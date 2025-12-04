
public abstract class GameObject {
    private int x, y;
    private Collidable collider;

    public GameObject(int x, int y, Collidable collider) {
        this.x = x;
        this.y = y;
        if (collider == null)
            throw new IllegalArgumentException("Collider cannot be null");

        this.collider = collider;
    }

    public int getX() { 
    	return x;
    }
    public int getY() { 
    	return y; 
    }
    public Collidable getCollider() { 
    	return collider;
    }

    public abstract String getDisplayName();

    public boolean intersects(GameObject other) {
        return collider.intersects(other.collider);
    }

    @Override
    public String toString() {
        return getDisplayName() + " at (" + x + "," + y + ")";
    }

}
