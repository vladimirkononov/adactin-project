/**
 * File Name: BasicTest.java<br>
 * Nepton, Jean-francois<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Sep 6, 2017
 */
package com.sqa.vk.core;

import org.openqa.selenium.firefox.*;
import org.testng.annotations.*;

/**
 * BasicTest //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Nepton, Jean-francois
 * @version 1.0.0
 * @since 1.0
 */
public class BasicTest extends Core {

	/**
	 * @param baseUrl
	 * @param driver
	 */
	public BasicTest(String baseUrl) {
		super(baseUrl);
	}

	/**
	 *
	 */
	public void setUpChrome() {
		// TODO Auto-generated method stub
	}

	@BeforeClass
	public void setupDriver() {
		this.driver = new FirefoxDriver();
	}

	/**
	 *
	 */
	public void setUpFirefox() {
		// TODO Auto-generated method stub
	}

	/**
	 *
	 */
	public void setUpIE() {
		// TODO Auto-generated method stub
	}

	@BeforeMethod
	public void setupTest() {
		getDriver().get(getBaseUrl());
	}

	@AfterClass
	public void tearDown() {
		getDriver().quit();
	}
}
