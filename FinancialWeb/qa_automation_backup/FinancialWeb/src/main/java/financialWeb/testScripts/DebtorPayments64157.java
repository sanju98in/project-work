package financialWeb.testScripts;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.pages.DebtorPayments;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorPaymentsWorkflow;
import financialWeb.workflow.DebtorsCreditNotesWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;
import util.GenUtil;

public class DebtorPayments64157 extends DebtorPaymentsWorkflow {

  @Test(groups = {"smoke"})
  public void partlyAllocateManualPaymentToAnInvoice()
      throws InterruptedException, ParseException, IOException, URISyntaxException {

    uniqueMaintenanceNumber = DebtorMaintenanceWorkflow.createDebtor();
    referenceNo = DebtorsVouchersWorkflow.createDBInvoice();
    searchText(testdataprop.getProperty("searchdbpayments"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbpayments"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchdbmanualpayments"));
    verifyAllocatedRefOneAndRefTwoField(msgprop.getProperty("referenceone"),
        msgprop.getProperty("referencetwo"));
    setAllocatedTransCode(testdataprop.getProperty("paymenttranscode"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    verifyAllocatedUpdatedRefOneAndRefTwoField(msgprop.getProperty("updatedreferenceone"),
        msgprop.getProperty("updatedreferencetwo"));
    setAllocatedDebtorNo(uniqueMaintenanceNumber);
    setAllocatedAmount(testdataprop.getProperty("amount"));
    currentDate =
        GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle = driver.getWindowHandle();
    verifyAllocatedDate();
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate, parentHandle,
        testdataprop.getProperty("todaydate"));
    verifyAllocatedGLDate();
    DebtorsVouchersWorkflow.selectDate(currentDate, parentHandle,
        testdataprop.getProperty("todaydate"));
    setAllocatedPaymentMethods(testdataprop.getProperty("cashpaymentmethod"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("insert"));
    newAllocation();
    // callEvent(orprop.getProperty("button"),testdataprop.getProperty("newallocation"));
    searchTableColumn(orprop.getProperty("dbpaymentallocationtable"), referenceNo);
    DebtorsCreditNotesWorkflow.findAndClickCheckbox();
    clickAddToAllocation();
    // callEvent(orprop.getProperty("button"),testdataprop.getProperty("addtoallocation"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("save"));
    String amt = DebtorPayments.getTxtOutstanding();
    String allocated = DebtorPayments.getTxtAllocated();
    validateOutstandingAmount(amt, testdataprop.getProperty("amount"), allocated);
    searchTableColumn(orprop.getProperty("existingallocationstable"), DebtorPayments.getTxtDate());
    searchTableColumn(orprop.getProperty("existingallocationstable"), referenceNo);
    amt = "£" + amt;
    searchTableColumn(orprop.getProperty("existingallocationstable"), amt);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("complete"));
    clickHrefLink(testdataprop.getProperty("home"));

    // signOut
    clickSignOut();
  }
}
