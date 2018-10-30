package com.cg.framework.cache;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import redis.clients.jedis.Jedis;

/**
 * Returns the connection object for cache
 * @author anangupt
 *
 */
@Component
@Primary
public class GenericCacheServiceImpl<T> extends AbstractCachingService<T> implements CachingService<T> {

	/* (non-Javadoc)
	 * @see com.afc.framework.cache.service.ApplicationServiceCache#setUser(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean put(String key, T t) {
		Jedis jedis = getConnection();
		Gson gson = new Gson();
		jedis.set(key, gson.toJson(t));
		closeConnection( jedis);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.afc.framework.cache.service.ApplicationServiceCache#removeUser(java.lang.String)
	 */
	@Override
	public boolean remove(String key) {
		Jedis jedis = getConnection();
		jedis.del(key);
		closeConnection( jedis);
		return true;
	}
	
	@Override
	public T get(String key, Class<T> targetClass) {
		Jedis jedis = getConnection();
		Gson gson = new Gson();
		String jsonStr = jedis.get(key);
		if(jsonStr !=null && !"".equalsIgnoreCase( jsonStr )) {
			return gson.fromJson(jsonStr, targetClass);
		}
		return null;
	}

}
