
public class CircleCollider implements Collidable {

    private int cx, cy, radius;

    public CircleCollider(int cx, int cy, int radius) {
        if (radius <= 0)
            throw new IllegalArgumentException("Radius must be > 0");

        this.cx = cx;
        this.cy = cy;
        this.radius = radius;
    }

    public boolean intersects(Collidable other) {
        if (other instanceof CircleCollider c) {
            int dx = cx - c.cx;
            int dy = cy - c.cy;
            int distanceSq = dx*dx + dy*dy;
            int r = radius + c.radius;
            return distanceSq <= r*r;
        }

        if (other instanceof RectangleCollider r) {
            int closestX = clamp(cx, r.getX(), r.getX() + 32);
            int closestY = clamp(cy, r.getY(), r.getY() + 32);

            int dx = cx - closestX;
            int dy = cy - closestY;
            return dx*dx + dy*dy <= radius * radius;
        }

        return false;
    }

    private int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }
}
