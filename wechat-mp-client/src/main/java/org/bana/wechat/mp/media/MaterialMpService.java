package org.bana.wechat.mp.media;

import org.bana.wechat.mp.media.param.WechatMpUploadParam;
import org.bana.wechat.mp.media.result.MediaUploadResult;

public interface MaterialMpService {

	/**
	 * @param uploadParam
	 * @return
	 */
	MediaUploadResult upload(WechatMpUploadParam uploadParam);
}
