package OOP_Inheritance;

public class TestCar {

	public static void main(String[] args) {

		BMW b = new BMW();
		b.start();// overridden
		b.stop();// inherited
		b.refuel();// inherited
		b.autoParking();// individual
		b.engine();

		BMW.speed();
		Car.speed();

		Car c = new Car();
		c.start();
		c.stop();
		c.refuel();
		c.engine();

		// child class object can be referred by parent class ref variable
		// top casting
		Car c1 = new BMW();
		c1.start();
		c1.stop();
		c1.refuel();
		// c1.autoParking();//ref type check

		// child class object can be referred by grand parent class ref variable
		Vehicle v1 = new BMW();
		v1.engine();

		// down casting:
//		BMW b1 = (BMW)new Car();//ClassCastException
//		b1.start();

		// BMW b2 = (BMW)new Vehicle();//ClassCastException

		Audi a = new Audi();
		a.stop();
		a.start();
		a.refuel();
		a.theftSafety();
		a.engine();

	}

}
