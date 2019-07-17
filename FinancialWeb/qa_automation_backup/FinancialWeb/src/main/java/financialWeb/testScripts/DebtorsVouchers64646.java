package financialWeb.testScripts;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorAdjustmentsWorkflow;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorsCreditNotesWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;

public class DebtorsVouchers64646 extends DebtorsVouchersWorkflow {
 

  @Test(groups = {"smoke"})
  public void findDBCreditNoteUsingSearchFunctionality() throws InterruptedException, ParseException, IOException, URISyntaxException {
  
    // Create Debtor
    uniqueDebtorNumber = DebtorMaintenanceWorkflow.createDebtor();

   //Create DB CreditNote
   DebtorsCreditNotesWorkflow.createDBCreditNote();
   
   searchText(testdataprop.getProperty("searchdbvouchers"));
   searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
       testdataprop.getProperty("searchdbvouchers"));
   clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchcdbcreditnote"));
  
   findReference();
   setRandomWebElementValue(msgprop.getProperty("lbldebtornumber"),uniqueDebtorNumber);
   setRandomWebElementValue(msgprop.getProperty("referenceone"),referenceNo);
   DebtorAdjustmentsWorkflow.selectTransDate(orprop.getProperty("dbfindcrnotetransdate"));
   callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
   searchTableColumn(orprop.getProperty("tbldbfindcrnotegrid"), uniqueDebtorNumber);
   searchTableColumn(orprop.getProperty("tbldbfindcrnotegrid"), referenceNo);
   callEvent(orprop.getProperty("button"),testdataprop.getProperty("clear"));
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }
}
