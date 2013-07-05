package com.hicomb.bmc.bladelogic.rest.configure;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * Properties类
 */
public class RestPorperties {
	private static final Log logger = LogFactory.getLog(RestPorperties.class);
	private static RestPorperties instance;
	private static Properties configProperties = new Properties();
	private static Properties allProperties = new Properties();
	
	/**
	 * The prefix used by all properties.
	 */
	public static final String PROPERTY_PREFIX = "com.hicomb.bmc.";
	
	private static boolean needReload = true;

	private RestPorperties() {
	}

	/**
	 * 获取实例
	 * @return
	 */
	public static RestPorperties getInstance() {
		if (instance == null) {
			instance = new RestPorperties();
		} if(needReload){
			loadConfig();
		}
		return instance;
	}

	
	@SuppressWarnings("rawtypes")
	private static void loadConfig() {
		try {
			//载入Properties文件
			configProperties.load(RestPorperties.class.getResourceAsStream("bmc-bladelogic-rest.properties"));
		} catch (IOException e) {
			logger.error("未找到bmcbladelogic-rest.properties");
		}
		for (Map.Entry e : configProperties.entrySet()) {
			allProperties.put(e.getKey(), e.getValue());
		}
		needReload = false;
	}


	public String getConfigProperty(String prop) {
		return allProperties.getProperty(prop);
	}

	public String getConfigProperty(String prop, String defaultValue) {
		return allProperties.getProperty(prop, defaultValue);
	}
}