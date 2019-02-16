package com.bankguru.account;

import org.testng.annotations.Test;



import commons.AbstractPage;
import commons.AbstractTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Account_01_RegisterAndLoginToSystem_Level2_ApplyAbstractPage extends AbstractTest {
	private WebDriver driver;
	private String email, userID, password, loginUrl;
	 AbstractPage abstractPage;
	
	 
	 @Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		 driver = openMultiBrowser(browserName);
		abstractPage = new AbstractPage();
		email= "seleniumonline"+randomNumber()+"@gmail.com";
	  }
	
 /* @Test
  public void TC_01_RegisterToSystem() {
	  driver.get("http://demo.guru99.com/v4/index.php");
	  
	  loginUrl = driver.getCurrentUrl();
	  
	  driver.findElement(By.xpath("//a[text()='here']")).click();
	  Assert.assertTrue(driver.findElement(By.xpath("//input[@name='emailid']")).isDisplayed());
	  driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);
	  driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	  userID= driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
	  password= driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
  
  }
  */
	 @Test
	  public void TC_01_RegisterToSystem() {
		 // driver.get("http://demo.guru99.com/v4/index.php");
		  abstractPage.getURL(driver, "http://demo.guru99.com/v4/index.php");
		  
		  loginUrl = abstractPage.getCurrentURL(driver);
		  abstractPage.clickButton(driver, "//a[text()='here']");
		 // driver.findElement(By.xpath("//a[text()='here']")).click();
		 // Assert.assertTrue(driver.findElement(By.xpath("//input[@name='emailid']")).isDisplayed());
		  Assert.assertTrue(abstractPage.isControlDisplay(driver, "//input[@name='emailid']"));
		  abstractPage.senkeyToElement(driver, "//input[@name='emailid']", email);
		//  driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);
		  
		  abstractPage.clickButton(driver, "//input[@name='btnLogin']");
		//  driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		//  userID= driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		  userID= abstractPage.getTextElement(driver, "//td[text()='User ID :']/following-sibling::td");
		 // password= driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
		  password=  abstractPage.getTextElement(driver, "//td[text()='Password :']/following-sibling::td");
	  }
	
  @Test
  public void TC_02_LoginWithAboveInformation() {
	  driver.get(loginUrl);
	  
	  driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userID);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	  driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	  
	  Assert.assertTrue(driver.findElement(By.xpath("//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]")).isDisplayed());
	  Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Manger Id : "+ userID+"']")).isDisplayed());
	  
	  
  }
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  public int randomNumber() {
	  Random random = new Random();
	  int number = random.nextInt(999999);
	  return number;
  }

}
