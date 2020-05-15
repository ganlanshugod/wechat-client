/**
* @Company 全域旅游
* @Title: MongoWechatLogger.java 
* @Package org.bana.wechat.common.log.mongo 
* @author liuwenjie   
* @date May 15, 2020 3:05:37 PM 
* @version V1.0   
*/ 
package org.bana.wechat.common.log.mongo;

import org.bana.wechat.common.log.WechatLogDomain;
import org.bana.wechat.common.log.WechatLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

/** 
* @ClassName: MongoWechatLogger 
* @Description: 微信日志的mongo保存方式
* @author liuwenjie   
*/
public class MongoWechatLogger extends WechatLogger{
	
	private MongoTemplate mongoTemplate;
	
	private String collectionName = "t_wechat_api_log";
	
	private static final Logger LOG = LoggerFactory.getLogger(MongoWechatLogger.class);
	/**
	* <p>Description: </p> 
	* @author liuwenjie   
	* @date May 15, 2020 3:06:46 PM 
	* @param logDomain 
	* @see org.bana.wechat.common.log.WechatLogger#doSaveWechatLog(org.bana.wechat.common.log.WechatLogDomain) 
	*/ 
	@Override
	protected void doSaveWechatLog(WechatLogDomain logDomain) {
//		super.doSaveWechatLog(logDomain);
//		Map<String, Object> convertBean = BeanToMapUtil.convertBean(param);
		LOG.info("===微信使用Mongo保存访问记录===" + logDomain.getWechatUrl());
		mongoTemplate.save(logDomain, collectionName);
	}
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	public String getCollectionName() {
		return collectionName;
	}
	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}
	
	
}
