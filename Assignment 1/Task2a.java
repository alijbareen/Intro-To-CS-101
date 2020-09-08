import java.util.Scanner;

public class Task2a {
	
	public static void main(String[] args) {

		// ----------------- write your code BELOW this line only --------

		// Calculate factorial number
		Scanner myScanner = new Scanner(System.in);
	    int n = myScanner.nextInt();
	    int factorial = 1;

	    for(int i = 2; i <= n ; i = i+1) { //Multiply all numbers until given number n
			factorial = factorial * i;
	    }
	    System.out.println(factorial);
	    myScanner.close();

	    // ----------------- write your code ABOVE this line only ---------
		
	}
}
