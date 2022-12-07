import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class FindFirstAndSecondMaxNumbers {
	
	public static void main(String[] args) {
		
		Integer[] array= {10,20,30,10,30};
		TreeSet <Integer> s=new TreeSet<>(Arrays.asList(array));
		System.out.println("Max Element" +s.last());
		
		ArrayList<Integer> ar=new ArrayList<>(s);
		System.out.println("Second Max Element"+ ar.get(ar.size()-2));
	}
}