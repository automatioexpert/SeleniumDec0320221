package com.MethodOverriding;

public class BMW extends Car{
	
	// When same method is present in Parent class as well as in Child class with the same name and same number of arguments
	// Prefence will be given to the child class method .This is called Method Overriding.
	// In our example below the method is start() 
	
	public void start() {// Overridden method
		 System.out.println("BMW -- This is BMW Start");
	}

	public void theftsafety() {
		System.out.println("BMW -- theftsafety");
		 System.out.println(i); 
	}
	
	public void Musicsystem() { 
		System.out.println("BMW -- First Class Music System");
		 System.out.println(d); 
	}
}
