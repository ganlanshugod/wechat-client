/**
* @Company Elink   
* @Title: MessageMiniServiceImpl.java 
* @Package org.bana.wechat.mini.message.impl 
* @author zhangzhichao   
* @date Jul 15, 2019 2:46:25 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mini.message.impl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.bana.wechat.common.HttpHelper;
import org.bana.wechat.common.util.StringUtils;
import org.bana.wechat.mini.common.Constants;
import org.bana.wechat.mini.common.WeChatMiniException;
import org.bana.wechat.mini.common.WechatMiniResultHandler;
import org.bana.wechat.mini.message.MessageMiniService;
import org.bana.wechat.mini.message.result.MsgCheckResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/** 
* @ClassName: MessageMiniServiceImpl 
* @Description: 
* @author zhangzhichao   
*/
public class MessageMiniServiceImpl implements MessageMiniService {
	private static final Logger LOG = LoggerFactory.getLogger(MessageMiniServiceImpl.class);
	/**
	* <p>Description: </p> 
	* @author zhangzhichao   
	* @date Jul 15, 2019 2:46:25 PM 
	* @param accessToken
	* @param content
	* @return 
	* @see org.bana.wechat.mini.message.MessageMiniService#checkMsgSec(java.lang.String, java.lang.String) 
	*/
	@Override
	public MsgCheckResult checkMsgSec(String accessToken, String content) {
		if(StringUtils.isBlank(accessToken,content)){
			throw new WeChatMiniException(WeChatMiniException.PARAM_ERROR,"checkMsgSec时参数不能为空 accessToken=" + accessToken + ",content=" + content);
		}
		HttpHelper httpHelper = new HttpHelper();
		Map<String,String> param = new HashMap<String,String>();
		param.put("content", content);
		String url = Constants.内容安全文本.getValue()+"?access_token="+accessToken;
		JSONObject resultObject = httpHelper.httpPost(url, param);
		return WechatMiniResultHandler.handleResult(resultObject,MsgCheckResult.class);
	}
	/**
	* <p>Description: </p> 
	* @author zhangzhichao   
	* @date Jul 16, 2019 9:07:56 AM 
	* @param accessToken
	* @param imgUrl
	* @return 
	* @see org.bana.wechat.mini.message.MessageMiniService#checkImgSec(java.lang.String, java.lang.String) 
	*/ 
	@Override
	public MsgCheckResult checkImgSec(String accessToken, String imgUrl) {
		if(StringUtils.isBlank(accessToken,imgUrl)){
			throw new WeChatMiniException(WeChatMiniException.PARAM_ERROR,"checkImgSec时参数不能为空 accessToken=" + accessToken + ",imgUrl=" + imgUrl);
		}
		String result = null;
		BufferedReader reader = null;
		try {
			String[] imgNameArr = imgUrl.split("/");
			String checkUrl = Constants.内容安全图片.getValue()+"?access_token="+accessToken;
			URL checkUrlObj = new URL(checkUrl);
			HttpURLConnection checkCon = (HttpURLConnection) checkUrlObj.openConnection();
			checkCon.setRequestMethod("POST");
			checkCon.setDoInput(true);
			checkCon.setDoOutput(true);
			checkCon.setUseCaches(false);
			checkCon.setRequestProperty("Connection", "Keep-Alive");
			checkCon.setRequestProperty("Charset", "UTF-8");
			String boundary = "-------------------------" + System.currentTimeMillis();
			String prefix = "--";
			String end = "\r\n";
			checkCon.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
			StringBuilder sb = new StringBuilder();
			sb.append(prefix);
			sb.append(boundary);
			sb.append(end);
			sb.append("Content-Disposition: form-data; name=\"media\";filename=\"" + imgNameArr[imgNameArr.length-1] + "\"" + end);
			sb.append("Content-Type: image/png" + end);
			sb.append(end); // 上传图片流之前必须要有一个空行，否则服务端获取不到图片参数：{"errcode":41005,"errmsg":"media data missing hint: [eAbP301484245]"}
			byte[] head = sb.toString().getBytes("utf-8");
			OutputStream out = new DataOutputStream(checkCon.getOutputStream());
			out.write(head);
			// 图片流
			URL imgUrlObj = new URL(imgUrl+"?x-oss-process=image/resize,m_fill,w_720,h_540,color_FFFFFF,limit_0");
            HttpURLConnection conn = (HttpURLConnection)imgUrlObj.openConnection();    
            conn.setRequestMethod("GET");    
            conn.setConnectTimeout(5 * 1000);
            InputStream inStream = conn.getInputStream();
//			// 本地图片测试
//			FileInputStream fis = new FileInputStream(new File("/Users/zhangzhichao/work/elink/test-code/a.jpg"));
			int len = 0;
			byte[] bufferOut = new byte[1024];
			while ((len=inStream.read(bufferOut))!=-1) {
				out.write(bufferOut, 0, len);
			}
			inStream.close();
			out.write(end.getBytes());
			byte[] foot = (prefix + boundary + prefix + end).getBytes("utf-8");
			out.write(foot);
			out.flush();
			// 返回值
			StringBuffer buffer = new StringBuffer();
			reader = new BufferedReader(new InputStreamReader(checkCon.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			if (result == null) {
				result = buffer.toString();
			}
			LOG.info("img-sec-result="+result);
			JSONObject resultObject = JSONObject.parseObject(result);
			return WechatMiniResultHandler.handleResult(resultObject,MsgCheckResult.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WeChatMiniException("system-error", e.getMessage());
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new WeChatMiniException("system-error", e.getMessage());
				}
			}
		}
	}

}
