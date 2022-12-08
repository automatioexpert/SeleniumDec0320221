package tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Config {

  private static Config instance;
  private Properties properties;

  public static final long POLLING_PERIOD = Long
      .parseLong(getInstance().getProperty("polling_period"));
  public static final long LOCATION_TIMEOUT = Long
      .parseLong(getInstance().getProperty("location_timeout"));

  /**
   * Used to retrieve an instance of the Configuration class.
   *
   * @return instance of {@link Config}
   */
  public static Config getInstance() {
    if (instance == null) {
      instance = new Config();
    }

    return instance;
  }

  private Config() {
    properties = new Properties();
    try {
      InputStream stream = getClass()
          .getClassLoader()
          .getResourceAsStream("config.properties");
      properties.load(stream);
      stream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String getInstanceUnderTest() {
    return System.getProperty("environment");
  }

  public String getBrowser() {
    return getProperty("browser");
  }

  public String getProperty(String key) {
    return properties.getProperty(key);
  }

  public String getUrl() {
    return getProperty("url");
  }

  public String getAccountsUrl() {
    return getProperty("accounts_url");
  }
}
