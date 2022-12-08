package LinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListPrac {

	public static void main(String[] args) {
		
		//Creating Linked list
		LinkedList<String> ll = new LinkedList<String>();
		
		//Adding values
		ll.add("R");
		ll.add("a");
		ll.add("j");
		ll.add("i");
		ll.add("t");
		
		//Adding values in specific index
		
		ll.add(0, "AA");
		
		System.out.println("Linked list elements are>>>>> " + ll);
		
		//Removing Vaues in specific index
		
		ll.remove(0);
		System.out.println("After removal of index 0>>> " + ll);
		
		//Get And Set
		
	String First = 	ll.getFirst();
	System.out.println("Getting First>>>>>>>>>>>>>>>>>>>> " + First);
	
	System.out.println("Getting at index>>>>>>"  + ll.get(4));
	
	ll.set(0, "av");
	System.out.println("After setting 0th element >>>>> " + ll);
		
System.out.println("*****************************************************************************************");	

		//For loop

		for(int i = 0 ; i< ll.size() ; i++) {
			
			System.out.println("For loop result is >>>> " + ll.get(i));
		}
		//iterator
		
		Iterator<String> it = ll.iterator();
		//while loop
		
		while(it.hasNext()) {
			
			System.out.println("Iteratorwith while loop printing        " + it.next());
			
		}
		
		//Advance for loop
		
		for(String St : ll) {
			
			System.out.println("Advance for loop result is>>>>>>>    " + St);
		}

	}

}
