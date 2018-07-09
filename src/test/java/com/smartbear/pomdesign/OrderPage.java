package com.smartbear.pomdesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrderPage {

	public OrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="ctl00_MainContent_fmwOrder_ddlProduct")
	public WebElement dropDownProducts;
	
	@FindBy(id ="ctl00_MainContent_fmwOrder_txtQuantity")
	public WebElement quantity;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_txtUnitPrice")
	public WebElement pPU;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_txtDiscount")
	public WebElement discount;
	
	@FindBy(tagName = "submit")
	public Select submit;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
	public WebElement cxName;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
	public WebElement streetAddress;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
	public WebElement cityAddress;
	
	@FindBy(id ="ctl00_MainContent_fmwOrder_TextBox4")
	public WebElement stateAddress;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
	public WebElement zipAddress;
	
	@FindBy(xpath = "(//tr)[3]/td[1]")
	public WebElement cardTableVisa;
	
	@FindBy(xpath = "(//tr)[3]/td[2]")
	public WebElement cardTableMC;
	
	@FindBy(xpath = "(//tr)[3]/td[3]")
	public WebElement cardTableAmex;
	
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
	public WebElement ccNumber;

	
	@FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
	public WebElement expCC;
	
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
	public WebElement processButton;
	
	@FindBy(xpath ="//strong")
	public WebElement processed;
	
	
}
