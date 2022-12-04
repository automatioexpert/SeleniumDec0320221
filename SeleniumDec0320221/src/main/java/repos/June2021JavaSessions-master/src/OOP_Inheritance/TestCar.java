package OOP_Inheritance;

import java.util.ArrayList;

public class TestCar {


	public static void main(String[] args) {
		
		final int i = 10;//constant variable
		
		final int days = 7;
		System.out.println(days * 100);

		BMW b = new BMW();
		b.start();//overriden
		b.stop();//inherited from P
		b.refuel();//inherited
		b.autoParking();//Individual
		b.engine();//inherited from GP
		b.airBags();
		System.out.println(b.price);
		
		BMW.testing();
		Car.testing();
		
		
		Car c = new Car();
		c.start();
		c.stop();
		c.refuel();

		//top/up casting:
		Car c1 = new BMW();//child class object can be referred by parent class ref variable
		c1.start();
		c1.stop();
		c1.refuel();
		//c1.autoParking();//-->ref type check
		
		Car c2 = new BMW();
		((BMW)c2).autoParking();
		
		//child class object can be referred by grant parent class ref variable
		Vehicle v1 = new BMW();
		v1.airBags();
		v1.engine();
		

		//down casting: parent class object can be referred by child class ref varibale
		//BMW b1 = (BMW)new Car();//ClassCastException at run time
		
		//BMW b2 = (BMW)new Vehicle();
		
		
		
	}

}
