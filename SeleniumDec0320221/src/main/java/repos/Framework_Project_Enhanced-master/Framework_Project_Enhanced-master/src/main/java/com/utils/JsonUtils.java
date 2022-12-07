package com.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.constants.FrameworkConstants;
import com.enums.ConfigProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 
 * Sep 10, 2022
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 */
public final class JsonUtils {
	
	/**
	 * 
	 */
	private JsonUtils() {

	}
	/**
	 * 
	 */
	private static Map<String, String> CONFIGMAP;
	static {
		try {
			CONFIGMAP= new ObjectMapper()
					.readValue(new File(FrameworkConstants.getJsonConfigFilePath()), new TypeReference<HashMap<String, String>>() {});
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}			
	}
	
	/**
	 * 
	 * @author Hassen
	 * Sep 10, 2022
	 * @param key
	 * @return
	 * @throws Exception 
	 */
	public static String get(ConfigProperties key) throws Exception {
		if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new Exception("Property name "+ key +" is not fournd. Please check config.json");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}
}
