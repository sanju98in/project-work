package financialWeb.testScripts;
import org.testng.annotations.Test;
import financialWeb.pages.DebtorsInvoice;
import financialWeb.workflow.CreditorPaymentsWorkflow;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorsAuthoriseWorkflow;
import financialWeb.workflow.DebtorsEnquiriesWorkflow;
import financialWeb.workflow.DebtorsInvoiceWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;
import util.GenUtil;

public class DebtorEnquiries64828 extends DebtorsEnquiriesWorkflow{
  
  @Test(groups = {"smoke"})
  public void  viewDBAgedDebtEnquiryInvoiceDue30To59Days () throws Exception {
            
    uniqueDebtorNumber=DebtorMaintenanceWorkflow.createDebtor();     
    searchText(testdataprop.getProperty("searchdbvouchers"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchdbvouchers"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchcdbinvoice"));
    waitforPanelLoad();
    DebtorsVouchersWorkflow.setTransactionCode(testdataprop.getProperty("inv001transactioncode"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load")); 
    CreditorPaymentsWorkflow.setUniqueNumber(uniqueDebtorNumber);    
    String currentDate = GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle=driver.getWindowHandle();
    DebtorsInvoiceWorkflow.setDBInvoiceGLDate();
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    DebtorsVouchersWorkflow.setDtGlDate();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    setDtDueDate();
    setDueDateAsOneMonthOlderDate(testdataprop.getProperty("pastdate"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addline")); 
    DebtorsVouchersWorkflow.setDescription(testdataprop.getProperty("comment"));
    DebtorsVouchersWorkflow.setDBCreditLineQty(testdataprop.getProperty("qty"));
    DebtorsVouchersWorkflow.setDBCreditLinePrice(testdataprop.getProperty("rndtelephonelimit"));
    DebtorsVouchersWorkflow.setDBCreditLineVat(testdataprop.getProperty("vtcode"));
    DebtorsInvoice.setGLCode(testdataprop.getProperty("glcode"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    String amount = DebtorsVouchersWorkflow.getDBInvoiceAmount();
    DebtorsVouchersWorkflow.validateDBVoucherAmount(amount, testdataprop.getProperty("qty"),testdataprop.getProperty("rndtelephonelimit"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    referenceNo = DebtorsVouchersWorkflow.storeReferenceNo();
    DebtorsInvoiceWorkflow.validateDBInvoiceAuthorizeStatus(msgprop.getProperty("authorise"));
    searchText(testdataprop.getProperty("searchdbenquiry"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchdbenquiry"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchdbageddebtenquiry"));   
    DebtorsAuthoriseWorkflow.setDBAuthTransactionDebtorNumber(uniqueDebtorNumber);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    searchTableColumn(orprop.getProperty("findinvoicetable"),uniqueDebtorNumber);
    searchTableColumn(orprop.getProperty("findinvoicetable"),fullName);
    verifyNotYetDueAmount(orprop.getProperty("findinvoicetable"),amount);
    calculateTotalOutStandingAmt(orprop.getProperty("debtorenquirytable"));   
    clickHrefLink(testdataprop.getProperty("home"));
    //signOut
    clickSignOut();   
  }

}