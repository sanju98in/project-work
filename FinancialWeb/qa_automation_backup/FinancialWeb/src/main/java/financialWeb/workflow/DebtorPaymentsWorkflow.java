package financialWeb.workflow;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.StringTokenizer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import financialWeb.pages.DebtorMaintenance;
import financialWeb.pages.DebtorPayments;
import financialWeb.pages.DebtorsAuthorise;
import financialWeb.pages.DebtorsVouchers;
import util.GenUtil;

public class DebtorPaymentsWorkflow extends CommonWorkflow{

  static DebtorPayments objDebtorPayments;
  static CreditorMaintenanceWorkflow objCreditorMaintenanceWorkflow;
  static DebtorMaintenance objDebtorMaintenance;

  public static void createUnallocatedManualPayment(String uniqueMaintenanceNumber,String transcode,String lblRef1,String lblRef2,String updatedlblRef1,String updatedlblRef2,String amount,String paymentMethod,String comment,String status) throws FileNotFoundException, InterruptedException {
    objDebtorPayments = new DebtorPayments(driver);
    searchText(testdataprop.getProperty("searchdbpayments"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbpayments"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchdbmanualpayments"));
    waitforPanelLoad();
    validateMessage(DebtorPayments.lblForReferenceOne, lblRef1);
    String label = DebtorPayments.lblForReferenceTwo.getText();
    if(label.equalsIgnoreCase(lblRef2)) {
      highlightElement(DebtorPayments.lblForReferenceTwo);
      log.info(KEYWORD_PASS + "Find element ");
    }else {
      log.info(KEYWORD_FAIL + "Cannot find element ");
    }
    //DebtorPayments.setTransactionCode(transcode);
    selectRandomWebElementDrpDwn(msgprop.getProperty("lbltransactioncode"),
        transcode);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load")); 
    validateMessage(DebtorPayments.lblForReferenceOne, updatedlblRef1);
    label = DebtorPayments.lblForReferenceTwo.getText();
    if(label.equalsIgnoreCase(updatedlblRef2)) {
      highlightElement(DebtorPayments.lblForReferenceTwo);
      log.info(KEYWORD_PASS + "Find element ");
    }else {
      log.info(KEYWORD_FAIL + "Cannot find element ");
    }

    //DebtorPayments.setDebtorNumber(uniqueMaintenanceNumber);
    setRandomWebElementValue(msgprop.getProperty("lbldebtornumber"), uniqueMaintenanceNumber);
    //DebtorPayments.setAmount(amount);
    setRandomWebElementText(msgprop.getProperty("lblamount"), amount);
    String currentDate = GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle=driver.getWindowHandle();
   // DebtorPayments.clickDate();
    selectRandomWebElementCalendarImage(msgprop.getProperty("lbldate"));
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    //DebtorPayments.clickGLDate();
    selectRandomWebElementCalendarImage(msgprop.getProperty("lblgldate"));
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    //DebtorPayments.setPaymentMethod(paymentMethod);
    selectRandomWebElementDrpDwn(msgprop.getProperty("lblpaymentmethod"),
        paymentMethod);
   // DebtorPayments.setComment(comment);
    setRandomWebElementValue(msgprop.getProperty("lblcomments"), comment);
    
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    paymentNo = getRandomWebElementValue(msgprop.getProperty("updatedreferenceone"));
    dbPaymentNo= paymentNo;
    //alternatePaymentNo = DebtorPayments.getReferenceTwo();
    alternatePaymentNo = getRandomWebElementValue(msgprop.getProperty("updatedreferencetwo"));
    
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete")); 
    waitforPanelLoad();
   // validateStatus(status);
    validateRandomWebElementdrpdwn(msgprop.getProperty("lblstatus"),status);
  }

  protected static void selectCancellationReason(String data) throws InterruptedException {
    DebtorPayments.setCancelReason(data);
  }

  public static String getDBAmount() throws InterruptedException {
    return DebtorPayments.getAmount();

  }

