package org.qa.sharif.commonutils;

import org.qa.sharif.environment.Environment;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyHelper {

    static InputStream inputStream;
    static Properties properties;
    public static String propFileName = Environment.propertyFileLocation;

    public PropertyHelper() {
        try {
            properties = new Properties();
            inputStream = new FileInputStream(propFileName);
            properties.load(inputStream);

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getPropertyValue(String propName) {
        String propValue = properties.getProperty(propName);
        if (propValue != null) return propValue;
        else throw new RuntimeException(propName + " not found at " + propFileName);
    }

}
