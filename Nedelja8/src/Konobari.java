
public class Konobari extends Zaposleni {
	
	private int prekovremeniSati;

	
	public int getPrekovremeniSati() {
		return prekovremeniSati;
	}


	public void setPrekovremeniSati(int prekovremeniSati) {
		this.prekovremeniSati = prekovremeniSati;
	}


	public Konobari(int iD, String ime, String prezime, double satnica, int brojSati, int prekovremeniSati) {
		super(iD, ime, prezime, satnica, brojSati);
		this.prekovremeniSati = prekovremeniSati;
	}


    @Override
    public double iznosPlate() {
        double redovni =  brojSati*  satnica;
        double prekovremeni = prekovremeniSati * satnica * 1.2;
        return 4 * (redovni + prekovremeni);
    }
}
