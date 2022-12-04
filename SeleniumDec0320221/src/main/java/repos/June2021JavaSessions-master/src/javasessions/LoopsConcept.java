package javasessions;

public class LoopsConcept {

	public static void main(String[] args) {

		//1 to 10:
		//1. while:
		
		int i = 1;
		while(i<=10) {
			System.out.println(i);//1 2 3 4.....10 
			//i++;
			//++i;
			i=i+1;
		}
		
		//practical use cases: 
		//have to use when we are not sure about how many iterations are there...
		//1. we have to lazy loading..linkedin, FB scrolling
		//2. timeout operations: waiting for a webelement
		//3. handing multiple windows: window handler APIs: how many pop ups?
		
		int n = 1;
		while(n<=50) {
			System.out.println(n);
				if(n % 5 == 0) {
					System.out.println("Hi....");
				}
			n++;	
		}
		
		System.out.println("-----while with break----------");
		
		int num = 50;
		while(num<=100) {
			System.out.println(num);
			if(num == 50) {
				System.out.println("half century");
			}
			
			if(num == 100) {
				System.out.println("century");
			}
			
			if(num == 0) {
				System.out.println("duck...out");
				break;
			}
			num++;
		}
		
		System.out.println("-------");
		
		//for loop: 1 to 10:
		
		for(int k=1; k<=10; ) { //init, conditional, incremental/decr
			System.out.println(k);//1 2 3 4 ...10
			k++;
		}
		
		//
//		for(;;) {
//			System.out.println("Bye....");
//		}
		System.out.println("-------");

		//even numbers : 0 2 4 6 8 10....
		for(int even = 0; even<=10; ) {
			System.out.println(even);
			//even=even+2;
			even+=2;
		}
		
		//even numbers with %2==0
		//odd number with %2!=0
		
		//use cases:
		//we are sure about how many iterations we have to perform....
		//1. you have to iterate array, arraylist, collections which order based
		//2. total links on the page: you have to print the text of all links
		//3. footer/top links
		//4. ArrayList -- 10 links---> 
		//click on product link: if(text.quals("product") --> click and break
		
		System.out.println("--------");
		//for with if:
		int p = 1;
		for(;p<=10;p++) {
			System.out.println(p);
			if(p==2) {
				System.out.println("Hello....");
				break;
			}
		}
		
		//infinite loop: use case:
		//Taj Hotel--display--welcome to taj -- 24x7:
//		while(true) {
//			System.out.println("welcome to taj....");
//		}
		
//		while(true) {
//			//check the element is displayed or not...
//			//once its displayed -- break the loop
//			//thread.sleep(2);
//			//max time out = 20 secs --break;
//		}
		System.out.println("---------");
		
		//do-while loop:
		//webelement--> at least check this webelement on the page immediately...
		//if first time its available on the page....break the loop
		
		//land on the web page:
		//check if page is fully loaded...do loop
		//then WE ---while();
		int h = 1;
		do {
			System.out.println(h);//1
			h++;
		}
		while(h>=10);
		
		//for each
		//streams -- JDK 1.8: a. sequnce b. parallel --- use cases in selenium
		
		
		
		
	}

}
