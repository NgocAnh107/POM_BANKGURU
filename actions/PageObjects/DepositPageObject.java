package PageObjects;

import org.openqa.selenium.WebDriver;

import PageUI.DepositPageUI;

import commons.AbstractPage;

public class DepositPageObject extends AbstractPage {
	WebDriver driver;
	public DepositPageObject(WebDriver driverMapping) {
		driver = driverMapping;
		
	}
	public boolean isDepositDisplay() {
		waitToElementVisible(driver, DepositPageUI.DEPOSIT_TEXT);
		return isControlDisplay(driver, DepositPageUI.DEPOSIT_TEXT);
	}

}
