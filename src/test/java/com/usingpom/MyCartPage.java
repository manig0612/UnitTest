package com.usingpom;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.screenunit.BaseClass;

public class MyCartPage extends BaseClass {
	
	public MyCartPage() {
	 PageFactory.initElements(driver, this);
	}
	
	
	
	public List<WebElement> wbElement = new LinkedList<WebElement>();
	
	@FindBy(xpath = "//h5[contains(text(), 'My')]")
	private WebElement cartTxt;
	
	@FindBy(xpath = "//div[@data-toggle = 'modal']")
	private WebElement addAddress;
	
	@FindBy(id = "address_type")
	private WebElement webtoChooseAddressType;
	
	@FindBy(name = "first_name")
	private WebElement firstName;
 
	@FindBy(name = "last_name")
	private WebElement lastName;
	
	@FindBy(name = "mobile")
	private WebElement mobileNo;
	
	@FindBy(name = "apartment")
	private WebElement firstAddress;
	
	@FindBy(name = "address")
	private WebElement secondAddress;
	
	@FindBy(xpath = "//select[@name = 'state']")
	private WebElement toSelecState;
	
	@FindBy(xpath = "//select[@name = 'city']")
	private WebElement toCity;
	
	@FindBy(xpath = "//input[@name = 'zipcode']")
	private WebElement zipCode;
	
	@FindBy(xpath = "//button[@class = 'saveAddress font18 fontSemiBold colorWhite bgTheme radius50 borderNone px-5 py-2 hover1']")
	private WebElement saveBtnPress; 
	
	

	public WebElement getFirstName() {
		return firstName;
	}


	public WebElement getLastName() {
		return lastName;
	}


	public WebElement getMobileNo() {
		return mobileNo;
	}


	public WebElement getFirstAddress() {
		return firstAddress;
	}


	public WebElement getSecondAddress() {
		return secondAddress;
	}


	public WebElement getWebtoChooseAddressType() {
		return webtoChooseAddressType;
	}
	
	
	public WebElement getAddAddress() {
		return addAddress;
	}

	public void addAddress(LinkedList<String> excelList) {
		wbElement.add(firstName);
		wbElement.add(lastName);
		wbElement.add(mobileNo);
		wbElement.add(firstAddress);
		wbElement.add(secondAddress);
		wbElement.add(toSelecState);
		wbElement.add(toCity);
		wbElement.add(zipCode);
		
		explicitWaitToFindLocatorConditions(addAddress, 60);
		nexplicitWaitToclickableConditions(addAddress, 60);
		toClickBtn(addAddress);
		nexplicitWaitToclickableConditions(webtoChooseAddressType, 60);
		toSelectbyText(webtoChooseAddressType, "Office");
		
		for (int i = 0; i < wbElement.size(); i++) {
			

			if(i == 5) {
				toSelectbyText(wbElement.get(i), excelList.get(i));
			}
			
			else if(i == 6) {
				toSelectbyText(wbElement.get(i), excelList.get(i));
				
			}
			
			else {
				toSendKeys(wbElement.get(i), excelList.get(i));
			}
			
		}
		
		toClickBtn(saveBtnPress);
			
	}
	
	public String getCartDetais() {
		String text = toGetTextFromWebpage(cartTxt);
	    return text;
	}
	
	
	
	
}
