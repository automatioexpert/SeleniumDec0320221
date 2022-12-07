package collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo1 {
	public static void main(String[] args) {
		HashSet hs = new HashSet();
		// HashSet hs=new HashSet(100);
		// HashSet hs=new HashSet(100, (float)0.90);
		// HashSet <Integer>hs=new HashSet(Integer);

		// add objects/elements into HashSet
		hs.add(100);
		hs.add("welcome");
		hs.add(16.4);
		hs.add('A');
		hs.add(true);
		hs.add(null);

		System.out.println(hs); // [null, A, 100, 16.4, welcome, true] insertion order not preserved

		// remove
		hs.remove(16.4); // value		
		System.out.println(" After removing element: "+hs);
		
		//contains
		hs.contains("welcome");
		System.out.println(hs.contains("welcome"));
		System.out.println(hs.contains("xyz"));
		
		System.out.println(hs.isEmpty()); //false
		
		//Reading objects/elements from hashset using for each loop
		for (Object e : hs) {
			System.out.println(e);			
		}
		
		Iterator it=hs.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());		
		}
	}
}