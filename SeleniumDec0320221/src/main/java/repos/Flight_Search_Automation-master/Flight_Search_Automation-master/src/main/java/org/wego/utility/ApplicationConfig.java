package org.wego.utility;

public class ApplicationConfig {
    public static PropertyHelper propertyHelper = new PropertyHelper();

    public static String getBaseUrl() {
        return propertyHelper.getPropertyValue("base.url");
    }

    public static String getDefaultBrowser() {
        return propertyHelper.getPropertyValue("defaultBrowser.name");
    }

    public static int getDefaultImplicitWait() {
        return Integer.parseInt(propertyHelper.getPropertyValue("implicit_wait"));
    }

    public static int getDefaultPageTimeout() {
        return Integer.parseInt(propertyHelper.getPropertyValue("pageLoad.timeout"));
    }

    public static int getDefaultExplicitWait() {
        return Integer.parseInt(propertyHelper.getPropertyValue("explicit_wait"));
    }
}
