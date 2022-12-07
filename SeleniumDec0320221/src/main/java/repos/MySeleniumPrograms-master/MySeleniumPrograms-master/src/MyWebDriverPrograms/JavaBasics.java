package MyWebDriverPrograms;

public class JavaBasics {

       //     public static void main(String[] args) {  
		    // will be used for the comments
		    //print the value 
		    /* can used for mutliple line comments */
	  //      System.out.println("this is my first statement in java");
		    // variable declaration ( data types)
		    // int datatype is used to declare integers//
	   /*   int a=10;
		    int b=100;
		    // long datatype is used for larger numbers
		    long c=43456689;
		    char z='t';
		    String username="test123";
		    boolean result=true;
		    double f=12.34;
		    int x=a+b;
		    System.out.println("value of x is :"+ x);
		    a++; 
		    System.out.println("value of a increment :" + a); */ 
 
//--------------------------------------------------------------------------
	   
  /* public static void main(String[] args) {
	   
  int i = 2;
   
 switch (i)
  {
   case 1 :   System.out.println("Distinction");
   break;
   
   case 2 :   System.out.println("First Class");
   break;
   
   case 3 :   System.out.println("Pass");
   break;
   
   case 4 :   System.out.println("Fail");
   break;

   default:  System.out.println("Invalid grade");
  
  }		
 
 } */

//--------------------------------------------------------------------
//Java program to illustrate while loop
/* In Java While loop, condition is tested at the beginning of the loop 
 * and if the condition is True then only statements in that loop will be executed. 
 * So, While loop executes the code block only if the condition is True.
 * For this reason it is also called Entry control loop.
 */
	
 /* public static void main(String[] args) { 
{
     int x = 1;

    while (x<=3)
    {  
	System.out.println("Value of X is :" +x);
	
    x++;
    }
    
 
  } */
 
	
//----------------------------------------------------------------------------------

//Java program to illustrate for loop
/* A "For" statement consumes the initialization, condition and increment/decrement 
 * in one line thereby providing a shorter, easy to debug structure of looping.
 */
/*  public static void main(String[] args) {
 {

                for (int i = 0; i <=10; i++) 
	System.out.println("Value of I is :" + i);
	
 } */
	
//------------------------------------------------------------------------------------
//Java program to illustrate do-while loop
/* In Java Do While loop, condition is tested at the end of the loop 
 * so Do While executes the statements in the code block at least once 
 * even if the condition Fails.
 * do while: do while loop is similar to while loop with only difference that it checks 
 * for condition after executing the statements, 
 * and therefore is an example of Exit Control Loop.
 */
  public static void main(String[] args) {
  {
 
	 int i = 15;
	 do
	 {
        // The line will be printed even if the condition is false
		 System.out.println("Value of I is :" + i);
	 	 i++;
	 }
	 while (i <= 19);
 
  } 
	
 
 
 }
}
