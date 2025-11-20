
public class RectangleCollider implements Collidable {
	
    private int x, y, width, height;

    public RectangleCollider(int x, int y, int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Širina i visina pravougaonika moraju biti veće od nule.");
        }
        this.setX(x);
        this.setY(y);
        this.setWidth(width);
        this.setHeight(height);
    }

    
    public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}


	@Override
    public boolean intersects(Collidable other) {
        if (other instanceof RectangleCollider) {
            RectangleCollider r = (RectangleCollider) other;
            return x < r.x + r.width && x + width > r.x &&
                   y < r.y + r.height && y + height > r.y;
        } else if (other instanceof CircleCollider) {
            return other.intersects(this); // delegiramo krugu
        }
        return false;
    }
}
