/**
* @Company 青鸟软通   
* @Title: FileMessageParam.java 
* @Package org.bana.wechat.qy.message.param.file 
* @author Liu Wenjie   
* @date 2015-5-27 下午9:27:18 
* @version V1.0   
*/ 
package org.bana.wechat.cp.message.param.file;

import org.bana.wechat.cp.common.Constants;
import org.bana.wechat.cp.message.param.MessageParam;



/** 
 * @ClassName: FileMessageParam 
 * @Description: file消息
 *  
 */
public class FileMessageParam extends MessageParam {

	private static final long serialVersionUID = 7308130039543425531L;
	
	private FileMessage file;

	/** 
	 * <p>Description: </p> 
	 * @author Liu Wenjie   
	 * @date 2015-5-27 下午9:40:33  
	 */
	public FileMessageParam() {
		setMsgtype(Constants.file消息.getValue());
	}
	
	/**
	 * @Description: 属性 file 的get方法 
	 * @return file
	 */
	public FileMessage getFile() {
		return file;
	}


	/**
	 * @Description: 属性 file 的set方法 
	 * @param file 
	 */
	public void setFile(FileMessage file) {
		this.file = file;
	}



	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-27 下午9:28:31 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "FileMessageParam [file=" + file + ", touser=" + touser + ", toparty=" + toparty + ", totag=" + totag + ", msgtype=" + msgtype + ", agentid=" + agentid + ", safe="
				+ safe + "]";
	}
	
	
	
}
