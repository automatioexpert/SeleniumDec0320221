/**
 * 
 */
package commonutil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author rohitnegi
 *
 */
public class PropertyUtil {

	
	private static Properties obj; 
		
		private static final String fileName = "eukleialms.properties";
		
		
		public static String getProperty(String key) {
			
			String value = null;
			
			loadProperties();
			
			value = obj.getProperty(key);
			//System.out.println(key + " is :" + value);
			
			return value;
			
		}
		
		public static void loadProperties() {
			
			try {
				obj = new Properties();
				FileReader fileReader = new FileReader(fileName);
				obj.load(fileReader);
				
				if (fileReader != null) {
					fileReader.close();
			} }
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

	
}
