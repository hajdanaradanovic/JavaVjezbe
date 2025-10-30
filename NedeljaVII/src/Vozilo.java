
public class Vozilo {
	
    protected String proizvodjac;
    protected int godinaProizvodnje;
    protected int kubikaza;
    protected String boja;
	
	
	public Vozilo(String proizvodjac, int godinaProizvodnje, int kubikaza, String boja) {
		super();
		this.proizvodjac = proizvodjac;
		this.godinaProizvodnje = godinaProizvodnje;
		this.kubikaza = kubikaza;
		this.boja = boja;
	}
	
	public String getProizvodjac() {
		return proizvodjac;
	}
	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
	}
	public int getGodinaProizvodnje() {
		return godinaProizvodnje;
	}
	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}
	public int getKubikaza() {
		return kubikaza;
	}
	public void setKubikaza(int kubikaza) {
		this.kubikaza = kubikaza;
	}
	public String getBoja() {
		return boja;
	}
	public void setBoja(String boja) {
		this.boja = boja;
	}
	
    public double cijenaRegistracije() {
        double cijena = 100;

        if (godinaProizvodnje < 2010)
            cijena += 30;

        if (kubikaza > 2000)
            cijena += 50;

        return cijena;
    }
    
@Override
	public String toString() {
		return "Vozilo [proizvodjac=" + proizvodjac + ", godinaProizvodnje=" + godinaProizvodnje + ", kubikaza="
				+ kubikaza + ", boja=" + boja + "]";
	}



static class Automobil extends Vozilo {  
	private int brojVrata;          
	private String tipMotora;

    public Automobil(String proizvodjac, int godinaProizvodnje, int kubikaza, String boja,int brojVrata, String tipMotora) {
        super(proizvodjac, godinaProizvodnje, kubikaza, boja);
        this.brojVrata = brojVrata;
        this.tipMotora = tipMotora;
}
    
    public int getBrojVrata() {
		return brojVrata;
	}

	public void setBrojVrata(int brojVrata) {
		this.brojVrata = brojVrata;
	}

	public String getTipMotora() {
		return tipMotora;
	}

	public void setTipMotora(String tipMotora) {
		this.tipMotora = tipMotora;
	}

    @Override
    public double cijenaRegistracije() {
        double cijena = super.cijenaRegistracije();
        if (tipMotora.equalsIgnoreCase("dizel"))    //poredi dva stringa, zasto ne == jer moze biti 
            cijena += 20;                          //disel i DIESEL
        return cijena;
    }

	@Override
	public String toString() {
		return "Automobil " + proizvodjac +" , " + godinaProizvodnje + "\n"
				+ kubikaza + "cc" + boja + " , "+ brojVrata +" vrata, motor:" + tipMotora;
	}

}


static class Kamioni extends Vozilo {
	private double kapacitetTereta;
	private boolean prikolica;
	
	public Kamioni(String proizvodjac, int godinaProizvodnje, int kubikaza, String boja, double kapacitetTereta,boolean prikolica) {
		super(proizvodjac, godinaProizvodnje, kubikaza, boja);
		this.kapacitetTereta = kapacitetTereta;
		this.prikolica = prikolica;
	}
	
	
	public double getKapacitetTereta() {
		return kapacitetTereta;
	}
	public void setKapacitetTereta(double kapacitetTereta) {
		this.kapacitetTereta = kapacitetTereta;
	}
	public boolean isPrikolica() {
		return prikolica;
	}
	public void setPrikolica(boolean prikolica) {
		this.prikolica = prikolica;
	}
	
	public double cijenaKamiona() {
		double cijena = 100;
		if(prikolica)
			cijena+= 50;
		return  cijena;
	}
	
	

@Override
	public String toString() {
		return "Kamion : " + proizvodjac + ", " + godinaProizvodnje + ", "
                + kubikaza + "cc, " + boja + ", Kapacitet: " + kapacitetTereta + "t, "
                + "Prikolica: " + (prikolica ? "da" : "ne");
	}



static class Kombi extends Vozilo {
	private int kapacitetPutnika;

	public Kombi(String proizvodjac, int godinaProizvodnje, int kubikaza, String boja, int kapacitetPutnika) {
		super(proizvodjac, godinaProizvodnje, kubikaza, boja);
		this.kapacitetPutnika = kapacitetPutnika;
	}

	public int getKapacitetPutnika() {
		return kapacitetPutnika;
	}
	public void setKapacitetPutnika(int kapacitetPutnika) {
		this.kapacitetPutnika = kapacitetPutnika;
}

    @Override
    public double cijenaRegistracije() {
        double cijena = super.cijenaRegistracije();
        if (kapacitetPutnika > 8)
            cijena += 30;
        return cijena;
    }

	
	@Override
	public String toString() {
		return "Kombi : " + proizvodjac + ", " + godinaProizvodnje + " godina proizvodnje "
			       + kubikaza + "cc, " + boja + ", Kapacitet putnika: " + kapacitetPutnika;
	}
	
}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Automobil auto = new Automobil("Audi", 2015, 2200, "Siva", 5, "dizel");
	    System.out.println(auto.toString());
	    System.out.println("Cijena registracije: " + auto.cijenaRegistracije() + " EUR");
	    
	    Kamioni kamion = new Kamioni("Volvo", 2010, 5000, "Plava", 12.5, true);
	    System.out.println(kamion.toString());
	    System.out.println("Cijena registracije: " + kamion.cijenaKamiona() + " EUR");
	}

}