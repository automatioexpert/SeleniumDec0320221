package WebDriver_Arch;

public class RemoteWebDriver implements WebDriver {

	@Override
	public void findElement() {
		System.out.println("FE");
	}

	@Override
	public void findElements() {
		System.out.println("FEs");

	}

	@Override
	public void get(String url) {
		System.out.println("enter url");

	}

	@Override
	public String getTitle() {
		return "some title";
	}

	@Override
	public String getUrl() {
		return "https://www.abc.com";
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
	public void close() {
		System.out.println("close browser");
	}

}
