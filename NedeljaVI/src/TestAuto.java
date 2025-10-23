//this pokazivac
import java.util.ArrayList;
class Auto {
	private String markaAuta;
	private int godisteAuta;
	private float snagaMotora;
	private boolean prodato;
	private float kubikaza;
	private boolean registrovan;
	private static int brojProdatih = 0;  //on se veze za klasu, ne za instancu
	
	public Auto(String markaAuta, int godisteAuta, float snagaMotora, boolean prodato, float kubikaza,
			boolean registrovan) {
		this.markaAuta = markaAuta;
		this.godisteAuta = godisteAuta;
		this.snagaMotora = snagaMotora;
		this.prodato = prodato;
		this.kubikaza = kubikaza;
		this.registrovan = registrovan;
		if (prodato) brojProdatih ++;
		this.registrovan = godisteAuta < 1985 ? false : registrovan;  //zapis drugaciji za if
	}
	//ako se kaze da imamo difoltne vrijednosti
	/*public Auto() {
		this.markaAuta = " ";
		
	}
	
} */  // u seterima se radi validacija da li je to valdino uopste
	public String getMarkaAuta() {return markaAuta;}

	public void setMarkaAuta(String markaAuta) {this.markaAuta = markaAuta;}

	public int getGodisteAuta() {return godisteAuta;}

	public void setGodisteAuta(int godisteAuta) {
		if(godisteAuta >= 2025) {
			System.out.print("Jos nismo stigli do te godine");
			return;  //samo izbaci iz programa
		}
		this.godisteAuta = godisteAuta;
		if(godisteAuta < 1985) this.registrovan = false;
	}

	public float getSnagaMotora() {return snagaMotora;}

	public void setSnagaMotora(float snagaMotora) {this.snagaMotora = snagaMotora;}

	public boolean jeProdato() {return prodato;}

	public void setProdato(boolean prodato) {
		if(this.prodato != prodato && prodato) brojProdatih ++; //vec je bilo prodato u konstruktoru
		this.prodato = prodato;     
	}

	public float getKubikazaMotora() {return this.kubikaza;}

	public void setKubikazaMotora(float kubikaza) {
		this.kubikaza = kubikaza;	
	}

	public boolean jeRegistrovan() {return registrovan;}


	public void setRegistrovan(boolean registrovan) {
		if(this.godisteAuta >= 1985) this.registrovan = registrovan;
	}


	public static int BrojProdatih() {  //primijenili ime geteru
		return brojProdatih;  //static nema jer se ne veze ni za jednu instancu
	}


	public static void setBrojProdatih(int brojProdatih) {
		Auto.brojProdatih = brojProdatih;
	}
	
	public boolean mozeSeRegistrovati() {
		return godisteAuta >= 1985;
	}
	
	public static double koeficijentZaGodiste(int godiste) {
		if(godiste < 1985) return 0.0;
		if(godiste <= 2000) return 3.0;
		if(godiste <= 2010) return 2.0;
		
		return 1.5;
	}
	
	public double cijenaRegistracije() {
		if(!mozeSeRegistrovati()) return 0.0; //moglo je i this da se stavi,a li se podrazumijeva da se poziva
		return koeficijentZaGodiste(godisteAuta) * kubikaza * snagaMotora; //nad instancom
	}

	
	@Override 
	public String toString() { //=%s - kazemo koji tip podatka se ocekuje


return String.format("Auto [marka=%s, godiste=%d, snaga=%.1f, " +
				"kubikaza=%.1f, registrovan=%s, prodato=%s, cijenaReg=%.2f]"
				, markaAuta, godisteAuta, snagaMotora, kubikaza, 
				registrovan ? "da" : "ne", 
				prodato ? "da" : "ne", cijenaRegistracije());
	}
}

//sad radimo sa listom auta, zato pravimo novu klasu 
class AutoServis {
	public static ArrayList <Auto> neregistrovaniKojiSeMoguRegistrovati(ArrayList<Auto>auta){
		ArrayList <Auto> lista = new ArrayList<>();
		for(Auto a: auta) {
			if(a.mozeSeRegistrovati()&& !a.jeRegistrovan()) {
				lista.add(a);
			}
		}
		return lista;
	}
	
	public static double ukupnaRegistracija(ArrayList<Auto> auta) {
		double suma = 0;
		for(Auto a:auta) {
			suma += a.cijenaRegistracije();
		}
		return suma;
	}
}

public class TestAuto {   
//ovdje je samo jedna testna klasa
	
	public static void main(String[] args) {
		//pravimo array listu dje pravimo vise objekata
		
		ArrayList<Auto> auta = new ArrayList<>();
		Auto a1 = new Auto("VW Golf 3", 1995, 55, true, 1600, false);
		auta.add(a1);
		auta.add(new Auto("BMW 320d", 2020, 140, true, 1995, true));
		for(Auto a: AutoServis.neregistrovaniKojiSeMoguRegistrovati(auta)) {
			System.out.println(a);
		}
		System.out.print(auta.get(0)); //ovako pristupamo prvom elementu liste
	}
	
}

