package com.qq.weixin.map.aes;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;

public class Sample {

	private WXBizMsgCrypt wxcpt;

	@Before
	public void init() throws AesException {
//		String sToken = "QDG6eK";
//		String sCorpID = "wx5823bf96d3bd56c7";
//		String sEncodingAESKey = "jWmYm7qr5nMoAUwZRjGtBxmz3KA1tkAj3ykkR6q2B2C";
		
		String sToken = "e7LVf3PPLJOd4YVZKmObhOL0";
		String sCorpID = "tj5a30d5d5814ff7d0";
		String sEncodingAESKey = "wuHqKOUAckV4In2OoOnOyuxY19ACPFU0dTHAufzHaD7";
		
		wxcpt = new WXBizMsgCrypt(sToken, sEncodingAESKey, sCorpID);
	}

	/**
	 * @Description: ------------使用示例一：验证回调URL---------------
	 *               企业开启回调模式时，企业号会向验证url发送一个get请求 假设点击验证时，企业收到类似请求： GET
	 *               /cgi-bin/wxpush?msg_signature=5
	 *               c45ff5e21c57e6ad56bac8758b79b1d9ac89fd3
	 *               &timestamp=1409659589
	 *               &nonce=263014780&echostr=P9nAzCzyDtyTWESHep1vC5X9xho
	 *               %2FqYX3Zpb4yKa9SKld1DsH3Iyt3tP3zNdtp
	 *               %2B4RPcs8TgAE7OaBO%2BFZXvnaqQ%3D%3D HTTP/1.1 Host:
	 *               qy.weixin.qq.com
	 *               接收到该请求时，企业应
	 *               1.解析出Get请求的参数，包括消息体签名(msg_signature)，时间戳(timestamp
	 *               )，随机数字串(nonce)以及公众平台推送过来的随机加密字符串(echostr), 这一步注意作URL解码。
	 *               2.验证消息体签名的正确性 3. 解密出echostr原文，将原文当作Get请求的response，返回给公众平台
	 *               第2，3步可以用公众平台提供的库函数VerifyURL来实现。
	 * @author Liu Wenjie
	 * @throws AesException 
	 * @date 2015-5-12 下午10:16:07
	 */
	@Test
	public void test1() throws AesException {
		/**
		 * echoStr=nudOYh+lf1mmABuzie8ejWMA1BcdpAQfrINFY3eXr1neqdOLBVthdUfhbCVbuSvHPrqmiNFH06QSniHgfhxxVQ==
		 * ,nonce=510197131
		 * ,timeStamp=1466509103
		 * ,msgSignature=e434376c5cec62e6765e666dd0ef8277c3cc72b6
		 */
		// 解析出url上的参数值如下：
		// String sVerifyMsgSig = HttpUtils.ParseUrl("msg_signature");
		String sVerifyMsgSig = "5c45ff5e21c57e6ad56bac8758b79b1d9ac89fd3";
		sVerifyMsgSig = "e434376c5cec62e6765e666dd0ef8277c3cc72b6";
		// String sVerifyTimeStamp = HttpUtils.ParseUrl("timestamp");
		String sVerifyTimeStamp = "1409659589";
		sVerifyTimeStamp = "1466509103";
		// String sVerifyNonce = HttpUtils.ParseUrl("nonce");
		String sVerifyNonce = "263014780";
		sVerifyNonce = "510197131";
//		 String sVerifyEchoStr = HttpUtils.ParseUrl("echostr");
		String sVerifyEchoStr = "P9nAzCzyDtyTWESHep1vC5X9xho/qYX3Zpb4yKa9SKld1DsH3Iyt3tP3zNdtp+4RPcs8TgAE7OaBO+FZXvnaqQ==";
		sVerifyEchoStr = "nudOYh+lf1mmABuzie8ejWMA1BcdpAQfrINFY3eXr1neqdOLBVthdUfhbCVbuSvHPrqmiNFH06QSniHgfhxxVQ==";
		String sEchoStr; // 需要返回的明文
			sEchoStr = wxcpt.VerifyURL(sVerifyMsgSig, sVerifyTimeStamp, sVerifyNonce, sVerifyEchoStr);
			System.out.println("verifyurl echostr: " + sEchoStr);
			// 验证URL成功，将sEchoStr返回
			// HttpUtils.SetResponse(sEchoStr);
	}

