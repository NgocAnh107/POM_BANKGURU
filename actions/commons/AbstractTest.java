package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbstractTest {
	private WebDriver driver;
	
	public WebDriver openMultiBrowser(String browserName  ) {
		if(browserName.equals("firefox")) {
			 driver = new FirefoxDriver();
		 }else  if(browserName.equals("chrome")) {
			 System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
			 driver = new ChromeDriver();
		 
		 }else if(browserName.equals("chromeheadless")){
			 ChromeOptions options = new ChromeOptions();
			 options.addArguments("headless");
			 options.addArguments("window-size=1366x768");
			 driver = new ChromeDriver(options);
		 }
		driver.get(Constants.DEV_URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver; // để map với driver bên testcase
	}

}
