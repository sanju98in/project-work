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
  }

  public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
  }


  public void beforeAlertAccept(WebDriver driver) {
  }

  public void afterAlertAccept(WebDriver driver) {
    log("Alert Accepted");
  }

  public void afterAlertDismiss(WebDriver driver) {
    log("Alert Dismissed");
  }

  public void beforeAlertDismiss(WebDriver driver) {
  }

  public void beforeNavigateTo(String url, WebDriver driver) {
  }

  public void afterNavigateTo(String url, WebDriver driver) {
  }

  public void beforeNavigateBack(WebDriver driver) {
  }

  public void afterNavigateBack(WebDriver driver) {
  }

  public void beforeNavigateForward(WebDriver driver) {
  }

  public void afterNavigateForward(WebDriver driver) {
  }

  public void beforeNavigateRefresh(WebDriver driver) {
  }

  public void afterNavigateRefresh(WebDriver driver) {
  }

  public void beforeFindBy(By by, WebElement element, WebDriver driver) {
  }

  public void afterFindBy(By by, WebElement element, WebDriver driver) {
  }

  public void beforeClickOn(WebElement element, WebDriver driver) {
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
