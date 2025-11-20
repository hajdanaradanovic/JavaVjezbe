import java.util.Scanner;

public class UnosCijeneProzivoda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
        Scanner u = new Scanner(System.in);
        double cijena = 0;
        boolean validanUnos = false;

        while (!validanUnos) {
            System.out.print("Unesite cijenu proizvoda: ");
            String unos = u.nextLine();

            //try - koristimo jer postoji mogucnost da se dogodi izuzetak
            try {
                cijena = Double.parseDouble(unos);

                // Ako je cijena ≤ 0, bacamo IllegalArgumentException
                if (cijena <= 0) {
                    throw new IllegalArgumentException("Cijena mora biti veca od nule.");
                }

                validanUnos = true;

            } catch (NumberFormatException e) {
                System.out.println("Greska, unesite broj");
            } catch (IllegalArgumentException e) {
                System.out.println("Greska ");
            }
        }

        System.out.println("Cijena proizvoda je uspjesno unesena: " + cijena);
        u.close();

	}

}
