import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindfirstrepeatedElementUsingArrayList {

	public static void main(String a[]) {
	  int[] numbers = {1, 2, 2, 4, 3, 4, 5};
	    List<Integer> store = new ArrayList<>();

	    for (int n = 0; n < numbers.length; n++){
	        if (!store.contains(numbers[n])){
	            store.add(numbers[n]);
	          
	        }
	        else
	        {
	        	 System.out.println(numbers[n]);
		           break;
	        }
	    }
	}
	
}
