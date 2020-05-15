/**
* @Company 全域旅游
* @Title: HttpHelperService.java 
* @Package org.bana.wechat.common.http 
* @author liuwenjie   
* @date May 15, 2020 2:26:18 PM 
* @version V1.0   
*/ 
package org.bana.wechat.common.http;

import org.bana.wechat.common.HttpHelper;

/** 
* @ClassName: HttpHelperService 
* @Description: 一个带有httpHelper的基础实现类
* @author liuwenjie   
*/
public class HttpHelperService {
	
	protected HttpHelper httpHelper ;
	
	/** 
	* <p>Description: </p> 
	* @author liuwenjie   
	* @date May 15, 2020 2:29:21 PM  
	*/
	public HttpHelperService() {
		if(httpHelper == null) {
			httpHelper = new HttpHelper();
		}
	}

	public HttpHelper getHttpHelper() {
		return httpHelper;
	}

	public void setHttpHelper(HttpHelper httpHelper) {
		this.httpHelper = httpHelper;
	}
	
}