  protected static void selectRefundTransactionCode(String data) throws InterruptedException {
    DebtorPayments.setRefundTransCode(data);
  }

  protected static void setRefundComment(String data) throws InterruptedException {
    DebtorPayments.setRefundOverpaymentComment(data);
  }
  protected static void setRefundReason(String data) throws InterruptedException {
    DebtorPayments.setRefundOverpaymentReason(data);
  }

  protected static void selectCancellationMessage(String data) throws InterruptedException {
    DebtorPayments.setCancelComment(data);
  }

  protected static void closeRefundOverpayment() throws InterruptedException, FileNotFoundException {
    objDebtorPayments = new  DebtorPayments(driver);
    waitforPanelElement(DebtorPayments.btnClose);
    DebtorPayments.btnClose.click();
    waitforPanelLoad();
  }


  protected static void validateStatus(String status) throws FileNotFoundException, InterruptedException {
    objDebtorPayments = new DebtorPayments(driver);
 // String actuals = DebtorPayments.getStatus();
    String actuals = getRandomWebElementDrpDwn(msgprop.getProperty("lblstatus"));
    if(actuals.equalsIgnoreCase(status)){
      log.info(KEYWORD_PASS  + "find element");
     // highlightElement(DebtorPayments.drpdnStatus);
    }else {
      log.info(KEYWORD_FAIL  + "cannot find element");
    }
  }

  protected static void cancellationSave() throws InterruptedException, FileNotFoundException {
    objDebtorPayments = new DebtorPayments(driver);
    waitforPanelElement(DebtorPayments.btnCancelSave);
    clickElement(DebtorPayments.btnCancelSave);
    waitforPanelLoad();
  }

  protected static String updateDebtor(String title, String firstName, String lastName, String location, String typeOfDebtor, String accessLevel) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad();
    objDebtorMaintenance = new DebtorMaintenance(driver);
    objCreditorMaintenanceWorkflow = new CreditorMaintenanceWorkflow();
    searchText(testdataprop.getProperty("dbaccountmaintenance"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("dbaccountmaintenance"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("dbdebtormaintenance"));
    waitforPanelLoad();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load")); 
    waitforPanelLoad();
    setDebtorTitle(title);
    setDebtorFirstName(firstName);
    setDebtorLastName(lastName);
    setDebtorLocation(location);
    setTypeOfDebtor(typeOfDebtor);
    setAccessLevel(accessLevel);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    searchTabs(orprop.getProperty("tabs"),testdataprop.getProperty("dbdebtormaintenanceheadertabs"));
    CreditorMaintenanceWorkflow.searchAndClickLatestRecordInTable(orprop.getProperty("addresstab"),testdataprop.getProperty("address"));
    CreditorMaintenanceWorkflow.editAddress();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    validateTableExist(DebtorMaintenance.tblDBEditAddress);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("manualaddress"));
    updateAddressDetailsForDebtorMaintenance(
        testdataprop.getProperty("updatedefaultadd"),
        testdataprop.getProperty("addressline2"),
        testdataprop.getProperty("addressline3"),
        testdataprop.getProperty("addressline4"),
        testdataprop.getProperty("country"),
        testdataprop.getProperty("postcode"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    CreditorMaintenanceWorkflow.validateTableData(orprop.getProperty("tableaddress"),addressOne);
    CreditorMaintenanceWorkflow.validateTableData(orprop.getProperty("tableaddress"),postCode);    
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("authorise"));
    //validate and store debtor number
    uniqueDebtorNumber = DebtorPayments.getDebtorNumber(); 
    title = DebtorPayments.getTitle();
    firstName = DebtorPayments.getFirstName();
    lastName = DebtorPayments.getLastName();
    fullName = title +" " +firstName +" " + lastName;
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("clear"));
    return uniqueDebtorNumber; 
  }



