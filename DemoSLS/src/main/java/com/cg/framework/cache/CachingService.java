package com.cg.framework.cache;

/**This class is used to contains the abstraction for cache service.
 * The main task is to get, remove, and put the object to and from the cache.
 * 
 * @author anangupt
 *
 */
public interface CachingService<T> {

	/**This method is used to connect default service.
	 * 
	 */
	public void connect();
	
	/**This method is used to connect specified service.
	 * 
	 */
	public void connect(String endpoint, int port);

	
	/**This method is store the object in cache.
	 * 
	 * @param key
	 * @param value
	 */
	boolean put(String key, T value);
	
	/**This method is remove the object in cache.
	 * 
	 * @param key
	 * @param value
	 */
	boolean remove(String key);

	/**This method is get the object in cache.
	 * 
	 * @param key
	 * @return T
	 */
	T get(String key, Class<T> targetClass);
	

}