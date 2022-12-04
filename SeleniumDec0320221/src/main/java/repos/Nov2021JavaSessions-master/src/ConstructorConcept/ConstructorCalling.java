package ConstructorConcept;

import java.util.Scanner;

public class ConstructorCalling {

	String name;//naveen-->tom
	int age;
	double salary;

	public ConstructorCalling(String name) {
		this.name = name;
	}

	public ConstructorCalling(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public ConstructorCalling(String name, int age, double salary) {
		this("naveen");
		//this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public ConstructorCalling(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public static void main(String[] args) {
		ConstructorCalling obj = new ConstructorCalling("Tom", 20, 23.33);
		System.out.println(obj.name);
	}

}
