package com.hashmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapEntryKeySetValuesExample {

	public static void main(String[] args) {

		HashMap<String, String> countryISOMapping = new HashMap<String, String>();
		countryISOMapping.put("India", "IN");
		countryISOMapping.put("United States of America", "US");
		countryISOMapping.put("Russia", "RU");
		countryISOMapping.put("Germany", "DE");
		countryISOMapping.put("China", "CN");

		Set<Entry<String, String>> countryEntrySet = countryISOMapping.entrySet();
		System.out.println("ISO Country entries " + countryEntrySet);

		Set<String> countries = countryISOMapping.keySet();
		System.out.println("List of Countries " + countries);

		Collection<String> isoCodes = countryISOMapping.values();
		System.out.println("ISO Codes are " + isoCodes);

	}
}
