/**
 * @Company JBINFO
 * @Title: DepartmentCPServiceImpl.java
 * @Package org.bana.wechat.cp.department.impl
 * @author Zhang Zhichao
 * @date 2018年2月1日 下午1:20:02
 * @version V1.0
 */
package org.bana.wechat.cp.department.impl;

import java.util.List;

import org.bana.wechat.cp.common.Constants;
import org.bana.wechat.cp.common.WechatCpResultHandler;
import org.bana.wechat.cp.common.WechatCpService;
import org.bana.wechat.cp.department.DepartmentCPService;
import org.bana.wechat.cp.department.domain.Department;
import org.bana.wechat.cp.department.param.DepartmentListParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: DepartmentCPServiceImpl
 * @Description: 部门信息相关接口实现
 * @author Zhang Zhichao
 */
public class DepartmentCPServiceImpl extends WechatCpService implements DepartmentCPService{
	
	private static final Logger LOG = LoggerFactory.getLogger(DepartmentCPServiceImpl.class);
	
	/**
	 * <p>Description: 查询部门列表</p>
	 * @author Zhang Zhichao
	 * @date 2018年2月1日 下午4:30:05
	 * @param param
	 * @return
	 * @see org.bana.wechat.cp.department.DepartmentCPService#findDepartmentList(org.bana.wechat.cp.department.param.DepartmentListParam)
	 */
	@Override
	public List<Department> findDepartmentList(DepartmentListParam param) {
		JSONObject result = this.get(Constants.获取部门列表.getValue(), param);
		List<Department> depList = WechatCpResultHandler.handleResult(result, Department.class, "department");
		LOG.info("获取到的部门列表为： " + depList);
		return depList;
	}
}
