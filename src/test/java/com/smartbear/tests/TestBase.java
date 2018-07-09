package com.smartbear.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.smartbear.pomdesign.WebOrderLoginPage;

public class TestBase {

	public WebDriver driver;

	public String userId = "Tester";
	public String passWord = "test";
	public String wrongUser = "Wrong";

	public String quantiy = ""+(Faker.instance().number().numberBetween(1, 5));
	public int cardTableNum = Faker.instance().number().numberBetween(1, 3);
	
	public String cxName = Faker.instance().name().fullName()+" Case4TE";
	public String streetAddy = Faker.instance().address().buildingNumber();
	public String cityAddy = Faker.instance().address().cityName();
	public String stateAddy = Faker.instance().address().state();
	public String zipAddy = ""+ Faker.instance().number().numberBetween(10000, 99999);
	public String ccNumberFake = Faker.instance().finance().creditCard().replaceAll("-", "");
	public String ccExpFake = "0"+Faker.instance().number().numberBetween(1, 9)+"/0"+Faker.instance().number().numberBetween(1, 9);
	 
	public int ddI = Faker.instance().number().numberBetween(1, 3);


	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
//		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
//		OldWebOrderLoginPage loginPage = new OldWebOrderLoginPage(driver);
//		loginPage.login(userId, passWord);	
	}
		
	@BeforeMethod
	public void setUpMeth(){
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		WebOrderLoginPage loginPage = new WebOrderLoginPage(driver);
		loginPage.login(userId, passWord);		
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	

}
