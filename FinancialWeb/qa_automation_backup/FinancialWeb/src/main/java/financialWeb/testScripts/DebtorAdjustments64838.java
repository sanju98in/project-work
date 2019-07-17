package financialWeb.testScripts;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorAdjustmentsWorkflow;
import financialWeb.workflow.DebtorMaintenanceWorkflow;

public class DebtorAdjustments64838 extends DebtorAdjustmentsWorkflow {

@Test(groups = {"smoke"})
  public void createReversePaymentwithAuthorisationbySupervisor()
      throws InterruptedException, ParseException, IOException, URISyntaxException {


    uniqueDebtorNumber = DebtorMaintenanceWorkflow.createDebtor();

    //adjustmentNumber = getAdjustmentNumber(uniqueDebtorNumber);
    
    searchText(testdataprop.getProperty("searchdbadjustments"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbadjustments"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchdbDBpaymentreversals"));
    verifyLabelName(msgprop.getProperty("lblreference1"), msgprop.getProperty("lblReference2"));
    selectRandomWebElementDrpDwn(msgprop.getProperty("lbltransactioncode"),
        testdataprop.getProperty("reversalpaymentwithauthtrancode"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    setRandomWebElementValue(msgprop.getProperty("lbldebtornumber"), uniqueDebtorNumber);
    verifyLabelName(msgprop.getProperty("lbladjustmentnumber"),
        msgprop.getProperty("lblpaymentnumber"));
    setAmount(testdataprop.getProperty("amount"));
    setGLDate();
    selectRandomWebElementDrpDwn(msgprop.getProperty("lblpaymentmethod"),
        testdataprop.getProperty("cashpaymentmethod"));
    selectRandomWebElementDrpDwn(msgprop.getProperty("lblreasoncode"),
        testdataprop.getProperty("refundreason"));
    setRandomWebElementValue(msgprop.getProperty("lblcomments"),
        testdataprop.getProperty("dbstylemaintenancecomments"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("save"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("complete"));
    String adjustmentNumber = getRandomWebElementValue(msgprop.getProperty("lbladjustmentnumber"));

    authoriseAdjustmentNo(uniqueDebtorNumber, adjustmentNumber);
    verifyAdjustmentNumber(uniqueDebtorNumber, adjustmentNumber);

    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }
}
