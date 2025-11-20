//izuzeci - koriste se da ne bi doslo do prekida programa 
public abstract class Vozilo {
	
	protected String id;
	protected double maxBrzina;
	
	
	public Vozilo(String id, double maxBrzina) {
		this.setId(id);
		this.setMaxBrzina(maxBrzina);
	}
	
	public Vozilo() {
		this("", 0);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getMaxBrzina() {
		return maxBrzina;
	}
	public void setMaxBrzina(double maxBrzina) {
		this.maxBrzina = maxBrzina;
	} 
	
	public void info() { 
        System.out.println("ID vozila: " + id + ", a maksimalna brzina: " + maxBrzina + " km/h");
    }
	
	 public abstract double izracunajVrijemeDostave(double udaljenostKm); 
	 //apstraktna klasa dje njena implementacija zavisi od tipa vozila

}
