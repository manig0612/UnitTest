package com.usingpom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.screenunit.BaseClass;

public class ProductListinPage extends BaseClass {
	
	public ProductListinPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text() = 'Add'][1]")
	private WebElement addFirstBtn;
	
	@FindBy(id = "cart-22")
	private WebElement addToCartBtn;
	
	@FindBy(xpath = "//a[@class = 'hover1']")
	private WebElement goToCartBtn;
	
	@FindBy(xpath = "//h5[contains(text(), 'Search Result')]")
	private WebElement getSearchText;

	public WebElement getGetSearchText() {
		return getSearchText;
	}

	public WebElement getAddFirstBtn() {
		return addFirstBtn;
	}

	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}

	public WebElement getGoToCartBtn() {
		return goToCartBtn;
	}
	
	public void cartHandling() throws InterruptedException {
		toClickBtn(addFirstBtn);
		toClickBtn(addToCartBtn);
		Thread.sleep(3000);
		toClickBtn(goToCartBtn);
	}
	
	public String getCartText() {
		String text = toGetTextFromWebpage(getSearchText);
		return text;
	}
	
	

}
