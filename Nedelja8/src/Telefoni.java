import java.util.ArrayList;

public class Telefoni extends EProizvodi {
	
	private String operativniSistem;
	private double velicinaEkrana;
	public String getOperativniSistem() {
		return operativniSistem;
	}
	public void setOperativniSistem(String operativniSistem) {
		this.operativniSistem = operativniSistem;
	}
	public double getVelicinaEkrana() {
		return velicinaEkrana;
	}
	public void setVelicinaEkrana(double velicinaEkrana) {
		this.velicinaEkrana = velicinaEkrana;
	}
	public Telefoni(String opisProizvoda, String sifraProizvoda, double uvoznaCijenaProizvoda, String operativniSistem,
			double velicinaEkrana) {
		super(opisProizvoda, sifraProizvoda, uvoznaCijenaProizvoda);
		this.setOperativniSistem(operativniSistem);
		this.setVelicinaEkrana(velicinaEkrana);
	} 
	
	@Override
    public double izracunajMaloprodajnuCijenu() {
        double cijena = uvoznaCijenaProizvoda * 1.05;  //to je za sve istp
        if (velicinaEkrana > 6) {
            cijena *= 1.03; // dodatnih 3% ako je ekran veći od 6 inča
        }
        return cijena;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | OS: %s | Ekran: %.1f inča | Maloprodajna cijena: %.2f",
                operativniSistem, velicinaEkrana, izracunajMaloprodajnuCijenu());
    }
	
}
