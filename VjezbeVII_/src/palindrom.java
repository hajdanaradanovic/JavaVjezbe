import java.util.Scanner;

public class palindrom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		/*String tekst = sc.nextLine();
		tekst = tekst.trim();  //ne mijenja se string jer se stringovi direktno ne mijenjaju
		//nova varijabla tekst  */
		
		String tekst = sc.nextLine().trim(); //ekvivaletno prethodnom tekstu 
		String okrenutiTekst = new StringBuilder(tekst).reverse().toString();
		
		System.out.print(tekst.equalsIgnoreCase(okrenutiTekst));  
		
		sc.close();
		
	}

}
