package javasessions;

public class IfElseLogic {

	public static void main(String[] args) {

		String browser = "chrome";
		if (browser.equals("chrome")) {
			System.out.println("launch chrome");
		}
		else if (browser.equals("ff")) {
			System.out.println("launch ff");
			
		}
		else if (browser.equals("safari")) {
			System.out.println("launch safari");

		}
		else if (browser.equals("ie")) {
			System.out.println("launch ie");

		}
		else {
			System.out.println("please pass the right browser");
		}
		

	}

}
