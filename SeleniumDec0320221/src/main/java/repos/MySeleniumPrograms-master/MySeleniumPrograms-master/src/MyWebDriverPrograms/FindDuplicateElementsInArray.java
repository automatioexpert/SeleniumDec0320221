package MyWebDriverPrograms;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateElementsInArray {

//Solution 1:-
/*	void printDuplicates(int arr[], int size) {
		int i, j;
		System.out.println("Duplicate Elements are :");
		for (i = 0; i < size; i++) {
			for (j = i + 1; j < size; j++) {
				if (arr[i] == arr[j])
					System.out.print(arr[i] + " ");
			}
		}
	}

	public static void main(String[] args) {
		FindDuplicateElementsInArray repeat = new FindDuplicateElementsInArray();
		int arr[] = { 4, 2, 4, 5, 2, 3, 1, 7, 8, 9, 5 };
		int arr_size = arr.length;
		System.out.println("arr_size:" + arr_size);
		repeat.printDuplicates(arr, arr_size);
	}
} */

//Solution 2:-// For finding Duplicate elements in String
/*public static void main(String[] args) {

	String Names[] = {"Java", "JavaScript", "RUBY", "C#", "C++", "Cobol", "Java", "ruby", ".Net", "Groovy", "C"};

	//1. Compare each element 0(nxn) - not a good solution
	     int i, j;
	 for (i = 0; i < Names.length; i++) {
		 for (j = i+1; j < Names.length; j++) {

			 if (Names[i].equalsIgnoreCase(Names[j])) {
				 System.out.println("Duplicate Element is : " +Names[i]);
			 }
		 }
	 }
   } */



//Solution 3:- For finding Duplicate elements in a Number Array
/*	 public static void main(String[] args) {

		 int Store[] = {1, 2, 3, 4, 5, 2, 0, 3, 6, 7, 8, 5, 9};

		 //1. Compare each element Not a good solution
		   int i, j;
		   for (i=0; i < Store.length; i++) {
			   for (j=i+1; j < Store.length; j++) {

				   if (Store[i]==(Store[j])) {

					   System.out.println("Duplicate Number in the Array is : " +Store[i]);
				   }
			   }
		   }
	 }	 */


//Solution 4 :- Find elements in Array using Hashset
// Using HashSet : Java Collection: It stores unique values : 0(n)	 --> Good Solution
	 public static void main(String[] args) {

		 String Names[] = {"Java", "JavaScript", "Ruby", "C#", "C++", "Cobol", "Java", ".Net", "Groovy", "C", "Ruby"};

		 Set<String> StringStore = new HashSet<String>();
		 System.out.println("Duplicate String Elements in the Array are :");
		 for (String Name : Names) {
			 if (StringStore.add(Name) == false) {
				 System.out.println( Name + " ");
			 }

		 }

		int Numbers[] = {1, 2, 3, 4, 5, 2, 0, 3, 6, 7, 8, 5, 9};

		Set<Integer> Numberlist = new HashSet<Integer>();
		System.out.println("Duplicate Numbers in the Array are : ");
		for (int Number : Numbers) {
			if ( Numberlist.add(Number) == false) {
				 System.out.println(Number + " ");
			}
		}


	 int Store[] = {7, 2, 0, 8, 9, 3, 6, 7, 8, 5, 9, 0, 6};

	 //1. Compare each element Not a good solution
	   int i, j;
	   System.out.println("Duplicate Numbers in the Array are : ");
	   for (i=0; i < Store.length; i++) {
		   for (j=i+1; j < Store.length; j++) {

			   if (Store[i]==(Store[j])) {

				   System.out.println(Store[i] + " ");
			   }
		   }
	   }
	 }

}
