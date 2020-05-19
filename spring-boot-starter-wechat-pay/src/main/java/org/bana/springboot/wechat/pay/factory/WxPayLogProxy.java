/**
* @Company 全域旅游
* @Title: WxPayProxy.java 
* @Package org.bana.springboot.wechat.pay.factory 
* @author liuwenjie   
* @date May 19, 2020 3:15:55 PM 
* @version V1.0   
*/ 
package org.bana.springboot.wechat.pay.factory;

import java.lang.reflect.Method;

import org.apache.http.entity.StringEntity;
import org.bana.wechat.common.log.WechatLogDomain;
import org.bana.wechat.common.log.WechatLogger;
import org.bana.wechat.common.log.WechatLoggerFactory;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import com.alibaba.fastjson.JSON;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConfig;

/** 
* @ClassName: WxPayProxy 
* @Description: 微信pay的Log代理类
* @author liuwenjie   
*/
public class WxPayLogProxy implements MethodInterceptor {
	private Object target;
	
	private static WechatLogger LOG;
	
	public static final String HTTP_GET = "get";
	public static final String HTTP_POST = "post";
	/**
	* <p>Description: </p> 
	* @author liuwenjie   
	* @date May 19, 2020 3:17:16 PM 
	* @param obj
	* @param method
	* @param arr
	* @param proxy
	* @return
	* @throws Throwable 
	* @see org.springframework.cglib.proxy.MethodInterceptor#intercept(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], org.springframework.cglib.proxy.MethodProxy) 
	*/ 
	@Override
	public Object intercept(Object obj, Method method, Object[] arr, MethodProxy proxy) throws Throwable {
		try {
			WechatLogDomain domain = getLOG().getWechatLogDomain();
			// 记录开始信息内容
			String params = JSON.toJSONString(arr);
			getLOG().logBegin(method.getName(), params,HTTP_POST);
//			System.out.println("Cglib动态代理，监听开始！" + method.getName());
			Object invoke = method.invoke(target, arr);//方法执行，参数：target 目标对象 arr参数数组
//			System.out.println("Cglib动态代理，监听结束！" + invoke);
			domain.setWechatResult(JSON.toJSONString(invoke));
			return invoke;
		} catch (RuntimeException e) {
			getLOG().logException(e);
			throw e;
		} finally {
			getLOG().logEnd();
			getLOG().saveLog();
		}
	}
	
	//定义获取代理对象方法
    public static WXPay getWxPayProxy(WXPay wxPay ,WXPayConfig payConfig){
        Enhancer enhancer = new Enhancer();
        //设置父类,因为Cglib是针对指定的类生成一个子类，所以需要指定父类
        enhancer.setSuperclass(WXPay.class);
        WxPayLogProxy proxy = new WxPayLogProxy();
        proxy.setTarget(wxPay);
        enhancer.setCallback(proxy);// 设置回调 
        WXPay result = (WXPay)enhancer.create(new Class[] {WXPayConfig.class},new Object[] {payConfig});//创建并返回代理对象
        return result;
    }

	public void setTarget(Object target) {
		this.target = target;
	}
	
	public static WechatLogger getLOG() {
		if(LOG == null) {
			LOG = WechatLoggerFactory.getWechatLogger();
		}
		return LOG;
	}

}
