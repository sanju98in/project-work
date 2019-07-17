package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorMaintenanceWorkflow;
import financialWeb.workflow.CreditorVouchersWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;

public class CreditorVoucher64886 extends CreditorVouchersWorkflow{
  
  @Test(groups = {"smoke"})
  public void  creatingCreditNote() throws InterruptedException, ParseException, IOException, URISyntaxException {
            
    uniqueCreditorNumber= CreditorMaintenanceWorkflow.createCreditor();
    
    searchText(testdataprop.getProperty("searchcrcreditnote"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchcrcreditnote"));
    waitforPanelLoad();
    setCRPOInvoiceTransCode(testdataprop.getProperty("crcreditnotetranscode"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    DebtorsVouchersWorkflow.setDBInvoiceDebtorNumber(uniqueCreditorNumber);
    randomNumber = getRandomNumber(testdataprop.getProperty("lengthlimit"));
    setCRPOInvoiceNo(randomNumber);
    setCRPOInvoiceGrossAmount(testdataprop.getProperty("amount"));
    setCRPOInvoiceVatAmount(testdataprop.getProperty("vatamount"));
    parentHandle=driver.getWindowHandle();
    selectInvoiceDate();
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    selectGLDate();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addline"));
    setCrCreditNoteGlCode(testdataprop.getProperty("glcode"));
    setCrCreditNoteAnalysisCode(testdataprop.getProperty("comment"));
    setCRPOInvoiceGLCode(testdataprop.getProperty("amount"));
    setCrCreditNoteVatCode(testdataprop.getProperty("vatcodefordbchargecode"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    voucherNumber =storeVoucherNumber();
    validateCreditNoteStatus(msgprop.getProperty("poinvoiceentered"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    validateCreditNoteStatus(msgprop.getProperty("crcreditnotestatus"));
    
    clickHrefLink(testdataprop.getProperty("home"));
    
    //signOut
    clickSignOut();   
  }
}