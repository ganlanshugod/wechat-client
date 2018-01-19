/**
* @Company 艾美伴行   
* @Title: CardMesseage.java 
* @Package org.bana.wechat.mp.message.param 
* @author liuwenjie   
* @date 2016-6-15 下午4:24:42 
* @version V1.0   
*/ 
package org.bana.wechat.mp.message.param;

/** 
 * @ClassName: CardMesseage 
 * @Description: 卡券消息的客服消息
 *  
 */
public class CardMesseage {

	private String card_id;//:"123dsdajkasd231jhksad",
    private String card_ext;// 通过cardExt对象转换的一个json串
	/**
	 * @Description: 属性 card_id 的get方法 
	 * @return card_id
	 */
	public String getCard_id() {
		return card_id;
	}
	/**
	 * @Description: 属性 card_id 的set方法 
	 * @param card_id 
	 */
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	/**
	 * @Description: 属性 card_ext 的get方法 
	 * @return card_ext
	 */
	public String getCard_ext() {
		return card_ext;
	}
	/**
	 * @Description: 属性 card_ext 的set方法 
	 * @param card_ext 
	 */
	public void setCard_ext(String card_ext) {
		this.card_ext = card_ext;
	}
	/**
	* Description: 
	* @author liuwenjie   
	* @date 2016-6-15 下午5:13:21 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "CardMesseage [card_id=" + card_id + ", card_ext=" + card_ext + "]";
	}
    
    
}
