package financialWeb.workflow;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import financialWeb.pages.DebtorVouchersSalesInvoices;
import util.GenUtil;

public class DebtorVouchersSalesInvoicesWorkflow extends CommonWorkflow{
  
 static DebtorVouchersSalesInvoices objDebtorVouchersSalesInvoices;
 private static ArrayList<String> arrayList;
 

  public static void setFrequency(String data) throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    //objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    //waitforPanelElement(DebtorVouchersSalesInvoices.drpdnFrequency);
    //DebtorVouchersSalesInvoices.setDrpdnFrequency(data);
    selectRandomWebElementDrpDwn(msgprop.getProperty("lblfrequency"), data);
  }
  public static void setPIMFrequency(String data) throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    waitforPanelElement(DebtorVouchersSalesInvoices.drpdnPIMFrequency);
    DebtorVouchersSalesInvoices.setDrpdnPIMFrequency(data);
  }
  public static void setInvToGenerate(String data) throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    //objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    //DebtorVouchersSalesInvoices.setTxtInvToGenerate(data);
    setRandomWebElementValue(msgprop.getProperty("lblinvtogenerate"), data);
  }
  
  public static void setPIMInvToGenerate(String data) throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    DebtorVouchersSalesInvoices.setTxtPIMInvToGenerate(data);
  }
  
  public static void setTransactionCodePayment(String data) throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    DebtorVouchersSalesInvoices.setDrpdnTransactionCodePayment(data);
  }
  
  public static void setTransactionCodeWriteOff(String data) throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    DebtorVouchersSalesInvoices.setDrpdnTransactionCodeWriteOff(data);
  }
  
  public static void setReasonWriteOff(String data) throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    waitforPanelElement(DebtorVouchersSalesInvoices.drpdnReasonWriteOff);
    DebtorVouchersSalesInvoices.setDrpdnReasonWriteOff(data);
  }
  
  public static void setInvoiceNumber(String data) throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    DebtorVouchersSalesInvoices.setTxtInvoiceNumber(data);
  }
  
  public static void setEntryDate() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    waitforPanelElement(DebtorVouchersSalesInvoices.dtEntryDate);
    clickElement(DebtorVouchersSalesInvoices.dtEntryDate);
  }
  
  public static void setDebtorNumberForChargeCode(String data) throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    //objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    setRandomWebElementValue(msgprop.getProperty("lbldebtornumber"), data);
    //DebtorVouchersSalesInvoices.setTxtDebtorNumber(data);
  }
  
  public static void setTaxPointDate() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    DebtorVouchersSalesInvoices.setDtTaxPointDate();
  }
  
  public static void setGlDate() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    DebtorVouchersSalesInvoices.setDtGlDate();
  }
  
  public static void setInvoiceGlDate() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    DebtorVouchersSalesInvoices.setDtInvoiceGlDate();
  }
  
  public static void setTxtAddLineChargeCode(String data) throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    DebtorVouchersSalesInvoices.setTxtAddLineChargeCode(data);
  }
  
  public static String getAmount() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    return DebtorVouchersSalesInvoices.getTxtAmount();
  }
  
  public static void validateDBInvoiceAmount(String amount, String qty, String price) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    boolean found = validateAmount(amount, qty, price);
    if(found) {
     log.info(KEYWORD_PASS + " Amount matched " );
     highlightElement(DebtorVouchersSalesInvoices.txtAmount);
   }
  }
  
  public static void validateInvoiceStatus(String data) throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    DebtorVouchersSalesInvoices.getTxtInvoiceStatus(data);
  }
  
  public static void setMsgField(String data) throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    waitforPanelElement(DebtorVouchersSalesInvoices.txtMsg);
    DebtorVouchersSalesInvoices.setTxtMsg(data);
  }
  
  public static void clickDbNotesTab() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    DebtorVouchersSalesInvoices.setDbNotesTab();
  }
  
  public static void setInstalmentFrequency(String data) throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    DebtorVouchersSalesInvoices.setDrpdnInstalmentFrequency(data);
  }
  
  public static void clickBrowseAndUploadFile() throws InterruptedException, IOException, URISyntaxException {
    //objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    waitforPanelLoad();
    boolean found = false;
    switchToFrame(orprop.getProperty("uploadfileframe"));
    Thread.sleep(2000);
    WebElement btnBrowser=driver.findElement(By.xpath(orprop.getProperty("lblchoosefile")));
    found= IsExist(btnBrowser);
    if(found) {
      highlightElement(btnBrowser);
      click(btnBrowser);
    }
    
    uploadFile(envprop.getProperty("uploadexcelexternalfile"));
    clickUpload();
    waitforPanelLoad();
  }
  
  public static void clickUpload() throws InterruptedException, FileNotFoundException {
    Thread.sleep(2000);
    //objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    WebElement btnUpload=driver.findElement(By.xpath(orprop.getProperty("lblbuttonupload")));
    boolean found = IsExist(btnUpload);
    if(found) {
      btnUpload.click();
      Thread.sleep(2000);
    }
    switchToParentWindow(parentHandle);
    Thread.sleep(2000);
  }  
  
  public static void setNextDate() throws FileNotFoundException, InterruptedException {
    //waitforPanelLoad();
    Thread.sleep(2000);
    objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    String futureDate = GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("nextdate"));
    switchToFrame(orprop.getProperty("dateframe"));
      //waitforPanelLoad();
      dateTimePicker(futureDate,DebtorVouchersSalesInvoices.calDateClass,DebtorVouchersSalesInvoices.calDrpDnMonth,DebtorVouchersSalesInvoices.calDrpDnYear);
  }
  
  public static void setEndDate() throws FileNotFoundException, InterruptedException {
    boolean foundCalendar = DebtorVouchersSalesInvoices.Calendarclass.isDisplayed();
    if(foundCalendar) {
      String EndDate = GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("enddate"));
      switchToFrame(orprop.getProperty("dateframe"));
      dateTimePicker(EndDate,DebtorVouchersSalesInvoices.calEndDateClass,DebtorVouchersSalesInvoices.calDrpDnMonth,DebtorVouchersSalesInvoices.calDrpDnYear);
    }  
  } 
  
  public static void setCommentForPIM(String data) throws InterruptedException, FileNotFoundException {
    //waitforPanelLoad();
    setRandomWebElementValue(msgprop.getProperty("lblcomments"), data);
   // objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
   // DebtorVouchersSalesInvoices.setTxtCommentForPIM(data);
  } 
  
  public static String getCommentForPIM() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    return DebtorVouchersSalesInvoices.getTxtCommentForPIM();
  } 
  
  public static void setNoOfInstalments(String data) throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    DebtorVouchersSalesInvoices.setTxtNoOfInstalments(data);
  } 
  
  public static void validateDueDate(String table) {
    List<WebElement> myTable = driver.findElements(By.xpath(table));
    validateSortedCountsForDueDate(myTable);   
  }
  
  public static void validateSortedCountsForDueDate(List<WebElement> myTable) {
    ArrayList<String> list = new ArrayList<String>();
    for(WebElement el:myTable) {
        list.add(el.getAttribute("value"));
    }
    SortArrayListAscendingDescending (list);
    ArrayList<String> unsortedArrayList = getArrayList();         
    log.info("Unsorted ArrayList: " + unsortedArrayList);         
    ArrayList<String> sortedArrayListAscending = sortAscending();         
    log.info("Sorted ArrayList in Ascending Order : " + sortedArrayListAscending);         
    if(unsortedArrayList.equals(sortedArrayListAscending)) {
      log.info(KEYWORD_PASS + " List data is sorted in Ascending order");
    }else {
      log.info( KEYWORD_FAIL +" List data is not sorted in Ascending order");
    }
    
  }
  public static void SortArrayListAscendingDescending(ArrayList<String> list) {         
    arrayList = list;     
  } 
  
  public static ArrayList<String> getArrayList() {         
    return arrayList;     
  }   
  
  public static ArrayList<String> sortAscending() {         
    Collections.sort(arrayList);         
    return arrayList;
  }       
  public static ArrayList<String> sortDescending() {         
    Collections.sort(arrayList, Collections.reverseOrder());         
    return arrayList;     
  } 
  
  public static void clickDbInvoiceTab() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    DebtorVouchersSalesInvoices.dbInvoiceTab.click();
  } 
  
  public static void validateInstallmentStatus(String expected) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    waitforPanelElement(DebtorVouchersSalesInvoices.txtInstalmentStatus);
    String actuals = DebtorVouchersSalesInvoices.getTxtInstalmentStatus();
    if(actuals.equalsIgnoreCase(expected)) {
      highlightElement(DebtorVouchersSalesInvoices.txtInstalmentStatus);
      log.info(KEYWORD_PASS + " Status is " + actuals);
      }
      else {
        log.info(KEYWORD_FAIL + " Status is " + actuals);
      }
  }  
  public static void setNewDept(String data) throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    waitforPanelElement(DebtorVouchersSalesInvoices.drpdnNewDept);
    DebtorVouchersSalesInvoices.setDrpdnNewDept(data);
  } 
  
  public static String getSection() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    return DebtorVouchersSalesInvoices.getDrpdnSection();
  } 
  
  public static String getInvoiceSection() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    return DebtorVouchersSalesInvoices.getDrpdnInvoiceSection();
  } 
  
  public static String getNewDept() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    waitforPanelElement(DebtorVouchersSalesInvoices.drpdnNewDeptTransfer);
    return DebtorVouchersSalesInvoices.getdrpdnNewDeptTransfer();
  }
 
}
