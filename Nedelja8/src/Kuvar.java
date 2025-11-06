
public class Kuvar extends Zaposleni {
	
	 private static final double bonus = 1500;

	 public Kuvar(int iD, String ime, String prezime, double satnica, int brojSati) {
		super(iD, ime, prezime, satnica, brojSati);
	 }
	 
	 @Override
	 public double iznosPlate() {
	      return bonus + 4 * brojSati * satnica;
	  }	

}
