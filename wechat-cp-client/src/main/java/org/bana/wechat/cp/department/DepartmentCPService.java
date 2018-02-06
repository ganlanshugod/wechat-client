/**
 * @Company JBINFO
 * @Title: DepartmentCPService.java
 * @Package org.bana.wechat.cp.department
 * @author Zhang Zhichao
 * @date 2018年2月1日 下午1:19:18
 * @version V1.0
 */
package org.bana.wechat.cp.department;

import java.util.List;

import org.bana.wechat.cp.department.domain.Department;
import org.bana.wechat.cp.department.param.DepartmentListParam;

/**
 * @ClassName: DepartmentCPService
 * @Description: 部门信息相关接口
 * @author Zhang Zhichao
 */
public interface DepartmentCPService {
	
	/**
	 * Description: 查询部门列表
	 * @author Zhang Zhichao
	 * @date 2018年2月1日 下午4:29:37
	 * @param param
	 * @return
	 */
	List<Department> findDepartmentList(DepartmentListParam param);
}
