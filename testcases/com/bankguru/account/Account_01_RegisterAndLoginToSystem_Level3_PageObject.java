package com.bankguru.account;

import org.testng.annotations.Test;

import PageObjects.HomePageObject;
import PageObjects.LoginPageObject;
import PageObjects.RegisterPageObject;
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

public class Account_01_RegisterAndLoginToSystem_Level3_PageObject extends AbstractTest {
	private WebDriver driver;
	private String email, userID, password, loginUrl;

	private HomePageObject homePage;
	private LoginPageObject loginPage ; 
	private RegisterPageObject registerPage;
	 @Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		 driver = openMultiBrowser(browserName);
		System.out.println("driver in test case:" +driver);
		email= "seleniumonline"+randomNumber()+"@gmail.com";
		loginPage = new LoginPageObject(driver);
		registerPage = new RegisterPageObject(driver);
	  }
	
 
	 @Test
	  public void TC_01_RegisterToSystem() {
		 loginUrl = loginPage.getLoginURL();
		 loginPage.clickToHereLink();
		 registerPage = new RegisterPageObject(driver);
		 registerPage.inputToEmailIDTextbox(email);
		 registerPage.clickToSubmitButton();
		 userID = registerPage.getUserIDText();
		 System.out.println("id" + userID);
		 password =registerPage.getPasswordText();
		 System.out.println("id" + password);
		// registerPage.openLoginPage(loginUrl);
				 
	  }
	
  @Test
  public void TC_02_LoginWithAboveInformation() {
	 registerPage.openLoginPage(loginUrl);
	  
	 //Open login url -? vaof loginpage lai
	  loginPage = new LoginPageObject(driver);
	  loginPage.inputToUserIDTextBox(userID);
	  loginPage.inputToPasswordTextBox(password);
	  loginPage.clickToLoginButton();
	  
	  //click button -> vaa trang homepage
	  homePage = new HomePageObject(driver);
	  Assert.assertTrue(homePage.isHomePageDisplayed());
  
  }
  

  @AfterClass
  public void afterClass() {
	
  }
  
  public int randomNumber() {
	  Random random = new Random();
	  int number = random.nextInt(999999);
	  return number;
  }

}
