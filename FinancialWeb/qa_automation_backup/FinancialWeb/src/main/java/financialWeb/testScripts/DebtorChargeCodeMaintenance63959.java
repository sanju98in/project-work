package financialWeb.testScripts;
import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorChargeCodeMaintenanceWorkflow;
import financialWeb.workflow.FinancialWebHomepageWorkflow;

public class DebtorChargeCodeMaintenance63959 extends DebtorChargeCodeMaintenanceWorkflow{

  @Test(groups = {"smoke"})
  public void createNewChargeCodeForDebtor() throws InterruptedException, ParseException, IOException {
        
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    searchText(testdataprop.getProperty("dbchargecodemaintenance"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("dbchargecodemaintenance"));
    waitforPanelLoad();
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
    waitForElementDisappear();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addpriceline"));
    waitForElementDisappear();
    setStartDate();
    setPrice(testdataprop.getProperty("rndtelephonelimit"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addsplitline"));
    setGLCode(testdataprop.getProperty("glcode"));
    clickAnalysisCode();
    waitForElementDisappear();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    Thread.sleep(2000);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("departmentalsecurity"));
    Thread.sleep(6000);
    waitforPanelLoad();
    clickArchitecturalService();
    clickHousing();
    clickChiefexecutive();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("update"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("close"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    clickHrefLink(testdataprop.getProperty("home"));
    //signOut
    clickSignOut();    
  }
 
}