
public class Enemy extends GameObject implements Attacker {

    protected String type;
    protected int damage;
    protected int health;

    public Enemy(String type, int x, int y, Collidable collider, int damage, int health) {
        super(x, y, collider);

        this.type = type;

        if (damage < 0 || damage > 100)
            throw new IllegalArgumentException("Damage invalid");

        if (health < 0 || health > 100)
            throw new IllegalArgumentException("Health invalid");

        this.damage = damage;
        this.health = health;
    }

    @Override
    public int getEffectiveDamage() {
        return damage;
    }

    @Override
    public String getDisplayName() {
        return type;
    }
}
