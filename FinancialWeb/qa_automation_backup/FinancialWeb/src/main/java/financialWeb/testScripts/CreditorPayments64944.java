package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorEnquiriesWorkflow;
import financialWeb.workflow.CreditorMaintenanceWorkflow;
import financialWeb.workflow.CreditorPaymentsWorkflow;
import financialWeb.workflow.DebtorVouchersSalesInvoicesWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;
import util.GenUtil;

public class CreditorPayments64944 extends CreditorPaymentsWorkflow{
  
  @Test(groups = {"smoke"})
  public void  creditorManualPayment() throws InterruptedException, ParseException, IOException, URISyntaxException {
    
    
    uniqueCreditorNumber=CreditorMaintenanceWorkflow.createCreditor();    
    voucherNumber=createCRInvoice(testdataprop.getProperty("sundryinvoicetranscode"),
        uniqueCreditorNumber,
        testdataprop.getProperty("amount"),
        testdataprop.getProperty("vatamount"),
        testdataprop.getProperty("glcode"),
        testdataprop.getProperty("comment"),
        testdataprop.getProperty("amount"),
        testdataprop.getProperty("vtcode"));
    searchText(testdataprop.getProperty("searchcrmanualpayment"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchcrmanualpayment"));
    CreditorEnquiriesWorkflow.setTransactionCode(testdataprop.getProperty("crmanualpaymenttranscode"));
    DebtorVouchersSalesInvoicesWorkflow.setTransactionCodePayment(testdataprop.getProperty("crmanualpaymentbankaccount"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    DebtorVouchersSalesInvoicesWorkflow.setMsgField(uniqueCreditorNumber);
    currentDate = GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle=driver.getWindowHandle();
    CreditorEnquiriesWorkflow.setManualPaymentDate();
    getHandles();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    CreditorEnquiriesWorkflow.setManualPaymentGlDate();
    DebtorsVouchersWorkflow.selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    CreditorEnquiriesWorkflow.setExchangeRate(testdataprop.getProperty("vatamount"));
    CreditorEnquiriesWorkflow.setPaymentAmount(testdataprop.getProperty("amount"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("match"));
    setVoucherNo(voucherNumber);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submitnewquery"));
    setTransCodeCheckbox();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addtomatchedpayment"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    CreditorEnquiriesWorkflow.validateCrManualpaymentStatus(testdataprop.getProperty("defaultcreditorstatus"));
    crManualPaymentNo = CreditorEnquiriesWorkflow.getManualPaymentNo();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    CreditorEnquiriesWorkflow.validateCrManualpaymentStatus(msgprop.getProperty("allocated"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("clear"));
    clickHrefLink(testdataprop.getProperty("home"));
    //signOut
    clickSignOut();   
  }
}