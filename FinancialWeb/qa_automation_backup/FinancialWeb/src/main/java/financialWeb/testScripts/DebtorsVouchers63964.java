package financialWeb.testScripts;

import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorPaymentsWorkflow;
import financialWeb.workflow.DebtorsCreditNotesWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;
import util.GenUtil;

public class DebtorsVouchers63964 extends DebtorsVouchersWorkflow {
 

  @Test(groups = {"smoke"})
  public void createDBInvoice64110() throws InterruptedException, ParseException, IOException {
  
    uniqueDebtorNumber = DebtorMaintenanceWorkflow.createDebtor();
    createDBInvoice();
    searchText(testdataprop.getProperty("searchdbvouchers"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbvouchers"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchcdbcreditnote"));
    DebtorsCreditNotesWorkflow.setCreditLineTransCode(testdataprop.getProperty("crnotetransactioncode"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    DebtorsCreditNotesWorkflow.setCreditLineDebtorNo(uniqueDebtorNumber);
    String currentDate = GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle=driver.getWindowHandle();
    selectRandomWebElementCalendarImage(msgprop.getProperty("lbltaxpoint"));
    getHandles();
    selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    selectRandomWebElementCalendarImage(msgprop.getProperty("lblgldate"));
    selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    DebtorsCreditNotesWorkflow.selectCreditReason(testdataprop.getProperty("reasonforcredit"));
    setInvoice(referenceNo);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addline"));
    DebtorsCreditNotesWorkflow.setDescription(testdataprop.getProperty("dbcreditlinedesc"));
    DebtorsCreditNotesWorkflow.setQty(testdataprop.getProperty("qty"));
    DebtorsCreditNotesWorkflow.setPrice(testdataprop.getProperty("crnoteprice"));
    DebtorsCreditNotesWorkflow.setVatCodex(testdataprop.getProperty("vtcode"));
    DebtorsCreditNotesWorkflow.setGLCode(testdataprop.getProperty("glcode"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    crNoteReference = DebtorsCreditNotesWorkflow.getRefernece();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("allocate"));
    DebtorsCreditNotesWorkflow.setRefernceOne(referenceNo);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    DebtorsCreditNotesWorkflow.selectDBNewCrLineAllocationCheckbox();
    DebtorPaymentsWorkflow.clickAddToAllocation();
    //callEvent(orprop.getProperty("button"),testdataprop.getProperty("addtoallocation"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    DebtorsCreditNotesWorkflow.validatePartiallyAllocatedStatus(msgprop.getProperty("partlyallocated"));
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }

  
    
}
