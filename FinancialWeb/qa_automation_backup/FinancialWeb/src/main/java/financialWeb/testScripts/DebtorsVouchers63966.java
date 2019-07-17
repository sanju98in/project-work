package financialWeb.testScripts;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorVouchersWorkflow;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorsAuthoriseWorkflow;
import financialWeb.workflow.DebtorsEnquiriesWorkflow;
import financialWeb.workflow.DebtorsInvoiceWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;
import util.GenUtil;


public class DebtorsVouchers63966 extends DebtorsVouchersWorkflow{

  @Test(groups = {"smoke"})
  public void createDbInvoiceWithAuthorisation() throws Exception {
        
    uniqueDebtorNumber = DebtorMaintenanceWorkflow.createDebtor();
    searchText(testdataprop.getProperty("searchdbvouchers"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchdbvouchers"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchcdbinvoice"));
    setTransactionCode(testdataprop.getProperty("transactioncodeforsalesinvoice"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    CreditorVouchersWorkflow.setCreditorNumber(uniqueDebtorNumber);
    String currentDate = GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle=driver.getWindowHandle();
    DebtorsInvoiceWorkflow.setDBInvoiceGLDate();
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    DebtorsVouchersWorkflow.setDtGlDate();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate")); 
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addline"));
    setDescription(testdataprop.getProperty("comment"));
    setDBCreditLineQty(testdataprop.getProperty("qty"));
    setDBCreditLinePrice(testdataprop.getProperty("rndtelephonelimit"));
    setDBCreditLineVat(testdataprop.getProperty("vtcode"));
    DebtorsInvoiceWorkflow.setGLCode(testdataprop.getProperty("glcode"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
     String amount = DebtorsEnquiriesWorkflow.getAmount();
    validateDBVoucherAmount(amount, testdataprop.getProperty("qty"),testdataprop.getProperty("rndtelephonelimit"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    referenceNo = storeReferenceNo();
    searchText(testdataprop.getProperty("searchdbauthorise"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchdbauthorise"));    
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchdbauthorisetrans"));
    DebtorsAuthoriseWorkflow.setDBAuthTransactionDebtorNumber(uniqueDebtorNumber);
    DebtorsAuthoriseWorkflow.setDBAuthTransactionReferenceOne(referenceNo);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    DebtorsAuthoriseWorkflow.selectAuthorize();
    clickAuthorise();
    searchText(testdataprop.getProperty("searchdbvouchers"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchdbvouchers"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchcdbinvoice"));
    DebtorsVouchersWorkflow.setDBAuthTransactionReferenceOne(referenceNo);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    DebtorsInvoiceWorkflow.validateDBInvoiceAuthorizeStatus(msgprop.getProperty("authorise"));
    clickHrefLink(testdataprop.getProperty("home"));
       
    //signOut
    clickSignOut();    
  }
}