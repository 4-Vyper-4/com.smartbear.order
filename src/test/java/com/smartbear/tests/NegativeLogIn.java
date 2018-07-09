package com.smartbear.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.smartbear.pomdesign.WebOrderLoginPage;
import com.smartbear.tests.TestBase;

public class NegativeLogIn extends TestBase {
	
	@Test(priority = 1)
	public void TC001() {
		WebOrderLoginPage loginPage = new WebOrderLoginPage(driver);
		loginPage.logout();
		loginPage.login(wrongUser, passWord);
		String errMsg = loginPage.invalidLoginError.getText();
		assertEquals(errMsg, "Invalid Login or Password.");
	}
	

}
