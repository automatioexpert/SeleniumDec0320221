package javasessions;

public class SwitchCaseLogic {

	public static void main(String[] args) {

		String browser = "  chr  ome ";
		
		switch (browser.toLowerCase().replace(" ", "")) {
		case "chrome":
			System.out.println("launch chrome");
			break;	
		case "firefox":
			System.out.println("launch firefox");
			break;
		case "safari":
			System.out.println("launch safari");
			break;
		case "ie":
			System.out.println("launch ie");
			break;

		default:
			System.out.println("please pass the right browser " + browser);
		}
		
		
		
		//
		int total = 79;
		switch (total) {
		case 100:
			System.out.println("A++");
			break;
		case 90:
			System.out.println("A");
			break;
		case 80:
			System.out.println("B");
			break;

		default:
			System.out.println("FAIL");
			break;
		}
		
		//
		//user level/RBAC/Permission 
		//diff test enviornments
		//cross browser logic
		//cross devices 
		//cross cloud: MS, AWS, GCP, LOCAL, DOCKER
		//localization - multi languages
		
	}

}
