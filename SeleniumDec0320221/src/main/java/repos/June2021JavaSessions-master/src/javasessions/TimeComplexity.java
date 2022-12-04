package javasessions;

public class TimeComplexity {

	public static void main(String[] args) {
		
		
		int j = 10; //O(1) 
		System.out.println(j);
		
		//Time Complexity: Big O(N) --> N = 1;
		
		for(int i=1; i<=10; i++) {
			System.out.println(i);
		}
		
		//1.2.3.4.5....10 --> O(N) --> O(100) ==>  O(N) 
		
		//1+n+n+n => 1+3n => 3n+1 => 3n => n => O(n)  --Linear Equation
		
		for(int p=1; p<=5; p++) {
			for(int r=1; r<=5; r++) {
				System.out.print(p+""+r + " "); //11 12 13 14 15
			}
			System.out.println();
		}
		
		//(1+n+n+n)(1+n+n+n) => (1+3n)(1+3n) => 1+3n+3n+9n^2 ==> 9n^2+6n+1 => 9n^2+6n => 3(3n^2+2n)
		//==> 3n^2+2n ==> n(3n+2)=> 3n^2 ==> n^2 ==> O(n^2) ==> Qudratic eq.
		
		
		for(int p=1; p<=5; p++) {
			for(int r=1; r<=5; r++) {
				for(int q=1; q<=5; q++) {
					System.out.print(p+""+r + ""+q+" "); 
				}
			}
			System.out.println();
		}
		
		//nxnxn => n^3 ==> O(n^3)
		//Binary Search: divide two parts ==> N/2 ==> N/4 ==> N/8 ==> O(logN)

	}

}
