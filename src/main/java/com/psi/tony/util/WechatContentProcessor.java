package com.psi.tony.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.psi.tony.domain.WechatContent;

public class WechatContentProcessor {

	public static WechatContentProcessor wechatContentProcessor;

	private WechatContentProcessor() {
		ObjectMapper mapper = new ObjectMapper();
		String json = ReadWriteContentFileUtil.getJsonContent();
		List<WechatContent> list = null;
		try {
			list = mapper.readValue(json, new TypeReference<List<WechatContent>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (list != null) {
			for (WechatContent wc : list) {
				contents.add(wc);
			}
		}
	}

	public static synchronized WechatContentProcessor getInsance() {

		if (wechatContentProcessor == null) {
			wechatContentProcessor = new WechatContentProcessor();
		}
		return wechatContentProcessor;

	}

	private List<WechatContent> contents = new ArrayList<WechatContent>();

	public List<WechatContent> getContents() {
		return contents;
	}

	public void setContents(List<WechatContent> contents) {
		this.contents = contents;
	}

	public List<WechatContent> addContent(WechatContent wechatContent) {
		this.contents.add(wechatContent);

		ObjectMapper mapper = new ObjectMapper();
		try {
			String strJson = mapper.writeValueAsString(contents);
			ReadWriteContentFileUtil.setJsonContent(strJson);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return contents;
	}

	public List<WechatContent> deleteContent(String date) {

		List<WechatContent> tmp = new ArrayList<WechatContent>();
		for (WechatContent wc : contents) {
			if (!wc.getDate().equals(date)) {
				tmp.add(wc);
			}
		}
		contents = tmp;

		ObjectMapper mapper = new ObjectMapper();
		try {
			String strJson = mapper.writeValueAsString(contents);
			ReadWriteContentFileUtil.setJsonContent(strJson);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return contents;
	}

}
