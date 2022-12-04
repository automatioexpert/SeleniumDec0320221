package javasessions;

public class IncrementAndDecrementalOperators {

	public static void main(String[] args) {

		//1. post increment:
		int i = 1;
		int j = i++;
		System.out.println(i+","+j);
		System.out.println(i);//2
		System.out.println(j);//1
		
		
		int p = -89;
		int q = p++;
		System.out.println(p);//-88
		System.out.println(q);//-89
		
		//2. pre increment:
		int h = 1;
		int g = ++h;
		System.out.println(h);//2
		System.out.println(g);//2
		
		int a = -101;
		int b = ++a;
		System.out.println(a);//-100
		System.out.println(b);//-100
		
		//3. post decrement:
		int t = 2;
		int u = t--;
		System.out.println(t);//1
		System.out.println(u);//2
		
		int s = -999;
		int x = s--;
		System.out.println(s);//-999-1 = -1000
		System.out.println(x);//-999
		
		//4. pre decrement:
		int f = 2;
		int d = --f;
		System.out.println(f);//1
		System.out.println(d);//1
		
		
		//
		int p1 = 1;
		System.out.println(p1++);
		System.out.println(p1);
		
		int t1 = 2;
		System.out.println(++t1);
		System.out.println(t1++);		
		System.out.println(t1);
	}

}
