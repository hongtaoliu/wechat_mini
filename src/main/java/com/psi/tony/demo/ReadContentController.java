package com.psi.tony.demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psi.tony.domain.WechatContent;
import com.psi.tony.util.WechatContentProcessor;

@RestController
public class ReadContentController {

	@GetMapping("/api/wechat/contents")
	public List<WechatContent> getWechatContent() {
		WechatContentProcessor wechatContentProcessor = WechatContentProcessor.getInsance();
		return wechatContentProcessor.getContents();
	}

}
