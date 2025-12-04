import java.util.*;
import java.io.*;

public class Game {
    private Player player;
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private ArrayList<String> log = new ArrayList<>();
    
    

    public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setEnemies(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}

	public void setLog(ArrayList<String> log) {
		this.log = log;
	}

	public Game(Player player) {
        this.player = player;
    }

    public void addEnemy(Enemy e) {
        enemies.add(e);
        log.add("Enemy added: " + e.getDisplayName());
    }

    public boolean checkCollision(Player p, Enemy e) {
        return p.intersects(e);
    }

    public void decreaseHealth(Player p, Enemy e) {
        int before = p.getHealth();
        p.decreaseHealth(e.getEffectiveDamage());
        log.add("Collision with " + e.getDisplayName() +
                " → HP: " + before + " → " + p.getHealth());
    }

    public List<Enemy> collidingWithPlayer() {
        ArrayList<Enemy> list = new ArrayList<>();
        for (Enemy e : enemies) {
            if (checkCollision(player, e))
                list.add(e);
        }
        return list;
    }

    public void resolveCollisions() {
        for (Enemy e : enemies) {
            if (checkCollision(player, e)) {
                decreaseHealth(player, e);
            }
        }
    }

    public List<String> getLog() { return log; }
    public List<Enemy> getEnemies() { return enemies; }

    public static ArrayList<Enemy> loadEnemiesFromCSV(String filePath) throws Exception {
        ArrayList<Enemy> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");

            if (parts.length < 8)
                throw new IllegalArgumentException("Invalid CSV row: " + line);

            String type = parts[0].trim();
            String cls  = parts[1].trim();  // melee/boss
            int x = Integer.parseInt(parts[2]);
            int y = Integer.parseInt(parts[3]);

            String colliderType = parts[4].trim();

            Collidable col;

            if (colliderType.equalsIgnoreCase("rect")) {
                int w = Integer.parseInt(parts[5]);
                int h = Integer.parseInt(parts[6]);
                col = new RectangleCollider(x, y, w, h);
            } else {
                int r = Integer.parseInt(parts[5]);
                col = new CircleCollider(x, y, r);
            }

            int damage = Integer.parseInt(parts[parts.length - 2]);
            int health = Integer.parseInt(parts[parts.length - 1]);

            Enemy e = cls.equals("boss") ?
                      new BossEnemy(type, x, y, col, damage, health) :
                      new MeleeEnemy(type, x, y, col, damage, health);

            list.add(e);
        }

        br.close();
        return list;
    }
}