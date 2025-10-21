import java.util.Scanner;

public class broj_rijeci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc = new Scanner(System.in);

        System.out.print("Unesite rečenicu: ");
        String text = sc.nextLine();
        
        String [] rijeci = text.split(" ");
        
        System.out.println("Broj rijeci je: "+ rijeci.length);
        
        sc.close(); 
   	
	}

}
