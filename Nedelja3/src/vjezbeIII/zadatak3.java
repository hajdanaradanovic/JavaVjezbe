package vjezbeIII;

import java.util.Scanner;

public class zadatak3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int T = sc.nextInt();

		int pozicija = 0;

		for (int i = 0; i < T; i++) {
			int K = sc.nextInt();
			pozicija = (pozicija + K) % N;
			System.out.println(pozicija);
		}

		System.out.println("Konačna pozicija: " + pozicija);
		sc.close();
	}

}
