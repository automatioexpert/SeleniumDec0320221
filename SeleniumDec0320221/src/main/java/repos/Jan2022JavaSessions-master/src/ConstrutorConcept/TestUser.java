package ConstrutorConcept;

import java.util.ArrayList;
import java.util.Arrays;

public class TestUser {

	public static void main(String a[]) {

//		System.out.println(a.length);
//		System.out.println(a[0]);//AIOB

		ArrayList<String> tomList = new ArrayList<String>();
		tomList.add("iph12");
		tomList.add("iph13");
		tomList.add("imac");

		User u1 = new User("Tom", 25, tomList);

		System.out.println(u1.name);
		System.out.println(u1.age);
		System.out.println(u1.deviceList);

		String orders[] = { "samsung 10, macbook pro", "shoes" };
		System.out.println(Arrays.toString(orders));
		System.out.println(tomList);

		User u2 = new User("Tom", 30, tomList, orders);
		System.out.println(u2.name);
		System.out.println(u2.age);
		System.out.println(u2.deviceList);
		System.out.println(Arrays.toString(u2.orders));

		// Person p = new Person();
		Person.getMail();

		String s = new String("Automation");
		System.out.println(s); // Automation
		s = s + "Selenium"; // AutomationSelenium
		System.out.println(s);// AutomationSelenium

		EmployeeD ed = new EmployeeD();
		ed.setAge(25);
		ed.setName("tom");
		// String info = ed.getEmployeeInfo();
		ed.getEmployeeInfo().getName();
		ed.getEmployeeInfo().getAge();
		System.out.println(ed.getName());

	}

}
