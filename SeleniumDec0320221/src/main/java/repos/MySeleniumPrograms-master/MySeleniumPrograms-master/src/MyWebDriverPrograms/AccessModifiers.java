package MyWebDriverPrograms;

public class AccessModifiers {

	//Access Modifiers
	int i =10; // This is default access modifier and it is accessed within the class and only entire package but not other packages.
	private int j = 100; // Accessed only within that particular class
	public int c  = 1000; // Accessed everywhere in all classes and packages
	protected int d = 23;//Accessed within the class and within the package and only on the child class from other packages.

	public static void main(String[] args) throws Throwable {
		AccessModifiers obj = new AccessModifiers();
         obj.start();

         // finalize() Method is Called by the garbage collector on an object when garbage collection determines
         // that there are no more references to the object.A subclass overrides the
         // finalize method to dispose of system resources or to perform cleanup process on an Object.
         obj.finalize();


         obj.refuel();
         obj.stop();
         System.out.println(obj.j);
         System.out.println(obj.d);

	   }

	 public void start() {
		   System.out.println("Car -- Start");
	   }

	   public void stop() {
		   System.out.println("Car -- Stop");
	   }

	   public void refuel() {
		   System.out.println("Car -- refuel");
	   }

}
