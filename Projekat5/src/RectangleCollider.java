
public class RectangleCollider implements Collidable {
	
	private int x, y, width, height;

    public RectangleCollider(int x, int y, int width, int height) {
        if (width <= 0 || height <= 0)
            throw new IllegalArgumentException("Width and height must be > 0");

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public boolean intersects(Collidable other) {
        if (other instanceof RectangleCollider rc) {
            return !(rc.x > x + width ||
                     rc.x + rc.width < x ||
                     rc.y > y + height ||
                     rc.y + rc.height < y);
        }

        // Ako je drugi krug → prebacimo logiku na krug
        if (other instanceof CircleCollider cc) {
            return cc.intersects(this); 
        }

        return false;
    }

}
