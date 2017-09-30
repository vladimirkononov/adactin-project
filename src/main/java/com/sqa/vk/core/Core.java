package com.sqa.vk.core;

import org.apache.log4j.*;
import org.openqa.selenium.*;

import com.sqa.vk.helpers.*;

public class Core {

	private static int count = 1;

	private String baseUrl;

	protected WebDriver driver;

	private BasicTest curTest;

	private Logger log = Logger.getLogger(this.getClass());

	public Core(BasicTest test) {
		this.curTest = test;
		this.baseUrl = test.getBaseUrl();
		this.driver = test.getDriver();
	}

	/**
	 * @param baseUrl
	 */
	public Core(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public Core(String baseUrl, WebDriver driver) {
		super();
		this.baseUrl = baseUrl;
		this.driver = driver;
	}

	public String getBaseUrl() {
		return this.baseUrl;
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public Logger getLog() {
		return this.log;
	}

	public String getProp(String propName) {
		return AutoBasics.getProp(propName, "src/main/resources/", "config.properties", getLog());
	}

	public boolean isElementPresent(By locator) {
		return false;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void takeScreenshot() {
		AutoBasics.takeScreenshot("screenshots/", "AutoTest" + count, getDriver(), this.getLog());
		count++;
	}

	public void takeScreenshot(String name) {
		AutoBasics.takeScreenshot("screenshots/", name, getDriver(), this.getLog());
	}
}
