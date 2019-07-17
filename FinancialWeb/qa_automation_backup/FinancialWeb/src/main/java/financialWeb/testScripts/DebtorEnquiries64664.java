package financialWeb.testScripts;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorMaintenanceWorkflow;
import financialWeb.workflow.DebtorsEnquiriesWorkflow;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorPaymentsWorkflow;
import financialWeb.workflow.DebtorsAuthoriseWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;


public class DebtorEnquiries64664 extends DebtorsEnquiriesWorkflow{
  
  @Test(groups = {"smoke"})
  public void  viewTheDBTransactionsEnquiryPayment() throws Exception {
            
    uniqueDebtorNumber=DebtorMaintenanceWorkflow.createDebtor();     
    DebtorPaymentsWorkflow.createUnallocatedManualPayment(
        uniqueDebtorNumber,
        testdataprop.getProperty("paymenttranscode"),
        msgprop.getProperty("referenceone"),
        msgprop.getProperty("referencetwo"),
        msgprop.getProperty("updatedreferenceone"),
        msgprop.getProperty("updatedreferencetwo"),
        testdataprop.getProperty("amount"),
        testdataprop.getProperty("cashpaymentmethod"),
        testdataprop.getProperty("comment"),
        msgprop.getProperty("authorisedformatchingstatus")
        );   
    searchText(testdataprop.getProperty("searchdbenquiry"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchdbenquiry"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchdbtransactionenquiry"));
    DebtorsAuthoriseWorkflow.setDBAuthTransactionDebtorNumber(uniqueDebtorNumber);
    setReferenceone(paymentNo);
    parentHandle=driver.getWindowHandle();
    setTransDateFrom();
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    setTransDateTo();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    CreditorMaintenanceWorkflow.searchAndClickLatestRecordInTable(orprop.getProperty("findinvoicetable"),paymentNo);
    searchTableColumn(orprop.getProperty("dbinvoiceenquiry"),paymentNo);
    searchTableColumn(orprop.getProperty("dbinvoiceenquiry"),alternatePaymentNo);
    searchTableColumn(orprop.getProperty("dbinvoiceenquiry"),msgprop.getProperty("authorisedformatchingstatus"));
    searchTableColumn(orprop.getProperty("dbinvoiceenquiry"),testdataprop.getProperty("departmentandsection"));
    searchTableColumn(orprop.getProperty("dbinvoiceenquiry"),testdataprop.getProperty("bankaccount"));
    String getDate = getDate();
    searchTableColumn(orprop.getProperty("dbinvoiceenquiry"),getDate);
    String getGLDate = getGLDate();
    searchTableColumn(orprop.getProperty("dbinvoiceenquiry"),getGLDate);
    String amount = DebtorPaymentsWorkflow.getDBAmount();
    amount = "£"+ amount;
    searchTableColumn(orprop.getProperty("dbinvoiceenquiry"),amount);
    searchTableColumn(orprop.getProperty("tblcrnoteenquirydebtordetails"),fullName);
    searchTableColumn(orprop.getProperty("tblcrnoteenquirydebtordetails"),uniqueDebtorNumber);
    clickHrefLink(testdataprop.getProperty("home"));
    //signOut
    clickSignOut();   
  }

}