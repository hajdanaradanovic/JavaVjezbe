//metod koji pretvara karakter u broj, pa onda gledamo da li je paran ili neparan 

import java.util.Scanner;

public class enkripcija {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String unos = sc.nextLine();
		String s = "";
		
		for(int i = 0; i < unos.length(); i++) {
			char c = unos.charAt(i);
			
			int cifra = Character.getNumericValue(c);
			if(cifra % 2 == 0) {
				s = s + "1";
			} else {
				s = s + "0";
			}
		}
		System.out.println(s);
		sc.close();
	}

}
