package com.smartbear.pomdesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebOrderLoginPage {
	public WebOrderLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "ctl00_MainContent_username")
	public WebElement userName;

	@FindBy(id = "ctl00_MainContent_password")
	public WebElement password;

	@FindBy(id = "ctl00_MainContent_login_button")
	public WebElement loginButton;

	@FindBy(id = "ctl00_MainContent_status")
	public WebElement invalidLoginError;

	@FindBy(id = "ctl00_logout")
	public WebElement logoutLink;

	public void logout() {
		logoutLink.click();
	}

	public void login(String uid, String pwd) {
		userName.sendKeys(uid);
		password.sendKeys(pwd);
		loginButton.click();
	}
}
