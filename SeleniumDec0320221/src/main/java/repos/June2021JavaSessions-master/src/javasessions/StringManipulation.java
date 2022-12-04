package javasessions;

public class StringManipulation {

	public static void main(String[] args) {

		String s = "Hi this is my java code and i am so happy";
		
		System.out.println(s.length());
		
		int l = s.length();//41
		int hi = l-1;//40
		int li = 0;
		
		System.out.println(s.charAt(4));
		System.out.println(s.charAt(40));
		//System.out.println(s.charAt(41));//StringIndexOutOfBoundsException
		//System.out.println(s.charAt(-1));//StringIndexOutOfBoundsException
		System.out.println("-----");
		System.out.println(s.indexOf('i'));//1st occurrence of i
		System.out.println(s.indexOf('i', s.indexOf('i')+1));//2nd occurrence of i
		
		System.out.println(s.indexOf('H'));
		System.out.println(s.indexOf("java"));
		System.out.println(s.indexOf("naveen"));//-1
		
		String mesg = "welcome null";
		if(mesg.indexOf("admin")>0) {
			System.out.println("admin user logged in");
		}
		else {
			System.out.println("user is null...");
		}
		
		String a1 = "this is my code";
		System.out.println(a1.toUpperCase());
		System.out.println(a1.toLowerCase());
		
		//contains:
		String header = "This is amazon page";
		System.out.println(header.contains("amazon"));
		
		//equals:
		//String literals:
		String s1 = "naveen";
		String s2 = "naveen";
		System.out.println(s1.equals(s2));//true
		System.out.println(s1==s2);//true
		
		String n1 = "Naveen";
		System.out.println(s1.equals(n1));
		System.out.println(s1.equalsIgnoreCase(n1));
		
		//String object with new keyword:
		String s3 = new String("test");
		String s4 = new String("test");
		String n2 = new String("naveen");

		System.out.println(s3==s4);//false
		System.out.println(s3.equals(s4));
		
		System.out.println(s1==n2);//false
		System.out.println(s1.equals(n2));
		
		String t1 = "selenium";
		t1 = t1+ "QTP naveen";
		
		int m = 10;
		m = 20;
		
		String t2 = "selenium";
		
		System.out.println(t2);
		System.out.println(t1);
		System.out.println(m);

		//substring:
		String p1 = "this is selenium code";
		System.out.println(p1.substring(8));
		System.out.println(p1.substring(2, 8));
		
		//split:
		String str = "java_python_ruby_javascript";
		String strArr[] = str.split("_");
		System.out.println(strArr.length);
		System.out.println(strArr[0]);
		for(String e : strArr) {
			System.out.println(e);
		}
		
		//test data:
		String empReg = "ekta;kumar;ekta@gmail.com;9090;ekta@123";
		String empData[] = empReg.split(";");
		
		for(String e : empData) {
			System.out.println(e);
		}
		
		//
		String tr = "xXtestingXxXSeleniumXXxXpython";
		String test[] = tr.split("xX");
		System.out.println(test[0]);
		System.out.println(test[1]);
		System.out.println(test[2]);
		System.out.println(test[3]);
		//System.out.println(test[4]);//ArrayIndexOutOfBoundsException

		String hr = "testing_selenium;test_seleniumPython;testing_selenium_ruby";
		System.out.println(hr.split(";")[0]);
		System.out.println(hr.split(";")[1]);

		
	}

}
