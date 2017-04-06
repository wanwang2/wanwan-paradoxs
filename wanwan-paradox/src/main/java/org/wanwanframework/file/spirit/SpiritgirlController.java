package org.wanwanframework.file.spirit;

import java.util.Map;

import org.wanwanframework.file.map.LineTool;

/**
 * 分发格式： file->path |content
 * 
 * fileList->list<file> 基础配置文件为路径配置文件，指定系统的起点 参数配置文件+模板配置文件为输入配置
 */
public class SpiritgirlController {

	private Map<String, String>[] configs;
	private Map<String, String> importParam;// 注入的参数、起最后修正参数的作用
	private Map<String, String> mapping;

	private String resourcePath;

	/**
	 * 初始化加载configs所有的配置路径指定的配置参数 resourcePath = "./src/main/resources/spirit";
	 */
	public SpiritgirlController() {
		resourcePath = this.getClass().getResource("/spirit").getPath();
		Map<String, String> url = LineTool.getLine(resourcePath + "/config.txt", LineTool.DEFAULT_SPLITOR);
		String configUrl = resourcePath + url.get("url");
		configs = LineTool.getConfigs(configUrl, LineTool.DEFAULT_SPLITOR);
		mapping = LineTool.getLine(resourcePath + "/mapping.txt", LineTool.DEFAULT_SPLITOR);
	}

	/**
	 * 按照配置数组进行循环
	 */
	public void init() {
		if (importParam == null) {
			SpiritgirlTool.readConfigs(configs, mapping);
		} else {
			SpiritgirlTool.readConfigs(configs, mapping, importParam);
		}
	}

	public Map<String, String>[] getConfigs() {
		return configs;
	}

	public void setConfigs(Map<String, String>[] configs) {
		this.configs = configs;
	}

	public Map<String, String> getImportParam() {
		return importParam;
	}

	public void setImportParam(Map<String, String> importParam) {
		this.importParam = importParam;
	}

	public static void main(String[] args) {
		SpiritgirlController controller = new SpiritgirlController();
		controller.init();
	}

}
