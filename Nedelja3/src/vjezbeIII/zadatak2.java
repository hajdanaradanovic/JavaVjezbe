package vjezbeIII;

import java.util.Scanner;

public class zadatak2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double cx = sc.nextDouble();
		double cy = sc.nextDouble();
		double R1 = sc.nextDouble();
		double R2 = sc.nextDouble();
		int N = sc.nextInt();

		int broj = 0;
		double maxUdaljenost = 0;

		for (int i = 1; i <= N; i++) {
			double x = sc.nextDouble();
			double y = sc.nextDouble();

			double dist = Math.sqrt(Math.pow(x - cx, 2) + Math.pow(y - cy, 2));

			if (dist >= R1 && dist <= R2 && y >= cy) {
				broj++;
			}

			if (dist > maxUdaljenost) {
				maxUdaljenost = dist;
			}
		}

		System.out.println(broj);
		System.out.println(maxUdaljenost);
		
		sc.close();

	}
}