  private static String[] updateAddressDetailsForDebtorMaintenance(String addLine1,String addLine2,String addLine3,String addLine4,
      String country,String pcode) throws InterruptedException, FileNotFoundException {
    objDebtorPayments = new DebtorPayments(driver);
    waitforPanelElement(DebtorPayments.txtAddressLine1);
    addressOne = addLine1;

    setText(DebtorPayments.txtAddressLine1, addLine1);
    setText(DebtorPayments.txtAddressLine2, addLine2);
    setText(DebtorPayments.txtAddressLine3, addLine3);
    setText(DebtorPayments.txtAddressLine4, addLine4);
    setText(DebtorPayments.txtCountry, country);
    postCode = pcode;
    setText(DebtorPayments.txtPostCode, pcode);
    formFields= new String[] {addLine1,postCode};
    return formFields;
  }


  public static void searchTabs(String table,String dataSet) throws InterruptedException {

    List<WebElement> tabs = driver.findElements(By.xpath(table));
    boolean found = false;
    for(WebElement tab:tabs) {
      StringTokenizer tokenizer = new StringTokenizer(dataSet, ",");
      while (tokenizer.hasMoreTokens()) {
        String tokeknVal=tokenizer.nextToken();
        if(tab.getAttribute("value").trim().equalsIgnoreCase(tokeknVal)) {
          highlightElement(tab);
          log.info(KEYWORD_PASS +" Tab " +tab.getAttribute("value").trim() + " find");
          found=true;
          break;
        }else if(!found)break;
      }
    }

  }

  public static void searchAndClickTab(String table,String dataSet) throws InterruptedException, FileNotFoundException {

    List<WebElement> tabs = driver.findElements(By.xpath(table));
    for(WebElement tab:tabs) {
      if(tab.getAttribute("value").trim().equalsIgnoreCase(dataSet)) {
        highlightElement(tab);
        log.info(KEYWORD_PASS +" Tab " +tab.getAttribute("value").trim() + " find");
        tab.click();
        break;
      }
    }
    waitforPanelLoad();
  }

  protected static void setDebtorTitle(String title) throws InterruptedException, FileNotFoundException {
    objDebtorPayments = new DebtorPayments(driver);
    DebtorPayments.setTitle(title);
  }

  protected static void setDebtorFirstName(String data) throws InterruptedException, FileNotFoundException {
    objDebtorPayments = new DebtorPayments(driver);
    DebtorPayments.setFirstName(data);
  }

  protected static void setDebtorLastName(String data) throws InterruptedException, FileNotFoundException {
    objDebtorPayments = new DebtorPayments(driver);
    DebtorPayments.setLastName(data);
  }
  protected static void setDebtorLocation(String data) throws InterruptedException, FileNotFoundException {
    objDebtorPayments = new DebtorPayments(driver);
    DebtorPayments.setLocation(data);
  }

  protected static void setPaymentReferenceOne(String data) throws InterruptedException, FileNotFoundException {
    objDebtorPayments = new DebtorPayments(driver);
    DebtorPayments.setReferenceOne(data);
  }
  public static void setDebtorNumber(String data) throws InterruptedException, FileNotFoundException {
    objDebtorPayments = new DebtorPayments(driver);
    DebtorPayments.setDebtorNo(data);
  }

  public static void setCreditorAccountCode(String data) throws FileNotFoundException {
    objDebtorPayments = new DebtorPayments(driver);
    DebtorPayments.setCreditorNo(data);
  }
  protected static void setAccessLevel(String data) throws InterruptedException, FileNotFoundException {
    objDebtorPayments = new DebtorPayments(driver);
    DebtorPayments.setAccessLevel(data);
  }
  protected static void setTypeOfDebtor(String data) throws InterruptedException, FileNotFoundException {
    objDebtorPayments = new DebtorPayments(driver);
    DebtorPayments.setTypeOfDebtors(data);
  }
  protected static void setAllocatedTransCode(String data) throws InterruptedException, FileNotFoundException {
    objDebtorPayments = new DebtorPayments(driver);
    DebtorPayments.setDrpdnAllocatedTransCode(data);
  }

