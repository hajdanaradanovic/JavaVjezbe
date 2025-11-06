
public class Zaposleni {

	protected int ID;
	protected String ime;
	protected String prezime;
	protected double satnica; //plata po satu , pomijesala naziv
	protected int brojSati; //ukupan broj sati 
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public double getSatnica() {
		return satnica;
	}
	public void setSatnica(double satnica) {
		this.satnica = satnica;
	}
	public int getBrojSati() {
		return brojSati;
	}
	public void setBrojSati(int brojSati) {
		this.brojSati = brojSati;
	}
	
	public Zaposleni(int iD, String ime, String prezime, double satnica, int brojSati) {
		this.ID = iD;
		this.ime = ime;
		this.prezime = prezime;
		this.satnica = satnica;
		this.brojSati = brojSati;
	}
	
	
	public Zaposleni() {
		this(0, "", "", 0, 0);
	}
	
	public double iznosPlate() {
		double plata = 0;
		plata = brojSati* satnica; 
		return plata;
	}

	
}
