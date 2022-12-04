package WebDriver_Arch;

public class ChromeDriver implements WebDriver {

	public ChromeDriver() {
		System.out.println("launch chrome");
	}

	@Override
	public void findElement() {
		System.out.println("find the element");
	}

	@Override
	public void findElements() {
		System.out.println("find the elements");
	}

	@Override
	public void get(String url) {
		System.out.println("launch url: " + url);
	}

	@Override
	public String getTitle() {
		return "XYZ Application";
	}

	@Override
	public String getUrl() {
		return "http://www.xyz.com";
	}

	@Override
	public void click() {
		System.out.println("click on element");
	}

	@Override
	public void sendKeys(String value) {
		System.out.println("pass this value: " + value);
	}

	@Override
	public void quit() {
		System.out.println("close the browser");
	}

}
