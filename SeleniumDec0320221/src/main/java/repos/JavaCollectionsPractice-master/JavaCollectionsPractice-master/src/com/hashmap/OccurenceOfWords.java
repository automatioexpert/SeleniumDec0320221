package com.hashmap;

import java.util.LinkedHashMap;

public class OccurenceOfWords {

	public static void main(String[] args) {
		String str = "Krishna Krishna Majgaonkar Hi world Krishna Hi team";
		String[] arr = str.split(" ");
		LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
		for (String s : arr) {
			if (map.containsKey(s)) {
				map.put(s, map.get(s) + 1);
			} else {
				map.put(s, 1);
			}
		}
		System.out.println(map);

	}

}
