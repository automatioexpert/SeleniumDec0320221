package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.w3c.dom.ls.LSOutput;

import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//HashMap m=new HashMap();
		HashMap<Integer, String> m=new HashMap<Integer, String>();
		
		m.put(101, "John");
		m.put(102, "David");
		m.put(103, "Scott");
		m.put(104, "Mary");
		m.put(105, "Tye");
		m.put(106, "David");
		
		m.put(103, "X");
		System.out.println(m); // {101=John, 102=David, 103=Scott, 104=Mary, 105=Tye}
		
		System.out.println(m.get(105)); // return the value of the key 105  Tye
		
		System.out.println(m.remove(106)); //remove pair from hashmap
		
		System.out.println(m.containsKey(101)); //true
		System.out.println(m.containsKey(106));  //false
		
		System.out.println(m.containsValue("Mary")); //true
		System.out.println(m.containsValue("Y"));  //false
		
		m.isEmpty(); //should return false
		System.out.println(m.keySet());  //return all the keys as set  [101, 102, 103, 104, 105]
		System.out.println(m.values());  //return all the values as collection [John, David, X, Mary, Tye]
		
		System.out.println(m.entrySet()); //returns all the entries as Set [101=John, 102=David, 103=X, 104=Mary, 105=Tye, 106=David]
		
		for (Object k:m.keySet()) {
			System.out.println(k);
		}
		
		for (Object v:m.values()) {
			System.out.println(v);
		}
		
		//
		for (Object kv : m.keySet()) {
			System.out.println(kv+"    "+m.get(kv));
		}

		//Entry methods
		for (Map.Entry entry :m.entrySet()) {
			System.out.println(entry.getKey() +" "+ entry.getValue());
		}

		//iterator
		Set s=m.entrySet();
		Iterator itr=s.iterator();
		while (itr.hasNext()) {
			Map.Entry entry=(Entry) itr.next();
		    System.out.println(entry.getKey() +""+entry.getValue());
		}
	}
}
