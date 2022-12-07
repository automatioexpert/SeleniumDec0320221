package com.hashset;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HashSetMethods {

	public static void main(String[] args) {

		Set<String> hashSet = new HashSet<>();

		String sentence = "Krishna shivram shivram   Majgaonkar is studying studying";
		String[] arr = sentence.split("\\s+");
		System.out.println(arr.length);
		List<String> arrList = Arrays.asList(arr);
		hashSet.add("One");
		hashSet.add("two");
		hashSet.add("One");
		hashSet.add("three");
		hashSet.add("Three");
		hashSet.add("Four");
		hashSet.add("Five");
		hashSet.add(null);

		System.out.println(hashSet);
		hashSet.addAll(arrList);

		System.out.println(hashSet);

		Iterator<String> iterator = hashSet.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		hashSet.forEach(data -> {
			System.out.println(data);
		});
	}
}
