package PageObjects;

import org.openqa.selenium.WebDriver;

import PageUI.NewAccountPageUI;
import PageUI.NewCustomerPageUI;
import commons.AbstractPage;

public class NewAccountPageObject extends AbstractPage {
		WebDriver driver ;
	public NewAccountPageObject(WebDriver driverMapping) {
		driver = driverMapping;
	}

	public boolean isNewAccountPageDisplay() {
		waitToElementVisible(driver, NewAccountPageUI.NEW_ACCOUNT_TEXT);
		return isControlDisplay(driver, NewAccountPageUI.NEW_ACCOUNT_TEXT);
	}


}
