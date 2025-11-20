
public class Enemy extends GameObject implements Attacker {
	
    private String type;
    private int damage; // 0-100
    private int health; // 0-100
    
    public Enemy(String type, int x, int y, Collidable collider, int damage, int health) {
        super(x, y, collider);
        this.setType(type);
        this.setDamage(damage);
        this.setHealth(health);
    }
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		
        if (type == null) throw new IllegalArgumentException("Type ne može biti null.");
        type = type.trim();
        if (type.isEmpty()) throw new IllegalArgumentException("Type ne može biti prazan.");
        this.type = type;
        
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		   if (damage < 0 || damage > 100) throw new IllegalArgumentException("Damage mora biti 0-100.");
	       this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
        if (health < 0 || health > 100) throw new IllegalArgumentException("Health mora biti 0-100.");
        this.health = health;
	}

	@Override
	public int getEffectiveDamage() {
		// TODO Auto-generated method stub
		return damage;
	}

	@Override
	public String getDisplayName() {
		// TODO Auto-generated method stub
		return type;
	}
	
	@Override
	public String toString() {
	    Collidable c = getCollider();
	    String size = (c instanceof RectangleCollider) ? 
	                  ((RectangleCollider) c).getWidth() + "x" + ((RectangleCollider) c).getHeight() : 
	                  ((CircleCollider) c).getPoluprecnik() + " poluprecnik";
	    return "Enemy(" + type + ") @ (" + getX() + "," + getY() + ") " + size + 
	           " DMG=" + damage + " HP=" + health;
	}

}
