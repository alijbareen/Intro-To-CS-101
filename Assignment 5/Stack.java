/*---------------------------------------
 Genuine author: Nadav Shaked, I.D.: 312494925
 Date: 02-01-2019
---------------------------------------*/
public interface Stack<T> {
	
	//Returns true iff this stack is empty.
	public boolean isEmpty();
	
	//Removes the object at the top of this stack and returns that object.
	public T pop();
	
	//Pushes an item onto the top of this stack.
	public void push(T element);

}
