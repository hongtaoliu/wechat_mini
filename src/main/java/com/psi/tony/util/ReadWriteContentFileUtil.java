package com.psi.tony.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriteContentFileUtil {

	public static String sotrePath = "/Users/sunny/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ROOT/sihai/notification/notification.json";

	public static String getJsonContent() {
		String str = "";
		File file = new File(sotrePath);
		if (file.exists()) {
			BufferedReader reader = null;
			try {
				System.out.println("以行为单位读取文件内容，一次读一整行：");
				reader = new BufferedReader(new FileReader(file));
				String tempString = null;
				while ((tempString = reader.readLine()) != null) {
					str = tempString;
					break;
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException e1) {
					}
				}
			}
		}
		return str;
	}

	public static void setJsonContent(String content) {
		FileWriter fileWriter = null;
		try {
			File file = new File(sotrePath);
			if (!file.exists()) {
				file.createNewFile();
			}
			fileWriter = new FileWriter(file);
			fileWriter.write(content);
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e1) {
				}
			}
		}
	}
}
