package object_Oriented_Programming;

public class ConstructorDefault {
	public static void main(String args[]){  
		//creating objects  
		ConstructorDefault s1=new ConstructorDefault();  
		ConstructorDefault s2=new ConstructorDefault();  
		//displaying values of the object  
		s1.display();  
		s2.display();  
		}  
	// Let us see another example of default constructor
	// which displays the default values
	int id;
	String name;

	// method to display the value of id and name      https://www.startimes.com/f.aspx?t=38448419
	void display() {
		System.out.println(id + " " + name);
	}
}
