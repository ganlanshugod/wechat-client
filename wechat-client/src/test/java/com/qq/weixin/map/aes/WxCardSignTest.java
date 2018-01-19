package com.qq.weixin.map.aes;

import com.qq.weixin.mp.aes.WxCardSign;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Administrator
 */
public class WxCardSignTest {
	public static void main(String[] args) throws Exception {
		String code = "jonyqin_1434008071";
		int timestamp = 1404896688;
		String card_id = "pjZ8Yt1XGILfi-FUsewpnnolGgZk";
		String api_ticket = "ojZ8YtyVyr30HheH3CM73y7h4jJE ";
		String nonce_str = "jonyqin";
		WxCardSign signer = new WxCardSign();
		signer.AddData(timestamp);
		signer.AddData(card_id);
		signer.AddData(api_ticket);
		signer.AddData(code);
		signer.AddData(nonce_str);
		System.out.println(signer.GetSignature());
		//期望的
		// 1404896688jonyqinjonyqin_1434008071ojZ8YtyVyr30HheH3CM73y7h4jJE pjZ8Yt1XGILfi-FUsewpnnolGgZk
		// 6b81fbf6af16e856334153b39737556063c82689
		//实际的
		// 1404896688jonyqinjonyqin_1434008071ojZ8YtyVyr30HheH3CM73y7h4jJE pjZ8Yt1XGILfi-FUsewpnnolGgZk
		// 2b4d29b5f60fa4be37522ddfd9583c329446d3e3
	}

}