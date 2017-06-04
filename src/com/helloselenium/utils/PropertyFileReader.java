package com.helloselenium.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

	public String readPropertyFile(File configFile, String property) {
		String propertyValue = "";
		try {
			FileInputStream fis = new FileInputStream(configFile);
			Properties prop = new Properties();
			prop.load(fis);
			propertyValue = prop.getProperty(property);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return propertyValue;
	}

}
