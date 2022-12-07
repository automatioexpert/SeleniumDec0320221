package org.qa.sharif.commonutils;

public class AppConfig {

    public static PropertyHelper propertyHelper = new PropertyHelper();

    public static String getBaseUrl() {
        return propertyHelper.getPropertyValue("base.url");
    }

    public static String getDefaultBrowser() {
        return propertyHelper.getPropertyValue("defaultBrowser.name");
    }

    public static int getDefaultElementTimeOut() {
        return Integer.parseInt(propertyHelper.getPropertyValue("element.timeout"));
    }

    public static int getDefaultPageTimeout() {
        return Integer.parseInt(propertyHelper.getPropertyValue("pageLoad.timeout"));
    }

    public static int getDefaultScriptTimeout() {
        return Integer.parseInt(propertyHelper.getPropertyValue("script.timeout"));
    }
}
