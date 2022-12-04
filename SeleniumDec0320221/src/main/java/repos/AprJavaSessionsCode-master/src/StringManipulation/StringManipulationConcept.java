package StringManipulation;

import java.util.Arrays;

public class StringManipulationConcept {

	public static void main(String[] args) {

		
		String str = "this is my java code and i am so happy";
		
		System.out.println(str.length());
		
		int len = str.length();
		int hi = len - 1;
		int li = 0;
		
		System.out.println("li = " + 0);
		System.out.println("hi = " + (len -1));
		System.out.println("length = " + len);
		
		System.out.println(str.charAt(0));
		System.out.println(str.charAt(37));
		//System.out.println(str.charAt(38));//SIOB
		//System.out.println(str.charAt(-1));//SIOB
		
		System.out.println(str.indexOf('t'));
		System.out.println(str.indexOf('i'));//1st occurrence of i
		System.out.println(str.indexOf('i', str.indexOf('i')+1));//2nd occurrence of i
		
		
		System.out.println(str.indexOf("java"));
		System.out.println(str.indexOf("Naveen"));
		System.out.println(str.indexOf("Java"));
		
		String mesg = "Welcome null";
		if(mesg.indexOf("Admin")!=-1) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}

		
		String st = "this is my first java code";
		System.out.println(st.toUpperCase());
		String st1 = "THIS IS MY JAVA PROGRAM";
		System.out.println(st1.toLowerCase());
		
		//trim:
		String s = "     hello world    ";
		System.out.println(s.trim());
		
		//replace:
		String dob = "01-01-1990"; //01/01/1990
		System.out.println(dob.replace("-", "/"));
		
		String t = "   hello selenium   ";
		System.out.println(t.replace(" ", ""));
		
		//contains:
		String m = "your user id is naveenautomation 123";
		System.out.println(m.contains("naveenautomation"));
		
		if(m.contains("naveenautomation")) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
		
		//equals:
		//String literals
		String p = "hello selenium";
		String k = "hello selenium";
		System.out.println(p.equals(k));
		System.out.println(p.equalsIgnoreCase(k));
		
		String h = new String("hello world");//2
		String g = new String("hello world");//1
		//SCP - 1 "hello world"
		
		System.out.println(h==g);//false
		System.out.println(p==k);//true
		System.out.println(h.equals(g));//true
		
		String n = "hello world";//0
		System.out.println(h==n);//false
		System.out.println(h.equals(n));//true
		
		String nn = "hello world";//0
		System.out.println(n==nn);
		
		String hh = new String("Hello Selenium");
		
		//
		String sp = "Sachin";
		//System.out.println(sp+"Tendulkar");
		sp = sp + "Tendulkar";
		System.out.println(sp);
		String sp1 = "Sachin";
		
		String sp2 = "Sachin";
		System.out.println(sp == sp1);
		
		//SubString:
		String test = "your order id is 98989";
		System.out.println(test.substring(17));
		System.out.println(test.substring(1, 12));//our order
		System.out.println(test.substring(test.indexOf("is")+3, test.length()));
		
		
		//split:
		String lang = "JAVA_PYTHON_JAVASCRIPT_RUBY";
		
		
		String l[] = lang.split("_");
		System.out.println(l[0]);
		System.out.println(l[3]);
		//System.out.println(l[4]);
		
		String empData = "Leyla;Rama;IBM;Pune;India;SDET2";
		String emp[] = empData.split(";");
		System.out.println(emp[0]);
		System.out.println(emp[1]);
		System.out.println(emp[2]);

		System.out.println(Arrays.toString(emp));
		for(String e : emp) {
			System.out.println(e);
		}
		
		//
		String pop = "seleniumhelloworldhellotesting";
		String p1[] = pop.split("hello");
		System.out.println(p1[0]);
		
		//
		String pool = "xXtestingXxXxXseleniumxXXpythonxXautomationX";
		String pl[] = pool.split("xX");
		System.out.println(pl[0]);
		System.out.println(pl[1]);
		System.out.println(pl[2].length());
		System.out.println(pl[3]);
//		System.out.println(pl[4]);
		
		


	}

}
