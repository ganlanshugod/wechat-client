/**
* @Company 艾美伴行 
* @Title: KefuClient.java 
* @Package org.bana.wechat.qy.kefu 
* @author Yang Shuangshuang   
* @date 2016-5-5 13:17:44 
* @version V1.0   
*/ 
package org.bana.wechat.qy.kefu;

import java.util.Arrays;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.bana.common.util.basic.BeanToMapUtil;
import org.bana.wechat.qy.common.BanaWeChatException;
import org.bana.wechat.qy.common.Constants;
import org.bana.wechat.qy.common.WeChatConnection;
import org.bana.wechat.qy.kefu.domain.Kefu;
import org.bana.wechat.qy.kefu.param.KefuParam;
import org.bana.wechat.qy.kefu.param.KefuQueryParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
* @ClassName: KefuClient 
* @Description: 客服客户端接口
*
 */
public class KefuClient {
	private static final Logger LOG = LoggerFactory.getLogger(KefuClient.class);
	
	/**
	* @Description: 发送消息方法
	* @author Yang Shuangshuang   
	* @date 2016-5-5 下午1:18:32 
	* @param message
	* @return
	 */
	public static void send(KefuParam kefuParam){
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(kefuParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.发送客服消息.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		String errcode = json.getString(Constants.返回码.getValue());
		if (WeChatConnection.isSuccess(errcode)) {
			LOG.info("发送消息成功");
			return;
		} else {
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
	
	public static Kefu findKfList(KefuQueryParam param){
		Kefu kefu=new Kefu();
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(param);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.获取客服列表.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		String errcode = json.getString(Constants.返回码.getValue());
		if (WeChatConnection.isSuccess(errcode)) {
			Object kefuJson;
			if(param.getType().equals("internal")){
				kefuJson = json.get("internal");
			}else{
				kefuJson = json.get("external");
			}
			JSONObject resultJson= JSONObject.fromObject(kefuJson);
			//成员
			JSONArray userArray=resultJson.getJSONArray("user");
			String[] users = (String[]) JSONArray.toArray(userArray, String.class);
			kefu.setUser(Arrays.asList(users));
			LOG.info("转化后的成员集合结果为 " + kefu.getUser());
			//部门
			JSONArray partyArray=resultJson.getJSONArray("party");
			Integer[] partys = (Integer[]) JSONArray.toArray(partyArray, Integer.class);
			if(partys.length>0){
				kefu.setParty(Arrays.asList(partys));
				LOG.info("转化后的部门集合结果为 " + kefu.getParty());
			}
			//标签
			JSONArray tagArray=resultJson.getJSONArray("tag");
			Integer[] tags = (Integer[]) JSONArray.toArray(tagArray, Integer.class);
			if(tags.length>0){
				kefu.setTag(Arrays.asList(tags));
				LOG.info("转化后的标签集合结果为 " + kefu.getTag());
			}
			return kefu;
		}else {
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}


}
