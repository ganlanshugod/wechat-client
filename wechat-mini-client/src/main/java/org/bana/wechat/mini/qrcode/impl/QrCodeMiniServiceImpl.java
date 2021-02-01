/**
* @Company Elink   
* @Title: QrCodeMiniServiceImpl.java 
* @Package org.bana.wechat.mini.qrcode.impl 
* @author ChuLinpeng   
* @date 2021年1月27日 下午4:50:31 
* @version V1.0   
*/
package org.bana.wechat.mini.qrcode.impl;

import java.util.HashMap;
import java.util.Map;

import org.bana.wechat.common.util.StringUtils;
import org.bana.wechat.mini.common.Constants;
import org.bana.wechat.mini.common.WeChatMiniException;
import org.bana.wechat.mini.common.WechatMiniService;
import org.bana.wechat.mini.qrcode.QrCodeMiniService;
import org.bana.wechat.mini.qrcode.param.LineColor;
import org.bana.wechat.mini.qrcode.param.WxacodeParam;
import org.bana.wechat.mini.qrcode.param.WxacodeUnlimitedParam;
import org.bana.wechat.mini.qrcode.param.Wxaqrcode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: QrCodeMiniServiceImpl
 * @Description:
 * @author ChuLinpeng
 */
public class QrCodeMiniServiceImpl extends WechatMiniService implements QrCodeMiniService {
	private static final Logger LOG = LoggerFactory.getLogger(QrCodeMiniServiceImpl.class);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author ChuLinpeng
	 * @date 2021年1月27日 下午5:45:55
	 * @param param
	 * @return
	 * @see org.bana.wechat.mini.qrcode.QrCodeMiniService#createWxaqrcode(org.bana.wechat.mini.qrcode.param.Wxaqrcode)
	 */
	@Override
	public String createWxaqrcode(Wxaqrcode param) {
		if (StringUtils.isBlank(param.getPath())) {
			throw new WeChatMiniException(WeChatMiniException.PARAM_ERROR,"createWxaqrcode时path参数不能为空 ");
		}
		String res = this.getHttpHelper()
				.getBase64FromHttpPost(addAccessToken(Constants.获取有数量限制的小程序二维码.getValue(), param), param);
		return res;
	}
	
	/**
	* <p>Description: </p> 
	* @author ChuLinpeng   
	* @date 2021年1月29日 上午10:47:27 
	* @param param
	* @return 
	* @see org.bana.wechat.mini.qrcode.QrCodeMiniService#createWxaqrcodeInputStream(org.bana.wechat.mini.qrcode.param.Wxaqrcode) 
	*/ 
	@Override
	public byte[] createWxaqrcodeByteArray(Wxaqrcode param) {
		if (StringUtils.isBlank(param.getPath())) {
			throw new WeChatMiniException(WeChatMiniException.PARAM_ERROR,"createWxaqrcode时path参数不能为空 ");
		}
		byte[] res = this.getHttpHelper()
				.getByteArrayFromHttpPost(addAccessToken(Constants.获取有数量限制的小程序二维码.getValue(), param), param);
		return res;
	}

	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author ChuLinpeng
	 * @date 2021年1月27日 下午4:50:31
	 * @param param
	 * @return
	 * @see org.bana.wechat.mini.qrcode.QrCodeMiniService#get(org.bana.wechat.mini.qrcode.param.WxacodeParam)
	 */
	@Override
	public String getWxaqrcode(WxacodeParam param) {
		Map<String, Object> mpParam = structWxaqrcodeParam(param);
		String res = this.getHttpHelper().getBase64FromHttpPost(Constants.获取有数量限制的小程序码.getValue(), mpParam);
		return res;
	}
	
	@Override
	public byte[] getWxaqrcodeByteArray(WxacodeParam param) {
		Map<String, Object> mpParam = structWxaqrcodeParam(param);
		byte[] res = this.getHttpHelper()
				.getByteArrayFromHttpPost(addAccessToken(Constants.获取有数量限制的小程序码.getValue(), param), mpParam);
		return res;
	}
	

	
	private Map<String, Object> structWxaqrcodeParam(WxacodeParam param) {
		Map<String, Object> mpParam = new HashMap<>();
		if (StringUtils.isNotBlank(param.getPath())) {
			mpParam.put("path", param.getPath());
		} else {
			throw new WeChatMiniException(WeChatMiniException.PARAM_ERROR,"getWxaqrcode时path参数不能为空 ");
		}
		if (param.getWidth() < 280) {
			mpParam.put("width", 280);
		} else if (param.getWidth() > 1280) {
			mpParam.put("width", 1280);
		} else {
			mpParam.put("width", param.getWidth());
		}
		mpParam.put("auto_color", param.isAutoColor());
		mpParam.put("line_color", param.getLineColor());
		mpParam.put("is_hyaline", param.isHyaline());
		return mpParam;
	}

	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author ChuLinpeng
	 * @date 2021年1月27日 下午4:50:31
	 * @param param
	 * @return
	 * @see org.bana.wechat.mini.qrcode.QrCodeMiniService#getUnlimited(org.bana.wechat.mini.qrcode.param.WxacodeUnlimitedParam)
	 */
	@Override
	public String getUnlimited(WxacodeUnlimitedParam param) {
		Map<String, Object> mpParam = structUnlimitedParam(param);
		String res = this.getHttpHelper().getBase64FromHttpPost(Constants.获取无数量限制的小程序码.getValue(), mpParam);
		return res;
	}
	
	/**
	* <p>Description: </p> 
	* @author ChuLinpeng   
	* @date 2021年1月29日 上午10:51:28 
	* @param param
	* @return 
	* @see org.bana.wechat.mini.qrcode.QrCodeMiniService#getUnlimitedInputStream(org.bana.wechat.mini.qrcode.param.WxacodeUnlimitedParam) 
	*/ 
	@Override
	public byte[] getUnlimitedByteArray(WxacodeUnlimitedParam param) {
		Map<String, Object> mpParam = structUnlimitedParam(param);
		byte[] res = this.getHttpHelper()
				.getByteArrayFromHttpPost(addAccessToken(Constants.获取无数量限制的小程序码.getValue(), param), mpParam);
		return res;
	}
	
	private Map<String, Object> structUnlimitedParam(WxacodeUnlimitedParam param) {
		Map<String, Object> mpParam = new HashMap<>();
		if (StringUtils.isNotBlank(param.getScene())) {
			mpParam.put("scene", param.getScene());
		} else {
			mpParam.put("scene", "");
		}
		if (StringUtils.isNotBlank(param.getPage())) {
			mpParam.put("page", param.getPage());
		}
		if (param.getWidth() < 280) {
			mpParam.put("width", 280);
		} else if (param.getWidth() > 1280) {
			mpParam.put("width", 1280);
		} else {
			mpParam.put("width", param.getWidth());
		}
		mpParam.put("auto_color", param.isAutoColor());
		mpParam.put("line_color", param.getLineColor());
		mpParam.put("is_hyaline", param.isHyaline());
		return mpParam;
	}
}
