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

	Select ccType = new Select(this.driver.findElement(By.id("cc_type")));

	Select expMonth = new Select(this.driver.findElement(By.id("cc_exp_month")));

	Select expYear = new Select(this.driver.findElement(By.id("cc_exp_year")));

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
