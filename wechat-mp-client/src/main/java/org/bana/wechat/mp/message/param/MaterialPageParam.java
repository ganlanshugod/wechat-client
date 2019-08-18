/**
* @Company Elink   
* @Title: MaterialPageParam.java 
* @Package org.bana.wechat.mp.message.param 
* @author zhangzhichao   
* @date Aug 18, 2019 1:49:57 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.message.param;

import org.bana.wechat.mp.common.WeChatMpParam;

/** 
* @ClassName: MaterialPageParam 
* @Description: 素材列表参数 
* @author zhangzhichao   
*/
public class MaterialPageParam extends WeChatMpParam {

	private static final long serialVersionUID = 4414586511417818433L;
	
	private String type; //素材的类型，图片（image）、视频（video）、语音 （voice）、图文（news）
	private Integer offset; //从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
	private Integer count; //返回素材的数量，取值在1到20之间
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "MaterialPageParam [type=" + type + ", offset=" + offset + ", count=" + count + "]";
	}
}
