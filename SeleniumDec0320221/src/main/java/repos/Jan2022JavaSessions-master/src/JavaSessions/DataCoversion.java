package JavaSessions;

public class DataCoversion {

	public static void main(String[] args) {

		String x = "100";
		System.out.println(x+20);//10020
		
		int i = Integer.parseInt(x);//100
		System.out.println(i+20);//120
		
		String y = "12.33";
		System.out.println(y+20);
		
		double d = Double.parseDouble(y);
		System.out.println(d+20);
		
		String p = "AA100";
		System.out.println(p+20);
		
		//int a = Integer.parseInt(p);//NumberFormatException
		
		
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);
		
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		
		//int to String:
		int t = 100;
		System.out.println(t+20);
		String tt = String.valueOf(t);//"100"
		System.out.println(tt+20);
		
		boolean flag = true;
		String s = String.valueOf(flag);//"true"
		if(s.equals("true")) {
			System.out.println("hii");
		}
		
		
		String mesg = "welcome to \"java\" world";
		//op: welcome to "java" world
		System.out.println(mesg);
		
		
		
		
	}

}
