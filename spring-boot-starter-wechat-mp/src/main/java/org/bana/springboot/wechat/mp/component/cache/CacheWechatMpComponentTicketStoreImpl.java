/**
* @Company 全域旅游
* @Title: CacheWechatMpComponentTicketStoreImpl.java 
* @Package org.bana.springboot.wechat.mp.component.cache 
* @author liuwenjie   
* @date Sep 17, 2020 6:33:35 PM 
* @version V1.0   
*/ 
package org.bana.springboot.wechat.mp.component.cache;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.bana.wechat.mp.component.common.WechatMpComponentTicketStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

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
	private static final String KEY_APPID = "appId";
	private static final String KEY_TIME = "time";
	
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
		String jsonStr = opsForValue.get(CACHENAME+appId);
		if(!StringUtils.isBlank(jsonStr)){
			JSONObject parseObject = JSON.parseObject(jsonStr, JSONObject.class);
			return parseObject.getString(KEY_APPID);
		}
		return null;
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
		JSONObject value = new JSONObject();
		value.put(KEY_APPID, ticket);
		value.put(KEY_TIME, DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		redisTemplate.opsForValue().set(CACHENAME+appId, JSON.toJSONString(value));
		redisTemplate.persist(CACHENAME+appId);
	}
	

}
