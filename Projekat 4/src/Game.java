import java.util.ArrayList;

public class Game {
	
    private Player player;
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private ArrayList<String> eventLog = new ArrayList<>();

    public Game(Player player) {
        if (player == null) throw new IllegalArgumentException("Player ne može biti null.");
        this.player = player;
    }

    public void addEnemy(Enemy e) {
        if (e == null) throw new IllegalArgumentException("Enemy ne može biti null.");
        enemies.add(e);
        eventLog.add("Enemy: " + e.getDisplayName());
    }

    public ArrayList<Enemy> findByType(String query) {
        ArrayList<Enemy> result = new ArrayList<>();
        for (Enemy e : enemies) {
            if (e.getType().toLowerCase().contains(query.toLowerCase())) {
                result.add(e);
            }
        }
        return result;
    }

    public boolean checkCollision(Player p, Enemy e) {
        if (p == null || e == null) throw new IllegalArgumentException("Player ili Enemy ne može biti null.");
        return p.intersects(e);
    }

    public void decreaseHealth(Player p, Enemy e) {
        if (p == null || e == null) throw new IllegalArgumentException("Player ili Enemy ne može biti null.");
        int oldHP = p.getHealth();
        int damage = e.getEffectiveDamage();
        int newHP = Math.max(0, oldHP - damage);
        p.setHealth(newHP);
        eventLog.add("HIT: " + p.getName() + " by " + e.getDisplayName() + " for " + damage +" > HP " + oldHP + " > " + newHP);
    }

    public ArrayList<Enemy> collidingWithPlayer() {
        ArrayList<Enemy> result = new ArrayList<>();
        for (Enemy e : enemies) {
            if (checkCollision(player, e)) {
                result.add(e);
            }
        }
        return result;
    }

    public void resolveCollisions() {
        for (Enemy e : enemies) {
            if (checkCollision(player, e)) {
                decreaseHealth(player, e);
            }
        }
    }

    public ArrayList<String> getEventLog() { return eventLog; }

    public static Enemy parseEnemy(String linija) {
        try {
            String[] parts = linija.split(";");
            if (parts.length != 5) throw new IllegalArgumentException("Pogrešan format linije: " + linija);
            String type = parts[0].trim();
            String[] pos = parts[1].split(",");
            int x = Integer.parseInt(pos[0].trim());
            int y = Integer.parseInt(pos[1].trim());
            String[] size = parts[2].toLowerCase().split("x");
            int width = Integer.parseInt(size[0].trim());
            int height = Integer.parseInt(size[1].trim());
            int damage = Integer.parseInt(parts[3].trim());
            String enemyClass = parts[4].trim().toLowerCase();

            Collidable collider = new RectangleCollider(x, y, width, height);

            if (enemyClass.equals("boss")) {
                return new BossEnemy(type, x, y, collider, damage, 100);
            } else {
                return new MeleeEnemy(type, x, y, collider, damage, 100);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Nevalidan broj u liniji: " + linija, e);
        }
    }

}
