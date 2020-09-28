/**
* @Company 全域旅游
* @Title: Encrity.java 
* @Package org.bana.springboot.wechat.mp.component 
* @author liuwenjie   
* @date Sep 28, 2020 10:34:46 AM 
* @version V1.0   
*/ 
package org.bana.springboot.wechat.mp.component;

import org.bana.springboot.test.WechatMpApplication;
import org.bana.wechat.mp.component.common.WXMpCompBizMsgCryptFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/** 
* @ClassName: Encrity 
* @Description: 
* @author liuwenjie   
*/

@SpringBootTest(classes=WechatMpApplication.class)
@RunWith(SpringRunner.class)
public class WXMpBizMsgCryptFactoryTest {

	@Autowired
	private WXMpCompBizMsgCryptFactory wXMpBizMsgCryptFactory;
	
	private String compoenentAppId =  "wxe35ec229c4f65cd9";
	
	String timestamp = "1601258242";
	String nonce="1468299776";
	String encryptType="aes";
	String msgSignature= "1753a985c230ae83b916abcb2b2bb7c3efeee945";
			String signature="9ad3978410c79eb5022b7bf87bad11dc8434143a";
			String  openId = "oTNO107-p12Cg05fnzL1-mccHzb4";
			String  appId ="gh_d1fb40c6be3b";
			String postData="<xml><ToUserName><![CDATA[gh_d1fb40c6be3b]]></ToUserName>"+
"<Encrypt><![CDATA[MXnOlgkDzLthzUuGhF+jAxOPxUEN2BxPsCrOC8dDkd7LGH+fv4vuNj1bHSuoCNgKn6YxGERkS84bu20ux8si1K0ieXrIHX4oftm5V0602oQw9YEH3ov/Iiq56E3jDqp7pAJ/qvQ9gOHS4Dr9QX8qM8I37d6MQzoBcLhWyazhQ5qOBpT3+jWPCHoW96wG6nNZxfYuRp2jrU9oGaFqw7y9n+BQif8aq8gumHWzxp+fAQuctRGRdiIppIvowU1Rd9jD92tXHG2TKEsG6yDktAJ7NEWuHWr8GCponA9SXn/Rzm+IDcEFP4k/vPmd1kyf9l4ZFMXKstTIDAfDY4iIqb8UHMmbFbPCs+OST4qN5/7k+3gtvNoJLpQG5QkstHbhTy+FpdhEqPv86dBXFIB1glJFtfQf/wCVOMVaujV8vcdacr4=]]></Encrypt>"+
"</xml>";
	
	@Test
	public void testDecroyt() {
		String decryptMsg = wXMpBizMsgCryptFactory.getWxBizMsgCrypt(compoenentAppId).decryptMsg(msgSignature, timestamp, nonce, postData);
		System.out.println(decryptMsg);
	}
	
	@Test
	public void testVerify() {
		String verifyUrl = wXMpBizMsgCryptFactory.getWxBizMsgCrypt(compoenentAppId).verifyUrl(msgSignature, timestamp, nonce, postData);
		System.out.println(verifyUrl);
	}
}
