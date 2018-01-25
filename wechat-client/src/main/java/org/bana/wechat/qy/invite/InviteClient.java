/**
 * @Company 青鸟软通   
 * @Title: InviteClient.java 
 * @Package org.bana.wechat.qy.invite 
 * @author Liu Wenjie   
 * @date 2015-5-11 下午9:57:49 
 * @version V1.0   
 */
package org.bana.wechat.qy.invite;

import java.util.Map;

import org.bana.common.util.basic.BeanToMapUtil;
import org.bana.wechat.cp.common.Constants;
import org.bana.wechat.qy.common.BanaWeChatException;
import org.bana.wechat.qy.common.WeChatConnection;
import org.bana.wechat.qy.invite.param.InviteSendParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

/**
 * @ClassName: InviteClient
 * @Description: 成员邀请的接口调用
 * 
 */
public class InviteClient {

	private static final Logger LOG = LoggerFactory.getLogger(InviteClient.class);

	public static final Integer WECHAT_INVITE = 1; // 微信邀请
	public static final Integer EMAIL_INVITE = 2;// 邮件邀请

	/**
	 * @Description: 邀请成员关注
	 * @author Liu Wenjie
	 * @date 2015-5-11 下午10:01:11
	 * @param sendParam
	 */
	public static Integer send(InviteSendParam sendParam) {
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(sendParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.邀请成员关注.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		String errcode = json.getString(Constants.返回码.getValue());
		if (WeChatConnection.isSuccess(errcode)) {
			Integer type = json.getInt("type");
			LOG.info("成功邀请的类型 为  " + type);
			return type;
		} else {
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
}
