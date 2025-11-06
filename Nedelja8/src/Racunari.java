//apstraksija iznad programskog jezika, za javu spring boot

import java.util.ArrayList;

public class Racunari extends EProizvodi {

	private String procesor;
	private double memorija;
	public String getProcesor() {
		return procesor;
	}
	public void setProcesor(String procesor) {
		this.procesor = procesor;
	}
	public double getMemorija() {
		return memorija;
	}
	public void setMemorija(double memorija) {
		this.memorija = memorija;
	}
	public Racunari(String opisProizvoda, String sifraProizvoda, double uvoznaCijenaProizvoda, String procesor,
			double memorija) {
		super(opisProizvoda, sifraProizvoda, uvoznaCijenaProizvoda);
		this.setProcesor(procesor);
		this.setMemorija(memorija);
	} 
	

	@Override
    public double izracunajMaloprodajnuCijenu() {
        double cijena = uvoznaCijenaProizvoda * 1.05; // osnovno povećanje 5%
        cijena *= 1.05; // dodatnih 5% za računare
        return cijena;
    }

	@Override
    public String toString() {
        return super.toString() + String.format(" | Procesor: %s | Memorija: %dGB | Maloprodajna cijena: %.2f",
                procesor, memorija, izracunajMaloprodajnuCijenu());
    }
}

