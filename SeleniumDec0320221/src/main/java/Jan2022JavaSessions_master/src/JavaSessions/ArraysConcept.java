package JavaSessions;

public class ArraysConcept {

	public static void main(String[] args) {

		//limitations of array:
		//1. size is fixed: static array: to overcome this, we need to use dynamic array(ArrayList)
		//2. stores only similar types of data: we can use Object array (static)
		
		//1. int array:
		int i[] = new int[4];
		i[0] = 10;
		i[1] = 20;
		i[2] = 30;
		i[3] = 40;
		//i[4] = 50;//ArrayIndexOutOfBoundsException
		
		System.out.println(i[0]);
		System.out.println(i.length);
		
		int li = 0;
		int len = i.length;
		int hi = len-1;
		System.out.println(li);
		System.out.println(len);
		System.out.println(hi);
		
		System.out.println(i[3]+i[0]);
		//System.out.println(i[4]);//ArrayIndexOutOfBoundsException
		//System.out.println(i[-1]);//ArrayIndexOutOfBoundsException
		System.out.println("-------");
		
		//how to fecth the values from array: for loop:
		for(int k=0; k<i.length; k++) {
			System.out.println(i[k]);//10 20 30 40 
		}
		System.out.println("-------");
		
		//for each loop:
		for(int e : i) {
			System.out.println(e);
				if(e==30) {
					System.out.println("hiiii");
					break;
				}
		}
		

		System.out.println("-------");

		//2. double:
		double d[] = new double[2];
		d[0] = 12.33;
		d[1] = 23.33;
		System.out.println(d[0]+d[1]);
		
		//char:
		char c[] = new char[3];
		c[0] = 'a';
		c[1] = '1';
		c[2] = '$';
		
		//
		int a[] = new int[10];
		a[5] = 10;
		System.out.println(a[0]);//0
		
		//String:
		String s[] = new String[3];
		s[0] = "Java";
		s[1] = "Python";
		s[2] = "JS";
		System.out.println(s[0]);
		
		for(String n : s) {
			System.out.println(n);
		}
		System.out.println("------");
		for(int p=s.length-1; p>=0; p-- ) {
			System.out.println(s[p]);
		}
		
		System.out.println("------");
		for(char b='a'; b<='z'; b++) {
			System.out.println((int)b);
		}
		
		System.out.println("------");

		//emp data: String, int, double, boolean, char
		//Object Array: static array:
		Object emp[] = new Object[5];
		emp[0] = "Tom";
		emp[1] = 30;
		emp[2] = 23.33;
		emp[3] = true;
		emp[4] = 'm';
		emp[5] = "01-01-1990";//AIOB
		
		for(Object e : emp) {
			System.out.println(e);
				
		}
		
		for(int n=0; n<emp.length; n++) {
			System.out.println(emp[n]);
//				if(emp[n] == 30) {
//					
//				}
		}
		
		
	}

}
