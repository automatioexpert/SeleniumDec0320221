package javasessions;

import java.util.HashMap;
import java.util.Map;

public class HashMapConcept {

	public static void main(String[] args) {

		//array
		//araylist
		//hashmap
		//linkedhashmap
		//treemap
		
		//stores with key-value pair
		//HashMap(c) implememts Map(I)
		HashMap<String, String> empMap = new HashMap<String, String>();
		
		empMap.put("tom", "SDET1");
		empMap.put("peter", "SDET2");
		empMap.put("lisa", "SDET3");
		empMap.put("naveen", "QA");
		empMap.put(null, "QA1");//0
		empMap.put("peter", "SDET4");
		empMap.put(null, "QA2");//0
				
		System.out.println(empMap.get("peter"));
		System.out.println(empMap.get(null));
		
		//print all the values from hashap:
		//System.out.println(empMap);
		
		for(Map.Entry element : empMap.entrySet()) {
			System.out.println(element.getKey() + ":" + element.getValue());
		}
		
		//
		//jdk1.8: can use lambda:
		empMap.forEach((k,v) -> System.out.println(k+":"+v));
		
		HashMap<Integer, String> numMap = new HashMap<Integer, String>();
		numMap.put(1, "A");
		numMap.put(2, "B");
		
		
		
	}

}
