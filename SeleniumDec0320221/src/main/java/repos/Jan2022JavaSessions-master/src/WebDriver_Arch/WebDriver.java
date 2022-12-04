package WebDriver_Arch;

public interface WebDriver extends SearchContext{

	public void click();

	public void sendKeys(String value);

	public String getTitle();

	public String getUrl();

	public void quit();
	
	@Override
	public void findElement(String element);

	@Override
	public void findElements(String element);

}
