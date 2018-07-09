package com.smartbear.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.smartbear.pomdesign.AllOrdersPage;
import com.smartbear.pomdesign.ProductsPage;

public class VerifyContentTest extends TestBase {
		
	@Test(priority = 3)
	public void TC004() {
		AllOrdersPage allOrderPage = new AllOrdersPage(driver);
		assertEquals(allOrderPage.webOrders.getText(), "Web Orders");

	}

	@Test(priority = 4)
	public void TC005() {
		AllOrdersPage allOrderPage = new AllOrdersPage(driver);
		assertEquals(allOrderPage.loginInfo.getText().replace(" | Logout", ""), "Welcome, " + userId + "!");
	}

	@Test(priority = 5)
	public void TC006() {
		AllOrdersPage allOrderPage = new AllOrdersPage(driver);
		assertTrue(allOrderPage.listOfAllOrders.isDisplayed(), "List Of All Orders label is not displayed");
	}

	@Test(priority = 6)
	public void TC007() {
		AllOrdersPage allOrderPage = new AllOrdersPage(driver);
		assertTrue(allOrderPage.viewAllOrders.isDisplayed(), "viewAllOrders is not displayed");
	}

	@Test(priority = 7)
	public void TC008() {
		AllOrdersPage allOrderPage = new AllOrdersPage(driver);
		assertEquals(allOrderPage.viewAllProducts.getText(), "View all products");
	}

	@Test(priority = 8)
	public void TC009() {
		AllOrdersPage allOrderPage = new AllOrdersPage(driver);
		assertEquals(allOrderPage.orderLink.getText(), "Order");
	}

	@Test(priority = 9)
	public void TC0011() {
		AllOrdersPage allOrderPage = new AllOrdersPage(driver);
		allOrderPage.viewAllProducts.click();
		ProductsPage productsPage = new ProductsPage(driver);
		List<String> expProducts = Arrays.asList("MyMoney", "FamilyAlbum", "ScreenSaver");
		List<String> actProducts = new ArrayList<>();

		// productsPage.productNames.forEach(
		// elem -> actProducts.add(elem.getText())
		// );

		for (WebElement prod : productsPage.productNames) {
			actProducts.add(prod.getText());
		}
		assertEquals(actProducts, expProducts);

	}

	@Test(priority = 10)
	public void TC0012() {
		AllOrdersPage allOrderPage = new AllOrdersPage(driver);
		allOrderPage.viewAllProducts.click();
		ProductsPage productsPage = new ProductsPage(driver);

		for (WebElement row : productsPage.productRows) {
			String[] prodData = row.getText().split(" ");
			switch (prodData[0]) {
			case "MyMoney":
				assertEquals(prodData[1], "$100");
				assertEquals(prodData[2], "8%");

				break;
			case "FamilyAlbum":
				assertEquals(prodData[1], "$80");
				assertEquals(prodData[2], "15%");

				break;
			case "ScreenSaver":
				assertEquals(prodData[1], "$20");
				assertEquals(prodData[2], "10%");

				break;
			}
		}

	}


}
