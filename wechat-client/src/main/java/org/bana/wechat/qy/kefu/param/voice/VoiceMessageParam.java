/**
* @Company 青鸟软通   
* @Title: VoiceMessageParam.java 
* @Package org.bana.wechat.qy.message.param.voice 
* @author Liu Wenjie   
* @date 2015-5-27 下午9:23:14 
* @version V1.0   
*/ 
package org.bana.wechat.qy.kefu.param.voice;

import org.bana.wechat.cp.common.Constants;
import org.bana.wechat.qy.kefu.param.KefuParam;
import org.bana.wechat.qy.message.param.voice.VoiceMessage;

/** 
 * @ClassName: VoiceMessageParam 
 * @Description: voice消息
 *  
 */
public class VoiceMessageParam extends KefuParam {
	private VoiceMessage voice;

	
	/** 
	 * <p>Description: </p> 
	 * @author Liu Wenjie   
	 * @date 2015-5-27 下午9:43:54  
	 */
	public VoiceMessageParam() {
		setMsgtype(Constants.voice消息.getValue());
	}
	/**
	 * @Description: 属性 voice 的get方法 
	 * @return voice
	 */
	public VoiceMessage getVoice() {
		return voice;
	}

	/**
	 * @Description: 属性 voice 的set方法 
	 * @param voice 
	 */
	public void setVoice(VoiceMessage voice) {
		this.voice = voice;
	}

	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-27 下午9:24:20 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "VoiceMessageParam [voice=" + voice + ", sender=" + sender + ", receiver=" + receiver +
				", msgtype=" + ", access_token=" + access_token +  "]";
	}
	
}
