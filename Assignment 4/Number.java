import java.util.Iterator;

public class Number implements Comparable<Number> {
    private static final int BASE = 2;
    private static final Number ZERO = new Number();
    private static final Number ONE = new Number(1);
    private List<Bit> list;
	
    /**
     * Constructs a new Number defaulted to the value zero.
     */
    public Number(){
    	list = new LinkedList<Bit>();
        list.add(new Bit(false));
    }

    /**
     * Constructs a new Number from an int.
     * @param number an int representing a decimal number
     */
    public Number(int number){  // assignment #1
    	list = new LinkedList<Bit>();
    	
    	if (number < 0) {
            throw new IllegalArgumentException("Number Must Be Positive");
    	}
    	else if (number == 0) {
    		list.add(new Bit(false));
    	}
    	else {
    		while (number > 0) {
    			list.add(new Bit(number % 2 == 1)); // Converts number to bit and adds to list
    			number = number / 2;
    		}
    	}
    }

    /**
     * Constructs a new Number from a String.
     * @param s a String (possibly) representing a decimal number.
     */
    public Number(String s){    // assignment #2
    	// Checks if the string represents a number
    	if (s == null) {
    		throw new IllegalArgumentException("String Can't Be Null");
    	}
    	if (s.charAt(0) == '0' & s.length() > 1) {
    		throw new IllegalArgumentException("String Is Illigal Number");
    	}
    	
    	int number = 0;
    	int power = 1;
    	
    	for (int i = s.length() - 1; i >= 0; i = i - 1) {
    		if (s.charAt(i) < '0' | s.charAt(i) > '9') { // Checks if string includes illegal character
    			throw new IllegalArgumentException("String Is Not A Positive Number");
    		}
    		
    		int digit = s.charAt(i) - '0'; // Gets the value of the char
    		
    		number = number + digit * power;
    		power = power * 10;
    	}
    	
    	// Creates number object
    	list = new LinkedList<Bit>();
    	
    	if (number == 0) {
    		list.add(new Bit(false));
    	}
    	else {
    		while (number > 0) {
    			if (number % 2 == 1) { // Finds the bit value
    				list.add(new Bit(true));
    			}
    			else {
    				list.add(new Bit(false));
    			}
    			number = number / 2;
    		}
    	}
    }

    /**
     * Constructs a new Number which is a deep copy of the provided Number.
     * @param number a Number to be copied
     */
    public Number(Number number){ // assignment #3
    	// Copies the given number
    	if (number == null) {
    		throw new IllegalArgumentException("Number Can't Be Null");
    	}
    	list = new LinkedList<Bit>();
    	int numberSize = number.list.size();
    	for (int i = 0; i < numberSize; i = i + 1) {
    		Bit tmp = new Bit(number.list.get(i).getValue());
    		list.add(tmp);
    	}
    }
    
    /**
     * Returns the list of the Number.
     */
    public List<Bit> getList() {
    	return list;
    }

    /**
     * Checks if this Number is zero.
     * @return true if and only if this object representing the number zero.
     */
    public boolean isZero(){ // assignment #4
        return (this.list.size() == 1 && this.list.get(0).isZero());
    }


    /**
     * Returns an iterator over the Bit objects in the representation of this number,
     * which iterates over the Bit objects from LSB (first) to MSB (last).
     * @return a LSB-first iterator over the Bit objects in the representation of this number.
     */
    public Iterator<Bit> bitIterator(){ // assignment #5        
        return this.list.iterator();
    }


