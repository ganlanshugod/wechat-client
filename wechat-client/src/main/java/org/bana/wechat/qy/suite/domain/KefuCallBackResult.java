/**
* @Company 艾美伴行   
* @Title: KefuCallBackResult.java 
* @Package org.bana.wechat.qy.suite.domain 
* @author Yang Shuangshuang   
* @date 2016-5-6 下午14:08:28 
* @version V1.0   
*/ 
package org.bana.wechat.qy.suite.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** 
 * @ClassName: KefuCallBackResult 
 * @Description: 微信客服回调的返回值结果对象
 * <xml>
   <AgentType>kf_internal</AgentType>
   <ToUserName>CORPID</ToUserName>
   <ItemCount>3</ItemCount>
   <PackageId>3156175696255</PackageId>
   <Item>
       <FromUserName><![CDATA[UserID]]></FromUserName>
       <CreateTime>1348831860</CreateTime>
       <MsgType><![CDATA[text]]></MsgType>
       <Content><![CDATA[test message]]></Content>
       <MsgId>1234567890123456</MsgId>
       <Receiver>
           <Type>userid</Type>
           <Id>lisi</Id>
       </Receiver>
   </Item>
</xml>
 *  
 */
@XmlRootElement(name="xml")
public class KefuCallBackResult implements Serializable{

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 2567559801968336408L;
	
	private String toUserName;
	private String agentType;
	private Long itemCount;
	private String packageId;
	private MessageItem item;
	
	
	/**
	 * @Description: 属性 toUserName 的get方法 
	 * @return toUserName
	 */
	@XmlElement(name="ToUserName")
	public String getToUserName() {
		return toUserName;
	}
	/**
	 * @Description: 属性 toUserName 的set方法 
	 * @param toUserName 
	 */
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	/**
	 * @Description: 属性 agentType 的get方法 
	 * @return agentType
	 */
	@XmlElement(name="AgentType")
	public String getAgentType() {
		return agentType;
	}
	
	/**
	 * @Description: 属性 agentType 的set方法 
	 * @param agentType 
	 */
	public void setAgentType(String agentType) {
		this.agentType = agentType;
	}
	
	/**
	 * @Description: 属性 itemCount 的get方法 
	 * @return itemCount
	 */
	@XmlElement(name="ItemCount")
	public Long getItemCount() {
		return itemCount;
	}
	
	/**
	 * @Description: 属性 itemCount 的set方法 
	 * @param itemCount 
	 */
	public void setItemCount(Long itemCount) {
		this.itemCount = itemCount;
	}
	
	/**
	 * @Description: 属性 packageId 的get方法 
	 * @return packageId
	 */
	@XmlElement(name="PackageId")
	public String getPackageId() {
		return packageId;
	}
	
	/**
	 * @Description: 属性 packageId 的set方法 
	 * @param packageId 
	 */
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	
	/**
	 * @Description: 属性 item 的get方法 
	 * @return item
	 */
	@XmlElement(name="Item")
	public MessageItem getItem() {
		return item;
	}
	
	/**
	 * @Description: 属性 item 的set方法 
	 * @param item 
	 */
	public void setItem(MessageItem item) {
		this.item = item;
	}
	
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-10-9 下午2:08:10 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "KefuCallBackResult [toUserName=" + toUserName + ", packageId=" + packageId + ", itemCount=" + itemCount
				+ ", agentType=" + agentType +", item=" + item + "]";
	}

	
}
