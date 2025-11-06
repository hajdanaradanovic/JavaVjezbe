import java.util.ArrayList;
import java.util.Scanner;

public class EProizvodi {
	
	protected String opisProizvoda; 
	protected String sifraProizvoda; 
	protected double uvoznaCijenaProizvoda;
	
	
	public String getOpisProizvoda() {
		return opisProizvoda;
	}


	public void setOpisProizvoda(String opisProizvoda) {
		this.opisProizvoda = opisProizvoda;
	}


	public String getSifraProizvoda() {
		return sifraProizvoda;
	}


	public void setSifraProizvoda(String sifraProizvoda) {
		this.sifraProizvoda = sifraProizvoda;
	}


	public double getUvoznaCijenaProizvoda() {
		return uvoznaCijenaProizvoda;
	}


	public void setUvoznaCijenaProizvoda(double uvoznaCijenaProizvoda) {
		this.uvoznaCijenaProizvoda = uvoznaCijenaProizvoda;
	}


	public EProizvodi(String opisProizvoda, String sifraProizvoda, double uvoznaCijenaProizvoda) {
		this.setOpisProizvoda(opisProizvoda);;
		this.setSifraProizvoda(sifraProizvoda);;
		this.setUvoznaCijenaProizvoda(uvoznaCijenaProizvoda);;
	}
	
	public EProizvodi() {
		this("", "",0.0);
		
	}
	
	
    public String getTipUredjaja() {
        String prefiks = sifraProizvoda.substring(0, 2).toUpperCase();
        if(prefiks.startsWith("RA")) {
            return "Racunari";
        }
        else if(prefiks.startsWith("TE")){
        	return "Telefoni";
        }
        else if(prefiks.startsWith("TV"))
            return "TV";
        else return "null";
    }
	
	public double izracunajMaloprodajnuCijenu() {
		return uvoznaCijenaProizvoda * 1.05;
	}
	
    @Override
    public String toString() {
        return String.format("%s [%s] - Uvozna cijena: %.2f",
                opisProizvoda, sifraProizvoda, uvoznaCijenaProizvoda);
    }
    
    

    public static void stampajGrupuProizvoda(EProizvodi[] proizvodi, String tipUredjaja) {
        System.out.println("Lista proizvoda tipa: " + tipUredjaja + ":");
        
        for (EProizvodi p : proizvodi) {
            String tip = p.getTipUredjaja(); // dobija tip iz šifre (RA, TE, TV)
            if (tip.equals(tipUredjaja)) { 
                System.out.println(p);
            }
        }
    }




	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		ArrayList<EProizvodi> lista = new ArrayList<>();

		System.out.println("Unos uređaja (unesite 0 za kraj unosa):");

		while (true) {
		    System.out.print("Unesite tip uređaja (RA - Racunari, TE - Telefoni, TV - TV, 0 za kraj): ");
		    String tip = in.nextLine().toUpperCase();
		    if (tip.equals("0")) break;

		    System.out.print("Opis uređaja: ");
		    String opis = in.nextLine();
		    System.out.print("Šifra uređaja: ");
		    String sifra = in.nextLine();
		    System.out.print("Uvozna cijena: ");
		    double cijena = in.nextDouble();
		    in.nextLine(); 

		    if (tip.equals("RA")) {
		    	System.out.print("Procesor: ");
		        String proc = in.nextLine();
		        System.out.print("Memorija (GB): ");
		        double mem = in.nextDouble();
	            in.nextLine();
	            lista.add(new Racunari(opis, sifra, cijena, proc, mem));
	        } else if (tip.equals("TE")) {
	            System.out.print("Operativni sistem: ");
	            String os = in.nextLine();
	            System.out.print("Velicina ekrana (inča): ");
	            double ekran = in.nextDouble();
	            in.nextLine();
	            lista.add(new Telefoni(opis, sifra, cijena, os, ekran));
	        } else if (tip.equals("TV")) {
	            System.out.print("Velicina ekrana (inča): ");
	            double ekran = in.nextDouble();
	            in.nextLine();
	            lista.add(new TV(opis, sifra, cijena, ekran));
	        } else {
	            System.out.println("Nepoznat tip uređaja! Pokušajte ponovo.");
	        }
	    }

			// Prikaz svih uređaja
		System.out.println("Svi uređaji:");
		for (EProizvodi p : lista) {
		System.out.println(p);
		}

		// Pregled uređaja određenog tipa
		System.out.print("Unesite tip uređaja za pregled (Racunari, Telefoni, TV): ");
		String tipZaPregled = in.nextLine();

		System.out.println("Uređaji tipa " + tipZaPregled + ":");
		for (EProizvodi p : lista) {
		    if (p.getTipUredjaja().equalsIgnoreCase(tipZaPregled)) {
		        System.out.println(p);
		    }
		}
		    in.close();
	
	}

}
