package vjezbeIII;

public class Zaposleni {
	
	private String ime;
	private String prezime;
	private int godine_staza;
	private double plata; 

	public Zaposleni(String ime, String prezime, int godine_staza, double plata) {
		this.ime = ime;
		this.prezime = prezime;
		this.godine_staza = godine_staza;
		this.plata = plata;
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

	public int getGodine_staza() {
		return godine_staza;
	}

	public void setGodine_staza(int godine_staza) {
		this.godine_staza = godine_staza;
	}

	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}

	public void uvecanjePlate() {
		if(plata < 800 && godine_staza >= 10) {
			plata += plata * 0.06;
		} 
	}
	
	public void ispis() {
		System.out.println("Ime i prezime zaposlenog je "+ ime +" "+ prezime +", a godine staza su "+ godine_staza + " plata "+ plata); 
	}
	
	public static void najvecaPlata(Zaposleni[]niz) {
		double max = 0; 
		for(int i = 0; i < niz.length; i ++) {
			if(max < niz[i].getPlata()) {
				max = niz[i].getPlata(); 
			}
		}
		for(int i = 0; i < niz.length; i ++) {
			if(niz[i].getPlata() == max) {
				System.out.println("Ima osobe koja ima najvecu platu je "+ niz[i].getIme()); 
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Zaposleni z1 = new Zaposleni("Hajdana", "Radanovic", 10, 10000.23);
		Zaposleni z2 = new Zaposleni("Elena", "Bozaric", 7, 900.16);
		Zaposleni z3 = new Zaposleni("Marko", "Markonovic", 2, 900.23);
		Zaposleni z4 = new Zaposleni("Nada", "Nadic",11, 720.23);
		Zaposleni z5 = new Zaposleni("Luka", "Lukic", 6, 890.23);
		
		Zaposleni[] niz = { z1, z2, z3, z4, z5 };
		
		z4.uvecanjePlate();
		z4.ispis();
		najvecaPlata(niz);

	}

}
