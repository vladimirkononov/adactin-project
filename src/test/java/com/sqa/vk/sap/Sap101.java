package com.sqa.vk.sap;

import java.util.*;

import org.testng.annotations.*;

public class Sap101 extends SapTest {

	@Test
	public void test101() throws NoSuchElementException {
		SapHomePage homePage = new SapHomePage(this);
		homePage.selectFeature();
	}
}
