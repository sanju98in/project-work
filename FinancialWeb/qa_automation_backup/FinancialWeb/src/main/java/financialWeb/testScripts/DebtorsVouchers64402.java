package financialWeb.testScripts;

import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorChargeCodeMaintenanceWorkflow;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorsCreditNotesWorkflow;
import financialWeb.workflow.DebtorsEnquiriesWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;
import financialWeb.workflow.FinancialWebHomepageWorkflow;
import util.GenUtil;

public class DebtorsVouchers64402 extends DebtorChargeCodeMaintenanceWorkflow {


  @Test(groups = {"smoke"})
  public void createDBCreditNotewithapredefinedchargecode()
      throws InterruptedException, ParseException, IOException {

    uniqueMaintenanceNumber = DebtorMaintenanceWorkflow.createDebtor();
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    searchText(testdataprop.getProperty("dbchargecodemaintenance"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("dbchargecodemaintenance"));
    setChargeCode();
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    setShortDescription(testdataprop.getProperty("shortchargecodedesc"));
    setDescription(testdataprop.getProperty("chargecodedesc"));
    setPopUpText(testdataprop.getProperty("popuptextforchargecode"));
    setUnitOfCharge(testdataprop.getProperty("unitofcharge"));
    selectCheckboxPriceInclusiveOfVAT();
    setDefaultQuantity(testdataprop.getProperty("rndtelephonelimit"));
    setVatCode(testdataprop.getProperty("vatcodefordbchargecode"));
    selectCheckboxAllowOverrideDesc();
    selectCheckboxAllowOverridePrice();
    selectCheckboxAllowOverrideVatCode();
    selectCheckboxAllowOverrideLedgerCode();
    selectCheckboxAllowOverrideUnitOfCharge();
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("addpriceline"));
    setStartDate();
    setPrice(testdataprop.getProperty("rndtelephonelimit"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("addsplitline"));
    setGLCode(testdataprop.getProperty("glcode"));
    // clickAnalysisCode();
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("save"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("departmentalsecurity"));
    clickArchitecturalService();
    clickHousing();
    clickChiefexecutive();
    updateAndcloseDBChargeCodeSecurityWindow();
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("save"));
    chargeCode = getChargeCode();
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("clear"));

    // steps to create db credit note
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
    selectRandomWebElementCalendarImage(msgprop.getProperty("lbltaxpoint"));
    // DebtorsCreditNotesWorkflow.clickTaxPointDate();
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate, parentHandle,
        testdataprop.getProperty("todaydate"));
    parentHandle = driver.getWindowHandle();
    selectRandomWebElementCalendarImage(msgprop.getProperty("lblgldate"));
    // DebtorsCreditNotesWorkflow.clickGLDate();
    DebtorsVouchersWorkflow.selectDate(currentDate, parentHandle,
        testdataprop.getProperty("todaydate"));
    DebtorsCreditNotesWorkflow.selectCreditReason(testdataprop.getProperty("reasonforcredit"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("addline"));
    DebtorsCreditNotesWorkflow.setChargeCodeDBCreditLine(chargeCode);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("insert"));
    validateChargeCodeTextPopup();
    // callEvent(orprop.getProperty("button"),testdataprop.getProperty("ok"));
    // switchandAcceptPopupMessageBox(driver);
    String amount = DebtorsEnquiriesWorkflow.getAmount();
    validateAmount(amount, testdataprop.getProperty("qty"),
        testdataprop.getProperty("rndtelephonelimit"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("complete"));
    DebtorsCreditNotesWorkflow
        .validateDBCreditNoteStatus(testdataprop.getProperty("authorisedcreditorstatus"));
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }
}
