package com.sqa.vk.sap;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import com.sqa.vk.core.*;

public class SapHomePage extends BasicPage {

	@FindBy(xpath = ".//*[@id='main']/div[2]/div[4]/div[2]/section/div/div[2]/div/div/div/div[1]/div[1]/div/a/img")
	private WebElement solution1;

	@FindBy(xpath = ".//*[@id='main']/div[2]/div[4]/div[2]/section/div/div[2]/div/div/div/div[1]/div[2]/div/a/img")
	private WebElement solution2;

	@FindBy(xpath = ".//*[@id='main']/div[2]/div[4]/div[2]/section/div/div[2]/div/div/div/div[2]/div[1]/div/a/img")
	private WebElement solution3;

	@FindBy(xpath = ".//*[@id='main']/div[2]/div[4]/div[2]/section/div/div[2]/div/div/div/div[2]/div[2]/div/a/img")
	private WebElement solution4;

	// private WebDriverWait wait = new WebDriverWait(this.driver, 30);
	public SapHomePage(BasicTest test) {
		super(test);
	}

	// method to navigate back to the home page www.sap.home
	public void navigateHome() {
		this.driver.get(getBaseUrl());
	}

	public void selectFeature() {
		this.solution1.click();
		takeScreenshot("DigitalBusiness");
		this.navigateHome();
		this.solution2.click();
		takeScreenshot("InternetOfThings");
		this.navigateHome();
		this.solution3.click();
		takeScreenshot("MachineLearning");
		this.navigateHome();
		this.solution4.click();
		takeScreenshot("SmallAndMidsizeEnterprises");
		this.navigateHome();
	}
}
