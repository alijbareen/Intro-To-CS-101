import java.util.Iterator;

public class NumberTester
{
    public static void main(String[] args)
    {
        System.out.println("testNumber() = " + testNumber());
        //System.out.println("");
        System.out.println("testIsZero() = " + testIsZero());
		//System.out.println("");
        System.out.println("testBitIterator() = " + testBitIterator());
		//System.out.println("");
        System.out.println("testIncrement() = " + testIncrement());
		//System.out.println("");
        System.out.println("testIsLegal() = " + testIsLegal());
		//System.out.println("");
        System.out.println("testEquals() = " + testEquals());
        //System.out.println("");
        System.out.println("testToString() = " + testToString());
        //System.out.println("");
        System.out.println("testLessEq() = " + testLessEq());
        //System.out.println("");
        System.out.println("testLessThan() = " + testLessThan());
        //System.out.println("");
        System.out.println("testCompareTo() = " + testCompareTo());
        //System.out.println("");
        System.out.println("testAdd() = " + testAdd());
        //System.out.println("");
        System.out.println("testMultiply() = " + testMultiply());
    }
    
    public static boolean testNumber(){
    	boolean output = true;
        Number num0 = new Number();
        Number num1 = new Number("1");
        Number num2 = new Number(12);
        Number num3 = new Number(num0);
        List<Bit> list = new LinkedList<Bit>();
        list.add(new Bit(false));
        
        if (!num0.getList().equals(list)) {
        	output = false;
        }
        
        list = new LinkedList<Bit>();
        list.add(new Bit(true));
        
        if (!num1.getList().equals(list)) {
        	output = false;
        }
        
        list = new LinkedList<Bit>();
        list.add(new Bit(false));
        list.add(new Bit(false));
        list.add(new Bit(true));
        list.add(new Bit(true));
        
        if (!num2.getList().equals(list)) {
        	output = false;
        }
        
        list = new LinkedList<Bit>();
        list.add(new Bit(false));
        
        if (!num3.getList().equals(list)) {
        	output = false;
        }
        
        return output;
    }


    public static boolean testIsZero(){
    	//System.out.println("IsZero Tests");
    	Number num0 = new Number(0);
		//System.out.println(num0.isZero()); //true
		Number num1 = new Number(1);
		//System.out.println(num1.isZero()); //false
		Number num2 = new Number("0");
		//System.out.println(num2.isZero()); //true
		Number num3 = new Number("4234");
		//System.out.println(num3.isZero()); //false
		Number num4 = new Number(num1);
		//System.out.println(num4.isZero()); //false
		Number num5 = new Number(num3);
		//System.out.println(num5.isZero()); //false

		return (num0.isZero() & !num1.isZero() & num2.isZero() & !num3.isZero() & !num4.isZero() & !num5.isZero());
    }

    public static boolean testBitIterator(){
    	//System.out.println("Bit Iterator Tests");
    	boolean output = true;
    	Number num0 = new Number(15);
    	Iterator<Bit> it0 = num0.bitIterator();
    	
    	if (it0 == null) {
    		output = false;
    	}
    	else {
    		int counter = 0;
    		while (output & it0.hasNext()) {
    			counter = counter + 1;
    			if (it0.next().isZero()) {
    				output = false;
    			}
    		}
    		if (output & counter != 4) {
    			output = false;
    		}
    	}
    	
    	num0 = new Number(7);
    	it0 = num0.bitIterator();
    	
    	if (it0 == null) {
    		output = false;
    	}
    	else {
    		int counter = 0;
    		while (output & it0.hasNext()) {
    			counter = counter + 1;
    			if (it0.next().isZero()) {
    				output = false;
    			}
    		}
    		if (output & counter != 3) {
    			output = false;
    		}
    	}
    	
    	return output;
    }


