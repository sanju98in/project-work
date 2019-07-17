package financialWeb.workflow;

import java.io.FileNotFoundException;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import financialWeb.pages.DebtorAdjustments;
import financialWeb.pages.FinancialWebHomepage;
import util.GenUtil;

public class DebtorAdjustmentsWorkflow extends CommonWorkflow {


  public static void verifyLabelName(String... labelname)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    boolean found = false;
    for (int i = 0; i < labelname.length; i++) {
      String combinedString = orprop.getProperty("containspart1").trim() + labelname[i].trim()
          + orprop.getProperty("containspart2").trim();
      List<WebElement> findMe = driver.findElements(By.xpath(combinedString));
      for (WebElement myElement : findMe) {
        found = IsExist(myElement);
        if (found) {
          highlightElement(myElement);
          log.info(myElement.getText());
        }

      }
    }
  }

  public static void setAmount(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    
    setRandomWebElementText(msgprop.getProperty("lblamount"), data);
   /* objDebtorAdjustments = new DebtorAdjustments(driver);
    boolean found = IsExist(DebtorAdjustments.txtAmount);
    if (found) {
      setText(DebtorAdjustments.txtAmount, data);
    }
    waitforPanelLoad();*/
  }

  public static void setGLDate() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDebtorAdjustments = new DebtorAdjustments(driver);
    boolean found = IsExist(DebtorAdjustments.txtGLDate);
    if (found) {
      currentDate =
          GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
      parentHandle = driver.getWindowHandle();
      clickElement(DebtorAdjustments.txtGLDate);
      getHandles();
      DebtorsVouchersWorkflow.selectDate(currentDate, parentHandle,
          testdataprop.getProperty("todaydate"));
    }
    waitforPanelLoad();
  }

  public static void checkAuthrise(String debotorNo)
      throws FileNotFoundException, InterruptedException {
    DBReportsWorkflow.selectDBStyleCheckbox(debotorNo, orprop.getProperty("dbstylefield"));
  }

  public static void acceptAlertHandle(String btnName)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    try {
      callEvent(orprop.getProperty("button"), btnName);
    } catch (UnhandledAlertException f) {
      Alert alert = driver.switchTo().alert();
      alert.accept();
    } catch (NoAlertPresentException e) {
      log.info(e.getMessage());
    }
  }


  public static String getAdjustmentNumber(String uniqueDebtorNumber)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    searchText(testdataprop.getProperty("searchdbadjustments"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbadjustments"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchdbDBpaymentreversals"));
    verifyLabelName(msgprop.getProperty("lblreference1"), msgprop.getProperty("lblReference2"));
    selectRandomWebElementDrpDwn(msgprop.getProperty("lbltransactioncode"),
        testdataprop.getProperty("reversalpaymenttrancode"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    setRandomWebElementValue(msgprop.getProperty("lbldebtornumber"), uniqueDebtorNumber);
    verifyLabelName(msgprop.getProperty("lbladjustmentnumber"),
        msgprop.getProperty("lblpaymentnumber"));
    setAmount(testdataprop.getProperty("amount"));
    setGLDate();
    selectRandomWebElementDrpDwn(msgprop.getProperty("lblpaymentmethod"),
        testdataprop.getProperty("cashpaymentmethod"));
    selectRandomWebElementDrpDwn(msgprop.getProperty("lblreasoncode"),
        testdataprop.getProperty("refundreason"));
    setRandomWebElementValue(msgprop.getProperty("lblcomments"),
        testdataprop.getProperty("dbstylemaintenancecomments"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("save"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("complete"));
    String adjustmentNumber = getRandomWebElementValue(msgprop.getProperty("lbladjustmentnumber"));
    return adjustmentNumber;
  }

  public static void authoriseAdjustmentNo(String uniqueDebtorNumber, String adjustmentNumber)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    searchText(testdataprop.getProperty("searchdbauthorise"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbauthorisetrans"));
    setRandomWebElementValue(msgprop.getProperty("lbldebtornumber"), uniqueDebtorNumber);
    setRandomWebElementValue(msgprop.getProperty("lblreference1"), adjustmentNumber);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submit"));
    checkAuthrise(uniqueDebtorNumber);
    acceptAlertHandle(testdataprop.getProperty("authorise"));
    waitforPanelLoad();
  }

  public static void verifyAdjustmentNumber(String uniqueDebtorNumber, String adjustmentNumber)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    searchText(testdataprop.getProperty("searchdbadjustments"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbadjustments"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchdbDBpaymentreversals"));
    setRandomWebElementValue(msgprop.getProperty("lblreference1"), adjustmentNumber);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    validateRandomWebElementdrpdwn(msgprop.getProperty("lblstatus"),
        msgprop.getProperty("authorisedformatchingstatus"));
    waitforPanelLoad();
  }

  public static void clickReference1() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDebtorAdjustments = new DebtorAdjustments(driver);
    boolean found = IsExist(DebtorAdjustments.txtReference1Dot);
    if (found) {
      clickElement(DebtorAdjustments.txtReference1Dot);
    }
    waitforPanelLoad();
  }

  public static void clickTransactionFrom() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDebtorAdjustments = new DebtorAdjustments(driver);
    boolean found = IsExist(DebtorAdjustments.txtTransactionDateFrom);
    if (found) {
      clickElement(DebtorAdjustments.txtTransactionDateFrom);
    }
    waitforPanelLoad();
  }

  public static void clickTransactionTo() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDebtorAdjustments = new DebtorAdjustments(driver);
    boolean found = IsExist(DebtorAdjustments.txtTransactionDateTo);
    if (found) {
      clickElement(DebtorAdjustments.txtTransactionDateTo);
    }
    waitforPanelLoad();
  }

  public static void dbFindAdjustment(String debtorNumber, String adjustment)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    setRandomWebElementValue(msgprop.getProperty("lbldebtornumber"), debtorNumber);
    setRandomWebElementValue(msgprop.getProperty("lblreference1"), adjustment);
    String currentDate =
        GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle = driver.getWindowHandle();
    clickTransactionFrom();
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate, parentHandle,
        testdataprop.getProperty("todaydate"));
    clickTransactionTo();
    DebtorsVouchersWorkflow.selectDate(currentDate, parentHandle,
        testdataprop.getProperty("todaydate"));
    waitforPanelLoad();

  }
  protected static void switchToAlertClick(String table,String butName) throws FileNotFoundException, InterruptedException 
  {
    waitForPageLoad();
    parentHandle = driver.getWindowHandle();
    objFinWebHomePage = new FinancialWebHomepage(driver);
    boolean found = false;
    Thread.sleep(500);
    waitForElementDisappear();
    // waitForPageLoad();
    getHandles();
    List<WebElement> findButton = driver.findElements(By.xpath(table));
    for (WebElement myButton : findButton) {
      if (myButton.isDisplayed() && myButton.isEnabled()
          && myButton.getAttribute("value").trim().equalsIgnoreCase(butName.trim())) {
        found = findAndClickElementWithTextAttribute(myButton, butName);
        if (found) {
          found = waitForElementDisappear();
          if (found) {
            // waitForPageLoad();
            break;
          }
        }
      }
      if (found)
        break;
    }
    switchToParentWindow(parentHandle);
    // WaitForElementDisapper();
    waitforPanelLoad();
    Thread.sleep(1000);
    /*
     * waitforPanelLoad(); parentHandle = driver.getWindowHandle(); boolean found=true;
     * getHandles(); found = IsExist(button); if (found) { clickElement(button); found = false; } //
     * waitforPanelLoad(); switchToParentWindow(parentHandle); waitforPanelLoad();
     */
  }
  protected static void switchToAlertSelDrpdwn(WebElement drpdwnElement,String button) throws FileNotFoundException, InterruptedException 
  {
    waitforPanelLoad();
    parentHandle = driver.getWindowHandle();
    getHandles();
    boolean found=IsExist(drpdwnElement);
       if (found) {
     selectDropDown(drpdwnElement,button);
      found = false;
    }
    // waitforPanelLoad();
    switchToParentWindow(parentHandle);
    waitforPanelLoad();
  }

  protected static void setTextAlertbox(WebElement txtElement,String data) throws FileNotFoundException, InterruptedException 
  {
    waitforPanelLoad();
    parentHandle = driver.getWindowHandle();
    getHandles();
    boolean found=IsExist(txtElement);
       if (found) {
     setText(txtElement, data);
      found = false;
    }
    // waitforPanelLoad();
    switchToParentWindow(parentHandle);
    waitforPanelLoad();
  }
  public static void clickCancelPaymentReversal() throws FileNotFoundException, InterruptedException {
    switchToAlertClick(orprop.getProperty("button"), testdataprop.getProperty("cancelpaymentreversal"));
    switchToAlertSelDrpdwn(DebtorAdjustments.drpdwnPopupReason, testdataprop.getProperty("cancelreason"));
    setTextAlertbox(DebtorAdjustments.drpdwnPopupComments, testdataprop.getProperty("msgfieldforinvoice"));
    saveCancellation();
    switchToAlertClick(orprop.getProperty("button"), testdataprop.getProperty("close"));
  }

  public static void saveCancellation() throws InterruptedException {
    click(DebtorAdjustments.btnsavecancellation);
  }

  protected static void setFromDebtorShow(String data) throws FileNotFoundException, InterruptedException {
    objDebtorAdjustments = new DebtorAdjustments(driver);
    selectDropDown(DebtorAdjustments.drpdnFromDebtorShow, data);
  }
  
  public static void setReference1(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    setRandomWebElementValue(msgprop.getProperty("lblreference1"), data);
  }
  
  public static void setAllocatedAmount(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    Thread.sleep(2000);
    setText(getRandomWebElement(msgprop.getProperty("lblnewallocations"), orprop.getProperty("allocatedamount")),data);
   // setText(DebtorAdjustments.AllocatedAmt,data);
  }

