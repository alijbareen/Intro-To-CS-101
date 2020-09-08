/*---------------------------------------
 Genuine author: Nadav Shaked, I.D.: 312494925
 Date: 02-01-2019
---------------------------------------*/
import java.util.Iterator;


public class FilteredBankAccountsIterator implements Iterator<BankAccount> {

    private BankAccountsBinarySearchTree bankAccountsTree;
    private BankAccount current;
    private Iterator<BankAccount> accountsIter;

    //Complete the following method
    public FilteredBankAccountsIterator(BankAccountsBinarySearchTree bankAccountsTree) {
    	
    	List<BankAccount> accountsList= new LinkedList<BankAccount>();
    	BinaryTreeInOrderIterator<BankAccount> it = new BinaryTreeInOrderIterator<BankAccount>(bankAccountsTree.root);

    	while (it.hasNext()) {
    		BankAccount account = it.next();
    		if (account.getBalance() > 100) {
    			accountsList.add(account);
    		}
    	}
    	accountsIter = accountsList.iterator();
    }

    //Complete the following method
    @Override
    public boolean hasNext() {
        return accountsIter.hasNext();
    }

    //Complete the following method
    @Override
    public BankAccount next() {
        return accountsIter.next();
    }

    //Do not change this method.
    public void remove() {
        return;
    }
}
