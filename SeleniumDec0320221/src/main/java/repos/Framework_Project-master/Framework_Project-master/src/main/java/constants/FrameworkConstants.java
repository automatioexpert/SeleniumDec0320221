package constants;

public final class FrameworkConstants {

	private FrameworkConstants() {
	}

	private static final String CONFIGFILEPATH= System.getProperty("user.dir") + "./Config File/config.properties";
	private static final int IMPLICITLYWAIT=10;
	
	public static String getCONFIGFILEPATH() {
		return CONFIGFILEPATH;
	}

	public static int getIMPLICITLYWAIT() {
		return IMPLICITLYWAIT;
	}
}
