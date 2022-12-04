package javasessions;

import java.util.Arrays;

public class ArrayConcept {

	public static void main(String[] args) {

		
		//array:
		//used to store multiple similar type of data/values
		//limitations:
		//1. size is fixed/static: to overcome this, we need to use dynamic array
		//2. stores only similar types of data: to overcome this, we use Object static array
		
		//1. int array:
		int a[] = new int[4];
		//li = 0
		//len = 4
		//hi = len-1 -> 3
		//len = hi+1--> 4
		
		a[0] = 10;
		a[1] = 20;
		a[2] = 30;
		a[3] = 40;
		//a[4] = 50;//ArrayIndexOutOfBoundsException
		
		System.out.println(a[0]);
		System.out.println(a[3]);
		//System.out.println(a[4]);//ArrayIndexOutOfBoundsException
		//System.out.println(a[-1]);

		System.out.println(a[0]+a[2]);
		System.out.println("---");

		System.out.println(a.length);//4
		int len = a.length;//4
		
		System.out.println("---");
		//to print all the values of array: index based for loop:
		for(int i=0; i<=len-1; i++) {
			System.out.println(a[i]);//10 20 30 40 
		}
		
		System.out.println("---");
		//for each loop: enhanced loop:
		for(int e : a) {
			System.out.println(e);
		}
		System.out.println("---");
		System.out.println(a);//hashcode number/address
		System.out.println(Arrays.toString(a));
		System.out.println("---");

		//2. double array:
		double d[] = new double[2];
		d[0]=12.33;
		d[1]=23.44;
		
		for(double e : d) {
			System.out.println(e);
		}
		System.out.println(Arrays.toString(d));
		
		//3. char array:
		char c[] = new char[3];
		c[0] = 'a';
		c[1] = 'b';
		c[2] = '1';
		System.out.println(c[0]+c[1]);
		System.out.println("---");

		//4. String array:
		String emp[] = new String[3];
		emp[0]="Pyush";
		emp[1]="Atif";
		emp[2]="Saurav";
		
		for(String e : emp) {
			System.out.println(e);
		}
		System.out.println(Arrays.toString(emp));

		System.out.println("---");

		//5. Object array: static
		Object st[] = new Object[5];
		st[0] = "Harshini";
		st[1] = 30;
		st[2] = 35.55;
		st[3] = 'f';
		st[4] = true;
		
		for(Object e : st) {
			System.out.println(e);
		}
		
		System.out.println("---");

		Object st1[] = new Object[6];
		st1[0] = "Asha";
		st1[1] = 32;
		st1[2] = 34.55;
		st1[3] = 'f';
		st1[4] = false;
		System.out.println(st1[5]);
		
		for(Object e : st1) {
			System.out.println(e);
		}
		System.out.println(Arrays.toString(st1));
		
		//default values:
		//int : 0
		//double: 0.0
		//boolean: false
		//char: space
		//String: null
		//Object: null
		
	}

}
