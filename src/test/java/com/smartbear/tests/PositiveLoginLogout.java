package com.smartbear.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.smartbear.pomdesign.WebOrderLoginPage;

public class PositiveLoginLogout {

	public WebDriver driver;
	public String userId = "Tester";
	public String passWord = "test";

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}


	@Test(priority = 1)
	public void TC002() {
		// driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		WebOrderLoginPage loginPage = new WebOrderLoginPage(driver);
		loginPage.login(userId, passWord);
		
	}

	@Test(priority = 2)
	public void TC0099() {
		WebOrderLoginPage loginPage = new WebOrderLoginPage(driver);
		loginPage.login(userId, passWord);
		loginPage.logout();
	}

}
