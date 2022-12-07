package com.MethodOverriding;

public class Car {
	//Access Modifiers
	int i =10; // This is default access modifier and it is accessed within the class and entire package and not other packages.
	private int j = 100; // Access only within that particular class
	public int c  = 1000; // Accessed everywhere in all claases and packages
	protected int d = 23;//Accessed within the class and within the package and only on the child class from other packages.
	
	// METHOD OVERRIDING:-
	//--------------------
	// When same method is present in Parent class as well as in Child class with the same name and same number of arguments
	// Prefence on execution will be given to the child class method .This is called 'METHOD OVERRIDING'.
	// In our example below the method is start() 
	
	 // 'Method Overriding' is an example of Runtime Polymorphism (OR) Dynamic polymorphism (OR) Late Binding :-
     // Dynamic polymorphism is a process in which a call to an overridden method is resolved at runtime, 
     // thats why it is called runtime polymorphism. In the example below it is the 'CAR.start() Method'.
	 // BMW Child class start() Method is executed instead of the Parent class 'Car' start() Method.
	 
	 // Inheritance is involved in Method Overriding.
	 //Child class object can be reffered by Parent class reference variable.
	 // This is also called 'Top Casting'.
	 

   public void start() { // Overriding method
	   System.out.println("Car -- Start");
	   System.out.println(j); 
   }

   public void stop() {
	   System.out.println("Car -- Stop");
   }
   
   public void refuel() {
	   System.out.println("Car -- refuel");
   }
}
