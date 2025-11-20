import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
/*      Vozilo bicikl = new Bicikl("B1", 20);
        Vozilo motor = new Motor("M1", 70);
        Vozilo auto = new Automobil("A1", 100);


        
        bicikl.info();
        System.out.println("Vrijeme dostave za 10 km: " + bicikl.izracunajVrijemeDostave(10) + " h");
        
        System.out.println();

        motor.info();
        System.out.println("Vrijeme dostave za 10 km: " + motor.izracunajVrijemeDostave(10) + " h");

        System.out.println();

        auto.info();
        System.out.println("Vrijeme dostave za 10 km: " + auto.izracunajVrijemeDostave(10) + " h");
        
        //za vozila koja su ekonomocni treba dodatno ispisati koliko je iznosila njihova ukupna potresnja 
        //na toj relaciji      
        if (bicikl instanceof Ekonomican) {
            Ekonomican e = (Ekonomican) bicikl;
            System.out.println("Potrosnja po km: " + e.potrosnjaPoKm());
        }

        System.out.println();
        //mogli smo ovako i za motor ili auto   */
		
        ArrayList<Vozilo> vozila = new ArrayList<>();
        vozila.add(new Bicikl("B1", 20));
        vozila.add(new Motor("M1", 70));
        vozila.add(new Automobil("A1", 100));

        double udaljenost = 10;

        System.out.println();
        
        for (Vozilo v : vozila) {
            v.info();
            double vrijeme = v.izracunajVrijemeDostave(udaljenost);
            System.out.printf("Vrijeme dostave: %.2f h%n", vrijeme);

            // Ako je ekonomično, ispisujemo i potrošnju
            if (v instanceof Ekonomican) {
                Ekonomican e = (Ekonomican) v;
                double potrosnja = e.potrosnjaPoKm() * udaljenost;
                System.out.printf("Potrošnja na %.1f km: %.2f jedinica%n", udaljenost, potrosnja);
            }
            System.out.println();
        }

        
        for (Vozilo v : vozila) {
            double vrijeme = v.izracunajVrijemeDostave(udaljenost);
            System.out.printf("%s - vrijeme: %.2f h", v.id, vrijeme);

            if (v instanceof Ekonomican) {
                Ekonomican e = (Ekonomican) v;
                double potrosnja = e.potrosnjaPoKm() * udaljenost;
                System.out.printf(", potrošnja: %.2f jedinica", potrosnja);
            }
            System.out.println();
        }

	}

}
