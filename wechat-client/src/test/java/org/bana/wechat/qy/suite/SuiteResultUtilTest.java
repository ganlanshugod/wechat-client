/**
* @Company 青鸟软通   
* @Title: SuiteResultUtilTest.java 
* @Package org.bana.wechat.qy.suite 
* @author Liu Wenjie   
* @date 2015-5-13 下午3:22:56 
* @version V1.0   
*/ 
package org.bana.wechat.qy.suite;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.bana.wechat.qy.suite.domain.CallBackResult;
import org.bana.wechat.qy.suite.domain.ReceiveSuitResult;
import org.bana.wechat.qy.suite.domain.ReceiveSuiteTicket;
import org.junit.Test;

/** 
 * @ClassName: SuiteResultUtilTest 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 *  
 */
public class SuiteResultUtilTest {
	
	@Test
	public void testParseConcatChange(){
		String xml = "<xml>"+
    "<SuiteId><![CDATA[tj4asffe99e54c0f4c]]></SuiteId>"+
    "<AuthCorpId><![CDATA[wxf8b4f85f3a794e77]]></AuthCorpId>"+
    "<InfoType><![CDATA[change_contact]]></InfoType>"+
    "<TimeStamp>1403610513</TimeStamp>"+
    "<ChangeType><![CDATA[create_user]]></ChangeType>"+
    "<UserID><![CDATA[zhangsan]]></UserID>"+
    "<Name><![CDATA[张三]]></Name>"+
   " <Department><![CDATA[1,2,3]]></Department>"+
    "<Mobile><![CDATA[15913215421]]></Mobile>"+
    "<Position><![CDATA[产品经理]]></Position>"+
    "<Gender>1</Gender>"+
    "<Email><![CDATA[zhangsan@gzdev.com]]></Email>"+
    "<Status>2</Status>"+
    "<Avatar><![CDATA[http://wx.qlogo.cn/mmopen/ajNVdqHZLLA3WJ6DSZUfiakYe37PKnQhBIeOQBO4czqrnZDS79FH5Wm5m4X69TBicnHFlhiafvDwklOpZeXYQQ2icg/0]]></Avatar>"+
    "<EnglishName><![CDATA[zhangsan]]></EnglishName>"+
    "<IsLeader>1</IsLeader>"+
   " <Telephone><![CDATA[020-3456788]]></Telephone>"+
   " <ExtAttr>"+
   "     <Item>"+
   "     <Name><![CDATA[爱好]]></Name>"+
   "     <Value><![CDATA[旅游]]></Value>"+
   "     </Item>"+
    "    <Item>"+
   "     <Name><![CDATA[卡号]]></Name>"+
    "    <Value><![CDATA[1234567234]]></Value>"+
   "     </Item>"+
   " </ExtAttr>"+
"</xml>";
		Object parseXmlToObject = SuiteResultUtil.parseXmlToObject(xml);
		System.out.println(parseXmlToObject.getClass());
		System.out.println(parseXmlToObject);
	}
	
	@Test
	public void testParseXmlToObject4(){
		String xml = "<xml>" + 
		  "<SuiteId><![CDATA[tj46d5dffebef1ce32]]></SuiteId>" + 
		  "<AuthCode><![CDATA[eW2Ripdp68qdVivBPHLhZvDV4XbEJvoAfYUWi-aMF7zeIy1xOPlKPuw3PRNqzVnHxTi_mQBb-f8ZuWatUMUO4A]]></AuthCode>" + 
		  "<InfoType><![CDATA[create_auth]]></InfoType>" + 
		  "<TimeStamp>1466517564</TimeStamp>" + 
		"</xml>";
		Object parseXmlToObject = SuiteResultUtil.parseXmlToObject(xml);
		System.out.println(parseXmlToObject.getClass());
		System.out.println(parseXmlToObject);
	}

	/**
	 * Test method for {@link org.bana.wechat.qy.suite.SuiteResultUtil#parseXmlToObject(java.lang.String)}.
	 */
	@Test
	public void testParseXmlToObject() {
		String xml = "<xml>" +
		"<SuiteId><![CDATA[wxfc918a2d200c9a4c]]></SuiteId>" +
		"<InfoType> <![CDATA[suite_ticket]]></InfoType>" +
		"<TimeStamp>1403610513</TimeStamp>" +
		"<SuiteTicket><![CDATA[asdfasfdasdfasdf]]></SuiteTicket>" +
	"</xml>	";
//		ByteArrayInputStream is = new ByteArrayInputStream(xml.getBytes());
		ReceiveSuitResult result = (ReceiveSuitResult)SuiteResultUtil.parseXmlToObject(xml);
		assertTrue(result instanceof ReceiveSuiteTicket);
		ReceiveSuiteTicket token = (ReceiveSuiteTicket)result;
		assertNotNull(token.getSuiteTicket());
	}
	
	
	@Test
	public void testParseXmlToObject2() {
		String xml = "<xml><ToUserName><![CDATA[wxc2a104d974df2b69]]></ToUserName>" +
"<FromUserName><![CDATA[QY46_gxcj_1433834399033]]></FromUserName>" +
"<CreateTime>1433991208</CreateTime>" +
"<MsgType><![CDATA[event]]></MsgType>" +
"<AgentID>3</AgentID>" +
"<Event><![CDATA[enter_agent]]></Event>" +
"<EventKey><![CDATA[]]></EventKey>" +
"</xml>";
//		ByteArrayInputStream is = new ByteArrayInputStream(xml.getBytes());
		CallBackResult result = (CallBackResult)SuiteResultUtil.parseXmlToObject(xml);
		System.out.println(result);
		assertNotNull(result.getEvent());
	}
	
