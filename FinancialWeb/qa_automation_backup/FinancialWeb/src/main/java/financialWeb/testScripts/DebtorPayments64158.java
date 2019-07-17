package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorPaymentsWorkflow;
import financialWeb.workflow.DebtorsCreditNotesWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;
import util.GenUtil;

public class DebtorPayments64158 extends DebtorPaymentsWorkflow{
  
 @Test(groups = {"smoke"})
  public void  partlyAllocateManualPaymentToMultipleInvoices() throws InterruptedException, ParseException, IOException, URISyntaxException {
            
    uniqueMaintenanceNumber= DebtorMaintenanceWorkflow.createDebtor();
    String oldReferenceNo=DebtorsVouchersWorkflow.createDBInvoice();
    referenceNo=DebtorsVouchersWorkflow.createDBInvoice();
    searchText(testdataprop.getProperty("searchdbpayments"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchdbpayments"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchdbmanualpayments"));    
    verifyAllocatedRefOneAndRefTwoField(msgprop.getProperty("referenceone"),msgprop.getProperty("referencetwo"));
    setAllocatedTransCode(testdataprop.getProperty("paymenttranscode"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load")); 
    verifyAllocatedUpdatedRefOneAndRefTwoField(msgprop.getProperty("updatedreferenceone"),msgprop.getProperty("updatedreferencetwo"));
    setAllocatedDebtorNo(uniqueMaintenanceNumber);
    setAllocatedAmount(testdataprop.getProperty("allocatedamount"));
    currentDate = GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle=driver.getWindowHandle();
    verifyAllocatedDate();
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    verifyAllocatedGLDate();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    setAllocatedPaymentMethods(testdataprop.getProperty("cashpaymentmethod"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    newAllocation();
    //callEvent(orprop.getProperty("button"),testdataprop.getProperty("newallocation")); 
    DebtorsCreditNotesWorkflow.findAndClickCheckbox();
    clickAddToAllocation();
    //callEvent(orprop.getProperty("button"),testdataprop.getProperty("addtoallocation"));
    searchTableColumn(orprop.getProperty("existingallocationstable"),oldReferenceNo);
    searchTableColumn(orprop.getProperty("existingallocationstable"),referenceNo);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete")); 
    clickHrefLink(testdataprop.getProperty("home"));
    
    //signOut
    clickSignOut();   
  }
}