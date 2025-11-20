
public class Automobil extends Vozilo {

    public Automobil(String id, double maxBrzina) {
        super(id, maxBrzina);
    }
	

	@Override
	public double izracunajVrijemeDostave(double udaljenostKm) {
		// TODO Auto-generated method stub
		return udaljenostKm / maxBrzina;
	}

}
