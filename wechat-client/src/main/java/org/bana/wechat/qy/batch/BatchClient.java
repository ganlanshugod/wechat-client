/**
 * @Company 成长伴行   
 * @Title: BatchClient.java 
 * @Package org.bana.wechat.qy.batch 
 * @author Yang Shuangshuang   
 * @date 2016-11-10 下午4:21:59 
 * @version V1.0   
 */
package org.bana.wechat.qy.batch;

import java.util.Map;

import org.bana.common.util.basic.BeanToMapUtil;
import org.bana.wechat.cp.common.Constants;
import org.bana.wechat.qy.batch.param.DepartmentReplaceParam;
import org.bana.wechat.qy.common.BanaWeChatException;
import org.bana.wechat.qy.common.WeChatConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

/**
 * @ClassName: BatchClient
 * @Description: 微信企业号异步任务相关的接口方法
 * 
 */
public class BatchClient {

	private static final Logger LOG = LoggerFactory.getLogger(BatchClient.class);

	/**
	* @Description: 全量覆盖部门
	* @author Yang Shuangshuang   
	* @date 2016-11-10 下午4:53:16 
	* @param listParam
	* @return
	 */
	public static String replaceParty(DepartmentReplaceParam departParam) {
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(departParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.全量覆盖部门.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		String errcode = json.getString(Constants.返回码.getValue());
		if (WeChatConnection.isSuccess(errcode)) {
			String jobId = json.getString("jobid");
			LOG.info("全量覆盖部门jobid为 " + jobId);
			return jobId;
		} else {
			String errmsg = json.getString(Constants.返回信息.getValue());
			LOG.info("全量覆盖部门失败 " + errmsg);
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
	
	/**
	* @Description: 全量覆盖部门
	* @author Yang Shuangshuang   
	* @date 2016-11-10 下午4:53:16 
	* @param listParam
	* @return
	 */
	public static String syncUser(DepartmentReplaceParam departParam) {
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(departParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.批量更新成员.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		String errcode = json.getString(Constants.返回码.getValue());
		if (WeChatConnection.isSuccess(errcode)) {
			String jobId = json.getString("jobid");
			LOG.info("批量更新成员的jobid为 " + jobId);
			return jobId;
		} else {
			String errmsg = json.getString(Constants.返回信息.getValue());
			LOG.info("批量更新成员失败 " + errmsg);
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
}
