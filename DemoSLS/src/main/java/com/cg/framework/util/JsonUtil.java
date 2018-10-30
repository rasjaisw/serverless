package com.cg.framework.util;

import com.google.gson.Gson;

/**
 * This class is used to convert the object into the JSON.
 * @author anangupt
 *
 */
public class JsonUtil {

	private JsonUtil() {

	}

	/**This method convert the object into json.
	 * 
	 * @param objectBody
	 * @return
	 */
	public static String convertToJson(Object objectBody) {
		Gson gson = new Gson();
		return gson.toJson(objectBody);
	}
	
	/**This method convert the object into json.
	 * 
	 * @param objectBody
	 * @return
	 */
	public static <T> T convertToObject(String jsonStr, Class<T> targerClass) {
		Gson gson = new Gson();
		return gson.fromJson(jsonStr, targerClass);
	}
}
