/**
 * @Company JBINFO
 * @Title: WechatCpService.java
 * @Package org.bana.wechat.cp.common
 * @author Liu Wenjie
 * @date 2018年1月19日 下午1:05:27
 * @version V1.0
 */
package org.bana.wechat.cp.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.bana.wechat.common.HttpHelper;
import org.bana.wechat.common.WechatException;
import org.bana.wechat.common.log.WechatLogDomain;
import org.bana.wechat.common.log.WechatLogger;
import org.bana.wechat.common.log.WechatLoggerFactory;
import org.bana.wechat.common.util.StringUtils;
import org.bana.wechat.cp.media.param.UploadParam;
import org.bana.wechat.cp.token.AccessTokenService;
import org.bana.wechat.cp.token.SuiteAccessTokenService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


/**
 * @ClassName: WechatCpService
 * @Description: 微信企业号的通用抽象类
 * @author Liu Wenjie
 */
public abstract class WechatCpService {
	
	private static final WechatLogger LOG = WechatLoggerFactory.getWechatLogger();
	public static final String HTTP_POST = "post";

	private HttpHelper httpHelper = new HttpHelper();
	
	private AccessTokenService accessTokenService;
	
	private SuiteAccessTokenService suiteAccessTokenService;
	/**
	 * Description: 返回通用的http工具类对象
	 * @author Liu Wenjie
	 * @date 2018年1月19日 下午1:09:56
	 * @return
	 */
	protected JSONObject get(String url,WeChatCPParam param){
		String paramStr = JSON.toJSONString(param);
		Map<String,Object> map = JSON.parseObject(paramStr, Map.class);
		String paramUrl = StringUtils.getUrlParamsByMap(map);
		if(!StringUtils.isBlank(paramUrl)){
			if(url.contains("?")){
				url += "&" + paramUrl;
			}else{
				url += "?" + paramUrl;
			}
		}
		return getHttpHelper().httpGet(addAccessToken(url, param));
	}
	
	/**
	 * Description: 返回通用的http工具类对象（第三方套件接口相关）
	 * @author Zhang Zhichao
	 * @date 2018年1月30日 下午5:41:18
	 * @param url
	 * @param param
	 * @return
	 */
	protected JSONObject get(String url,WeChatCPSuiteParam param){
		return getHttpHelper().httpGet(addSuiteAccessToken(url, param));
	}
	
	/**
	 * Description: post 提交参数
	 * @author Liu Wenjie
	 * @date 2018年1月19日 下午1:35:54
	 * @param url
	 * @param param
	 * @return
	 */
	protected JSONObject post(String url,WeChatCPParam param){
		return getHttpHelper().httpPost(addAccessToken(url, param),param);
	}
	
	/**
	 * Description: 上传附件到微信企业号
	 * @author Huang Nana
	 * @date 2018年2月26日 下午4:01:59
	 * @param url
	 * @param param
	 * @return
	 */
	protected JSONObject postUpload(String url, UploadParam param) {
		HttpURLConnection connection = null;
		WechatLogDomain domain = LOG.getWechatLogDomain();
		url = addAccessToken(url, param);
		String params = JSON.toJSONString(param);
		
		LOG.logBegin(url, params, HTTP_POST);

		String boundary = "------------7da2e536604c8";
		try {
			URL connectionUrl = new URL(url);
			connection = (HttpURLConnection) connectionUrl.openConnection();
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setDoOutput(true);
			connection.setDoInput(true);
		    // 设置请求头Content-Type
			connection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
			// 获取媒体文件上传的输出流（往微信服务器写数据）
		    OutputStream outputStream = connection.getOutputStream();
		    // 请求体开始
		    outputStream.write(("--" + boundary + "\r\n").getBytes());
		    String fileName = "file" + param.getFileExt();
		    if(StringUtils.isNotBlank(param.getFileName())){
		    	fileName = param.getFileName();
		    }
		    outputStream.write(String.format("Content-Disposition: form-data; name=\"media\"; filename=\"%s\"\r\n", fileName).getBytes());
		    outputStream.write(String.format("Content-Type: %s\r\n\r\n", param.getContentType()).getBytes());

		    // 获取媒体文件的输入流（读取文件）
		    byte[] postMediaBytes = param.getMedia();
	        // 将媒体文件写到输出流（往微信服务器写数据）
	        outputStream.write(postMediaBytes);
	        // 请求体结束  
	        outputStream.write(("\r\n--" + boundary + "--\r\n").getBytes());
		    // 请求体结束
	        outputStream.flush();
	        
	        StringBuilder responseBuilder = new StringBuilder();
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			String input;
			while ((input = in.readLine()) != null) {
				responseBuilder.append(input).append("\r\n");
			}
			in.close();
			String result = responseBuilder.toString();

			//LOG 内容
			domain.setWechatResult(result);
			return JSON.parseObject(result);
		} catch (IOException e) {
			LOG.logException(e);
			throw new WechatException("500",e.getMessage(),e);
		} finally {
			LOG.logEnd();
			if(connection != null){
				try {
					LOG.getWechatLogDomain().setStatusCode(connection.getResponseCode()+"");
				} catch (IOException e) {
					e.printStackTrace();
				}
				connection.disconnect();
			}
			LOG.saveLog();
		}
	}
	
	/**
	 * Description: post 提交参数（第三方套件接口相关）
	 * @author Zhang Zhichao
	 * @date 2018年1月29日 下午1:29:34
	 * @param url
	 * @param param
	 * @return
	 */
	protected JSONObject post(String url,WeChatCPSuiteParam param){
		return getHttpHelper().httpPost(addSuiteAccessToken(url, param),param);
	}
	
	
	private String addAccessToken(String url,WeChatCPParam param){
		String accessToken = accessTokenService.getAccessToken(param.getCorpId(), param.getAgentId());
		if(url.contains("?")){
			url += "&";
		}else{
			url += "?";
		}
		url+="access_token="+accessToken;
		return url;
	}
	
	/**
	 * Description: 获取suite_access_token
	 * @author Zhang Zhichao
	 * @date 2018年1月29日 下午1:30:22
	 * @param url
	 * @param param
	 * @return
	 */
	private String addSuiteAccessToken(String url,WeChatCPSuiteParam param){
		String suiteAccessToken = suiteAccessTokenService.getSuiteAccessToken(param.getSuiteId());
		if(url.contains("?")){
			url += "&";
		}else{
			url += "?";
		}
		url+="suite_access_token="+suiteAccessToken;
		return url;
	}
	
	protected HttpHelper getHttpHelper() {
		if(httpHelper == null){
			httpHelper = new HttpHelper();
		}
		return httpHelper;
	}

	
	/*=========getter and setter ===========*/
	public void setHttpHelper(HttpHelper httpHelper) {
		this.httpHelper = httpHelper;
	}

	public void setAccessTokenService(AccessTokenService accessTokenService) {
		this.accessTokenService = accessTokenService;
	}

	public void setSuiteAccessTokenService(SuiteAccessTokenService suiteAccessTokenService) {
		this.suiteAccessTokenService = suiteAccessTokenService;
	}
	
}
