package financialWeb.testScripts;

import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorChargeCodeMaintenanceWorkflow;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorVouchersSalesInvoicesWorkflow;
import financialWeb.workflow.DebtorsCreditNotesWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;
import util.GenUtil;

public class DebtorsVouchers64293 extends DebtorChargeCodeMaintenanceWorkflow {
 

  @Test(groups = {"smoke"})
  public void createDbInvoiceWithPredefinedChargeCode() throws InterruptedException, ParseException, IOException {
  
    uniqueMaintenanceNumber = DebtorMaintenanceWorkflow.createDebtor();
    searchText(testdataprop.getProperty("dbchargecodemaintenance"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("dbchargecodemaintenance"));
    setChargeCode();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    setShortDescription(testdataprop.getProperty("shortchargecodedesc"));
    setDescription(testdataprop.getProperty("chargecodedesc"));
    setPopUpText(testdataprop.getProperty("popuptextforchargecode"));
    setUnitOfCharge(testdataprop.getProperty("unitofcharge"));
    selectCheckboxPriceInclusiveOfVAT();
    setDefaultQuantity(testdataprop.getProperty("rndtelephonelimit"));
    setVatCode(testdataprop.getProperty("vatcodefordbchargecode"));
    selectCheckboxAllowOverrideDesc() ;
    selectCheckboxAllowOverridePrice();
    selectCheckboxAllowOverrideVatCode();
    selectCheckboxAllowOverrideLedgerCode();
    selectCheckboxAllowOverrideUnitOfCharge();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addpriceline"));
    setStartDate();
    setPrice(testdataprop.getProperty("rndtelephonelimit"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addsplitline"));
    setGLCode(testdataprop.getProperty("glcode"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("departmentalsecurity"));
    clickArchitecturalService();
    clickHousing();
    clickChiefexecutive();
    updateAndcloseDBChargeCodeSecurityWindow();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    chargeCode=getChargeCode();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("clear"));  
    searchText(testdataprop.getProperty("searchdbvouchers"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchdbvouchers"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchcdbinvoice"));
    DebtorsCreditNotesWorkflow.setCreditLineTransCode(testdataprop.getProperty("inv001transactioncode"));   
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));    
    DebtorVouchersSalesInvoicesWorkflow.setDebtorNumberForChargeCode(uniqueMaintenanceNumber);
    String currentDate = GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle=driver.getWindowHandle();
    waitforPanelLoad();
    DebtorVouchersSalesInvoicesWorkflow.setTaxPointDate();
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    DebtorVouchersSalesInvoicesWorkflow.setGlDate();
    waitforPanelLoad();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addline"));
    DebtorVouchersSalesInvoicesWorkflow.setTxtAddLineChargeCode(chargeCode);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    validateChargeCodeTextPopup();
    //callEvent(orprop.getProperty("button"),testdataprop.getProperty("ok"));
    //switchandAcceptPopupMessageBox(driver);
    String amount = DebtorVouchersSalesInvoicesWorkflow.getAmount();
    DebtorVouchersSalesInvoicesWorkflow.validateDBInvoiceAmount(amount, testdataprop.getProperty("qty"),testdataprop.getProperty("rndtelephonelimit"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    DebtorVouchersSalesInvoicesWorkflow.validateInvoiceStatus(testdataprop.getProperty("authorisedcreditorstatus"));
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }
}
