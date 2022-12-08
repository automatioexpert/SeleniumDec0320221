package com.utils;

import java.io.File;

public class FileUitls {

	/**
	 * Method to create new reports folder
	 * @param folderName
	 * @return
	 */
	public static String getReportsFolderPath(String folderName) {
		String path = "reports/" + folderName;
		String filePath = "";
		File file = new File(path);

		if (file.exists()) {
			file.mkdir();
			filePath = file.getAbsolutePath();
		} else
			filePath = file.getAbsolutePath();

		return filePath;
	}
}
