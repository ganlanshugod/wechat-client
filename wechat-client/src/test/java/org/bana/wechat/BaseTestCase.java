/**
* @Company 青鸟软通   
* @Title: BaseTestCase.java 
* @Package org.bana.wechat 
* @author Liu Wenjie   
* @date 2015-5-9 下午3:56:54 
* @version V1.0   
*/ 
package org.bana.wechat;

import java.util.UUID;

/** 
 * @ClassName: BaseTestCase 
 * @Description: 基础测试类
 *  
 */
public class BaseTestCase {
	
	/** 
	* @Fields cropId : 全局的cropId 
	*/ 
	protected String cropId = "wxc2a104d974df2b69";
	
	/** 
	* @Fields secret : 全局的测试管理秘钥
	*/ 
	protected String secret = "vbeHcEQmOfhc5jqAuMORiQmL_XZxKsxlcE9cue3M-UtPcY3d-YFQChyHXBigXSSl";
	
	//通讯录应用的accessToken

	protected String accessToken = "Eys1rALrD-29OZEgWEVSt6dB40zDDQMAAQ0FZATjJyLBfJAS_Rfx88miRI9o1COxRELyPbWFNw3FKUSBYiIeAzGcgBIMZ-W77ZHTnmVvZW5rsOL-RLH0jEZmZmueqgOewsgia6LJsTJ34kY8XrcpDlY_j69zq0L0_oXobp6TYDvY5wtQQnaMxqx2ad367IQihz6IqpS_1Y9RUfxIa6WHR-zKcxuRvbBNGl--gQjHhskI6qtKRAEGXIMYkY5yoBH8mXUJ2SIa0-e8WEXr1EtQwTVmRiORRThwOV5m5tRL_N0";
	
	//模拟的信息只读的客服应用
//	protected String accessToken = "xS0a-I456NC2P4wdp5JKYTGx-VqKZCKBc3BUJFBezHL1b1kzZ7-9QkuKKwgH8Oaq";

	/** 
	* @Fields suite_id : 套件ID
	*/ 
	protected String suite_id = "tj46d5dffebef1ce32";
	
	/** 
	* @Fields suite_secret : 套件secret
	*/ 
	protected String suite_secret = "SaOJJdO0IE-7abD8BcvOH9F2dgisnYSATr9_tJsqXP2wc05iq9JT4R1AbzVFnb89";

	
	/** 
	* @Fields suite_ticket : 微信推送的token信息,每十分钟更新，可以通过 
	* http://manager.i3618.com.cn/wechat/suite/show?suiteId=tj06154271e7f5928e
	* 获取
	*/ 
	protected String suite_ticket = "prDViPc_TfIFcJbk9sAFPll70w5hSNwKlc5XvChOxXTqm1agUfXrmEQM0pUIrQ-I";


	protected String permanentCode = "reKwa9u5C88984lN1RI8EyBv-Scl_T0NGNyeQD8JUWzDpAdHMJfPYxwz-onrFu2w";
	
	protected String suiteAccessToken = "X2u1a4IvqHu_64J2pWZNbAZuH2N_Hm4_rY1tVcC_1h85v9_GrO58IC2CHRcE0dnm";
}
