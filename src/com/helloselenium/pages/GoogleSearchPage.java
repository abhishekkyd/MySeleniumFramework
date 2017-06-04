package com.helloselenium.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.helloselenium.commons.Commands;
import com.helloselenium.commons.InitWebDriver;
import com.helloselenium.utils.PropertyFileReader;
import com.helloselenium.utils.WebElementGenerator;

public class GoogleSearchPage {

	static WebDriver driver = InitWebDriver.driver;

	public static void search(String keyword) {
		File objRepoFile = new File(
				"E:\\workspace\\SeleniumClass\\MySeleniumFramework\\resources\\objectRepository.properties");
		PropertyFileReader propObjRepoFile = new PropertyFileReader();
		String[] searchTextbox = propObjRepoFile.readPropertyFile(objRepoFile, "searchTextbox").split(";");
		String[] searchButton = propObjRepoFile.readPropertyFile(objRepoFile, "searchButton").split(";");

		WebElement searchTextboxInput = WebElementGenerator.findWebElementByLocator(searchTextbox[0], searchTextbox[1]);
		Commands.type(searchTextboxInput, keyword);

		WebElement searchButtonWe = WebElementGenerator.findWebElementByLocator(searchButton[0], searchButton[1]);
		Commands.click(searchButtonWe);
		
	}

}
