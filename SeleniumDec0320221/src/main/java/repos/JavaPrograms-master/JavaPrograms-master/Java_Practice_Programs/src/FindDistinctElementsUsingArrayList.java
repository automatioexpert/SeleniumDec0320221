import java.util.ArrayList;

public class FindDistinctElementsUsingArrayList {

	public static void main(String a[]) {
	  int[] numbers = {1, 1, 2, 1, 3, 4, 5};
	    ArrayList<Integer> store = new ArrayList<Integer>(); // so the size can vary

	    for (int n = 0; n < numbers.length; n++){
	        if (!store.contains(numbers[n])){ // if numbers[n] is not in store, then add it
	            store.add(numbers[n]);
	        }
	    }
	    numbers = new int[store.size()];
	    for (int n = 0; n < store.size(); n++){
	        System.out.println(store.get(n));
	        
	    }
	}
	
}
