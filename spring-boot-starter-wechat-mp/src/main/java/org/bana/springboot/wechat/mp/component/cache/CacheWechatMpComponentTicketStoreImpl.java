/**
* @Company 全域旅游
* @Title: CacheWechatMpComponentTicketStoreImpl.java 
* @Package org.bana.springboot.wechat.mp.component.cache 
* @author liuwenjie   
* @date Sep 17, 2020 6:33:35 PM 
* @version V1.0   
*/ 
package org.bana.springboot.wechat.mp.component.cache;

import org.bana.wechat.mp.component.common.WechatMpComponentTicketStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/** 
* @ClassName: CacheWechatMpComponentTicketStoreImpl 
* @Description: 可以缓存的WechatMpComponentTIcket 
* @author liuwenjie   
*/
public class CacheWechatMpComponentTicketStoreImpl implements WechatMpComponentTicketStore{

	private static final Logger LOG = LoggerFactory.getLogger(CacheWechatMpComponentTicketStoreImpl.class);
	
	@Autowired
    private RedisTemplate<String, String> redisTemplate;
	
	private  static final String CACHENAME = "WECHATMP:ticket:";
	
	/**
	* <p>Description: </p> 
	* @author liuwenjie   
	* @date Sep 17, 2020 6:34:09 PM 
	* @param appId
	* @return 
	* @see org.bana.wechat.mp.component.common.WechatMpComponentTicketStore#getComponentVerifyTicket(java.lang.String) 
	*/ 
	@Override
	public String getComponentVerifyTicket(String appId) {
		LOG.warn("通过redis获取==== appId： "+appId);
		ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
		return opsForValue.get(CACHENAME+appId);
	}

	/**
	* <p>Description: </p> 
	* @author liuwenjie   
	* @date Sep 17, 2020 6:34:09 PM 
	* @param appId
	* @param ticket 
	* @see org.bana.wechat.mp.component.common.WechatMpComponentTicketStore#putComponentVerifyTicket(java.lang.String, java.lang.String) 
	*/ 
	@Override
	public void putComponentVerifyTicket(String appId, String ticket) {
		LOG.info("新增加了一个redis缓存===appId:"+appId+",ticket:"+ticket);
		redisTemplate.opsForValue().set(CACHENAME+appId, ticket);
		redisTemplate.persist(CACHENAME+appId);
	}
	

}
