/**
* @Company 青鸟软通   
* @Title: MediaClient.java 
* @Package org.bana.wechat.qy.media 
* @author Liu Wenjie   
* @date 2015-7-20 下午5:15:13 
* @version V1.0   
*/ 
package org.bana.wechat.qy.media;

import net.sf.json.JSONObject;

import org.bana.wechat.qy.common.BanaWeChatException;
import org.bana.wechat.qy.common.Constants;
import org.bana.wechat.qy.common.WeChatConnection;
import org.bana.wechat.qy.media.domain.UploadResult;
import org.bana.wechat.qy.media.param.UploadParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * @ClassName: MediaClient 
 * @Description: 素材管理的客户端定义
 *  
 */
public class MediaClient {
	
	private static final Logger LOG = LoggerFactory.getLogger(MediaClient.class);

	/** 
	* @Description: 上传一个附件到微信，并获得medie——id
	* @author Liu Wenjie   
	* @date 2015-7-20 下午5:20:28 
	* @param parma
	* @return  
	*/ 
	public static UploadResult upload(UploadParam param){
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.postUpload(Constants.上传临时素材文件.getValue(), param);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		if (WeChatConnection.isSuccess(json)) {
			UploadResult uploadResult = (UploadResult) JSONObject.toBean(json, UploadResult.class);
			LOG.info("上传完成后的结果为  " + uploadResult);
			return uploadResult;
		} else {
			String errcode = json.getString(Constants.返回码.getValue());
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
}
