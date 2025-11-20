
public class CircleCollider implements Collidable {
    private int centerX, centerY, radius;

    public CircleCollider(int centerX, int centerY, int radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Poluprečnik kruga mora biti veći od nule.");
        }
        this.setCenterX(centerX);
        this.setCenterY(centerY);
        this.setRadius(radius);
    }
    
    public int getCenterX() {
		return centerX;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}


	@Override
    public boolean intersects(Collidable other) {
		
        if (other instanceof CircleCollider) {
            CircleCollider c = (CircleCollider) other;
            
            //provjeravamo horizontalno i vertikalno rastojanje izmedju centra dva kruga
            int dx = centerX - c.centerX;
            int dy = centerY - c.centerY;
            
            //izracunace kvadrat rastojanja
            int distanceSq = dx * dx + dy * dy;
            //izracunace zbir poluprečnika
            //Ako je centar kruga (x0, y0) i radijus r, onda sve tačke (x, y) na kružnici zadovoljavaju
            //(x - x0)² + (y - y0)² = r²
            int radiusSum = radius + c.radius;
      //Ako je rastojanje između centara manje ili jednako zbiru radijusa ⇒ krugovi se dodiruju ili preklapaju.
            return distanceSq <= radiusSum * radiusSum;
            
            
         //Da provjeri da li se krug sudara sa pravougaonikom. 
        } else if (other instanceof RectangleCollider) {
            RectangleCollider r = (RectangleCollider) other;
            
            //Nađi najbližu X koordinatu pravougaonika centru kruga
            int closestX = clamp(centerX, r.getX(), r.getX() + r.getWidth());
            //Isto samo za Y
            int closestY = clamp(centerY, r.getY(), r.getY() + r.getHeight());
            
            //Izračunaj horizontalnu i vertikalnu udaljenost od centra kruga
            int dx = centerX - closestX;
            int dy = centerY - closestY;
            
            //Provjeri da li je rastojanje ≤ radijus kruga
            return dx * dx + dy * dy <= radius * radius;
            
        }
        return false;
    }

	/*Clamp ograničava broj da uvijek bude u datim granicama.
	Ako pređe minimum → vraća minimum.
	Ako pređe maksimum → vraća maksimum.
	Ako je između → ostavlja ga.  */
    private int clamp(int val, int min, int max) {
        return Math.max(min, Math.min(max, val));
    }

}