protected static void setToDebtorShow(String data) throws FileNotFoundException, InterruptedException {
    objDebtorAdjustments = new DebtorAdjustments(driver);
    selectDropDown(DebtorAdjustments.drpdnToDebtorShow, data);
  }
  
  protected static void selectTidyFromDebtor() throws FileNotFoundException, InterruptedException {
    objDebtorAdjustments = new DebtorAdjustments(driver);
    clickElement(DebtorAdjustments.chkFromDebtorSelectForTidy);
  }
  
  protected static void selectTidyToDebtor() throws FileNotFoundException, InterruptedException {
    objDebtorAdjustments = new DebtorAdjustments(driver);
    clickElement(DebtorAdjustments.chkToDebtorSelectForTidy);
  }
    
  protected static void selectReverse() throws FileNotFoundException, InterruptedException {
    objDebtorAdjustments = new DebtorAdjustments(driver);
    for(WebElement reverse:DebtorAdjustments.chkReverse) {
      if(reverse.isDisplayed()) {
        clickElement(reverse);
      }
    }
  }
  
  protected static void setCrNoteTidyAmt(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    log.info("");
    objDebtorAdjustments = new DebtorAdjustments(driver);
    setText(DebtorAdjustments.txtCrNoteTidyAmt,data);
  }
  
  protected static void setInvoiceTidyAmt(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDebtorAdjustments = new DebtorAdjustments(driver);
    setText(DebtorAdjustments.txtInvoceTidyAmt,data);
  }
  
  protected static String getFromTidyReference() throws FileNotFoundException, InterruptedException {
    objDebtorAdjustments = new DebtorAdjustments(driver);
    String val= DebtorAdjustments.lblFromTidyReference.getText();
    return val;
  }
  
  protected static String getToTidyReference() throws FileNotFoundException, InterruptedException {
    objDebtorAdjustments = new DebtorAdjustments(driver);
    String val= DebtorAdjustments.lblToTidyReference.getText();
    return val;
  }
  
  protected static void validateBalance(String data) throws FileNotFoundException, InterruptedException {
    objDebtorAdjustments = new DebtorAdjustments(driver);
    for(WebElement reverse:DebtorAdjustments.lblReverse) {
        searchTableColumn(reverse, data);
    }
  }
  
  public static void selectTransDate(String data) throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    List<WebElement> dateList = driver.findElements(By.xpath(data));
    int size = dateList.size();
    for(int i=0;i<size;i++) {
      if(dateList.get(i).isDisplayed()) {
        parentHandle=driver.getWindowHandle();
        clickElement(dateList.get(i));
        getHandles();
        DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
        waitforPanelLoad();
      }
    }
    
  }
    // end of class
}
