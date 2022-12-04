package OOP_Encapsulation;

public class Browser {

	// private methods
	// will be accessed via public methods

	public void launchBrowser() {
		System.out.println("trying to launch browser...");
		isChromePresent();
		checkRAMSpace();
		browserIsUpgraded();
		checkOSCompatible();
		checkBrowserVersion();
		System.out.println("browser is launched...");

	}

	private void isChromePresent() {
		System.out.println("isChromePresent");
	}

	private void checkRAMSpace() {
		System.out.println("checkRAMSpace");

	}

	private void browserIsUpgraded() {
		System.out.println("browserIsUpgraded");

	}

	private void checkOSCompatible() {
		System.out.println("checkOSCompatible");

	}

	private void checkBrowserVersion() {
		System.out.println("checkBrowserVersion");

	}

}
