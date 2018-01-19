/**
 * @Company 青鸟软通   
 * @Title: DepartmentDeleteParam.java 
 * @Package org.bana.wechat.qy.department.domain 
 * @author Liu Wenjie   
 * @date 2015-5-9 下午7:56:29 
 * @version V1.0   
 */
package org.bana.wechat.qy.batch.param;

import org.bana.wechat.qy.common.WeChatParam;

/**
 * @ClassName: DepartmentDeleteParam
 * @Description: 部门表删除的方法
 * 
 */
public class DepartmentReplaceParam extends WeChatParam {

	private String media_id; // 部门id

	public String getMedia_id() {
		return media_id;
	}



	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author Liu Wenjie
	 * @date 2015-5-9 下午7:57:33
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DepartmentReplaceParam [media_id=" + media_id + ", access_token="
				+ access_token + "]";
	}



	

}
