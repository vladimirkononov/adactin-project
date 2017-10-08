package com.sqa.vk.adactin;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.*;
import org.testng.annotations.*;

import com.sqa.vk.core.*;
import com.sqa.vk.helpers.*;

public class AdactinTestSet extends AdactinTest {

	public void login() {
		AdactinHomePage homePage = new AdactinHomePage(this);
		homePage.login(this.getProp("username"), this.getProp("password"));
	}

	@Test(enabled = false)
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

	@Test(enabled = false)
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

	@Test(enabled = false)
	public void TC104() throws NoSuchElementException {
		String checkInDate = AppBasics.addDays(0);
		String checkOutDate = AppBasics.addDays(1);
		this.login();
		SearchHotelPage searchPage = new SearchHotelPage(this);
		searchPage.searchHotels("Sydney", "Hotel Creek", "Standard", "1", checkInDate, checkOutDate, "1");
		takeScreenshot("TC104");
		String actualValue = this.driver.findElement(By.id("location_0")).getAttribute("value").toString();
		Assert.assertEquals(actualValue, "Sydney");
		System.out.println("TC104\n" + "Selected location is: " + actualValue + "\"\n-------------------");
	}

	@Test(enabled = false)
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

	@Test(enabled = false)
	public void TC106() throws NoSuchElementException {
		String checkInDate = AppBasics.addDays(0);
		String checkOutDate = AppBasics.addDays(1);
		this.login();
		SearchHotelPage searchPage = new SearchHotelPage(this);
		searchPage.searchHotels("Sydney", "Hotel Creek", "Standard", "3", checkInDate, checkOutDate, "1");
		takeScreenshot("TC106");
		String numRooms = this.driver.findElement(By.id("rooms_0")).getAttribute("value").toString();
		Assert.assertEquals(numRooms, "3 Rooms");
		System.out.println(
				"TC106\n" + "Selected number of rooms is: " + "\"" + numRooms + "\"" + "\"\n-------------------");
	}

	@Test(enabled = false)
	public void TC107() throws NoSuchElementException {
		String checkInDate = AppBasics.addDays(0);
		String checkOutDate = AppBasics.addDays(1);
		this.login();
		SearchHotelPage searchPage = new SearchHotelPage(this);
		searchPage.searchHotels("Sydney", "Hotel Creek", "Deluxe", "1", checkInDate, checkOutDate, "1");
		takeScreenshot("TC107");
		String roomType = this.driver.findElement(By.id("room_type_0")).getAttribute("value").toString();
		Assert.assertEquals(roomType, "Deluxe");
		System.out.println("TC107\n" + "Selected Room Type is: " + "\"" + roomType + "\"" + "\"\n-------------------");
	}

	@Test(enabled = false)
	public void TC108() throws NumberFormatException {
		String checkInDate = AppBasics.addDays(0);
		String checkOutDate = AppBasics.addDays(1);
		this.login();
		SearchHotelPage searchPage = new SearchHotelPage(this);
		searchPage.searchHotels("Sydney", "Hotel Creek", "Standard", "2", checkInDate, checkOutDate, "1");
		takeScreenshot("TC108");
		String pricePerNight = this.driver.findElement(By.id("price_night_0")).getAttribute("value").toString();
		pricePerNight = pricePerNight.replaceAll("[^0-9]", "");
		String numOfNights = this.driver.findElement(By.id("no_days_0")).getAttribute("value").toString();
		numOfNights = numOfNights.replaceAll("[^0-9]", "");
		String numOfRooms = this.driver.findElement(By.id("rooms_0")).getAttribute("value").toString();
		numOfRooms = numOfRooms.replaceAll("[^0-9]", "");
		String actualTotalPrice = this.driver.findElement(By.id("total_price_0")).getAttribute("value").toString();
		actualTotalPrice = actualTotalPrice.replaceAll("[^0-9]", "");
		int actualPrice = Integer.parseInt(actualTotalPrice);
		int nightPrice = Integer.parseInt(pricePerNight);
		int nightNum = Integer.parseInt(numOfNights);
		int roomNum = Integer.parseInt(numOfRooms);
		int totalPrice = nightPrice * nightNum * roomNum;
		Assert.assertEquals(actualPrice, totalPrice);
		System.out.println("Price per night is: " + nightPrice + "\n" + "Number of nights is: " + nightNum + "\n"
				+ "Number of rooms is: " + roomNum + "\n" + "Total Price is: " + actualPrice);
		System.out.println("\"\n-------------------");
	}

	@Test(enabled = true)
	public void TC109() throws NoSuchElementException, InterruptedException {
		String checkInDate = AppBasics.addDays(0);
		String checkOutDate = AppBasics.addDays(1);
		this.login();
		SearchHotelPage searchPage = new SearchHotelPage(this);
		searchPage.searchHotels("Sydney", "Hotel Creek", "Standard", "2", checkInDate, checkOutDate, "1");
		this.driver.findElement(By.id("radiobutton_0")).click();
		this.driver.findElement(By.id("continue")).click();
		BookHotelPage bookPage = new BookHotelPage(this);
		bookPage.bookHotel("Vlad", "Kononov", "21 Solitude CT, Oakley, CA 94561", "1111111111111111", "VISA", "5",
				"2021", "222");
		WebDriverWait wait = new WebDriverWait(this.driver, 30);
		WebElement bookingConfirmation;
		bookingConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout")));
		takeScreenshot("TC109_booked");
		bookingConfirmation.click();
		takeScreenshot("TC109_loggedout");
		Assert.assertTrue(this.driver.getPageSource().contains("You have successfully logged out."));
	}
}
