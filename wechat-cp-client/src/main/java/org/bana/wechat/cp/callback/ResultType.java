package org.bana.wechat.cp.callback;

import java.util.Arrays;

/**
 * @ClassName: ReulstType
 * @Description:返回值结果类型
 * 
 */
public enum ResultType {
	通讯录变更通知("contact_sync"), 
	企业微信通讯录变更通知("change_contact"),
	新增成员事件("create_user"),
	更新成员事件("update_user"),
	删除成员事件("delete_user"),
	推送suite_ticket协议("suite_ticket"), 
	变更授权的通知("change_auth"), 
	取消授权的通知("cancel_auth"), 
	触发的事件("event"), 
	推送授权回调("create_auth"), 
	普通消息("text", "image", "voice", "video", "shortvideo", "location", "link"), 
	成员关注("subscribe"),
	成员取消关注("unsubscribe"),
	不支持("");

	private String[] type;

	private ResultType(String... type) {
		this.type = type;
	}

	/**
	 * @Description: 属性 type 的get方法
	 * @return type
	 */
	public String[] getType() {
		return type;
	}

	public static ResultType getInstance(String type) {
		ResultType[] values = ResultType.values();
		for (ResultType resultType : values) {
			if (Arrays.asList(resultType.getType()).contains(type)) {
				return resultType;
			}
		}
		return ResultType.不支持;
	}

}