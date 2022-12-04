package javasessions;

import java.util.ArrayList;

public class ArrayListConcept {

	public static void main(String[] args) {

		//ArrayList : default class in java (JDK)
		//collections: dynamic array
		//order/index based arraylist
		
		//create the object of arraylist:
		
		ArrayList ar = new ArrayList();//vc = 10, pc = 0
		//defaukt vc = 10;
		
		//System.out.println(ar.get(0));//IOB
		System.out.println(ar.size());
		
		ar.add(100);//0
		ar.add(200);//1
		
		System.out.println(ar.size());
		
		ar.add(300);//2
		ar.add(400);//3
		
		System.out.println(ar.size());

		ar.add(500);//4
		ar.add(600);//5
		System.out.println(ar.size());

		System.out.println(ar.get(0));
		System.out.println(ar.get(5));
		//System.out.println(ar.get(6));//IOB
		//System.out.println(ar.get(-1));//IOB
		
		System.out.println("-----------");
		//
		ArrayList ar1 = new ArrayList(5);//vc = 5
		//vc=5
		ar1.add(100);//0
		ar1.add("testing");//1
		ar1.add('m');//2
		ar1.add(12.33);//3
		ar1.add(true);//4
		
		System.out.println(ar1.size());
		System.out.println(ar1);
		ar1.add(600);//5
		System.out.println(ar1.size());//6
		System.out.println(ar1);
		System.out.println("-----------");

		//to print all the vlaues from the arraylist: for loop:
		for(int i=0; i<ar1.size(); i++) {
			System.out.println(ar1.get(i));
		}
		
		//for each loop:
		
		//generics:
		ArrayList<Integer> marks = new ArrayList<Integer>();
		//vc = 10
		marks.add(10);
		System.out.println("-----------");

		ArrayList<String> namesList = new ArrayList<String>();//vc = 10
		namesList.add("Nidhi");//0
		namesList.add("Sachin");//1
		namesList.add("Saurabh");//2
		namesList.add("Pooja");//3
		System.out.println(namesList.size());
		System.out.println(namesList);
		System.out.println("-----------");

		//for each loop:
		for(String e : namesList) {
			System.out.println(e);
		}
		
		
		System.out.println("-----------");

		for(int i=0; i<namesList.size(); i++) {
				if(namesList.get(i).equals("Saurabh")) {
					System.out.println("100% bonus");
					System.out.println(namesList.get(i));
					break;
				}
			
			System.out.println(namesList.get(i));
		}
		System.out.println("-----------");

		//AR : store emp data: name(string), age(int), sal(double), isPerm(true), gender(char)
		//
		ArrayList<Object> empDataList = new ArrayList<Object>();
		empDataList.add("Tom");//0
		empDataList.add(20);//1
		empDataList.add(12.33);//2
		empDataList.add(true);//3
		empDataList.add('m');//4
		
		System.out.println(empDataList.size());
		for(int k=0; k<empDataList.size(); k++) {
			System.out.println(empDataList.get(k));
		}
		
		//
		for(Object e : empDataList) {
			System.out.println(e);
		}
		
		//
		ArrayList<String> empList = new ArrayList<String>();//vc = 10
		empList.add("Nidhi");//0
		empList.add("Sachin");//1
		empList.add("Saurabh");//2
		empList.add("Pooja");//3
		empList.add("Tom");
		empList.add("Peter");
		
		for(String e : empList) {
			System.out.println(e);
				if(e.equals("Pooja")) {
					System.out.println("50 % bonus");
					break;
				}
		}
		
		
	}

}
