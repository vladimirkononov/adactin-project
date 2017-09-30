package com.sqa.vk.helpers;

import java.io.*;
import java.util.*;

import org.apache.commons.io.*;
import org.apache.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;

public class AutoBasics {

	public static List<WebElement> getByTagName(WebDriver driver, String tagName) {
		return null;
	}

	public static List<WebElement> getCSSPropBasedElements(WebDriver driver, By locator, String prop, String value) {
		List<WebElement> elements = driver.findElements(locator);
		ArrayList<WebElement> filteredElements = new ArrayList<WebElement>();
		for (int i = 0; i < elements.size(); i++) {
			if (elements.get(i).getCssValue(prop).equalsIgnoreCase(value)) {
				filteredElements.add(elements.get(i));
			}
		}
		return filteredElements;
	}

	public static List<WebElement> getLinks(WebDriver driver) {
		return null;
	}

	public static List<WebElement> getPictures(WebDriver driver) {
		List<WebElement> elements = driver.findElements(By.tagName("img"));
		return elements;
	}

	public static String getProp(String propName, String fileLocation, String fileName, Logger logger) {
		Properties props = new Properties();
		InputStream input;
		try {
			input = new FileInputStream(fileLocation + fileName);
			props.load(input);
		} catch (FileNotFoundException e) {
			logger.warn("Can not load config properties file because it was not found: " + fileName);
		} catch (IOException e) {
			logger.warn("Can not load config properties file can not be read: " + fileName);
		}
		return props.getProperty(propName);
	}

	public static List<String> getTextContents(WebDriver driver, By locator) {
		return null;
	}

	public static boolean isElementPresent(WebDriver driver, By by, Logger logger) {
		try {
			WebElement element = driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			logger.warn("Element was not found: " + by);
			return false;
		}
	}

	public static void logImportantImages(WebDriver driver, Logger logger) {
		List<WebElement> images = AutoBasics.getPictures(driver);
		for (int i = 0, j = 1; i < images.size(); i++) {
			if (!images.get(i).getAttribute("alt").equalsIgnoreCase("")) {
				logger.info("#" + (j) + ": [" + images.get(i).getAttribute("alt") + "] SRC="
						+ images.get(i).getAttribute("src"));
				j++;
			}
		}
	}

	public static boolean takeScreenshot(String fileLocation, String fileName, WebDriver driver, Logger logger) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(fileLocation + "/" + fileName + ".png"));
			return true;
		} catch (IOException e) {
			logger.warn("Screenshot " + fileName + " was not captured to disk correctly.");
			return false;
		}
	}
}
