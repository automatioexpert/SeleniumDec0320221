package collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapSortByValue {

	public static void main(String[] args) {
		HashMap<Integer, String> unSortedMap = new HashMap<Integer, String>();
        
		unSortedMap.put(50, "Alex");
		unSortedMap.put(20, "Charles");
		unSortedMap.put(60, "Brian");
		unSortedMap.put(70, "Edwin");
		unSortedMap.put(120, "George");
		unSortedMap.put(10, "David");
		
		//LinkedHashMap preserve the ordering of elements in which they are inserted
		LinkedHashMap<Integer, String> sortedMap = new LinkedHashMap<Integer, String>();
		
		unSortedMap.entrySet()
		.stream()
	    .sorted(Map.Entry.comparingByValue())
	    .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
		
		System.out.println(sortedMap);

	}

}
