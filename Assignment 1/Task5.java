// You may not change or erase any of the lines and comments 
// in this file. You may only add lines in the designated 
// area.

import java.util.Scanner;

public class Task5 {


    public static void main(String[] args){
 

    	// ----------------- "A": write your code BELOW this line only --------

		// Swap nubers so a is the smallest number and e is the biggest number between given number
		Scanner myScanner = new Scanner(System.in);
		int a = myScanner.nextInt();
		int b = myScanner.nextInt();
		int c = myScanner.nextInt();
		int d = myScanner.nextInt();
		int e = myScanner.nextInt();

		int tmp;

		if (a > b) {
			tmp = b;
			b = a;
			a = tmp;
		}
		if (a > c) {
			tmp = c;
			c = a;
			a = tmp;
		}
		if (b > c) {
			tmp = c;
			c = b;
			b = tmp;
		}
		if (d > e) {
			tmp = e;
			e = d;
			d = tmp;
		}
		if (c > e) {
			tmp = e;
			e = c;
			c = tmp;
		}
		if (a > d) {
			tmp = d;
			d = a;
			a = tmp;
		}
		System.out.println(a);
		System.out.println(e);
		myScanner.close();

		// ----------------- "B" write your code ABOVE this line only ---------

    } // end of main
} //end of class Task5

