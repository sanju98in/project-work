package financialWeb.testScripts;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorEnquiriesWorkflow;
import financialWeb.workflow.DebtorChargeCodeMaintenanceWorkflow;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorPaymentsWorkflow;
import financialWeb.workflow.DebtorVouchersSalesInvoicesWorkflow;
import financialWeb.workflow.DebtorsAuthoriseWorkflow;
import financialWeb.workflow.DebtorsCreditNotesWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;
import util.GenUtil;


public class DebtorEnquiries64661 extends DebtorChargeCodeMaintenanceWorkflow{
  
  @Test(groups = {"smoke"})
  public void  viewTheDBChargeCodeEnquiry() throws Exception {
            
    uniqueDebtorNumber=DebtorMaintenanceWorkflow.createDebtor();     
    searchText(testdataprop.getProperty("dbchargecodemaintenance"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("dbchargecodemaintenance"));
    DebtorChargeCodeMaintenanceWorkflow.setChargeCode();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    setShortDescription(testdataprop.getProperty("shortchargecodedesc"));
    setDescription(testdataprop.getProperty("chargecodedesc"));
    setPopUpText(testdataprop.getProperty("popuptextforchargecode"));
    setUnitOfCharge(testdataprop.getProperty("unitofcharge"));
    setDefaultQuantity(testdataprop.getProperty("rndtelephonelimit"));
    setVatCode(testdataprop.getProperty("vatcodefordbchargecode"));
    checkAllEmailOrFaxOptionsCheckbox();
    uncheckSuspendCharge();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addpriceline"));
    setStartDate();
    String getStartDate= getStartDate();
    setPrice(testdataprop.getProperty("rndtelephonelimit"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addsplitline"));
    setGLCode(testdataprop.getProperty("glcode"));
    clickAnalysisCode();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("departmentalsecurity"));
    clickArchitecturalService();
    clickHousing();
    clickChiefexecutive();
    updateAndcloseDBChargeCodeSecurityWindow();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    chargeCode=DebtorChargeCodeMaintenanceWorkflow.getChargeCode();
    searchText(testdataprop.getProperty("searchdbvouchers"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchdbvouchers"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchcdbinvoice"));
    DebtorsCreditNotesWorkflow.setCreditLineTransCode(testdataprop.getProperty("inv001transactioncode"));   
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));    
    DebtorPaymentsWorkflow.setAllocatedDebtorNo(uniqueDebtorNumber);   
    String currentDate = GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle=driver.getWindowHandle();
    DebtorVouchersSalesInvoicesWorkflow.setGlDate();
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));   
    DebtorVouchersSalesInvoicesWorkflow.setInvoiceGlDate();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addline"));
    DebtorVouchersSalesInvoicesWorkflow.setTxtAddLineChargeCode(chargeCode);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
   //callEvent(orprop.getProperty("button"),testdataprop.getProperty("ok"));
    validateChargeCodeTextPopup();
    String amount = CreditorEnquiriesWorkflow.getTxtAmount();
    DebtorVouchersSalesInvoicesWorkflow.validateDBInvoiceAmount(amount, testdataprop.getProperty("qty"),testdataprop.getProperty("rndtelephonelimit"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    referenceNo=DebtorsCreditNotesWorkflow.storeReference(); 
    searchText(testdataprop.getProperty("searchdbenquiry"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchdbenquiry"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchdbchargecodeenquiry"));
    DebtorsAuthoriseWorkflow.setDBAuthTransactionDebtorNumber(chargeCode);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    searchTableColumn(orprop.getProperty("findinvoicetable"),uniqueDebtorNumber);
    searchTableColumn(orprop.getProperty("findinvoicetable"),fullName);
    searchTableColumn(orprop.getProperty("findinvoicetable"),chargeCode);
    searchTableColumn(orprop.getProperty("findinvoicetable"),referenceNo);
    searchTableColumn(orprop.getProperty("findinvoicetable"),getStartDate);
    searchTableColumn(orprop.getProperty("findinvoicetable"),testdataprop.getProperty("qty"));
    amount = "£"+amount;
    searchTableColumn(orprop.getProperty("findinvoicetable"),amount);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("clear"));
    clickHrefLink(testdataprop.getProperty("home"));
    //signOut
    clickSignOut();   
  }

}