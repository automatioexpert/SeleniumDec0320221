import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindingAllDuplicateElementsInArray {

	public static void main(String[] args) {
		String[] array= {"10","20","30","10","30"};
		List <String> st= new ArrayList<>(Arrays.asList(array));
		Set <String> s=new HashSet<>();
		for(int i=0;i<array.length;i++)
		{
			if((Collections.frequency(st, array[i]))>1)
			{
				s.add(array[i]);
			}
		}
		for(String i:s) {
		System.out.println(i);
		}
	}
}
