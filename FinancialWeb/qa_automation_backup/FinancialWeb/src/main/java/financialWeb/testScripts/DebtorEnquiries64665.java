package financialWeb.testScripts;

import org.testng.annotations.Test;
import financialWeb.pages.DebtorVouchersSalesInvoices;
import financialWeb.workflow.CreditorMaintenanceWorkflow;
import financialWeb.workflow.CreditorPaymentsWorkflow;
import financialWeb.workflow.DebtorsEnquiriesWorkflow;
import financialWeb.workflow.DebtorsInvoiceWorkflow;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorVouchersSalesInvoicesWorkflow;
import financialWeb.workflow.DebtorsAuthoriseWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;


public class DebtorEnquiries64665 extends DebtorsEnquiriesWorkflow {

 @Test(groups = {"smoke"})
  public void viewTheDBPIMEnquiry() throws Exception {

    uniqueDebtorNumber = DebtorMaintenanceWorkflow.createDebtor();
    searchText(testdataprop.getProperty("searchdbvouchers"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbvouchers"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("dbperiodicinvoicemaster"));
    DebtorsVouchersWorkflow.setTransactionCode(testdataprop.getProperty("pimtransactioncode"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    CreditorPaymentsWorkflow.setUniqueNumber(uniqueMaintenanceNumber);
    DebtorVouchersSalesInvoicesWorkflow
        .setPIMFrequency(testdataprop.getProperty("updatedunitofcharge"));
    DebtorVouchersSalesInvoicesWorkflow
        .setPIMInvToGenerate(testdataprop.getProperty("updatedprice"));
    parentHandle = driver.getWindowHandle();
    DebtorVouchersSalesInvoices.setDtStartDBPimDate();
    getHandles();
    DebtorVouchersSalesInvoicesWorkflow.setNextDate();
    DebtorsInvoiceWorkflow.setDBInvoiceStatus(testdataprop.getProperty("comment"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("addline"));
    DebtorsVouchersWorkflow.setDescription(testdataprop.getProperty("commentforpim"));
    DebtorsVouchersWorkflow.setDBCreditLineQty(testdataprop.getProperty("qtyforpim"));
    DebtorsVouchersWorkflow.setDBCreditLinePrice(testdataprop.getProperty("priceforpim"));
    DebtorsVouchersWorkflow.setDBCreditLineVat(testdataprop.getProperty("vtcode"));
    DebtorVouchersSalesInvoices.setTxtPIMGlCode(testdataprop.getProperty("glcode"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("insert"));
   // DebtorVouchersSalesInvoices.setDtEndPimDate();
    selectRandomWebElementCalendarImage(msgprop.getProperty("lblenddate"));
    DebtorVouchersSalesInvoicesWorkflow.setEndDate();
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("save"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("complete"));
    String startDate = getStartDate();
    String nxtDate = getNextDate();
    String endDate = getEndDate();
    String referenceNo = DebtorsVouchersWorkflow.storeReferenceNo();
    log.info("ReferenceNo:"+referenceNo);
    searchText(testdataprop.getProperty("searchdbenquiry"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbenquiry"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchdbtransactionenquiry"));
    DebtorsAuthoriseWorkflow.setDBAuthTransactionDebtorNumber(uniqueDebtorNumber);
    setReferenceone(referenceNo);
    parentHandle = driver.getWindowHandle();
    setTransDateFrom();
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate, parentHandle,
        testdataprop.getProperty("todaydate"));
    setTransDateTo();
    DebtorsVouchersWorkflow.selectDate(currentDate, parentHandle,
        testdataprop.getProperty("todaydate"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submit"));
    CreditorMaintenanceWorkflow.searchAndClickLatestRecordInTable(orprop.getProperty("findinvoicetable"), referenceNo);
    String[] dataSet = {referenceNo, msgprop.getProperty("authorise"),
        testdataprop.getProperty("updatedunitofcharge"), testdataprop.getProperty("updatedprice"),
        startDate, nxtDate, endDate};
    DebtorMaintenanceWorkflow.reviewDetails(orprop.getProperty("dbinvoiceenquiry"), dataSet);
    searchTableColumn(orprop.getProperty("tblcrnoteenquirydebtordetails"), fullName);
    searchTableColumn(orprop.getProperty("tblcrnoteenquirydebtordetails"), uniqueDebtorNumber);
    searchTableColumn(orprop.getProperty("tbldbcrnotechargelineenquiry"),
        testdataprop.getProperty("commentforpim"));

    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }

}
