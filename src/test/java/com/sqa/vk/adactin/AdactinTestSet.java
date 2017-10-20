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
	// To verify whether the check-out date field accepts a later date than
	// check-in date.
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
	// To check if error is reported if check-out date field is in the past
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
	// To verify whether locations in Select Hotel page are displayed
	// according to the location selected in Search Hotel
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
	// To verify whether Check-in date and Check-out date are being displayed in
	// Select Hotel page according to the dates selected in search Hotel.
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
	// To verify whether no. of rooms in Select Hotel page is same as the
	// Number of rooms selected in search hotel page
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
	// To verify whether Room Type in Select Hotel page is same as Room type
	// selected in search hotel page
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
	// To verify whether the total price (excl.GST) is calculated as “price per
	// night * no. of nights* no of rooms”.
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
		System.out.println("\n-------------------");
	}

	@Test(enabled = false)
	// To verify when pressed, logout button logs out from the application.
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
		System.out.println("\n-------------------");
	}

	@Test(enabled = false)
	// Verify that total-price is being calculated as
	// (price-per-night*no-of-rooms*no-of-days + 10% GST”)
	public void TC110() throws NoSuchElementException {
		String checkInDate = AppBasics.addDays(0);
		String checkOutDate = AppBasics.addDays(1);
		this.login();
		SearchHotelPage searchPage = new SearchHotelPage(this);
		searchPage.searchHotels("Melbourne", "Hotel Creek", "Standard", "2", checkInDate, checkOutDate, "1");
		this.driver.findElement(By.id("radiobutton_0")).click();
		this.driver.findElement(By.id("continue")).click();
		BookHotelPage bookPage = new BookHotelPage(this);
		takeScreenshot("TC110");
		String numRooms = bookPage.getNumRooms().replaceAll("[^0-9]", "");
		String numDays = bookPage.getNumDays().replaceAll("[^0-9]", "");
		String priceNight = bookPage.getPriceNight().replaceAll("[^0-9]", "");
		String finalPrice = bookPage.getFinalPrice().replaceAll("[^0-9]", "");
		String gstNum = bookPage.getGst().replaceAll("[^0-9]", "");
		int numOfRooms = Integer.parseInt(numRooms);
		int numOfDays = Integer.parseInt(numDays);
		int pricePerNight = Integer.parseInt(priceNight);
		double totalPrice = Integer.parseInt(finalPrice);
		totalPrice = totalPrice * 10.0 / 100.0;
		double gst = Integer.parseInt(gstNum);
		gst = gst * 10.0 / 100.0;
		double totalPriceCalculated = pricePerNight * numOfRooms * numOfDays + gst;
		System.out.println("The number of rooms: " + numOfRooms + "\n" + "The nunber of Days: " + numOfDays + "\n"
				+ "Price Per Night is: " + pricePerNight + "\n" + "GST is: " + gst);
		System.out.println("The total price CALCULATED is: " + totalPriceCalculated);
		Assert.assertEquals(totalPrice, totalPriceCalculated);
		System.out.println("\n-------------------");
	}

	@Test(enabled = false)
	// To check Hotel name, Location, room type, Total Day, price per night are
	// same in Booking confirmation page as they were selected in previous
	// screen
	public void TC111() throws Exception {
		String checkInDate = AppBasics.addDays(0);
		String checkOutDate = AppBasics.addDays(1);
		this.login();
		SearchHotelPage searchPage = new SearchHotelPage(this);
		searchPage.searchHotels("Sydney", "Hotel Creek", "Standard", "2", checkInDate, checkOutDate, "1");
		SelectHotelPage selectHotel = new SelectHotelPage(this);
		takeScreenshot("TC111_SelectPage");
		selectHotel.getSelectButton().click();
		selectHotel.getContinueButton().click();
		takeScreenshot("TC111_BookHotelPage");
		BookHotelPage bookPage = new BookHotelPage(this);
		Assert.assertEquals(selectHotel.getHotel().toString(), bookPage.getHotel().toString());
		Assert.assertEquals(selectHotel.getLocation().toString(), bookPage.getLocation().toString());
		Assert.assertEquals(selectHotel.getRoom().toString(), bookPage.getRoom().toString());
		Assert.assertEquals(selectHotel.getDays().toString().replaceAll("[^0-9]", ""),
				bookPage.getNumDays().toString().replaceAll("[^0-9]", ""));
		Assert.assertEquals(selectHotel.getPriceNight().toString(), bookPage.getPriceNight().toString());
		System.out.println("Data on the \"Select Hotel\" page matches data on the \"Book Hotel\" page.");
		System.out.println("\n-------------------");
	}

	@Test(enabled = false)
	// To check correct Final billed price is Total Price + 10% Total price in
	// Book a Hotel page
	public void TC112() throws Exception {
		String checkInDate = AppBasics.addDays(0);
		String checkOutDate = AppBasics.addDays(1);
		this.login();
		SearchHotelPage searchPage = new SearchHotelPage(this);
		searchPage.searchHotels("Sydney", "Hotel Creek", "Standard", "2", checkInDate, checkOutDate, "1");
		SelectHotelPage selectHotel = new SelectHotelPage(this);
		takeScreenshot("TC112_SelectPage");
		selectHotel.getSelectButton().click();
		selectHotel.getContinueButton().click();
		takeScreenshot("TC112_BookHotelPage");
		BookHotelPage bookPage = new BookHotelPage(this);
		String totalPrice = bookPage.getTotal().replaceAll("[^0-9]", "");
		String gstNum = bookPage.getGst().replaceAll("[^0-9]", "");
		String finalBilledPrice = bookPage.getFinalPrice().replaceAll("[^0-9]", "");
		double total = Integer.parseInt(totalPrice);
		double gst = Integer.parseInt(gstNum);
		gst = gst * 10.0 / 100.0;
		double finalPriceCalculated = total + gst;
		double finalPrice = Integer.parseInt(finalBilledPrice);
		finalPrice = finalPrice * 10.0 / 100.0;
		System.out.println("here is the final price: " + finalPrice + "\nhere is the CALCULATED final price: "
				+ finalPriceCalculated);
		Assert.assertEquals(finalPrice, finalPriceCalculated);
		System.out.println("\n-------------------");
	}

	@Test(enabled = true)
	// To verify whether the data displayed is same as the selected data in Book
	// hotel page
	public void TC113() throws Exception {
		String checkInDate = AppBasics.addDays(0);
		String checkOutDate = AppBasics.addDays(1);
		this.login();
		SearchHotelPage searchPage = new SearchHotelPage(this);
		searchPage.searchHotels("Sydney", "Hotel Creek", "Standard", "2", checkInDate, checkOutDate, "1");
		SelectHotelPage selectHotel = new SelectHotelPage(this);
		String roomNumberSelected = selectHotel.getNumRooms().replaceAll("[^0-9]", "");
		takeScreenshot("TC113_SelectPage");
		selectHotel.getSelectButton().click();
		selectHotel.getContinueButton().click();
		takeScreenshot("TC113_BookHotelPage");
		BookHotelPage bookPage = new BookHotelPage(this);
		String roomNumberBooked = bookPage.getNumRooms().replaceAll("[^0-9]", "");
		System.out.println("Hotel name: " + selectHotel.getHotel() + "\nRoom type: " + selectHotel.getRoom()
				+ "\nNumber of rooms: " + selectHotel.getNumRooms());
		System.out.println("\n-------------------");
		System.out.println("Hotel name: " + bookPage.getHotel() + "\nRoom type: " + bookPage.getRoom()
				+ "\nNumber of rooms: " + bookPage.getNumRooms());
		Assert.assertEquals(selectHotel.getHotel(), bookPage.getHotel());
		Assert.assertEquals(selectHotel.getRoom(), bookPage.getRoom());
		Assert.assertEquals(roomNumberSelected, roomNumberBooked);
		System.out.println("\n-------------------");
	}
}
