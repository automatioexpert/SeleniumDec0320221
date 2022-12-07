package homework;

public class primitive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Virgina");
		
		//Datatype,name of variable=value
		int a=20;
		int b=6;
		int c=10;
		System.out.println("The value for integer c is:"+c);
		
		boolean d=true;
		System.out.println("The value for boolean (true or Flase) u is: "+d);
		
		long e=6000000L;
		System.out.println("The value for long l is:"+e);
		
		float f=8.8f;
		System.out.println("The value for float f is:"+f);
        
		double g=88.888888666;
		System.out.println("The value for double d is:"+g);
		
		//Arithmetic Operations
		int x=45;
		int y=25;
		//Addition 
		int h=x+y;
		System.out.println("The value for addition h is:"+h);
		//Subtraction 
		int i=x-y;
		System.out.println("The value for subtraction i is:"+i);
		//Division
		int l=x/y;
		System.out.println("The value for division l is:"+l);
		//Multiplication
		int m=x*y;
		System.out.println("The value for multiplication m is:"+m);
		//Percentage
		int n=x%y;
		System.out.println("The value for percentage n is:"+n);
		
		//And & OR operator
		int r=6;
		int s=6;
		int z=r+s;
		boolean p=(r==s)&&(z==r)&&(s==z);
		System.out.println("The value for AND orpeation is:"+p);
		
		boolean q=(r==s)||(z==r)||(s==z);
		System.out.println("The value for OR orpeation is :"+q);	
	}

}
