package financialWeb.testScripts;

import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.pages.DebtorsVouchers;
import financialWeb.workflow.DebtorChargeCodeMaintenanceWorkflow;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorsCreditNotesWorkflow;
import financialWeb.workflow.DebtorsEnquiriesWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;
import util.GenUtil;

public class DebtorsVouchers64608 extends DebtorChargeCodeMaintenanceWorkflow {
 

 @Test(groups = {"smoke"})
  public void viewTheDBCreditNoteEnquiry() throws InterruptedException, ParseException, IOException {
  
    uniqueMaintenanceNumber = DebtorMaintenanceWorkflow.createDebtor();
    //steps to create db credit note
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
    DebtorsVouchersWorkflow.clickCompleteDBCreditNote();
    DebtorsCreditNotesWorkflow.validateCreditNoteStatus(testdataprop.getProperty("authorisedcreditorstatus"));
    referenceNo = DebtorsVouchersWorkflow.storeReferenceNo();
    dbCrNoteDpt = DebtorsCreditNotesWorkflow.storeDBCreditNoteDepartment();
    dbCrNoteSec = DebtorsCreditNotesWorkflow.storeDBCreditNoteSection();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("adjust"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("reverseoverpayment"));
    DebtorsCreditNotesWorkflow.setAdjustCrNoteTransactionCode(testdataprop.getProperty("dbadjustcrnotetrnscode"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    DebtorsCreditNotesWorkflow.validateDBAdjustCrNoteDates(currentDate);
    DebtorsCreditNotesWorkflow.validateDefaultSelectedBankAccount(msgprop.getProperty("bankaccount"));
    DebtorsCreditNotesWorkflow.selectReverseOverpaymentReason(testdataprop.getProperty("reverseoverpaymentreason"));
    DebtorsCreditNotesWorkflow.setReverseOverpaymentComment(testdataprop.getProperty("comment"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    String dbAdjustCrNoteReferenceOne = DebtorsCreditNotesWorkflow.storeDBAdjustCrNoteReferenceOneAndClose();
    DebtorsVouchersWorkflow.setDBAuthTransactionReferenceOne(referenceNo);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    DebtorsCreditNotesWorkflow.validateCreditNoteStatus(msgprop.getProperty("fullyacclocated"));
    searchTableColumn(orprop.getProperty("dbcrnoteexistingallocationstabledata"),dbAdjustCrNoteReferenceOne);
    clickHrefLink(testdataprop.getProperty("home"));
    
    // signOut
    clickSignOut();
  }
}
