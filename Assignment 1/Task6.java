// You may not change or erase any of the lines and comments 
// in this file. You may only add lines.

import java.util.Scanner;

public class Task6 {


    public static void main(String[] args){

    	// ----------------- write any code BELOW this line only --------

		// Checks if task 5 works
		int a;
		int b;
		int c;
		int d;
		int e;

		int tmp;
		boolean failed = false;

		//Try all possible combinations of 0 and 1 and stop if a>e
		for (int i = 0; i <= 1 & !failed; i++) {
			for (int j = 0; j <= 1 & !failed; j++) {
				for (int k = 0; k <= 1 & !failed; k++) {
					for (int l = 0; l <= 1 & !failed; l++) {
						for (int m = 0; m <= 1 & !failed; m++) {
							// Difine the value of the variations
							a = i;
							b = j;
							c = k;
							d = l;
							e = m;

            				// ----------------- write any code ABOVE this line only ---------

            				// -----------------  copy here the code from Task 5 that is between
            				// -----------------  the comments "A" and "B"

							// Swap numbers so a is the smallest number and e is the biggest number between given number
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

            				// -----------------  end of copied code from Task 5

            				// ----------------- write any code BELOW this line only --------

							if (a > e) { //Check if a is the smallest and e is the biggest
								System.out.println(a);
								System.out.println(b);
								System.out.println(c);
								System.out.println(d);
								System.out.println(e);

								failed = true;
							}
						}
					}
				}
			}
		}
		if (!failed) {
			System.out.println("verified");
		}

		// ----------------- write any code ABOVE this line only ---------

    } // end of main
} //end of class Task6

