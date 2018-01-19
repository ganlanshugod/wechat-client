/**
 * @Company 青鸟软通   
 * @Title: PutOnCardParam.java 
 * @Package org.bana.wechat.mp.card.param 
 * @author Han Tongyang   
 * @date 2015-10-28 下午5:19:33 
 * @version V1.0   
 */
package org.bana.wechat.mp.card.param;

import java.io.Serializable;

/**
 * @ClassName: PutOnCardParam
 * @Description: 投放卡券参数
 * 
 */
public class PutOnCardParam implements Serializable {

	/**
	 * @Fields serialVersionUID :
	 */
	private static final long serialVersionUID = 8563868189669990229L;
	private CardParam card;

	/**
	 * @Description: 属性 card 的get方法
	 * @return card
	 */
	public CardParam getCard() {
		return card;
	}

	/**
	 * @Description: 属性 card 的set方法
	 * @param card
	 */
	public void setCard(CardParam card) {
		this.card = card;
	}

	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author Han Tongyang
	 * @date 2015-10-28 下午5:23:12
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PutOnCardParam [card=" + card + "]";
	}

}
