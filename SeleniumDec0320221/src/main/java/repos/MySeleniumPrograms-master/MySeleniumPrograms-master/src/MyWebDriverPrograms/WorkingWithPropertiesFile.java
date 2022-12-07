package MyWebDriverPrograms;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WorkingWithPropertiesFile {

	public static void main(String[] args) throws IOException {
		Properties pros=new Properties();
		FileInputStream fis = new FileInputStream("F:\\Selenium\\MtWebDriverProject\\src\\Sample\\Config.Properties");
		pros.load(fis);
		String URL = pros.getProperty("URL");
		System.out.println(URL);
		String user=pros.getProperty("Username");
		System.out.println(user);
		
	
		
		
		
		
		
		

	
	}
}
