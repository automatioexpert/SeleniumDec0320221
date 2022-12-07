package constant;

import core.properties.PropertiesReader;

public class BaseHost {
    private static final PropertiesReader propertiesReader = PropertiesReader.getInstance();
    private static final String host = propertiesReader.getHost();

    public static String getHost() {
        return host;
    }
}
