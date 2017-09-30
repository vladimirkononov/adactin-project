package com.sqa.vk.adactin;

import org.testng.annotations.*;

import com.sqa.vk.core.*;
import com.sqa.vk.helpers.enums.*;
import com.sqa.vk.helpers.exceptions.*;

public class LogoutTestTC109 extends SauceLabsTest {

	public LogoutTestTC109() throws BrowserNotSupportedBySauceLabsException {
		super("http://adactin.com/HotelApp/");
	}

	@Override
	@DataProvider
	public Object[][] dp() {
		return new Object[][] {
				new Object[] { "Sydney", "Hotel Creek", "Double", "5 - Five", "31/05/2017", "01/06/2017", "3 - Three",
						"3 - Three" },
				new Object[] { "Brisbane", "Hotel Cornice", "Double", "5 - Five", "31/05/2017", "01/06/2017",
						"3 - Three", "3 - Three" },
				new Object[] { "London", "Hotel Sunshine", "Double", "5 - Five", "31/05/2017", "01/06/2017",
						"3 - Three", "3 - Three" }, };
	}

	@Test(dataProvider = "dataProvider")
	public void testSearchHotels(String username, String accessKey, Browser browser, String version, String platform,
			String city, String hotel, String roomtype, String numofroom, String checkindate, String checkoutdate,
			String adultsperroom, String childsperroom) throws BrowserNotSupportedBySauceLabsException {
		this.preTest(username, accessKey, browser, version, platform);
		// SearchHotelPage searchPage = new
		// AdactinHomePage(this).login(getProp("username"),
		// getProp("password"));
		// searchPage.searchHotels(city, hotel, roomtype, numofroom,
		// checkindate, checkoutdate, adultsperroom,
		// childsperroom);
		System.out.println("Testing " + city + " " + hotel + " " + roomtype + " " + numofroom + " " + checkindate + " "
				+ checkoutdate + " " + adultsperroom + " " + childsperroom);
		this.takeScreenshot("Hotel Results - " + hotel + " (" + city + ")");
	}
}
