package practice_Java_2;

public class TriabgleShape {
	public static void main(String [] args){ 
	//System.out.println("Pyramid pattern of star in Java : ");
	printTriagle();
	} 

	   //Function to demonstrate printing pattern 
		public static void printTriagle() {
			for (int i = 0; i < 5; i++) {
	            for (int j = 0; j < 5 - i; j++) {
	                System.out.print(" ");
	            }
	            for (int k = 0; k <= i; k++) {
	                System.out.print("* ");
	            }
	            System.out.println();
	            }
	   }
	
	} 