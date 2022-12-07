package com.MethodOverLoading;

public class MethodOverloading {

	// Compile time Polymorphism (OR) Static polymorphism (OR) Early Binding:-
	//------------------------------------------------------------------------
	// Polymorphism that is resolved during compiler time is known as static polymorphism.
	// Method overloading is an example of compile time polymorphism.
	// Here in the example below we have 6 definitions of the same method "sum()" which 'sum method' would be called is determined 
    // by the parameter list at the compile time. That is the reason this is also known as compile time polymorphism.

  
	// Method OverLoading -
	// --------------------
	//Method Overloading: When the Method name is same with different signatures OR arguments OR input parameters 
	//within the same class.
	//The input parameters of methods are different in number, sequence and data types of parameters. 

	// You cannot create a method inside a method
	// Duplicate Methods -- i.e Same method name with same number of arguments are not allowed

	public static void main(String args[]) { // Main method can be yes ofcourse can be Overloaded

		MethodOverloading obj = new MethodOverloading();
		obj.sum();
		obj.sum(10);
		obj.sum("Peter", 123456789);
		obj.sum(10, 20);
		obj.sum("Jay", 12.22, 5);
		obj.sum(10.25, "B", "A", 22);
	}

	public void sum() { // 0 input param
		System.out.println("Sum Method -- Zero input param");
	}

	public void sum(int i) { // 1 input param
		System.out.println("Sum Method -- 1 input param");
		System.out.println("i is :" + i);
	}

	public void sum(String i, long j) { // 2 input param with String and long
		System.out.println("Sum Method -- 2 input param with String and Long variables");
		System.out.println("i is :" + i);
		System.out.println("j is :" + j);
	}

	public void sum(int i, int j) { // 2 input param
		System.out.println("Sum Method -- 2 input param");
		System.out.println("i is :" + i);
		System.out.println("j is :" + j);
	}

	public void sum(String i, double j, int k) { // 3 input param
		System.out.println("Sum Method -- 3 input param");
		System.out.println("i is :" + i);
		System.out.println("j is :" + j);
		System.out.println("k is :" + k);
	}

	public void sum(double i, String j, String k, int l) {
		System.out.println("Sum Method - 4 input param");
		System.out.println("i is :" + i);
		System.out.println("j is :" + j);
		System.out.println("k is :" + k);
		System.out.println("L is :" + l);
	}

}
