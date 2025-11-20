
public class Motor extends Vozilo implements Ekonomican {

    public Motor(String id, double maxBrzina) {
        super(id, maxBrzina);
    }
	
	@Override
	public double potrosnjaPoKm() {
		// TODO Auto-generated method stub
		return 0.02;
	}

	@Override
	public double izracunajVrijemeDostave(double udaljenostKm) {
		// TODO Auto-generated method stub
		return udaljenostKm / maxBrzina;
	}

}
