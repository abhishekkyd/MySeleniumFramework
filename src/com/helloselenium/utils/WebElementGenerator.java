package com.helloselenium.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.helloselenium.commons.InitWebDriver;

public class WebElementGenerator {

	static WebDriver driver = InitWebDriver.driver;

	static WebElement we = null;

	public static WebElement findWebElementByLocator(String locatorType, String locatorValue) {
		if (locatorType.equalsIgnoreCase("id")) {
			we = driver.findElement(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("name")) {
			we = driver.findElement(By.name(locatorValue));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			we = driver.findElement(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("css")) {
			we = driver.findElement(By.cssSelector(locatorValue));
		}
		return we;
	}

}
