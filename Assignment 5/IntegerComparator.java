/*---------------------------------------
 Genuine author: Nadav Shaked, I.D.: 312494925
 Date: 02-01-2019
---------------------------------------*/
import java.util.Comparator;

//This comparator is used for demonstrations in Test classes.
public class IntegerComparator implements Comparator<Integer>{

	public IntegerComparator() {
		super();
	}

	@Override
	public int compare(Integer number1, Integer number2) {
		return number1.compareTo(number2);
	}
}
