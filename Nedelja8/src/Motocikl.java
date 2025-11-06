
public class Motocikl extends Vozilo {
	private int kilometraza;

	public int getKilometraza() {
		return kilometraza;
	}

	public void setKilometraza(int kilometraza) {
		this.kilometraza = kilometraza;
	}

	public Motocikl(String marka, String model, int kubikaza, int godine, int kilometraza) {
		super(marka, model, kubikaza, godine);
		this.setKilometraza(kilometraza);
	}
	
	public Motocikl() {
		this(null, null, 0, 0 , 0);
	}

	@Override
	public String toString() {
		return "'{'klasa': Automobil' ,  'marka: '" + getMarka() + "', \n 'model: " + getModel() + 
				",\n,kubikaza: " + getKubikaza() + "\n'godiste: '" + getGodine() +"\nkolometraza ': "+ this.getKilometraza()+"}"
			;
	}
	
	@Override
	public float dajCijenuRegistracije() {  //pogledaj ovo kako je bilo na ono sto je on okacio
		return 0; 
	}
	
}
