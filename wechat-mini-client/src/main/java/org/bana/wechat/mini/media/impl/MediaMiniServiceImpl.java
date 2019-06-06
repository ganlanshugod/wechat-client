package org.bana.wechat.mini.media.impl;

import org.bana.wechat.mini.common.Constants;
import org.bana.wechat.mini.common.WechatMiniResultHandler;
import org.bana.wechat.mini.common.WechatMiniService;
import org.bana.wechat.mini.media.MediaMiniService;
import org.bana.wechat.mini.media.param.WechatMiniUploadParam;
import org.bana.wechat.mini.media.result.MediaUploadResult;

import com.alibaba.fastjson.JSONObject;

/**
 * 附件上传对应的实现类
 * @author Liu Wenjie
 *
 */
public class MediaMiniServiceImpl extends WechatMiniService implements MediaMiniService {

	/** (non-Javadoc)
	 * 上传媒体文件
	 * @see org.bana.wechat.mp.media.MediaMiniService#upload(org.bana.wechat.mp.media.WechatMiniUploadParam.WechatMpUploadParam)
	 */
	@Override
	public MediaUploadResult upload(WechatMiniUploadParam uploadParam) {
		JSONObject postMedia = this.postMedia(Constants.上传媒体文件.getValue(), uploadParam);
		return WechatMiniResultHandler.handleResult(postMedia, MediaUploadResult.class);
	}
	
	

}
