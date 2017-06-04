package com.helloselenium.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TextFileReader {

	public static BufferedReader readTextFile(File textFile) {
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(textFile);
			br = new BufferedReader(fr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return br;
	}

}
