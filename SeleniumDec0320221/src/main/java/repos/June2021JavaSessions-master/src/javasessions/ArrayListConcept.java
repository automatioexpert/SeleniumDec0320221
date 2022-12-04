package javasessions;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListConcept {

	public static void main(String[] args) {

		//ArrayList -- default class
		//need to create the object
		//collection --> index based/order based		
		
		ArrayList ar = new ArrayList();//10
		System.out.println(ar.size());

		ar.add(100);//0
		ar.add("testing");//1
		ar.add(12.33);//2
		
		System.out.println(ar.get(0));
		
		//li = 0
		//hi = s - 1; --> 2
		//s = ar.size()
		System.out.println(ar.size());
		
		ar.add(200);//3
		ar.add(300);//4
		
		System.out.println(ar.size());
		
		ar.add(400);//5
		ar.add(500);//6

		System.out.println(ar.size());
		
		System.out.println(ar.get(6));//500
	//	System.out.println(ar.get(7));//IndexOutOfBoundsException
	//	System.out.println(ar.get(-1));//IndexOutOfBoundsException
		//ArrayList ar1 = new ArrayList(5);

		//to print all the values of arraylist:
		for(int i=0; i<ar.size(); i++) {
			System.out.println(ar.get(i));
		}//n
		
		//for each:
		for(Object e : ar) {
			System.out.println(e);
		}//n
		
		//n+n = O(n)
		
		//Generics in ArrayList:
		ArrayList<String> names = new ArrayList<String>();
		names.add("Udita");
		names.add("Pavan");
		
		ArrayList<Integer> marks = new ArrayList<Integer>();
		marks.add(20);
		marks.add(30);
		marks.add(-65);
		
		ArrayList<Character> val = new ArrayList<Character>();

		//store product info --> String, double, boolean, String, int
		ArrayList<Object> productInfo = new ArrayList<Object>();
		productInfo.add("Macbook Pro");
		productInfo.add(4000);
		productInfo.add('t');
		productInfo.add("Neon enterprise");
		productInfo.add(4.5);
		
		for(Object e : productInfo) {
			System.out.println(e);
				if(e.equals("Neon enterprise")) {
					System.out.println("this seller is good....");
				}
		}
		
		//1. findelements() -- List
		//2. drop down--> arraylist
		//3. total number of advertisement pop ups--> ArrayList
		//4. total links --> arraylist
		//5. total images --> arraylist
		//6. Uber -- ArrayList
		
		System.out.println("score card......");
		ArrayList<Integer> scoreList = new ArrayList<Integer>();
		scoreList.add(1);//0
		scoreList.add(10);//1
		scoreList.add(20);//2
		scoreList.add(21);//3
		scoreList.add(5);//4
		scoreList.add(1, 500);
		
		System.out.println(scoreList.get(1));
		System.out.println(scoreList.get(2));

		System.out.println(scoreList.size());
//		scoreList.remove(3);
//		System.out.println(scoreList.get(3));
//		System.out.println(scoreList.size());

		System.out.println(scoreList);
		Collections.sort(scoreList);
		System.out.println(scoreList);

		
		
	}

}
