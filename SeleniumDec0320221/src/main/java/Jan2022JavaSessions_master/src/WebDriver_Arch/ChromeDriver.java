package WebDriver_Arch;

public class ChromeDriver implements WebDriver {

	public ChromeDriver() {
		System.out.println("launch chrome browser");
	}

	@Override
	public void click() {
		System.out.println("click on element");
	}

	@Override
	public void sendKeys(String value) {
		System.out.println("enter value: " + value);
	}

	@Override
	public String getTitle() {
		return "title";
	}

	@Override
	public String getUrl() {
		return "http://www.xyz.com";
	}

	@Override
	public void quit() {
		System.out.println("quit browser");
	}

	@Override
	public void findElement(String element) {
		System.out.println("find the element: " + element);
	}

	@Override
	public void findElements(String element) {
		System.out.println("find the elements: " + element);

	}

}
