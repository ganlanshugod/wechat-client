package org.bana.wechat.pay.common;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.github.wxpay.sdk.WXPayConfig;

public abstract class BaseWXPayConfig implements WXPayConfig{

    private byte[] certData;

    public BaseWXPayConfig() throws Exception {
        String certPath = "/cert/apiclient_cert.p12";
        File file = new File(BaseWXPayConfig.class.getResource(certPath).getFile());
        InputStream certStream = new FileInputStream(file);
        this.certData = new byte[(int) file.length()];
        certStream.read(this.certData);
        certStream.close();
    }

    public InputStream getCertStream() {
        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }

    public int getHttpConnectTimeoutMs() {
        return 8000;
    }

    public int getHttpReadTimeoutMs() {
        return 10000;
    }
}