package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorMaintenanceWorkflow;
import financialWeb.workflow.CreditorPaymentsWorkflow;
import financialWeb.workflow.CreditorVouchersWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;

public class CreditorVoucher64888 extends CreditorVouchersWorkflow{
  
  @Test(groups = {"smoke"})
  public void  creatingPOInvoice() throws InterruptedException, ParseException, IOException, URISyntaxException {
            
    uniqueCreditorNumber= CreditorMaintenanceWorkflow.createCreditor();
    waitForElementDisappear();
    searchText(testdataprop.getProperty("searchcrpoinvoice"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchcrpoinvoice"));
    //waitforPanelLoad();
    CreditorPaymentsWorkflow.setTransactionCodeForPOInvoice(testdataprop.getProperty("crpoinvoicetranscode"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    setPOInvoiceCreditorNumber(uniqueCreditorNumber);
    randomNumber = getRandomNumber(testdataprop.getProperty("lengthlimit"));
    setPOInvoiceInvoiceNo(randomNumber);
    setPOInvoiceGrossAmount(testdataprop.getProperty("amount"));
    setCRPOInvoiceVatAmount(testdataprop.getProperty("vatamount"));
    parentHandle=driver.getWindowHandle();
    selectPOInvoiceDate();
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    selectPOInvoiceGLDate();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addline"));
    setCRPOInvoiceGLCode(testdataprop.getProperty("glcode"));
    setCRPOInvoiceAnalysisCode(testdataprop.getProperty("comment"));
    setCRPOInvoiceGoodsAmount(testdataprop.getProperty("amount"));
    setCRPOInvoiceVatCode(testdataprop.getProperty("vatcodefordbchargecode"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    voucherNumber =storePOVoucherNumber();
    validateCRPOInvoiceStatus(msgprop.getProperty("poinvoiceentered"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    validateCRPOInvoiceStatus(msgprop.getProperty("poinvoicereadyforpayments"));

    clickHrefLink(testdataprop.getProperty("home"));
    
    //signOut
    clickSignOut();   
  }
}