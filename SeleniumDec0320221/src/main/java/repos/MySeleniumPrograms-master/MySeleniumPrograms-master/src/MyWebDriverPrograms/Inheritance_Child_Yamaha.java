package MyWebDriverPrograms;

public class Inheritance_Child_Yamaha extends Inheritance_Parent_Bike {

	public static  void tyretype()
	{
		System.out.println("Tyres are MRF");
	}
	public static void main(String[] args) {
		
	@SuppressWarnings("unused")
	Inheritance_Child_Yamaha Yamaha = new Inheritance_Child_Yamaha();
      Inheritance_Parent_Bike.start();
      Inheritance_Parent_Bike.stop();
      tyretype();  
      

   //Dynamic polymorphism is a process in which a call to an overridden method (Method Overriding) is resolved at runtime, 
   //thats why it is called runtime polymorphism. 
      
      
   // Child Class Object can be reffered by Parent class reference variale--Dynamic Polymorphism(OR)Runtime Polymorphism(OR)Late Binding
   // Inheritance_Parent_Bike ---> Parent Class
   // RX100 ---> Parent Class reference variable
   // new Inheritance_Child_Yamaha() ----> Child Class Object
   // Top Casting
      Inheritance_Parent_Bike RX100 = new Inheritance_Child_Yamaha();
      System.out.println(RX100.WheelsCount);
      System.out.println(RX100.Name);
      RX100.Refuel();
      RX100.Model();
      stop();
      
	}

}
