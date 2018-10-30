package com.cg.framework.cache;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.cg.framework.constant.EnvConstant;


/**This class is responsible to load the Redis cache end point and Cache.
 * 
 * @author anangupt
 *
 */

@Component
public class ApplicationCacheConfig {
	
	/**
	 * Address of the Redis service Cache.
	 */
	private String endpoint;	
	
	/**
	 * Port of the Redis service Cache.
	 */
	private int port;
	
	//@PostConstruct
	public void init() {
		endpoint= EnvConstant.CACHE_SERVICE_ENDPOINT.getVal();	
		port= Integer.parseInt( EnvConstant.CACHE_SERVICE_PORT.getVal());
	}
	
	
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	
}
