
public class Bit {
	
	//fields
	private boolean value;

	//constructors
    public Bit(boolean value) {
    	
		this.value = value;
	}

    public String toString() {
    	
    	String digit = "0";
    	
    	if (value == true) {
    		digit = "1";
    	}
    	
		return digit;
    }

    public boolean isOne() { //Check if value represent the digit 1
    	
    	boolean isOne = true;
    	if (value == false) {
    		isOne = false;
    	}
    	
		return isOne;
    }

    public boolean lessThan(Bit digit) { //Check if field value represent smaller value than digit 
    	
    	boolean isLess = false;
    	if (intValue(digit.isOne()) > intValue(value)) {
    		isLess = true;
    	}
        return isLess;
	}

    public boolean lessEq(Bit digit) { //Check if field value represent equal or smaller value than digit
    	
    	boolean isLessEq = false;
    	if (intValue(digit.isOne()) >= intValue(value)) {
    		isLessEq = true;
    	}
        return isLessEq;
	}

   public static Bit fullAdderSum(Bit A, Bit B, Bit Cin) { //Return Bit object that represent the fullAdderSum
	   
	   int sum = intValue(A.isOne()) + intValue(B.isOne()) + intValue(Cin.isOne());
	   Bit fASum = new Bit (sum % 2 == 1);
	   
       return fASum;
   }
   
   public static Bit fullAdderCarry(Bit A, Bit B, Bit Cin) { //Return Bit object that represent the fullAdderCarry
	   int carry = intValue(A.isOne()) + intValue(B.isOne()) + intValue(Cin.isOne());
	   Bit fACarry = new Bit (carry/2 == 1);
	   
	   return fACarry;
   }
   
   public static int intValue(boolean value) { //Convert the field value to int
	   
	   int intValue = 0;
	   
	   if (value == true) {
		   intValue = 1;
	   }
	   
	   return intValue;
   }

}
