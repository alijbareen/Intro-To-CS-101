/*---------------------------------------
 Genuine author: Nadav Shaked, I.D.: 312494925
 Date: 02-01-2019
---------------------------------------*/
import java.util.Comparator;
import java.util.Iterator;

public class BankAccountsBinarySearchTree extends BinarySearchTree<BankAccount>{

	public BankAccountsBinarySearchTree(Comparator<BankAccount> myComparator) {
		super(myComparator);
	}
	
	//The following method balances the binary tree
	public void balance(){
		BinaryTreeInOrderIterator<BankAccount> oldTree = new BinaryTreeInOrderIterator<BankAccount>(this.root);
		List<BankAccount> treeList = new LinkedList<BankAccount>();
		while (oldTree.hasNext()){ //adds the bank accounts to the treeList
			treeList.add(oldTree.next());
		}
		this.root= null; //resets the tree
		
		buildBalancedTree(this ,treeList, 0, (treeList.size()-1));
	}
	
	//The following method builds a balanced tree using an empty tree, a bank accounts list, and relevant sizes
	private void buildBalancedTree(BankAccountsBinarySearchTree tree, List<BankAccount> list, int low, int high) {
		int middle = (high + low + 1) / 2;
		tree.insert(list.get(middle));
		if (low != high) {
			buildBalancedTree(tree, list, (middle + high) / 2, high); //Inserts half of list into one side of the tree
			buildBalancedTree(tree, list, low, middle - 1);//Inserts second half of list into other side of the tree
		}
	}

	public Iterator<BankAccount> iterator(){
		return new FilteredBankAccountsIterator(this);
	}
	
}