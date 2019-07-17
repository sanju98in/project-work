package financialWeb.testScripts;
import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.pages.DebtorVouchersSalesInvoices;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorVouchersSalesInvoicesWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;
import util.GenUtil;

public class DebtorsVouchers64147 extends DebtorVouchersSalesInvoicesWorkflow{
  
  
  @Test(groups = {"smoke"})
  public void  createDBPeriodicInvoiceMaster() throws InterruptedException, ParseException, IOException {
        
    DebtorMaintenanceWorkflow.createDebtor();
    searchText(testdataprop.getProperty("searchdbvouchers"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchdbvouchers"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("dbperiodicinvoicemaster"));
    DebtorsVouchersWorkflow.setTransactionCode(testdataprop.getProperty("pimtransactioncode"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load")); 
    setRandomWebElementValue(msgprop.getProperty("lbldebtornumber"), uniqueMaintenanceNumber);
    setFrequency(testdataprop.getProperty("updatedunitofcharge"));
    setInvToGenerate(testdataprop.getProperty("updatedprice"));
    String currentDate = GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle=driver.getWindowHandle();
    selectRandomWebElementCalendarImage(msgprop.getProperty("lblstartdate"));
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    selectRandomWebElementCalendarImage(msgprop.getProperty("lblnextdate"));
    setNextDate();
    setCommentForPIM(testdataprop.getProperty("comment"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addline")); 
    DebtorsVouchersWorkflow.setDescription(testdataprop.getProperty("commentforpim"));
    DebtorsVouchersWorkflow.setDBCreditLineQty(testdataprop.getProperty("qtyforpim"));
    DebtorsVouchersWorkflow.setDBCreditLinePrice(testdataprop.getProperty("priceforpim"));
    DebtorsVouchersWorkflow.setDBCreditLineVat(testdataprop.getProperty("vtcode"));
    DebtorVouchersSalesInvoices.setTxtPIMGlCode(testdataprop.getProperty("glcode"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    selectRandomWebElementCalendarImage(msgprop.getProperty("lblenddate"));
    setEndDate();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save")); 
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete")); 
    clickHrefLink(testdataprop.getProperty("home"));
    
    //signOut
    clickSignOut();   
  }
}