package collection;

import java.util.HashSet;

public class HashSetDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> set1 = new HashSet<Integer>();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		set1.add(5);		
		System.out.println("HashSet 1: " + set1); //HashSet 1: [1, 2, 3, 4, 5]

		HashSet<Integer> set2 = new HashSet<Integer>();
		set2.add(3);
		set2.add(4);
		System.out.println("New HashSet 2: "+set2); //New HashSet 2: [3, 4]
		
		set1.addAll(set2);
		System.out.println("Union HashSet: "+set1); //Union HashSet: [1, 2, 3, 4, 5]
		
		set1.retainAll(set2);
		System.out.println("Intersection HashSet: "+set1); //Intersection HashSet: [3, 4]
		
		//set1.removeAll(set2);
		//System.out.println("Difference HashSet: "+set1); //Intersection HashSet: [1, 2]
		
		set1.containsAll(set2);
		System.out.println(set1.containsAll(set2));
		System.out.println("Subset HashSet: "+set1); //Subset HashSet: [1, 2, 3, 4, 5]
		
	}
}
