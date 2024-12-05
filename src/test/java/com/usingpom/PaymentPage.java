package com.usingpom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.screenunit.BaseClass;

public class PaymentPage extends BaseClass {
	
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "payment_type")
	private WebElement paymentType;
	
	@FindBy(xpath = "//label[text() = ' Visa ']")
	private WebElement cardType;
	
	@FindBy(name = "card_no")
	private WebElement cardNumber;
	
	@FindBy(id = "month")
	private WebElement expirymonth;
	
	@FindBy(id = "year")
	private WebElement expiryYear;
	
	@FindBy(name = "cvv")
	private WebElement ccNumber;
	
	@FindBy(id = "placeOrder")
	private WebElement placeOrderBtn;

	public WebElement getPlaceOrderBtn() {
		return placeOrderBtn;
	}

	public WebElement getPaymentType() {
		return paymentType;
	}

	public WebElement getCardType() {
		return cardType;
	}

	public WebElement getCardNumber() {
		return cardNumber;
	}

	public WebElement getExpirymonth() {
		return expirymonth;
	}

	public WebElement getExpiryYear() {
		return expiryYear;
	}

	public WebElement getCcNumber() {
		return ccNumber;
	}
	
	public void paymentProcess(String carno, String cardcvv) throws InterruptedException {
		Thread.sleep(3000);
		
		explicitWaitToFindLocatorConditions(paymentType, 60);
		//nexplicitWaitToclickableConditions(paymentType, 60);
		
		toSelectByValue(paymentType, "debit_card");
		explicitWaitToFindLocatorConditions(cardType, 60);
		nexplicitWaitToclickableConditions(cardType, 60);
		toClickBtn(cardType);
		
		explicitWaitToFindLocatorConditions(cardNumber, 60);
		nexplicitWaitToclickableConditions(cardNumber, 60);
		
		toSendKeys(cardNumber, carno);
		explicitWaitToFindLocatorConditions(expirymonth, 60);
		nexplicitWaitToclickableConditions(expirymonth, 60);
		toSelectByIndex(expirymonth, 11);
		
		explicitWaitToFindLocatorConditions(expiryYear, 60);
		nexplicitWaitToclickableConditions(expiryYear, 60);
		toSelectbyText(expiryYear, "2029");
		explicitWaitToFindLocatorConditions(ccNumber, 60);
		nexplicitWaitToclickableConditions(ccNumber, 60);
		toSendKeys(ccNumber, cardcvv);
		toClickBtn(placeOrderBtn);
		
		
	}
	

}
