package com.screenunit;



import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetTextFromJunit extends BaseClass {
	
	public static WebDriver driver;
	
	List<String> testlist = new LinkedList<String>();
	
	@BeforeClass
	public static void browserLaunch() {
		toLaunchBrowser("CHROME");
		toGetURl("https://www.omrbranch.com/");
		maximizeTheWindow();
		implicityWait();
	}
	
	@Test
	public void login() throws IOException {
		WebElement userNameTxt = toFindLocatorById("email");
		toSendKeys(userNameTxt, getCellData("Grocery", 1, 0));
		
		WebElement passwordTxt = toFindLocatorById("pass");
		toSendKeys(passwordTxt, getCellData("Grocery", 1, 1));
		
		WebElement loginBtn = toFindLocatorByXpath("//button[text() = 'Login']");
		toClickBtn(loginBtn);
		
		WebElement loginTxt = toFindLocatorByXpath("//a[@class = 'icoTwitter mr-2 dropdown-toggle']");
		String getableText = toGetTextFromWebpage(loginTxt);
		
		boolean cont = getableText.contains("Mani");
		Assert.assertTrue("verify login text", cont);
		testlist.add(getableText);
			
	}
	
	@Test
	public void searchBar() throws IOException, InterruptedException {
		WebElement searchTxt = toFindLocatorById("search");
		toSendKeyWithBtn(searchTxt, getCellData("Grocery", 1, 2));
		WebElement getsearch = toFindLocatorByXpath("//h5[contains(text(),  'Search Result')]");
		String searchText = toGetTextFromWebpage(getsearch);
		
		boolean contain = searchText.contains("nuts");
		Assert.assertTrue("verify serach text", contain);
		testlist.add(searchText);
	
		WebElement clickAddBtn = toFindLocatorByXpath("//a[text() = 'Add'][1]");
		toClickBtn(clickAddBtn);
		
		WebElement clickInsideAddBtn = toFindLocatorById("cart-22");
		toClickBtn(clickInsideAddBtn);
		
		Thread.sleep(3000);
		WebElement toCartBtn = toFindLocatorByXpath("//a[text() = ' Go To Cart ']");
		toClickBtn(toCartBtn);
//		
		WebElement findMyCart =  toFindLocatorByXpath("//h5[text() = 'My Cart']");
		String fromMyCart = toGetTextFromWebpage(findMyCart);
//		
		boolean containcart = fromMyCart.contains("Cart");
		Assert.assertTrue("verify cart", containcart);
		testlist.add(fromMyCart);
		
		WebElement toclickAddressBtn = toFindLocatorByXpath("//div[@class = 'diffAddres addAddress d-flex justify-content-center align-items-center mb-md-0 mb-2']");
		explicitWaitToFindLocatorConditions(toclickAddressBtn, 60);
		nexplicitWaitToclickableConditions(toclickAddressBtn, 60);
		toClickBtn(toclickAddressBtn);
		WebElement addAddress = toFindLocatorById("address_type");
		nexplicitWaitToclickableConditions(addAddress, 60);
		toSelectbyText(addAddress, "Office");
//		
		WebElement fillFirstTxt = toFindLocatorByName("first_name");
		
		toSendKeys(fillFirstTxt, getCellData("Grocery", 1, 3));
		
		
		WebElement fillLastTxt = toFindLocatorByName("last_name");
		toSendKeys(fillLastTxt, getCellData("Grocery", 1, 4));
//		
//		
		WebElement fillMobile = toFindLocatorByName("mobile");
		toSendKeys(fillMobile, getCellData("Grocery", 1, 5));
		
		
		WebElement fillApartment = toFindLocatorByName("apartment");
		toSendKeys(fillApartment, getCellData("Grocery", 1, 6));
		
		
		WebElement fillSecondAddress = toFindLocatorByName("address");
		toSendKeys(fillSecondAddress, getCellData("Grocery", 1, 7));
//		
//		
		WebElement selState = toFindLocatorByXpath("//select[@name = 'state']");
		toSelectbyText(selState, "Tamil Nadu");
		
		
		WebElement selCity = toFindLocatorByXpath("//select[@name = 'city']");
		toSelectbyText(selCity, "Chennai");
		
		
		WebElement toSendZipCode = toFindLocatorByXpath("//input[@name = 'zipcode']");
		toSendKeys(toSendZipCode, getCellData("Grocery", 1, 8));
		
		WebElement clickSaveBtn = toFindLocatorByXpath("//button[@class = 'saveAddress font18 fontSemiBold colorWhite bgTheme radius50 borderNone px-5 py-2 hover1']");
		toClickBtn(clickSaveBtn);
		
	    WebElement getAddress = toFindLocatorByXpath("//p[@class = 'font14 color36']");
	    String addText = getAddress.getText();
		boolean addressCheck = addText.contains("thuraipakkam");
		Assert.assertTrue("verify address", addressCheck);
		testlist.add(addText);
		
		WebElement selPayment = toFindLocatorById("payment_type");
		toSelectByValue(selPayment, "debit_card");
		String paymentmethod = toGetFirstSelectOption(selPayment);
		WebElement toSelectCard = toFindLocatorByXpath("//label[text() = ' Visa ']");
		//grocery.nexplicitWaitToclickableConditions(toSelectCard, 60);
		toClickBtn(toSelectCard);
		
		
		WebElement toSendCardNum = toFindLocatorByName("card_no");
		toSendKeys(toSendCardNum, getCellData("Grocery", 1, 9));
		
		
		WebElement toSelMonth = toFindLocatorById("month");
		toSelectByIndex(toSelMonth, 11);
		
		
		WebElement selYear = toFindLocatorById("year");
		toSelectbyText(selYear, "2030");
		
		
		WebElement sendCvv = toFindLocatorByName("cvv");
		toSendKeys(sendCvv, getCellData("Grocery", 1, 10));
		
		
		WebElement pressPlaceOrderBtn = toFindLocatorById("placeOrder");
		toClickBtn(pressPlaceOrderBtn);
		Boolean payVerify = paymentmethod.contains("Debit");
		Assert.assertTrue("verify payment", payVerify);
		testlist.add(paymentmethod);
		
		WebElement selcHome =toFindLocatorByXpath("//a[contains(text(), 'Welcome')]");
		nexplicitWaitToclickableConditions(selcHome, 60);
		toClickBtn(selcHome);
		
		
		WebElement toselMyAccount = toFindLocatorByXpath("//a[contains(text(), 'My')]");
	    toClickBtn(toselMyAccount);
		
		
		WebElement toselorder = toFindLocatorByXpath("//a[text() = 'orders']");
		toClickBtn(toselorder);
		
		
		WebElement toSeleceOrderDetails = toFindLocatorByXpath("//a[text() = 'More Details'][1]");
		toClickBtn(toSeleceOrderDetails);
		
		//Thread.sleep(3000);
		WebElement toGetOrderid = toFindLocatorByXpath("//p[text() = 'Order No: ']");
		String orderId = toGetTextFromWebpage(toGetOrderid);
		boolean conformOrder = orderId.contains("Order");
		Assert.assertTrue("verify order", conformOrder);
		testlist.add(orderId);
		
		
		
	}
	
	@After
	public void getTextfromWeb() {
		
		for (int i = 0; i < testlist.size(); i++) {
			
			String forTest = testlist.get(i);
			System.out.println(forTest);
			
		}
	}
	
	@AfterClass
	public static void closeWindow() {
		closeTheWindow();
	}
	

}
