import java.util.Scanner;

public class Task4b {
	
	public static void main(String[] args) {

		// ----------------- write your code BELOW this line only --------

        //Finds the lowest common multiple of three given numbers
		Scanner myScanner = new Scanner(System.in);
	    int a = myScanner.nextInt();
	    int b = myScanner.nextInt();
	    int c = myScanner.nextInt();
	    int gcd = 1;
	    int i = 2;
	    int lcm;

	    while (i <= a & i <= b) { //Check the GCD between a & b
			if (a%i == 0 & b%i == 0) {
		    	gcd = i;
			}
			i = i + 1;
	    }
	    
	    lcm = (a * b) / gcd;
	    gcd = 1;
	    i = 2;
	    
	    while (i <= c & i <= lcm) { //Check the GCD between c & lcm(a,b)
			if (c%i == 0 & lcm%i == 0) {
		    	gcd = i;
			}
			i = i + 1;
	    }
	    lcm = (c * lcm) / gcd;
	    System.out.println(lcm);
	    myScanner.close();

	    // ----------------- write your code ABOVE this line only ---------
		
	}
}
