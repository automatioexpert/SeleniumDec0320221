package javasessions;

public class LoopsConceptTest {

	public static void main(String[] args) {

		//1 to 10:
		//1. while loop:
		int i = 1;
		while(i<=10) {
			System.out.println(i);//1 2 3 4 5 .....10
			i++;
			//++i;
			//i=i+2;
		}
		
//		boolean flag = false;
//		while(!flag) {
//			System.out.println("welcome to taj hotel -- 24 x7 hrs");
//		}
		//use cases:
		//1. number of iterations are not fixed: use while loop
		//2. page load time out
		//3. wait for the element on the page
		//4. calendar : 
		//5. pagination: < 1 2 3 4   10 > ---> 
		//6. lazy loading of the page: 
		
		System.out.println("------------");
		//2. for loop:
		//1 to 10:
		for(int j=1; j<=10; ) {
			System.out.println(j);//1 2 3 4 5 ....10
			//j++;
			//++j;
			j=j+2;
		}
		
		System.out.println("------------");

//		for(;;) {
//			System.out.println("bye");
//		}
		
		for(byte b=1; b<=10; b++) {
			System.out.println(b);
		}
		
		System.out.println("------------");

		for(double d = 1.1; d<=10.1; d++) {
			System.out.println(d);
		}
		
		System.out.println("-----a to z-------");
		//a : 97
		//b : 98
		for(char c = 'a'; c<='z'; c++) {
			System.out.println(c+" : "+(int)c);
		}
		//use cases:
		//1. number of iterations are fixed
		//2. drop down --> month - 12: 
		//3. menu items --> 
		//4. arrays and arraylist: 
		
		//3. do-while loop:
		// 1 to 10:
		int p = 1;
		do {
			p++;
			System.out.println(p);//234567891011
		}
		while(p<=10);
		//use cases:
		//1. web element check on the page first time -- if its not there--> then start the loop
		
		//for each
		//java 8 streams
				
		
	}

}
