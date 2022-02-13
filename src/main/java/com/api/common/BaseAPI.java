package com.api.common;

import java.util.Map;
import java.util.Properties;

import com.config.ConfigProp;
import com.utils.ReadTokensFromFile;

public class BaseAPI {
	Map<String, String> tokens;
	public static Properties prop;
	
	public BaseAPI() {
		prop = ConfigProp.getConfig();
		tokens = ReadTokensFromFile.getTokens();		
	}
}
