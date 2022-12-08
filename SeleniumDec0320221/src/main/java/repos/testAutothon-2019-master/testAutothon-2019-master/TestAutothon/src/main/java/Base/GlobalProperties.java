package Base;

public enum GlobalProperties {

    REPORTPATH("reportPath", "//Reports"), BROWSER("browser", "REMOTECHROME");

    private final String propertyName;

    private final String defaultValue;

    GlobalProperties(String propertyName, String defaultValue) {
        this.propertyName = propertyName;
        this.defaultValue = defaultValue;
    }

    GlobalProperties(String propertyName) {
        this(propertyName, "");

    }

    public String getValue() {
        return System.getProperty(propertyName, defaultValue);
    }
}
