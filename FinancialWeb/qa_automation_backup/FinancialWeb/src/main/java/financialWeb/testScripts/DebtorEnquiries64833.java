package financialWeb.testScripts;

import org.testng.annotations.Test;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorsCreditNotesWorkflow;
import financialWeb.workflow.DebtorsEnquiriesWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;
import util.GenUtil;

public class DebtorEnquiries64833 extends DebtorsEnquiriesWorkflow {

  @Test(groups = {"smoke"})
   public void VerifyTheUnauthorisedTransactionsDBDetailsEnquiryPage() throws Exception {

    uniqueDebtorNumber = DebtorMaintenanceWorkflow.createDebtor();
    DebtorsVouchersWorkflow.createUnauthorisedDBInvoiceForDebtorEnquiries();
    searchText(testdataprop.getProperty("searchdbvouchers"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbvouchers"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchcdbcreditnote"));
    DebtorsCreditNotesWorkflow
        .setCreditLineTransCode(testdataprop.getProperty("crnotetransactioncode"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    DebtorsCreditNotesWorkflow.setCreditLineDebtorNo(uniqueMaintenanceNumber);
    String currentDate =
        GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle = driver.getWindowHandle();
    DebtorsCreditNotesWorkflow.clickTaxPointDate();
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate, parentHandle,
        testdataprop.getProperty("todaydate"));
    DebtorsCreditNotesWorkflow.clickGLDate();
    DebtorsVouchersWorkflow.selectDate(currentDate, parentHandle,
        testdataprop.getProperty("todaydate"));
    DebtorsCreditNotesWorkflow.selectCreditReason(testdataprop.getProperty("reasonforcredit"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("addline"));
    DebtorsCreditNotesWorkflow.setDescription(testdataprop.getProperty("comment"));
    DebtorsCreditNotesWorkflow.setQty(testdataprop.getProperty("qty"));
    DebtorsCreditNotesWorkflow.setPrice(testdataprop.getProperty("rndtelephonelimit"));
    DebtorsCreditNotesWorkflow.setVatCodex(testdataprop.getProperty("vtcode"));
    DebtorsCreditNotesWorkflow.setGLCode(testdataprop.getProperty("glcode"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("insert"));
    waitforPanelLoad();
    createUnauthorisedUnallocatedManualPaymentForDebtorEnquiries(uniqueDebtorNumber,
        testdataprop.getProperty("paymenttranscode"), msgprop.getProperty("referenceone"),
        msgprop.getProperty("referencetwo"), msgprop.getProperty("updatedreferenceone"),
        msgprop.getProperty("updatedreferencetwo"), testdataprop.getProperty("amount"),
        testdataprop.getProperty("cashpaymentmethod"), testdataprop.getProperty("comment"),
        msgprop.getProperty("authorisedformatchingstatus"));
    searchText(testdataprop.getProperty("searchdbenquiry"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbenquiry"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchdbdetailsenquiries"));
    waitforPanelLoad();
    setDebtorEnquiriesDebtorNumber(uniqueDebtorNumber);
    submit();
    waitforPanelLoad();
    searchTableColumn(orprop.getProperty("dbinvoiceenquiry"), fullName);
    searchTableColumn(orprop.getProperty("dbinvoiceenquiry"), testdataprop.getProperty("location"));
    searchTableColumn(orprop.getProperty("dbinvoiceenquiry"), msgprop.getProperty("authorise"));
    verifyNotYetDueAmount(orprop.getProperty("outstandingtransactiontoolstable"),dbInvoiceAmount);
    verifyCreditNoteAndPaymentDetails(dbInvoiceAmount,
        DebtorsCreditNotesWorkflow.getDBCreditLineAmount(msgprop.getProperty("lblunauthorisedinvoices")));
    calculateOutStandingTransactionAmt(orprop.getProperty("outstandingtransactionsumtable"),
        Integer.parseInt(testdataprop.getProperty("startIndexlimit")),
        Integer.parseInt(testdataprop.getProperty("endindexlimit")),
        Integer.parseInt(testdataprop.getProperty("chargecode")));
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }

}
