package financialWeb.workflow;

import java.io.FileNotFoundException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import financialWeb.pages.CreditorMaintenance;
import financialWeb.pages.DebtorMaintenance;
import financialWeb.pages.FinancialWebHomepage;

public class CreditorMaintenanceWorkflow extends CommonWorkflow{

  static CreditorMaintenance objCreditorMaintenance;
  static DebtorMaintenance objDebtorMaintenance;
  static DebtorMaintenanceWorkflow objDebtorMaintenanceWorkflow;
  
  protected static void setName(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad();
    objCreditorMaintenance = new CreditorMaintenance(driver);
  waitforPanelElement(CreditorMaintenance.txtName);
  setText(CreditorMaintenance.txtName, data);
}

protected static String setContactName(String data) throws FileNotFoundException, InterruptedException{
  waitforPanelLoad();
  objCreditorMaintenance = new CreditorMaintenance(driver);
  waitforPanelElement(CreditorMaintenance.txtContactName);
  setText(CreditorMaintenance.txtContactName, data);
  return data;
}

protected static void setJobTitle(String data) throws FileNotFoundException, InterruptedException{
  waitforPanelLoad();
  objCreditorMaintenance = new CreditorMaintenance(driver);
  setText(CreditorMaintenance.txtJobTitle, data);
}

protected static void setPaymentMethod(String data) throws FileNotFoundException, InterruptedException{
  waitforPanelLoad();
  objCreditorMaintenance = new CreditorMaintenance(driver);
  selectDropDown(CreditorMaintenance.drpdnPaymentMethod, data);
}

protected static void setInsertPaymentMethod(String data) throws FileNotFoundException, InterruptedException{
  waitforPanelLoad();
  objCreditorMaintenance = new CreditorMaintenance(driver);
  selectDropDown(CreditorMaintenance.drpdnAInsertPaymentMethod, data);
}


protected static void setEmailAddress(String data) throws FileNotFoundException, InterruptedException{
  waitforPanelLoad();
  objCreditorMaintenance = new CreditorMaintenance(driver);
  setText(CreditorMaintenance.txtEmailAdd, data);
}

protected static void insertEmailAddress(String data) throws FileNotFoundException, InterruptedException{
  waitforPanelLoad();
  objCreditorMaintenance = new CreditorMaintenance(driver);
  setText(CreditorMaintenance.txtInsertEmailAdd, data);
}

protected static void insertEmail(String data) throws FileNotFoundException, InterruptedException{
  waitforPanelLoad();
  objCreditorMaintenance = new CreditorMaintenance(driver);
  setText(CreditorMaintenance.txtInsertEmail, data);
}

protected static void setPaymentDay(String data) throws FileNotFoundException, InterruptedException{
  waitforPanelLoad();
  objCreditorMaintenance = new CreditorMaintenance(driver);
  selectDropDown(CreditorMaintenance.drpdnPaymentDay, data);
}

protected static void setAccessLevel(String data) throws FileNotFoundException, InterruptedException{
  objCreditorMaintenance = new CreditorMaintenance(driver);
  selectDropDown(CreditorMaintenance.drpdnAccessLevel, data);
}

public static void setInsertAccessLevel(String data) throws FileNotFoundException, InterruptedException{
  waitforPanelLoad();
 // objCreditorMaintenance = new CreditorMaintenance(driver);
  //selectDropDown(CreditorMaintenance.drpdnInsertAccessLevel, data);
  //selectDropDown(CreditorMaintenance.drpdnInsertLocation, data);
  selectRandomWebElementDrpDwn(msgprop.getProperty("lblaccesslevel"), data);
  
}

protected static void setLocation(String data) throws FileNotFoundException, InterruptedException{
  waitforPanelLoad();
  //objCreditorMaintenance = new CreditorMaintenance(driver);
  //selectDropDown(CreditorMaintenance.drpdnLocation, data);
  selectRandomWebElementDrpDwn(msgprop.getProperty("lbllocation"), data);
}

protected static void setInsertLocation(String data) throws FileNotFoundException, InterruptedException{
  waitforPanelLoad();
  selectRandomWebElementDrpDwn(msgprop.getProperty("lbllocation"), data);
  //objCreditorMaintenance = new CreditorMaintenance(driver);
  //selectDropDown(CreditorMaintenance.drpdnInsertLocation, data);
}


protected static void setTypeOfCreditor(String data) throws FileNotFoundException, InterruptedException{
  waitforPanelLoad();
//  objCreditorMaintenance = new CreditorMaintenance(driver);
//  selectDropDown(CreditorMaintenance.drpdnTypeOfCreditor, data);
  selectRandomWebElementDrpDwn(msgprop.getProperty("lbltypeofcreditor"), data);
}

protected static void setInsertTypeOfCreditor(String data) throws FileNotFoundException, InterruptedException{
  waitforPanelLoad();
  selectRandomWebElementDrpDwn(msgprop.getProperty("lbltypeofcreditor"), data);
//  objCreditorMaintenance = new CreditorMaintenance(driver);
//  selectDropDown(CreditorMaintenance.drpdnInsertTypeOfCreditor, data);
}

public static void validateAndClickTableData(String htmlTable,String data) throws InterruptedException, FileNotFoundException {
  waitforPanelLoad();
  searchAndClickLatestRecordInTable(htmlTable, data);
  waitforPanelLoad();
}

public static void validateTableData(String htmlTable,String data) throws InterruptedException, FileNotFoundException {
  waitforPanelLoad();
  searchTableColumn(htmlTable,data);
}

protected static void setPostCode(String data) throws FileNotFoundException, InterruptedException {
  waitforPanelLoad();
  objCreditorMaintenance = new CreditorMaintenance(driver);
  setText(CreditorMaintenance.txtPostCode, data);
}


protected static void setInsertPostCode(String data) throws FileNotFoundException, InterruptedException {
  waitforPanelLoad();
  objCreditorMaintenance = new CreditorMaintenance(driver);
  setText(CreditorMaintenance.txtInsertPostCode, data);
}

protected static void UpdateDefaultAddedAddress(String data) throws FileNotFoundException, InterruptedException {
  waitforPanelLoad();
  objCreditorMaintenance = new CreditorMaintenance(driver);
  waitforPanelElement(CreditorMaintenance.txtDefaultAddedAdd);
  setText(CreditorMaintenance.txtDefaultAddedAdd, data);
}

protected static void setInsertAddLineOne(String data) throws FileNotFoundException, InterruptedException {
  waitforPanelLoad();
  objCreditorMaintenance = new CreditorMaintenance(driver);
  setText(CreditorMaintenance.txtInsertAddLineOne, data);
}

protected static void validateInsertAddLineOne(String data) throws FileNotFoundException, InterruptedException {
  waitforPanelLoad();
  objCreditorMaintenance = new CreditorMaintenance(driver);
  validateMessage(CreditorMaintenance.txtInsertAddLineOne, data);
}

protected static void UpdateDefaultAddedPostCode(String data) throws FileNotFoundException, InterruptedException {
  waitforPanelLoad();
  objCreditorMaintenance = new CreditorMaintenance(driver);
  setText(CreditorMaintenance.txtDefaultAddedPostCode, data);
}

protected static void UpdateDefaultAddedEmailAddress(String data) throws FileNotFoundException, InterruptedException {
  waitforPanelLoad();
  objCreditorMaintenance = new CreditorMaintenance(driver);
  setText(CreditorMaintenance.txtDefaultAddedEmailAdd, data);
}

public static String storeuniqueMaintenanceNumber() throws FileNotFoundException, InterruptedException {
  objCreditorMaintenance = new CreditorMaintenance(driver);
  waitforPanelElement(CreditorMaintenance.txtCreditorNumber);
  boolean found =IsExist(CreditorMaintenance.txtCreditorNumber);
  if(found) {
    log.info("Pass: Field vlaue is " + CreditorMaintenance.txtCreditorNumber.getAttribute("value"));
  }else {
    log.info("Fail: Field vlaue is " + CreditorMaintenance.txtCreditorNumber.getAttribute("value"));
  }
  return uniqueMaintenanceNumber = CreditorMaintenance.txtCreditorNumber.getAttribute("value");
}

public static void setCreditorNumber(String data) throws FileNotFoundException, InterruptedException {
   objCreditorMaintenance = new CreditorMaintenance(driver);
  waitforPanelElement(CreditorMaintenance.txtCreditorNumber);
  setText(CreditorMaintenance.txtCreditorNumber,data);
}

public static void validateInsertCustomerName(String data) throws FileNotFoundException, InterruptedException {
  objCreditorMaintenance = new CreditorMaintenance(driver);
  waitForElementDisappear();
  waitforPanelElement(CreditorMaintenance.txtInsertCreditorName);
  validateMessageByTag(CreditorMaintenance.txtInsertCreditorName,data);
  
}

public static String createCreditor() throws FileNotFoundException, InterruptedException {
  waitforPanelLoad();
  objFinWebHomePage = new FinancialWebHomepage(driver);
  FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
  searchText(testdataprop.getProperty("searchccractmaint"));
  searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchccractmaint"));
  clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchccrcreditormaint"));
  waitforPanelLoad();
  callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
  waitforPanelLoad();
  //setName(testdataprop.getProperty("name"));
  setRandomWebElementValue(msgprop.getProperty("lblname"), testdataprop.getProperty("name"));
  
  //setPaymentMethod(testdataprop.getProperty("testpaymentmethod"));
  selectRandomWebElementDrpDwn(msgprop.getProperty("lblpaymentmethod"), testdataprop.getProperty("testpaymentmethod"));
  
  //setEmailAddress(testdataprop.getProperty("emailaddress"));
  setRandomWebElementValue(msgprop.getProperty("lblemailadd"), testdataprop.getProperty("emailaddress"));
  
   //setPaymentDay(testdataprop.getProperty("monpaymentday"));
  selectRandomWebElementDrpDwn(msgprop.getProperty("lblpaymentday"), testdataprop.getProperty("monpaymentday"));
    
  //setAccessLevel(testdataprop.getProperty("accesslevel3"));
  selectRandomWebElementDrpDwn(msgprop.getProperty("lblaccesslevel"), testdataprop.getProperty("accesslevel3"));
  
  //setLocation(testdataprop.getProperty("locationwithincouncilboundary"));
  selectRandomWebElementDrpDwn(msgprop.getProperty("lbllocation"), testdataprop.getProperty("locationwithincouncilboundary"));
  
  //setTypeOfCreditor(testdataprop.getProperty("companytypeofcreditor"));
  selectRandomWebElementDrpDwn(msgprop.getProperty("lbltypeofcreditor"), testdataprop.getProperty("companytypeofcreditor"));
  
  callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
  waitforPanelLoad();
  searchAndClickLatestRecordInTable(orprop.getProperty("addresstable"),testdataprop.getProperty("defaultadded"));
  editAddress();
  postCode = getRandomNumber(testdataprop.getProperty("rndfieldlimit"));
  setPostCode(postCode);
  callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
  //waitforPanelLoad();
  waitforPanelElement(FinancialWebHomepage.btnManualAddress);
  callEvent(orprop.getProperty("button"),testdataprop.getProperty("manualaddress"));
  //waitforPanelLoad();
  UpdateDefaultAddedAddress(testdataprop.getProperty("updatedefaultadd"));
  UpdateDefaultAddedPostCode(testdataprop.getProperty("updatedefaultpostcode"));
  UpdateDefaultAddedEmailAddress(testdataprop.getProperty("emailaddress"));
  callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
  validateStatus(testdataprop.getProperty("defaultcreditorstatus"));
  callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
  callEvent(orprop.getProperty("button"),testdataprop.getProperty("authorise"));
  uniqueMaintenanceNumber = storeuniqueMaintenanceNumber();
  uniqueCreditorNumber = uniqueMaintenanceNumber;
  clearDetails();
  waitforPanelLoad();
  validateFieldIsEnabled();
  return uniqueCreditorNumber;
  
}

protected static String createCreditor(String name, 
    String paymentMethod, String printMethod, String emailAdd,String accessLevel,
    String loc, String typeOfCreditor, String defaultAddCode, String defaultAddType,
    String newAdd, String validPostCode) throws FileNotFoundException, InterruptedException {
  waitforPanelLoad();
  objDebtorMaintenance = new DebtorMaintenance(driver);
  clickHrefLink(testdataprop.getProperty("home"));
  searchText(testdataprop.getProperty("searchccractmaint"));
  searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchccractmaint"));
  clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchccrinsertcreditor"));
  waitforPanelLoad();
  callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
  waitforPanelLoad();
  DebtorMaintenanceWorkflow.setTitleForDbInsertDebtor(name);
  setInsertPaymentMethod(paymentMethod);
  //add code for print method
  setPrintMethod(printMethod);
  insertEmail(emailAdd);
  setInsertAccessLevel(accessLevel);
  setInsertLocation(loc);
  setInsertTypeOfCreditor(typeOfCreditor);
  DebtorMaintenanceWorkflow.setCountryForDbInsertDebtor(defaultAddCode);
  validateDefaultAddressType(defaultAddType);
  insertAddress();
  postCode = getRandomNumber(testdataprop.getProperty("rndfieldlimit"));
  setPostCode(postCode);
  callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
  callEvent(orprop.getProperty("button"),testdataprop.getProperty("manualaddress"));
  setInsertAddLineOne(newAdd);
  setInsertPostCode(validPostCode);
  insertEmailAddress(emailAdd);
  callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
  waitforPanelLoad();
  return uniqueMaintenanceNumber = storeuniqueMaintenanceNumber();
}

private static void validateDefaultAddressType(String defaultAddType) throws FileNotFoundException, InterruptedException {
  waitforPanelLoad();
  objCreditorMaintenance = new CreditorMaintenance(driver);
  waitforPanelElement(CreditorMaintenance.drpdnInsertAddType);
  Select oSelect = new Select(CreditorMaintenance.drpdnInsertAddType);
  if(oSelect.getFirstSelectedOption().getText().equalsIgnoreCase(defaultAddType)) {
    highlightElement(oSelect.getFirstSelectedOption());
    log.info("Pass: Default value displayed is " + oSelect.getFirstSelectedOption().getText());
  }else {
    log.info("Fail: Default value displayed is " + oSelect.getFirstSelectedOption().getText());
  }
}

public static void editAddress() throws InterruptedException, FileNotFoundException {
  waitforPanelLoad();
  objCreditorMaintenance = new CreditorMaintenance(driver);
  Thread.sleep(5000);
  waitforPanelElement(CreditorMaintenance.btnEditAddress);
  clickElement(CreditorMaintenance.btnEditAddress);
  waitforPanelLoad();
  waitforPanelElement(CreditorMaintenance.btnSubmit);
  waitForElementDisappear();
}

public static void setTelDescription(String data) throws InterruptedException, FileNotFoundException {
  waitforPanelLoad();
  objCreditorMaintenance = new CreditorMaintenance(driver);
  selectDropDown(CreditorMaintenance.drpDnTelDescription,data);
}

public static void setPrintMethod(String data) throws InterruptedException, FileNotFoundException {
  waitforPanelLoad();
  objCreditorMaintenance = new CreditorMaintenance(driver);
  selectDropDown(CreditorMaintenance.drpDnPrintMethod,data);
}

public static void setTelehoneNumber(String data) throws InterruptedException, FileNotFoundException {
  waitforPanelLoad();
  objCreditorMaintenance = new CreditorMaintenance(driver);
  setText(CreditorMaintenance.txtTelephoneNumber,data);
}

protected static void setInsertContactEmailAddress(String data) throws FileNotFoundException, InterruptedException{
  waitforPanelLoad();
  objCreditorMaintenance = new CreditorMaintenance(driver);
  setText(CreditorMaintenance.txtInsertContactEmailAdd, data);
}

protected static void setComment(String data) throws FileNotFoundException, InterruptedException{
  waitforPanelLoad();
  objCreditorMaintenance = new CreditorMaintenance(driver);
  setText(CreditorMaintenance.txtComment, data);
}

protected static void validateInsertCreditorStatus(String data) throws FileNotFoundException, InterruptedException{
  waitforPanelLoad();
  objCreditorMaintenance = new CreditorMaintenance(driver);
  waitforPanelElement(CreditorMaintenance.txtInsertCreditorStatus);
  validateMessageByTag(CreditorMaintenance.txtInsertCreditorStatus, data);
}

public static String setAddressType(String data) throws FileNotFoundException, InterruptedException{
  objCreditorMaintenance = new CreditorMaintenance(driver);
  waitforPanelElement(CreditorMaintenance.drpdnAddType);
  addressType=data;
  selectDropDown(CreditorMaintenance.drpdnAddType, addressType);
  return addressType;
}

protected static void setAddComment(String data) throws FileNotFoundException, InterruptedException{
  waitforPanelLoad();
  objCreditorMaintenance = new CreditorMaintenance(driver);
  setText(CreditorMaintenance.txtAddComment, data);
}

public static void validateCRInsertEmailAddress(String data) throws FileNotFoundException, InterruptedException {
  waitforPanelLoad();
  objCreditorMaintenance = new CreditorMaintenance(driver);
  validateMessageByTag(CreditorMaintenance.txtInsertEmail, data);
}

public static void setCrNumber(String data) throws FileNotFoundException, InterruptedException{
  objCreditorMaintenance = new CreditorMaintenance(driver);
  waitforPanelElement(CreditorMaintenance.txtCrNumber);
  CreditorMaintenance.setValueCrNumber(data);
}

public static void setAccountNumber(String data) throws FileNotFoundException, InterruptedException{
  objCreditorMaintenance = new CreditorMaintenance(driver);
   waitforPanelElement(CreditorMaintenance.txtBankAcNumber);
  CreditorMaintenance.setBankACNumber(data);
}

public static void setAccountSortCode(String data) throws FileNotFoundException, InterruptedException{
  objCreditorMaintenance = new CreditorMaintenance(driver);
  waitforPanelElement(CreditorMaintenance.txtBankAcSortCode);
  CreditorMaintenance.setBankSortCode(data);
}

public static void setAccountName(String data) throws FileNotFoundException, InterruptedException{
  objCreditorMaintenance = new CreditorMaintenance(driver);
  CreditorMaintenance.setBankAccountName(data);
}

public static void validateCreditStatus(String data) throws FileNotFoundException, InterruptedException{
  objCreditorMaintenance = new CreditorMaintenance(driver);
  waitforPanelElement(CreditorMaintenance.txtCrStatus);
  verifyTextAttribute(CreditorMaintenance.txtCrStatus, data);
  waitforPanelLoad();
}

public static void validatetxtCreditorMaintenanceStatus(String data) throws FileNotFoundException, InterruptedException{
  objCreditorMaintenance = new CreditorMaintenance(driver);
  waitforPanelElement(CreditorMaintenance.txtCreditorMaintenanceStatus);
  verifyTextAttribute(CreditorMaintenance.txtCreditorMaintenanceStatus, data);
}

protected static void setLiableReason(String data) throws FileNotFoundException, InterruptedException{
  waitforPanelLoad();
  objCreditorMaintenance = new CreditorMaintenance(driver);
  CreditorMaintenance.setLiableReason(data);
}

protected static void isPurchasingSupplierPresent() throws FileNotFoundException, InterruptedException{
  objCreditorMaintenance = new CreditorMaintenance(driver);
  boolean found  = false;
  waitforPanelElement(CreditorMaintenance.chkPurchasingSupplier);
  while(!found) {
    found = CreditorMaintenance.chkPurchasingSupplier.isDisplayed();
  if(found)break;
  }
}

protected static void setOtherEmailAddress(String data) throws FileNotFoundException, InterruptedException{
  objCreditorMaintenance = new CreditorMaintenance(driver);
  waitforPanelElement(CreditorMaintenance.txtOtherEmailAdd);
  CreditorMaintenance.OtherEmailAddress(data);
}

protected static void findCreditorNumber() throws Exception {
  waitforPanelLoad();
  objCreditorMaintenance = new CreditorMaintenance(driver);
  CreditorMaintenance.clickCreditorNumber();
}

public static void setCreditorName(String data) throws Exception {
  waitforPanelLoad();
  objCreditorMaintenance = new CreditorMaintenance(driver);
  CreditorMaintenance.crName(data);
}

public static void setCreditorAddress(String data) throws Exception {
  waitforPanelLoad();
  objCreditorMaintenance = new CreditorMaintenance(driver);
  CreditorMaintenance.crAddress(data);
}

public static void setCreditorPostCode(String data) throws Exception {
  waitforPanelLoad();
  objCreditorMaintenance = new CreditorMaintenance(driver);
  CreditorMaintenance.crPostCode(data);
}
protected static void validateCrMaintenanceStatus(String data) throws FileNotFoundException, InterruptedException {
  objCreditorMaintenance = new CreditorMaintenance(driver);
  waitForElementDisappear();
  waitforPanelElement(CreditorMaintenance.txtCrMaintenanceStatus);
  creditorStatus = CreditorMaintenance.getTxtCrMaintenanceStatus();
  if(creditorStatus.equalsIgnoreCase(data)) {
   highlightElement(CreditorMaintenance.txtCrMaintenanceStatus);
    log.info("Pass: Creditor status field value is " + creditorStatus);
  }
  else
    log.info("Fail: Creditor status field value is " + creditorStatus);
}

protected static void selectCreditorDetailsTab(String data) throws InterruptedException, FileNotFoundException {
  waitForPageLoad();
  List<WebElement> htmlTable = driver.findElements(By.xpath(orprop.getProperty("crcreditortbreadtable")));
  for(WebElement myTable:htmlTable) {
    if(myTable.getAttribute("value").trim().equalsIgnoreCase(data.trim())) {
      log.info(KEYWORD_PASS + " Element find" );
      click(myTable);
      waitforPanelLoad();
      break;
    }else {
      log.info(KEYWORD_FAIL + " Cannot find element " );
    }
  }waitforPanelLoad();
}
//end of class
}
