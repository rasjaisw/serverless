package com.cg.framework.cache;

/**
 * Cache Service Constant is used to declare all the constant which are used for caching service impl.
 * 
 * @author anangupt
 *
 */
public enum CacheServiceConstant {

	AUTH_CACHE_SERVICE("authCacheService"),
	GENERIC_CACHE_SERVICE("genericCacheService");
	
	/**Hold the constant property.
	 * 
	 */
	private String val;

	CacheServiceConstant(String val){
		this.val = val;
	}
	
	public String getVal() {
		return System.getenv(this.val);
	}
	
}
