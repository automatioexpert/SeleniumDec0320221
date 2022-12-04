package JavaSessions;


public class LoopsConcept {

	public static void main(String[] args) {

		
		//1 to 10:
		//1. while loop:
		
		int i = 1;
		while(i<=10) {
			System.out.println(i);//1 2 3 4 5 ...10
			i++;
			//++i;
			//i=i+1;
		}
		
		System.out.println("--------");
		
		int k = 1;
		while(k<=100) {
			System.out.println(k);
			if(k % 5 == 0) {
				System.out.println("hiiii");
				break;
			}
			k++;
		}
		
		//use cases of while loop:
		//1. you have to use while loop when number of iterations are not fixed
		//2. waiting for the element on the page
		//3. waiting for the page to be loaded
		//4. pagination : 1 2 3 4 5 6 ....11..20
		
		System.out.println("--------");

//		while(true) {
//			System.out.println("welcome to TAJ HOTEL");
//		}
		
		//2. for loop:
		//1 to 10:
//		for(int j = 1; j<=10; ++j) {
//			System.out.println(j);//12345...10
//		}
		
		int j = 1;
		for( ;j<=10; ) {
			System.out.println(j);//12345...10
			++j;
		}
		
		System.out.println("---10 to 1-----");

		for(int l=10; l>=1; l--) {
			System.out.println(l);//10 9
		}
		
		System.out.println("--------");

//		for(; ;) {
//			System.out.println("Hello");
//			//break;
//		}
		
		//use cases of for loop:
		//1. use for loop when number of iterations are fixed
		//2. drop down traversing
		//3. menu items of the page
		//4. calendar handling
		
		
		//3. do-while loop:
		int p = 1;
		do {
			p++;
			System.out.println(p);//1 2 3 4 ...10 11
		}
		while(p<=10);
		
		//4. for each
		//5. streams
		
		System.out.println("----");
		//
		//00 01 02 03 04
		//10 11 12 13 14
		//20 21 22 23 24
		
		for(int l=0; l<=9;l++) {
			for(int m=0; m<=9; m++) {
				System.out.print(l+""+m+" ");
			}
			System.out.println();
		}
		
		
		String s = new String("java");//2
		String s1 = "hello";//1
		String s2 = "hello";//0
		String s3 = new String("hello");//1

		System.out.println(s1==s2);
		System.out.println(s3 == s1);
		System.out.println(s3.equals(s1));
		System.out.println(s1.equals(s2));
		
		
		
	}

}
