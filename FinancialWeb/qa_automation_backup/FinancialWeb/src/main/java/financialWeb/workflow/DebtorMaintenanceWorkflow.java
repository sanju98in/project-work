package financialWeb.workflow;

import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import financialWeb.pages.CreditorMaintenance;
import financialWeb.pages.DebtorMaintenance;

public class DebtorMaintenanceWorkflow extends CommonWorkflow{

  static DebtorMaintenance objDebtorMaintenance;
  static CreditorMaintenanceWorkflow objCreditorMaintenanceWorkflow;
  static  FinancialWebHomepageWorkflow objFinancialWebHomepageWorkflow; 
  protected static String[] formFields;
  protected static String addressOne = null;
  protected static String postCode = null;
  protected static String addressLine1 = null;
 
  public static String createDebtor() throws FileNotFoundException, InterruptedException{
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    waitforPanelLoad();
    objDebtorMaintenance = new DebtorMaintenance(driver);
    objCreditorMaintenance = new CreditorMaintenance(driver);
    objCreditorMaintenanceWorkflow = new CreditorMaintenanceWorkflow();
    searchText(testdataprop.getProperty("dbaccountmaintenance"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("dbaccountmaintenance"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("dbdebtormaintenance"));    
    waitforPanelLoad();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load")); 
    //waitforPanelLoad();
    setTitle(testdataprop.getProperty("title"));
    setFirstName(testdataprop.getProperty("firstname"));
    // lastname and addres sLine1 have same locator
    setLastName(testdataprop.getProperty("lastname"));
    setLocationForDebtor(testdataprop.getProperty("location"));
    setTypeOfDebtor(testdataprop.getProperty("typeofdebtor"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    //searchAndValidate(testdataprop.getProperty("dbdebtormaintenanceheadertabs"));
    waitforPanelLoad();
    searchAndClickLatestRecordInTable(orprop.getProperty("addresstable"),testdataprop.getProperty("address"));
    waitforPanelLoad();
    CreditorMaintenanceWorkflow.editAddress();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    waitforPanelElement(DebtorMaintenance.tblDBEditAddress);
    //validateTableExist(DebtorMaintenance.tblDBEditAddress);
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
    uniqueMaintenanceNumber = getRandomWebElementValue(msgprop.getProperty("lbldebtornumber"));
   // uniqueMaintenanceNumber = CreditorMaintenanceWorkflow.storeuniqueMaintenanceNumber();
    uniqueDebtorNumber = uniqueMaintenanceNumber;
    title = DebtorMaintenance.getTitle();
    firstName = DebtorMaintenance.getFirstName();
    lastName = DebtorMaintenance.getLastName();
    fullName = title +" " +firstName +" " + lastName;
    clearDetails();
    waitforPanelLoad();
	return uniqueMaintenanceNumber;
  }
  
  public static String updateDebtor() throws FileNotFoundException, InterruptedException{
    waitforPanelLoad();
  
    objDebtorMaintenance = new DebtorMaintenance(driver);
    objCreditorMaintenanceWorkflow = new CreditorMaintenanceWorkflow();
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    searchText(testdataprop.getProperty("dbaccountmaintenance"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("dbaccountmaintenance"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("dbdebtormaintenance"));
    waitforPanelLoad();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    waitforPanelLoad();
    setTitle(testdataprop.getProperty("title"));
    setFirstName(testdataprop.getProperty("firstname"));
    // lastname and addres sLine1 have same locator
    setLastName(testdataprop.getProperty("lastname"));
    setLocationForDebtor(testdataprop.getProperty("location"));
    setTypeOfDebtor(testdataprop.getProperty("typeofdebtor"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    //searchAndValidate(testdataprop.getProperty("dbdebtormaintenanceheadertabs"));
    CreditorMaintenanceWorkflow.searchAndClickLatestRecordInTable(orprop.getProperty("addresstable"),testdataprop.getProperty("address"));
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
    uniqueMaintenanceNumber = CreditorMaintenanceWorkflow.storeuniqueMaintenanceNumber(); 
    uniqueDebtorNumber = uniqueMaintenanceNumber;
    title = DebtorMaintenance.getTitle();
    firstName = DebtorMaintenance.getFirstName();
    lastName = DebtorMaintenance.getLastName();
    fullName = title +" " +firstName +" " + lastName;
    clearDetails();
    waitforPanelLoad();
    return uniqueDebtorNumber;
  }
  public static String createAndStoreDebtorDetails() throws FileNotFoundException, InterruptedException{
    waitforPanelLoad();
    objDebtorMaintenance = new DebtorMaintenance(driver);
    objCreditorMaintenanceWorkflow = new CreditorMaintenanceWorkflow();
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    searchText(testdataprop.getProperty("dbaccountmaintenance"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("dbaccountmaintenance"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("dbdebtormaintenance"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load")); 
    setTitle(testdataprop.getProperty("title"));
    setFirstName(testdataprop.getProperty("firstname"));
    
    // lastname and addressLine1 have same locator
    setLastName(testdataprop.getProperty("lastname"));
    setLocationForDebtor(testdataprop.getProperty("location"));
    setTypeOfDebtor(testdataprop.getProperty("typeofdebtor"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    //searchAndValidate(testdataprop.getProperty("dbdebtormaintenanceheadertabs"));
    waitforPanelLoad();
    CreditorMaintenanceWorkflow.searchAndClickLatestRecordInTable(orprop.getProperty("addresstable"),testdataprop.getProperty("address"));
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
    CreditorMaintenanceWorkflow.searchAndClickLatestRecordInTable(orprop.getProperty("addresstable"),testdataprop.getProperty("updatedefaultadd"));
    addressOne = DebtorMaintenance.getAddressLineOne();
    addressTwo = DebtorMaintenance.getAddressLineTwo();
    addressThree = DebtorMaintenance.getAddressLineThree();
    addressFour = DebtorMaintenance.getAddressLineFour();
    country = DebtorMaintenance.getCountry();
    postCode = DebtorMaintenance.getPostCode();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("cancel"));
    CreditorMaintenanceWorkflow.validateTableData(orprop.getProperty("tableaddress"),addressOne);
    CreditorMaintenanceWorkflow.validateTableData(orprop.getProperty("tableaddress"),postCode);    
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("authorise"));
    //validate and store debtor number
    uniqueMaintenanceNumber = CreditorMaintenanceWorkflow.storeuniqueMaintenanceNumber();
    title = DebtorMaintenance.getTitle();
    firstName = DebtorMaintenance.getFirstName();
    lastName = DebtorMaintenance.getLastName();
    fullName = title +" " +firstName +" " + lastName;
    clearDetails();
    waitforPanelLoad();
    return uniqueMaintenanceNumber;
  }
  
  protected static void setTitle(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    waitforPanelElement(DebtorMaintenance.txtTitle);
    setText(DebtorMaintenance.txtTitle, data);
  }
  protected static String setFirstName(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    waitforPanelElement(DebtorMaintenance.txtFirstName);
    setText(DebtorMaintenance.txtFirstName, data);
    firstName=data;
    return firstName;
  }
  protected static String updateFirstName(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    setText(DebtorMaintenance.txtFirstName, data);
    firstName=data;
    return firstName;
  }
  protected static String setLastName(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    setText(DebtorMaintenance.txtAddressLine1, data);
    lastName=data;
    return lastName;
  }
  protected static void setLocationForDebtor(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    selectDropDown(DebtorMaintenance.drpdnLocationForDebtor, data);
  }
  protected static void setTypeOfDebtor(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad();
    objDebtorMaintenance = new DebtorMaintenance(driver);
    selectDropDown(DebtorMaintenance.dropdnTypeofDebtor, data);
  }
  protected static void setAccessLevelValue(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    selectDropDown(DebtorMaintenance.dropdnAccessLevel, data);
  }
  protected static void updateTypeOfDebtor(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad(); objDebtorMaintenance = new DebtorMaintenance(driver);
    selectDropDown(DebtorMaintenance.dropdnTypeofDebtor, data);
  }
  protected static void setAddressCode(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad();
    objDebtorMaintenance = new DebtorMaintenance(driver);
    setText(DebtorMaintenance.txtAddressCode, data);
  }
  public static void insertAddressForDebtor() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorMaintenance = new DebtorMaintenance(driver);
    clickElement(DebtorMaintenance.btnInsertAddress);
  }

  public static void insertAddress() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    waitforPanelElement(DebtorMaintenance.btnInsertAddress);
    clickElement(DebtorMaintenance.btnInsertAddress);
  }
  protected static void setNameAtAddress(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad();
    objDebtorMaintenance = new DebtorMaintenance(driver);
    setText(DebtorMaintenance.txtNameAtAddress, data);
  }
  protected static void setTelephoneNumber(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad();
    objDebtorMaintenance = new DebtorMaintenance(driver);
    setText(DebtorMaintenance.txtTelephone, data);
  }
  protected static void setEmailForDebtor(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    setText(DebtorMaintenance.txtEmail, data);
  }
  protected static String setTitleForDbInsertDebtor(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    waitforPanelElement(DebtorMaintenance.txtTitleForDbInsertDebtor);
    contactName=data;
    setText(DebtorMaintenance.txtTitleForDbInsertDebtor, contactName);
    return contactName;
  }
  public static void validateInsertCreditorName(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad();
    objDebtorMaintenance = new DebtorMaintenance(driver);
    validateMessage(DebtorMaintenance.txtDebtorNumber, data);
  }
  
  protected static void setWebsiteForDebtor(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    setText(DebtorMaintenance.txtWebsite, data);
  }
  protected static String setFirstNameForDbInsertDebtor(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    waitforPanelElement(DebtorMaintenance.txtFirstNameForDbInsertDebtor);
    addressCode=data;
    setText(DebtorMaintenance.txtFirstNameForDbInsertDebtor, addressCode);
    return addressCode;
  }
  protected static void setLocationForDbInsertDebtor(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad();
    objDebtorMaintenance = new DebtorMaintenance(driver);
    selectDropDown(DebtorMaintenance.drpdnLocationForDebtorForDbInsertDebtor, data);
  }
  protected static void setTypeOfDebtorForDbInsertDebtor(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad();
    objDebtorMaintenance = new DebtorMaintenance(driver);
    selectDropDown(DebtorMaintenance.dropdnTypeofDebtorForDbInsertDebtor, data);
  }
  protected static void setAddressLine1ForDbInsertDebtor(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    setText(DebtorMaintenance.txtAddressLine1ForDbInsertDebtor, data);
  }
  protected static void setAddressLine2ForDbInsertDebtor(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    setText(DebtorMaintenance.txtAddressLine2ForDbInsertDebtor, data);
  }
  protected static void setAddressLine3ForDbInsertDebtor(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    setText(DebtorMaintenance.txtAddressLine3ForDbInsertDebtor, data);
  }
 protected static void getInsertAddressCode(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    validateMessageByTag(DebtorMaintenance.txtAddressLine3ForDbInsertDebtor, data);
  }
  protected static void setAddressLine4ForDbInsertDebtor(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad();
    objDebtorMaintenance = new DebtorMaintenance(driver);
    setText(DebtorMaintenance.txtAddressLine4ForDbInsertDebtor, data);
  }
  protected static void setCountryForDbInsertDebtor(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad();
    objDebtorMaintenance = new DebtorMaintenance(driver);
    setText(DebtorMaintenance.txtCountryForDbInsertDebtor, data);
  }
  protected static void setPostCodeForDbInsertDebtor(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    setText(DebtorMaintenance.txtPostCodeForDbInsertDebtor, data);
  }
  protected static String[] updateAddressDetailsForDebtorMaintenance(String addLine1,String addLine2,String addLine3,String addLine4,
      String cntry,String pcode) throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
      waitforPanelElement(DebtorMaintenance.txtAddressLine1);
      addressOne = addLine1;
      setText(DebtorMaintenance.txtAddressLine1, addressOne);
      addressTwo = addLine2;
      setText(DebtorMaintenance.txtAddressLine2, addLine2);
      addressThree = addLine3;
      setText(DebtorMaintenance.txtAddressLine3, addLine3);
      addressFour = addLine4;
      setText(DebtorMaintenance.txtAddressLine4, addLine4);
      country = cntry;
      setText(DebtorMaintenance.txtCountry, cntry);
      postCode = pcode;
      setText(DebtorMaintenance.txtPostCode, postCode);
      formFields= new String[] {addLine1,postCode};
      return formFields;
  }
  
  protected static void validateDebtorStatus(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDebtorMaintenance = new DebtorMaintenance(driver);
    debtorStatus = DebtorMaintenance.txtAddressLine4.getAttribute("value");
    if(debtorStatus.equalsIgnoreCase(data))
      log.info("Pass: Creditor status field value is " + debtorStatus);
    else
      log.info("Fail: Creditor status field value is " + debtorStatus);
  }
  
  protected static void searchAndValidate(String dataSet) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDebtorMaintenance = new DebtorMaintenance(driver);
    waitforPanelLoad();
    StringTokenizer tokenizer = new StringTokenizer(dataSet, ",");
    while (tokenizer.hasMoreTokens()) {
      findHTMLTableData(DebtorMaintenance.lblDbDebtorMaintenanceTabs,tokenizer.nextToken());
    }
  }
  public static String storeUniqueDebtorMaintenanceNumber() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    waitforPanelElement(DebtorMaintenance.txtDebtorNumber);
    boolean found =IsExist(DebtorMaintenance.txtDebtorNumber);
    if(found) {
      log.info("Pass: Field vlaue is " + DebtorMaintenance.txtDebtorNumber.getAttribute("value"));
    }else {
      log.info("Fail: Field vlaue is " + DebtorMaintenance.txtDebtorNumber.getAttribute("value"));
    }
    return uniqueMaintenanceNumber = DebtorMaintenance.txtDebtorNumber.getAttribute("value");
  }
  protected static void setDebtorNumber(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDebtorMaintenance = new DebtorMaintenance(driver);
    
    waitforPanelElement(CreditorMaintenance.txtPostCode);
    setText(CreditorMaintenance.txtPostCode,data);
  }
 
 public static void setCreditorNumber(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    
    waitforPanelElement(DebtorMaintenance.txtDebtorNumber);
    setText(DebtorMaintenance.txtDebtorNumber,data);
  }
 public static void getCRInsertEmailAddress(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad(); objDebtorMaintenance = new DebtorMaintenance(driver);
    validateMessage(DebtorMaintenance.txtCountry, data);
  }
  
  protected static void validateDebtorMaintenanceStatus(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    objCreditorMaintenance = new CreditorMaintenance(driver);
    waitForElementDisappear();
    //waitforPanelElement(CreditorMaintenance.txtEmailAdd);
    waitforPanelElement(CreditorMaintenance.txtBankAcName);
    //debtorStatus = CreditorMaintenance.txtEmailAdd.getAttribute("value");
    debtorStatus = CreditorMaintenance.txtBankAcName.getAttribute("value");
    if(debtorStatus.equalsIgnoreCase(data))
      //highlightElement(CreditorMaintenance.txtEmailAdd);
      highlightElement(CreditorMaintenance.txtBankAcName);
    else
      log.info("Fail: Creditor status field value is " + debtorStatus);
  }
  protected static void validateErrorMsg() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    validateMessage(DebtorMaintenance.lblErrorMsg,testdataprop.getProperty("errormsg"));
  }
  protected static void verifyUpdatedFields() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    findMatchingNumberInString(DebtorMaintenance.lblInputHeaders,uniqueMaintenanceNumber);
  }  
  protected static void verifyActionColumn() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDebtorMaintenance = new DebtorMaintenance(driver);
    StringTokenizer str = new StringTokenizer(testdataprop.getProperty("actioncolumn"), ",");
    while(str.hasMoreTokens()) {
    findTableData(DebtorMaintenance.lblActionColumn,str.nextToken());
    }
  } 
  protected static void verifyTypeColumn() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    StringTokenizer str = new StringTokenizer(testdataprop.getProperty("typecolumn"), ",");
    while(str.hasMoreTokens()) {
      findTableData(DebtorMaintenance.lblTypeColumn,str.nextToken());
    }
  }
  protected static void setVatCode(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad();
    objDebtorMaintenance = new DebtorMaintenance(driver);
    selectDropDown(DebtorMaintenance.dropdnVatCode, data);
  }
  protected static void checkSuspendRecoveryCheckBox() throws FileNotFoundException, InterruptedException{
    waitforPanelLoad();
    objDebtorMaintenance = new DebtorMaintenance(driver);
    checkCheckBox(DebtorMaintenance.suspendRecoveryCheckbox);
  }
  protected static void checkemailCreditNoteCheckbox() throws FileNotFoundException, InterruptedException{
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    checkCheckBox(DebtorMaintenance.emailCreditNoteCheckbox);
  }
  protected static void checkemailStatementsCheckbox() throws FileNotFoundException, InterruptedException{
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    checkCheckBox(DebtorMaintenance.emailStatementsCheckbox);
  }
  protected static void checkemailInstalmentsCheckbox() throws FileNotFoundException, InterruptedException{
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    checkCheckBox(DebtorMaintenance.emailInstalmentsCheckbox);
  }
  protected static void checkemailInvoiceMasterCheckbox() throws FileNotFoundException, InterruptedException{
    waitforPanelLoad();
    objDebtorMaintenance = new DebtorMaintenance(driver);
    checkCheckBox(DebtorMaintenance.emailInvoiceMasterCheckbox);
  }
  protected static void checkemailReminderLettersCheckbox() throws FileNotFoundException, InterruptedException{
    waitforPanelLoad();
    objDebtorMaintenance = new DebtorMaintenance(driver);
    checkCheckBox(DebtorMaintenance.emailReminderLettersCheckbox);
  }
  protected static void checkemailDDAgreementsCheckbox() throws FileNotFoundException, InterruptedException{
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    checkCheckBox(DebtorMaintenance.emailDDAgreementsCheckbox);
  }
  protected static void checkemailDDmandatesCheckbox() throws FileNotFoundException, InterruptedException{
    waitforPanelLoad();
    objDebtorMaintenance = new DebtorMaintenance(driver);
    checkCheckBox(DebtorMaintenance.emailDDmandatesCheckbox);
  }
  protected static void checkfaxInvoiceCheckbox() throws FileNotFoundException, InterruptedException{
    waitforPanelLoad();
    objDebtorMaintenance = new DebtorMaintenance(driver);
    checkCheckBox(DebtorMaintenance.faxInvoiceCheckbox);
  }
  protected static void checkfaxCreditNoteCheckbox() throws FileNotFoundException, InterruptedException{
    waitforPanelLoad();
    objDebtorMaintenance = new DebtorMaintenance(driver);
    checkCheckBox(DebtorMaintenance.faxCreditNoteCheckbox);
  }
  protected static void checkfaxStatementsCheckbox() throws FileNotFoundException, InterruptedException{
    waitforPanelLoad();
    objDebtorMaintenance = new DebtorMaintenance(driver);
    checkCheckBox(DebtorMaintenance.faxStatementsCheckbox);
  }
  protected static void checkfaxInstallmentsCheckbox() throws FileNotFoundException, InterruptedException{
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    checkCheckBox(DebtorMaintenance.faxInstallmentsCheckbox);
  }
  protected static void checkfaxInvoiceMasterCheckbox() throws FileNotFoundException, InterruptedException{
    waitforPanelLoad();
    objDebtorMaintenance = new DebtorMaintenance(driver);
    checkCheckBox(DebtorMaintenance.faxInvoiceMasterCheckbox);
  }
  protected static void checkfaxReminderLettersCheckbox() throws FileNotFoundException, InterruptedException{
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    checkCheckBox(DebtorMaintenance.faxReminderLettersCheckbox);
  }
  protected static void checkfaxDDAgreementsCheckbox() throws FileNotFoundException, InterruptedException{
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    checkCheckBox(DebtorMaintenance.faxDDAgreementsCheckbox);
  }
  protected static void checkfaxDDmandatesCheckbox() throws FileNotFoundException, InterruptedException{
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    checkCheckBox(DebtorMaintenance.faxDDmandatesCheckbox);
  }
  protected static void setTelephoneNumberDesc(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad();
    objDebtorMaintenance = new DebtorMaintenance(driver);
    selectDropDown(DebtorMaintenance.dropdnTelephoneNumber, data);
  }
  protected static void setalternateTelephoneNumberDesc(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad();
    objDebtorMaintenance = new DebtorMaintenance(driver);
    DebtorMaintenance.setDropdnalternateTelephoneNumber(data);
  }
  protected static void setWebsiteForInsertAddress(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    DebtorMaintenance.setTxtWebsiteForInsertAddress(data);
  }
  protected static String setComment(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    setText(DebtorMaintenance.txtComment, data);
    comment=data;
    return comment;
  }
  public static void reviewDetails(String htmlTable,String[]reviewDetails) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDebtorMaintenance = new DebtorMaintenance(driver);
    for(String data: reviewDetails) {
      searchTableColumn(htmlTable,data);
    }
  }
  protected static void setTelephonenumForInsertContact(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    setText(DebtorMaintenance.txtAddressLine3, data);
  }
  public static void setMobilenumForInsertContact(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    setText(DebtorMaintenance.txtCountry, data);
  }
  protected static void setAlternateNumber(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    DebtorMaintenance.setTxtAlternateNumber(data);
  }
  protected static void setEmailForInsertContact(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad(); 
    objDebtorMaintenance = new DebtorMaintenance(driver);
    DebtorMaintenance.setTxtEmailForInsertContact(data);
  }
  protected static void setCommentsForInsertContact(String data) throws FileNotFoundException, InterruptedException{
    waitforPanelLoad();
    objDebtorMaintenance = new DebtorMaintenance(driver);
    setText(DebtorMaintenance.txtPostCode, data);
  }
  
  //end of class
}