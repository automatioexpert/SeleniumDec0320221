package OOP_Inheritance;

public class TestCar {

	public static void main(String[] args) {

		BMW b = new BMW();
		b.start();// overridden
		b.stop();// inherited
		b.refuel();// inherited
		b.autoParking();// individual
		b.engine();
		System.out.println(b.speed);
		BMW.run();
		b.aeroDynamic();

		System.out.println("-----");

		Car c = new Car();
		c.start();
		c.stop();
		c.refuel();
		c.engine();
		Car.run();
		c.aeroDynamic();

		System.out.println("-----");
		Audi a = new Audi();
		a.theftSafety();
		a.start();
		a.stop();
		a.refuel();
		a.engine();

		System.out.println("----------");
		Automobile au = new Automobile();
		au.aeroDynamic();

		System.out.println("-----");
		Truck t = new Truck();
		t.heavyLoading();

		System.out.println("-----");

		// Top casting
		Car c1 = new BMW();// child class object can be referred by parent class ref variable
		c1.start();
		c1.stop();
		c1.refuel();
		c1.engine();

		Vehicle c2 = new BMW();// child class object can be referred by Grand parent class ref variable
		Automobile c3 = new BMW();
		
		c2.aeroDynamic();
		c2.engine();

		// down casting: at RunTime -- it will throw ClassCastException
		 //BMW b1 = (BMW) new Car();
		// BMW b2 = (BMW) new Vehicle();

	}

}
