package seleniumsessions;

public class MixWait {

	public static void main(String[] args) {

		//imp wait - 10 secs -- global wait
		
		//exp wait -- ele - 15 secs
		
		//never mix imp wait and exp wait:
		//badly impact the performance of the script coz of cumulative wait will be applied
		
		//ele -- imp wait      exp wait    total time
		//e1  -- 0             2              2
		//e1 --  5			   0              5
		//e1 --- 0 				15			 15
		//e1 --  10 			15 			 25
		//e1 -   8 				12			20	
		
		
		
		
		
		
		
	}

}
