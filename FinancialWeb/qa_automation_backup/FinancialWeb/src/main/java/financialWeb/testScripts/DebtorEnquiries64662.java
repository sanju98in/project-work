package financialWeb.testScripts;
import org.testng.annotations.Test;
import financialWeb.pages.DebtorsVouchers;
import financialWeb.workflow.CreditorMaintenanceWorkflow;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorsAuthoriseWorkflow;
import financialWeb.workflow.DebtorsEnquiriesWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;
import util.GenUtil;


public class DebtorEnquiries64662 extends DebtorsEnquiriesWorkflow{
  
 @Test(groups = {"smoke"})
  public void  viewTheDBChargeCodeEnquiryInvoice() throws Exception {
            
    uniqueDebtorNumber=DebtorMaintenanceWorkflow.createDebtor();     
    referenceNo=DebtorsVouchersWorkflow.createDBInvoice();
    searchText(testdataprop.getProperty("searchdbenquiry"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchdbenquiry"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchdbtransactionenquiry"));
    DebtorsAuthoriseWorkflow.setDBAuthTransactionDebtorNumber(uniqueDebtorNumber);
    setReferenceone(referenceNo);
    String currentDate = GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle=driver.getWindowHandle();
    setTransDateFrom();
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    setTransDateTo();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    CreditorMaintenanceWorkflow.searchAndClickLatestRecordInTable(orprop.getProperty("findinvoicetable"),referenceNo);
    searchTableColumn(orprop.getProperty("dbinvoiceenquiry"),referenceNo); 
    searchTableColumn(orprop.getProperty("dbinvoiceenquiry"),msgprop.getProperty("authorise")); 
    searchTableColumn(orprop.getProperty("dbinvoiceenquiry"),testdataprop.getProperty("departmentandsection")); 
    //String amount = DebtorsVouchersWorkflow.getDBInvoiceAmount();
    String amount = "£"+ dbInvoiceAmount;
    searchTableColumn(orprop.getProperty("dbinvoiceenquiry"),amount);    
    searchTableColumn(orprop.getProperty("tblcrnoteenquirydebtordetails"),uniqueDebtorNumber);
    searchTableColumn(orprop.getProperty("tblcrnoteenquirydebtordetails"),fullName);
    searchTableColumn(orprop.getProperty("tbldbcrnotechargelineenquiry"),testdataprop.getProperty("comment"));
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