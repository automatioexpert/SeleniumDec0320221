import java.util.Arrays;
import java.util.TreeSet;

public class FindMinMaxInAnArray {
	
	public static void main(String[] args) {
		
		Integer[] array= {10,20,30,10,30};
		TreeSet <Integer> s=new TreeSet<>(Arrays.asList(array));
		System.out.println("Min Element"+s.first());
		System.out.println("Max Element"+s.last());
	}
}