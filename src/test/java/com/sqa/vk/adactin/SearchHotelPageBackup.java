package com.sqa.vk.adactin;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import com.sqa.vk.core.*;

public class SearchHotelPageBackup extends BasicPage {

	// @FindBy(id = "location")
	// private WebElement city_orig;
	//
	// @FindBy(id = "hotels")
	// WebElement hotel;
	//
	// @FindBy(id = "room_type")
	// WebElement roomtype;
	//
	// @FindBy(id = "room_nos")
	// WebElement numofroom;
	@FindBy(id = "datepick_in")
	WebElement checkindate;

	@FindBy(id = "datepick_out")
	WebElement checkoutdate;

	@FindBy(id = "adult_room")
	WebElement adultsperroom;

	@FindBy(id = "child_room")
	WebElement childsperroom;

	Select city = new Select(this.driver.findElement(By.id("location")));

	Select hotel = new Select(this.driver.findElement(By.id("hotels")));

	Select roomtype = new Select(this.driver.findElement(By.id("room_type")));

	Select numofroom = new Select(this.driver.findElement(By.id("room_nos")));

	public SearchHotelPageBackup(BasicTest test) {
		super(test);
	}

	public void searchHotels(String cityName) {
		this.city.selectByVisibleText(cityName);
	}

	public void searchHotels(String cityName, String hotelName, String roomType, String numofRoom) {
		this.city.selectByVisibleText(cityName);
		this.hotel.selectByVisibleText(hotelName);
		this.city.selectByVisibleText(roomType);
		this.city.selectByVisibleText(numofRoom);
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
	public void searchHotels(String city, String hotel, String roomtype, String numofroom, String checkindate,
			String checkoutdate, String adultsperroom, String childsperroom) {
		// this.city.getTagName();
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
