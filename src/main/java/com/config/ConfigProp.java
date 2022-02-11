package com.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigProp {
	
	public static Properties prop;
	
	private ConfigProp() {		
		
	}
	
	public String getConfigProperty(String configKey) {
		return prop.getProperty(configKey);
	}
	
	public static Properties getConfig() {
		if(prop==null) {
			try {
				prop = new Properties();
				FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "/properties/application.properties");			
				prop.load(fis);				
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}catch(Exception oExp) {
				oExp.printStackTrace();
			}
		}
		return prop;
	}
}
