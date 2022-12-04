package javasessions;

public class PersonTest {

	public static void main(String[] args) {

		Persons p1 = new Persons("Tom", 20);
		System.out.println(p1.name);
		System.out.println(p1.age);
		System.out.println(p1.city);
		
		Persons p2 = new Persons("Peter", 25, "NY");
		System.out.println(p2.name);
		System.out.println(p2.age);
		System.out.println(p2.city);
		
		CarBooking b1 = new CarBooking("sedan", "bangalore", "pune");
		b1.booking();
		
		CarBooking b2 = new CarBooking();
		b2.booking();
		
		CarBooking b3 = new CarBooking("mini", "dest1", "dest2");
		b3.booking();
	}

}
