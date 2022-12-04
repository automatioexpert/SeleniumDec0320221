package javasessions;

public class TimeComplexity {

	public static void main(String[] args) {

		//O(n) - BIG O
		
		int i = 1; //O(1): constant time
		
		int j = 1;
		System.out.println(i+j);
		
		//1 to 10: loop: O(N)
		for(int p=1; p<=10; p++) {
			System.out.println(p);
		}
		
		//1+n+n+n => 3n+1 (Linear Eq) --> 3n -> n -> O(n)
		//O(3n+1) --> 
		
		System.out.println("-----");
		//nested for loop:
		for(int m = 0; m<=5; m++) {
			for(int n = 0; n<=5; n++) {
				System.out.print(m+""+n+" ");
				//00 01 02 03 04 05
				//10 11 12 13 14 15
				//20 21 22 23 24 25				
			}
			System.out.println();
		}
		
		//(1+n+n+n)(1+n+n+n) --> (1+3n)(1+3n)=> 1+3n+3n+9n^2 => 1+6n+9n^2
		//9n^2+6n+1 (quadratic eq)--> 9n^2+6n ==> 3n(3n+2)=> 3n(3n)=> 9n^2==> O(n^2)
		
		for(int m = 0; m<=5; m++) {
			for(int n = 0; n<=5; n++) {
				for(int q=0; q<=5; q++) {
					System.out.print(m+""+n+""+q+" ");
				}
			}
			System.out.println();
		}
		//(1+n)(1+n)(1+n)==> n^3+n2+n+1
		
		
	}

}
