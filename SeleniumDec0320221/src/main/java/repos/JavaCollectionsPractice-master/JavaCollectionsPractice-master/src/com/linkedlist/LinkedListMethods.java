package com.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListMethods {

	public static void main(String[] args) {

		LinkedList<String> friends = new LinkedList<>();

		friends.add("Goraksh");
		friends.add("Mayur");
		friends.add("Neha");
		friends.add("Harshada");
		friends.add("Satish");

		System.out.println("Intial LinkedList is :: " + friends);

		friends.addFirst("Bhagyashri");
		friends.addLast("Kalyani");

		System.out.println("New linkedlist is :: " + friends);

		List<String> collegeFriends = new ArrayList<String>();
		collegeFriends.add("Prathamesh");
		collegeFriends.add("Chetan");

		friends.addAll(collegeFriends);
		System.out.println("All friends ::" + friends);

		friends.sort(Comparator.naturalOrder());
		System.out.println("sorted :: " + friends);

		Collections.sort(friends);
		System.out.println("sorted :: " + friends);

		System.out.println("for each");
		friends.forEach(name -> {
			System.out.println(name);
		});

		System.out.println("for loop");
		for (String name : friends) {
			System.out.println(name);
		}

		System.out.println("iterator");

		Iterator<String> iterator = friends.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		System.out.println("Search whether krishna is present");
		{
			if (friends.contains("Krishna")) {
				System.out.println("Present");
			} else {
				System.out.println("Not Present");
			}
		}
	}

}
