import java.util.Scanner;

public class Task4a {
	
	public static void main(String[] args) {

		// ----------------- write your code BELOW this line only --------

        // Finds the greatest common devisor of three given numbers
		Scanner myScanner = new Scanner(System.in);
	    int a = myScanner.nextInt();
	    int b = myScanner.nextInt();
	    int c = myScanner.nextInt();
	    int gcd = 1;
	    int i = 2;

	    while (i <= a & i <= b & i <=c) { //Check all the vars, and find the greatest common divisor
			if (a%i == 0 & b%i == 0 & c%i == 0) {
		    	gcd = i;
			}
			i = i + 1;
	    }
	    System.out.println(gcd);
	    myScanner.close();

	    // ----------------- write your code ABOVE this line only ---------
		
	}
}
