/**
* @Company 全域旅游
* @Title: CacheComponentAccessTokenServiceImpl.java 
* @Package org.bana.springboot.wechat.mp.component.cache 
* @author liuwenjie   
* @date Sep 18, 2020 3:23:36 PM 
* @version V1.0   
*/ 
package org.bana.springboot.wechat.mp.component.cache;

import org.bana.springboot.wechat.mp.WechatMpConstants;
import org.bana.wechat.mp.component.impl.SimpleComponentAccessTokenServiceImpl;
import org.springframework.cache.annotation.Cacheable;

/** 
* @ClassName: CacheComponentAccessTokenServiceImpl 
* @Description: 
* @author liuwenjie   
*/
public class CacheComponentAccessTokenServiceImpl extends SimpleComponentAccessTokenServiceImpl{

	/**
	* <p>Description: </p> 
	* @author liuwenjie   
	* @date Sep 18, 2020 3:23:51 PM 
	* @param appId
	* @return 
	* @see org.bana.wechat.mp.component.impl.SimpleComponentAccessTokenServiceImpl#getAccessToken(java.lang.String) 
	*/ 
	@Override
	@Cacheable(value=WechatMpConstants.CACHE_NAME,key="methodName+'Component'+#appId")
	public String getAccessToken(String appId) {
		return super.getAccessToken(appId);
	}
}
