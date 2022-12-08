package NewPrac;

public class objectref {
	
	String colour;
	String good;

	public static void main(String[] args) {
		
		
		objectref a = new objectref();
		objectref b = new objectref();
		
		a.colour = "Blue";
		a.good = "N";
		b.colour = "Black";
		
		b.good = "Y";
		
		System.out.println(b.good);
		
		System.out.println("The colour of car a is >>>>>>>>"+ a.colour);
		
		
	}
	
	
	}