  public static void setAllocatedDebtorNo(String data) throws InterruptedException, FileNotFoundException {
    objDebtorPayments = new DebtorPayments(driver);
    DebtorPayments.setTxtAllocatedDebtorNo(data);
  }

  protected static void setAllocatedAmount(String data) throws InterruptedException, FileNotFoundException {
    objDebtorPayments = new DebtorPayments(driver);
    DebtorPayments.setTxtAllocatedAmount(data);
  }

  protected static void setAllocatedPaymentMethods(String data) throws InterruptedException, FileNotFoundException {
    objDebtorPayments = new DebtorPayments(driver);
    DebtorPayments.setAllocatedPaymentMethod(data);
  }

  protected static void setAllocatedReferenceNo(String data) throws InterruptedException, FileNotFoundException {
    objDebtorPayments = new DebtorPayments(driver);
    DebtorPayments.setTxtAllocatedReferenceNo(data);
  }

  protected static void setTxtAllocatedComment(String data) throws InterruptedException, FileNotFoundException {
    objDebtorPayments = new DebtorPayments(driver);
    DebtorPayments.setAllocatedComment(data);
  }

  protected static void verifyAllocatedDate() throws InterruptedException, FileNotFoundException {
    objDebtorPayments = new DebtorPayments(driver);
    DebtorPayments.clickAllocatedDate();
  }

  protected static void verifyAllocatedGLDate() throws InterruptedException, FileNotFoundException {
    objDebtorPayments = new DebtorPayments(driver);
    DebtorPayments.clickAllocatedGLDate();
  }

  protected static void verifyAllocatedRefOneAndRefTwoField(String lblRef1,String lblRef2) throws InterruptedException, FileNotFoundException {
    objDebtorPayments = new DebtorPayments(driver);
    validateMessage(DebtorPayments.lblForAllocatedReferenceOne, lblRef1);
    String label = DebtorPayments.lblForAllocatedReferenceTwo.getText();
    if(label.equalsIgnoreCase(lblRef2)) {
      highlightElement(DebtorPayments.lblForAllocatedReferenceTwo);
      log.info(KEYWORD_PASS + "Find element ");
    }else {
      log.info(KEYWORD_FAIL + "Cannot find element ");
    }
  }

