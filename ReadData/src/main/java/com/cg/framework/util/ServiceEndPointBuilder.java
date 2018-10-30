package com.cg.framework.util;

/**
 * This is class is used to accept the ip, port and uri and return the full qualified URL.
 * @author anangupt
 *
 */
public class ServiceEndPointBuilder {
	
	
	/**The ServiceEndPointBuilder constructor is private so that no class is able to create a object of this class.
	 * 
	 */
	private ServiceEndPointBuilder() {
		
	}
	
	/**This method accept the ip, port and uri and convert into a valid URL
	 * 
	 * @param ip
	 * @param port
	 * @param uri
	 * @return URL:String
	 */
	public static String getURL(String ip, String port, String uri) {
		StringBuilder sb = new StringBuilder();
		sb  = sb.append(ip);
		sb  = sb.append(":");
		sb  = sb.append(port);
		sb  = sb.append("/");
		sb  = sb.append(uri);
		return sb.toString();
	}
	
  
}