/**
* @Company 青鸟软通   
* @Title: ShortUrlUtilTest.java 
* @Package org.bana.wechat.mp.common 
* @author Liu Wenjie   
* @date 2015-10-29 下午5:03:26 
* @version V1.0   
*/ 
package org.bana.wechat.mp.common;

import org.bana.wechat.BaseMPTestCase;
import org.junit.Assert;
import org.junit.Test;

/** 
 * @ClassName: ShortUrlUtilTest 
 * @Description: 
 *  
 */
public class ShortUrlUtilTest extends BaseMPTestCase{

	@Test
	public void test() {
		String longUrl = "http://iwechat.i3618.com.cn/wechat-web/wechatcorp/notice/index?corpId=wxecc7d30e791adfb8&agentId=22&appTarget=noticeDetail&noticeId=8297";
		String shortUrl = ShortUrlUtil.shortUrl(accessToken.getAccess_token(), longUrl);
		Assert.assertNotNull(shortUrl);
	}
	
	@Test
	public void test2(){
		String accessToken = "11_Iyn62Km0JuJJQtCtXf6JdKBIXvm2FrhAQNnkzySf9rz6-gZGRGxFUQmp1UneVkSzfYJTzIiSsCGIidAwDLo1Q7Ot-YceEqZbDPbHKoA23RQN8BWStKpaeOKfGb1fLvMMSx3H5OPVMr1h7UlbGFFbABAMLL";
		String longUrl = "http://www.qingdaodujia.cn/wxmp/shop/bus/shop01?appId=wx5bc259b375eb9572";
		String shortUrl = ShortUrlUtil.shortUrl(accessToken, longUrl);
		System.out.println(shortUrl);
	}

}
