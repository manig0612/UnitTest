package com.usingpom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.screenunit.BaseClass;

public class FindOrderIdPage extends BaseClass {
	
	public FindOrderIdPage() {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(), 'Welcome')]")
	private WebElement  toGoProfile;
	
	@FindBy(xpath = "//a[contains(text(), 'My')]")
	private WebElement toSelectOptions;
	
	@FindBy(xpath = "//a[text() = 'orders']")
	private WebElement toClickOrder;
	
	@FindBy(xpath = "//a[text() = 'More Details'][1]")
	private WebElement orderDetails;
	
	@FindBy(xpath = "//p[text() = 'Order No: ']")
	private WebElement orderId;
	
	
	public void getOrderId() {
		
		nexplicitWaitToclickableConditions(toGoProfile, 60);
		toClickBtn(toGoProfile);
		toClickBtn(toSelectOptions);
		toClickBtn(toClickOrder);
		toClickBtn(orderDetails);
		
	}
	
	public String getorderNo() {
		String text = toGetTextFromWebpage(orderId);
		return text;
	}
	
	
	
	
	
}
