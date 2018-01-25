/**
* @Company 青鸟软通   
* @Title: DepartmentClientTest.java 
* @Package org.bana.wechat.qy.department 
* @author Liu Wenjie   
* @date 2015-5-9 下午6:19:10 
* @version V1.0   
*/ 
package org.bana.wechat.qy.department;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.bana.common.util.tree.Tree;
import org.bana.common.util.tree.TreeNode;
import org.bana.common.util.tree.TreeNodeList;
import org.bana.common.util.tree.TreeUtil;
import org.bana.wechat.BaseTestCase;
import org.bana.wechat.cp.token.domain.AccessToken;
import org.bana.wechat.qy.connection.GetToken;
import org.bana.wechat.qy.department.domain.Department;
import org.bana.wechat.qy.department.param.DepartmentDeleteParam;
import org.bana.wechat.qy.department.param.DepartmentListParam;
import org.bana.wechat.qy.department.param.DepartmentModifyParam;
import org.junit.Ignore;
import org.junit.Test;

/** 
 * @ClassName: DepartmentClientTest 
 * @Description: 测试部门的微信接口方法
 *  
 */
public class DepartmentClientTest extends BaseTestCase{

	@Test
	public void testList() {
//		String corpId = "wx7dbc31a2b1914a1a";
//		String secret = "50Gmr4TGRAqT0Eh6nlAd_mi6Dt4_i9PYNKNDS88ETK6OgU-MY6h9tPPg10gcZMo-";
//		String accessToken = GetToken.getAccessToken(cropId, secret).getAccessToken();
//		AccessToken accessToken = GetToken.getAccessToken(corpId, secret);
		DepartmentListParam listParam = new DepartmentListParam();
		listParam.setAccess_token(accessToken);
		listParam.setId(7);
//		listParam.setId(48);
		List<Department> list = DepartmentClient.list(listParam);
		long begin = System.currentTimeMillis();
		Tree<Department> tree = TreeUtil.getTree(list, "id", "parentid");
		long end = System.currentTimeMillis();
		System.out.println("转化 " + tree.size() + " 个元素，用时" + (end - begin)); 
		printNode(tree.getRootTreeNodes());
		deleteDepartmentTree(tree.getRootTreeNodes(),accessToken);
		assertNotNull(list);
	}
	
	/** 
	* @Description: 删除指定企业号下的所有id
	* @author Liu Wenjie   
	* @date 2015-12-8 下午3:23:02 
	* @param rootTreeNodes  
	*/ 
	private void deleteDepartmentTree(TreeNodeList<Department> rootTreeNodes,String accessToken) {
		for (int i = 0; i < rootTreeNodes.size(); i++) {
			TreeNode<Department> treeNode = rootTreeNodes.get(i);
			if(!treeNode.getChildrenList().isEmpty()){
				deleteDepartmentTree(treeNode.getChildrenList(),accessToken);
			}
			//删除当前对象
			if(treeNode.getThisData() != null && !treeNode.getId().equals(1)){
				deleteDepartment(treeNode.getThisData(),accessToken);
			}
		}
	}
	
	/** 
	* @Description: 
	* @author Liu Wenjie   
	* @date 2015-12-8 下午3:26:27 
	* @param thisData  
	*/ 
	private void deleteDepartment(Department thisData,String accessToken) {
		DepartmentDeleteParam deleteParam = new DepartmentDeleteParam();
		deleteParam.setAccess_token(accessToken);
		deleteParam.setId(thisData.getId());
		DepartmentClient.delete(deleteParam);
	}

	private void printNode(TreeNodeList<Department> treeNodeList){
		for(int i = 0;i < treeNodeList.size(); i++){
			TreeNode<Department> treeNode = treeNodeList.get(i);
			System.out.print(treeNode.getId() + "\t");
			printNode(treeNode.getChildrenList());
			System.out.println();
		}
	}
	
	@Test
	@Ignore
	public void testCreate(){
		AccessToken accessToken = GetToken.getAccessToken(cropId, secret);
		DepartmentModifyParam createParam = new DepartmentModifyParam();
		createParam.setAccess_token(accessToken.getAccessToken());
		createParam.setName("测试创建中文");
		createParam.setOrder(3);
		createParam.setParentid(59);
		Integer create = DepartmentClient.create(createParam);
		assertNotNull(create);
	}
	
	@Test
//	@Ignore
	public void testUpdate(){
		AccessToken accessToken = GetToken.getAccessToken(cropId, secret);
		DepartmentModifyParam updateParam = new DepartmentModifyParam();
		updateParam.setAccess_token(accessToken.getAccessToken());
		updateParam.setId(66);
//		updateParam.setName("测试修改中文");
//		updateParam.setOrder(3);
		updateParam.setParentid(1);
		DepartmentClient.update(updateParam);
	}
	
	
	@Test
	@Ignore
	public void testDelete(){
		AccessToken accessToken = GetToken.getAccessToken(cropId, secret);
		DepartmentDeleteParam deleteParam = new DepartmentDeleteParam();
		deleteParam.setAccess_token(accessToken.getAccessToken());
		deleteParam.setId(89);
		DepartmentClient.delete(deleteParam);
	}

}
