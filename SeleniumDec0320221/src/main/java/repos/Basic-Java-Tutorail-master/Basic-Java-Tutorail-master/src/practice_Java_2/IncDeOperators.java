package practice_Java_2;

public class IncDeOperators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		//Increment Decrement operators
		int a=10;
		/*a++;
		System.out.println();
		
		int b=3;
		b--;
		System.out.println("The value of b :"+b);
		
		int n=a++;
		System.out.println("The value of a: "+a);
		System.out.println("The value of n: "+n);
		
		//if statement
		int x=6;
		if (x==6){
			System.out.println("The value of x is positve: "+x);
		}
		
		//if else statement
		if (x % 2 == 0){
			System.out.println("The value x is even: "+x);
		}else {
			System.out.println("The value x is odd: "+x);
		}
		
		int h=100;
		if (h<100 && h==101){
			System.out.println("This conditons is true with AND and the value of h is: "+h);
		  }else{
			  System.out.println("This conditons is false with AND and the value of h is: "+h);
		   }
		    if (h<100 || h==100){			
		    System.out.println("The condition is true with OR and the value of h is: "+h);
		     }else{
			System.out.println("This condition is false with OR and the value of h is: "+h);
		    }
	
		
		float prg=6.8f;
		if (prg>=90 && prg<100){
			System.out.println("Grade of the student : A");
		}else if (prg>=80 && prg<=89){
			System.out.println("Grade of the student : B");
		}else if(prg>=70 && prg<=79){
			System.out.println("Grade of the student : C");
		}else if(prg>=60 && prg<=69){
			System.out.println("Grade of the student : D");
		}else if (prg>=50 && prg<=59){
			System.out.println("Grade of the student : E");
		}else {
			System.out.println("Please try again");
		}
		
		//find the largest number
		int t=1000;
		int r=6000;
		int i=6660000;
		 if(t>r){
			 if (t>i){
				 System.out.println("The Larger Number is t: "+t);
			 }else {
				 System.out.println("The Larger Number is i: "+i);
			 }
		 }else if (r>i){
			 System.out.println("The Larger Number is r: "+r);
		   }else{
			 System.out.println("The Larger Number is i: "+i);
		   }   
	 
		 //While statement
		int z=10;
		while (z<=15){
			System.out.println(z + ", ");
			z +=2; //add 2 to z
		}
		System.out.println("Who do we appteciate");
		
		int c=1;
		while (c<=10){
			System.out.println("The value of c: " +c);
			++c;
		}
		//do...while statement
		do{
			System.out.println("Print the value of A wiht do while loop: " +c);
			c++;
		}while(c<=10);
		
		
		//for statement
		for (int j=1; j<=10;j++){
			System.out.println("The loop =" +j);
			}*/
		IncDeOperators obj=new IncDeOperators();
		obj.profit(10000, 88);
		
				
		addition(); //call the new method addition to be executed
		int jan= obj.profit(55800,55800);
		int fev= obj.profit(6000,5000);
		int mar= obj.profit(9000,5500);
		int total= jan+fev+mar;
		System.out.println("The toatl profit is:" +total);
		}
	
	public static void addition(){
		int a=60;
		int t=26;
		int c=a+t;
		System.out.println("The value of :" +c);
	}
	
	public int profit(int income, int expense){
		int netprofit=income-expense;
		System.out.println("Profit of the company is: " +netprofit);
		return netprofit;
	}
}
