package com.treeset;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class TreeSetMethods {

	public static void main(String[] args) {
		String sentence = "Krishna Krishna Shivram Majgaonkar Majgaonkar Majgaonkar 1 1 1 0 10 krishna Shivram";

		String[] arr = sentence.split("\\s+");
		List<String> list = Arrays.asList(arr);
		TreeSet<String> set = new TreeSet<String>(list);

		System.out.println(set);
		System.out.println(set.descendingSet());

		Iterator<String> reverseIterator = set.descendingIterator();
		while (reverseIterator.hasNext()) {
			System.out.println(reverseIterator.next());
		}
	}
}
