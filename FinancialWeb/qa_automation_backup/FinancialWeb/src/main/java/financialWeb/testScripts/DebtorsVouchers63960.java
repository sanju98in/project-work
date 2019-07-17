package financialWeb.testScripts;

import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorsAuthoriseWorkflow;
import financialWeb.workflow.DebtorsEnquiriesWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;
import util.GenUtil;

public class DebtorsVouchers63960 extends DebtorsVouchersWorkflow {

  @Test(groups = {"configurationfailedtestcase"})
  public void createDBCreditNoteWithAuthorisation() throws InterruptedException, ParseException, IOException {
  
    uniqueDebtorNumber = DebtorMaintenanceWorkflow.createDebtor();
    searchText(testdataprop.getProperty("searchdbvouchers"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbvouchers"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchcdbcreditnote"));
    setTransactionCode(testdataprop.getProperty("transactioncode"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load")); 
    setCreditNoteDebtorNumber(uniqueDebtorNumber);
    selectReasonForCredit(testdataprop.getProperty("reasonforcredit"));
    String currentDate = GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle=driver.getWindowHandle();
    clickTaxPointDatepicker();
    getHandles();
    selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    clickGLDatepicker();
    selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addline")); 
    setDescription(testdataprop.getProperty("dbcreditlinedesc"));
    setDBCreditLineQty(testdataprop.getProperty("qty"));
    setDBCreditLinePrice(testdataprop.getProperty("rndtelephonelimit"));
    setDBCreditLineVat(testdataprop.getProperty("vtcode"));
    setDBCreditLineGLCode(testdataprop.getProperty("glcode"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    String amount = DebtorsEnquiriesWorkflow.getAmount();
    validateAmount(amount, testdataprop.getProperty("qty"),testdataprop.getProperty("rndtelephonelimit"));
    clickComplete();
    referenceNo = storeReferenceNo();
    searchText(testdataprop.getProperty("searchdbauthorise"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbauthorise"));
    
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchdbauthorisetrans"));
    DebtorsAuthoriseWorkflow.setDBAuthTransactionDebtorNumber(uniqueDebtorNumber);
    DebtorsAuthoriseWorkflow.setDBAuthTransactionReferenceOne(referenceNo);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    DebtorsAuthoriseWorkflow.selectAuthorize();
    clickAuthorise();
    
    searchText(testdataprop.getProperty("searchdbvouchers"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbvouchers"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchcdbcreditnote"));
    
    DebtorsVouchersWorkflow.setDBAuthTransactionReferenceOne(referenceNo);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    DebtorsVouchersWorkflow.validateDBCreditNoteAuthorizeStatus(msgprop.getProperty("authorise"));
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }

  
    
}
