package core.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private Properties properties;

    private static PropertiesReader propertiesReader;

    private PropertiesReader() {
        properties = new Properties();
        try {
            String env = System.getProperty("ENV", "environment");
            String propertiesFilePath = env + ".properties";
            InputStream inputStream = getResourceAsStream(propertiesFilePath);
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PropertiesReader getInstance( ) {
        if(propertiesReader == null) {
            propertiesReader = new PropertiesReader();
        }
        return propertiesReader;
    }

    private InputStream getResourceAsStream(String path) {
        return this.getClass().getClassLoader().getResourceAsStream(path);
    }

    public String getHost() {
        return properties.getProperty("host");
    }
}
