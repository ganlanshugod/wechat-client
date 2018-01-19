/**
* @Company 艾美伴行   
* @Title: Sku.java 
* @Package org.bana.wechat.mp.card.param.create 
* @author liuwenjie   
* @date 2016-6-15 上午10:52:36 
* @version V1.0   
*/ 
package org.bana.wechat.mp.card.param.create.baseinfo;

/** 
 * @ClassName: Sku 
 * @Description: 商品信息，在创建卡号时的字段
 *  
 */
public class Sku {

	private int quantity;//	是	int	100000	卡券库存的数量，上限为100000000。
	
	/** 
	 * <p>Description: </p> 
	 * @author liuwenjie   
	 * @date 2016-6-15 下午1:44:54  
	 */
	public Sku() {
	}

	/** 
	* <p>Description: </p> 
	* @author liuwenjie   
	* @date 2016-6-15 下午1:44:51 
	* @param quantity 
	*/ 
	public Sku(int quantity) {
		super();
		this.quantity = quantity;
	}

	/**
	 * @Description: 属性 quantity 的get方法 
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @Description: 属性 quantity 的set方法 
	 * @param quantity 
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	* Description: 
	* @author liuwenjie   
	* @date 2016-6-15 上午10:57:29 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "Sku [quantity=" + quantity + "]";
	}
	
}
