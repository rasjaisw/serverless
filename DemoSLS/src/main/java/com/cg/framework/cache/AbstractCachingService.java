package com.cg.framework.cache;

import com.cg.framework.constant.EnvConstant;

import redis.clients.jedis.Jedis;

/**This class is used to define the common method to connect and close the cache service.
 * 
 * @author anangupt
 *
 * @param <T>
 */

public abstract class AbstractCachingService<T> implements CachingService<T> {

	private Jedis jedis;
	
	/**Connects the default service end point.
	 * 
	 */
	@Override
	public void connect() {
		int port= Integer.parseInt( EnvConstant.CACHE_SERVICE_PORT.getVal());
        this.jedis = new Jedis(EnvConstant.CACHE_SERVICE_ENDPOINT.getVal(), port);
	}
	
	/**Connects the specified service end point.
	 * 
	 */
	@Override
	public void connect(String endpoint, int port) {
        this.jedis = new Jedis(endpoint, port);
	}
	
	/**Close the service connection.
	 * 
	 */
	public void closeConnection(Jedis jedis) {
		if(jedis != null) {
			jedis.close();
		}
	}

	/**Connects the default service end point and returns the cache object.
	 * 
	 */
	public Jedis getConnection() {
		if(jedis==null) {
			connect( );
		}
		return jedis;
	}
	
	/**Connects the default service end point and returns the cache object.
	 * 
	 */
	public Jedis getConnection(String endpoint, int port) {
		if(jedis==null) {
			connect(endpoint, port);
		}
		return jedis;
	}
	
}
