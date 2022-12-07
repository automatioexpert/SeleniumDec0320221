package com.linkedhashset;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class FindoutUniqueWordswithInsertionOrder {

	public static void main(String[] args) {

		String sentence = "Krishna Krishna Shivram Majgaonkar Majgaonkar Majgaonkar 1 1 1 0 10 krishna Shivram";

		String[] arr = sentence.split("\\s+");
		List<String> list = Arrays.asList(arr);
		LinkedHashSet<String> set = new LinkedHashSet<String>(list);

		System.out.println(set);
	}

}
