package com.usingpom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.screenunit.BaseClass;

public class LoginPage extends BaseClass {
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "email")
	private WebElement userEmail;
	
	@FindBy(id = "pass")
	private WebElement userPass;
	
	@FindBy(xpath = "//button[@value = 'login']")
	private WebElement loginBtn;

	public WebElement getUserEmail() {
		return userEmail;
	}

	public WebElement getUserPass() {
		return userPass;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void login (String userName, String passWord) {
	
		toSendKeys(userEmail, userName);
		toSendKeys(userPass, passWord);
		toClickBtn(loginBtn);
		
	}
	
	
	

}
