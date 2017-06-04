package com.helloselenium.commons;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.helloselenium.utils.PropertyFileReader;

public class InitWebDriver {

	public static WebDriver driver = null;

	public static WebDriver initDriver() {

		File configFile = new File("E:\\workspace\\SeleniumClass\\MySeleniumFramework\\config\\config.properties");

		PropertyFileReader propFile = new PropertyFileReader();
		String browser = propFile.readPropertyFile(configFile, "browser");
		String baseUrl = propFile.readPropertyFile(configFile, "baseUrl");

		if (browser.equalsIgnoreCase("firefox")) {
			System.out.println("Tests are running on Firefox browser:");
			System.setProperty("webdriver.gecko.driver",
					"E:\\workspace\\SeleniumClass\\MySeleniumFramework\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.out.println("Tests are running on Chrome browser:");
			System.setProperty("webdriver.chrome.driver",
					"E:\\workspace\\SeleniumClass\\MySeleniumFramework\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			System.out.println("Tests are running on IE browser:");
			System.setProperty("webdriver.ie.driver",
					"E:\\workspace\\SeleniumClass\\MySeleniumFramework\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			System.out.println(browser + " is not a valid browser name!!");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		
		Commands.open(baseUrl);
		
		return driver;
	}
}
