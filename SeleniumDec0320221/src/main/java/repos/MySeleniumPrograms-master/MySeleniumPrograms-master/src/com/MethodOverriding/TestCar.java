package com.MethodOverriding;

public class TestCar {

	public static void main(String[] args) {
		
		BMW obj = new BMW();
		obj.start();
		obj.stop();
		obj.Musicsystem();
		obj.theftsafety();
		obj.refuel();
		System.out.println(obj.i); 
	
		System.out.println("********************************************"); 
		
		Car car = new Car();
		car.start();
		car.stop();
		car.refuel();
		System.out.println(obj.c); 
		
		
		System.out.println("********************************************"); 
		
		//Runtime Polymorphism (OR) Dynamic polymorphism (OR) Late Binding :-
		//-------------------------------------------------------------------
		// Dynamic polymorphism is a process in which a call to an overridden method is resolved at runtime, 
		// thats why it is called runtime polymorphism. In the example below it is the 'CAR.start() Method'.
		// BMW Child class start() Method is executed instead of the Parent class 'Car' start() Method.
		
        //Child class object can be reffered by Parent class reference variable -- Dynamic Polymorphism (OR) Runtime Polymorphism
        // This is also called 'Top Casting'.
		Car CAR = new BMW();
		CAR.start();
		CAR.refuel();
		CAR.refuel();
		System.out.println(obj.d); 
		
	}

}