    /**
     * Adds 1 to the number
     */
    public void increment(){ // assignment #6
    	int i = 0;
    	boolean isZeroFound = false;
    	while (i < this.list.size() & !isZeroFound) { // Runs over the number bits to find the first zero
    		if (this.list.get(i).isZero()) {
    			isZeroFound = true;
    			this.list.set(i, new Bit(true));
    			for (int j = i - 1; j >= 0; j = j - 1) { // Goes backwards and changes ones to zeros
    				this.list.set(j, new Bit(false));
    			}
    		}
    		i = i + 1;
    	}
    	if (!isZeroFound) {
    		i = 0;
    		while (i < this.list.size() - 1) { // Goes backwards and changes all ones to zeros
    			this.list.set(i, new Bit(false));
    			i = i + 1;
    		}
    		this.list.add(0, new Bit(false)); // Adds one as the most significant bit
    	}
    }


    /**
     * Checks if a provided String represent a legal decimal number.
     * @param s a String that possibly represents a decimal number, whose legality to be checked.
     * @return true if and only if the provided String is a legal decimal number
     */
    public static boolean isLegal(String s){ // assignment #7
    	boolean isLegal = true;
    	if (s == null || s == "") {
    		isLegal = false;
    	}
    	else if (s.charAt(0) == '0' & s.length() > 1) {
    		isLegal = false;
    	}
    	else {
    		for (int i = s.length() - 1;isLegal & i >= 0; i = i - 1) {
    			if (s.charAt(i) < '0' | s.charAt(i) > '9') { // Checks if string includes illegal characters
    				isLegal = false;
    			}
    		}
    	}
    	return isLegal;
    }


    /**
     * Compares the specified object with this Number for equality.
     * Returns true if and only if the specified object is also a
     * Number (object) which represents the same number.
     * @param obj he object to be compared for equality with this Number
     * @return true if and only if the specified object is equal to this object
     */
    public boolean equals(Object obj){ // assignment #8
    	boolean isEqual = true;
    	if (!(obj instanceof Number)) {
    		isEqual = false;
    	}
    	else if (((Number) obj).list.size() != this.list.size()) {
    		isEqual = false;
    	}
    	else {
    		int numOfBits = this.list.size();
    		int i = 0;
    		while (isEqual & i < numOfBits) { // Runs over the numbers and checks if the bits are equal
    			if (this.list.get(i).isZero() != ((Number) obj).list.get(i).isZero()) {
    				isEqual = false;
    			}
    			i = i + 1;
    		}
    	}
        return isEqual;
    }


    /**
     * Returns a string representation of this Number
     * as a binary number.
     * @return a string representation of this Number
     */
    public String toString(){ // assignment #9
    	Iterator<Bit> it = this.bitIterator();
    	String s = "";
    	while (it.hasNext()) {
    		Bit bit = it.next();
    		s = bit.toInt() + s;
    	}
        return s;
    }


    /**
     * Compares the two provided numbers, and returns true if
     * the first parameter is less than or equal to the second
     * parameter, as numbers.
     * @param num1 the first number to compare
     * @param num2 the second number to compare
     * @return true if and only if the first number is less than
     * or equal to the second parameter, as numbers.
     */
    public static boolean lessEq(Number num1, Number num2){ // assignment #10
    	boolean isLessEq = true;
    	int msNotEqualBit = 0; // Marks the number with the most significant bit (0 - equals, 1 - num1, 2 - num2)
    	Iterator<Bit> it1 = num1.bitIterator();
    	Iterator<Bit> it2 = num2.bitIterator();
    	
    	while (it1.hasNext() & it2.hasNext()) {
    		int bit1 = it1.next().toInt();
    		int bit2 = it2.next().toInt();
    		if (bit1 > bit2) {
    			msNotEqualBit = 1;
    		}
    		else if (bit1 < bit2) {
    			msNotEqualBit = 2;
    		}
    	}
    	if (!it1.hasNext() & !it2.hasNext()) { // Checks If both numbers have the same number of bits
    		if (msNotEqualBit == 1) {
    			isLessEq = false;
    		}
    	}
    	else if (it1.hasNext() & !it2.hasNext()) { // Checks if num1 has more digits than num2
    		isLessEq = false;
    	}
        
    	return isLessEq;
    }


