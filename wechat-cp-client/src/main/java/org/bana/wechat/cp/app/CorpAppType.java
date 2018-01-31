/**
 * @Company JBINFO
 * @Title: CorpAppType.java
 * @Package org.bana.wechat.cp.app
 * @author Liu Wenjie
 * @date 2018年1月19日 下午2:52:43
 * @version V1.0
 */
package org.bana.wechat.cp.app;

/**
 * @ClassName: CorpAppType
 * @Description: 企业应用的类型
 * @author Liu Wenjie
 */
public enum CorpAppType {

	自建应用("102"),
	通讯录管理API("104"),
	第三方托管("101"),
	第三方通讯录("103");
	
	private String type;
	private CorpAppType(String type) {
		this.type = type;
	}
	/**
	 * @Description: 属性 type 的get方法 
	 * @return type
	 */
	public String getType() {
		return type;
	}
	
	public static CorpAppType instance(String type){
		for (CorpAppType appType : values()) {
			if(appType.getType().equals(type)){
				return appType;
			}
		}
		return null;
	}
}
