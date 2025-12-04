
public class Player extends GameObject {
	
    private String name;
    private int health;

    public Player(String name, int x, int y, int health, Collidable collider) {
    	
        super(x, y, collider);

        if (name == null) name = "";
        name = name.trim();
        if (name.isEmpty())
            throw new IllegalArgumentException("Name cannot be empty");

        if (!Character.isUpperCase(name.charAt(0)))
            name = Character.toUpperCase(name.charAt(0)) + name.substring(1);

        if (health < 0 || health > 100)
            throw new IllegalArgumentException("Health must be 0–100");

        this.name = name;
        this.health = health;
    }

    public void decreaseHealth(int amount) {
        health = Math.max(0, health - amount);
    }

    public int getHealth() { 
    	return health; 
    	}
    
    @Override
    public String getDisplayName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player " + name + " (HP: " + health + ")";
    }
}
