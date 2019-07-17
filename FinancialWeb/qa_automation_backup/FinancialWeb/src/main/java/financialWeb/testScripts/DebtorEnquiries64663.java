package financialWeb.testScripts;
import org.testng.annotations.Test;
import financialWeb.pages.DebtorsVouchers;
import financialWeb.workflow.CreditorMaintenanceWorkflow;
import financialWeb.workflow.DebtorsEnquiriesWorkflow;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorsAuthoriseWorkflow;
import financialWeb.workflow.DebtorsCreditNotesWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;
import util.GenUtil;


public class DebtorEnquiries64663 extends DebtorsEnquiriesWorkflow{
  
 @Test(groups = {"smoke"})
   public void  viewTheDBTransactionCodeEnquiryCreditNote() throws Exception {
            
    uniqueDebtorNumber=DebtorMaintenanceWorkflow.createDebtor();     
    searchText(testdataprop.getProperty("searchdbvouchers"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbvouchers"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchcdbcreditnote"));
    DebtorsCreditNotesWorkflow.setTransCode(testdataprop.getProperty("crnotetransactioncode"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    DebtorsVouchersWorkflow.setCreditNoteDebtorNumber(uniqueDebtorNumber);
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
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    referenceNo = DebtorsVouchersWorkflow.storeReferenceNo();
    searchText(testdataprop.getProperty("searchdbenquiry"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchdbenquiry"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchdbtransactionenquiry"));
    DebtorsAuthoriseWorkflow.setDBAuthTransactionDebtorNumber(uniqueDebtorNumber);
    setReferenceone(referenceNo);
    parentHandle=driver.getWindowHandle();
    setTransDateFrom();
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    setTransDateTo();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    CreditorMaintenanceWorkflow.searchAndClickLatestRecordInTable(orprop.getProperty("findinvoicetable"),referenceNo);
    searchTableColumn(orprop.getProperty("dbinvoiceenquiry"),referenceNo); 
    searchTableColumn(orprop.getProperty("dbinvoiceenquiry"),testdataprop.getProperty("departmentandsection"));
    searchTableColumn(orprop.getProperty("dbinvoiceenquiry"),msgprop.getProperty("authorise"));      
    amount = "£"+ amount;
    searchTableColumn(orprop.getProperty("dbinvoiceenquiry"),amount);    
    searchTableColumn(orprop.getProperty("tblcrnoteenquirydebtordetails"),uniqueDebtorNumber);
    searchTableColumn(orprop.getProperty("tblcrnoteenquirydebtordetails"),fullName);
    searchTableColumn(orprop.getProperty("tbldbcrnotechargelineenquiry"),testdataprop.getProperty("dbcreditlinedesc"));
    String qty = DebtorsVouchersWorkflow.getDBCreditLineQty();
    searchTableColumn(orprop.getProperty("tbldbcrnotechargelineenquiry"),qty);
    String unitPrice = DebtorsVouchers.getCreditLinePrice(); 
    unitPrice = "£"+ unitPrice;
    searchTableColumn(orprop.getProperty("tbldbcrnotechargelineenquiry"),unitPrice);
    searchTableColumn(orprop.getProperty("tbldbcrnotechargelineenquiry"),amount);
    clickHrefLink(testdataprop.getProperty("home"));
    //signOut
    clickSignOut();   
  }

}