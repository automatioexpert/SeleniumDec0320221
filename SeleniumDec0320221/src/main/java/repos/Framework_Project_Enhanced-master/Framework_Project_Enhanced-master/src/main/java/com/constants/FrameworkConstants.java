package com.constants;

public final class FrameworkConstants {

	private FrameworkConstants() {

	}

	
	private static final int EXPLICITWAIT = 10;

	private static final String RESOURCESPATH= System.getProperty("user.dir") +"/src/test/resources/";

	private static final String CHROMEDRIVERPATH= RESOURCESPATH + "/executables/chromedriver.exe";
	private static final String GECKODRIVERPATH= RESOURCESPATH + "/executables/geckodriver.exe";
	private static final String CONFIGFILEPATH= RESOURCESPATH + "/config/config.properties";
	private static final String JSONCONFIGFILEPATH= RESOURCESPATH + "/jsons/config.json";

	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}
	
	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}
	
	public static String getGeckodriverpath() {
		return GECKODRIVERPATH;
	}

	public static String getChromedriverpath() {
		return CHROMEDRIVERPATH;
	}
	
	public static String getJsonConfigFilePath() {
		return JSONCONFIGFILEPATH;
	}

}
