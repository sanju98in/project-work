package financialWeb.testScripts;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorAdjustmentsWorkflow;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorsCreditNotesWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;
import financialWeb.workflow.FinancialWebHomepageWorkflow;

public class DebtorAdjustments65112 extends DebtorAdjustmentsWorkflow {

  @Test(groups = {"smoke"})
  
  public void setupTidyTransactionBTWNDebtorsPartiallyMatchTransaction()
      throws InterruptedException, ParseException, IOException, URISyntaxException {
    //create debtor
    uniqueMaintenanceNumber=DebtorMaintenanceWorkflow.createDebtor();
    String debtorOne = uniqueMaintenanceNumber;
    //create db invoice
    uniqueInvoiceNo = DebtorsVouchersWorkflow.createDBInvoice();        
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
    driver.close();
    
    selectBrowser(envprop.getProperty("browser"));
    navigateWithWindowsAuthentication(testdataprop.getProperty("purchasingbasicusername"),
        testdataprop.getProperty("financialwebpassword"), envprop.getProperty("url"));
    maximizeWindow();
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    
    //create debtor
    uniqueMaintenanceNumber=DebtorMaintenanceWorkflow.createDebtor();
    DebtorsCreditNotesWorkflow.createDBCreditNote();
    
    
    searchText(testdataprop.getProperty("dbadjustment"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("dbadjustment"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("dbtidubtwndebtors"));
    setRandomWebElementValue(msgprop.getProperty("lblfromdebtornumber"), debtorOne);
    setRandomWebElementValue(msgprop.getProperty("lbltodebtornumber"), uniqueMaintenanceNumber);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load")); 
    setFromDebtorShow(testdataprop.getProperty("fromdebtorshow"));
    setToDebtorShow(testdataprop.getProperty("todebtorshow"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("listtransactions")); 
    
    selectTidyFromDebtor();
    selectTidyToDebtor();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("setuptidy"));
    setCrNoteTidyAmt(testdataprop.getProperty("gldebit"));
    setInvoiceTidyAmt(testdataprop.getProperty("gldebit"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("dotidy"));
    waitforPanelLoad();
    getFromTidyReference();
    getToTidyReference();
    
    validateBalance(msgprop.getProperty("tidybalance"));
    searchTableColumn(orprop.getProperty("tidytransactions"), msgprop.getProperty("partlyallocated"));
    searchTableColumn(orprop.getProperty("tidytransactions"), msgprop.getProperty("fullypaid"));
    
    clickHrefLink(testdataprop.getProperty("home"));
    
    // signOut
    clickSignOut();
    
  }
}
