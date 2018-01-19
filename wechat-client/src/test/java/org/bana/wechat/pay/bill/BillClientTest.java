/**
* @Company 青鸟软通   
* @Title: BillClientTest.java 
* @Package org.bana.wechat.pay.bill 
* @author Liu Wenjie   
* @date 2015-9-24 下午2:21:23 
* @version V1.0   
*/ 
package org.bana.wechat.pay.bill;

import static org.junit.Assert.*;

import java.util.UUID;

import org.bana.wechat.BasePayTestCase;
import org.bana.wechat.pay.bill.param.DownBillParam;
import org.bana.wechat.pay.common.SignUtil;
import org.junit.Test;

/** 
 * @ClassName: BillClientTest 
 * @Description: 测试账单下载的方法
 *  
 */
public class BillClientTest extends BasePayTestCase{

	/**
	 * Test method for {@link org.bana.wechat.pay.bill.BillClient#downloadbill(org.bana.wechat.pay.bill.param.DownBillParam)}.
	 */
	@Test
	public void testDownloadbill() {
		DownBillParam param = new DownBillParam();
		initPayParam(param);
		param.setBill_date("20150922");
		param.setBill_type(DownBillParam.BILL_TYPE_ALL);
		param.setSign(SignUtil.getSign(param, apiKey));
		BillClient.downloadbill(param);
	}
	
	@Test
	public void testUUID(){
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 10000 ; i++) {
//			System.out.println(i);
			int hashCode = UUID.randomUUID().toString().hashCode();
		}
		System.out.println(System.currentTimeMillis() - begin);
//		System.out.println(hashCode);
//		623993406
//		-197046103
//		668457551
//		1283515671
//		1395387152
//		1668710221
//		1843847906
//		842827537
//		258465870
//		1087107305
//		1214503157
//		-695496881
//		2083100904
//		-2006845247
//		1235948628
//		-114064978
//		-1100840545
//		1968862523
//		2027312967
//		-489405967
	}

}
