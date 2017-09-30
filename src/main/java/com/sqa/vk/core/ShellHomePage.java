package com.sqa.vk.core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class ShellHomePage extends BasicPage {

	@FindBy(css = "#header li:nth-child(1) .media-links__link")
	private WebElement mediaLink1;

	@FindBy(css = "#header li:nth-child(2) .media-links__link")
	private WebElement mediaLink2;

	@FindBy(css = "#header li:nth-child(3) .media-links__link")
	private WebElement mediaLink3;

	@FindBy(css = "#header li:nth-child(4) .media-links__link")
	private WebElement mediaLink4;

	public ShellHomePage(BasicTest test) {
		super(test);
	}

	public void linkClick() {
		this.mediaLink1.click();
		takeScreenshot("Inside Energy stories");
		this.mediaLink2.click();
		takeScreenshot("Careers");
		this.mediaLink3.click();
		takeScreenshot("Media");
		this.mediaLink4.click();
		takeScreenshot("Investors");
	}
}
