package com.sqa.vk.adactin;

import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

import com.sqa.vk.core.*;
import com.sqa.vk.helpers.*;

public class AdactinTestSet extends AdactinTest {

	public void login() {
		AdactinHomePage homePage = new AdactinHomePage(this);
		homePage.login(this.getProp("username"), this.getProp("password"));
	}

	@Test(enabled = true)
	public void TC102() throws NoSuchElementException {
		String checkInDate = AppBasics.addDays(7);
		String checkOutDate = AppBasics.addDays(5);
		this.login();
		SearchHotelPage searchPage = new SearchHotelPage(this);
		searchPage.searchHotels("Sydney", "Hotel Creek", "Standard", "1", checkInDate, checkOutDate, "2", "3");
		takeScreenshot("CitySelect");
		String actualMsgIn = this.driver.findElement(By.id("checkin_span")).getText();
		String actualMsgOut = this.driver.findElement(By.id("checkout_span")).getText();
		String expectMsgIn = "Check-In Date shall be before than Check-Out Date";
		String expectMsgOut = "Check-Out Date shall be after than Check-In Date";
		Assert.assertEquals(actualMsgIn, expectMsgIn);
		Assert.assertEquals(actualMsgOut, expectMsgOut);
		System.out.println("TC102\n" + AppBasics.todayDate() + "\n" + "Expected Error for Wrong CheckIn: " + "\""
				+ actualMsgIn + "\"" + "\n" + "Expected Error for Wrong CheckOut: " + "\"" + actualMsgOut
				+ "\"\n-------------------");
	}

	@Test(enabled = true)
	public void TC103() throws NoSuchElementException {
		String checkInDate = AppBasics.substractDays(5);
		String checkOutDate = AppBasics.substractDays(3);
		String actualMsgIn;
		String actualMsgOut;
		String expectMsg = "Enter Valid dates";
		this.login();
		SearchHotelPage searchPage = new SearchHotelPage(this);
		searchPage.searchHotels("Sydney", "Hotel Creek", "Standard", "1", checkInDate, checkOutDate, "2", "3");
		takeScreenshot("TC103");
		actualMsgIn = this.driver.findElement(By.id("checkin_span")).getText();
		actualMsgOut = this.driver.findElement(By.id("checkout_span")).getText();
		// String expectMsg = "Enter Valid dates";
		Assert.assertEquals(actualMsgIn, expectMsg);
		Assert.assertEquals(actualMsgOut, expectMsg);
		System.out.println("TC103\n" + AppBasics.todayDate() + "\n" + "Expected Error for Invalid CheckIn: " + "\""
				+ expectMsg + "\"" + "\n" + "Expected Error for Invalid CheckOut: " + "\"" + expectMsg
				+ "\"\n-------------------");
	}

	@Test(enabled = true)
	public void TC104() throws NoSuchElementException {
		String checkInDate = AppBasics.addDays(0);
		String checkOutDate = AppBasics.addDays(1);
		this.login();
		SearchHotelPage searchPage = new SearchHotelPage(this);
		searchPage.searchHotels("Sydney", "Hotel Creek", "Standard", "1", checkInDate, checkOutDate, "1");
		takeScreenshot("TC104");
		String actualValue = this.driver.findElement(By.id("location_0")).getAttribute("value").toString();
		Assert.assertEquals(actualValue, "Sydney");
		System.out.println("TC104\n" + "Selected location is: " + "\"" + actualValue + "\"\n-------------------");
	}

	@Test(enabled = true)
	public void TC105() throws NoSuchElementException {
		String checkInDate = AppBasics.addDays(0);
		String checkOutDate = AppBasics.addDays(1);
		this.login();
		SearchHotelPage searchPage = new SearchHotelPage(this);
		searchPage.searchHotels("Sydney", "Hotel Creek", "Standard", "1", checkInDate, checkOutDate, "1");
		takeScreenshot("TC104");
		String checkInValue = this.driver.findElement(By.id("arr_date_0")).getAttribute("value").toString();
		String checkOutValue = this.driver.findElement(By.id("dep_date_0")).getAttribute("value").toString();
		Assert.assertEquals(checkInValue, checkInDate);
		Assert.assertEquals(checkOutValue, checkOutDate);
		System.out.println("TC105\n" + "Check-in-Date is: " + "\"" + checkInValue + "\n" + "Check-out_Date is: " + "\""
				+ checkOutValue + "\"\n-------------------");
	}
}
