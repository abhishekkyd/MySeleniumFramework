package com.helloselenium.practices;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.helloselenium.commons.Commands;
import com.helloselenium.commons.InitWebDriver;
import com.helloselenium.pages.GoogleSearchPage;
import com.helloselenium.utils.TakeScreenshot;

public class ReadTextFile {

	public static void main(String[] args) throws IOException, InterruptedException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dt = new Date();
		PrintStream out = new PrintStream(
				new FileOutputStream("E:/workspace/SeleniumClass/MySeleniumFramework/logs/console.log"));
		System.setOut(out);

		InitWebDriver.initDriver();

		File txtFile = new File("E:/workspace/SeleniumClass/MySeleniumFramework/resources/questions.txt");
		FileReader fr = new FileReader(txtFile);
		BufferedReader br = new BufferedReader(fr);

		String s = null;
		while ((s = br.readLine()) != null) {
			String timestamp = "[" + sdf.format(dt.getTime()) + "] ";
			System.out.println(timestamp + "Searching in google for: " + s);
			GoogleSearchPage.search(s);
			Thread.sleep(2000);
			String fileName = s.replace(" ", "_").replace("?", "");
			TakeScreenshot
					.takeScreenshot("E:\\workspace\\SeleniumClass\\MySeleniumFramework\\screenshots\\" + fileName + ".jpg");

			Thread.sleep(2000);
		}

		Commands.quitDriver();

	}

}
