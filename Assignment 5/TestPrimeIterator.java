import java.util.Comparator;
import java.util.Iterator;

/*---------------------------------------
Genuine author: Nadav Shaked, I.D.: 312494925
Date: 02-01-2019
---------------------------------------*/
public class TestPrimeIterator {

	public static void main(String[] args) {
		PrimeIterator iter = new PrimeIterator();
		for (int i = 1; i < 21; i = i + 1) {
			System.out.print(iter.next()+", ");
		}
	}
	
	public static void test0() {
		PrimeIterator iter = new PrimeIterator();
		for (int i = 1; i < 21; i = i + 1) {
			System.out.print(iter.next()+", ");
		}
	}
	
	public static void test1() {
		BankAccount b1 = new BankAccount("Yossi",345,1783);
		BankAccount b2 = new BankAccount("Avi",478,0);
		BankAccount b3 = new BankAccount("Twito",3443,23);
		System.out.println(b1.depositMoney(-78));//false
		System.out.println(b2.depositMoney(45));//true
		System.out.println(b2.getBalance());//45
		System.out.println(b3.withdrawMoney(25));//false
		System.out.println(b3.withdrawMoney(20));//true
		System.out.println(b3.getBalance());//3
	}
	
	public static void test2() {
		Comparator<BankAccount> compName = new AccountComparatorByName();
		Comparator<BankAccount> compNum = new AccountComparatorByNumber();
		BankAccount b1 = new BankAccount("Yossi",345,1783);
		BankAccount b2 = new BankAccount("Avi",478,0);
		BankAccount b3 = new BankAccount("Yoel",3443,23);
		BankAccount b4 = new BankAccount("Avi",589,0);
		System.out.println(compName.compare(b1, b2));//>0
		System.out.println(compName.compare(b2, b4));//0
		System.out.println(compName.compare(b3, b1));//<0
		System.out.println(compNum.compare(b1, b2));//<0
		System.out.println(compNum.compare(b4, b2));//>0
	}
	
	public static void test5() {
		Comparator<BankAccount> c = new AccountComparatorByNumber();

        BankAccountsBinarySearchTree t1 = new BankAccountsBinarySearchTree(c);
        t1.insert(new BankAccount("a", 4, 125));
        t1.insert(new BankAccount("b", 2, 120));
        t1.insert(new BankAccount("c", 6,132));
        t1.insert(new BankAccount("d", 1, 679));
        t1.insert(new BankAccount("f", 3, 222));
        t1.insert(new BankAccount("g", 5, 222));
        t1.insert(new BankAccount("h", 7, 333));
        t1.insert(new BankAccount("i", 8, 788));
        Iterator<BankAccount> it = t1.iterator();
        while(it.hasNext())
        	System.out.println(it.next());//Name: d, AccountNumber: 1
        								//Name: a, AccountNumber: 4
        								//Name: i, AccountNumber: 8
        System.out.println();	
        BankAccountsBinarySearchTree t2 = new BankAccountsBinarySearchTree(c);
        t2.insert(new BankAccount("a", 5, 0));
        t2.insert(new BankAccount("a", 2, 150));
        t2.insert(new BankAccount("a", 6, 0));
        t2.insert(new BankAccount("a", 1, 0));
        t2.insert(new BankAccount("a", 4, 678));
        t2.insert(new BankAccount("a", 7, 785));
        t2.insert(new BankAccount("a", 3, 0));
        t2.insert(new BankAccount("a", 8, 0));
        Iterator<BankAccount> it2 = t2.iterator();
        while(it2.hasNext())
        	System.out.println(it2.next());	
        
        //Name: a, AccountNumber: 2
        //Name: a, AccountNumber: 4
       // Name: a, AccountNumber: 7
	}
	
	public static void test6() {
		Bank bank = new Bank();
		BankAccount b1 = new  BankAccount("Shemesh",472,800);
		BankAccount b2 = new  BankAccount("Shemesh",475,600);
		BankAccount b3 = new  BankAccount("Twito",472,1000);
		BankAccount b4 = new  BankAccount("Kudish",572,65);
		BankAccount b5 = new  BankAccount("Myzels",121,800);
		BankAccount b6 = new  BankAccount("Eli",544,112);
		System.out.println(bank.add(b1) + " t");//true
		System.out.println(bank.add(b2) + " f");//false
		System.out.println(bank.add(b3) + " t");//true
		System.out.println(bank.add(b4) + " t");//true
		System.out.println(bank.add(b5) + " t");//true
		System.out.println(bank.add(b6) + " t");//true
		System.out.println(bank.delete("yossi") + " f");//false
		System.out.println(bank.delete(b1.getName()) + " t");//true
		System.out.println(bank.delete(80) + " f");//false
		System.out.println(bank.depositMoney(100, 121) + " t");//true
		System.out.println(bank.withdrawMoney(112,544) + " t");//true
		System.out.println(b5.getBalance());//900
		System.out.println(b6.getBalance());//0
		//this is the names tree
		/*  Name: Eli, AccountNumber: 544
		Name: Kudish, AccountNumber: 572
		  	Name: Myzels, AccountNumber: 121
		  */
		//this is the numbersTree
		/*  Name: Myzels, AccountNumber: 121
		Name: Eli, AccountNumber: 544
  			Name: Kudish, AccountNumber: 572*/
	}

}
