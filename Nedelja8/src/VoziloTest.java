import java.util.ArrayList;

public class VoziloTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vozilo.setOsnovicaZaRegistraciju(100);
//		Vozilo vv = new Vozilo(); - vidji zasto ti javlja gresku
		
		ArrayList <Vozilo> niz = new ArrayList();
		
		
		niz.add(new Automobil("Audi","SQ8",4000,2023,5, 5));
		niz.add(new Automobil("BMW","M5",3000,2022,5, 5));
		niz.add(new Motocikl("KTM", "1002", 800, 2024, 1000));
		niz.add(new Kamion("SCANIA", "???", 5000, 2000, 10));
		
		System.out.println("Sadrzaj voznog parka: ");
		for(Vozilo v: niz) {
			System.out.println(v.toString());  //implicitno poziva metodu toStirng
		}
		
		float ukupnaCijenaRegistracije = 0;
		
		
		for(Vozilo v : niz)
			ukupnaCijenaRegistracije += v.dajCijenuRegistracije();
		
		System.out.println("Ukupno za registraciju: " + ukupnaCijenaRegistracije);
	}

}
