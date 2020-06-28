package org.bana.wechat.pay.common;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.github.wxpay.sdk.WXPayConfig;

public abstract class BaseWXPayConfig implements WXPayConfig{

    private byte[] certData;

    public BaseWXPayConfig()  {
    	
    }

    public InputStream getCertStream() {
    	if(certData == null) {
    		readDefaultCert();
    	}
        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }
    
    private void readDefaultCert() {
    	try {
			String certPath = "/cert/apiclient_cert.p12";
			InputStream certStream = BaseWXPayConfig.class.getResourceAsStream(certPath);
			this.certData = new byte[(int) certStream.available()];
			certStream.read(this.certData);
			certStream.close();
		} catch (IOException e) {
			throw new RuntimeException("no wxPay cert",e);
		}
    }

    public int getHttpConnectTimeoutMs() {
        return 8000;
    }

    public int getHttpReadTimeoutMs() {
        return 10000;
    }
}