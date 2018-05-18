package org.bana.wechat.mp.media;

import static org.junit.Assert.*;

import java.io.File;

import org.bana.wechat.mp.BaseMpTest;
import org.bana.wechat.mp.media.impl.MediaMpServiceImpl;
import org.bana.wechat.mp.media.param.WechatMpUploadParam;
import org.bana.wechat.mp.media.result.MediaUploadResult;
import org.junit.Before;
import org.junit.Test;

public class MediaMpServiceTest extends BaseMpTest{

	private MediaMpService mediaMpService;
	
	@Before
	public void init(){
		MediaMpServiceImpl impl = new MediaMpServiceImpl();
		impl.setAccessTokenService(tokenService);
		this.mediaMpService = impl;
	}
	
	@Test
	public void testUpload() {
		String filePath = "D:/0.png";
		WechatMpUploadParam uploadParam = new WechatMpUploadParam();
		uploadParam.setAppId(appId);
		uploadParam.setType(UploadType.图片);
		uploadParam.setFile(new File(filePath));
		MediaUploadResult upload = mediaMpService.upload(uploadParam);
		assertNotNull(upload);
		System.out.println(upload);
	}

}
