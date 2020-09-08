import java.util.Scanner;

public class Task1b {
	
	public static void main(String[] args) {

		// ----------------- write your code BELOW this line only --------

		//Prints all pythagoras triples until given number n
		Scanner myScanner = new Scanner(System.in);
	    int n = myScanner.nextInt();

	    for(int i = 1; i <= n-2 ; i = i+1) {
			for(int j = i+1; j <= n-1 ; j = j+1) {
		    	for(int k = j+1; k <= n ; k= k+1) {
					if((i*i + j*j) == (k*k)) { //Check if pythagoras
			    		System.out.println(i + " " + j + " " + k);
					}
		    	}
			}
	    }
	    myScanner.close();

	    // ----------------- write your code ABOVE this line only ---------
		
	}
}
