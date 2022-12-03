package WrapperClasses;

public class DataConversion {
	
	
	public static void main(String a[]) {
		
		
		String x = "100";
		System.out.println(x+20);
		
		//String to int:
		int i = Integer.parseInt(x);//100
		System.out.println(i+20);
		
//		String y = "100A";
//		int j = Integer.parseInt(y);//NumberFormatException
//		System.out.println(j);
		
		//String to double:
		String s = "100.22";
		System.out.println(s+20);
		double d = Double.parseDouble(s);//100.22
		System.out.println(d+20);
		
		//int to String:
		int total = 1000;
		String t = String.valueOf(total);//"100"
		System.out.println(t+20);
		
		double tt = 50.55;
		String t1 = String.valueOf(tt);
		System.out.println(t1+20);
		
		//String to boolean:
		String p = "true";
		boolean flag = Boolean.parseBoolean(p);//true
		if(flag) {
			System.out.println("PASS");
		}
		
		String headless = "true";
		if(Boolean.parseBoolean(headless)) {
			System.out.println("launch chrome in headless");
		}
		else {
			System.out.println("FAIL");
		}
		
		//boolean to String:
		boolean f = true;
		String f1 = String.valueOf(f);//"true"
		System.out.println(f1+20);
		
		//String to long:
		String pop = "100000111";
		long dist = Long.parseLong(pop);
		System.out.println(dist + 1);
		
		System.out.println(Byte.MIN_VALUE);
		System.out.println(Byte.MAX_VALUE);
		
		System.out.println(Long.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);

		System.out.println(Short.MIN_VALUE);
		System.out.println(Short.MAX_VALUE);

		
		
	}
	
	
	
	

}
