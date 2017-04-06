package org.wanwanframework.file.spirit;

import java.util.logging.Logger;

@SuppressWarnings("unused")
public class SpiritLogController {

	private static final Logger logger = Logger.getLogger("" + SpiritLogController.class);

	private String className;

	private String word = "private static final Logger logger = Logger.getLogger(\"\" + @className.class);";

	private String getContent(String className, String word) {
		return word.replaceAll(className, word);
	}

	private boolean isHave(String word, String content) {
		if (content.indexOf(word) > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {

	}
}
