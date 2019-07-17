package financialWeb.testScripts;
import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorMaintenanceWorkflow;
import financialWeb.workflow.DebtorChargeCodeMaintenanceWorkflow;
import financialWeb.workflow.FinancialWebHomepageWorkflow;

public class DebtorChargeCodeMaintenance63970 extends DebtorChargeCodeMaintenanceWorkflow{

  @Test(groups = {"smoke"})
  public void maintainChargeCodeForDebtor() throws InterruptedException, ParseException, IOException {
        
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    searchText(testdataprop.getProperty("dbchargecodemaintenance"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("dbchargecodemaintenance"));
    //waitforPanelLoad();
    setChargeCode();
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
    setPrice(testdataprop.getProperty("rndtelephonelimit"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addsplitline"));
    setGLCode(testdataprop.getProperty("glcode"));
    clickAnalysisCode();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("departmentalsecurity"));
    clickArchitecturalService();
    clickHousing();
    clickChiefexecutive();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("update"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("close"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    btnClear();
    clickFindButton(orprop.getProperty("findchargecode"));
    //callEvent(orprop.getProperty("button"),testdataprop.getProperty("clickdbnumber"));
    setDBfindChargeCode(chargecode);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    CreditorMaintenanceWorkflow.searchAndClickLatestRecordInTable(orprop.getProperty("finddebtorstable"),chargecode);
    setUnitOfCharge(testdataprop.getProperty("updatedunitofcharge"));
    setVatCode(testdataprop.getProperty("updatedvatcode"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addpriceline"));
    setsecondStartDate();
    setSecondPrice(testdataprop.getProperty("updatedprice"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    clickHrefLink(testdataprop.getProperty("home"));
    //signOut
    clickSignOut();    
  }
}