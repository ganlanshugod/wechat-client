/**
* @Company 青鸟软通   
* @Title: InviteClientTest.java 
* @Package org.bana.wechat.qy.invite 
* @author Liu Wenjie   
* @date 2015-5-11 下午10:08:26 
* @version V1.0   
*/ 
package org.bana.wechat.qy.invite;

import static org.junit.Assert.*;

import org.bana.wechat.BaseTestCase;
import org.bana.wechat.cp.token.domain.AccessToken;
import org.bana.wechat.qy.connection.GetToken;
import org.bana.wechat.qy.invite.param.InviteSendParam;
import org.junit.Test;

/** 
 * @ClassName: InviteClientTest 
 * @Description: 测试成员邀请的接口
 *  
 */
public class InviteClientTest extends BaseTestCase{

	/**
	 * Test method for {@link org.bana.wechat.qy.invite.InviteClient#send(org.bana.wechat.qy.invite.param.InviteSendParam)}.
	 */
	@Test
	public void testSend() {
		AccessToken accessToken = GetToken.getAccessToken(cropId, secret);
		InviteSendParam sendParam = new InviteSendParam();
		sendParam.setAccess_token(accessToken.getAccessToken());
		sendParam.setUserid("lijiaxiu");
		Integer type = InviteClient.send(sendParam);
		assertNotNull(type);
	}

}
