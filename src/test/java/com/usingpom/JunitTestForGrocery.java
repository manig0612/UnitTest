package com.usingpom;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.screenunit.BaseClass;

public class JunitTestForGrocery extends BaseClass {
	
	@BeforeClass
	public static void launchbrowser() {
		
		toLaunchBrowser("CHROME");
		toGetURl("https://www.omrbranch.com/");
		maximizeTheWindow();
		implicityWait();
		
	}
	
	@Test
	public void groceryTest() throws IOException, InterruptedException {
		LoginPage lgnPage = new LoginPage();
		lgnPage.login(getCellData("Grocery", 1, 0), getCellData("Grocery", 1, 1));
		
		ProductSearchPage proSearch = new ProductSearchPage();
		String homeText = proSearch.togetHomeText();
		Assert.assertEquals("verify Home", "Welcome Mani", homeText);
		System.out.println(homeText);
		proSearch.searchTheProduct(getCellData("Grocery", 1, 2));
		
		ProductListinPage productList = new ProductListinPage();
		String cartText = productList.getCartText();
		Assert.assertEquals("Verify Search", "Search Result - nuts", cartText);
		System.out.println(cartText);
		productList.cartHandling();
		
		MyCartPage cartPage = new MyCartPage();
		String cText = cartPage.getCartDetais();
		Assert.assertEquals("verify cart", "My Cart", cText);;
		cartPage.addAddress(limitedCell("Grocery", 3, 10));
		
		PaymentPage paymentPage = new PaymentPage();
		paymentPage.paymentProcess(getCellData("Grocery", 1, 11), getCellData("Grocery", 0, 12));
		
		//toGetURl("https://www.omrbranch.com/");
		//lgnPage.login(getCellData("Grocery", 1, 0), getCellData("Grocery", 1, 1));
		
		FindOrderIdPage findorderPage = new FindOrderIdPage();
		findorderPage.getOrderId();
		String getorderNo = findorderPage.getorderNo();
		toWriteExcel(1, 13, getorderNo);
		System.out.println(getorderNo);
		
		
	}
	
	@AfterClass
	public static void closeDriver() {
		//closeTheWindow();
	}

}
