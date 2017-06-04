package com.helloselenium.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExcelTest {

	public static void main(String[] args) {
		try {

			FileInputStream file = new FileInputStream(
					new File("E:\\workspace\\MySeleniumFramework\\testdata\\testdata1.xls"));
			HSSFWorkbook workbook = new HSSFWorkbook(file);

			HSSFSheet sheet = workbook.getSheet("Search");

			System.setProperty("webdriver.gecko.driver", "E:\\workspace\\MySeleniumProject\\drivers\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();

			driver.manage().window().maximize();
			driver.get("http://www.google.com");

			WebElement searchtbox = driver.findElement(By.name("q"));

			for (int i = 0; i <= sheet.getLastRowNum(); i++) {
				for (int j = 0; j <= 0; j++) {
					HSSFCell cell = sheet.getRow(i).getCell(j);
					if (cell.getCellTypeEnum() == CellType.STRING) {
						String keyword = cell.getStringCellValue();
						System.out.println(cell.getStringCellValue());

						searchtbox.clear();
						searchtbox.sendKeys(keyword);

						driver.findElement(By.name("btnG")).click();

						new WebDriverWait(driver, 60)
								.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultStats")));
						
						System.out.println(driver.findElement(By.id("resultStats")).getText());

						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					} else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
						System.out.println(cell.getNumericCellValue());
					}
				}
			}

			workbook.close();
			file.close();

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}