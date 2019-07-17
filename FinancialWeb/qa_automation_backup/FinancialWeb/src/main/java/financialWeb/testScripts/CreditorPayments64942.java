package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorPaymentsWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;
import financialWeb.workflow.FinancialWebHomepageWorkflow;
import util.GenUtil;

public class CreditorPayments64942 extends CreditorPaymentsWorkflow{
  
  @Test(groups = {"smoke"})
  public void  CreatingNewTemplateForCreditor() throws InterruptedException, ParseException, IOException, URISyntaxException {
        
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    clickHrefLink(testdataprop.getProperty("home"));
    waitforPanelLoad();
    searchText(testdataprop.getProperty("searchcrnewpaymentrun"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchcrnewpaymentrun"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load")); 
    setTemplatename();
    currentDate = GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle=driver.getWindowHandle();
    setDueDate();
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    setPaymentDate();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    setGlPostingDate();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    setBankAccount(testdataprop.getProperty("bankaccount"));
    setNoOfInvoicesPerRemittance(testdataprop.getProperty("noofinvoicesperremittance"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    clickHrefLink(testdataprop.getProperty("home"));
    //signOut
    clickSignOut();   
  }
}