package vjezbeIII;

import java.util.Scanner;

public class zadatak1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		System.out.print("Unesi broj katapulta N: ");
		int N = sc.nextInt();

		System.out.print("Unesi domet katapulta D: ");
		int D = sc.nextInt();

		System.out.print("Unesi health dvorca HD: ");
		int HD = sc.nextInt();

		System.out.print("Unesi vrijednost napada jednog katapulta KA: ");
		int KA = sc.nextInt();

		int prijetnja = 0;

		for (int i = 1; i <= N; i++) {
			System.out.print("Unesi koordinate katapulta " + i + " (x y): ");
			int x = sc.nextInt();
			int y = sc.nextInt();

			int udaljenost = Math.abs(x) + Math.abs(y);

			if (udaljenost <= D) {
				prijetnja++;
			}
		}

		System.out.println("Broj katapulta koji prijete dvorcu: " + prijetnja);

		int ukupniNapad = prijetnja * KA;

		if (ukupniNapad >= HD) {
			System.out.println("Dvorac može biti srušen.");
		} else {
			System.out.println("Dvorac će preživjeti napad.");
		}
		
		sc.close();
	}

}
