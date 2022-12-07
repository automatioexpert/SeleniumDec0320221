package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.constants.FrameworkConstants;
import com.enums.ConfigProperties;

public final class PropertyUtils {

	private PropertyUtils() {
		
	}
	
	private static Properties property= new Properties();
	private static final Map<String, String> CONFIGMAP =new HashMap<>();
	
	static {
		try {
			FileInputStream file = new FileInputStream(FrameworkConstants.getConfigfilepath());
			property.load(file);
			for (Map.Entry<Object, Object> entry : property.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim()); //remove the trailing and leading spaces		
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		}
	
	public static String get(ConfigProperties key) throws Exception {
		if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new Exception("Property name "+ key +" is not fournd. Please check config.properties");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}
}
