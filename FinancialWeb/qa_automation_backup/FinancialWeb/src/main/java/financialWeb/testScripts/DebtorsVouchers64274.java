package financialWeb.testScripts;
import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorMaintenanceWorkflow;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorVouchersSalesInvoicesWorkflow;
import financialWeb.workflow.DebtorsAuthoriseWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;
import util.GenUtil;

public class DebtorsVouchers64274 extends DebtorVouchersSalesInvoicesWorkflow{

  @Test(groups = {"smoke"})
  public void findDbInvoiceUsingSearchFunctionality() throws InterruptedException, ParseException, IOException {
        
    DebtorMaintenanceWorkflow.createDebtor();
    DebtorsVouchersWorkflow.createDBInvoice();
    searchText(testdataprop.getProperty("searchdbvouchers"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchdbvouchers"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchcdbinvoice"));
   click(getRandomWebElement(msgprop.getProperty("lblinvoicenoreference"), orprop.getProperty("findbtn")));
   // clickFindButton(orprop.getProperty("finddebtorno"));
   // callEvent(orprop.getProperty("button"),testdataprop.getProperty("clickdbnumber"));
    DebtorsAuthoriseWorkflow.setDBAuthTransactionDebtorNumber(uniqueMaintenanceNumber);
    setInvoiceNumber(referenceNo);
    String currentDate = GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle=driver.getWindowHandle();
    setEntryDate();
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    CreditorMaintenanceWorkflow.validateTableData(orprop.getProperty("findinvoicetable"),uniqueMaintenanceNumber);
    CreditorMaintenanceWorkflow.validateTableData(orprop.getProperty("findinvoicetable"),referenceNo);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("clear"));
    clickHrefLink(testdataprop.getProperty("home"));
       
    //signOut
    clickSignOut();    
  }
}