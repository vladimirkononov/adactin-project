package com.sqa.vk.core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class BookHotelPage extends BasicPage {

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "last_name")
	WebElement lastName;

	@FindBy(id = "address")
	WebElement address;

	@FindBy(id = "cc_num")
	WebElement creditCard;

	@FindBy(id = "cc_cvv")
	WebElement cvvNumber;

	@FindBy(id = "book_now")
	WebElement bookNow;

	@FindBy(id = "location_dis")
	WebElement locationName;

	@FindBy(id = "hotel_name_dis")
	WebElement hotelName;

	@FindBy(id = "room_num_dis")
	WebElement numOfRooms;

	@FindBy(id = "room_type_dis")
	WebElement roomType;

	@FindBy(id = "total_days_dis")
	WebElement numOfDays;

	@FindBy(id = "price_night_dis")
	WebElement pricePerNight;

	@FindBy(id = "total_price_dis")
	WebElement totalPrice;

	@FindBy(id = "gst_dis")
	WebElement gstDis;

	@FindBy(id = "final_price_dis")
	WebElement finalPriceDis;

	Select ccType = new Select(this.driver.findElement(By.id("cc_type")));

	Select expMonth = new Select(this.driver.findElement(By.id("cc_exp_month")));

	Select expYear = new Select(this.driver.findElement(By.id("cc_exp_year")));

	String hotel = this.hotelName.getAttribute("value").toString();

	String location = this.locationName.getAttribute("value").toString();

	String room = this.roomType.getAttribute("value").toString();

	String numRooms = this.numOfRooms.getAttribute("value").toString();

	String numDays = this.numOfDays.getAttribute("value").toString();

	String priceNight = this.pricePerNight.getAttribute("value").toString();

	String total = this.totalPrice.getAttribute("value").toString();

	String gst = this.gstDis.getAttribute("value").toString();

	String finalPrice = this.finalPriceDis.getAttribute("value").toString();

	/**
	 * @param test
	 */
	public BookHotelPage(BasicTest test) {
		super(test);
	}

	public void bookHotel(String firstName, String lastName, String billingAddr, String creditCard, String cardType,
			String selectMonth, String selectYear, String cvvNum) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
		this.address.clear();
		this.address.sendKeys(billingAddr);
		this.creditCard.clear();
		this.creditCard.sendKeys(creditCard);
		this.ccType.selectByValue(cardType);
		this.expMonth.selectByValue(selectMonth);
		this.expYear.selectByValue(selectYear);
		this.cvvNumber.clear();
		this.cvvNumber.sendKeys(cvvNum);
		this.bookNow.click();
	}

	/**
	 * @return the finalPrice
	 */
	public String getFinalPrice() {
		return this.finalPrice;
	}

	/**
	 * @return the gst
	 */
	public String getGst() {
		return this.gst;
	}

	/**
	 * @return the hotel
	 */
	public String getHotel() {
		return this.hotel;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return this.location;
	}

	/**
	 * @return the numDays
	 */
	public String getNumDays() {
		return this.numDays;
	}

	/**
	 * @return the numRooms
	 */
	public String getNumRooms() {
		return this.numRooms;
	}

	/**
	 * @return the priceNight
	 */
	public String getPriceNight() {
		return this.priceNight;
	}

	/**
	 * @return the room
	 */
	public String getRoom() {
		return this.room;
	}

	/**
	 * @return the total
	 */
	public String getTotal() {
		return this.total;
	}

	/**
	 * @param finalPrice
	 *            the finalPrice to set
	 */
	public void setFinalPrice(String finalPrice) {
		this.finalPrice = finalPrice;
	}

	/**
	 * @param gst
	 *            the gst to set
	 */
	public void setGst(String gst) {
		this.gst = gst;
	}

	/**
	 * @param hotel
	 *            the hotel to set
	 */
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @param numDays
	 *            the numDays to set
	 */
	public void setNumDays(String numDays) {
		this.numDays = numDays;
	}

	/**
	 * @param numRooms
	 *            the numRooms to set
	 */
	public void setNumRooms(String numRooms) {
		this.numRooms = numRooms;
	}

	/**
	 * @param priceNight
	 *            the priceNight to set
	 */
	public void setPriceNight(String priceNight) {
		this.priceNight = priceNight;
	}

	/**
	 * @param room
	 *            the room to set
	 */
	public void setRoom(String room) {
		this.room = room;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(String total) {
		this.total = total;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BookHotelPage [firstName=" + this.firstName + ", lastName=" + this.lastName + ", address="
				+ this.address + ", creditCard=" + this.creditCard + ", cvvNumber=" + this.cvvNumber + ", bookNow="
				+ this.bookNow + ", ccType=" + this.ccType + ", expMonth=" + this.expMonth + ", expYear=" + this.expYear
				+ "]";
	}
}
