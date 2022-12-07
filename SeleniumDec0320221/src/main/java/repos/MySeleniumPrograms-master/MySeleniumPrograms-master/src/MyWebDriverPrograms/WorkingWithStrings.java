package MyWebDriverPrograms;

import java.util.Date;

public class WorkingWithStrings {

	public static void main(String[] args) {
		//Working with Strings
		String str1 = "Hello World";
		String str2 = "Learning Java";
		
		//Getting the length of the string1
		int len1 = str1.length();
		System.out.println("String1 length is :" +len1);
		
		//Getting length of string2
		int len2 = str2.length();
		System.out.println("String2 length is :" +len2);
		
		//Concatenation of Strings '+'
		String Total = str1 + " " + str2;
		System.out.println("Total :" +Total);
		
		//Covert to Upper and Lower case
		String Upper = str1.toUpperCase();
		String Lower = str2.toLowerCase();
		System.out.println(Upper);
		System.out.println(Lower);
		
		System.out.println(str1.equalsIgnoreCase(str2));
				
		//Position of the string by Index function and Substring - index starts from 0th position 
		int Num = str2.indexOf("Java");
		System.out.println("Num is :"+Num);
		String Position = str1.substring(3, 6);
		System.out.println(Position);
		
		String timestamp = String.valueOf(new Date().getTime());
		String Date = String.valueOf(new Date());
		String A = timestamp.substring(7);
		System.out.println("Date is :" +Date);
		System.out.println("Timestamp is :" +timestamp);
        System.out.println("A is :" +A);
				
	}

}
