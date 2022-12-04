package javasessions;

public class LoopsConcept {

	public static void main(String[] args) {

		//1 to 10
		/**
		 * 
		 * loop (1 to 100){
		 * 
		 * create a user logic
		 * 
		 * }
		 * create a user1 logic
		 * create a user2 logic
		 * create a user3 logic

		 */
		
		//1. while loop:
		//1 to 10:
		int i = 1;
		while(i<=10) {
			System.out.println(i);//1 2 3 4 ....10
			//i++;
			//i=i+1;
			++i;
		}
		//use cases: when we are not sure about how many iterations we have to perform
		//page loading
		//web element is coming on the page after 10/20/25/5 secs
		//pagination: 1 2 3 4 5 6....100
		//waiting for the server to respond
		//Carousel handling
		
		
		//infinite loop:
		boolean flag = true;
		int num = 1;
		while(flag) {
			System.out.println("weclome to Taj Hotel - 24 x7");
			num++;
			if(num==6) {
				break;
			}
		}
		
		System.out.println("------------");
		//2. for loop:
		//1 to 10:
//		for(int k=1; k<=10; k++) {
//			System.out.println(k);//1 2 3 4 5 ....10
//		}
//		int k=1;
//		for(;k<=10; k++) {
//			System.out.println(k);//1 2 3 4 5 ....10
//		}
		
		//use cases: we have to use for loop when we know how many iterations we have to perform
		//1 to 10: array/arraylist
		//drop down: jan to dec (1 to 12)
		//calendar/date selection
		
		int k=1;
		for(;k<=10;) {
			System.out.println(k);//1 2 3 4 5 ....10
			k++;
		}
		
		System.out.println("-----------");
		//infinite loop:
//		for(;;) {
//			System.out.println("HEllo");
//		}
		
		System.out.println("-----------");
		for(double d=1.1; d<=10.5; ) {
			System.out.println(d);
			d = d + 0.1;
		}
		
		System.out.println("-----------");
		for(char c = 'a'; c<='z'; c++) {
			System.out.println(c + ":" + (int)c);
		}
		
		System.out.println("-----------");

		//1 3 5 7 9 odd numbers
		for(int odd=1; odd<=9; odd=odd+2) {
			System.out.println(odd);//1
		}
		
		//num % 2 ==0 -- even (0 2 4 6 8 10)
		//num % 2 ==1 -- odd (1 3 5 7 9)
		
		System.out.println("-----------");
		for(int l=1; l<=100; l++) {
			System.out.println(l);//1
				if(l % 5 ==0) {
					System.out.println("Hi");
				}
		}
		
		System.out.println("--------");
		//3. do-while loop:
		int p = 1;
		do {
			p++;
			System.out.println(p);//2....11
			//p++;//2
		} 
		while (p<=10);

	}

}
