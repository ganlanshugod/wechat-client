/**
* @Company 全域旅游
* @Title: CacheComponentTokenServiceImpl.java 
* @Package org.bana.springboot.wechat.mp.component.cache 
* @author liuwenjie   
* @date Sep 18, 2020 10:49:22 AM 
* @version V1.0   
*/ 
package org.bana.springboot.wechat.mp.component.cache;

import org.bana.springboot.wechat.mp.WechatMpConstants;
import org.bana.wechat.mp.component.impl.SimpleComponentTokenServiceImpl;
import org.springframework.cache.annotation.Cacheable;

/** 
* @ClassName: CacheComponentTokenServiceImpl 
* @Description: 支持缓存的第三方平台获取组件
* @author liuwenjie   
*/
public class CacheComponentTokenServiceImpl extends SimpleComponentTokenServiceImpl{

	/**
	* <p>Description: </p> 
	* @author liuwenjie   
	* @date Sep 18, 2020 10:50:12 AM 
	* @param appId
	* @return 
	* @see org.bana.wechat.mp.component.impl.SimpleComponentTokenServiceImpl#getComponentToken(java.lang.String) 
	*/ 
	@Override
	@Cacheable(value=WechatMpConstants.CACHE_NAME,key="methodName+#appId")
	public String getComponentToken(String appId) {
		return super.getComponentToken(appId);
	}
	
	
}
