package org.bana.wechat.qy.suite.param;

import java.io.Serializable;

import org.bana.wechat.qy.common.WeChatSuiteParam;

public class MarkSuiteParam extends WeChatSuiteParam implements Serializable {

	private static final long serialVersionUID = -988806711868618645L;

	private String auth_corpid;//必填，调用接口凭证
	private String suite_id;//授权方企业id
	private String permanent_code;//永久授权码
	private boolean is_contact_suite; //否，设置为通讯录类型得授权，fase，设置为普通授权
	public String getAuth_corpid() {
		return auth_corpid;
	}
	public void setAuth_corpid(String auth_corpid) {
		this.auth_corpid = auth_corpid;
	}
	public String getSuite_id() {
		return suite_id;
	}
	public void setSuite_id(String suite_id) {
		this.suite_id = suite_id;
	}
	public boolean isIs_contact_suite() {
		return is_contact_suite;
	}
	public void setIs_contact_suite(boolean is_contact_suite) {
		this.is_contact_suite = is_contact_suite;
	}
	public String getPermanent_code() {
		return permanent_code;
	}
	public void setPermanent_code(String permanent_code) {
		this.permanent_code = permanent_code;
	}
	
}
