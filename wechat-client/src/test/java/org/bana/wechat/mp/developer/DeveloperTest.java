/**
* @Company 青鸟软通   
* @Title: DeveloperTest.java 
* @Package org.bana.wechat.mp.developer 
* @author Han Tongyang   
* @date 2015-9-2 下午5:09:44 
* @version V1.0   
*/ 
package org.bana.wechat.mp.developer;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

/** 
 * @ClassName: DeveloperTest 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 *  
 */
public class DeveloperTest {
	
	@Resource
	private SignService signService;
	
	@Test
	public void testSign(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("signature", "4a67d9b5370c4176428a6ac25a98c4f924a838b9");
		map.put("timestamp", "1441184790");
		map.put("nonce", "1260901888");
		System.out.println(signService.checkSignature(map, "banxing3618"));
	}
}
