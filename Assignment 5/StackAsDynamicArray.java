/*---------------------------------------
 Genuine author: Nadav Shaked, I.D.: 312494925
 Date: 02-01-2019
---------------------------------------*/
import java.util.NoSuchElementException;

public class StackAsDynamicArray<T> implements Stack<T>{

	private List<T> array;
	
	public StackAsDynamicArray() {
		this.array = new DynamicArray<T>();
	}
	
	public boolean isEmpty() {
		return array.isEmpty();
	}
	
	public T pop(){
		if(isEmpty())
			throw new NoSuchElementException();
		return array.remove(array.size()-1);
	}
		
	public void push(T element){
		array.add(element);		
	}
}
