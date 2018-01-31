/**
 * @Company JBINFO
 * @Title: WechatCpResultHandlerTest.java
 * @Package org.bana.wechat.cp.common
 * @author Zhang Zhichao
 * @date 2018年1月29日 下午7:59:32
 * @version V1.0
 */
package org.bana.wechat.cp.common;

import static org.junit.Assert.*;

import org.bana.wechat.cp.token.domain.SuiteAccessToken;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: WechatCpResultHandlerTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Zhang Zhichao
 */
public class WechatCpResultHandlerTest {

	/**
	 * Test method for {@link org.bana.wechat.cp.common.WechatCpResultHandler#handleResult(com.alibaba.fastjson.JSONObject, java.lang.Class)}.
	 */
	@Test
	public void testHandleResultJSONObjectClassOfT() {
		String s = "{\"suite_access_token\":\"Qt7GG7AAhtE6-6_vS-koUlatEOPHvG-wviKhSRu1OtmlnYlCdk63PLZxBkUvyCHk--ztDgF4_vM5ArRRYtvf9Ov9dKHtE0pNgtVAnZ6ARPE\",\"expires_in\":7200}";
		SuiteAccessToken handleResult = WechatCpResultHandler.handleResult(JSON.parseObject(s), SuiteAccessToken.class);
		System.out.println(handleResult);
	}

}
