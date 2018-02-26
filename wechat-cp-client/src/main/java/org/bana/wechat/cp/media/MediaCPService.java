/**
 * @Company JBINFO
 * @Title: MediaCPService.java
 * @Package org.bana.wechat.cp.media
 * @author Huang Nana
 * @date 2018年2月7日 上午11:37:31
 * @version V1.0
 */
package org.bana.wechat.cp.media;

import org.bana.wechat.cp.media.domain.UploadResult;
import org.bana.wechat.cp.media.param.UploadParam;

/**
 * @ClassName: MediaCPService
 * @Description: 媒体素材管理
 * @author Huang Nana
 */
public interface MediaCPService {

	/**
	 * Description: 上传附件，获取mediaId
	 * @author Huang Nana
	 * @date 2018年2月7日 上午11:37:54
	 * @param param
	 * @return
	 */
	UploadResult upload(UploadParam param);
}
