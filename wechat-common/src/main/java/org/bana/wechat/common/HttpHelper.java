/**
 * @Company JBINFO
 * @Title: HttpHelper.java
 * @Package org.bana.wechat
 * @author Liu Wenjie
 * @date 2018年1月19日 上午10:33:09
 * @version V1.0
 */

package org.bana.wechat.common;
import java.io.File;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;
import org.bana.wechat.common.http.StringResponseHandler;
import org.bana.wechat.common.log.WechatLogDomain;
import org.bana.wechat.common.log.WechatLogger;
import org.bana.wechat.common.log.WechatLoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: HttpHelper
 * @Description: 重新封装HttpHelper方法
 * @author Liu Wenjie
 */
public class HttpHelper {

	public static final String HTTP_GET = "get";
	public static final String HTTP_POST = "post";
	
	private static WechatLogger LOG;
	
	public static WechatLogger getLOG() {
		if(LOG == null) {
			LOG = WechatLoggerFactory.getWechatLogger();
		}
		return LOG;
	}
	
	public JSONObject httpPost(String url, Object data) {
		WechatLogDomain domain = getLOG().getWechatLogDomain();
		// 记录开始信息内容
		String params = JSON.toJSONString(data);
		StringEntity requestEntity = new StringEntity(params, "utf-8");
		getLOG().logBegin(url, params, HTTP_POST);
		HttpPost httpPost = new HttpPost(url);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout(4000).setConnectTimeout(4000).build();
		httpPost.setConfig(requestConfig);
		httpPost.addHeader("Content-Type", "application/json");
		CloseableHttpResponse response = null;
		try {
			httpPost.setEntity(requestEntity);
			response = httpClient.execute(httpPost,new BasicHttpContext());
			StringResponseHandler handler = new StringResponseHandler();
			String result = handler.handleResponse(response);
			//LOG 内容
			domain.setWechatResult(result);
			return JSON.parseObject(result);
		} catch (IOException e) {
			getLOG().logException(e);
			throw new WechatException("500",e.getMessage(),e);
		} finally {
			getLOG().logEnd();
			try {
				if(response != null){
					domain.setStatusCode(String.valueOf(response.getStatusLine().getStatusCode()));
					response.close();
	//				domain.setHttpMessage(String.valueOf(response.getStatusLine()));
				}
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			getLOG().saveLog();
		}
	}
	
	
	public JSONObject httpGet(String url) {
		// 记录开始信息内容
		getLOG().logBegin(url, null, HTTP_POST);
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse response = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout(4000).setConnectTimeout(4000).build();
		httpGet.setConfig(requestConfig);
		try {
			response = httpClient.execute(httpGet, new BasicHttpContext());
			StringResponseHandler handler = new StringResponseHandler();
			String result = handler.handleResponse(response);
			getLOG().getWechatLogDomain().setWechatResult(result);
			return JSON.parseObject(result);
		} catch (IOException e) {
			getLOG().logException(e);
			throw new WechatException("500",e.getMessage(),e);
		} finally {
			getLOG().logEnd();
			if (response != null) {
				getLOG().getWechatLogDomain().setStatusCode(String.valueOf(response.getStatusLine().getStatusCode()));
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			getLOG().saveLog();
		}
	}
	
	
	public JSONObject uploadMedia(String url, File file){
		// 记录开始信息内容
		getLOG().logBegin(url, null, HTTP_GET);
		HttpPost httpPost = new HttpPost(url);
		CloseableHttpResponse response = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout(4000).setConnectTimeout(4000).build();
		httpPost.setConfig(requestConfig);

		HttpEntity requestEntity = MultipartEntityBuilder
				.create()
				.addPart(
						"media",
						new FileBody(file,
								ContentType.APPLICATION_OCTET_STREAM, file
										.getName())).build();
		httpPost.setEntity(requestEntity);

		try {
			response = httpClient.execute(httpPost, new BasicHttpContext());
			StringResponseHandler handler = new StringResponseHandler();
			String result = handler.handleResponse(response);
			getLOG().getWechatLogDomain().setWechatResult(result);
			return JSON.parseObject(result);
		} catch (IOException e) {
			getLOG().logException(e);
			throw new WechatException("500",e.getMessage(),e);
		} finally {
			getLOG().logEnd();
			if (response != null) {
				getLOG().getWechatLogDomain().setStatusCode(String.valueOf(response.getStatusLine().getStatusCode()));
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			getLOG().saveLog();
		}
	}
}
