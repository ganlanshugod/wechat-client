/**
 * @Company 青鸟软通   
 * @Title: DepartmentClient.java 
 * @Package org.bana.wechat.qy.department 
 * @author Liu Wenjie   
 * @date 2015-5-9 下午5:21:59 
 * @version V1.0   
 */
package org.bana.wechat.qy.department;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.bana.common.util.basic.BeanToMapUtil;
import org.bana.wechat.qy.common.BanaWeChatException;
import org.bana.wechat.qy.common.Constants;
import org.bana.wechat.qy.common.WeChatConnection;
import org.bana.wechat.qy.department.domain.Department;
import org.bana.wechat.qy.department.param.DepartmentDeleteParam;
import org.bana.wechat.qy.department.param.DepartmentListParam;
import org.bana.wechat.qy.department.param.DepartmentModifyParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: DepartmentClient
 * @Description: 微信企业号部门相关的接口方法
 * 
 */
public class DepartmentClient {

	private static final Logger LOG = LoggerFactory.getLogger(DepartmentClient.class);

	/**
	 * @Description: 根据查询方法获取部门集合的方法
	 * @author Liu Wenjie
	 * @date 2015-5-9 下午5:26:37
	 * @param listParam
	 */
	public static List<Department> list(DepartmentListParam listParam) {
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(listParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.get(Constants.获取部门列表.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		String errcode = json.getString(Constants.返回码.getValue());
		if (WeChatConnection.isSuccess(errcode)) {
			JSONArray jsonArray = json.getJSONArray("department");
			Department[] array = (Department[]) JSONArray.toArray(jsonArray, Department.class);
			LOG.info("转化后的部门集合结果为 " + Arrays.toString(array));
			return Arrays.asList(array);
		} else {
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}

	/**
	 * @Description: 创建一个部门
	 * @author Liu Wenjie
	 * @date 2015-5-9 下午7:41:04
	 * @param createParam
	 * @return
	 */
	public static Integer create(DepartmentModifyParam createParam) {
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(createParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.创建部门.getValue(), convertBean);
		JSONObject json = JSONObject.fromObject(result);
		String errcode = json.getString(Constants.返回码.getValue());
		if (WeChatConnection.isSuccess(errcode)) {
			Integer id = json.getInt("id");
			LOG.info("创建部门后生成的部门id为 " + id);
			return id;
		} else {
			String errmsg = json.getString(Constants.返回信息.getValue());
			LOG.info("创建部门失败 " + errmsg);
			throw new BanaWeChatException(errcode, errmsg);
		}
	}

	/**
	* @Description: 更新一条部门信息
	* @author Liu Wenjie   
	* @date 2015-5-9 下午7:49:15 
	* @param updateParam
	 */
	public static void update(DepartmentModifyParam updateParam) {
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(updateParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.更新部门.getValue(), convertBean);
		JSONObject json = JSONObject.fromObject(result);
		String errcode = json.getString(Constants.返回码.getValue());
		if (WeChatConnection.isSuccess(errcode)) {
			LOG.info("修改部门成功" + updateParam);
		} else {
			String errmsg = json.getString(Constants.返回信息.getValue());
			LOG.info("修改部门失败" + updateParam);
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
	
	/**
	* @Description: 删除一条指定的删除参数
	* @author Liu Wenjie   
	* @date 2015-5-9 下午7:58:11 
	* @param deleteParam
	 */
	public static void delete(DepartmentDeleteParam deleteParam){
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(deleteParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.get(Constants.删除部门.getValue(), convertBean);
		JSONObject json = JSONObject.fromObject(result);
		String errcode = json.getString(Constants.返回码.getValue());
		if (WeChatConnection.isSuccess(errcode)) {
			LOG.info("删除部门成功" + deleteParam);
		} else {
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
}