	/**
	 * @Description: ------------使用示例二：对用户回复的消息解密---------------
	 *               用户回复消息或者点击事件响应时，
	 *               企业会收到回调消息，此消息是经过公众平台加密之后的密文以post形式发送给企业，密文格式请参考官方文档
	 *               假设企业收到公众平台的回调消息如下： POST /cgi-bin/wxpush?
	 *               msg_signature=477715d
	 *               11cdb4164915debcba66cb864d751f3e6&timestamp
	 *               =1409659813&nonce=1372623149 
	 *               HTTP/1.1 Host:
	 *               qy.weixin.qq.com Content-Length: 613 <xml>
	 *               <ToUserName><![CDATA
	 *               [wx5823bf96d3bd56c7]]></ToUserName><Encrypt
	 *               ><![CDATA[RypEvHKD8QQKFhvQ6QleEB4J58tiPdvo
	 *               +rtK1I9qca6aM/wvqnLSV5zEPeusUiX5L5X
	 *               /0lWfrf0QADHHhGd3QczcdCUpj911L3vg3W
	 *               /sYYvuJTs3TUUkSUXxaccAS0qhxchrRYt66wiSpGLYL42aM6A8dTT
	 *               +6k4aSknmPj48kzJs8qLjvd4Xgpue06DOdnLxAUHzM6+kDZ+HMZfJYuR+
	 *               LtwGc2hgf5gsijff0ekUNXZiqATP7PF5mZxZ3Izoun1s4zG4LUMnvw2r
	 *               +KqCKIw+3IQH03v+
	 *               BCA9nMELNqbSf6tiWSrXJB3LAVGUcallcrw8V2t9EL4EhzJWrQUax5wLVMNS0
	 *               +rUPA3k22Ncx4XXZS9o0MBH27Bo6BpNelZpS+/
	 *               uh9KsNlY6bHCmJU9p8g7m3fVKn28H3KDYA5Pl
	 *               /T8Z1ptDAVe0lXdQ2YoyyH2uyPIGHBZZIs2pDBS8R07
	 *               +qN+E7Q==]]></Encrypt> <AgentID><![CDATA[218]]></AgentID>
	 *               </xml>
	 * 
	 *               企业收到post请求之后应该
	 *               1.解析出url上的参数，包括消息体签名(msg_signature)，时间戳(timestamp
	 *               )以及随机数字串(nonce) 2.验证消息体签名的正确性。
	 *               3.将post请求的数据进行xml解析，并将<Encrypt
	 *               >标签的内容进行解密，解密出来的明文即是用户回复消息的明文，明文格式请参考官方文档
	 *               第2，3步可以用公众平台提供的库函数DecryptMsg来实现。
	 * @author Liu Wenjie
	 * @throws AesException 
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 * @date 2015-5-12 下午10:16:56
	 */
//	@Test
	public void test2() throws AesException, ParserConfigurationException, SAXException, IOException {
		// String sReqMsgSig = HttpUtils.ParseUrl("msg_signature");
		String sReqMsgSig = "477715d11cdb4164915debcba66cb864d751f3e6";
		// String sReqTimeStamp = HttpUtils.ParseUrl("timestamp");
		String sReqTimeStamp = "1409659813";
		// String sReqNonce = HttpUtils.ParseUrl("nonce");
		String sReqNonce = "1372623149";
		// post请求的密文数据
		// sReqData = HttpUtils.PostData();
		String sReqData = "<xml><ToUserName><![CDATA[wx5823bf96d3bd56c7]]></ToUserName><Encrypt><![CDATA[RypEvHKD8QQKFhvQ6QleEB4J58tiPdvo+rtK1I9qca6aM/wvqnLSV5zEPeusUiX5L5X/0lWfrf0QADHHhGd3QczcdCUpj911L3vg3W/sYYvuJTs3TUUkSUXxaccAS0qhxchrRYt66wiSpGLYL42aM6A8dTT+6k4aSknmPj48kzJs8qLjvd4Xgpue06DOdnLxAUHzM6+kDZ+HMZfJYuR+LtwGc2hgf5gsijff0ekUNXZiqATP7PF5mZxZ3Izoun1s4zG4LUMnvw2r+KqCKIw+3IQH03v+BCA9nMELNqbSf6tiWSrXJB3LAVGUcallcrw8V2t9EL4EhzJWrQUax5wLVMNS0+rUPA3k22Ncx4XXZS9o0MBH27Bo6BpNelZpS+/uh9KsNlY6bHCmJU9p8g7m3fVKn28H3KDYA5Pl/T8Z1ptDAVe0lXdQ2YoyyH2uyPIGHBZZIs2pDBS8R07+qN+E7Q==]]></Encrypt><AgentID><![CDATA[218]]></AgentID></xml>";
		String sReqData2 = "<xml><ToUserName><![CDATA[tj06154271e7f5928e]]></ToUserName><Encrypt><![CDATA[5RjmMLOo9cZ4mmu86o9JGYOYORi21XOrkxDuxcyHGNCYRO0quw020m2y8UU3NnokjXUmUS2WyTon1ylLOnzqYeOxEpCFEbI1lgndr7tLXuSYXsgH60XHV5RuPMp3r2s9njkvHLYqCzft/EL5SxpeJNECqVfDosF4nQJvHLnYKwFZC0UJg/FTJMlxofGMrHS2iGAXgFnWbZQlrRp4QYDu/iOatyX99ruL9TGFD4SpdJbn+Pt58Ktqe3g9OCDv1a2OANd+kUUJLzuhmdQGDLwb0nPfYxAExmkwjYdDaRHxSS48H9s98vvVzsA5TgvB+Ai1Jch8/77YtVL3xDnW+ZgVvO9hMtpEBiOYpqjKTf4IqthN+WYXZL8TVQIrvouWcM8V]]></Encrypt><AgentID><![CDATA[]]></AgentID></xml>";
			String sMsg = wxcpt.DecryptMsg(sReqMsgSig, sReqTimeStamp, sReqNonce, sReqData);
			System.out.println("after decrypt msg: " + sMsg);
			// TODO: 解析出明文xml标签的内容进行处理
			// For example:
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			StringReader sr = new StringReader(sMsg);
			InputSource is = new InputSource(sr);
			Document document = db.parse(is);

			Element root = document.getDocumentElement();
			NodeList nodelist1 = root.getElementsByTagName("Content");
			String Content = nodelist1.item(0).getTextContent();
			System.out.println("Content：" + Content);

	}

