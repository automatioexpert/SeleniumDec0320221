package collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

import array.ArrayList;

public class HashSetSort {

	public static void main(String[] args) {
		//Unsorted list
		HashSet<Integer> numbersSet = new LinkedHashSet<>( 
		        Arrays.asList(15, 11, 9, 55, 47, 18, 1123, 520, 366, 420) );
		 
		List<Integer> numbersList = new ArrayList<Integer>(numbersSet) ;        //set -> list
		 
		//Sort the list
		Collections.sort(numbersList);
		 
		numbersSet = new LinkedHashSet<>(numbersList);          //list -> set
		 
		//Print set to confirm
		System.out.println(numbersSet);

	}

}
