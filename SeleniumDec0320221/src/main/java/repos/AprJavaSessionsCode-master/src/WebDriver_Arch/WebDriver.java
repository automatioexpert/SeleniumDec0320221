package WebDriver_Arch;

public interface WebDriver extends SearchContext {

	@Override
	public void findElement();

	@Override
	public void findElements();

	public void click(String element);

	public void sendKeys(String element, String value);

	public void get(String url);

	public String getTitle();

	public void close();

}
