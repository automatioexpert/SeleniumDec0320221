package MyWebDriverPrograms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromAList {

	public static void main(String[] args) {
       
		 Set<Integer> list = new HashSet<Integer>(); 
	     list.addAll(Arrays.asList(new Integer[] {1, 3, 2, 4, 4, 2, 5, 6, 7, 8, 9, 8, 6, 7, 6, 1}));
	        
		System.out.println("List After Removing Duplcates is : " + list);
	}
	
}