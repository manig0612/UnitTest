package com.screenunit;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenFromJunit {
	
	static WebDriver driver;
	
	@BeforeClass
	public static void beforeClass() {
		
		driver = new ChromeDriver();
		driver.get("https://www.omrbranch.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
	}
	@Test
	public void login() {
		WebElement emailTxt = driver.findElement(By.id("email"));
		emailTxt.sendKeys("manikandang0612@gmail.com");
		
		WebElement passTxt = driver.findElement(By.id("pass"));
		passTxt.sendKeys("Mani@gmail.com");
		
		WebElement loginBtn = driver.findElement(By.xpath("//button[text() = 'Login']"));
		loginBtn.click();
			
	}
	
	@After
	public void afterMethod() throws IOException {
		TakesScreenshot screshot = (TakesScreenshot) driver;
		File screenshotAs = screshot.getScreenshotAs(OutputType.FILE);
		
		File file = new File("C:\\Users\\Cyntexia\\eclipse-workspace\\ScreeshotJUnit\\Screenshots\\afterlogin.png");
		FileUtils.copyFile(screenshotAs, file);
		
	}
	
	@Before
	public void beforeMethod() throws IOException {
		TakesScreenshot screshot = (TakesScreenshot) driver;
		File screenshotAs = screshot.getScreenshotAs(OutputType.FILE);
		
		File file = new File("C:\\Users\\Cyntexia\\eclipse-workspace\\ScreeshotJUnit\\Screenshots\\beforelogin.png");
		FileUtils.copyFile(screenshotAs, file);
			
	}
	
	@AfterClass
	public static void afterClass() {
		driver.close();
	}
	
 
}
