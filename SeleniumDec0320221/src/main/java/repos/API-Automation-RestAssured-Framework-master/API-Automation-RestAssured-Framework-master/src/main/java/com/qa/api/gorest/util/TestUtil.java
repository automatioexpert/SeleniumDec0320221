/**
 * 
 */
package com.qa.api.gorest.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author anand acharya
 *
 */
public class TestUtil {

	/**
	 * This method is used to convert POJO object to a JSON String...
	 * @param obj
	 * @return jsonString
	 */
	public static String getSerializedJSON(Object obj){
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = null;
        try {
        	jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        	System.out.println("JSON BODY PAYLOAD ==> "+jsonString);
        } catch (JsonProcessingException e) {
               e.printStackTrace();
        }
        
        return jsonString;
	}
}
