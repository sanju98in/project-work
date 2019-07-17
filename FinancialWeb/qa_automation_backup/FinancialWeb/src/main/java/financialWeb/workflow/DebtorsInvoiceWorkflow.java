package financialWeb.workflow;

import java.io.FileNotFoundException;
import financialWeb.pages.DebtorsInvoice;
import financialWeb.pages.DebtorsAuthorise;
import financialWeb.pages.DebtorsVouchers;
import util.GenUtil;

public class DebtorsInvoiceWorkflow extends CommonWorkflow{

  static DebtorsInvoice objDebtorsInvoice;
 static DebtorsAuthorise objDebtorsAuthorise;
  
  public static void validateDBInvoiceAuthorizeStatus(String expected) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDebtorsVouchers = new DebtorsVouchers(driver);
    String actuals = DebtorsInvoice.getDBInvoiceStatus();
    if(actuals.equalsIgnoreCase(expected)) {
      log.info(KEYWORD_PASS + " Status is " + expected);
      }
      else {
        log.info(KEYWORD_FAIL + " Status is not "+ expected);
      }
  }
  
  public static void validatetxtDBInvoiceGLCode(String vatcode) throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorsVouchers = new DebtorsVouchers(driver);
    verifyTextAttribute(DebtorsInvoice.txtDBInvoiceGLCode,vatcode);
 }
  public static void setDBAuthTransactionDebtorNumber(String data) throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorsAuthorise = new  DebtorsAuthorise(driver);
    waitforPanelElement(DebtorsAuthorise.txtDebtorNumber);
    DebtorsAuthorise.setDBAuthorizreDebtorNumber(data);
  }

 public static void setDBAuthTransactionReferenceOne(String data) throws FileNotFoundException {
    DebtorsAuthorise.setDBAuthorizeReferneceOne(data);
  }
 
 public static void setDBInvoiceStatus(String data) throws FileNotFoundException, InterruptedException {
   DebtorsInvoice.setDBInvoiceStatus(data);
 }
 
  public static void selectAuthorize() throws FileNotFoundException, InterruptedException {
    DebtorsAuthorise.selectCheckboxAuthorize();
  }
  
  public String createDBInvoice() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDebtorsVouchers = new DebtorsVouchers(driver);
    objDebtorsInvoice = new DebtorsInvoice(driver);
    waitforPanelLoad();
    searchText(testdataprop.getProperty("searchdbvouchers"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchdbvouchers"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchcdbinvoice"));
    waitforPanelLoad();
    DebtorsVouchersWorkflow.setTransactionCode(testdataprop.getProperty("inv001transactioncode"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    waitforPanelLoad();
    DebtorsVouchers.setDBInvoiceDebtorNumber(uniqueMaintenanceNumber);
    String currentDate = GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle=driver.getWindowHandle();
    DebtorsInvoice.setDBInvoiceTaxPoint();
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    DebtorsInvoice.setDBInvoiceGLDate();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addline"));
    DebtorsVouchersWorkflow.setDescription(testdataprop.getProperty("comment"));
    DebtorsVouchersWorkflow.setDBCreditLineQty(testdataprop.getProperty("qty"));
    DebtorsVouchersWorkflow.setDBCreditLinePrice(testdataprop.getProperty("rndtelephonelimit"));
    DebtorsVouchersWorkflow.setDBCreditLineVat(testdataprop.getProperty("vtcode"));
    DebtorsInvoice.setGLCode(testdataprop.getProperty("glcode"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    waitforPanelElement(DebtorsInvoice.txtDBInvoiceAmount);
    amount = DebtorsVouchersWorkflow.getDBInvoiceAmount();
    DebtorsVouchersWorkflow.validateDBVoucherAmount(amount, testdataprop.getProperty("qty"),testdataprop.getProperty("rndtelephonelimit"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    referenceNo = DebtorsVouchersWorkflow.storeReferenceNo();
    return referenceNo;
  }
  
  public static void setDBInvoiceTaxPoint() throws Exception {
    waitforPanelLoad();
    objDebtorsInvoice = new DebtorsInvoice(driver);
    DebtorsInvoice.setDBInvoiceTaxPoint();
  }
  
  public static void setDBInvoiceGLDate() throws Exception {
    waitforPanelLoad();
    objDebtorsInvoice = new DebtorsInvoice(driver);
    DebtorsInvoice.setDBInvoiceGLDate();
  }
  
  public static void setGLCode(String data) throws Exception {
    waitforPanelLoad();
    objDebtorsInvoice = new DebtorsInvoice(driver);
    DebtorsInvoice.setGLCode(data);
  }
 
  public static String getGLCode() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDebtorsInvoice = new DebtorsInvoice(driver);
    return DebtorsInvoice.getGLCode();
  }

  public static String getDBInvoiceAmount() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDebtorsInvoice = new DebtorsInvoice(driver);
    waitforPanelElement(DebtorsInvoice.txtDBInvoiceAmount);
    return DebtorsVouchersWorkflow.getDBInvoiceAmount();
    }
}//end of class