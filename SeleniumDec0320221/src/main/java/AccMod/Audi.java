package AccMod;

import AccessModifier.Car;

public class Audi extends Car{

	public static void main(String[] args) {

		Audi a = new Audi();
		a.name = "test";
		a.color = "red";
		System.out.println(a.name);
		System.out.println(a.color);
		
		
	}

}
