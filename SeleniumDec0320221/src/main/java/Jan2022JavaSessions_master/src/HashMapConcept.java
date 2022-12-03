import java.util.HashMap;

public class HashMapConcept {

	public static void main(String[] args) {

		//<key, value> -- pair/segment
		//HashMap class - default -- implements Map (Interface)
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put(null, 60);

		map.put("Sandeep", 100);//3
		map.put("Manas", 90);//5
		map.put("Swapana", 95);//3
		map.put("Dhrumil", 80);
//		map.put(null, 50);
//		map.put("Naveen", null);
//		map.put("Tom", null);
//		map.put("Sandeep", 70);
//		map.put(null, null);
		map.put("Swapana", 95);//3
		map.put("Swapana11", 95);//3
		map.put("Swapana212", 95);//3
		map.put("Swapana2233", 95);//3
		map.put("Swapana11121", 95);//3
		
		System.out.println(map.get("Sandeep"));
		System.out.println(map.get("Swapana"));

//		System.out.println(map.get(null));
//		System.out.println(map.get("Naveen"));
//		System.out.println(map.get("Tom"));
		
		map.forEach((k,v) -> System.out.println(k + ":" +v));
		
		System.out.println("-------");
		
		HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
		mp.put(1, 100);		
		mp.put(11, 1100);
		mp.put(111, 11000);
		mp.put(2, 200);
		mp.put(22, 2200);
		
		mp.forEach((k,v) -> System.out.println(k+ ":" +v));



		
		
		
		
	}

}
