package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WebEventListener extends TestBase implements WebDriverEventListener {

	/*This method will log all the items that are mentioned in each of the event
	 * This will reduce the overhead of adding loggers in each and every step in test
	 * method as well as Page Factory classes*/
  
  public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
    //TestBase.log("Value of the WebElement " + element.toString() + " before any changes: " + element.getText());

  }

public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
    //TestBase.log("Value changed to " + element.toString());

}


	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		log("Alert Accepted");

	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		log("Alert Dismissed");

	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		//TestBase.log("Before Navigate to :" + url);

	}

	public void afterNavigateTo(String url, WebDriver driver) {
		//TestBase.log("After Navigate to :" + url);

	}

	public void beforeNavigateBack(WebDriver driver) {
		//TestBase.log("Navigating back to previous page");

	}

	public void afterNavigateBack(WebDriver driver) {
		//TestBase.log("Navigated back to previous page");

	}

	public void beforeNavigateForward(WebDriver driver) {
		//TestBase.log("Navigating forward to next page");

	}

	public void afterNavigateForward(WebDriver driver) {
	//	TestBase.log("Navigated forward to next page");

	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		//log("Trying to find element " + by.toString() );
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		//log("Found element" + by.toString());

	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		log("Clicked On: " + element.toString());
	}


	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
	}

	public void onException(Throwable throwable, WebDriver driver) {
		log("Exception Occured " + throwable);
	}
	
	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
	}

	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
	}

}
