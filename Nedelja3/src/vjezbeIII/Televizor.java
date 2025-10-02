package vjezbeIII;

public class Televizor {
	
	private int brojKanala;
	private String nazivKanala; 
	private int jacinaTona;

	public Televizor(int brojKanala, String nazivKanala, int jacinaTona) {
		setBrojKanala(brojKanala);
        setNazivKanala(nazivKanala);
        setJacinaTona(jacinaTona);
	}

	public int getBrojKanala() {
		return brojKanala;
	}




	public void setBrojKanala(int brojKanala) {
		if(brojKanala >= 1) {
			this.brojKanala = brojKanala;
		} else {
			this.brojKanala = 1; 
		}
	}




	public String getNazivKanala() {
		return nazivKanala;
	}




	public void setNazivKanala(String nazivKanala) {
		this.nazivKanala = nazivKanala;
	}




	public int getJacinaTona() {
		return jacinaTona;
	}




	public void setJacinaTona(int jacinaTona) {
		if(jacinaTona < 0) {
			this.jacinaTona = 0;
		} else if(jacinaTona > 10) {
			this.jacinaTona = 10;
		} else {
			this.jacinaTona = jacinaTona;
		}
	}

	public void pojacajTon(){
		if(jacinaTona < 10) {
			jacinaTona ++;
		} else {
			System.out.print("Pojacano je na maksimum");		
			}
	}
	
	public void ispisi() {
		System.out.println("Broj kanala je "+ brojKanala+ ", naziv kanala je "+ nazivKanala + " trenutna jacina tona je "+ jacinaTona);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Televizor t1 = new Televizor(100, "HBO", 11);
		t1.pojacajTon();
		t1.ispisi();
		
	}

}
