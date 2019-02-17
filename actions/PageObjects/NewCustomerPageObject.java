package PageObjects;

import org.openqa.selenium.WebDriver;

import PageUI.NewCustomerPageUI;
import commons.AbstractPage;

public class NewCustomerPageObject extends AbstractPage{
	WebDriver driver;
	public NewCustomerPageObject(WebDriver driverMapping) {
		driver = driverMapping;
	}

	public boolean isNewCustomerPageDisplay() {
		waitToElementVisible(driver, NewCustomerPageUI.NEW_CUSTOMER_TEXT);
		return isControlDisplay(driver, NewCustomerPageUI.NEW_CUSTOMER_TEXT);
	}
	
	public NewAccountPageObject openNewAccountPage() {
		waitToElementVisible(driver, NewCustomerPageUI.NEW_ACCOUNT_LINK);
		clickButton(driver, NewCustomerPageUI.NEW_ACCOUNT_LINK);
		return PageFactoryManager.getNewAccountPage(driver);
	}

}
