//klasa object  
public abstract class Vozilo {

	//atributi
	protected String marka;
	protected String model;
	protected int kubikaza; 
	protected int godine; 
	protected static float osnovicaZaRegistraciju; //staticka promjenjiva koja definise koeficient na osnovu 
	//koje se registruje vozilo
	
	

	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getKubikaza() {
		return kubikaza;
	}
	public void setKubikaza(int kubikaza) {
		this.kubikaza = kubikaza;
	}
	public int getGodine() {
		return godine;
	}
	public void setGodine(int godine) {
		this.godine = godine;
	}
	public static float getOsnovicaZaRegistraciju() {
		return osnovicaZaRegistraciju;
	}
	public static void setOsnovicaZaRegistraciju(float osnovicaZaRegistraciju) {
		Vozilo.osnovicaZaRegistraciju = osnovicaZaRegistraciju;
	}
	
	public Vozilo(String marka, String model, int kubikaza, int godine) {
		super();
		this.setMarka(marka);
		this.setModel(model);
		this.setKubikaza(kubikaza);
		this.setGodine(godine);
	}
	
	public Vozilo() {
		this(null, null,0, 0);
	}
	
	
	//udjemo u metods
	@Override // - provjeri potpis klase iznad, java ispravlja greske umjesto nas, on provjerava
	public String toString() {
		return "{\n 'klasa': Vozilo,\n 'marka: '" + getMarka() + "', \n 'model: " + getModel() + " \n,kubikaza:" + getKubikaza()
				+ ",\n'godiste:\n " + getGodine() + "\n}";
	}

	//apstraktna metoda - ona nema svoju realizaciju i ocekuj njenu definisanost kasnije
	public abstract float dajCijenuRegistracije() ;


	
}
