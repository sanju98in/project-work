package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorMaintenanceWorkflow;
import financialWeb.workflow.CreditorVouchersWorkflow;
import financialWeb.workflow.DebtorChargeCodeMaintenanceWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;

public class CreditorVoucher64887 extends CreditorVouchersWorkflow{
  
  @Test(groups = {"smoke"})
  public void  maintainingCreditNote() throws InterruptedException, ParseException, IOException, URISyntaxException {
            
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
    //workaround as the method is commonly used on different screen but has different id
    setCRPOInvoiceVatAmount(testdataprop.getProperty("vatamount"),"0");
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
    DebtorChargeCodeMaintenanceWorkflow.btnClear();
    setCRVoucherNumber(voucherNumber);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    setSUndryInvoiceComment(testdataprop.getProperty("comment"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    clickHrefLink(testdataprop.getProperty("home"));
    
    //signOut
    clickSignOut();   
  }
}