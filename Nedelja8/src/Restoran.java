import java.util.ArrayList;

public class Restoran {
	
	private String naziv; 
	private String adresa;
	private int PIB; 
	private ArrayList<Zaposleni> zaposleni;
	

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public int getPIB() {
		return PIB;
	}

	public void setPIB(int pIB) {
		PIB = pIB;
	}
	
	public ArrayList<Zaposleni> getZaposleni() {
		return zaposleni;
	}

	public void setZaposleni(ArrayList<Zaposleni> zaposleni) {
		this.zaposleni = zaposleni;
	}

	

	public Restoran(String naziv, String adresa, int pIB, ArrayList<Zaposleni> zaposleni) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		PIB = pIB;
		this.zaposleni = zaposleni;
	}

	
	public Restoran() {
	this("", "", 0, null);
	}
	
    public void dodajZaposlenog(Zaposleni z) {
        zaposleni.add(z);
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}
}
