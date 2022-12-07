package com.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapMethods {

	public static void main(String[] args) {

		Map<Integer, String> numbermapping = new HashMap<Integer, String>();
		numbermapping.put(0, "Zero");
		numbermapping.put(1, "One");
		numbermapping.put(2, "Two");
		numbermapping.put(3, "Three");
		numbermapping.put(4, "Four");

		numbermapping.putIfAbsent(4, "four");
		numbermapping.putIfAbsent(5, "Five");

		System.out.println(numbermapping);

		System.out.println("Value of number 1 is " + numbermapping.get(1));

		if (numbermapping.containsKey(6)) {
			System.out.println("Value of number 6 is " + numbermapping.get(6));
		} else
			numbermapping.put(6, "Six");

		System.out.println(numbermapping);
	}
}
