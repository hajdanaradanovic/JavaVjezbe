
public class MeleeEnemy extends Enemy {
	
    public MeleeEnemy(String type, int x, int y, Collidable collider, int damage, int health) {
        super(type, x, y, collider, damage, health);
    	}


    @Override
    public int getEffectiveDamage() {
        return super.getDamage() * 2;
    }

    @Override
    public String toString() {
        Collidable c = getCollider();
        String size = (c instanceof RectangleCollider) ? 
                      ((RectangleCollider) c).getWidth() + "x" + ((RectangleCollider) c).getHeight() : 
                      ((CircleCollider) c).getPoluprecnik() + " poluprecnik";
        return "BossEnemy[" + getType() + "] @ (" + getX() + "," + getY() + ") " + size + 
               " DMG=" + getDamage() + "x2 HP=" + getHealth();
    }
}
