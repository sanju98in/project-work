package financialWeb.testScripts;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorVouchersWorkflow;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorsEnquiriesWorkflow;
import financialWeb.workflow.DebtorsInvoiceWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;
import util.GenUtil;


public class DebtorsVouchers63968 extends DebtorsVouchersWorkflow{

  @Test(groups = {"smoke"})
  public void createDbInvoiceByExistingInvoice() throws Exception {
    
    uniqueDebtorNumber = DebtorMaintenanceWorkflow.createDebtor();
    searchText(testdataprop.getProperty("searchdbvouchers"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchdbvouchers"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchcdbinvoice"));
    setTransactionCode(testdataprop.getProperty("inv001transactioncode")); 
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
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("repeat"));
  
    validateDBCreditNoteTransCode(testdataprop.getProperty("inv001transactioncode"));
    validateDBInvoiceAmount(amount);
    validateDBDescription(testdataprop.getProperty("comment"));
    validateDBQty(testdataprop.getProperty("qty"));
    validateDbCreditLinePrice(msgprop.getProperty("price"));
    validateDBCreditLineVat(testdataprop.getProperty("vtcode"));
    String glCode = DebtorsInvoiceWorkflow.getGLCode();
    DebtorsInvoiceWorkflow.validatetxtDBInvoiceGLCode(glCode);
    setDebtorInvoice(uniqueDebtorNumber);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    clickHrefLink(testdataprop.getProperty("home"));
       
    //signOut
    clickSignOut();    
  }
}