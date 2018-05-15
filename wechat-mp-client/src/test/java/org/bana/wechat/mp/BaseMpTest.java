/**
 * @Company JBINFO
 * @Title: BaseMpTest.java
 * @Package org.bana.wechat.mp
 * @author Liu Wenjie
 * @date 2018年5月15日 下午12:31:42
 * @version V1.0
 */
package org.bana.wechat.mp;

import org.bana.wechat.mp.token.impl.SimpleAccessTokenServiceImpl;
import org.junit.BeforeClass;

/**
 * @ClassName: BaseMpTest
 * @Description: 
 * @author Liu Wenjie
 */
public class BaseMpTest {
	
	protected static SimpleAccessTokenServiceImpl tokenService;

	protected static String appId = "wxa7eeec1744e8d41e";

	protected static String secret = "d6fadb9f2aad175b7e2bcc35048b35ab";
	
	@BeforeClass
	public static void beforeClass(){
		tokenService =  new SimpleAccessTokenServiceImpl();
	}
}
