
public class CircleCollider implements Collidable {
	
    private int centerX, centerY, poluprecnik;

    public CircleCollider(int centerX, int centerY, int poluprecnik) {
        if (poluprecnik <= 0) {
            throw new IllegalArgumentException("Poluprečnik kruga mora biti veći od nule.");
        }
        this.setCenterX(centerX);
        this.setCenterY(centerY);
        this.setPoluprecnik(poluprecnik);
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

	public int getPoluprecnik() {
		return poluprecnik;
	}

	public void setPoluprecnik(int poluprecnik) {
		this.poluprecnik = poluprecnik;
	}

	@Override
    public boolean intersects(Collidable other) {
		
        if (other instanceof CircleCollider) {
            CircleCollider c = (CircleCollider) other;
            
            //provjeravamo horizontalno i vertikalno rastojanje izmedju centra dva kruga
            int dx = centerX - c.centerX;
            int dy = centerY - c.centerY;
            
            //izracunace kvadrat rastojanja
            int distanca = dx * dx + dy * dy;
            //izracunace zbir poluprečnika
            //Ako je centar kruga (x0, y0) i poluprecnik r, onda sve tačke (x, y) na kružnici zadovoljavaju
            //(x - x0)² + (y - y0)² = r²
            int poluprecnikSum = poluprecnik + c.poluprecnik;
    //Ako je rastojanje između centara manje ili jednako zbiru poluprecnika ⇒ krugovi se dodiruju ili preklapaju.
            return distanca <= poluprecnikSum * poluprecnikSum;
            
            
         //Da provjeri da li se krug sudara sa pravougaonikom. 
        } else if (other instanceof RectangleCollider) {
            RectangleCollider r = (RectangleCollider) other;
            
            //Naci cemo najbližu X koordinatu pravougaonika centru kruga
            int najblizaX = clamp(centerX, r.getX(), r.getX() + r.getWidth());
            //Isto samo za Y
            int najblizaY = clamp(centerY, r.getY(), r.getY() + r.getHeight());
            
            //Izračunaj horizontalnu i vertikalnu udaljenost od centra kruga
            int dx = centerX - najblizaX;
            int dy = centerY - najblizaY;
            
            //Provjeri da li je rastojanje ≤ poluprenik kruga
            return dx * dx + dy * dy <= poluprecnik * poluprecnik;
            
        }
        return false;
    }

    private int clamp(int val, int min, int max) {
        return Math.max(min, Math.min(max, val));
    }

}
