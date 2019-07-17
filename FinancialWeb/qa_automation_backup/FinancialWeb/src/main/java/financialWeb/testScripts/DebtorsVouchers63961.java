package financialWeb.testScripts;

import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorsEnquiriesWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;
import util.GenUtil;

public class DebtorsVouchers63961 extends DebtorsVouchersWorkflow {

 @Test(groups = {"smoke"})
  public void createDBCreditNoteWithoutAuthorisation() throws InterruptedException, ParseException, IOException {
  
    uniqueDebtorNumber = DebtorMaintenanceWorkflow.createDebtor();
    searchText(testdataprop.getProperty("searchdbvouchers"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbvouchers"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchcdbcreditnote"));
    setTransactionCode(testdataprop.getProperty("crnotetransactioncode"));
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
      DebtorsVouchersWorkflow.validateDBCreditNoteAuthorizeStatus(msgprop.getProperty("authorise"));
    
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }

  
    
}
