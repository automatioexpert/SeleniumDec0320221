package OOP_Inheritance;

public class TestCar {

	public static void main(String[] args) {

		BMW b = new BMW();
		b.start();//overridden
		b.stop();//inherited
		b.refuel();//inherited
		b.autoParking();//individual
		b.engine();//inherited
		b.name = "520d";
		System.out.println(b.name);
		System.out.println(Car.wheels);
		System.out.println(BMW.wheels);
		//System.out.println(b.wheels);
		
		BMW.price();
		Car.price();
		
		Audi au = new Audi();
		au.start();
		au.stop();
		au.refuel();
		au.engine();
		au.theftSafety();
		
		Car c = new Car();
		c.start();
		c.stop();
		c.refuel();
		c.engine();

		//Top Casting:
		//child class object can be referred by parent class reference variable
		Car c1 = new BMW();
		c1.start();
		c1.stop();
		c1.refuel();
		c1.engine();
		
		//child class object can be referred by grand parent class reference variable
		Vehicle v1 = new BMW();
		v1.engine();
		
		
		//down casting:
		//parent class object can be referred by child class reference variable
		//BMW b1 = (BMW)new Car();//ClassCastException
		
		BMW b2 = (BMW)new Vehicle();//ClassCastException
		
	}

}
