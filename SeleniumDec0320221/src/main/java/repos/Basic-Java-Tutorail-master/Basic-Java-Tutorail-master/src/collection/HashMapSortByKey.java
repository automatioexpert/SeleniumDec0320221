package collection;

import java.util.HashMap;
import java.util.TreeMap;

public class HashMapSortByKey {

	public static void main(String[] args) {
		
		HashMap<Integer, String> map=new HashMap<Integer, String>();
		map.put(50, "Alex");
		map.put(20, "Charles");
		map.put(60, "Brian");
		map.put(70, "Edwin");
		map.put(120, "George");
		map.put(10, "David");
		
		TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>(map);
		 
		System.out.println(treeMap);
	}

}
