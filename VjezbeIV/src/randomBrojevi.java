import java.util.Scanner;
import java.util.Random;

//rand daje vrijednosti od 0 do 10 
//zadatak sa random brojevima 6. nedelja
public class randomBrojevi {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random rand = new Random(); 
		int n = in.nextInt();
		int elem[] = new int[n];
		for(int i = 0; i< elem.length;i++) {
			elem[i] = rand.nextInt();
		}
		int niz[] = new int[elem.length]; 
		//paran - njemu suprotan
		//neparan - ili za jedan veci ili za jedan manji 
		// -1 * n 
		// 1/n
		
		for(int i = 0; i < elem.length; i++) {
			if(elem[i]%2 == 0) {
				niz[i] = elem[i]*(-1);
			} else {
				niz[i] = 1 / elem[i]; 
			}
		}
		
	}

}
