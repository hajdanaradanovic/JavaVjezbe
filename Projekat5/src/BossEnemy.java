
public class BossEnemy extends Enemy {
	
    public BossEnemy(String type, int x, int y, Collidable c, int damage, int health) {
        super(type, x, y, c, damage, health);
    }

    @Override
    public int getEffectiveDamage() {
        return damage * 2;
    }

    @Override
    public String toString() {
        return "BOSS " + type + " (DMG: " + damage + ", HP: " + health + ")";
    }

}
