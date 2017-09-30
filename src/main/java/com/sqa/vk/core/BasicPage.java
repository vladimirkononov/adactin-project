package com.sqa.vk.core;

import org.openqa.selenium.support.*;

public class BasicPage extends Core {

	public BasicPage(BasicTest test) {
		super(test);
		PageFactory.initElements(getDriver(), this);
	}
}