    /**
     * Compares the two provided numbers, and returns true if
     * the first parameter is strictly less than the second
     * parameter, as numbers.
     * @param num1 the first number to compare
     * @param num2 the second number to compare
     * @return true if and only if the first number is strictly
     * less than the second parameter, as numbers.
     */
    public static boolean lessThan(Number num1, Number num2){ // assignment #11
    	boolean isLessEq = true;
    	int msNotEqualBit = 0; // Marks the number with the most significant bit (0 - equals, 1 - num1, 2 - num2)
    	Iterator<Bit> it1 = num1.bitIterator();
    	Iterator<Bit> it2 = num2.bitIterator();
    	
    	while (it1.hasNext() & it2.hasNext()) {
    		int bit1 = it1.next().toInt();
    		int bit2 = it2.next().toInt();
    		if (bit1 > bit2) {
    			msNotEqualBit = 1;
    		}
    		else if (bit1 < bit2) {
    			msNotEqualBit = 2;
    		}
    	}
    	if (!it1.hasNext() & !it2.hasNext()) { // Checks If both numbers have the same number of bits
    		if (msNotEqualBit != 2) { // If the most significant bit is not in num1 it means num2 is equal or bigger
    			isLessEq = false;
    		}
    	}
    	else if (it1.hasNext() & !it2.hasNext()) { // Checks if num1 has more digits than num2
    		isLessEq = false;
    	}
        
    	return isLessEq;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Number o){ // assignment #12
    	int output = 0;
        if (!(o instanceof Number)) {
        	throw new IllegalArgumentException("illigal argument");
        }
        else {
        	if(lessThan(this, o)) {
        		output = -1;
        	}
        	else if (lessEq(this, o)) { // Checks if equal
        		output = 0;
        	}
        	else {
        		output = 1;
        	}
        }
        
        return output;
    }


    /**
     * Adds the specified Number objects, and returns their sum.
     * @param num1 the first addend
     * @param num2 the second addend
     * @return the sum of the specified Number objects.
     */
    public static Number add(Number num1, Number num2){ // assignment #13
    	
    	Bit Cin = new Bit(false);
    	Number num = null;
    	Iterator<Bit> it1 = num1.bitIterator();
    	Iterator<Bit> it2 = num2.bitIterator();
    	
    	while (it1.hasNext() | it2.hasNext()) {
    		Bit bit1;
    		Bit bit2;
    		
    		if (it1.hasNext()) {
    			bit1 = it1.next();
    		}
    		else {
    			bit1 = new Bit (false);
    		}
    		
    		if (it2.hasNext()) {
    			bit2 = it2.next();
    		}
    		else {
    			bit2 = new Bit (false);
    		}
    		
    		if (num == null) {
    	    	num = new Number(Bit.fullAdderSum(bit1, bit2, Cin).toInt()); // Creates number and inserts the result of sum calculation
    		}
    		else {
    			num.list.add(Bit.fullAdderSum(bit1, bit2, Cin)); // Inserts the result of sum calculation to the number
    		}
			Cin = Bit.fullAdderCarry(bit1, bit2, Cin); // Inserts the result of carry calculation
    	}
    	if (Cin.isOne()) {
    		num.list.add(Cin); // Adds one if the most significant number is zero
    	}
    	
    	return num;
    }


    /**
     * Multiply the specified Number objects, and returns their product.
     * @param num1 the first factor
     * @param num2 the second factor
     * @return the product of the specified Number objects.
     */
    public static Number multiply(Number num1, Number num2){ // assignment #14
    	Number retNum = new Number(0);
    	Number multNum = new Number(num1);
    	
    	Iterator<Bit> it2 = num2.bitIterator();
    	
    	while (it2.hasNext()) {
    		if (it2.next().isOne()) { // If bit is one then sum retNum with multNum
    			retNum = add(retNum, multNum);
    		}
    		multNum.list.add(0, new Bit(false));
    	}
    	
    	return retNum;
    }
}
