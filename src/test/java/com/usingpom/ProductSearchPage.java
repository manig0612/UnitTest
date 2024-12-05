package com.usingpom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.screenunit.BaseClass;

public class ProductSearchPage extends BaseClass {
	
	public ProductSearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "search")
	private WebElement txtSearch;
	
	@FindBy(xpath = "//a[@data-testid = 'username']")
	private WebElement homeTxt;

	public WebElement getTxtSearch() {
		return txtSearch;
	}
	
	public void searchTheProduct(String searchTxt) {
		
		toSendKeyWithBtn(txtSearch, searchTxt);
		
	}
	
	public String togetHomeText() {
		String text = toGetTextFromWebpage(homeTxt);
		return text;
	}
	

}
