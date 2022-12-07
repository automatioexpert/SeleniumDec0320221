package com.testcases;

import java.net.URL;

public class TestGetPath {

	public static void main(String[] args) {
		URL loc = TestGetPath.class.getClassLoader().getResource("./");
		String path = loc.getPath();
		path = path.replaceAll("bin", "src");
		path = path + "com" + System.getProperty("file.separator") + "resources" + System.getProperty("file.separator") + "data.csv";
		

	}

}