	@Test
	public void testParseXmlToObjecdt_text(){
		String xml = "<xml><ToUserName><![CDATA[wx10a64b88403bbf05]]></ToUserName>" +
		"<FromUserName><![CDATA[QY110_ZJH_1443099435642]]></FromUserName>" +
		"<CreateTime>1443193880</CreateTime>" +
		"<MsgType><![CDATA[text]]></MsgType>" +
		"<Content><![CDATA[sds]]></Content>" +
		"<MsgId>4376639887294595077</MsgId>" +
		"<AgentID>7</AgentID>" +
		"</xml>";
		CallBackResult result = (CallBackResult)SuiteResultUtil.parseXmlToObject(xml);
		System.out.println(result);
		assertNotNull(result.getContent());
	}
	
	
	@Test
	public void testParseXmlToObjectcancel_auth() {
		String xml = "<xml><SuiteId><![CDATA[tj161090b557a68202]]></SuiteId>" +
					"<AuthCorpId><![CDATA[wx48519e050305fe95]]></AuthCorpId>" +
					"<InfoType><![CDATA[cancel_auth]]></InfoType>" +
					"<TimeStamp>1443740526</TimeStamp>" +
					"</xml>";
//		ByteArrayInputStream is = new ByteArrayInputStream(xml.getBytes());
		ReceiveSuitResult result = (ReceiveSuitResult)SuiteResultUtil.parseXmlToObject(xml);
		System.out.println(result);
		assertNotNull(result.getInfoType());
	}
	
	@Test
	public void testParseXmlToObjectchangeAuth(){
		String xml = "<xml><SuiteId><![CDATA[tjcc8a8b758ba3aee0]]></SuiteId>" +
				"<AuthCorpId><![CDATA[wx42d23341cd3a2df9]]></AuthCorpId>" +
				"<InfoType><![CDATA[change_auth]]></InfoType>" +
				"<TimeStamp>1443855156</TimeStamp>" +
				"</xml>";
		ReceiveSuitResult result = (ReceiveSuitResult)SuiteResultUtil.parseXmlToObject(xml);
		System.out.println(result);
		assertNotNull(result.getInfoType());
	}
	
	@Test
	public void testParseXmlToObjectLinkMessage(){
		String xml = "<xml><ToUserName><![CDATA[wxc2a104d974df2b69]]></ToUserName>"+
			"<FromUserName><![CDATA[QY71_lxjj_1434013153877]]></FromUserName>"+
			"<CreateTime>1479294158</CreateTime>"+
			"<MsgType><![CDATA[link]]></MsgType>"+
			"<Title><![CDATA[名师伴行 | 如何帮助孩子建立自我管理意识]]></Title>"+
			"<Description><![CDATA[自我管理其实是个很大的话题，很多家长对孩子在自我管理方面有着挺高的要求，我也见过不少家长的烦恼在于他们的期待超越了这个年龄孩子所具备的能力。那么>如何帮助孩子建立自我管理意识呢？]]></Description>"+
			"<Url><![CDATA[http://mp.weixin.qq.com/s?__biz=MzIxNDYxNjk1NA==&mid=2247483738&idx=1&sn=56f74caecb0b77b20a877b5792fa864a&chksm=97a59f4fa0d216597be14bc2496a33f2ff321663f4f35c65fe6744960fb584349d494ae7af32&mpshare=1&scene=1&srcid=1116g9V9G3ixdYbTCfH36sZ3#rd]]></Url>"+
			"<PicUrl><![CDATA[http://shp.qpic.cn/bizmp/TSjd6sHIgVrI9ibGIpZsKYpliaUiaUgKy2P4tLvsgjMbOETGOwpA0KAPQ/]]></PicUrl>"+
			"<MsgId>3316026459773507205</MsgId>"+
			"<AgentID>295</AgentID>"+
			"</xml>";
		CallBackResult parseXmlToObject = (CallBackResult)SuiteResultUtil.parseXmlToObject(xml);
		System.out.println(parseXmlToObject);
	}
}
