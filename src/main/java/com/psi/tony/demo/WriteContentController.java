package com.psi.tony.demo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.psi.tony.domain.WechatContent;
import com.psi.tony.util.WechatContentProcessor;

@RestController
public class WriteContentController {

	@PostMapping("/api/wechat/contents")
	public List<WechatContent> getWechatContent(@RequestBody WechatContent wechatContent) {
		WechatContentProcessor wechatContentProcessor = WechatContentProcessor.getInsance();
		wechatContentProcessor.addContent(wechatContent);
		return wechatContentProcessor.getContents();
	}

	@DeleteMapping("/api/wechat/contents/{date}")
	public List<WechatContent> deleteWechatContent(@PathVariable("date") String date) {
		WechatContentProcessor wechatContentProcessor = WechatContentProcessor.getInsance();
		wechatContentProcessor.deleteContent(date);
		return wechatContentProcessor.getContents();
	}

}
