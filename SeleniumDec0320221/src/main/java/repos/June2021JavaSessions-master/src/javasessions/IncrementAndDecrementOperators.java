package javasessions;

public class IncrementAndDecrementOperators {

	public static void main(String[] args) {

		//++ --> increase the value by 1

		int a = 1;
		int b = a++;//post increment
		
		System.out.println(a);//2
		System.out.println(b);//1
		
		int m = -99;
		int n = m++;
		System.out.println(m);//-98
		System.out.println(n);//-99
		
		int c = 1;
		int d = ++c;//pre increment
		System.out.println(c);//2
		System.out.println(d);//2
		
		int f = -97;
		int g = ++f;
		System.out.println(f);//-96
		System.out.println(g);//-96
		
		int t = 1;
		System.out.println(t++);
		System.out.println(t);
		
		//post decreemnt: --
		int p = 2;
		int q = p--;
		System.out.println(p);//1
		System.out.println(q);//2
		
		int h = -999;
		int i = h--;
		System.out.println(h);
		System.out.println(i);
		
		//pre decrement:
		int s1 = 2;
		int s2 = --s1;
		System.out.println(s1);//1
		System.out.println(s2);//1
		
		int v = 1;
		System.out.println(++v + v++);
		System.out.println(v);
		
		int mm = 1;
		//System.out.println(mm++);
		System.out.println(mm++ + 4);
		System.out.println(mm);
		
		
		int x = 10;
		int y = 10/2;
		System.out.println(y);
		System.out.println(10/2);
		System.out.println(9/2);//4
		System.out.println(9.0/2);//4.5
		System.out.println(9/2.0);//4.5
		System.out.println(9.0/2.0);//4.5
		
		System.out.println(0/9);
		//System.out.println(9/0);
		System.out.println(1/1);
		//System.out.println(0/0);
		System.out.println(9.0/0);
		System.out.println(0.0/0.0);
		System.out.println(0/0.0);
		System.out.println(9/0.0);
		
		System.out.println(9 % 3);
		
		
		
		
	}

}
