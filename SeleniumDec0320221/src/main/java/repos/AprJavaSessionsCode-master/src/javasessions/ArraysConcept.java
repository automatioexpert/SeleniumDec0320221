package javasessions;

import java.util.Arrays;

public class ArraysConcept {

	public static void main(String[] args) {
		//two limitations of array:
		//1. size is fixed: static array: to overcome this problem, we use dynamic array (ArrayList)
		//2. similar types of data: to overcome this problem, we can use Object Array(static)
		
		
		//Array Literals: static array
		int m1[] = {1,2,3,10,20,30,40,12};//len=8, hi = 7, li = 0
		System.out.println(m1.length);//8
		System.out.println(m1[0]);
		System.out.println(m1[m1.length-1]);//m1[8-1]
		
		System.out.println("----------");
		
		int i[] = new int[4];
		
		int li = 0;
		int hi = 3;
		int len = i.length;
		System.out.println("length = " + len);
		System.out.println("hi = " + (len-1));
		System.out.println("li = " + 0);
		
		i[0] = 10;
		i[1] = 20;
		i[2] = 30;
		i[3] = 40;
		
		System.out.println(i[0]);
		System.out.println(i[3]);
		System.out.println(i[0]+i[2]);
		//System.out.println(i[4]);//AIOB
		//System.out.println(i[-1]);//AIOB
		

		int k[] = new int[3];
		k[0] = 100;
		k[2] = 300;
		//k[3] = 400;//AIOB
		System.out.println(k[0]);
		System.out.println(k[1]);
		System.out.println(k[2]);
		System.out.println(Arrays.toString(k));
		
		System.out.println("--------");
		//
		int marks[] = new int[4];
		marks[0] = 100;
		marks[1] = 200;
		marks[2] = 300;
		marks[3] = 400;
		System.out.println("--------");
		//for each loop:
		for(int e : marks) {
			System.out.println(e);
		}
		System.out.println("--------");

		//to print all the values from the array: for loop
		for(int p=0; p<=marks.length-1; p++) {
			System.out.println(marks[p]);
		}
		
		System.out.println(Arrays.toString(marks));
		
		System.out.println(marks[3]);
		
		//byte:
		byte b[] = new byte[3];
		short s[] = new short[5];
		
		//double array:
		double d[] = new double[2];
		d[0] = 12.33;
		d[1] = 23.44;
		System.out.println(Arrays.toString(d));
		
		//String array:
		String emp[] = new String[5];
		emp[0] = "Chetan";
		emp[1] = "Ravi";
		emp[2] = "Tom";
		emp[3] = "Peter";
		emp[4] = "Vinitha";
		
		for(int t=0; t<=emp.length-1; t++) {
				if(emp[t].equals("Tom")) {
					System.out.println("Hi....");
					break;
				}
			System.out.println(emp[t]);
		}

		System.out.println(Arrays.toString(emp));
		
		
		//Object array: static array
		Object data[] = new Object[5];
		data[0] = "Tom";
		data[1] = 25;
		data[2] = 45.55;
		//data[3] = 'm';
		data[4] = true;
		
		for(Object e : data) {
			System.out.println(e);
		}
		
		for(int m=0; m<=data.length-1; m++) {
			System.out.println(data[m]);
		}
		System.out.println(Arrays.toString(data));
		
		
	}

}
