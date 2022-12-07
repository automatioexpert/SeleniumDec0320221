import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class First_Repeated_Char {

	public static void main(String[] args) {
		Character[] array= {'a','b','c','b','c'};
		  ArrayList<Character> store = new ArrayList<Character>(Arrays.asList(array));
		  for (int n = 0; n < array.length; n++){
		        if (Collections.frequency(store, array[n])>1){ 
		        	System.out.println(array[n]);
		        	break;
		        }
	}	
	}
}