package MyWebDriverPrograms;

public class Inheritance_Parent_Bike {

	public double price = 12.12;
	public String Name = "Jay";
	public int WheelsCount = 5;

	// Static method can be called directly with method name OR with
	// 'Classname.Methodname'
	public static void start() {
		System.out.println("Bike will start automatically");
	}

	// Static methiod can be called directly with method name OR with
	// 'Classname.Methodname'
	public static void stop() {
		System.out.println("Bike will stop with the Remote");
	}

	// Non Static Method - Object is created for non-Static Method
	public void Refuel() {
		System.out.println("Bike will be Refueled");
	}

	// Non Static Method - Object is created for non-Static Method
	public void Model() {
		System.out.println("Bike Model is Yamaha");
	}

	public static void main(String[] args) {
		start();
		stop();
		
		
		// Inheritance_Parent_Bike ---> Parent Class
		// Obj ---> Parent Class reference variable
		// new Inheritance_Parent_Bike() ----> Object
		Inheritance_Parent_Bike Obj = new Inheritance_Parent_Bike();
		Obj.Refuel();// Non Static Method - Object is created for non-Static Method and called by
						// 'Referencevariable.Methodname'
		Obj.Model();// Non Static Method - Object is created for non-Static Method
					// 'Referencevariable.Methodname'
	}

}
