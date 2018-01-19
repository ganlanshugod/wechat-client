/**
* @Company 青鸟软通   
* @Title: WeChatConnection.java 
* @Package org.bana.wechat.qy.common 
* @author Liu Wenjie   
* @date 2015-5-9 下午5:34:56 
* @version V1.0   
*/ 
package org.bana.wechat.qy.common;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.bana.common.util.basic.BeanXmlUtil;
import org.bana.common.util.basic.StringUtils;
import org.bana.common.util.http.RestClient;
import org.bana.wechat.common.log.WechatLogger;
import org.bana.wechat.common.log.WechatLoggerFactory;
import org.bana.wechat.pay.common.HttpsRequest;
import org.bana.wechat.pay.common.WechatPayResult;
import org.bana.wechat.qy.media.param.UploadParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * @ClassName: WeChatConnection 
 * @Description: 微信接口访问的方法 
 *  
 */
public class WeChatConnection {
	
	public static final String HTTP_GET = "get";
	public static final String HTTP_POST = "post";
	
	public static final String XML_PARAM = "param";
	
	public static String certLocalPath = "/cert/apiclient_cert.p12";
	public static String certPassword = "";
	
	public static enum ParamType{
		JSON,XML
	}
	
	public static enum HttpType{
		HTTP,HTTPS
	}
	
	private static final Logger LOG = LoggerFactory.getLogger(WeChatConnection.class);
	private static final WechatLogger wechatLogger = WechatLoggerFactory.getWechatLogger();
	
	/**
	 * 
	* @Description: http的访问方法
	* @author Liu Wenjie   
	* @date 2015-5-9 下午5:39:26 
	* @param url
	* @param map
	 */
	public static void access(String url,Map<String,Object> map,String type){
		if(HTTP_GET.equals(type)){
			get(url, map);
		}else if(HTTP_POST.equals(type)){
			post(url,map);
		}else{
			throw new BanaWeChatException(BanaWeChatException.BUSINESS_CODE,"不支持的访问类型" + type);
		}
	}
	
	/**
	* @Description: get方式方位微信接口
	* @author Liu Wenjie   
	* @date 2015-5-9 下午5:40:21 
	* @param url
	* @param map
	* @return
	 */
	public static String get(String url,Map<String,Object> mapParam){
		String paramUrl = StringUtils.getUrlParamsByMap(mapParam);
		HttpURLConnection connection = null;
		//记录开始信息内容
		wechatLogger.logBegin(url + "?" + paramUrl,null,HTTP_GET);
		try {
			connection = RestClient.get(url + "?" + paramUrl);
			String result = RestClient.getConnectionResponse(connection);
			LOG.info("执行为微信接口 " + url + "?" + paramUrl + " 的结果为 " + result);
			//记录开始信息内容
			wechatLogger.getWechatLogDomain().setWechatResult(result);
			return result;
		} catch (IOException e) {
			wechatLogger.logException(e);
			throw new BanaWeChatException(BanaWeChatException.BUSINESS_CODE,"执行为微信接口 " + url + "?" + paramUrl + "失败" ,e);
		} finally{
			wechatLogger.logEnd();
			if(connection != null){
				try {
					wechatLogger.getWechatLogDomain().setHttpMessage(connection.getResponseMessage());
					wechatLogger.getWechatLogDomain().setStatusCode(connection.getResponseCode()+"");
				} catch (IOException e) {
					e.printStackTrace();
				}
				connection.disconnect();
			}
			wechatLogger.saveLog();
		}
	}
	
	/**
	* @Description: 通过post方式访问微信接口,包含null值
	* @author Liu Wenjie   
	* @date 2015-5-9 下午8:09:39 
	* @param url
	* @param mapParam
	* @return
	 */
	public static String post(String url,Map<String,Object> mapParam){
		return post(url,mapParam,false,ParamType.JSON,HttpType.HTTP);
	}
	
