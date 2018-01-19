/**
 * @Company 青鸟软通   
 * @Title: MediaClient.java 
 * @Package org.bana.wechat.mp.media 
 * @author Han Tongyang   
 * @date 2016-3-21 下午12:10:42 
 * @version V1.0   
 */
package org.bana.wechat.mp.media;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;

import javax.imageio.ImageIO;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.bana.common.util.basic.BeanToMapUtil;
import org.bana.common.util.image.ImageUtil;
import org.bana.wechat.mp.common.Constants;
import org.bana.wechat.mp.media.param.Article;
import org.bana.wechat.mp.media.param.MediaNewsParam;
import org.bana.wechat.mp.media.result.MediaResult;
import org.bana.wechat.qy.common.BanaWeChatException;
import org.bana.wechat.qy.common.WeChatConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: MediaClient
 * @Description: 多媒体接口
 * 
 */
public class MediaClient {
	
	private static final Logger LOG = LoggerFactory.getLogger(MediaClient.class);
	
	/**
	 * 上传媒体文件
	 * 
	 * @param accessToken 接口访问凭证
	 * @param type 媒体文件类型，分别有图片（image）、语音（voice）、视频（video），普通文件(file)
	 * @param media form-data中媒体文件标识，有filename、filelength、content-type等信息
	 * @param mediaFileUrl
	 *            媒体文件的url 上传的媒体文件限制 图片（image）:1MB，支持JPG格式
	 *            语音（voice）：2MB，播放长度不超过60s，支持AMR格式 视频（video）：10MB，支持MP4格式
	 *            普通文件（file）：10MB
	 * */
	public static MediaResult uploadPic(String accessToken, String type,
			String mediaFileUrl, String mpUrl, String formDataName) {
		LOG.info("上传封面图片开始：type=" + type + "|mediaFileUrl=" + mediaFileUrl + "|token=" + accessToken);
		MediaResult media = null;
		// 拼装请求地址
		if(StringUtils.isBlank(mpUrl)){
			mpUrl = Constants.上传媒体文件.getValue();
		}
		String uploadMediaUrl = mpUrl.replace("ACCESS_TOKEN", accessToken).replace("TYPE", type);
		// 定义数据分隔符
		String boundary = "------WebKitFormBoundaryByI3618AS" + new Date().getTime();
		String fileExt = "image/jpeg";
		OutputStream outputStream = null;
		String postName = StringUtils.isNotBlank(formDataName) ? formDataName : "media";
		try {
			URL uploadUrl = new URL(uploadMediaUrl);
			HttpURLConnection uploadConn = (HttpURLConnection) uploadUrl.openConnection();
			uploadConn.setDoOutput(true);
			uploadConn.setDoInput(true);
			uploadConn.setRequestMethod("POST");
			// 设置请求头Content-Type
			uploadConn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
			// 获取媒体文件上传的输出流（往微信服务器写数据）
			outputStream = uploadConn.getOutputStream();

			URL mediaUrl = new URL(mediaFileUrl);
			HttpURLConnection meidaConn = (HttpURLConnection) mediaUrl.openConnection();
			meidaConn.setDoOutput(true);
			meidaConn.setRequestMethod("GET");

			// 从参数中获取文件格式，并封装文件名
			String fileName = new Date().getTime() + "";
			int lastPoint = mediaFileUrl.lastIndexOf(".");
			if(StringUtils.isNotBlank(mediaFileUrl) && lastPoint > 0 && lastPoint != (mediaFileUrl.length() - 1)){
				fileName += mediaFileUrl.substring(lastPoint, mediaFileUrl.length());
			}else{
				fileName += ".jpg";
			}
			
			// 请求体开始
			outputStream.write(("--" + boundary + "\r\n").getBytes());
			outputStream.write(String
				.format("Content-Disposition: form-data; name=\"%s\"; filename=\"%s\"\r\n", postName, fileName).getBytes());
			outputStream.write(String.format("Content-Type: %s\r\n\r\n", fileExt).getBytes());
			
			// 获取媒体文件的输入流（读取文件）
			BufferedImage image = ImageUtil.compressImage(meidaConn.getInputStream(), 580, 322);
			ImageIO.write(image, "jpg", outputStream);
			
			// 请求体结束
			outputStream.write(("\r\n--" + boundary + "--\r\n").getBytes());
			outputStream.close();
			meidaConn.disconnect();

			// 获取媒体文件上传的输入流（从微信服务器读数据）
			InputStream inputStream = uploadConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			StringBuffer buffer = new StringBuffer();
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			uploadConn.disconnect();

			// 使用JSON-lib解析返回结果
			media = cloneToObj(JSONObject.fromObject(buffer.toString()), type, mpUrl);
			LOG.info("获取上传封面图片结果：" + media);
		} catch (Exception e) {
			media = null;
			LOG.error("获取上传封面图片结果：null");
			throw new BanaWeChatException(e);
		}
		return media;
	}
	
