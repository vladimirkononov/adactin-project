package com.sqa.vk;

import java.util.concurrent.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.*;
import org.testng.*;
import org.testng.annotations.*;

public class AdactinTests {

	private WebDriver driver;

	private String baseUrl;

	@BeforeClass
	public void SetUp() throws Exception {
		this.driver = new FirefoxDriver();
		this.baseUrl = "http://adactin.com/HotelApp/index.php";
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass
	public void tearDown() throws Exception {
		this.driver.quit();
	}

	@Test
	public void Test101() throws Exception {
		this.driver.get(this.baseUrl);
		this.driver.findElement(By.id("username")).clear();
		this.driver.findElement(By.id("username")).sendKeys("vkononov");
		this.driver.findElement(By.id("password")).clear();
		this.driver.findElement(By.id("password")).sendKeys("password1");
		this.driver.findElement(By.id("login")).click();
		Assert.assertEquals(this.driver.getTitle(), "AdactIn.com - Search Hotel");
	}

	@Test
	public void Test102() throws Exception {
		this.driver.get(this.baseUrl);
		this.driver.findElement(By.id("username")).clear();
		this.driver.findElement(By.id("username")).sendKeys("vkononov");
		this.driver.findElement(By.id("password")).clear();
		this.driver.findElement(By.id("password")).sendKeys("password1");
		this.driver.findElement(By.id("login")).click();
		Select selectorLocation = new Select(this.driver.findElement(By.id("location")));
		selectorLocation.selectByVisibleText("Sydney");
		Select selectorHotels = new Select(this.driver.findElement(By.id("hotels")));
		selectorHotels.selectByVisibleText("Hotel Creek");
		Select selectorRoomType = new Select(this.driver.findElement(By.id("room_type")));
		selectorRoomType.selectByVisibleText("Deluxe");
		Select selectorNumRooms = new Select(this.driver.findElement(By.id("room_nos")));
		selectorNumRooms.selectByValue("2");
		this.driver.findElement(By.id("datepick_in")).clear();
		this.driver.findElement(By.id("datepick_in")).sendKeys("10/10/2017");
		this.driver.findElement(By.id("datepick_out")).clear();
		this.driver.findElement(By.id("datepick_out")).sendKeys("11/11/2017");
		Select selectorAdults = new Select(this.driver.findElement(By.id("adult_room")));
		selectorAdults.selectByValue("3");
		Select selectorChildren = new Select(this.driver.findElement(By.id("child_room")));
		selectorChildren.selectByValue("1");
		this.driver.findElement(By.id("Submit")).click();
		Assert.assertEquals(this.driver.getTitle(), "AdactIn.com - Select Hotel");
	}
}
