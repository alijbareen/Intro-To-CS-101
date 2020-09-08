import java.util.Scanner;

public class Task4c {
	
	public static void main(String[] args) {

		// ----------------- write your code BELOW this line only --------

        //Check if the sum of the fractions is equal 1
		Scanner myScanner = new Scanner(System.in);
	    int a = myScanner.nextInt();
	    int b = myScanner.nextInt();
	    int c = myScanner.nextInt();
	    int d = myScanner.nextInt();
	    int e = myScanner.nextInt();
	    int f = myScanner.nextInt();

	    int gcd = 1;
	    int i = 2;
	    int lcm;

	    while (i <= d & i <= e) { //Check the GCD between d & e
			if (d%i == 0 & e%i == 0) {
		    	gcd = i;
			}
			i = i + 1;
	    }
	    
	    lcm = (d * e) / gcd;
	    gcd = 1;
	    i = 2;
	    
	    while (i <= f & i <= lcm) { //Check the GCD between f & lcm(d,e)
			if (f%i == 0 & lcm%i == 0) {
		    	gcd = i;
			}
			i = i + 1;
	    }
	    lcm = (f * lcm) / gcd;
	    
	    if ((a * (lcm / b)) + (c *  (lcm / d)) + (e * (lcm / f)) == lcm) {
			System.out.println("yes");
	    }
	    else {
			System.out.println("no");
	    }
	    myScanner.close();

	    // ----------------- write your code ABOVE this line only ---------
		
	}
}
