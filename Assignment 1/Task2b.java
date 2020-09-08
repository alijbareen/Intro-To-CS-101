import java.util.Scanner;

public class Task2b {
	
	public static void main(String[] args) {

		// ----------------- write your code BELOW this line only --------

		// Calculate the reminder of the devision of the factorial number n by k
		Scanner myScanner = new Scanner(System.in);
	    int n = myScanner.nextInt();
	    int k = myScanner.nextInt();
	    int riminder = 1;

	    for(int i = 1; i <= n ; i = i+1) { //Count the riminder
			riminder = (riminder * i) % k;
	    }
	    System.out.println(riminder);
	    myScanner.close();

	    // ----------------- write your code ABOVE this line only ---------
		
	}
}