    public static boolean testIncrement(){
    	//System.out.println("Increment Tests");
    	boolean output = true;
    	Number num = new Number();
    	
    	num.increment();
		if (!num.equals(new Number("1"))) {
			output = false;
		}
		num.increment();
		if (!num.equals(new Number(2))) {
			output = false;
		}
		num.increment();
		Number num3 = new Number(3);
		if (!num.equals(num3)) {
			output = false;
		}
		
		num = new Number("564");
    	
    	num.increment();
		if (!num.equals(new Number("565"))) {
			output = false;
		}
		num.increment();
		if (!num.equals(new Number(566))) {
			output = false;
		}
		num.increment();
		num3 = new Number(567);
		if (!num.equals(num3)) {
			output = false;
		}
		
		return output;
    }


    public static boolean testIsLegal(){
    	//System.out.println("IsLegal Tests");
		//System.out.println(Number.isLegal("0")); //true
		//System.out.println(Number.isLegal("0jkfsdlk")); //false
		//System.out.println(Number.isLegal("453859054354353453")); //true
		//System.out.println(Number.isLegal("4324523423kngdklg543534")); //false
		//System.out.println(Number.isLegal(null)); //false		
		//System.out.println(Number.isLegal("9032")); //true
		
		return (Number.isLegal("0") & !Number.isLegal("0jkfsdlk") & Number.isLegal("453859054354353453") & !Number.isLegal("4324523423kngdklg543534") & !Number.isLegal(null) & Number.isLegal("9032"));
    }


    public static boolean testEquals(){
    	//System.out.println("Equal Tests");
    	Number num0 = new Number(0);
		//System.out.println(num0.equals(new Number("0"))); //true
		Number num1 = new Number(1);
		//System.out.println(num1.equals(num0)); //false
		Number num2 = new Number("43");
		//System.out.println(num2.equals(new Number(43))); //true
		Number num3 = new Number("4234");
		//System.out.println(num3.equals(num2)); //false
		Number num4 = new Number(num1);
		//System.out.println(num4.equals(num0)); //false
		Number num5 = new Number("23456853");
		//System.out.println(num5.equals(num5)); //true

		return (num0.equals(new Number("0")) & !num1.equals(num0) & num2.equals(new Number(43)) & !num3.equals(num2) & !num4.equals(num0) & num5.equals(num5));
	}

    public static boolean testToString(){
    	//System.out.println("ToString Tests");
    	Number num0 = new Number(0);
		//System.out.println(num0.toString().equals("0")); //true
		Number num1 = new Number(1);
		//System.out.println(num1.toString().equals("1")); //true
		Number num2 = new Number("43");
		//System.out.println(num2.toString().equals("101011")); //true
		Number num3 = new Number("4234");
		//System.out.println(num3.toString().equals("1000010001010")); //true
		Number num4 = new Number(num1);
		//System.out.println(num4.toString().equals("1")); //true
		Number num5 = new Number("42456853");
		//System.out.println(num5.toString().equals("10100001111101011100010101")); //true

		return (num0.toString().equals("0") & num1.toString().equals("1") & num2.toString().equals("101011") & num3.toString().equals("1000010001010") & num4.toString().equals("1") & num5.toString().equals("10100001111101011100010101"));
    }


    public static boolean testLessEq(){
    	//System.out.println("Less Equal Tests");
    	Number num0 = new Number(0);
		//System.out.println(Number.lessEq(num0, new Number("0"))); //true
		Number num1 = new Number(1);
		//System.out.println(Number.lessEq(num0, num1)); //true
		Number num2 = new Number("43");
		//System.out.println(Number.lessEq(num2, num1)); //false
		Number num3 = new Number("4234");
		//System.out.println(Number.lessEq(num2, num3)); //true
		Number num4 = new Number(num1);
		//System.out.println(Number.lessEq(num4, num3)); //true
		Number num5 = new Number("42456853");
		//System.out.println(Number.lessEq(num4, num5)); //true
		
		return (Number.lessEq(num0, new Number("0")) & Number.lessEq(num0, num1) & !Number.lessEq(num2, num1) & Number.lessEq(num2, num3) & Number.lessEq(num4, num3) & Number.lessEq(num4, num5));
    }