  protected static void verifyAllocatedUpdatedRefOneAndRefTwoField(String updatedlblRef1,String updatedlblRef2) throws InterruptedException, FileNotFoundException {
    objDebtorPayments = new DebtorPayments(driver);
    validateMessage(DebtorPayments.lblForAllocatedReferenceOne, updatedlblRef1);
    String label = DebtorPayments.lblForAllocatedReferenceTwo.getText();
    label = DebtorPayments.lblForAllocatedReferenceTwo.getText();
    if(label.equalsIgnoreCase(updatedlblRef2)) {
      highlightElement(DebtorPayments.lblForAllocatedReferenceTwo);
      log.info(KEYWORD_PASS + "Find element ");
    }else {
      log.info(KEYWORD_FAIL + "Cannot find element ");
    }
  }
  public static void clickAddToAllocation() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorPayments = new DebtorPayments(driver);
    clickElement(DebtorPayments.btnAddToAllocation);
    waitforPanelLoad();
  }
  public static  void validateOutstandingAmount(String amount, String qty, String price) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDebtorPayments = new DebtorPayments(driver);
    boolean found = validateManualPaymentAmount(amount, qty, price);
    if(found) {
      log.info(KEYWORD_PASS + " Amount matched " );
      getRandomWebElementText(msgprop.getProperty("lbloutstanding"));
    }
  }

  public static boolean validateManualPaymentAmount(String amt, String qty, String price) throws FileNotFoundException, InterruptedException {
    objDebtorsVouchers = new DebtorsVouchers(driver);
    boolean found = false;
    float amount = Float.valueOf(qty)-Float.valueOf(price);
    String value = amt;
    String newAmount = String.valueOf(amount);
    value = value.substring(0,3);
    newAmount  = newAmount.substring(0, 3);
    if(newAmount.equalsIgnoreCase(value)) {
      log.info(KEYWORD_PASS +  " Amount matched ");
      found = true;
    }else {
      log.info(KEYWORD_FAIL +  " Amount does not matched ");
      found = false;
    }
    return found;
  }

  protected static void findManualPaymentUsingSearch(String debtorNo) throws FileNotFoundException, InterruptedException {
    objDebtorsAuthorise = new DebtorsAuthorise(driver);
    objDebtorPayments = new DebtorPayments(driver);
    searchText(testdataprop.getProperty("searchdbpayments"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbpayments"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchdbmanualpayments"));
    waitforPanelLoad();
    searchReferenceOne();
    waitforPanelLoad();
    DebtorsAuthorise.setDBAuthorizreDebtorNumber(debtorNo);
    setRefernceOne(paymentNo); 
    String currentDate = GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle=driver.getWindowHandle();
    DebtorPayments.clickTransDate();
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    searchTableColumn(orprop.getProperty("tbldbfindcrnotegrid"), uniqueDebtorNumber);
    searchAnchorTextInTableColumn(orprop.getProperty("tbldbfindcrnotegrid"), paymentNo);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("clear"));
  }

  public static void findAndClickPaymentAllocationCheckbox() throws InterruptedException, FileNotFoundException {
    objDebtorPayments = new DebtorPayments(driver);
    DebtorPayments.setChkdbAllocationCheckBox();    
  }

  public static void searchReferenceOne() throws FileNotFoundException, InterruptedException {
    objDebtorPayments = new DebtorPayments(driver);
    waitforPanelElement(DebtorPayments.btnSearchReferenceOne);
    DebtorPayments.clickReferenceOne();
  }

  public static void setRefernceOne(String data) throws FileNotFoundException {
    objDebtorPayments = new DebtorPayments(driver);
    DebtorPayments.setReferenceOneForDBFind(data);
  }

  public static void selectDBNotesForPayment() throws FileNotFoundException, InterruptedException {
    objDebtorPayments = new DebtorPayments(driver);
    DebtorPayments.clickDBNotesForPayment();
  }

  public static void validateImageIsAttached() throws FileNotFoundException, InterruptedException {
    objDebtorPayments = new DebtorPayments(driver);
    IsExist(DebtorPayments.imgAttach);
  }

  public static void setDrpdnAllocateTo() throws FileNotFoundException, InterruptedException {
    objDebtorPayments = new DebtorPayments(driver);
    DebtorPayments.setDrpdnAllocateTo();
  }

  public static void validateDbManualPaymentStatus(String data) throws FileNotFoundException, InterruptedException {
    objDebtorPayments = new DebtorPayments(driver);
    String actuals = DebtorPayments.getDrpdndbManualPaymentStatus();
    if(actuals.equalsIgnoreCase(data)) {
      log.info(KEYWORD_PASS + " Status is " + data);
    }
    else {
      log.info(KEYWORD_FAIL + " Status is not "+ data);
    }
  }


  public static void saveDetails() throws FileNotFoundException, InterruptedException {
    objDebtorPayments = new DebtorPayments(driver);
    DebtorPayments.setBtnSave();
    waitforPanelLoad();
  }

  public static void newAllocation() throws FileNotFoundException, InterruptedException {
    objDebtorPayments = new DebtorPayments(driver);
    waitforPanelLoad();
    boolean found =IsElementDisplayed(DebtorPayments.btnNewAllocation);
    if(found) {
      DebtorPayments.btnNewAllocation.click();
    }else {
      log.info(KEYWORD_FAIL + " Button New Allocaiton not found");
    }
    waitforPanelLoad();
  }
  //end of class
}