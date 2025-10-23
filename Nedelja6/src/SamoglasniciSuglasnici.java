import java.util.Scanner;

public class SamoglasniciSuglasnici {
	private static boolean jeSamoglasnik(char c) {
		c = Character.toLowerCase(c);  //sve pretvaramo u mala slova
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'; 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String tekst = sc.nextLine();
		
		int br_samoglasnika = 0;
		int br_slova = 0;
		
		for(int i =0; i < tekst.length(); i++) {
			char c = tekst.charAt(i); //karakteri se ovako dobijaju
			if(Character.isLetter(c)) {  
				br_slova ++;
				if(jeSamoglasnik(c)) {
					br_samoglasnika ++;
				}
			}
		}
		
		System.out.println("Broj samoglasnika je: "+ br_samoglasnika);
		System.out.println("Broj suglasnika je: "+ (br_slova - br_samoglasnika));
		
		sc.close();
	}

}
