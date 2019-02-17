package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.DepositPageObject;
import PageObjects.NewAccountPageObject;
import PageObjects.NewCustomerPageObject;
import PageObjects.PageFactoryManager;
import PageUI.AbstractPageUI;
import PageUI.HomePageUI;
import PageUI.NewAccountPageUI;
import PageUI.NewCustomerPageUI;

public class AbstractPage {
	
	//------WEB BROWSER------------
	public void getURL(WebDriver driver, String url) {
		driver.get(url);
	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();

	}

	public String getCurrentURL(WebDriver driver) {

		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();

	}

	public void back(WebDriver driver) {
		driver.navigate().back();
	}

	public void forward(WebDriver driver) {
		driver.navigate().forward();
		
	}

	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void acceptAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void cancelAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
	public void waitUntilAlertPresence(WebDriver driver) {
		WebDriverWait waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.alertIsPresent());
	}
	
	//------WEB ELEMENT------------
	
	public void clickButton(WebDriver driver, String locator) {
		driver.findElement(By.xpath(locator)).click();
	}
	public void clickToElement(WebDriver driver, String locator) {
		driver.findElement(By.xpath(locator)).click();
	}

	
	public void senkeyToElement(WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);
		
	}
	public void selectItemInHtmlDropdown(WebDriver driver, String locator, String valueDropdown) {
		WebElement element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		select.selectByVisibleText(valueDropdown);
	}
	
	public String getItemInHtmlDropdown(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}
	
	public void selectItemCustumDropdown(WebDriver driver, String scrollToXpath, String parentList,String childXpath, String expectItem ) throws InterruptedException{
		WebDriverWait waitExplicit = new WebDriverWait(driver, 30);
		JavascriptExecutor javaExecutor = (JavascriptExecutor) driver;
		
		//Scroll tới element cha
		javaExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(scrollToXpath)));
		Thread.sleep(1000);

		//Click vào dropdown
		WebElement element = driver.findElement(By.xpath(parentList));
		element.click();
		Thread.sleep(1000);
		//Get tất cả item trong dropdown vào 1 list element (List <WebElement>)
		List<WebElement> childList = driver.findElements(By.xpath(childXpath));
		
		//Wait để tất cả phần tử trong dropdown được hiển thị
		waitExplicit.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(childXpath))));
		
		//Dùng vòng lặp for duyệt qua từng phần tử sau đó getText
		for(WebElement child:childList) {
			String textItem = child.getText().trim(); //trim(): Xóa các ký tự trắng, tab,.. ở đầu và ở cuối
			System.out.println("Text in dropdown= " +textItem);
			
		//	Nếu actual text = expected text thì click vào phần tử đó và break khỏi vòng lặp

			if(textItem.equals(expectItem)) {
				//scroll tới expecteed item để click 
				javaExecutor.executeScript("arguments[0].scrollIntoView(true);", child);
				child.click();
				Thread.sleep(1000);
				break;
			}
		}
	}
	public String getAttributeValue(WebDriver driver, String locator , String attributeValue) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attributeValue);
		
	}
	 public String getTextElement(WebDriver driver, String locator) {
			WebElement element = driver.findElement(By.xpath(locator));
		 return element.getText();
	 }
	 
	 
	 public int countElementNumber(WebDriver driver, String locator) {
		List<WebElement>  element = driver.findElements(By.xpath(locator));
		 return element.size();
	 }
	 
	 public void checkTheRadio(WebDriver driver, String locator){
		 WebElement element = driver.findElement(By.xpath(locator));
	     if(!element.isSelected()) {
	    	 element.click();
	     }
	 
	 }
	 
	 public void uncheckTheRadio(WebDriver driver, String locator){
		 WebElement element = driver.findElement(By.xpath(locator));
	     if(element.isSelected()) {
	    	 element.click();
	     }
	 
	 }
	 public boolean isControlDisplay(WebDriver driver, String locator) {
		 WebElement element = driver.findElement(By.xpath(locator));
		 return element.isDisplayed();
	 }
	 
	 public boolean isControlEnable(WebDriver driver, String locator) {
		 WebElement element = driver.findElement(By.xpath(locator));
		 return element.isEnabled();
	 }
	 
	 public void switchToWindowByID(WebDriver driver, String parent) {
			//get ra tat ca cac windown dang co
	        Set<String> allWindows = driver.getWindowHandles();
	        //dung vong lap de kiem tra
	        for (String runWindow : allWindows) {
	        	System.out.println(runWindow);
	        	//moi lan duyet kiem tra dieu kien
	                    if (!runWindow.equals(parent)) {
	                                driver.switchTo().window(runWindow);
	                                break;
	                    }
	        }
	}
	 public void switchToWindowByTitle(WebDriver driver, String title) {
         Set<String> allWindows = driver.getWindowHandles();
         //Dùng vòng lặp kiểm tra tất cả cửa sổ đang có
         for (String runWindows : allWindows) {
         	//switch qua từng cửa sổ trc sau đó ktra
                     driver.switchTo().window(runWindows);
                     //get ra title của page ms switch
                     String currentWin = driver.getTitle();
                     //Kiểm tra neesu title of page = title truyền vào
                     if (currentWin.equals(title)) {
                                 break;
                     }
         }
}
	 public void closeAllWithoutParentWindows(WebDriver driver, String parentWindow) {
	    	//get ra ID cua tat ca cac cua so
	                Set<String> allWindows = driver.getWindowHandles();
	                //dung vong lap duyet qua tat ca ID
	                for (String runWindows : allWindows) {
	                            if (!runWindows.equals(parentWindow)) {
	                                        driver.switchTo().window(runWindows);
	                                        driver.close();
	                            }
	                }
	                driver.switchTo().window(parentWindow);
	               
	    }
	 
	 
	 public void clickElementByJavascript(WebDriver driver, String locator) {
		 WebElement element = driver.findElement(By.xpath(locator));
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].click();", element);
		}
	 
	 
	 public void switchToIframe(WebDriver driver, String locator) {
		 List<WebElement> elements = driver.findElements(By.xpath(locator));
		 if(elements.size()>0) {
			 driver.switchTo().frame(elements.get(0));
			 driver.switchTo().defaultContent();
		 }
		}
	 
	 
	 public boolean isImageDisplayed(WebDriver driver, String locator) {
		  try {
		   WebElement element = driver.findElement(By.xpath(locator));
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   return (boolean) js.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", element);
		  } catch (Exception e) {
		   e.getMessage();
		   return false;
		  }
		 }
	 
	  public Object navigateToUrlByJS(WebDriver driver, String url) {
	        try {
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            return js.executeScript("window.location = '" + url + "'");
	        } catch (Exception e) {
	            e.getMessage();
	            return null;
	        }
	    }
	//18
	public void waitToElementVisible(WebDriver driver, String locator) {
		By byLocator = By.xpath(locator);
		WebDriverWait waitEplixit = new WebDriverWait(driver, 30);
		waitEplixit.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
		
	}
	public void waitToElementPresence(WebDriver driver, String locator) {
		By byLocator = By.xpath(locator);
		WebDriverWait waitEplixit = new WebDriverWait(driver, 30);
		waitEplixit.until(ExpectedConditions.presenceOfElementLocated(byLocator));
	}
	public void waitToElementInvisible(WebDriver driver, String locator) {
		By byLocator = By.xpath(locator);
		WebDriverWait waitEplixit = new WebDriverWait(driver, 30);
		waitEplixit.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));	
	}
	
	public NewCustomerPageObject openNewCustomerPage(WebDriver driver) {
		waitToElementVisible(driver, AbstractPageUI.NEW_CUSTOMER_LINK);
		clickButton(driver, AbstractPageUI.NEW_CUSTOMER_LINK);
		return PageFactoryManager.getNewCustomerPage(driver);
	}
	
	public NewAccountPageObject openNewAccountPage(WebDriver driver) {
		waitToElementVisible(driver, AbstractPageUI.NEW_ACCOUNT_LINK);
		clickButton(driver, AbstractPageUI.NEW_ACCOUNT_LINK);
		return PageFactoryManager.getNewAccountPage(driver);
	}
	public DepositPageObject openDepositPage(WebDriver driver) {
		waitToElementVisible(driver, AbstractPageUI.NEW_DEPOSIT_LINK);
		clickToElement(driver, AbstractPageUI.NEW_DEPOSIT_LINK);
		return PageFactoryManager.getDepositPage(driver);
	}
	public void waitToElementVisible(WebDriver driver, String locator, String...dynamicValue ) {
		locator = String.format(locator, (Object[]) dynamicValue);
		By byLocator = By.xpath(locator);
		WebDriverWait waitEplixit = new WebDriverWait(driver, 30);
		waitEplixit.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
		
	}
	private void clickButton(WebDriver driver, String locator, String... dynamicValue) {
		locator = String.format(locator, (Object[]) dynamicValue);		
		driver.findElement(By.xpath(locator)).click();
		
	}
	 //dynamiclocator
	 public AbstractPage openDynamicPage(WebDriver driver, String pageName) {
		 waitToElementVisible(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
			clickButton(driver, AbstractPageUI.DYNAMIC_LINK , pageName);
			switch(pageName) {
			case "New Customer":
				return PageFactoryManager.getNewCustomerPage(driver);
			case "Account Customer":
				return PageFactoryManager.getNewAccountPage(driver);
			case "Deposit":
				return PageFactoryManager.getDepositPage(driver);
			default:
				return PageFactoryManager.getHomePage(driver);
			}
	 
	 }

	



}
