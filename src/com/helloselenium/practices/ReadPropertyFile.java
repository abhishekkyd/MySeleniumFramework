package com.helloselenium.practices;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.helloselenium.utils.PropertyFileReader;

public class ReadPropertyFile {

	public static void main(String[] args) {
		
		try {
			File propFile = new File("E:\\workspace\\SeleniumClass\\MySeleniumFramework\\config\\config.properties");
			FileInputStream propFis = new FileInputStream(propFile);
			
			Properties prop = new Properties();
			prop.load(propFis);
			String browser = prop.getProperty("browser");
			System.out.println(browser);
			System.out.println(prop.getProperty("baseUrl"));
			prop.setProperty("name", "Abhishek");
			prop.setProperty("browser", "chrome");

			FileOutputStream propFos = new FileOutputStream(propFile);
			prop.store(propFos, "");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
