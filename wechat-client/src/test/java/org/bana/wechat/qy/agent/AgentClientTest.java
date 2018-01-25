/**
* @Company 青鸟软通   
* @Title: AgentClientTest.java 
* @Package org.bana.wechat.qy.agent 
* @author Liu Wenjie   
* @date 2015-5-15 下午5:31:23 
* @version V1.0   
*/ 
package org.bana.wechat.qy.agent;

import static org.junit.Assert.*;

import java.util.List;

import org.bana.wechat.BaseTestCase;
import org.bana.wechat.cp.token.domain.AccessToken;
import org.bana.wechat.cp.token.domain.SuiteAccessToken;
import org.bana.wechat.qy.agent.domain.AgentInfo;
import org.bana.wechat.qy.agent.param.AgentGetParam;
import org.bana.wechat.qy.agent.param.AgentSetParam;
import org.bana.wechat.qy.common.WeChatParam;
import org.bana.wechat.qy.connection.GetToken;
import org.bana.wechat.qy.suite.SuiteClient;
import org.bana.wechat.qy.suite.domain.Agent;
import org.bana.wechat.qy.suite.param.GetCorpTokenParam;
import org.junit.Before;
import org.junit.Test;

/** 
 * @ClassName: AgentClientTest 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 *  
 */
public class AgentClientTest extends BaseTestCase{
	private AccessToken corpToken;
	private SuiteAccessToken suiteToken ;
	@Before
	public void init(){
		suiteToken = GetToken.getSuiteToken(suite_id, suite_secret, suite_ticket);
		GetCorpTokenParam tokenParam = new GetCorpTokenParam();
		tokenParam.setSuite_access_token(suiteToken.getSuiteAccessToken());
		tokenParam.setSuite_id(suite_id);
		tokenParam.setPermanent_code(permanentCode);
		tokenParam.setAuth_corpid(cropId);
		corpToken = SuiteClient.getCorpToken(tokenParam);
	}

	/**
	 * Test method for {@link org.bana.wechat.qy.agent.AgentClient#get(org.bana.wechat.qy.agent.param.AgentGetParam)}.
	 */
	@Test
	public void testGet() {
		AgentGetParam getParam = new AgentGetParam();
		getParam.setAccess_token(corpToken.getAccessToken());
		getParam.setAgentId("132");
		
		AgentInfo agentInfo = AgentClient.get(getParam);
		assertNotNull(agentInfo);
		
	}

	/**
	 * Test method for {@link org.bana.wechat.qy.agent.AgentClient#set(org.bana.wechat.qy.agent.param.AgentSetParam)}.
	 * 测试设置企业号托管的应用信息
	 */
	@Test
	public void testSet() {
		AgentSetParam setParam = new AgentSetParam();
		setParam.setAccess_token(corpToken.getAccessToken());
		setParam.setAgentid("132");
		setParam.setDescription("");
//		setParam.setIsreportenter(isreportenter);
//		setParam.setIsreportuser(isreportuser);
//		setParam.setLogo_mediaid(logo_mediaid);
//		setParam.setName(name);
		setParam.setRedirect_domain("wechat.i3618.com.cn");
//		setParam.setReport_location_flag(report_location_flag);
//		setParam.setAgentId("132");
		AgentClient.set(setParam);
	}

	/**
	 * Test method for {@link org.bana.wechat.qy.agent.AgentClient#list(org.bana.wechat.qy.common.WeChatParam)}.
	 */
	@Test
	public void testList() {
		AccessToken accessToken = GetToken.getAccessToken(cropId, secret);
		WeChatParam listParam = new WeChatParam();
		listParam.setAccess_token(accessToken.getAccessToken());
		
		List<Agent> list = AgentClient.list(listParam);
		assertNotNull(list);
	}

}
