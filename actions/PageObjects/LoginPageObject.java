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
		senkeyToElement(driver, LoginPageUI.USERID_TEXTBOX, pass);
	}
   
   public void clickToLoginButton() {
	   waitToElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
	   clickButton(driver, LoginPageUI.LOGIN_BUTTON);
	}
   
   public void clickToHereLink() {
	   waitToElementVisible(driver, LoginPageUI.HERE_LINK);
	   clickButton(driver, LoginPageUI.HERE_LINK);
		
  	}
   public String getLoginURL() {
	   return getCurrentURL(driver);
   }

}
