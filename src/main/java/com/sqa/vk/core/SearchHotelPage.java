package com.sqa.vk.core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class SearchHotelPage extends BasicPage {

	@FindBy(id = "datepick_in")
	WebElement checkindate;

	@FindBy(id = "datepick_out")
	WebElement checkoutdate;

	Select city = new Select(this.driver.findElement(By.id("location")));

	Select hotel = new Select(this.driver.findElement(By.id("hotels")));

	Select roomtype = new Select(this.driver.findElement(By.id("room_type")));

	Select numofroom = new Select(this.driver.findElement(By.id("room_nos")));

	Select adultsperroom = new Select(this.driver.findElement(By.id("adult_room")));

	Select childsperroom = new Select(this.driver.findElement(By.id("child_room")));

	@FindBy(id = "Submit")
	WebElement submit;

	public SearchHotelPage(BasicTest test) {
		super(test);
	}

	public void searchHotels(String cityName) {
		this.city.selectByVisibleText(cityName);
	}

	/**
	 */
	/**
	 * @param city
	 * @param hotel
	 * @param roomtype
	 * @param numofroom
	 * @param checkindate
	 * @param checkoutdate
	 * @param adultsperroom
	 * @param childsperroom
	 */
	public void searchHotels(String cityName, String hotelName, String roomType, String numofRoom, String checkIn,
			String checkOut, String adultRoom) {
		this.city.selectByVisibleText(cityName);
		this.hotel.selectByVisibleText(hotelName);
		this.roomtype.selectByVisibleText(roomType);
		this.numofroom.selectByValue(numofRoom);
		this.checkindate.clear();
		this.checkindate.sendKeys(checkIn);
		this.checkoutdate.clear();
		this.checkoutdate.sendKeys(checkOut);
		this.adultsperroom.selectByValue(adultRoom);
		this.submit.click();
	}

	/**
	 */
	/**
	 * @param city
	 * @param hotel
	 * @param roomtype
	 * @param numofroom
	 * @param checkindate
	 * @param checkoutdate
	 * @param adultsperroom
	 * @param childsperroom
	 */
	public void searchHotels(String cityName, String hotelName, String roomType, String numofRoom, String checkIn,
			String checkOut, String adultRoom, String childRoom) {
		this.city.selectByVisibleText(cityName);
		this.hotel.selectByVisibleText(hotelName);
		this.roomtype.selectByVisibleText(roomType);
		this.numofroom.selectByValue(numofRoom);
		this.checkindate.clear();
		this.checkindate.sendKeys(checkIn);
		this.checkoutdate.clear();
		this.checkoutdate.sendKeys(checkOut);
		this.adultsperroom.selectByValue(adultRoom);
		this.childsperroom.selectByValue(childRoom);
		this.submit.click();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SearchHotelPage [checkindate=" + this.checkindate + ", checkoutdate=" + this.checkoutdate
				+ ", adultsperroom=" + this.adultsperroom + ", childsperroom=" + this.childsperroom + ", city="
				+ this.city + ", hotel=" + this.hotel + ", roomtype=" + this.roomtype + ", numofroom=" + this.numofroom
				+ "]";
	}
}
