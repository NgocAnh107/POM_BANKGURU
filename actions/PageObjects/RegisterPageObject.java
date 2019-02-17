package PageObjects;

import org.openqa.selenium.WebDriver;

import com.sun.jna.platform.win32.OpenGL32Util;

import PageUI.RegisterPageUI;
import commons.AbstractPage;

public class RegisterPageObject extends AbstractPage{
	WebDriver driver ;
	
	public RegisterPageObject(WebDriver driverMapping) {
		driver = driverMapping;
	
		
	} // hàm khởi tạo( luôn luôn đc chạy đầu tiên trong class)
	
	public void inputToEmailIDTextbox(String email) {
		waitToElementVisible(driver,RegisterPageUI.EMAILID_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.EMAILID_TEXTBOX, email);
	
	}
	public void clickToSubmitButton() {
		waitToElementVisible(driver,RegisterPageUI.SUBMIT_BUTTON);
		clickButton(driver, RegisterPageUI.SUBMIT_BUTTON);
	}
	public String getUserIDText() {
		waitToElementVisible(driver,RegisterPageUI.USER_ID_TEXT);
		return getTextElement(driver, RegisterPageUI.USER_ID_TEXT);
	}
	
	public String getPasswordText() {
		waitToElementVisible(driver,RegisterPageUI.PASSWORD_TEXT);
		return getTextElement(driver, RegisterPageUI.PASSWORD_TEXT);
	}
	public LoginPageObject openLoginPage(String loginPageUrl) {
		getURL(driver, loginPageUrl);
		return PageFactoryManager.getLoginPage(driver);
	}

}
