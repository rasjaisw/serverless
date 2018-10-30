package com.cg.framework.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**This class is a singleton class and used to hold the Spring application context
 * object. There is only one object of ApplicationContext exist per deployment.
 * 
 * @author anangupt
 *
 */
public class ApplicationContextUtil {

	/**The constructor is private so that no class is able to create a object of this class.
	 * 
	 */
	private ApplicationContextUtil() {
		
	}
	
	/**The application context is static so that it is available for subsequent call.
	 * 
	 */
	private static ApplicationContext applicationContext;
	
	/**This method is used to return the object of ApplicationContext and make sure no other object will be created.
	 * 
	 * @param contextXML
	 * @return
	 */
	public static ApplicationContext getInstance(String contextXML) {
		if(applicationContext==null) {
			initContext(contextXML);
		}
		return applicationContext;
		
	}
	
	/**This method create the application context against the spring XML passed to the method.
	 * This is a synchronized method and make sure there is only object will be created even in the race condition.
	 * 
	 * @param contextXML
	 */
	private static synchronized void initContext(String contextXML) {
		
		if(applicationContext==null) {
			applicationContext = new ClassPathXmlApplicationContext(contextXML);
		}
		
	}
	
}