    public static boolean testLessThan(){
    	//System.out.println("Less Than Tests");
    	Number num0 = new Number(0);
		//System.out.println(Number.lessThan(num0, new Number("0"))); //false
		Number num1 = new Number(1);
		//System.out.println(Number.lessThan(num0, num1)); //true
		Number num2 = new Number("43");
		//System.out.println(Number.lessThan(num2, num1)); //false
		Number num3 = new Number("4234");
		//System.out.println(Number.lessThan(num2, num3)); //true
		Number num4 = new Number(num1);
		//System.out.println(Number.lessThan(num4, num3)); //true
		Number num5 = new Number("42456853");
		//System.out.println(Number.lessThan(num4, num5)); //true
		
		return (!Number.lessThan(num0, new Number("0")) & Number.lessThan(num0, num1) & !Number.lessThan(num2, num1) & Number.lessThan(num2, num3) & Number.lessThan(num4, num3) & Number.lessThan(num4, num5));
    }


    public static boolean testCompareTo(){
    	//System.out.println("Compare To Tests");
    	Number num0 = new Number(67);
		Number num1 = new Number("321");
		Number num2 = new Number(num0);
		Number num3 = new Number(0);
		//System.out.println(num0.compareTo(num1)); //-1
		//System.out.println(num2.compareTo(num0)); //0
		//System.out.println(num3.compareTo(num1)); //-1
		//System.out.println(num1.compareTo(new Number(321))); //0
		//System.out.println(num2.compareTo(num3)); //1
		//System.out.println(num1.compareTo(num1)); //0
		
		return (num0.compareTo(num1) == -1 & num2.compareTo(num0) == 0 & num3.compareTo(num1) == -1 & num1.compareTo(new Number(321)) == 0 & num2.compareTo(num3) == 1 & num1.compareTo(num1) == 0);
		}


    public static boolean testAdd(){
    	//System.out.println("Add Tests");
    	Number num0 = new Number(67);
		Number num1 = new Number("321");
		Number num2 = new Number(num0);
		Number num3 = new Number(0);
		//System.out.println(Number.add(num0, num1).equals(new Number(388))); //true
		//System.out.println(Number.add(num0, num2).equals(new Number("134"))); //true
		//System.out.println(Number.add(num3, num3).equals(new Number(54))); //false
		//System.out.println(Number.add(num3, num3).equals(new Number("0"))); //true
		//System.out.println(Number.add(num1, num3).equals(new Number(11))); //false
		//System.out.println(Number.add(Number.add(num1, num0), num3).equals(Number.add(Number.add(num3, num0), num1))); //true
		
		return (Number.add(num0, num1).equals(new Number(388)) & Number.add(num0, num2).equals(new Number("134")) & !Number.add(num3, num3).equals(new Number(54)) & Number.add(num3, num3).equals(new Number("0")) & !Number.add(num1, num3).equals(new Number(11)) & Number.add(Number.add(num1, num0), num3).equals(Number.add(Number.add(num3, num0), num1)));
	}

    public static boolean testMultiply(){
    	//System.out.println("Multiply Tests");
    	Number num0 = new Number(7);
		Number num1 = new Number("321");
		Number num2 = new Number(num0);
		Number num3 = new Number(0);
		//System.out.println(Number.multiply(num0, num1).equals(new Number(2247))); //true
		//System.out.println(Number.multiply(num0, num2).equals(new Number("49"))); //true
		//System.out.println(Number.multiply(num3, num3).equals(new Number(3))); //false
		//System.out.println(Number.multiply(num3, num3).equals(new Number("0"))); //true
		//System.out.println(Number.multiply(num1, num3).equals(new Number("234"))); //false
		//System.out.println(Number.multiply(Number.multiply(num1, num0), num2).equals(Number.multiply(Number.multiply(num2, num0), num1))); //true
		
		return (Number.multiply(num0, num1).equals(new Number(2247)) & Number.multiply(num0, num2).equals(new Number("49")) & !Number.multiply(num3, num3).equals(new Number(3)) & Number.multiply(num3, num3).equals(new Number("0")) & !Number.multiply(num1, num3).equals(new Number("234")) & Number.multiply(Number.multiply(num1, num0), num2).equals(Number.multiply(Number.multiply(num2, num0), num1)));
    }
}
