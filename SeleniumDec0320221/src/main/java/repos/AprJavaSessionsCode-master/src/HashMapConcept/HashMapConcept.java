package HashMapConcept;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapConcept {

	public static void main(String[] args) {

		// key-value pair format: <k,v>
		// does not maintain the order

		// HashMap<String, Integer> empMap = new HashMap<String, Integer>();

		//Map<String, Integer> empMap = new HashMap<String, Integer>();
		//Map<String, Integer> empMap = new LinkedHashMap<String, Integer>();
		Map<String, Integer> empMap = new TreeMap<String, Integer>();

		empMap.put("Tom", 100);
		empMap.put("Peter", 200);
		empMap.put("Lisa", 300);
		empMap.put("Ravi", 600);
		empMap.put("Naveen", 600);
		// empMap.put("Naveen", 200);
		//empMap.put(null, 500);
		//empMap.put(null, 600);
		empMap.put("a", 900);
		empMap.put("A", 9000);
		empMap.put("pavan", 300);
		empMap.put("test", 90);
		empMap.put("1", 5);
		empMap.put("$", 50);


		// System.out.println(empMap.get("Naveen"));

		empMap.forEach((k, v) -> System.out.println(k + ":" + v));

	}

}
