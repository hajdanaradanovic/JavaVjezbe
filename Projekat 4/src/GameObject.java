
public abstract class GameObject {
    private int x, y;
    private Collidable collider;

    public GameObject(int x, int y, Collidable collider) {
        if (collider == null) throw new IllegalArgumentException("Collider ne može biti null.");
        this.setX(x);
        this.setY(y);
        this.setCollider(collider);
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    public Collidable getCollider() { return collider; }
    
    
    public void setCollider(Collidable collider) {
    	//metoda baca izuzetak IllegalArgumentException.
    	//throw - prekida izvršavanje metode i signalizira grešku
        if (collider == null) throw new IllegalArgumentException("Collider ne može biti null.");
        this.collider = collider;
    }

    //provjerava da li se dva objekta sudaraju
    public boolean intersects(GameObject other) {
        return this.collider.intersects(other.getCollider());
    }

    //data kao jedna apstraktna klasa u zadatku
    public abstract String getDisplayName();

    @Override
    public String toString() {
        return "GameObject @ (" + x + "," + y + ")";
    }
}
