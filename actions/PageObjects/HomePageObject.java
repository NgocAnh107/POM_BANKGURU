package PageObjects;

import org.openqa.selenium.WebDriver;

import PageUI.HomePageUI;
import commons.AbstractPage;

public class HomePageObject extends AbstractPage {
	WebDriver driver;
	
	public HomePageObject(WebDriver driverMapping) {
		driver = driverMapping;
	System.out.println("driver in homePageObject:" + driver);
		
	} // hàm khởi tạo( luôn luôn đc chạy đầu tiên trong class)
	
	public boolean isHomePageDisplayed() {
		waitToElementVisible(driver, HomePageUI.HOMEPAGE_WELLCOME_MESSAGE);
		return isControlDisplay(driver, HomePageUI.HOMEPAGE_WELLCOME_MESSAGE);
	}
}
