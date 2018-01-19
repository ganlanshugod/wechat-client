package org.bana.wechat.cp.common;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/** 
 * @ClassName: WeChatParam 
 * @Description: 访问微信接口连接的通用参数抽象类
 *  
 */
public class WeChatCPParam implements Serializable{
	
	/**
	 * @Fields serialVersionUID : 
	 */
	private static final long serialVersionUID = -9199153742429752091L;
	/** 
	* @Fields access_token : 企业号id
	*/ 
	@JSONField(serialize=false)  
	protected String corpId;
	/**
	 * @Fields agentId : 应用id
	 */
	@JSONField(serialize=false)  
	protected String agentId;

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	
}
