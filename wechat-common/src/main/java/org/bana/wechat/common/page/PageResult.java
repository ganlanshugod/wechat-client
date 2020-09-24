/**
* @Company 全域旅游
* @Title: PageResult.java 
* @Package org.bana.wechat.common.page 
* @author liuwenjie   
* @date Sep 23, 2020 12:19:13 PM 
* @version V1.0   
*/ 
package org.bana.wechat.common.page;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/** 
* @ClassName: PageResult 
* @Description: 微信的分页列表对象
* @author liuwenjie   
*/
public class PageResult<T> {

	@JSONField(name="total_count")
	private long totalCount;
	
	private List<T> list;

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "PageResult [totalCount=" + totalCount + ", list=" + list + "]";
	}
	
}
