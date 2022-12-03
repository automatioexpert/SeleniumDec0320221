package javasessions;

public class MailApp {
	
	int price;//copy of this var wil be stored inside the object of this class
	static String name = "gmail";//CMA

	public void sendMail() {//copy of this method wil be stored inside the object of this class
		System.out.println("send mail");
	}

	public static void sendInfo() {//CMA
		System.out.println("send info");
	}

	public static void main(String[] args) {
		//how to call non static method:
		//create the object:
		MailApp ma = new MailApp();//price, sendMail()
		ma.sendMail();
		
		//how to call static method/vars: no need use object ref
		//1. using class name
		MailApp.sendInfo();
		System.out.println(MailApp.name);
		
		//2. call directly:
		sendInfo();

		//3. call it by using object ref:
		ma.sendInfo();
		
		
	}

}
