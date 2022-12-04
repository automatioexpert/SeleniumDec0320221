package javasessions;

import java.util.ArrayList;

public class ArrayListConcept {

	public static void main(String[] args) {
		// collection
		// ArrayList -- default class
		// dynamic array

		// object of arraylist:
		ArrayList ar = new ArrayList();// vc = 10
		System.out.println(ar.size());

		ar.add(100);// 0
		ar.add(200);// 1
		System.out.println(ar.size());// 2

		ar.add("tom");// 2
		ar.add('m');// 3
		System.out.println(ar.size());// 4

		// li = 0
		// hi = 3
		// len/size = hi+1 = 4

		ar.add(300);// 4
		System.out.println(ar.size());// 5

		System.out.println(ar.get(0));// 100
		// System.out.println(ar.get(-1));//IndexOutOfBoundsException
		// System.out.println(ar.get(5));//IndexOutOfBoundsException

		ArrayList ar1 = new ArrayList(20);// vc = 20
		ArrayList ar2 = new ArrayList(5);// vc = 5
		ar2.add(100);// 0
		ar2.add(100);// 1
		ar2.add(null);// 2
		ar2.add(null);// 3

		System.out.println(ar2.size());
		System.out.println(ar2.get(1));
		System.out.println(ar2.get(2));
		System.out.println(ar2.get(3));// null
		ar2.add(4, 200);
		// ar2.add(9,1000);//IndexOutOfBoundsException
		System.out.println(ar2.get(4));
		// System.out.println(ar2.get(9));//IndexOutOfBoundsException

		ar2.add(3, 1100);
		System.out.println(ar2.get(3));//

		ArrayList prod = new ArrayList();
		prod.add("A");// 0
		prod.add("B");// 1
		prod.add("C");// 2
		prod.add("D");// 3
		prod.add("E");// 4

		System.out.println(prod.size());// 5
		System.out.println(prod.get(3));// D
		prod.remove(3);
		System.out.println(prod.size());// 4
		System.out.println(prod.get(3));//

		// int arraylist:
		ArrayList<Integer> marks = new ArrayList<Integer>();
		marks.add(100);

		ArrayList<Double> sal = new ArrayList<Double>();

		System.out.println("-----");

		ArrayList<String> empList = new ArrayList<String>();
		empList.add("Tom");
		empList.add("Naveen");
		empList.add("Naveen");
		empList.add("Naveen");

		System.out.println(empList);

		System.out.println("-----");

		for (String e : empList) {
			System.out.println(e);
		}

		// name, age, gender, sal, boolean
		// Object ArrayList:
		ArrayList<Object> empData = new ArrayList<Object>();
		empData.add("Tom");// 0
		empData.add(30);// 1
		empData.add('m');// 2
		empData.add(12.33);// 3
		empData.add(true);// 4

		// to print all the values from AL:
		for (int i = 0; i < empData.size(); i++) {
			System.out.println(empData.get(i));
		}
		System.out.println("-----");
		// for each:
		for (Object e : empData) {
			System.out.println(e);
			if (e.equals('m')) {
				System.out.println("male employee");
			}
		}

		System.out.println(empData);

	}

}