	/**
	* @Description: 通过post方式访问微信接口,包含null值
	* @author Liu Wenjie   
	* @date 2015-5-9 下午8:09:39 
	* @param url
	* @param mapParam
	* @return
	 */
	public static String post(String url,Map<String,Object> mapParam,ParamType type){
		return post(url,mapParam,false,type,HttpType.HTTP);
	}
	
	/**
	* @Description: 通过post方式访问微信接口,包含null值
	* @author Liu Wenjie   
	* @date 2015-5-9 下午8:09:39 
	* @param url
	* @param mapParam
	* @return
	 */
	public static String post(String url,Map<String,Object> mapParam,boolean containNullParam){
		return post(url,mapParam,containNullParam,ParamType.JSON,HttpType.HTTP);
	}
	
	/**
	* @Description: 通过post方式访问微信接口
	* @author Liu Wenjie   
	* @date 2015-5-9 下午8:09:39 
	* @param url
	* @param mapParam
	* @return
	 */
	public static String post(String url,Map<String,Object> mapParam,boolean containNullParam,ParamType type,HttpType httpType){
		HttpURLConnection connection = null;
		String access_token = (String)mapParam.get("access_token");
		String suite_access_token = (String)mapParam.get("suite_access_token");
		if(!StringUtils.isBlank(access_token)){
			url += "?access_token=" + access_token; 
			mapParam.put("access_token", null);
		}else if(!StringUtils.isBlank(suite_access_token)){
			url += "?suite_access_token=" + suite_access_token;
			mapParam.put("suite_access_token", null);
		}
		
		//json类型
		String paramString = "";
		if(ParamType.JSON.equals(type)){
			JSONObject fromObject = null;
			if(!containNullParam){
				JsonConfig config = new JsonConfig();
				config.setJsonPropertyFilter(new PropertyFilter(){  
				    @Override  
				    public boolean apply(Object source, String name, Object value) { 
				    	if(value instanceof String){
				    		String strValue = (String) value;
				    		return StringUtils.isBlank(strValue);
				    	}
				        return value == null;  
				    }  
				}); 
				fromObject = JSONObject.fromObject(mapParam,config);
			}else{
				fromObject = JSONObject.fromObject(mapParam);
			}
			paramString = fromObject.toString();
		}else if(ParamType.XML.equals(type)){//xml类型的
			Object object = mapParam.get(XML_PARAM);
			paramString = BeanXmlUtil.beanToXml(object);
		}
		
		wechatLogger.logBegin(url,paramString,HTTP_POST);
		try {
			String result = "";
			if(HttpType.HTTPS.equals(httpType)){
				HttpsRequest httpsRequest = HttpsRequest.getInstance( certLocalPath, certPassword);
				result = httpsRequest.sendPost(url, paramString);
			}else{
				connection = RestClient.post(url,paramString);
				result = RestClient.getConnectionResponse(connection);
			}
			LOG.info(httpType.toString() + "方式 执行为微信接口 " + url + "?" + mapParam + " 的结果为 " + result);
			wechatLogger.getWechatLogDomain().setWechatResult(result);
			return result;
		} catch (Exception e) {
			wechatLogger.logException(e);
			throw new BanaWeChatException(BanaWeChatException.BUSINESS_CODE,"执行为微信接口 " + url + "?" + mapParam + "失败" ,e);
		} finally{
			wechatLogger.logEnd();
			if(connection != null){
				try {
					wechatLogger.getWechatLogDomain().setHttpMessage(connection.getResponseMessage());
					wechatLogger.getWechatLogDomain().setStatusCode(connection.getResponseCode()+"");
				} catch (IOException e) {
					e.printStackTrace();
				}
				connection.disconnect();
			}
			wechatLogger.saveLog();
		}
	}
	
	/**
	* @Description: 根据微信返回码,判断是否访问成功的方法
	* @author Liu Wenjie   
	* @date 2015-5-9 下午6:12:28 
	* @param errorCode
	 */
	public static boolean isSuccess(String errorCode){
		return Constants.成功码.getValue().equalsIgnoreCase(errorCode);
	}
	