	/**
	 * ------------使用示例三：企业回复用户消息的加密---------------
	 * 企业被动回复用户的消息也需要进行加密，并且拼接成密文格式的xml串。 假设企业需要回复用户的明文如下： <xml>
	 * <ToUserName><![CDATA[mycreate]]></ToUserName>
	 * <FromUserName><![CDATA[wx5823bf96d3bd56c7]]></FromUserName>
	 * <CreateTime>1348831860</CreateTime> <MsgType><![CDATA[text]]></MsgType>
	 * <Content><![CDATA[this is a test]]></Content>
	 * <MsgId>1234567890123456</MsgId> <AgentID>128</AgentID> </xml>
	 * 
	 * 为了将此段明文回复给用户，企业应：
	 * 1.自己生成时间时间戳(timestamp),随机数字串(nonce)以便生成消息体签名，也可以直接用从公众平台的post
	 * url上解析出的对应值。 2.将明文加密得到密文。
	 * 3.用密文，步骤1生成的timestamp,nonce和企业在公众平台设定的token生成消息体签名。
	 * 4.将密文，消息体签名，时间戳，随机数字串拼接成xml格式的字符串，发送给企业。
	 * 以上2，3，4步可以用公众平台提供的库函数EncryptMsg来实现。
	 * @throws AesException 
	 */
	@Test
	public void test3() throws AesException {
		String sRespData = "<xml><ToUserName><![CDATA[mycreate]]></ToUserName><FromUserName><![CDATA[wx5823bf96d3bd56c7]]></FromUserName><CreateTime>1348831860</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[this is a test]]></Content><MsgId>1234567890123456</MsgId><AgentID>128</AgentID></xml>";
		// String sReqTimeStamp = HttpUtils.ParseUrl("timestamp");
		String sReqTimeStamp = "1409659813";
		// String sReqNonce = HttpUtils.ParseUrl("nonce");
		String sReqNonce = "1372623149";
		String sEncryptMsg = wxcpt.EncryptMsg(sRespData, sReqTimeStamp, sReqNonce);
		System.out.println("after encrypt sEncrytMsg: " + sEncryptMsg);
		// 加密成功
		// TODO:
		// HttpUtils.SetResponse(sEncryptMsg);
	}
}
