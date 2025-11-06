
public class ObracunPlate extends Zaposleni {
	
    private Zaposleni zaposleni;
    private int mesec;
    private int godina;
    private double iznos;
    private double bonus; 

    public ObracunPlate(Zaposleni zaposleni, int mesec, int godina, double bonus) {
        this.zaposleni = zaposleni;
        this.mesec = mesec;
        this.godina = godina;
        this.bonus = bonus;
        this.iznos = izracunajPlatu(); 
    }

    // Getteri i setteri
    public Zaposleni getZaposleni() { 
    	return zaposleni;
    	}
    
    public void setZaposleni(Zaposleni zaposleni) { 
    	this.zaposleni = zaposleni; 
    	}

    public int getMesec() { 
    	return mesec; 
    	}
    public void setMesec(int mesec) { 
    	this.mesec = mesec; 
    	}

    public int getGodina() { 
    	return godina; 
    
 }
    public void setGodina(int godina) { 
    	this.godina = godina;
    	}

    public double getIznos() { 
    	return iznos; 
    	}

    public double getBonus() { 
    	return bonus;
    	}
    public void setBonus(double bonus) { 
        this.bonus = bonus; 
        this.iznos = izracunajPlatu(); 
    }

 
    private double izracunajPlatu() {
        if (zaposleni == null) return 0;
        return zaposleni.getSatnica() * zaposleni.getBrojSati() + bonus;
    }


    public void prikaziObracun() {
        System.out.println("Zaposleni: " + zaposleni.getIme() + " " + zaposleni.getPrezime());
        System.out.println("Mesec/Godina: " + mesec + "/" + godina);
        System.out.println("Iznos plate: " + iznos);
        System.out.println("Bonus: " + bonus);
    }
	
}
