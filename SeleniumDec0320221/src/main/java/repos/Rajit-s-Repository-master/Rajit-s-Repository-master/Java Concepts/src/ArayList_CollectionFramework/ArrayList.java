package ArayList_CollectionFramework;

import java.util.Iterator;

public class ArrayList {

	public static void main(String[] args) {
		
		//Creating an ArrayList
		
		java.util.ArrayList arr = new java.util.ArrayList();
		//inserting values in arraylist.
		
		
		arr.add("Name"); 		//Adding String
		
		arr.add("55");			//	Adding int
		arr.add("334");
		
		arr.add("55");			//Adding Same value
		
		arr.add(true);			//Adding boolean;
		
		//printing the values
		
		for(int i = 0 ; i<arr.size(); i++) {
			
			System.out.println(i);			//only array index  printed
			
			System.out.println(arr.get(i)); 	//printing array value
		}
		
		
		
		
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>");
		
		
		//Creating the objects of Employeedetails class
		
		EmployeeDetails emp1 = new EmployeeDetails("Ram", 27, "QA");
		EmployeeDetails emp2 = new EmployeeDetails("Haru", 34, "Dev");
		EmployeeDetails emp3 = new EmployeeDetails("Chn", 33, "Admin");
		EmployeeDetails emp4 = new EmployeeDetails("Kelo", 35, "HR");
		
		//Storing the value in Arraylist
		
		//Creating the ArrayList and making it generic to the employee details class.
		// Now the array list will store the variables of type employeedetails class
		// java .util is not necessary. I did because it was showing an error while parameterizing the aaraylist.
		
		java.util.ArrayList<EmployeeDetails> ar = new java.util.ArrayList<EmployeeDetails>();
		ar.add(emp1);
		ar.add(emp2);
		ar.add(emp3);
		ar.add(emp4);
		
		// Iterating the values
		//We'll use the iterator now to traverse the values n order to use all the values from ar.
		
		Iterator<EmployeeDetails> it = ar.iterator();
		while(it.hasNext()) {
			
			EmployeeDetails ed = it.next();
			System.out.println("It Printing>>>>  " + it);
			System.out.println(ed.empname + "      " + ed.age + "      " + ed.dept);
			
			
		}
		
		
		
		
		System.out.println("*****************************************************************************");
		//My own
		
		
		//Creating object References of the class
		ProductDetails  pd1 = new ProductDetails("vit", "Red", 44);
		ProductDetails  pd2 = new ProductDetails("Kit","Blue", 48);
		
		//Creating the ArrayList         Making it generic to the product details class.
		java.util.ArrayList<ProductDetails> al = new java.util.ArrayList<ProductDetails>();
		
		//Adding Values in Arraylist
		al.add(pd1);
		al.add(pd2);
		
		Iterator itr = al.iterator();
		
		//Creating the loop
		
		while(itr.hasNext()) {
			
			ProductDetails v = (ProductDetails) itr.next();
			System.out.println(v.prodname + "     " + v.size + "         " + v.clr);
			
		}
		
		
		
		

	}

}
