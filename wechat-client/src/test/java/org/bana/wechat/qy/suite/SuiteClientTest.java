/**
* @Company 青鸟软通   
* @Title: SuiteClientTest.java 
* @Package org.bana.wechat.qy.suite 
* @author Liu Wenjie   
* @date 2015-5-14 上午10:32:14 
* @version V1.0   
*/ 
package org.bana.wechat.qy.suite;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.bana.common.util.basic.ClonePojoUtil;
import org.bana.wechat.BaseTestCase;
import org.bana.wechat.cp.common.Constants;
import org.bana.wechat.cp.token.domain.AccessToken;
import org.bana.wechat.qy.agent.domain.AgentInfo;
import org.bana.wechat.qy.common.BanaWeChatException;
import org.bana.wechat.qy.common.WeChatConnection;
import org.bana.wechat.qy.suite.domain.Agent;
import org.bana.wechat.qy.suite.domain.Department;
import org.bana.wechat.qy.suite.domain.PermanentCode;
import org.bana.wechat.qy.suite.domain.PreAuthCode;
import org.bana.wechat.qy.suite.param.AgentParam;
import org.bana.wechat.qy.suite.param.GetAgentInfoParam;
import org.bana.wechat.qy.suite.param.GetAuthInfoParam;
import org.bana.wechat.qy.suite.param.GetCorpTokenParam;
import org.bana.wechat.qy.suite.param.MarkSuiteParam;
import org.bana.wechat.qy.suite.param.PermanentCodeParam;
import org.bana.wechat.qy.suite.param.PreAuthCodeParam;
import org.bana.wechat.qy.suite.param.SetAgentParam;
import org.junit.Before;
import org.junit.Test;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/** 
 * @ClassName: SuiteClientTest 
 * @Description: 第三方应用接口的测试方法
 *  
 */
public class SuiteClientTest extends BaseTestCase{
	private AccessToken corpToken;
	private String suiteToken ;
	
	@Before
	public void init(){
//		suiteToken = GetToken.getSuiteToken(suite_id, suite_secret, suite_ticket);
		suiteToken = "cJEW-UPPUKdjeUsklpD1FBrmiV3RNMUYAB01pdisDw7kBGCPBgtZ22OpU58O8nR-";
//		GetCorpTokenParam tokenParam = new GetCorpTokenParam();
//		tokenParam.setSuite_access_token(suiteToken);
//		tokenParam.setSuite_id(suite_id);
//		tokenParam.setPermanent_code(permanentCode);
//		tokenParam.setAuth_corpid(cropId);
//		corpToken = SuiteClient.getCorpToken(tokenParam);
	}

	/**
	 * Test method for {@link org.bana.wechat.qy.suite.SuiteClient#getPreAuthCode(org.bana.wechat.qy.suite.param.PreAuthCodeParam)}.
	 */
	@Test
	public void testGetPreAuthCode() {
		PreAuthCodeParam authCode = new PreAuthCodeParam();
		authCode.setSuite_access_token(suiteToken);
		authCode.setAppid(Arrays.asList(1,2));
		authCode.setSuite_id(suite_id);
		PreAuthCode preAuthCode = SuiteClient.getPreAuthCode(authCode);
		assertNotNull(preAuthCode);
	}
	
	@Test
	public void testGetPermanentCode(){
		String authCode = "ldglBm8sI4NGPKoZw3siOvyTsljh-KvHxaziXGUbUHTLpn72J9qrwCUS17_pb2vE";
		PermanentCodeParam permanentCode = new PermanentCodeParam();
		permanentCode.setSuite_access_token(suiteToken);
		permanentCode.setSuite_id(suite_id);
		permanentCode.setAuth_code(authCode);
		PermanentCode permanentCode2 = SuiteClient.getPermanentCode(permanentCode);
		assertNotNull(permanentCode2);
	}
	
