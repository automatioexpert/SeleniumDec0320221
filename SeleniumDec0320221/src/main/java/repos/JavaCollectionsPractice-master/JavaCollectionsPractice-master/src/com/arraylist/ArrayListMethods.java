package com.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListMethods {

	public static void main(String args[]) {

		// initialize arraylist
		List<String> companies = new ArrayList<>();

		// add data in arraylist
		companies.add("Google");
		companies.add("Amazon");
		companies.add("Walmart");
		companies.add("Facebook");

		System.out.println("List of Companies is :: " + companies);
		// add data at given index in list
		companies.add(4, "Cognizant");

		System.out.println("New List :: " + companies);

		// change data at particular data
		companies.set(4, "Tibco");

		System.out.println("Modified list :: ");
		for (String company : companies) {
			System.out.println(company);
		}
		
		Iterator<String> iterator = companies.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().equalsIgnoreCase("Google")) {
				iterator.remove();
			}
		}

		System.out.println("Modified list :: " + companies);

		Collections.sort(companies);

		System.out.println("Sorted list is :: " + companies);

	}

}
