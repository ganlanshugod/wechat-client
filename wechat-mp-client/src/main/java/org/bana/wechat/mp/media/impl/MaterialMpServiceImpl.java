package org.bana.wechat.mp.media.impl;

import org.bana.wechat.mp.common.Constants;
import org.bana.wechat.mp.common.WechatMpResultHandler;
import org.bana.wechat.mp.common.WechatMpService;
import org.bana.wechat.mp.media.MaterialMpService;
import org.bana.wechat.mp.media.param.WechatMpUploadParam;
import org.bana.wechat.mp.media.result.MediaUploadResult;

import com.alibaba.fastjson.JSONObject;

/**
 * 附件上传对应的实现类
 * @author Liu Wenjie
 *
 */
public class MaterialMpServiceImpl extends WechatMpService implements MaterialMpService {

	/** (non-Javadoc)
	 * 上传媒体文件
	 * @see org.bana.wechat.mp.media.MediaMpService#upload(org.bana.wechat.mp.media.param.WechatMpUploadParam)
	 */
	@Override
	public MediaUploadResult upload(WechatMpUploadParam uploadParam) {
		JSONObject postMedia = this.postMedia(Constants.新增永久素材文件.getValue(), uploadParam);
		return WechatMpResultHandler.handleResult(postMedia, MediaUploadResult.class);
	}
	
	

}
