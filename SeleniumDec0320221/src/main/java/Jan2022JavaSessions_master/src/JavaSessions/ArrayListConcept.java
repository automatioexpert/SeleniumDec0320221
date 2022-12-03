package JavaSessions;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListConcept {

	public static void main(String[] args) {

		//ArrayList -- default class in Java
		//dynamic array
		//order based/index based AL
		//collections
		
		ArrayList ar = new ArrayList();//vc = 10
		System.out.println(ar.size());//0--PC = 0
		
		ar.add(100);//0
		ar.add(200);//1
		
		System.out.println(ar.size());
		
		ar.add(300);//2
		ar.add(400);//3
		
		System.out.println(ar.size());

		ar.add(12.33);//4
		ar.add('h');//5
		ar.add(true);//6
		ar.add("testing");//7
		
		System.out.println(ar.size());
		
		System.out.println(ar.get(1));
		//li = 0
		//len = ar.size()--> PC = 8
		//hi = len - 1==> 7
		
		//System.out.println(ar.get(-1));//IOB
		//System.out.println(ar.get(8));//IOB
		
		System.out.println("--------");
		//to get all the values from array list:
		for(int i=0; i<ar.size(); i++) {
			System.out.println(ar.get(i));//100
		}
		
		System.out.println("--------");

		for(Object e : ar) {
			System.out.println(e);
		}
		
		System.out.println("--------");

		
		ArrayList ar1 = new ArrayList(20);
		System.out.println(ar1.size());

		//generics:
		
		ArrayList<Integer> marksList = new ArrayList<Integer>();
		marksList.add(100);
		marksList.add(200);
//		marksList.add("hello");
//		marksList.add(12.33);
		
		ArrayList<Object> empData = new ArrayList<Object>();
		empData.add("Tom");
		empData.add(25);
		empData.add('m');
		empData.add(12.33);
		empData.add(true);
		
		ArrayList<String> namesList = new ArrayList<String>();
		namesList.add("Tom");
		namesList.add("naveen");
		System.out.println(namesList.size());
		
		//
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(100);//0
		numbers.add(200);//1
		numbers.add(300);//2
		numbers.add(400);//3
		
		
		Collections.reverse(numbers);
		for(Integer e : numbers) {
			System.out.println(e);
		}
		//Conformiq
		
		
//		System.out.println(numbers.get(2));//300
//		System.out.println(numbers.size());//4
//		
//		numbers.remove(2);
//		System.out.println(numbers.get(2));
//		System.out.println(numbers.size());//3
		
		System.out.println(numbers.get(3));//400
		numbers.add(3, 500);
		System.out.println(numbers.get(3));//500
		
		
		int i[] = new int[4];
		i[2] = 10;
		System.out.println(i[2]);//10
		System.out.println(i[0]);//0
		
		int j[] = {1,2,3,4,5,6};//static array literals
		System.out.println(j.length);
		j[0] = 200;
		System.out.println(j[0]);
		
	}

}
