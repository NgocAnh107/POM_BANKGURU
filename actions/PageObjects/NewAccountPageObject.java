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
		waitToElementVisible(driver, NewCustomerPageUI.NEW_CUSTOMER_TEXT);
		return isControlDisplay(driver, NewCustomerPageUI.NEW_CUSTOMER_TEXT);
	}
	public DepositPageObject openDepositPage() {
		waitToElementVisible(driver, NewAccountPageUI.NEW_DEPOSIT_LINK);
		clickToElement(driver, NewAccountPageUI.NEW_DEPOSIT_LINK);
		return PageFactoryManager.getDepositPage(driver);
	}
}
