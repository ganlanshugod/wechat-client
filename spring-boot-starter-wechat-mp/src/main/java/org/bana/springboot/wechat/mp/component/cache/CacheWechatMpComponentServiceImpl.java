/**
* @Company 全域旅游
* @Title: CacheWechatMpComponentServiceImpl.java 
* @Package org.bana.springboot.wechat.mp.component.cache 
* @author liuwenjie   
* @date Sep 22, 2020 5:45:50 PM 
* @version V1.0   
*/ 
package org.bana.springboot.wechat.mp.component.cache;

import org.bana.springboot.wechat.mp.WechatMpConstants;
import org.bana.wechat.mp.component.impl.WechatMpComponentServiceImpl;
import org.springframework.cache.annotation.Cacheable;

/** 
* @ClassName: CacheWechatMpComponentServiceImpl 
* @Description: 
* @author liuwenjie   
*/
public class CacheWechatMpComponentServiceImpl extends WechatMpComponentServiceImpl{

	/**
	* <p>Description: </p> 
	* @author liuwenjie   
	* @date Sep 22, 2020 5:46:06 PM 
	* @param componentAppId
	* @return 
	* @see org.bana.wechat.mp.component.impl.WechatMpComponentServiceImpl#createPreAuthCode(java.lang.String) 
	*/ 
	@Override
	@Cacheable(value=WechatMpConstants.CACHE_PRECODE,key="methodName+#componentAppId")
	public String createPreAuthCode(String componentAppId) {
		return super.createPreAuthCode(componentAppId);
	}
}
