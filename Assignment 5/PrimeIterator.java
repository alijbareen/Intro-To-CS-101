/*---------------------------------------
 Genuine author: Nadav Shaked, I.D.: 312494925
 Date: 02-01-2019
---------------------------------------*/
import java.util.Iterator;

public class PrimeIterator implements Iterator<Integer> {

    private List<Integer> primes;
   
	//Complete the following method
    public PrimeIterator(){
    	primes = new LinkedList<Integer>();
    	primes.add(2);
    }

	//Complete the following method
    public boolean hasNext(){	
    	return true;
    }

	//Complete the following method
    public Integer next(){
    	int size = primes.size();
    	Integer currentPrime = primes.get(size - 1);
    	Integer nextPrime = currentPrime.intValue();
    	boolean isFound = false;
    	while (!isFound) {
    		isFound = true;
    		nextPrime = nextPrime + 1;
    		Iterator<Integer> it = primes.iterator();
    		while (isFound & it.hasNext()) {
    			if (nextPrime % it.next() == 0) {
    				isFound = false;
    			}
    		}
    	}
    	primes.add(nextPrime);
        return currentPrime;
    }
	
	//DO NOT REMOVE OR CHANGE THIS MEHTOD – IT IS REQUIRED 
	public void remove() {
		return;
	}
}
