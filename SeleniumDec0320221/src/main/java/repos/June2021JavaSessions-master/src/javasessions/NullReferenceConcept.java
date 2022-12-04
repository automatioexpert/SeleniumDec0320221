package javasessions;

public class NullReferenceConcept {

	String name;
	int age;

	public static void main(String[] args) {

		NullReferenceConcept obj = new NullReferenceConcept();
		System.out.println(obj.age);
		
		obj.name = "Sachin";
		obj.age = 20;

		obj = null;//null reference//no reference

		System.out.println(obj.name);// NPE
		

	}

}
