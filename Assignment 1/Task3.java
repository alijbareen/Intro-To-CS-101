import java.util.Scanner;

public class Task3 {
	
	public static void main(String[] args) {

		// ----------------- write your code BELOW this line only --------

		// Prints all prime factors of given number and the number of times they devise
		Scanner myScanner = new Scanner(System.in);
	    int n = myScanner.nextInt();
	    int divisor = 2;
	    int counter;

	    while (n != 1) {
			counter = 0;
			while (n%divisor == 0) { //Count how many times the divisor divises n
			    n = n/divisor;
			    counter = counter + 1;
			}
			if (counter == 1) {
			    System.out.println(divisor);
			}
			if (counter > 1) {
		    	System.out.println(divisor + " " + counter);
			}
			divisor = divisor + 1;
	    }
	    myScanner.close();

	    // ----------------- write your code ABOVE this line only ---------
		
	}
}
