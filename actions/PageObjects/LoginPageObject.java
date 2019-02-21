package PageObjects;

import org.openqa.selenium.WebDriver;

import PageUI.LoginPageUI;
import commons.AbstractPage;

public class LoginPageObject extends AbstractPage {
	WebDriver driver ;
	
	public LoginPageObject(WebDriver driverMapping) {
		driver = driverMapping;
		System.out.println("driver in logiPageObject:" + driver);
		
	} // hàm khởi tạo( luôn luôn đc chạy đầu tiên trong class)
	
	public void inputToUserIDTextBox(String userID) {
		waitToElementVisible(driver, LoginPageUI.USERID_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.USERID_TEXTBOX, userID);
	}
	
	
   public void inputToPasswordTextBox(String pass) {
	   waitToElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, pass);
	}
   
   public HomePageObject clickToLoginButton() {
	   waitToElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
	   clickButton(driver, LoginPageUI.LOGIN_BUTTON);
	   return PageFactoryManager.getHomePage(driver);
	}
   
   public RegisterPageObject clickToHereLink() {
	   waitToElementVisible(driver, LoginPageUI.HERE_LINK);
	   clickButton(driver, LoginPageUI.HERE_LINK);
		return PageFactoryManager.getRegisterPage(driver);
  	}
   public String getLoginURL() {
	   return getCurrentURL(driver);
   }

}