	@Test
	public void testCreatePermanentCodeResult(){
		String result = "{"+
			    "\"access_token\": \"Z8k9avKfiV4IzHZKCQzpofL9eVx7gGT5Ja3q8KRaBrfkdoxBbZfZbsEBfJ69YTZ4\","+
			    "\"expires_in\": 7200,"+
			    "\"permanent_code\": \"L2t8UqNPplXCBNBOZDlYD-EFW6hGZQuSiG-tS1X7-KpxG6_khhgmKe19mXhRgVG-\","+
			    "\"auth_corp_info\": {"+
			        "\"corpid\": \"wxf53fe967743802e4\","+
			        "\"corp_name\": \"QAS伴行3618\","+
			        "\"corp_type\": \"unverified\","+
			        "\"corp_round_logo_url\": \"\","+
			        "\"corp_square_logo_url\": \"\","+
			        "\"corp_user_max\": 50,"+
			        "\"corp_agent_max\": 30,"+
			        "\"corp_wxqrcode\": \"http://shp.qpic.cn/bizmp/ocrXJL70nTVFLLyYabUqjJBKVKMLDbiax1ybIgXB0ksSmohs3uTGajg/\""+
			    "},"+
			    "\"auth_info\": {"+
			      "  \"agent\": ["+
			      "      {"+
			       "         \"agentid\": 4,"+
			       "         \"name\": \"家校互动\","+
			       "         \"square_logo_url\": \"http://wx.qlogo.cn/mmhead/Q3auHgzwzM6icQjNky00NtB6vicLVJtrGE5wibsQAOm35gIOLPpE10y3w/0\","+
			       "         \"round_logo_url\": \"http://mmbiz.qpic.cn/mmbiz/OfwqdGWJia9vZ5C3h96YpWHb2W6BPm57UgaLicH0CAnQhcsjn6NlfoI2W7HicQPhZUG2TV0sRLPqRwb9hIRBI3x5Q/0\","+
			        "        \"appid\": 1,"+
			        "        \"api_group\": ["+
			        "            \"get_location\""+
			       "         ]"+
			       "     }"+
			      "  ],"+
			      "  \"department\": ["+
			       "     {"+
			       "         \"id\": 1,"+
			        "        \"name\": \"风度第一小学\","+
			        "        \"parentid\": 0,"+
			         "       \"order\": 200,"+
			        "        \"writable\": true"+
			        "    }"+
			       " ]"+
			    "},"+
			    "\"auth_user_info\": {"+
			    "    \"email\": \"liuwenjie@i3618.com.cn\""+
			    "}"+
			"}";
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setRootClass(PermanentCode.class);
		Map<String,Object> mapClass = new HashMap<String,Object>();
		mapClass.put("agent", Agent.class);
		mapClass.put("department", Department.class);
		jsonConfig.setClassMap(mapClass);
		if (WeChatConnection.isSuccess(json)) {
			PermanentCode bean = (PermanentCode) JSONObject.toBean(json, jsonConfig);
			System.out.println("转化后的企业号的永久授权码为 " + bean);
		} else {
			String errcode = json.getString(Constants.返回码.getValue());
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
	
	
	/**
	* @Description: 测试通过永久授权码获取accessToken的方法
	* @author Liu Wenjie   
	* @date 2015-5-15 下午9:33:08
	 */
	@Test
	public void testGetSuiteToken(){
		GetCorpTokenParam tokenParam = new GetCorpTokenParam();
		tokenParam.setSuite_access_token(suiteToken);
		tokenParam.setSuite_id(suite_id);
		tokenParam.setPermanent_code(permanentCode);
		tokenParam.setAuth_corpid(cropId);
		AccessToken corpToken = SuiteClient.getCorpToken(tokenParam);
		assertNotNull(corpToken);
	}
	
	@Test
	public void testGetAgentInfo(){
		GetAgentInfoParam agentParam = new GetAgentInfoParam();
		agentParam.setSuite_access_token(suiteToken);
		agentParam.setSuite_id(suite_id);
		agentParam.setPermanent_code(permanentCode);
		agentParam.setAuth_corpid(cropId);
		agentParam.setAgentid("132");
		AgentInfo agentInfo = SuiteClient.getAgentInfo(agentParam);
		assertNotNull(agentInfo);
	}
	
	@Test
	public void testSetAgentInfo(){
		GetAgentInfoParam agentParam = new GetAgentInfoParam();
		agentParam.setSuite_access_token(suiteToken);
		agentParam.setSuite_id(suite_id);
		agentParam.setPermanent_code(permanentCode);
		agentParam.setAuth_corpid(cropId);
		agentParam.setAgentid("5");
		AgentInfo agentInfo = SuiteClient.getAgentInfo(agentParam);
		
		SetAgentParam agentsetParam = new SetAgentParam();
		agentsetParam.setSuite_access_token(suiteToken);
		agentsetParam.setSuite_id(suite_id);
		agentsetParam.setPermanent_code(permanentCode);
		agentsetParam.setAuth_corpid(cropId);
		AgentParam agent = ClonePojoUtil.copyClassFromTo(agentInfo, AgentParam.class);
		agent.setRedirect_domain("wechat.i3618.com.cn");
		agentsetParam.setAgent(agent);
		SuiteClient.setAgent(agentsetParam);
		
//		JsonConfig config = new JsonConfig();
//		config.setJsonPropertyFilter(new PropertyFilter()  
//		{  
//		    @Override  
//		    public boolean apply(Object source, String name, Object value)  
//		    {  
//		        return value == null;  
//		    }  
//		}); 
//		JSONObject jsonObject = JSONObject.fromObject(agentsetParam,config);
//		System.out.println(jsonObject.toString());
	}
	
	/**
	* @Description: 
	* @author Liu Wenjie   
	* @date 2015-5-30 上午11:12:16
	 */
	@Test
	public void testGetAuthInfo(){
		GetAuthInfoParam getParam = new GetAuthInfoParam();
		getParam.setAuth_corpid(cropId);
		getParam.setSuite_access_token(suiteToken);
		getParam.setPermanent_code(permanentCode);
		getParam.setSuite_id(suite_id);
		
		Map<String, Object> authInfo = SuiteClient.getAuthInfo(getParam);
		assertNotNull(authInfo);
		System.out.println(authInfo);
	}
	
	
	@Test
	public void testMarkAsContactsSuite(){
		MarkSuiteParam markSuiteParam = new MarkSuiteParam();
		markSuiteParam.setAuth_corpid(cropId);
		markSuiteParam.setIs_contact_suite(true);
		markSuiteParam.setPermanent_code(permanentCode);
		markSuiteParam.setSuite_access_token(suiteAccessToken);
		markSuiteParam.setSuite_id(suite_id);
		SuiteClient.markAsContactsSuite(markSuiteParam);
		
	}

}
