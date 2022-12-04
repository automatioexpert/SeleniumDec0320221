package javasessions;

public class Browser {

	// launch a browser:
	// input param: name (String): FF/CH/SF/IE
	// return: boolean
	public boolean launchBrowser(String name) {
		System.out.println("browser name is: " + name);
		if (name.equals("chrome")) {
			System.out.println("launch chrome");
			return true;
		} else if (name.equals("firefox")) {
			System.out.println("launch firefox");
			return true;

		} else if (name.equals("safari")) {
			System.out.println("launch safari");
			return true;

		} else if (name.equals("IE")) {
			System.out.println("launch IE");
			return true;

		} else {
			System.out.println("please pass the right browser.....");
			return false;
		}
	}

	public boolean openBrowser(String brName) {
		System.out.println("browser name: " + brName);
		switch (brName.toLowerCase()) {
		case "chrome":
			System.out.println("launch chrome");
			return true;
		case "firefox":
			System.out.println("launch FF");
			return true;
		case "ie":
			System.out.println("launch IE");
			return true;

		default:
			System.out.println("plz pass the right browser " + brName);
			return false;
		}
		
	}

	// main method will never return anything
	public static void main(String[] args) {
		Browser br = new Browser();
		boolean flag = br.openBrowser("safari");
		System.out.println(flag);
		
		
//		if (br.launchBrowser("opera")) {
//			System.out.println("br is launched....");
//		} else {
//			System.out.println("TC is FAILEd.....");
//		}
		
	}

}
