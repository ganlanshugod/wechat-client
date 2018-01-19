/**
* @Company 青鸟软通   
* @Title: BaseMPTestCase.java 
* @Package org.bana.wechat 
* @author Liu Wenjie   
* @date 2015-8-18 下午5:23:17 
* @version V1.0   
*/ 
package org.bana.wechat;

import org.bana.wechat.mp.token.TokenClient;
import org.bana.wechat.mp.token.domain.AccessToken;
import org.junit.Before;

/** 
 * @ClassName: BaseMPTestCase 
 * @Description: 3PvSQlXGOhmbyCfl9Hl6hcCliZ5tvLonEpzFLgDRgQMD2slS4CdrirdJn6dZlyK-N-4MTC7x64SlJ4jVRyLLSDERikCoz1V_zazapiYBGRM
 *  
 */
public class BaseMPTestCase {

	protected String grantType = "client_credential";
	protected String appId = "wxdede47f42007f37a";
	protected String secret = "b67d8c0253b27c45b515087bb75f6b63";
//	protected String appId = "wx9ea95f1dc1ba973f";
	
//	protected String appId = "wx25d38bc1b0c52ff1";
	//protected String secret = "611d95de732d912637823ba5e731b9de";
//	protected String secret = "bb86f79741416891f06880753cfab210";
	protected AccessToken accessToken;
	
	@Before
	public void init(){
		accessToken = TokenClient.token(grantType, appId, secret);
	}
}
