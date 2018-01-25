/**
* @Company 青鸟软通   
* @Title: TagClient.java 
* @Package org.bana.wechat.qy.tag 
* @author Liu Wenjie   
* @date 2015-5-11 下午10:21:03 
* @version V1.0   
*/ 
package org.bana.wechat.qy.tag;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bana.common.util.basic.BeanToMapUtil;
import org.bana.wechat.cp.common.Constants;
import org.bana.wechat.qy.common.BanaWeChatException;
import org.bana.wechat.qy.common.WeChatConnection;
import org.bana.wechat.qy.common.WeChatParam;
import org.bana.wechat.qy.tag.domain.GetTagUserResult;
import org.bana.wechat.qy.tag.domain.ManagerTagUserResult;
import org.bana.wechat.qy.tag.param.TagCreateParam;
import org.bana.wechat.qy.tag.param.TagDeleteParam;
import org.bana.wechat.qy.tag.param.TagGetParam;
import org.bana.wechat.qy.tag.param.TagUpdateParam;
import org.bana.wechat.qy.tag.param.TagUserParam;
import org.bana.wechat.qy.user.domain.SimpleUser;
import org.bana.wechat.qy.user.domain.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

/** 
 * @ClassName: TagClient 
 * @Description: 标签管理的接口
 *  
 */
public class TagClient {
	
	private static final Logger LOG = LoggerFactory.getLogger(TagClient.class);
	/** 
	* @Description: 创建标签
	* @author Liu Wenjie   
	* @date 2015-5-11 下午10:28:58 
	* @param createParam
	* @return  
	*/ 
	public static String create(TagCreateParam createParam){
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(createParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.创建标签.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		String errcode = json.getString(Constants.返回码.getValue());
		if (WeChatConnection.isSuccess(errcode)) {
			String tagId = json.getString("tagid");
			LOG.info("创建标签成功 tagId =" + tagId );
			return tagId;
		} else {
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
	
	/** 
	* @Description: 更新标签名字
	* @author Liu Wenjie   
	* @date 2015-5-11 下午10:39:54 
	* @param updateParam  
	*/ 
	public static void update(TagUpdateParam updateParam){
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(updateParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.更新标签名字.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		String errcode = json.getString(Constants.返回码.getValue());
		if (WeChatConnection.isSuccess(errcode)) {
			LOG.info("更新标签成功" + updateParam);
			return;
		} else {
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
	
	/** 
	* @Description: 删除标签
	* @author Liu Wenjie   
	* @date 2015-5-11 下午10:43:13 
	* @param deleteParam  
	*/ 
	public static void delete(TagDeleteParam deleteParam){
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(deleteParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.get(Constants.删除标签.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		String errcode = json.getString(Constants.返回码.getValue());
		if (WeChatConnection.isSuccess(errcode)) {
			LOG.info("删除标签成功" + deleteParam);
			return;
		} else {
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
	
	
	/** 
	* @Description: 获取标签对应的成员集合
	* @author Liu Wenjie   
	* @date 2015-5-11 下午10:56:26 
	* @param getParam
	* @return  
	*/ 
	public static GetTagUserResult get(TagGetParam getParam){
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(getParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.get(Constants.获取标签成员.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		String errcode = json.getString(Constants.返回码.getValue());
		if (WeChatConnection.isSuccess(errcode)) {
//			JSONArray jsonArray = json.getJSONArray("userlist");
			Map<String,Object> classMap = new HashMap<String, Object>();
	        classMap.put("userlist", SimpleUser.class);
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setRootClass(GetTagUserResult.class);
			jsonConfig.setClassMap(classMap);
			jsonConfig.setJavaPropertyFilter(new PropertyFilter() {
				public boolean apply(Object source/* 属性的拥有者 */, String name /* 属性名字 */, Object value/* 属性值 */) {
					if (name.equals("department")) {
						return true;
					} else {
						return false;
					}
				}
			});
			GetTagUserResult array = (GetTagUserResult) JSONObject.toBean(json , jsonConfig);
			LOG.info("转化后的标签成员集合为" + array);
			return array;
		} else {
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
	
	
	/** 
	* @Description: 增加标签成员
	* @author Liu Wenjie   
	* @date 2015-5-11 下午11:20:22 
	* @param addParam
	* @return  
	*/ 
	public static ManagerTagUserResult addTagUsers(TagUserParam addParam){
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(addParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.增加标签成员.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		String errcode = json.getString(Constants.返回码.getValue());
		if (WeChatConnection.isSuccess(errcode)) {
			ManagerTagUserResult bean = (ManagerTagUserResult)JSONObject.toBean(json,ManagerTagUserResult.class);
			LOG.info("增加标签成员成功" + addParam + ",返回结果为" + bean);
			return bean;
		} else {
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
	
	
	/** 
	* @Description: 删除标签成员
	* @author Liu Wenjie   
	* @date 2015-5-12 下午4:43:19 
	* @param deleteParam
	* @return  
	*/ 
	public static ManagerTagUserResult delTagUsers(TagUserParam deleteParam){
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(deleteParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.删除标签成员.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		String errcode = json.getString(Constants.返回码.getValue());
		if (WeChatConnection.isSuccess(errcode)) {
			ManagerTagUserResult bean = (ManagerTagUserResult)JSONObject.toBean(json,ManagerTagUserResult.class);
			LOG.info("删除标签成员成功" + deleteParam + ",返回结果为" + bean);
			return bean;
		} else {
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
	
	/**
	* @Description: 获取标签列表
	* @author Liu Wenjie   
	* @date 2015-5-12 下午5:00:41 
	* @param param
	* @return
	 */
	public static List<Tag> list(WeChatParam param){
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(param);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.get(Constants.获取标签列表.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		String errcode = json.getString(Constants.返回码.getValue());
		if (WeChatConnection.isSuccess(errcode)) {
			JSONArray jsonArray = json.getJSONArray("taglist");
			Tag[] array = (Tag[]) JSONArray.toArray(jsonArray , Tag.class);
			LOG.info("转化后的标签集合为" + Arrays.toString(array));
			return Arrays.asList(array);
		} else {
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
}
