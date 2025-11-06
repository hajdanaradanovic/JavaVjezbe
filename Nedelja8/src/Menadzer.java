
public class Menadzer extends Zaposleni {
	
	 private double bonus;
	 private static final double osnovica = 1300; //to je pocetna fiksna vrijednost
	 public double getBonus() {
		 return bonus;
	 }
	 public void setBonus(double bonus) {
		 this.bonus = bonus;
	 }
	 public static double getOsnovica() {
		 return osnovica;
	 }
	 public Menadzer(int iD, String ime, String prezime, double satnica, int brojSati, double bonus) {
		super(iD, ime, prezime, satnica, brojSati);
		this.bonus = bonus;
	 }
	 
	 @Override
	 public double iznosPlate() {
		 return  osnovica + 4 * brojSati * satnica + bonus;
	 }

}
