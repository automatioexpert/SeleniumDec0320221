package com.inetBanking.utilites;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	FileInputStream fis;

	public ReadConfig() {
		File src = new File("./Configuration/config.properties");

		try {
			fis = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Config.properties not fount at " + src);
		}
		pro = new Properties();
		try {
			pro.load(fis);
		} catch (IOException e) {
			System.out.println("Exception is " + e.getMessage());
			e.printStackTrace();
		}
	}

	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}

	public String getUsername() {
		String username = pro.getProperty("username");
		return username;
	}

	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}

	public String getChromePath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}

	public String getEdgePath() {
		String edgepath = pro.getProperty("edgepath");
		return edgepath;
	}

	public String getFirefoxPath() {
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	
}
