package TimeComplexity;

public class TC {

	public static void main(String[] args) {

		int i = 10;
		System.out.println(i);

		// TC: Big O --> O(1)--constant time

		// 1 to 10:
		for (int p = 1; p <= 10; p++) {
			System.out.println(p);
		}
		// 1+n+n+n => 1+3n=> 3n+1 ==> Linear Equation
		// 3n => O(n)

		
		for (int p = 1; p <= 10; p++) {
			for (int q = 1; q <= 10; q++) {
				System.out.println(p + "" + q);
				int l = 10+p+q;
			}
		}
		//(1+n+n)(1+n+n+n)==> (1+2n)(1+3n)==> 1+3n+2n+6n^2==> 6n^2+5n+1==>Qudratic Eq
		//6n^2+5n==> n(6n+5)==> 6n^2==> O(n^2)
		
		for (int p = 1; p <= 10; p++) {
			for (int q = 1; q <= 10; q++) {
				for(int r=1; r<=10; r++) {
					System.out.println(p + "" + q+ ""+r);
				}
			}
		}
		//(1+n+n)(1+n+n)(1+n+n+n)==> (1+2n)(1+2n)(1+3n)=> 12n^3==> O(n^3)

	}

}
