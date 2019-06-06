package org.bana.wechat.mini.media;

import org.bana.wechat.mini.media.param.WechatMiniUploadParam;
import org.bana.wechat.mini.media.result.MediaUploadResult;

public interface MediaMiniService {

	/**
	 * @param uploadParam
	 * @return
	 */
	MediaUploadResult upload(WechatMiniUploadParam uploadParam);
}
