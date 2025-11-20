
public class Player extends GameObject {
	
	private String name;
    private int health; // 0-100

	public Player(int x, int y, Collidable collider, String name, int health) {
		super(x, y, collider);
		this.setName(name);
		this.setHealth(health); 
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
        if (name == null) throw new IllegalArgumentException("Ime ne može biti null");
        name = name.trim().replaceAll("\\s+", " "); 
        String[] rijeci = name.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String w : rijeci) {
            if (!w.isEmpty()) {
                sb.append(Character.toUpperCase(w.charAt(0))).append(w.substring(1).toLowerCase()).append(" ");
            }
        }
        this.name = sb.toString().trim();
        if (this.name.isEmpty()) {
            throw new IllegalArgumentException("Ime ne može biti prazno nakon obrade.");
        }
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
        if (health < 0 || health > 100) {
            throw new IllegalArgumentException("Health mora biti između 0 i 100.");
        }
        this.health = health;
	}


	@Override
	public String getDisplayName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
	    return "Player(" + name + ") @ (" + getX() + "," + getY() + ") 32x32 HP=" + health;
	}

}
