/*---------------------------------------
 Genuine author: Nadav Shaked, I.D.: 312494925
 Date: 02-01-2019
---------------------------------------*/
import java.util.Comparator;

public class AccountComparatorByNumber implements Comparator<BankAccount>{

	@Override
	//Complete the following method
	public int compare(BankAccount account1, BankAccount account2) {
		return (account1.getAccountNumber() - account2.getAccountNumber());
	}

}
