package com.helloselenium.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.helloselenium.commons.InitWebDriver;

public class TakeScreenshot {

	static WebDriver driver = InitWebDriver.driver;
	
	public static void takeScreenshot (String filename){
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File outFile = new File(filename);
		try {
			FileUtils.copyFile(scrFile, outFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
