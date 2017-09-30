package com.sqa.vk.msn;

import java.util.*;

import org.openqa.selenium.*;
import org.testng.annotations.*;

import com.sqa.vk.helpers.*;

public class MSNHelperTests extends MSNTest {

	@Test(enabled = false)
	public void testHelperMethodsPictures() {
		System.out.println("Image Count" + AutoBasics.getPictures(getDriver()).size());
	}

	@Test
	public void testHelperMethodsPictures2() {
		List<WebElement> images = AutoBasics.getPictures(getDriver());
		for (int i = 0, j = 1; i < images.size(); i++) {
			if (!images.get(i).getAttribute("alt").equalsIgnoreCase("")) {
				System.out.println("#" + (j) + ": [" + images.get(i).getAttribute("alt") + "] SRC="
						+ images.get(i).getAttribute("src"));
				j++;
			}
		}
	}
}
