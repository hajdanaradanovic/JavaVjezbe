
public class Bicikl extends Vozilo implements Ekonomican {
	
	public Bicikl(String id, double maxBrzina) {
		super(id, maxBrzina);
	}

	@Override
	public double potrosnjaPoKm() {
		// TODO Auto-generated method stub
		return 0.05;
	}

	@Override
	public double izracunajVrijemeDostave(double udaljenostKm) {
		// TODO Auto-generated method stub
		 return udaljenostKm / maxBrzina; // u satima
	}

}