	/** 
	* @Description: 根据微信返回码,判断是否访问成功的方法
	* @author Liu Wenjie   
	* @date 2015-5-15 下午8:18:45 
	* @param json
	* @return  
	*/ 
	public static boolean isSuccess(JSONObject json){
		try {
			String errcode = json.getString(Constants.返回码.getValue());
			return isSuccess(errcode);
		} catch (RuntimeException e) {
			LOG.info("没有返回码，认为执行成功",e.getMessage());
			return true;
		}
	}

	/** 
	* @Description: 修改为上传文件接口的实现方式
	* @author Liu Wenjie   
	* @date 2015-7-20 下午5:30:47 
	* @param value
	* @param convertBean
	* @return  
	*/ 
	public static String postUpload(String url, UploadParam param) {
		HttpURLConnection connection = null;
		String access_token = param.getAccess_token();
		if(!StringUtils.isBlank(access_token)){
			url += "?access_token=" + access_token; 
		}
		String type = param.getType();
		if(!StringUtils.isBlank(type)){
			url+="&type="+type;
		}
		JsonConfig config = new JsonConfig();
		//排除media属性
		config.setJsonPropertyFilter(new PropertyFilter(){  
		    @Override  
		    public boolean apply(Object source, String name, Object value) { 
		        return "media".equals(name);  
		    }  
		});
		JSONObject fromObject = JSONObject.fromObject(param,config);
		
		wechatLogger.logBegin(url,fromObject.toString(),HTTP_POST);
		// 定义数据分隔符
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
			String result = RestClient.getConnectionResponse(connection);
			LOG.info("执行为微信接口 " + url + "?" + param + " 的结果为 " + result);
			wechatLogger.getWechatLogDomain().setWechatResult(result);
			return result;
		} catch (IOException e) {
			wechatLogger.logException(e);
			throw new BanaWeChatException(BanaWeChatException.BUSINESS_CODE,"执行为微信接口 " + url + "?" + param + "失败" ,e);
		} finally{
			wechatLogger.logEnd();
			if(connection != null){
				try {
					wechatLogger.getWechatLogDomain().setHttpMessage(connection.getResponseMessage());
					wechatLogger.getWechatLogDomain().setStatusCode(connection.getResponseCode()+"");
				} catch (IOException e) {
					e.printStackTrace();
				}
				connection.disconnect();
			}
			wechatLogger.saveLog();
		}
	}

	/** 
	* @Description: 判断wechatPay返回结果是否正确
	* @author Liu Wenjie   
	* @date 2015-9-17 下午7:16:57 
	* @param xmlToBean
	* @return  
	*/ 
	public static boolean isSuccess(WechatPayResult xmlToBean) {
		return xmlToBean != null && "SUCCESS".equalsIgnoreCase(xmlToBean.getReturn_code());
	}

	/** 
	* @Description: 根据类型访问对应的post方法
	* @author Liu Wenjie   
	* @date 2015-9-24 上午10:52:51 
	* @param value
	* @param convertBean
	* @param xml
	* @param http
	* @return  
	*/ 
	public static String post(String url, Map<String, Object> mapParam, ParamType type, HttpType http) {
		return post(url, mapParam, false, type, http);
	}

	/**
	 * @Description: 属性 certLocalPath 的get方法 
	 * @return certLocalPath
	 */
	public static String getCertLocalPath() {
		return certLocalPath;
	}

	/**
	 * @Description: 属性 certLocalPath 的set方法 
	 * @param certLocalPath 
	 */
	public static void setCertLocalPath(String certLocalPath) {
		WeChatConnection.certLocalPath = certLocalPath;
	}

	/**
	 * @Description: 属性 certPassword 的get方法 
	 * @return certPassword
	 */
	public static String getCertPassword() {
		return certPassword;
	}

	/**
	 * @Description: 属性 certPassword 的set方法 
	 * @param certPassword 
	 */
	public static void setCertPassword(String certPassword) {
		WeChatConnection.certPassword = certPassword;
	}
	
}

