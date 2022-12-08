package Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HashMaps {

	public static void main(String[] args) {
		
		//Creating Hashmap
		HashMap<Integer , String> hm = new HashMap<Integer ,String>();
		//Inserting Values
		
		hm.put(1, "AV");
		hm.put(2, "RT");
		hm.put(3, "Al");
		hm.put(4, "DP");
		
		//Printing Values
		
		System.out.println("Values are " + hm.get(2));
		
		//Printing using loop
		
		for(Entry e : hm.entrySet()) {
			
			System.out.println(hm);
		}

	}

}
