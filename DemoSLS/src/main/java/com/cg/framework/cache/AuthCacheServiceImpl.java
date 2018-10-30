package com.cg.framework.cache;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cg.framework.base.auth.AuthDTO;
import com.cg.framework.util.DateUtil;
import com.google.gson.Gson;

import redis.clients.jedis.Jedis;

/**
 * Returns the connection object for cache
 * @author anangupt
 * 
 */
@Component
@Qualifier("authCacheService")
public class AuthCacheServiceImpl extends AbstractCachingService<AuthDTO> implements CachingService<AuthDTO> {

	
	/* (non-Javadoc)
	 * @see com.afc.framework.cache.service.ApplicationServiceCache#setUser(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean put(String tokenID, AuthDTO authdto){
		Jedis jedis = getConnection();
		Gson gson = new Gson();
		authdto.setLoginTime(String.valueOf(DateUtil.getUTCTimeinMillis()));
		jedis.set(tokenID, gson.toJson(authdto));
		closeConnection(jedis );
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.afc.framework.cache.service.ApplicationServiceCache#removeUser(java.lang.String)
	 */
	@Override
	public boolean remove(String tokenID) {
		Jedis jedis = getConnection();
		jedis.del(tokenID);
		closeConnection( jedis);
		return true;
	}
	
	@Override
	public AuthDTO get(String tokenID, Class<AuthDTO> targetClass) {
		Jedis jedis = getConnection();
		Gson gson = new Gson();
		AuthDTO authDTO = null;
		String jsonStr = jedis.get(tokenID);
		if(jsonStr !=null && !"".equalsIgnoreCase( jsonStr )) {
			authDTO = gson.fromJson(jsonStr, targetClass);
		}
		closeConnection(jedis);
		return authDTO;
	}

}
