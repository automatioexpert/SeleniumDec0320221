package javasessions;

public class Browser {
	
	//WAF: launch browser on the basis of given browser name
	//func name : launchBrowser()
	//input param: browserName(String)
	//return : boolean (true/false)
	
	public boolean launchBrowser(String browserName) {
		System.out.println("browser name is : " + browserName);
		boolean flag = false;
		switch (browserName) {
		case "chrome":
			System.out.println("chrome is launched...");
			flag = true;
			break;
		case "firefox":
			System.out.println("ff is launched...");
			flag = true;
			break;
		case "safari":
			System.out.println("safari is launched...");
			flag = true;
			break;
		case "edge":
			System.out.println("edge is launched...");
			flag = true;
			break;

		default:
			System.out.println("please pass the right browser name..." + browserName);
			break;
		}
		return flag;
	}
	//8 AM IST sunday morning
	//POJO
	public void createsUser(String fn, String ln) {
		//return 100;
		System.out.println("user is created" + fn) ;
	}
	

	public static void main(String[] args) {

		Browser br = new Browser();
		boolean flag = br.launchBrowser("opera");
		System.out.println(flag);
		if(flag) {
			System.out.println("http://www.google.com");
		}
		
		
	}

}
