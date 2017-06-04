package com.helloselenium.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Commands {
	
	static WebDriver driver = InitWebDriver.driver;

	public static void open(String url) {
		driver.get(url);
	}

	public static void navigateBrowser(String url) {
		driver.navigate().to(url);
	}

	public static void type(WebElement we, String value) {
		if (we.isDisplayed()) {
			if (we.isEnabled()) {
				we.clear();
				we.sendKeys(value);
			} else {
				System.out.println("Element is not enabled.");
			}
		} else {
			System.out.println("Element is not displayed.");
		}
	}

	public static void click(WebElement we) {
		if (we.isDisplayed()) {
			if (we.isEnabled()) {
				we.click();
			} else {
				System.out.println("Element is not enabled.");
			}
		} else {
			System.out.println("Element is not displayed.");
		}
	}

	public static void closeBrowser(){
		driver.close();
	}

	public static void quitDriver(){
		driver.quit();
	}

}
