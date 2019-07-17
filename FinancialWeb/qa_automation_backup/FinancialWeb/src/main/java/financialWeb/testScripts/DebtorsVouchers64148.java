package financialWeb.testScripts;
import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.pages.DebtorVouchersSalesInvoices;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorVouchersSalesInvoicesWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;
import util.GenUtil;

public class DebtorsVouchers64148 extends DebtorVouchersSalesInvoicesWorkflow{
  
  @Test(groups = {"smoke"})
  public void  setupInstallmentScheduleForInvoice() throws InterruptedException, ParseException, IOException {
       
    DebtorMaintenanceWorkflow.createDebtor();
    DebtorsVouchersWorkflow.createDBInvoice();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("instalment"));
    setInstalmentFrequency(testdataprop.getProperty("installmentfrequency"));
    String currentDate = GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle=driver.getWindowHandle();
    DebtorVouchersSalesInvoices.setDtFirstDate();
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    setNoOfInstalments(testdataprop.getProperty("rndtelephonelimit"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("apply"));   
    validateDueDate(orprop.getProperty("countduedate"));
    validateDueDate(orprop.getProperty("countamount"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert")); 
    clickDbInvoiceTab(); 
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("clear")); 
    DebtorsVouchersWorkflow.setDBAuthTransactionReferenceOne(referenceNo);
    DebtorsVouchersWorkflow.dbCreditNoteLoad();
    validateInstallmentStatus(msgprop.getProperty("beingpaidbyinstalments"));
    clickHrefLink(testdataprop.getProperty("home"));
       
    //signOut
    clickSignOut();    
  }
}