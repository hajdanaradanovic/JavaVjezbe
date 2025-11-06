
public class TV extends EProizvodi {
	private double velicinaEkrana;

	public double getVelicinaEkrana() {
		return velicinaEkrana;
	}

	public void setVelicinaEkrana(double velicinaEkrana) {
		this.velicinaEkrana = velicinaEkrana;
	}

	public TV(String opisProizvoda, String sifraProizvoda, double uvoznaCijenaProizvoda, double velicinaEkrana) {
		super(opisProizvoda, sifraProizvoda, uvoznaCijenaProizvoda);
		this.velicinaEkrana = velicinaEkrana;
	}
	
	@Override
    public double izracunajMaloprodajnuCijenu() {
        double cijena = uvoznaCijenaProizvoda * 1.05;
        if (velicinaEkrana > 65) {
            cijena *= 1.10; // dodatnih 10%
        }
        return cijena;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Ekran: %.1f inča | Maloprodajna cijena: %.2f",
                velicinaEkrana, izracunajMaloprodajnuCijenu());
    }
}


