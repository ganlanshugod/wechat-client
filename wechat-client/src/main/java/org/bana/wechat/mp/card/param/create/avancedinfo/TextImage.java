/**
* @Company 艾美伴行   
* @Title: TextImage.java 
* @Package org.bana.wechat.mp.card.param.create.avancedinfo 
* @author liuwenjie   
* @date 2016-6-15 下午3:06:43 
* @version V1.0   
*/ 
package org.bana.wechat.mp.card.param.create.avancedinfo;

/** 
 * @ClassName: TextImage 
 * @Description: 
 *  
 */
public class TextImage {

	private String image_url;//	图片链接，必须调用上传图片接口上传图片获得链接，并在此填入，否则报错	是
	private String text;//	图文描述，5000字以内	是
	/**
	 * @Description: 属性 image_url 的get方法 
	 * @return image_url
	 */
	public String getImage_url() {
		return image_url;
	}
	/**
	 * @Description: 属性 image_url 的set方法 
	 * @param image_url 
	 */
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	/**
	 * @Description: 属性 text 的get方法 
	 * @return text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @Description: 属性 text 的set方法 
	 * @param text 
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	* Description: 
	* @author liuwenjie   
	* @date 2016-6-15 下午3:10:00 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "TextImage [image_url=" + image_url + ", text=" + text + "]";
	}
	
}
