package EnumConcept;

public enum Environment {

	QA("qa"), 
	STAGE("amazonstage"), 
	DEV("dev"), 
	UAT("uat"), 
	PROD("prod");

	private String envName;

	Environment(String envName) {
		this.envName = envName;
	}

	public String getEnvValue() {
		return this.envName;
	}

}
