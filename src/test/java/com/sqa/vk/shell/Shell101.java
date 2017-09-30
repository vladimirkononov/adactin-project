package com.sqa.vk.shell;

import org.testng.annotations.*;

import com.sqa.vk.core.*;

public class Shell101 extends ShellTest {

	@Test
	public void testTC101() throws IllegalMonitorStateException, InterruptedException {
		// WebDriverWait wait = new WebDriverWait(this.driver, 30);
		ShellHomePage homePage = new ShellHomePage(this);
		homePage.linkClick();
	}
}
