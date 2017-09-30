package com.sqa.vk.adactin;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.*;
import org.testng.annotations.*;

import com.sqa.vk.core.*;

// import junit.framework.*;
public class TC101 extends AdactinTest {

	@Test(enabled = true)
	public void negativeCheckin() throws InterruptedException {
		AdactinHomePage homePage = new AdactinHomePage(this);
		homePage.login(this.getProp("username"), this.getProp("password"));
		Select city = new Select(this.driver.findElement(By.id("location")));
		city.selectByVisibleText("Sydney");
		takeScreenshot("CitySelect");
	}

	@Test(enabled = true)
	public void testLogin() throws InterruptedException {
		AdactinHomePage homePage = new AdactinHomePage(this);
		homePage.login(this.getProp("username"), this.getProp("password"));
		Assert.assertTrue(this.driver.getTitle().contains("AdactIn.com - Search Hotel"));
	}
}
