
//BIO JE NA KOLOKVIJUM 

import java.util.Scanner;

public class EvidencijaTemperatura {
	private double niz[];

	public EvidencijaTemperatura(double[] niz) {
		this.niz = niz;
	}

	public double[] getNiz() {
		return niz;
	}

	public void setNiz(double[] niz) {
		this.niz = niz;
	}
	
	//iz postavke ovog zadatka sam uklonila parametar double[] niz, zato sto tu vrijednost vec imamo kao atribut klase 
	public double prosjecnaTemperatura() {
		double zbir = 0;
		for(double x: this.niz) {
			zbir += x;
		}
		return zbir/this.niz.length;
	}
	
	public double maksimalnaTemperatura() {
		double max = this.niz[0];
		for(int i = 1; i < this.niz.length; i++) {
			if(max > this.niz[i]) {
				max = this.niz[i];
			}
		}
		return max; 
	}
	
	public boolean daLiSeNalazi(double x) {
	    double[] niz= getNiz();
	    for (int i = 0; i < niz.length; i++) {
	        if (x == niz[i]) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public void ukloniti(double y) {
	    double[] niz = getNiz();
	    int br = 0;
	    for (double z: niz) {
	        if (z != y) {
	            br++;
	        }
	    }
	    double[] noviNiz = new double[br];
	    int index = 0;
	    for (double vr : niz) {
	        if (vr != y) {
	            noviNiz[index++] = vr;
	        }
	    }
	    setNiz(noviNiz);
	}

	public static void main(String[] args) {
		
		
		
		Scanner sc = new Scanner(System.in);
		double [] niz1 = new double[5];
		for(int i =0; i<niz1.length; i++) {
			niz1[i] = sc.nextDouble();
			System.out.print(" "+ niz1[i]);
		}
		
		EvidencijaTemperatura e = new EvidencijaTemperatura(niz1);
		
		
		System.out.print(" , a duzina je "+ niz1.length);
		System.out.println(e.prosjecnaTemperatura());
		System.out.println(e.maksimalnaTemperatura());
		System.out.println(e.daLiSeNalazi(16.5));
		e.ukloniti(8.0);
		
		sc.close();
		
		
	}
}
