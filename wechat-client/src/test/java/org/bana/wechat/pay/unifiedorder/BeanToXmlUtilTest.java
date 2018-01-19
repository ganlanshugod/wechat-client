/**
* @Company 青鸟软通   
* @Title: BeanToXmlUtilTest.java 
* @Package org.bana.wechat.pay.unifiedorder 
* @author Liu Wenjie   
* @date 2015-9-29 下午12:49:37 
* @version V1.0   
*/ 
package org.bana.wechat.pay.unifiedorder;

import org.bana.common.util.basic.BeanXmlUtil;
import org.bana.wechat.pay.order.domain.UnifiedOrderDomain;
import org.junit.Test;

/** 
 * @ClassName: BeanToXmlUtilTest 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 *  
 */
public class BeanToXmlUtilTest {

	@Test
	public void test(){
		String str = "<xml><return_code><![CDATA[SUCCESS]]></return_code>"+
					"<return_msg><![CDATA[OK]]></return_msg>"+
					"<appid><![CDATA[wx9ea95f1dc1ba973f]]></appid>"+
					"<mch_id><![CDATA[1265342501]]></mch_id>"+
					"<device_info><![CDATA[Mozilla/5.0 (iPhone; CPU iPhone OS 8_1_2 like Mac OS X) AppleWebKit/600.1.4 (KHTML, like Gecko) Mobile/12B440 MicroMessenger/6.2.7 NetType/WIFI Language/zh_CNs]]></device_info>"+
					"<nonce_str><![CDATA[OJQAQW83ep11JzBg]]></nonce_str>"+
					"<sign><![CDATA[6646F41F9AFE4CCE36D898828030C85A]]></sign>"+
					"<result_code><![CDATA[FAIL]]></result_code>"+
					"<err_code><![CDATA[OUT_TRADE_NO_USED]]></err_code>"+
					"<err_code_des><![CDATA[商户订单号重复]]></err_code_des>"+
					"</xml>";
		UnifiedOrderDomain xmlToBean = BeanXmlUtil.xmlToBean(str, UnifiedOrderDomain.class);
		System.out.println(xmlToBean);
	}
}
