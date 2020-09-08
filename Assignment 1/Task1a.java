import java.util.Scanner;

public class Task1a {
	
	public static void main(String[] args) {

		// ----------------- write your code BELOW this line only --------

		//checks if the given numbers are pythagoras triple
		Scanner myScanner = new Scanner(System.in);
	    int a = myScanner.nextInt();
	    int b = myScanner.nextInt();
	    int c = myScanner.nextInt();

	    if(a <= 0 | a > b | b > c) { //Check if 0<a<b<c
			System.out.println("no");
		}
	    else if((a*a + b*b) == (c*c)) { //Check if pythagoras
			System.out.println("yes");
	    }
	    else {
			System.out.println("no");
	    }
	    myScanner.close();

	    // ----------------- write your code ABOVE this line only ---------
		
	}
}
