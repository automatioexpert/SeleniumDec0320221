package EnumConcept;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProp {

	public static void main(String[] args) {

		Properties prop = null;
		try {
			FileInputStream ip = new FileInputStream("./src/EnumConcept/config.properties");
			prop = new Properties();
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String brName = prop.getProperty("browser");
		System.out.println(brName);
		if(brName.equals("chrome")) {
			System.out.println("launch chrome");
		}
		
		System.out.println(prop.getProperty("url"));
		
		
		if(Boolean.parseBoolean(prop.getProperty("headless"))) {
			System.out.println("run in headless mode....");
		}
		
		
		
	}

}
