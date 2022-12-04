package javasessions;

public class WrapperClassConcept {

	public static void main(String[] args) {

		
		//String to int:
		String x = "100";
		System.out.println(x+20);
		
		int i = Integer.parseInt(x);//100
		System.out.println(i+20);
		
//		String y = "100A";
//		int k = Integer.parseInt(y);//NumberFormatException
//		System.out.println(k+30);
		
		//String to double:
		String total = "120.33";
		double d = Double.parseDouble(total);
		System.out.println(d+10.33);
		
		//String to boolean:
		String flag = "true";
		boolean fg = Boolean.parseBoolean(flag);
		if(fg) {
			System.out.println("run ur test");
		}
		
		//int to String;
		int bal = 500;
		String b = String.valueOf(bal);//"500"
		System.out.println(b+30);
		
		String mesg = "your order id is 12345";
		//substring:
		String orderID = mesg.substring(mesg.indexOf("is")+3);
		System.out.println(orderID);
		
		String m1 = mesg.substring(1, 11).trim();
		System.out.println(m1);
		
	}

}
