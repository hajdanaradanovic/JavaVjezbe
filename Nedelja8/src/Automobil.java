//udjemo u superclass i stavimo umjesto object Vozilo
public class Automobil extends Vozilo {
	private int brojVrata;
	private int brojOsoba;
	public int getBrojVrata() {
		return brojVrata;
	}
	public void setBrojVrata(int brojVrata) {
		this.brojVrata = brojVrata;
	}
	public int getBrojOsoba() {
		return brojOsoba;
	}
	public void setBrojOsoba(int brojOsoba) {
		this.brojOsoba = brojOsoba;
	}
	
	//u source gore 
	public Automobil(String marka, String model, int kubikaza, int godine, int brojVrata, int brojOsoba) {
		super(marka, model, kubikaza, godine);
		this.setBrojVrata(brojVrata);
		this.setBrojOsoba(brojOsoba);
		
	}
	
	public Automobil() {
		this(null, null, 0, 0, 0, 0);
	}
	
	@Override
	public String toString() {
		return "'{'klasa': Automobil' ,  'marka: '" + getMarka() + "', \n 'model: " + getModel() + 
				",\n,kubikaza: " + getKubikaza() + "	'godiste: " + getGodine() +"}" + this.brojVrata +
				", brojOsoba=" + this.brojOsoba + "]";
	}
	
	@Override
	public float dajCijenuRegistracije() {
		return (this.getKubikaza()/(float)10.0 + (2025-this.getBrojOsoba())*10) * Vozilo.getOsnovicaZaRegistraciju();
	}
	
	
}
