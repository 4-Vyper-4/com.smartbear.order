package com.smartbear.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.smartbear.pomdesign.AllOrdersPage;
import com.smartbear.pomdesign.OrderPage;

public class PlaceOrderTest extends TestBase {
	
		
	@Test(priority = 1)
	public void TC001() {
		AllOrdersPage allOrderPage = new AllOrdersPage(driver);
		allOrderPage.orderLink.click();

		OrderPage orderPage = new OrderPage(driver);

		Select dropProd = new Select(orderPage.dropDownProducts);
				dropProd.selectByIndex(ddI);

		orderPage.quantity.clear();
		orderPage.quantity.sendKeys(quantiy);
		// orderPage.submit.selectByIndex(0);
		orderPage.cxName.sendKeys(cxName);
		orderPage.streetAddress.sendKeys(streetAddy);
		orderPage.cityAddress.sendKeys(cityAddy);
		orderPage.stateAddress.sendKeys(stateAddy);
		orderPage.zipAddress.sendKeys(zipAddy);

		switch (cardTableNum) {
		case 1:
			orderPage.cardTableVisa.click();
			break;
		case 2:
			orderPage.cardTableMC.click();
			break;
		case 3:
			orderPage.cardTableAmex.click(); 
			break;
		}

		orderPage.ccNumber.sendKeys(ccNumberFake);
		orderPage.expCC.sendKeys(ccExpFake);
		orderPage.processButton.click();
	

	
		assertTrue(orderPage.processed.getText().contains("New order has been successfully added."));

		
		allOrderPage.viewAllOrders.click();
		assertEquals(allOrderPage.nameOrder.getText(), cxName);
		
		switch (ddI) {
		case 1:
			assertEquals(allOrderPage.productOrder.getText(), "FamilyAlbum");
			break;
		case 2:
			assertEquals(allOrderPage.productOrder.getText(), "ScreenSaver");
			break;
		case 3:
			assertEquals(allOrderPage.productOrder.getText(), "MyMoney");
			break;
		}
		
		assertEquals(allOrderPage.streetOrder.getText(), streetAddy);
		assertEquals(allOrderPage.cityOrder.getText(), cityAddy);
		assertEquals(allOrderPage.stateOrder.getText(), stateAddy);
		assertEquals(allOrderPage.zipOrder.getText(), zipAddy);
		
		switch (cardTableNum) {
		case 1:
			assertEquals(allOrderPage.ccTyperOrder.getText(), "Visa");
			break;
			
		case 2:
			assertEquals(allOrderPage.ccTyperOrder.getText(),"MasterCard");
			break;
			
		case 3:
			assertEquals(allOrderPage.ccTyperOrder.getText(), "	American Express");
			break;
		}
		
		assertEquals(allOrderPage.cardNumberOrder.getText(), ccNumberFake);
		assertEquals(allOrderPage.expdateOrder.getText(), ccExpFake);
	
		
		
	}
	
	

}
