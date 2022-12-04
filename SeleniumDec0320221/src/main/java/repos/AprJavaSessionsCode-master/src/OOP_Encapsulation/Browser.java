package OOP_Encapsulation;

public class Browser {

	public void launchChromeBrowser() {
		System.out.println("launch chrome");
		checkOSCompatible();
		checkRAMSIZE();
		checkChromeVersion();
		checkChromeServices();
		System.out.println("chrome browser is launched");
	}

	private void checkOSCompatible() {
		System.out.println("checkOSCompatible");
	}

	private void checkRAMSIZE() {
		System.out.println("checkRAMSIZE");
	}

	private void checkChromeVersion() {
		System.out.println("checkChromeVersion");
	}

	private void checkChromeServices() {
		System.out.println("checkChromeServices");
	}

}
