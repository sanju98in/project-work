/*package financialWeb.workflow;

import java.io.FileNotFoundException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import financialWeb.pages.PreRequisitesPage;

public class PreRequisiteWorkflow extends CommonWorkflow{

  public static PreRequisitesPage objPreRequisitesPage;
  
  
   Global variable for Debtor
   

  public static String dbTransCode = null;
  public static String dbDesc = null; 
  public static String keyOneValue = null; 
  public static String prefix = null; 
  
  public static void preRequisiteDebtorSetup() throws FileNotFoundException, InterruptedException {
    objPreRequisitesPage = new PreRequisitesPage(driver);
    log.info("*Setup Debtor started*");  
    
    log.info("*#82488 - Steps to Create Transaction Code for DB Invoice with authorisation*");
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    searchText(prerequisitesdataprop.getProperty("searchdbinvoicerules"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),prerequisitesdataprop.getProperty("searchdbinvoicerules"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addnew"));
    dbTransCode = getRandomNumber(testdataprop.getProperty("chargecode"))+prerequisitesdataprop.getProperty("transcodeendkeyword");;
    setText(PreRequisitesPage.txtTransactionCode,dbTransCode);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    dbDesc=getRandomString();
    setText(PreRequisitesPage.txtDescription,dbDesc);
    keyOneValue = getRandomNumber(testdataprop.getProperty("lengthlimit"));
    setText(PreRequisitesPage.txtKeyOneValue,keyOneValue);
    prefix = getRandomAlphaNumericValue(testdataprop.getProperty("accesslevel3"));
    setText(PreRequisitesPage.txtPrefix,prefix);
    selectDropDown(PreRequisitesPage.drpdnInvoiceAuthorisation,prerequisitesdataprop.getProperty("invpiceauthorisation"));
    checkCheckBox(PreRequisitesPage.chkAllowNegativeQty);
    checkCheckBox(PreRequisitesPage.chkDisplayTxtDebtorRecord);
    checkCheckBox(PreRequisitesPage.chkAllowZeroValueInvoices);
    selectDropDown(PreRequisitesPage.drpdnDefaultNextPrintStatus,prerequisitesdataprop.getProperty("defaultnextprintstatus"));
    selectDropDown(PreRequisitesPage.drpdnTypeOfSupply,prerequisitesdataprop.getProperty("defaulttypeofsupply"));
    selectDropDown(PreRequisitesPage.drpdnDefaultPrintReportStyle,prerequisitesdataprop.getProperty("defaultprintnowreportstyle"));
    selectDropDown(PreRequisitesPage.drpdnDefaultPrintExactReportStyle,prerequisitesdataprop.getProperty("defaultprintexactcopyreportstyle"));
    checkCheckBox(PreRequisitesPage.chkAllowDDOnInvoiceWithoutInstallments);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    searchText(prerequisitesdataprop.getProperty("searchcousergroupmaint"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),prerequisitesdataprop.getProperty("searchcousergroupmaint"));
    setDrpdnCompany();
    setDrpdnModule();
    selectDropDown(PreRequisitesPage.drpdnUserGroupName,prerequisitesdataprop.getProperty("usergroupname"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    checkTransactionCodeCheckBox();
    unCheckCheckBox(PreRequisitesPage.chkSuspend);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    searchText(prerequisitesdataprop.getProperty("searchdbnumberrange"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),prerequisitesdataprop.getProperty("searchdbnumberrange"));
    selectDropDown(PreRequisitesPage.drpdnRangeType,prerequisitesdataprop.getProperty("rangetype"));
    waitforPanelLoad();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    setText(PreRequisitesPage.txtTransCodeKey,dbTransCode);
    setText(PreRequisitesPage.txtDeptSectKey,prerequisitesdataprop.getProperty("deptorseckey"));
    selectDropDown(PreRequisitesPage.drpdnPrefixOne,prerequisitesdataprop.getProperty("prefixone"));
    setText(PreRequisitesPage.txtRangeFrom,prerequisitesdataprop.getProperty("rangefrom"));
    setText(PreRequisitesPage.txtRangeTo,prerequisitesdataprop.getProperty("rangeto"));
    setText(PreRequisitesPage.txtLastNumber,prerequisitesdataprop.getProperty("rangefrom"));
    setText(PreRequisitesPage.txtLength,testdataprop.getProperty("classificationcodelimit"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("close"));
    searchText(testdataprop.getProperty("searchcdbinvoice"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchcdbinvoice"));
    selectDropDownValue(PreRequisitesPage.drpdnTransCode,dbTransCode);
    
    log.info("*#82488- Completed Transaction Code for DB Invoice with authorisation.*");
    
    log.info("*#82496 - Steps to Create Transaction Code for Credit Note with Authorisation.*");
    
    searchText(prerequisitesdataprop.getProperty("searchdbcreditnoterules"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),prerequisitesdataprop.getProperty("searchdbcreditnoterules"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addnew"));
    dbTransCode = getRandomNumber(testdataprop.getProperty("chargecode"))+prerequisitesdataprop.getProperty("transcodeendkeyword");
    setText(PreRequisitesPage.txtTransactionCode,dbTransCode);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    dbDesc=getRandomString();
    setText(PreRequisitesPage.txtDescription,dbDesc);
    keyOneValue = getRandomNumber(testdataprop.getProperty("lengthlimit"));
    setText(PreRequisitesPage.txtKeyOneValue,keyOneValue);
    prefix = getRandomAlphaNumericValue(testdataprop.getProperty("accesslevel3"));
    setText(PreRequisitesPage.txtPrefix,prefix);
    selectDropDown(PreRequisitesPage.drpdnInvoiceAuthorisation,prerequisitesdataprop.getProperty("invpiceauthorisation"));
    checkCheckBox(PreRequisitesPage.chkNegativeQtyAllow);
    checkCheckBox(PreRequisitesPage.chkAllowPostingGlYearInCloseDown);
    selectDropDown(PreRequisitesPage.drpdnReason,prerequisitesdataprop.getProperty("reason"));
    selectDropDown(PreRequisitesPage.drpdnCrNoteDefaultPrintStatus,prerequisitesdataprop.getProperty("crnotedefaultprintstatus"));
    selectDropDown(PreRequisitesPage.drpdnCrNoteDefaultTypeOfSupply,prerequisitesdataprop.getProperty("crnotedefaulttypeofsupply"));
    checkCheckBox(PreRequisitesPage.chkUnallocatedAmount);
    selectDropDown(PreRequisitesPage.drpdnCrNoteDefaulrPrintNowReportStyle,prerequisitesdataprop.getProperty("crnotedefaultprintnowreportstyle"));
    selectDropDown(PreRequisitesPage.drpdnCrNoteDefaultPrintExactCopyReportStyle,prerequisitesdataprop.getProperty("crnotedefaultprintexactcopyreportstyle"));
    checkCheckBox(PreRequisitesPage.chkDepartmentAndSectionInvoice);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    searchText(prerequisitesdataprop.getProperty("searchcousergroupmaint"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),prerequisitesdataprop.getProperty("searchcousergroupmaint"));
    setDrpdnCompany();
    setDrpdnModule();
    selectDropDown(PreRequisitesPage.drpdnUserGroupName,prerequisitesdataprop.getProperty("usergroupname"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    checkTransactionCodeCheckBox();
    unCheckCheckBox(PreRequisitesPage.chkSuspend);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    searchText(prerequisitesdataprop.getProperty("searchdbnumberrange"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),prerequisitesdataprop.getProperty("searchdbnumberrange"));
    selectDropDown(PreRequisitesPage.drpdnRangeType,prerequisitesdataprop.getProperty("dbnumberrange"));
    waitforPanelLoad();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    setText(PreRequisitesPage.txtTransCodeKey,dbTransCode);
    setText(PreRequisitesPage.txtDeptSectKey,prerequisitesdataprop.getProperty("deptorseckey"));
    selectDropDown(PreRequisitesPage.drpdnPrefixOne,prerequisitesdataprop.getProperty("prefixone"));
    setText(PreRequisitesPage.txtRangeFrom,prerequisitesdataprop.getProperty("rangefrom"));
    setText(PreRequisitesPage.txtRangeTo,prerequisitesdataprop.getProperty("rangeto"));
    setText(PreRequisitesPage.txtLastNumber,prerequisitesdataprop.getProperty("rangefrom"));
    setText(PreRequisitesPage.txtLength,testdataprop.getProperty("classificationcodelimit"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("close"));
    searchText(testdataprop.getProperty("searchcdbcreditnote"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchcdbcreditnote"));
    selectDropDownValue(PreRequisitesPage.drpdnTransCode,dbTransCode);
    
    log.info("*#82496 - Completed Transaction Code for Credit Note with Authorisation.*");
    
    log.info("*#82492 - Steps to Create Transaction Code for DB PIM.*");
    
    searchText(prerequisitesdataprop.getProperty("searchdbpimrules"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),prerequisitesdataprop.getProperty("searchdbpimrules"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addnew"));
    dbTransCode = getRandomNumber(testdataprop.getProperty("chargecode"))+prerequisitesdataprop.getProperty("transcodeendkeyword");
    setText(PreRequisitesPage.txtTransactionCode,dbTransCode);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    dbDesc=getRandomString();
    setText(PreRequisitesPage.txtDescription,dbDesc);
    keyOneValue = getRandomNumber(testdataprop.getProperty("lengthlimit"));
    setText(PreRequisitesPage.txtKeyOneValue,keyOneValue);
    prefix = getRandomAlphaNumericValue(testdataprop.getProperty("accesslevel3"));
    setText(PreRequisitesPage.txtPrefix,prefix);
    selectDropDown(PreRequisitesPage.drpdnAutoGenPimNumber,prerequisitesdataprop.getProperty("autogeneratedpimnumber"));
    checkCheckBox(PreRequisitesPage.chkDisplayTextFromDebtor);
    checkCheckBox(PreRequisitesPage.chkAllowZeroValuePIMToBeEntered);
    selectDropDownValue(PreRequisitesPage.drpdnPimDefaultPrintStatus,prerequisitesdataprop.getProperty("defaultnextprintstatus"));
    checkCheckBox(PreRequisitesPage.chkUnallocatedCashHeldAgainstPim);
    selectDropDown(PreRequisitesPage.drpdnTransCodeForInvoiceGeneration,prerequisitesdataprop.getProperty("transcodeforinvoicegeneration"));
    checkCheckBox(PreRequisitesPage.chkPrintMandateReqByDefault);
    checkCheckBox(PreRequisitesPage.chkPrintAgreementLetterByDefault);
    selectDropDown(PreRequisitesPage.drpdnGlPeriodOverride,prerequisitesdataprop.getProperty("glperiodoverride"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    searchText(prerequisitesdataprop.getProperty("searchcousergroupmaint"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),prerequisitesdataprop.getProperty("searchcousergroupmaint"));
    setDrpdnCompany();
    setDrpdnModule();
    selectDropDown(PreRequisitesPage.drpdnUserGroupName,prerequisitesdataprop.getProperty("usergroupname"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    checkTransactionCodeCheckBox();
    unCheckCheckBox(PreRequisitesPage.chkSuspend);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    searchText(prerequisitesdataprop.getProperty("searchdbnumberrange"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),prerequisitesdataprop.getProperty("searchdbnumberrange"));
    selectDropDown(PreRequisitesPage.drpdnRangeType,prerequisitesdataprop.getProperty("pimrangetype"));
    waitforPanelLoad();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    setText(PreRequisitesPage.txtTransCodeKey,dbTransCode);
    setText(PreRequisitesPage.txtDeptSectKey,prerequisitesdataprop.getProperty("deptorseckey"));
    selectDropDown(PreRequisitesPage.drpdnPrefixOne,prerequisitesdataprop.getProperty("prefixone"));
    setText(PreRequisitesPage.txtRangeFrom,prerequisitesdataprop.getProperty("rangefrom"));
    setText(PreRequisitesPage.txtRangeTo,prerequisitesdataprop.getProperty("rangeto"));
    setText(PreRequisitesPage.txtLastNumber,prerequisitesdataprop.getProperty("rangefrom"));
    setText(PreRequisitesPage.txtLength,testdataprop.getProperty("classificationcodelimit"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("close"));
    searchText(testdataprop.getProperty("dbperiodicinvoicemaster"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("dbperiodicinvoicemaster"));
    selectDropDownValue(PreRequisitesPage.drpdnTransCode,dbTransCode);
       
    log.info("*#82492 - Completed Transaction Code for DB PIM.*");
    
    log.info("*#82491 - Steps to Create Transaction Code for DB Invoice w/o authorisation.*");
    
    searchText(prerequisitesdataprop.getProperty("searchdbinvoicerules"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),prerequisitesdataprop.getProperty("searchdbinvoicerules"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addnew"));
    dbTransCode = getRandomNumber(testdataprop.getProperty("chargecode"))+prerequisitesdataprop.getProperty("transcodeendkeyword");;
    setText(PreRequisitesPage.txtTransactionCode,dbTransCode);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    dbDesc=getRandomString();
    setText(PreRequisitesPage.txtDescription,dbDesc);
    keyOneValue = getRandomNumber(testdataprop.getProperty("lengthlimit"));
    setText(PreRequisitesPage.txtKeyOneValue,keyOneValue);
    prefix = getRandomAlphaNumericValue(testdataprop.getProperty("accesslevel3"));
    setText(PreRequisitesPage.txtPrefix,prefix);
    checkCheckBox(PreRequisitesPage.chkAllowNegativeQty);
    checkCheckBox(PreRequisitesPage.chkDisplayTxtDebtorRecord);
    checkCheckBox(PreRequisitesPage.chkAllowZeroValueInvoices);
    removeNumberOfDaysToRaiseInvoice();
    selectDropDown(PreRequisitesPage.drpdnDefaultNextPrintStatus,prerequisitesdataprop.getProperty("defaultnextprintstatus"));
    selectDropDown(PreRequisitesPage.drpdnTypeOfSupply,prerequisitesdataprop.getProperty("defaulttypeofsupply"));
    selectDropDown(PreRequisitesPage.drpdnDefaultPrintReportStyle,prerequisitesdataprop.getProperty("defaultprintnowreportstyle"));
    selectDropDown(PreRequisitesPage.drpdnDefaultPrintExactReportStyle,prerequisitesdataprop.getProperty("defaultprintexactcopyreportstyle"));
    checkCheckBox(PreRequisitesPage.chkAllowDDOnInvoiceWithoutInstallments);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    searchText(prerequisitesdataprop.getProperty("searchcousergroupmaint"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),prerequisitesdataprop.getProperty("searchcousergroupmaint"));
    setDrpdnCompany();
    setDrpdnModule();
    selectDropDown(PreRequisitesPage.drpdnUserGroupName,prerequisitesdataprop.getProperty("usergroupname"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    checkTransactionCodeCheckBox();
    unCheckCheckBox(PreRequisitesPage.chkSuspend);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    searchText(prerequisitesdataprop.getProperty("searchdbnumberrange"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),prerequisitesdataprop.getProperty("searchdbnumberrange"));
    selectDropDown(PreRequisitesPage.drpdnRangeType,prerequisitesdataprop.getProperty("rangetype"));
    waitforPanelLoad();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    setText(PreRequisitesPage.txtTransCodeKey,dbTransCode);
    setText(PreRequisitesPage.txtDeptSectKey,prerequisitesdataprop.getProperty("deptorseckey"));
    selectDropDown(PreRequisitesPage.drpdnPrefixOne,prerequisitesdataprop.getProperty("prefixone"));
    setText(PreRequisitesPage.txtRangeFrom,prerequisitesdataprop.getProperty("rangefrom"));
    setText(PreRequisitesPage.txtRangeTo,prerequisitesdataprop.getProperty("rangeto"));
    setText(PreRequisitesPage.txtLastNumber,prerequisitesdataprop.getProperty("rangefrom"));
    setText(PreRequisitesPage.txtLength,testdataprop.getProperty("classificationcodelimit"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("close"));
    searchText(testdataprop.getProperty("searchcdbinvoice"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchcdbinvoice"));
    selectDropDownValue(PreRequisitesPage.drpdnTransCode,dbTransCode);
    log.info("*#82491 - Completed Transaction Code for DB Invoice w/o authorisation.*");
    
    log.info("*#82497 - Steps to Create Transaction Code for Credit Note w/o Authorisation.*");
    
    searchText(prerequisitesdataprop.getProperty("searchdbcreditnoterules"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),prerequisitesdataprop.getProperty("searchdbcreditnoterules"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addnew"));
    dbTransCode = getRandomNumber(testdataprop.getProperty("chargecode"))+prerequisitesdataprop.getProperty("transcodeendkeyword");
    setText(PreRequisitesPage.txtTransactionCode,dbTransCode);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    dbDesc=getRandomString();
    setText(PreRequisitesPage.txtDescription,dbDesc);
    keyOneValue = getRandomNumber(testdataprop.getProperty("lengthlimit"));
    setText(PreRequisitesPage.txtKeyOneValue,keyOneValue);
    prefix = getRandomAlphaNumericValue(testdataprop.getProperty("accesslevel3"));
    setText(PreRequisitesPage.txtPrefix,prefix);
    selectDropDown(PreRequisitesPage.drpdnAutoGenerateControlNumber,prerequisitesdataprop.getProperty("crnoteautogeneratecontrolnumber")); 
    selectDropDown(PreRequisitesPage.drpdnControlExpAmtRequired,prerequisitesdataprop.getProperty("controlexpectedamountrequired"));
    selectDropDown(PreRequisitesPage.drpdnControlExpNumberRequired,prerequisitesdataprop.getProperty("controlexpectedamountrequired"));
    selectDropDown(PreRequisitesPage.drpdnAutoGenCrNoteNumber,prerequisitesdataprop.getProperty("autogeneratedpimnumber"));
    selectDropDown(PreRequisitesPage.drpdnAdditionalRefRequired,prerequisitesdataprop.getProperty("controlexpectedamountrequired"));
    checkCheckBox(PreRequisitesPage.chkNegativeQtyAllow);  
    checkCheckBox(PreRequisitesPage.chkAllowPostingGlYearInCloseDown);
    selectDropDown(PreRequisitesPage.drpdnCrNoteDefaultPrintStatus,prerequisitesdataprop.getProperty("crnotedefaultprintstatus"));
    selectDropDown(PreRequisitesPage.drpdnCrNoteDefaultTypeOfSupply,prerequisitesdataprop.getProperty("unauthorisedcrnotetypeofsupply"));
    checkCheckBox(PreRequisitesPage.chkUnallocatedAmount);
    checkCheckBox(PreRequisitesPage.chkAdjustUseOrgDeptAndSection);  
    selectDropDown(PreRequisitesPage.drpdnCrNoteDefaulrPrintNowReportStyle,prerequisitesdataprop.getProperty("unauthorisedcrnotereportstyle"));
    selectDropDown(PreRequisitesPage.drpdnCrNoteDefaultPrintExactCopyReportStyle,prerequisitesdataprop.getProperty("crnotedefaultprintexactcopyreportstyle"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    searchText(prerequisitesdataprop.getProperty("searchcousergroupmaint"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),prerequisitesdataprop.getProperty("searchcousergroupmaint"));
    setDrpdnCompany();
    setDrpdnModule();
    selectDropDown(PreRequisitesPage.drpdnUserGroupName,prerequisitesdataprop.getProperty("usergroupname"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    checkTransactionCodeCheckBox();
    unCheckCheckBox(PreRequisitesPage.chkSuspend);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    searchText(prerequisitesdataprop.getProperty("searchdbnumberrange"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),prerequisitesdataprop.getProperty("searchdbnumberrange"));
    selectDropDown(PreRequisitesPage.drpdnRangeType,prerequisitesdataprop.getProperty("dbnumberrange"));
    waitforPanelLoad();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    setText(PreRequisitesPage.txtTransCodeKey,dbTransCode);
    setText(PreRequisitesPage.txtDeptSectKey,prerequisitesdataprop.getProperty("deptorseckey"));
    selectDropDown(PreRequisitesPage.drpdnPrefixOne,prerequisitesdataprop.getProperty("prefixone"));
    setText(PreRequisitesPage.txtRangeFrom,prerequisitesdataprop.getProperty("rangefrom"));
    setText(PreRequisitesPage.txtRangeTo,prerequisitesdataprop.getProperty("rangeto"));
    setText(PreRequisitesPage.txtLastNumber,prerequisitesdataprop.getProperty("rangefrom"));
    setText(PreRequisitesPage.txtLength,testdataprop.getProperty("classificationcodelimit"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("close"));
    searchText(testdataprop.getProperty("searchcdbcreditnote"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchcdbcreditnote"));
    selectDropDownValue(PreRequisitesPage.drpdnTransCode,dbTransCode);
    
    log.info("*#82497 - Completed Transaction Code for Credit Note w/o Authorisation.*");
    
    log.info("*#82697 - Steps to Create Transaction Code for Payment with authorisation.*");
    
    searchText(prerequisitesdataprop.getProperty("searchdbpaymentrules"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),prerequisitesdataprop.getProperty("searchdbpaymentrules"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addnew"));
    dbTransCode = getRandomNumber(testdataprop.getProperty("chargecode"))+prerequisitesdataprop.getProperty("transcodeendkeyword");
    setText(PreRequisitesPage.txtTransactionCode,dbTransCode);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    dbDesc=getRandomString();
    setText(PreRequisitesPage.txtDescription,dbDesc);
    String refOne=getRandomString();
    setText(PreRequisitesPage.txtRefrenceOneCaption,refOne);
    String refTwo=getRandomString();
    setText(PreRequisitesPage.txtRefrenceTwoCaption,refTwo);  
    keyOneValue = getRandomNumber(testdataprop.getProperty("lengthlimit"));
    setText(PreRequisitesPage.txtKeyOneValue,keyOneValue);
    prefix = getRandomAlphaNumericValue(testdataprop.getProperty("accesslevel3"));
    setText(PreRequisitesPage.txtPrefix,prefix);
    selectDropDown(PreRequisitesPage.drpdnPaymentAuthorisation,prerequisitesdataprop.getProperty("invpiceauthorisation")); 
    
    selectDropDown(PreRequisitesPage.drpdnControlExpAmtRequired,prerequisitesdataprop.getProperty("controlexpectedamountrequired"));
    selectDropDown(PreRequisitesPage.drpdnControlExpNumberRequired,prerequisitesdataprop.getProperty("controlexpectedamountrequired"));
    selectDropDown(PreRequisitesPage.drpdnAutoGenCrNoteNumber,prerequisitesdataprop.getProperty("autogeneratedpimnumber"));
    selectDropDown(PreRequisitesPage.drpdnAdditionalRefRequired,prerequisitesdataprop.getProperty("controlexpectedamountrequired"));
    checkCheckBox(PreRequisitesPage.chkNegativeQtyAllow);  
    checkCheckBox(PreRequisitesPage.chkAllowPostingGlYearInCloseDown);
    selectDropDown(PreRequisitesPage.drpdnCrNoteDefaultPrintStatus,prerequisitesdataprop.getProperty("crnotedefaultprintstatus"));
    selectDropDown(PreRequisitesPage.drpdnCrNoteDefaultTypeOfSupply,prerequisitesdataprop.getProperty("unauthorisedcrnotetypeofsupply"));
    checkCheckBox(PreRequisitesPage.chkUnallocatedAmount);
    checkCheckBox(PreRequisitesPage.chkAdjustUseOrgDeptAndSection);  
    selectDropDown(PreRequisitesPage.drpdnCrNoteDefaulrPrintNowReportStyle,prerequisitesdataprop.getProperty("unauthorisedcrnotereportstyle"));
    selectDropDown(PreRequisitesPage.drpdnCrNoteDefaultPrintExactCopyReportStyle,prerequisitesdataprop.getProperty("crnotedefaultprintexactcopyreportstyle"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    searchText(prerequisitesdataprop.getProperty("searchcousergroupmaint"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),prerequisitesdataprop.getProperty("searchcousergroupmaint"));
    setDrpdnCompany();
    setDrpdnModule();
    selectDropDown(PreRequisitesPage.drpdnUserGroupName,prerequisitesdataprop.getProperty("usergroupname"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    checkTransactionCodeCheckBox();
    unCheckCheckBox(PreRequisitesPage.chkSuspend);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    searchText(prerequisitesdataprop.getProperty("searchdbnumberrange"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),prerequisitesdataprop.getProperty("searchdbnumberrange"));
    selectDropDown(PreRequisitesPage.drpdnRangeType,prerequisitesdataprop.getProperty("dbnumberrange"));
    waitforPanelLoad();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    setText(PreRequisitesPage.txtTransCodeKey,dbTransCode);
    setText(PreRequisitesPage.txtDeptSectKey,prerequisitesdataprop.getProperty("deptorseckey"));
    selectDropDown(PreRequisitesPage.drpdnPrefixOne,prerequisitesdataprop.getProperty("prefixone"));
    setText(PreRequisitesPage.txtRangeFrom,prerequisitesdataprop.getProperty("rangefrom"));
    setText(PreRequisitesPage.txtRangeTo,prerequisitesdataprop.getProperty("rangeto"));
    setText(PreRequisitesPage.txtLastNumber,prerequisitesdataprop.getProperty("rangefrom"));
    setText(PreRequisitesPage.txtLength,testdataprop.getProperty("classificationcodelimit"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("close"));
    searchText(testdataprop.getProperty("searchcdbcreditnote"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchcdbcreditnote"));
    selectDropDownValue(PreRequisitesPage.drpdnTransCode,dbTransCode);
    
    log.info("*#82497 - Completed Transaction Code for Payment with authorisation.*");
    
    clickHrefLink(testdataprop.getProperty("home"));
    
    log.info("*Setup Debtor Completed*");
    
  }
  
  
  
  public static void setDrpdnCompany() throws InterruptedException {
    selectDropDown(PreRequisitesPage.drpdnCompany,prerequisitesdataprop.getProperty("company"));
    PreRequisitesPage.drpdnCompany.sendKeys(Keys.TAB);
    Thread.sleep(3000);    
  }
  
  public static void setDrpdnModule() throws InterruptedException {
    selectDropDown(PreRequisitesPage.drpdnModule,testdataprop.getProperty("typeofnote"));
    PreRequisitesPage.drpdnModule.sendKeys(Keys.TAB);
    Thread.sleep(3000);    
  }
  
  public static void removeNumberOfDaysToRaiseInvoice() throws InterruptedException {
    PreRequisitesPage.txtNumberOfDaysPriorToRaiseInvoice.clear();
  }
  
  public static void checkTransactionCodeCheckBox() throws InterruptedException {
    log.debug("Checking checkbox");
    boolean found = false;
    List<WebElement> listCheckBoxes = driver.findElements(By.cssSelector("input:not(:checked)[type='checkbox']"));
      for(int i=0;i<listCheckBoxes.size();i++) {
        if(listCheckBoxes.get(i).isDisplayed()) {
            log.info(listCheckBoxes.get(i));
            found = listCheckBoxes.get(i).isSelected();
            if(!found) {
              scrollToView(listCheckBoxes.get(i));
              listCheckBoxes.get(i).click();
            }
          }
        }
      log.info(KEYWORD_PASS + " clicked checkbox ");
  }
  
  public static void preRequisiteTestSetup() throws FileNotFoundException, InterruptedException {
    preRequisiteDebtorSetup();
    
  } 

//end of class
}
*/