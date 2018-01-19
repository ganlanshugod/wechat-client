/**
* @Company 青岛艾瑞思   
* @Title: LoginUserTypeEnum.java 
* @Package org.bana.wechat.qy.login 
* @author Richard Core   
* @date 2016-3-22 下午4:18:36 
* @version V1.0   
*/ 
package org.bana.wechat.qy.login;


/** 
 * @ClassName: LoginUserTypeEnum 
 * @Description: 登录用户类型
 *  
 */
public enum LoginUserTypeEnum {
	
	企业号创建者(1),
	企业号内部系统管理员(2),
	企业号外部系统管理员(3),
	企业号分级管理员(4),
	企业号成员(5);
	
	private Integer type;
	
	private LoginUserTypeEnum(Integer type){
		this.type = type;
	}
	public static LoginUserTypeEnum getInstance(Integer type){
		for (LoginUserTypeEnum userType : values()) {
			if(userType.type.equals(type)){
				return userType;
			}
		}
		return 企业号成员;
	}
	
	
	/**
	 * @Description: 属性 type 的get方法 
	 * @return type
	 */
	public Integer getType() {
		return type;
	}
	
}
