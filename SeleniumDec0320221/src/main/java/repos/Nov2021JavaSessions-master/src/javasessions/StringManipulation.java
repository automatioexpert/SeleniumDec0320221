package javasessions;

public class StringManipulation {

	public static void main(String[] args) {

		String str = "Hello this is my java code";
		
		System.out.println(str.length());
		
		System.out.println(str.charAt(0));//H
		System.out.println(str.charAt(25));
		System.out.println(str.charAt(str.length()-1));
		//System.out.println(str.charAt(26));//StringIndexOutOfBoundsException
		
		System.out.println(str.indexOf('H'));
		System.out.println(str.indexOf('i'));//8//1st occurrence of i
		System.out.println(str.indexOf('i', str.indexOf('i')+1));//2nd occurrence of i

		System.out.println(str.indexOf("java"));
		System.out.println(str.indexOf("world"));
		
		String mesg = "Hello null";
		if(mesg.indexOf("Naveen")!=-1) {
			System.out.println("mesg is correct");
		}else {
			System.out.println("mesg incorrect");
		}
		
		//
		String test = "welcome to java";
		System.out.println(test.toLowerCase());
		System.out.println(test.toUpperCase());
		
		//String literals
		String s1 = "Hello World";
		String s2 = "Hello World";
		System.out.println(s1==s2);//true
		
		String s3 = new String("Hello Java");//2 objects
		String s4 = new String("Hello Java");//
		String s5 = "Hello Java";//0
		
		System.out.println(s3==s5);//false
		System.out.println(s3.equals(s5));//true
		
		String s6 = "Hello World";//0
		
		String s7 = "Hello Python";//1
		s7 = "Hello JS";//1
		System.out.println(s7);
		
		s4 = null;
		//System.out.println(s4.equals(s5));//NPE
		System.out.println(s5.equals(s4));//false
		
//		if(s4.equals(s5)) {//NPE
//			System.out.println("PASSSSSSS");
//		}else {
//			System.out.println("FAILLLLLL");
//		}
		
		if(s5.equals(s4)) {
			System.out.println("PASSSSSSS");
		}else {
			System.out.println("FAILLLLLL");
		}
		
		//equals:
		String t1 = "hello world";
		String t2 = "hello World ";
		
		System.out.println(t1.equals(t2));
		System.out.println(t1.equalsIgnoreCase(t2.trim()));
		
		//contains:
		System.out.println(t1.contains("hello"));
		
		//trim:
		String top = "        hello    testing     ";
		//System.out.println(top.trim());
		System.out.println(top.replace(" ", ""));
		//replace:
		String tt = "hello world";
		System.out.println(tt.replace(" ",""));
		
		String dob = "01-01-1990";//01/01/1990
		System.out.println(dob.replace("-", "/"));
		
		//split:
		String lang = "JAVA_PYTHON_JS_RUBY";
		String lg[] = lang.split("_");
		System.out.println(lg.length);
		System.out.println(lg[0]);
		
		String pop = "xXtestingxxXseleniumXxXQTPXXxXCypress";
		String p[] = pop.split("xX");
		System.out.println("----");
		System.out.println(p[0]);//empty
		System.out.println("----");
		System.out.println(p[1]);//testingx
		System.out.println(p[2]);//seleniumX
		System.out.println(p[3]);//QTPXX
		System.out.println(p[4]);//Cypress
		//System.out.println(p[5]);//AIOB

		System.out.println("----");

		String empData = "Devesh;Kumar;pune;India;SDET2;IBM";
		//System.out.println(empData.split(";")[0]);
		
		String emp[] = empData.split(";");
		for(String e : emp) {
			System.out.println(e);
		}
		
		String s11 = "Selenium";

	}

}
