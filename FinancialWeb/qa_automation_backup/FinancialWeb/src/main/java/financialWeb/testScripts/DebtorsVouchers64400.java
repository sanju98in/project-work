package financialWeb.testScripts;

import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.pages.DebtorsVouchers;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorsCreditNotesWorkflow;
import financialWeb.workflow.DebtorsEnquiriesWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;
import util.GenUtil;

public class DebtorsVouchers64400 extends DebtorsVouchersWorkflow {
 

  @Test(groups = {"smoke"})
  public void deleteDBCreditNote() throws InterruptedException, ParseException, IOException {
  
    DebtorMaintenanceWorkflow.createDebtor();
    searchText(testdataprop.getProperty("searchdbvouchers"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbvouchers"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchcdbcreditnote"));
    waitforPanelLoad();
    DebtorsCreditNotesWorkflow.setTransCode(testdataprop.getProperty("crnotetransactioncode"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    
    DebtorsVouchers.setDBCreditNoteDebtorNo(uniqueMaintenanceNumber);
    String currentDate = GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle=driver.getWindowHandle();
    DebtorsVouchersWorkflow.clickTaxPointDatepicker();
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    DebtorsVouchersWorkflow.clickGLDatepicker();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    DebtorsVouchersWorkflow.selectReasonForCredit(testdataprop.getProperty("reasonforcredit"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addline"));
    DebtorsVouchersWorkflow.setDescription(testdataprop.getProperty("dbcreditlinedesc"));
    DebtorsVouchersWorkflow.setDBCreditLineQty(testdataprop.getProperty("qty"));
    DebtorsVouchersWorkflow.setDBCreditLinePrice(testdataprop.getProperty("rndtelephonelimit"));
    DebtorsVouchersWorkflow.setDBCreditLineVat(testdataprop.getProperty("vtcode"));
    DebtorsVouchersWorkflow.setDBCreditLineGLCode(testdataprop.getProperty("glcode"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    String amount = DebtorsEnquiriesWorkflow.getAmount();
    DebtorsVouchersWorkflow.validateDBCreditNoteAmount(amount, testdataprop.getProperty("qty"),testdataprop.getProperty("rndtelephonelimit"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("delete"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("delete"));
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }

  
    
}