	/** 
	* @Description: 构建返回参数
	* @author Han Tongyang   
	* @date 2016-3-21 下午3:36:07 
	* @param jsonObject
	* @param type
	* @return  
	*/ 
	private static MediaResult cloneToObj(JSONObject jsonObject, String type, String mpUrl){
		if(jsonObject.toString().indexOf("errcode") > 0){
			throw new BanaWeChatException(jsonObject.getString("errcode"), jsonObject.getString("errmsg"));
		}
		MediaResult media = new MediaResult();
		if(Constants.上传图文消息内容图片.getValue().equals(mpUrl)){
			media.setMediaId(jsonObject.getString("url"));
		}else{
			media.setType(jsonObject.getString("type"));
			// type等于 缩略图（thumb） 时的返回结果和其它类型不一样
			if (StringUtils.isNotBlank(type) && "thumb".equals(type)) {
				media.setMediaId(jsonObject.getString("thumb_media_id"));
			} else {
				media.setMediaId(jsonObject.getString("media_id"));
			}
			media.setCreatedAt(jsonObject.getInt("created_at"));
		}
		return media;
	}
	
	/** 
	* @Description: 上传图文消息素材
	* @author Han Tongyang   
	* @date 2016-3-21 下午3:55:53 
	* @param accessToken
	* @return  
	*/ 
	public static MediaResult uploadNews(String accessToken, Article article){
		LOG.info("上传图文消息开始：" + accessToken + "  " + article);
		MediaNewsParam param = initMediaNewsParam(article, accessToken);
		String json = WeChatConnection.post(Constants.上传图文消息素材.getValue(), BeanToMapUtil.convertBean(param));
		//转换成Json格式
		MediaResult media = cloneToObj(JSONObject.fromObject(json), null, null);
		LOG.info("获取上传的图文消息结果：" + media);
		return media;
	}
	
	/** 
	* @Description: 初始化上传图文素材参数
	* @author Han Tongyang   
	* @date 2016-3-21 下午5:41:16 
	* @param article
	* @param token
	* @return  
	*/ 
	private static MediaNewsParam initMediaNewsParam(Article article, String token){
		MediaNewsParam param = new MediaNewsParam();
		//修改内容中的图片路径
		article.setContent(article.getContent());
		param.setArticles(Arrays.asList(article));
		param.setAccess_token(token);
		return param;
	}
	
	/**
	 * 上传媒体文件
	 * 
	 * @param accessToken 接口访问凭证
	 * @param type 媒体文件类型，分别有图片（image）、语音（voice）、视频（video），普通文件(file)
	 * @param media form-data中媒体文件标识，有filename、filelength、content-type等信息
	 * @param mediaFileUrl
	 *            媒体文件的url 上传的媒体文件限制 图片（image）:1MB，支持JPG格式
	 *            语音（voice）：2MB，播放长度不超过60s，支持AMR格式 视频（video）：10MB，支持MP4格式
	 *            普通文件（file）：10MB
	 * */
	public static MediaResult uploadContentPic(String accessToken, String type,
			InputStream imgInputStream) {
		LOG.info("上传封面图片开始：type=" + type + "|token=" + accessToken);
		MediaResult media = null;
		// 拼装请求地址
		String uploadMediaUrl = Constants.上传图文消息内容图片.getValue().replace("ACCESS_TOKEN", accessToken).replace("TYPE", type);
		// 定义数据分隔符
		String boundary = "------WebKitFormBoundaryByI3618AS" + new Date().getTime();
		String fileExt = "image/jpeg";
		OutputStream outputStream = null;
		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;
		try {
			URL uploadUrl = new URL(uploadMediaUrl);
			HttpURLConnection uploadConn = (HttpURLConnection) uploadUrl.openConnection();
			uploadConn.setDoOutput(true);
			uploadConn.setDoInput(true);
			uploadConn.setRequestMethod("POST");
			// 设置请求头Content-Type
			uploadConn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
			// 获取媒体文件上传的输出流（往微信服务器写数据）
			outputStream = uploadConn.getOutputStream();

			// 从参数中获取文件格式，并封装文件名
			String fileName = new Date().getTime() + ".jpg";
			// 请求体开始
			outputStream.write(("--" + boundary + "\r\n").getBytes());
			outputStream.write(String
				.format("Content-Disposition: form-data; name=\"buffer\"; filename=\"%s\"\r\n", fileName).getBytes());
			outputStream.write(String.format("Content-Type: %s\r\n\r\n", fileExt).getBytes());

			int c;
			while ((c = imgInputStream.read()) != -1) {
				outputStream.write(c);
			}
			// 关闭
			imgInputStream.close();
			imgInputStream = null;
			// 请求体结束
			outputStream.write(("\r\n--" + boundary + "--\r\n").getBytes());
			outputStream.close();
			outputStream = null;
			// 获取媒体文件上传的输入流（从微信服务器读数据）
			inputStream = uploadConn.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			bufferedReader = new BufferedReader(inputStreamReader);
			StringBuffer buffer = new StringBuffer();
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			bufferedReader = null;
			inputStreamReader.close();
			inputStreamReader = null;
			// 释放资源
			inputStream.close();
			inputStream = null;
			uploadConn.disconnect();

			// 使用JSON-lib解析返回结果
			media = cloneToObj(JSONObject.fromObject(buffer.toString()), type, Constants.上传图文消息内容图片.getValue());
			LOG.info("获取上传封面图片结果：" + media);
		} catch (Exception e) {
			media = null;
			LOG.error("获取上传封面图片结果：null");
			throw new BanaWeChatException(e);
		}finally{
			// 释放资源
			if(imgInputStream != null){
				try {
					imgInputStream.close();
				} catch (IOException e) {
				}
			}
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
				}
			}
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
				}
			}
			if (inputStreamReader != null) {
				try {
					inputStreamReader.close();
				} catch (IOException e) {
				}
			}
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
				}
			}
		}
		return media;
	}
	
}
