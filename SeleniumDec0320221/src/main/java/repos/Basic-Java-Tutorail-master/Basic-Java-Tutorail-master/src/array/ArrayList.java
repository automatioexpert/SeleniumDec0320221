package array;
import java.util.List;

public class ArrayList {

	public static void main(String[] args) {
		
		//ArrayList <String> List = new ArrayList <String>();
		//ArrayList <Integer> al=new ArrayList<Integer>();
		//List al=new ArrayList();
		
		ArrayList List = new ArrayList();
		// We can use any data type
		List.add(987654321);
		// Here i am passing next two values as "STM" just to show you that List allows duplicate values.. 
		// Set wont allow duplicate values.
		// Adding elements to the array list
		List.add("STM");
		List.add("STM");
		List.add(99.99);
		// To get all the values from the list
		System.out.println(List);
		// To get a value whose index is 1
		System.out.println(List.get(1));
	}

}
