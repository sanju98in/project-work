package financialWeb.testScripts;
import org.testng.annotations.Test;
import financialWeb.pages.CreditorPayments;
import financialWeb.pages.DebtorsInvoice;
import financialWeb.pages.DebtorsVouchers;
import financialWeb.workflow.CreditorMaintenanceWorkflow;
import financialWeb.workflow.CreditorPaymentsWorkflow;
import financialWeb.workflow.DebtorsEnquiriesWorkflow;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorsAuthoriseWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;
import util.GenUtil;


public class DebtorEnquiries64660 extends DebtorsEnquiriesWorkflow{
  
  @Test(groups = {"smoke"})
  public void  viewTheDBAgedDebtEnquiryDeptLevel() throws Exception {
            
    uniqueMaintenanceNumber=DebtorMaintenanceWorkflow.createDebtor();     
    DebtorsVouchersWorkflow.createDBInvoice();
    searchText(testdataprop.getProperty("searchdbvouchers"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchdbvouchers"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchcdbinvoice"));
    DebtorsVouchersWorkflow.setTransactionCode(testdataprop.getProperty("inv001transactioncode"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load")); 
    waitforPanelElement(CreditorPayments.txtCrNumber);
    CreditorPaymentsWorkflow.setUniqueNumber(uniqueDebtorNumber);
    setSection(testdataprop.getProperty("departmenteducation"));
    setDBInvoiceSection(testdataprop.getProperty("sectionaustinfarmprimaryschool"));   
    String currentDate = GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle=driver.getWindowHandle();
    DebtorsInvoice.setDBInvoiceGLDate();
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    DebtorsVouchers.setDtGlDate();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addline"));  
    DebtorsVouchersWorkflow.setDescription(testdataprop.getProperty("comment"));
    DebtorsVouchersWorkflow.setDBCreditLineQty(testdataprop.getProperty("qty"));
    DebtorsVouchersWorkflow.setDBCreditLinePrice(testdataprop.getProperty("rndtelephonelimit"));
    DebtorsVouchersWorkflow.setDBCreditLineVat(testdataprop.getProperty("vtcode"));
    DebtorsInvoice.setGLCode(testdataprop.getProperty("glcode"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));    
    String amount = DebtorsVouchersWorkflow.getDBInvoiceAmount();
    DebtorsVouchersWorkflow. validateDBVoucherAmount(amount, testdataprop.getProperty("qty"),testdataprop.getProperty("rndtelephonelimit"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    referenceNo = DebtorsVouchersWorkflow.storeReferenceNo();
    searchText(testdataprop.getProperty("searchdbenquiry"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchdbenquiry"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchdbageddebtenquiry"));   
    DebtorsAuthoriseWorkflow.setDBAuthTransactionDebtorNumber(uniqueMaintenanceNumber);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    searchTableColumn(orprop.getProperty("findinvoicetable"),uniqueMaintenanceNumber);
    searchTableColumn(orprop.getProperty("findinvoicetable"),fullName);
    CreditorMaintenanceWorkflow.searchAndClickLatestRecordInTable(orprop.getProperty("findinvoicetable"),uniqueMaintenanceNumber);
    searchTableColumn(orprop.getProperty("dbageddebtenquirydeptleveltable"),testdataprop.getProperty("departmenteducation"));
    searchTableColumn(orprop.getProperty("dbageddebtenquirydeptleveltable"),testdataprop.getProperty("departmentandsection"));
    verifyNotYetDueAmountForEducation(amount);   
    calculateTotalOutStandingAmt(orprop.getProperty("dbageddebtenquiryforchieftable"));
    
    clickHrefLink(testdataprop.getProperty("home"));
    //signOut
    clickSignOut();   
  }

}