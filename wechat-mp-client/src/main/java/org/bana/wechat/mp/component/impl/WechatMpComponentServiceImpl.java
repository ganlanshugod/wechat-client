/**
* @Company 全域旅游
* @Title: ComponentService.java 
* @Package org.bana.wechat.mp.component.impl 
* @author liuwenjie   
* @date Sep 18, 2020 1:22:50 PM 
* @version V1.0   
*/
package org.bana.wechat.mp.component.impl;

import java.util.HashMap;
import java.util.Map;

import org.bana.wechat.mp.common.Constants;
import org.bana.wechat.mp.common.WechatMpResultHandler;
import org.bana.wechat.mp.component.ComponentService;
import org.bana.wechat.mp.component.common.WechatMpComponentBaseService;
import org.bana.wechat.mp.component.param.AuthorizerOption;
import org.bana.wechat.mp.component.result.AuthDetailInfo;
import org.bana.wechat.mp.component.result.AuthorizationInfo;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: ComponentService
 * @Description: 第三方平台相关的接口实现
 * @author liuwenjie
 */
public class WechatMpComponentServiceImpl extends WechatMpComponentBaseService implements ComponentService {

	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author liuwenjie
	 * @date Sep 18, 2020 1:23:47 PM
	 * @param appId
	 * @see org.bana.wechat.mp.component.ComponentService#createPreAuthCode(java.lang.String)
	 */
	@Override
	public String createPreAuthCode(String componentAppId) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("component_appid", componentAppId);
		JSONObject post = this.post(Constants.第三方获取预授权码.getValue(), componentAppId, param);
		WechatMpResultHandler.handleResult(post);
		return post.getString("pre_auth_code");
//		{
//			  "pre_auth_code": "Cx_Dk6qiBE0Dmx4EmlT3oRfArPvwSQ-oa3NL_fwHM7VI08r52wazoZX2Rhpz1dEw",
//			  "expires_in": 600
//		}

	}

	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author liuwenjie
	 * @date Sep 18, 2020 2:03:38 PM
	 * @param componentAppId
	 * @param authCode
	 * @return
	 * @see org.bana.wechat.mp.component.ComponentService#queryAuth(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public AuthorizationInfo queryAuth(String componentAppId, String authCode) {
//		{
//			"component_appid":"appid_value" ,
//			"authorization_code": "auth_code_value"
//			}
		Map<String, String> param = new HashMap<>();
		param.put("component_appid", componentAppId);
		param.put("authorization_code", authCode);
		JSONObject post = this.post(Constants.第三方获取授权信息.getValue(), componentAppId, param);
		WechatMpResultHandler.handleResult(post);
		AuthorizationInfo javaObject = post.getJSONObject("authorization_info").toJavaObject(AuthorizationInfo.class);
		return javaObject;
	}

	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author liuwenjie
	 * @date Sep 18, 2020 3:46:01 PM
	 * @param componentAppId
	 * @param authorizerAppid
	 * @return
	 * @see org.bana.wechat.mp.component.ComponentService#getAuthorizerInfo(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public AuthDetailInfo getAuthorizerInfo(String componentAppId, String authorizerAppid) {
//		{
//			  "component_appid": "appid_value" ,
//			  "authorizer_appid": "auth_appid_value"
//			}
		Map<String, String> param = new HashMap<>();
		param.put("component_appid", componentAppId);
		param.put("authorizer_appid", authorizerAppid);
		JSONObject post = this.post(Constants.第三方获取授权详细信息.getValue(), componentAppId, param);
		return WechatMpResultHandler.handleResult(post, AuthDetailInfo.class);
	}

	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author liuwenjie
	 * @date Sep 18, 2020 4:23:10 PM
	 * @param componentAppId
	 * @param authorizerAppid
	 * @param option
	 * @return
	 * @see org.bana.wechat.mp.component.ComponentService#getAuthorizerOption(java.lang.String,
	 *      java.lang.String, org.bana.wechat.mp.component.param.AuthorizerOption)
	 */
	@Override
	public String getAuthorizerOption(String componentAppId, String authorizerAppid, AuthorizerOption option) {
//		{
//			  "component_appid": "appid_value",
//			  "authorizer_appid": "auth_appid_value ",
//			  "option_name": "option_name_value"
//			}
		Map<String, String> param = new HashMap<>();
		param.put("component_appid", componentAppId);
		param.put("authorizer_appid", authorizerAppid);
		param.put("option_name", option.getOptionName());
		JSONObject post = this.post(Constants.第三方获取授权方配置开关.getValue(), componentAppId, param);
		WechatMpResultHandler.handleResult(post);
//		{
//			  "authorizer_appid": "wx7bc5ba58cabd00f4",
//			  "option_name": "voice_recognize",
//			  "option_value": "1"
//			}
		return post.getString("option_value");
	}

	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author liuwenjie
	 * @date Sep 18, 2020 4:28:32 PM
	 * @param componentAppId
	 * @param authorizerAppid
	 * @param option
	 * @param optionValue
	 * @see org.bana.wechat.mp.component.ComponentService#setAuthorizerOption(java.lang.String,
	 *      java.lang.String, org.bana.wechat.mp.component.param.AuthorizerOption,
	 *      java.lang.String)
	 */
	@Override
	public void setAuthorizerOption(String componentAppId, String authorizerAppid, AuthorizerOption option,
			String optionValue) {
//		{
//		  "component_appid": "appid_value",
//		  "authorizer_appid": "auth_appid_value ",
//		  "option_name": "option_name_value",
//		  "option_value": "option_value_value"
//		}

		Map<String, String> param = new HashMap<>();
		param.put("component_appid", componentAppId);
		param.put("authorizer_appid", authorizerAppid);
		param.put("option_name", option.getOptionName());
		param.put("option_value", optionValue);
		JSONObject post = this.post(Constants.第三方设置授权方配置开关.getValue(), componentAppId, param);
		WechatMpResultHandler.handleResult(post);
	}

}
