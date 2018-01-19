/**
 * @Company 青鸟软通   
 * @Title: MediaTest.java 
 * @Package org.bana.wechat.mp.media 
 * @author Han Tongyang   
 * @date 2015-9-2 下午5:09:44 
 * @version V1.0   
 */
package org.bana.wechat.mp.media;

import org.bana.wechat.mp.common.Constants;
import org.bana.wechat.mp.media.param.Article;
import org.bana.wechat.mp.media.result.MediaResult;
import org.bana.wechat.mp.media.util.MedicTypeEnum;
import org.junit.Test;

/**
 * @ClassName: MediaTest
 * @Description: 上传媒体文件测试类
 * 
 */
public class MediaTest {
	
	private static final String accessToken = "HS64J2saRicKsoWJVRaPSbg9Xdlo1w6LO16AG8gQltpA1OSUffZQvca6A9CVOWt-elMSmGLcc5uBEDg68rg2kauQeAdVFILnBB3w1u1R9EV2TJNWiUqqXXjKYvMD5ps9VOFgAHAQJA";

	@Test
	public void testUploadPic() {
		MediaResult uploadPicResult = MediaClient
				.uploadPic(
						accessToken,
						"image",
						"http://img.i3618.com.cn/i3618/2016-07-04/attachMax/c00812c4-b7f6-4c83-9353-6342b169fe2c.jpg",
						Constants.上传图文消息内容图片.getValue(), null);
		System.out.println(uploadPicResult.toString());
	}
	
	@Test
	public void testUploadContentPic() {
		MediaClient.uploadPic(accessToken, MedicTypeEnum.缩略图.getMediaType(), "http://img.i3618.com.cn/i3618/2016-07-04/attachMax/c00812c4-b7f6-4c83-9353-6342b169fe2c.jpg", Constants.上传媒体文件.getValue(), null);
	}

	@Test
	public void testUploadNews() {
		Article article = new Article();
		article.setAuthor("小艾");
		article.setTitle("青岛中德生态园小学 被授予“山东省中小学课堂文化建设重点实验学校”");
		article.setDigest("3月26日至27日，在山东省中小学课堂文化建设研究课题开题暨教师专业发展培训会议上，青岛中德生态园小学被授予“山东省中小学课堂文化建设重点实验学校”。");
		article.setShow_cover_pic(1);
		article.setContent_source_url("http://www.baidu.com");
		article.setContent("<section style='margin: 0.8em 0px 0px; padding: 10px; max-width: 100%; white-space: normal; font-family: 微软雅黑; border: 1px solid rgb(192, 200, 209); color: rgb(51, 51, 51); text-align: justify; box-sizing: border-box !important; word-wrap: break-word !important; background-color: rgb(239, 239, 239);'><p style='margin-top: 0px; margin-bottom: 0px; padding: 0px; max-width: 100%; clear: both; min-height: 1em; white-space: pre-wrap; line-height: 1.6em; box-sizing: border-box !important; word-wrap: break-word !important;'><span style='margin: 0px; padding: 0px; max-width: 100%; font-family: arial, helvetica, sans-serif; box-sizing: border-box !important; word-wrap: break-word !important;'>3月26日至27日，在山东省中小学课堂文化建设研究课题开题暨教师专业发展培训会议上，青岛中德生态园小学被授予“山东省中小学课堂文化建设重点实验学校”。</span></p></section><p style='padding: 0px; max-width: 100%; clear: both; min-height: 1em; white-space: normal; color: rgb(62, 62, 62); line-height: 1.6em; font-family: 微软雅黑; box-sizing: border-box !important; word-wrap: break-word !important; background-color: rgb(255, 255, 255);'><br style='margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box !important; word-wrap: break-word !important;'/></p><p style='padding: 0px; max-width: 100%; clear: both; min-height: 1em; white-space: normal; color: rgb(62, 62, 62); line-height: 1.6em; font-family: 微软雅黑; box-sizing: border-box !important; word-wrap: break-word !important; text-align: center; background-color: rgb(255, 255, 255);'><IMG alt='' style='max-width:100%;' src='http://img.i3618.com.cn/i3618/2016-02-15/attachMax/1455495846990.jpeg' title=''/><span style='font-family: arial, helvetica, sans-serif; line-height: 25.6px; text-align: justify;'>我校常务副校长周方水领取奖牌</span></p><p style='padding: 0px; max-width: 100%; clear: both; min-height: 1em; white-space: normal; color: rgb(62, 62, 62); line-height: 1.6em; font-family: 微软雅黑; box-sizing: border-box !important; word-wrap: break-word !important; background-color: rgb(255, 255, 255);'><br/></p><p style='padding: 0px; max-width: 100%; clear: both; min-height: 1em; white-space: normal; color: rgb(62, 62, 62); line-height: 1.6em; font-family: 微软雅黑; box-sizing: border-box !important; word-wrap: break-word !important; background-color: rgb(255, 255, 255);'><span style='margin: 0px; padding: 0px; max-width: 100%; font-family: arial, helvetica, sans-serif; line-height: 25.6px; text-align: justify; box-sizing: border-box !important; word-wrap: break-word !important;'>学校重视教育教学科研工作，并将课题研究工作作为促进教师专业成长的重要举措之一。在此前，学校积极申报了“山东省中小学课堂文化建设研究总课题组”的两项子课题：“学科教学中的课堂文化构建研究”和“课堂教学模式创新研究”经课题组专家委员会评审，报请总课题组批准，两项子课题均得到批复立项。</span></p><p style='padding: 0px; max-width: 100%; clear: both; min-height: 1em; white-space: normal; color: rgb(62, 62, 62); line-height: 1.6em; font-family: 微软雅黑; box-sizing: border-box !important; word-wrap: break-word !important; background-color: rgb(255, 255, 255);'><span style='margin: 0px; padding: 0px; max-width: 100%; font-family: arial, helvetica, sans-serif; line-height: 25.6px; text-align: justify; box-sizing: border-box !important; word-wrap: break-word !important;'><br/></span></p><p style='padding: 0px; max-width: 100%; clear: both; min-height: 1em; white-space: normal; color: rgb(62, 62, 62); line-height: 1.6em; font-family: 微软雅黑; box-sizing: border-box !important; word-wrap: break-word !important; text-align: center; background-color: rgb(255, 255, 255);'><span style='margin: 0px; padding: 0px; max-width: 100%; font-family: arial, helvetica, sans-serif; line-height: 25.6px; text-align: justify; box-sizing: border-box !important; word-wrap: break-word !important;'><img style='max-width:100%;' src='http://img.i3618.com.cn/i3618/2016-02-15/attachMax/1455495846990.jpeg' title='' alt=''/></span></p><p style='text-align: center;'><span style='color: rgb(62, 62, 62); font-family: arial, helvetica, sans-serif; line-height: 25.6px; text-align: justify; background-color: rgb(255, 255, 255);'>课堂文化建设实验学校的批复通知</span></p>");
		article.setThumb_media_id("EM0rRgeqJH27hRY_TLOOQHkTfF_242Id-uBqatgKGhnH-_6MttjTyugnJzK_Nb3S");
		MediaResult uploadNewsResult = MediaClient.uploadNews(accessToken,
				article);
		System.out.println(uploadNewsResult.toString());
	}
}
