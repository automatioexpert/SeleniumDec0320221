package BuilderPattern;

import ABC.Employee;

public class TestEmp {

	public static void main(String[] args) {

		
		Employee e =new Employee();
		e.name = "Tom";
		
		String test = "this is java code test java";
		int i = test.lastIndexOf('t');
		System.out.println(i);
		
		int k = test.lastIndexOf("java");
		System.out.println(k);
		
		test.lastIndexOf('t', 9);
		
	}

}
