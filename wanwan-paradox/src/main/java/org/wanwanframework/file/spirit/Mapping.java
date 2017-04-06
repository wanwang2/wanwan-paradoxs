package org.wanwanframework.file.spirit;

import java.io.IOException;

import org.wanwanframwork.file.FileUtil;

public class Mapping {

	/**
	 * 指令调用
	 * @param method
	 * @param value
	 */
	public static void call(String method, String value) {
		if(method.indexOf("makeFile") >= 0) {
			try {
				FileUtil.makeFile(value);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if(method.indexOf("makeFolder") >= 0) {
			FileUtil.makeFolder(value);
		}
	}
}
