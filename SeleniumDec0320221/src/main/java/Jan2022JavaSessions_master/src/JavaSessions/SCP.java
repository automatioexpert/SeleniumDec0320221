package JavaSessions;

public class SCP {

	public static void main(String[] args) {

		//String literals
		String s1 = "Java";
		String s2 = "Java";
		String s3 = "Java";
		
		System.out.println(s1==s2);
		s1 = "python";
		System.out.println(s1==s2);

		String s4 = new String("Hello");//2
		String s5 = "Hello";//0
		
		System.out.println(s4 == s5);
		
		String s6 = new String("Hello");//1
		
		System.out.println(s4 == s6);//false
		
		String str = "Hello World";
		str = str + "Java";//Hello WorldJava
		System.out.println(str);
		String str1 = "Hello World";
		System.out.println(str1);
		
		int i = 10;
		i = i + 20;
		System.out.println(i);
		
	}

}
