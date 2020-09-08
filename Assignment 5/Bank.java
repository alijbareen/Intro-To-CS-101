/*---------------------------------------
 Genuine author: Nadav Shaked, I.D.: 312494925
 Date: 02-01-2019
---------------------------------------*/

/**
 * This class represents a bank,
 * it has namesTree, accountNumbersTree and supports operations like add, remove, deposit and withdraw.
 *
 * @author <Nadav Shaked>
 */
public class Bank {

	private BankAccountsBinarySearchTree namesTree;
	private BankAccountsBinarySearchTree accountNumbersTree;
	
	public Bank() {
		namesTree = new BankAccountsBinarySearchTree(new AccountComparatorByName());
		accountNumbersTree = new BankAccountsBinarySearchTree(new AccountComparatorByNumber());
	}

	public BankAccount lookUp(String name){
		// create an Entry with the given name, a "dummy" accountNumber (1) and zero balance
		// This "dummy" accountNumber will be ignored when executing getData
		BankAccount lookFor = new BankAccount(name, 1, 0);
		return (BankAccount)namesTree.findData(lookFor);
	}
	
	public BankAccount lookUp(int accountNumber){
		// create an Entry with a "dummy" name, zero balance and the given accountNumber
		// This "dummy" name will be ignored when executing getData
		BankAccount lookFor = new BankAccount("dummy", accountNumber,0);
		return (BankAccount)accountNumbersTree.findData(lookFor);
	}
	
	/**
     * This method balances the BankAccountsSearchTrees.
     */
	public void balance(){
		namesTree.balance();
		accountNumbersTree.balance();
	}
	
	/**
     * @return the object namesTree.
     */
	public Object exportNames() {
		return this.namesTree;
	}
	
	/**
     * @return the object accountNumbersTree.
     */
	public Object exportAccountNumbers() {
		return this.accountNumbersTree;
	}
	
	// END OF Given code -----------------------------------
	
	//Complete the following method
	/**
	 * This method adds new bank account to bank.
	 *
	 * @param newAccount The new account that needs to be added.
	 * @return true if there is no other bank account with the same name or number,
	 * and account is added to both fields .
	 */
	public boolean add(BankAccount newAccount) {
		boolean isAdded = false;
		if (lookUp(newAccount.getName()) == null & lookUp(newAccount.getBalance()) == null) {
			namesTree.insert(newAccount);
			accountNumbersTree.insert(newAccount);
			
			isAdded = true;
		}
		return isAdded;
	}

	//Complete the following method
	/**
	 * This method removes a bank account by bank account name.
	 *
	 * @param name The name of the account that needs to be removed.
	 * @return true if account is removed from both fields .
	 */
	public boolean delete(String name){
		// this first line is given in the assignment file
		BankAccount toRemove = lookUp(name);
		boolean isDeleted = false;
		if (toRemove != null) {
			namesTree.remove(toRemove);
			accountNumbersTree.remove(toRemove);
			isDeleted = true;
		}
		return isDeleted;	
	}
	
	//Complete the following method
	/**
	 * This method removes a bank account by bank account number.
	 *
	 * @param accountNumber The number of the account that needs to be removed.
	 * @return true if account is removed from both fields .
	 */
	public boolean delete(int accountNumber){
		// this first line is given in the assignment file
		BankAccount toRemove = lookUp(accountNumber);
		boolean isDeleted = false;
		if (toRemove != null) {
			namesTree.remove(toRemove);
			accountNumbersTree.remove(toRemove);
			isDeleted = true;
		}
		return isDeleted;
	}

	//Complete the following method
	/**
	 * This method deposit money into the bank account by increasing the balance.
	 *
	 * @param amount The amount of money to deposit.
	 * @param accountNumber The number of the account that the money is deposited into.
	 * @return true if amount >= 0 else if amount is negative and if account exists in bank, return false without changing the balance.
	 */
	public boolean depositMoney(int amount, int accountNumber){
		boolean isDeposit = false;
		BankAccount account = lookUp(accountNumber);
		if (account != null) {
			isDeposit = account.depositMoney(amount);
		}
		return isDeposit;
	}

	//Complete the following method
	/**
	 * This method withdraws money from the bank account by increasing the balance.
	 *
	 * @param amount The amount of money to withdraw.
	 * @param accountNumber The number of the account that the money is withdrawn from.
	 * @return true if account is found and amount >= 0 an d by decreasing balance it doesn't turns negative, else if amount is negative or
	 * if balance < 0 after the withdraw return false without changing the balance.
	 */
	public boolean withdrawMoney(int amount, int accountNumber){
		boolean isWithdraw = false;
		BankAccount account = lookUp(accountNumber);
		if (account != null) {
			isWithdraw = account.withdrawMoney(amount);
		}
		return isWithdraw;
	}
	


}
