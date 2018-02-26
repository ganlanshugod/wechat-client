/**
 * @Company JBINFO
 * @Title: MediaCPServiceImpl.java
 * @Package org.bana.wechat.cp.media.impl
 * @author Huang Nana
 * @date 2018年2月7日 上午11:38:56
 * @version V1.0
 */
package org.bana.wechat.cp.media.impl;

import org.bana.wechat.cp.common.Constants;
import org.bana.wechat.cp.common.WechatCpResultHandler;
import org.bana.wechat.cp.common.WechatCpService;
import org.bana.wechat.cp.media.MediaCPService;
import org.bana.wechat.cp.media.domain.UploadResult;
import org.bana.wechat.cp.media.param.UploadParam;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: MediaCPServiceImpl
 * @Description: 素材管理实现
 * @author Huang Nana
 */
public class MediaCPServiceImpl extends WechatCpService implements MediaCPService {

	/**
	 * <p>Description: 上传附件</p>
	 * @author Huang Nana
	 * @date 2018年2月7日 上午11:38:56
	 * @param param
	 * @return
	 * @see org.bana.wechat.cp.media.MediaCPService#upload(org.bana.wechat.cp.media.param.UploadParam)
	 */
	@Override
	public UploadResult upload(UploadParam param) {
		//拼接type参数
		JSONObject result = this.postUpload(Constants.上传临时素材文件.getValue() + "?type=" + param.getType(), param);
		UploadResult uploadResult = WechatCpResultHandler.handleResult(result, UploadResult.class);
		return uploadResult;
	}

}
