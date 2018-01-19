/**
 * @Company 青鸟软通   
 * @Title: MessageTest.java 
 * @Package org.bana.wechat.mp.message 
 * @author Han Tongyang   
 * @date 2015-9-2 下午5:09:44 
 * @version V1.0   
 */
package org.bana.wechat.mp.message;

import org.bana.wechat.mp.media.param.Article;
import org.junit.Test;

/**
 * @ClassName: MessageTest
 * @Description: 发送公众号消息测试类
 * 
 */
public class MessageTest {

	@Test
	public void testSendMessage() {
		String accessToken = "vMuEFN2C-tPrTE_nSCQZRTeGrM9ZFtNpGTp91Vr2FCDAoyqFfG81dt6ykR_gBElic3t4mwsHb09VWCEU0MK8WoJT3IGdwY31VV8jP_in3yMGXIeADALCN";
		Article article = new Article();
		article.setAuthor("小艾");
		article.setTitle("青岛中德生态园小学 被授予“山东省中小学课堂文化建设重点实验学校”");
		article.setDigest("3月26日至27日，在山东省中小学课堂文化建设研究课题开题暨教师专业发展培训会议上，青岛中德生态园小学被授予“山东省中小学课堂文化建设重点实验学校”。");
		article.setShow_cover_pic(1);
		article.setContent_source_url("http://www.baidu.com");
		article.setContent("<section style='margin: 0.8em 0px 0px; padding: 10px; max-width: 100%; white-space: normal; font-family: 微软雅黑; border: 1px solid rgb(192, 200, 209); color: rgb(51, 51, 51); text-align: justify; box-sizing: border-box !important; word-wrap: break-word !important; background-color: rgb(239, 239, 239);'><p style='margin-top: 0px; margin-bottom: 0px; padding: 0px; max-width: 100%; clear: both; min-height: 1em; white-space: pre-wrap; line-height: 1.6em; box-sizing: border-box !important; word-wrap: break-word !important;'><span style='margin: 0px; padding: 0px; max-width: 100%; font-family: arial, helvetica, sans-serif; box-sizing: border-box !important; word-wrap: break-word !important;'>3月26日至27日，在山东省中小学课堂文化建设研究课题开题暨教师专业发展培训会议上，青岛中德生态园小学被授予“山东省中小学课堂文化建设重点实验学校”。</span></p></section><p style='padding: 0px; max-width: 100%; clear: both; min-height: 1em; white-space: normal; color: rgb(62, 62, 62); line-height: 1.6em; font-family: 微软雅黑; box-sizing: border-box !important; word-wrap: break-word !important; background-color: rgb(255, 255, 255);'><br style='margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; word-wrap: break-word !important;'/></p><p style='padding: 0px; max-width: 100%; clear: both; min-height: 1em; white-space: normal; color: rgb(62, 62, 62); line-height: 1.6em; font-family: 微软雅黑; box-sizing: border-box !important; word-wrap: break-word !important; text-align: center; background-color: rgb(255, 255, 255);'><IMG alt='' style='max-width:100%;' src='http://img.i3618.com.cn/i3618/2016-03-30/attachMax/0588f746-9746-4b0d-b06e-494bc4a0242a.jpg' title=''/><span style='font-family: arial, helvetica, sans-serif; line-height: 25.6px; text-align: justify;'>我校常务副校长周方水领取奖牌</span></p><p style='padding: 0px; max-width: 100%; clear: both; min-height: 1em; white-space: normal; color: rgb(62, 62, 62); line-height: 1.6em; font-family: 微软雅黑; box-sizing: border-box !important; word-wrap: break-word !important; background-color: rgb(255, 255, 255);'><br/></p><p style='padding: 0px; max-width: 100%; clear: both; min-height: 1em; white-space: normal; color: rgb(62, 62, 62); line-height: 1.6em; font-family: 微软雅黑; box-sizing: border-box !important; word-wrap: break-word !important; background-color: rgb(255, 255, 255);'><span style='margin: 0px; padding: 0px; max-width: 100%; font-family: arial, helvetica, sans-serif; line-height: 25.6px; text-align: justify; box-sizing: border-box !important; word-wrap: break-word !important;'>学校重视教育教学科研工作，并将课题研究工作作为促进教师专业成长的重要举措之一。在此前，学校积极申报了“山东省中小学课堂文化建设研究总课题组”的两项子课题：“学科教学中的课堂文化构建研究”和“课堂教学模式创新研究”经课题组专家委员会评审，报请总课题组批准，两项子课题均得到批复立项。</span></p><p style='padding: 0px; max-width: 100%; clear: both; min-height: 1em; white-space: normal; color: rgb(62, 62, 62); line-height: 1.6em; font-family: 微软雅黑; box-sizing: border-box !important; word-wrap: break-word !important; background-color: rgb(255, 255, 255);'><span style='margin: 0px; padding: 0px; max-width: 100%; font-family: arial, helvetica, sans-serif; line-height: 25.6px; text-align: justify; box-sizing: border-box !important; word-wrap: break-word !important;'><br/></span></p><p style='padding: 0px; max-width: 100%; clear: both; min-height: 1em; white-space: normal; color: rgb(62, 62, 62); line-height: 1.6em; font-family: 微软雅黑; box-sizing: border-box !important; word-wrap: break-word !important; text-align: center; background-color: rgb(255, 255, 255);'><span style='margin: 0px; padding: 0px; max-width: 100%; font-family: arial, helvetica, sans-serif; line-height: 25.6px; text-align: justify; box-sizing: border-box !important; word-wrap: break-word !important;'><img style='max-width:100%;' src='http://img.i3618.com.cn/i3618/2016-03-30/attachMax/da670bc7-804d-485b-9d55-6fd5a3c2ab5e.jpg' title='' alt=''/></span></p><p style='text-align: center;'><span style='color: rgb(62, 62, 62); font-family: arial, helvetica, sans-serif; line-height: 25.6px; text-align: justify; background-color: rgb(255, 255, 255);'>课堂文化建设实验学校的批复通知</span></p>");
		article.setThumb_media_id("AkL-lWJuWrpCPWECLvkccAcFbnC3ZmEJAfqjUgZvgDuk78WtZss-e0F_WpfetC6u");
		String sendMpMessage = MessageClient.sendMpMessage(accessToken, article,
						"http://img.i3618.com.cn/i3618/2016-03-21/attachMax/8d5355c2-1af0-481b-8c0b-16a56cb4af0c.jpg", false);
		System.out.println(sendMpMessage);
	}

}
