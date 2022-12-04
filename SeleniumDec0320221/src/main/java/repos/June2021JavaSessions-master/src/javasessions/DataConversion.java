package javasessions;

public class DataConversion {

	public static void main(String[] args) {

		//String to int:
		String x = "100";
		System.out.println(x+20);
		
		int i = Integer.parseInt(x);//100
		System.out.println(i+20);
		
		//reading some string from prop/excel file
		//timeout = 20
		//"20" + 5 = "205"
		//from web page: data is always coming inthe form of text (string)
		
		//String to double:
		String y = "12.33";
		System.out.println(y+20);
		double d1 = Double.parseDouble(y);
		System.out.println(d1+20);
		
		//
		String z = "100A";
//		int k = Integer.parseInt(z);
//		System.out.println(k+20);
		
		//String to boolean:
		String headless = "true";
		if(Boolean.parseBoolean(headless)) {
			
		}
		
//		String d = "T";
//		int d2 = Integer.parseInt(d);
//		System.out.println(d2+200);
		
		//int to String:
		int t1 = 100;
		System.out.println(t1+20);//120
		//10020
		System.out.println(t1+""+20);
		
		String t2 = String.valueOf(t1); //"100"
		System.out.println(t2+20);
		
		
		
	}

}
