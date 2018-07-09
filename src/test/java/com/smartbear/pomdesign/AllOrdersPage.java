package com.smartbear.pomdesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllOrdersPage {

	public AllOrdersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[.='Web Orders']")
	public WebElement webOrders;

	@FindBy(css = ".login_info")
	public WebElement loginInfo;

	@FindBy(xpath = "//h2[contains(.,'List of All Orders')]")
	public WebElement listOfAllOrders;

	@FindBy(linkText = "View all orders")
	public WebElement viewAllOrders;

	@FindBy(linkText = "View all products")
	public WebElement viewAllProducts;

	@FindBy(linkText = "Order")
	public WebElement orderLink;
	
	@FindBy(xpath = "(//table//tr[2])/td[2]")
	public WebElement nameOrder;	
	
	@FindBy(xpath = "(//table//tr[2])/td[3]")
	public WebElement productOrder;	
	
	@FindBy(xpath = "(//table//tr[2])/td[6]")
	public WebElement streetOrder;	
	
	@FindBy(xpath = "(//table//tr[2])/td[7]")
	public WebElement cityOrder;	
	
	@FindBy(xpath = "(//table//tr[2])/td[8]")
	public WebElement stateOrder;	
	
	@FindBy(xpath = "(//table//tr[2])/td[9]")
	public WebElement zipOrder;	
	
	@FindBy(xpath = "(//table//tr[2])/td[10]")
	public WebElement ccTyperOrder;	
	
	@FindBy(xpath = "(//table//tr[2])/td[11]")
	public WebElement cardNumberOrder;	
	
	@FindBy(xpath = "(//table//tr[2])/td[12]")
	public WebElement expdateOrder;	
	
	
}
