//Vozilo tipa Kamion, to je u memoriji tako
public class Kamion extends Vozilo {
	private int nosivost;

	public int getNosivost() {
		return nosivost;
	}

	public void setNosivost(int nosivost) {
		this.nosivost = nosivost;
	}

	//uvijek setere stavljamo u konstruktor
	public Kamion(String marka, String model, int kubikaza, int godine, int nosivost) {
		super(marka, model, kubikaza, godine);
		this.setNosivost(nosivost);;
	}
	
	
	public Kamion() {
		this(null, null, 0 , 0 , 0);
	}
	
	@Override
	public String toString() {
		return "'{'klasa': Kamion' ,  'marka: '" + getMarka() + "', \n 'model: " + getModel() + 
				",\n,kubikaza: " + getKubikaza() + "\n'godiste: '" + getGodine() +"\nkolometraza ':" +",\nnosivost: "
				+ this.getNosivost()+ "}";
	}
	
	@Override
	public float dajCijenuRegistracije() {
		return(this.getKubikaza()/(float)10.0 + (2025- this.getGodine() * 10)) * Vozilo.osnovicaZaRegistraciju
				+ 30 * this.getNosivost();
	}
}
