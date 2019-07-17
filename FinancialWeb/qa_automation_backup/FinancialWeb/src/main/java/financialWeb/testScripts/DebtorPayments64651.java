package financialWeb.testScripts;

import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorMaintenanceWorkflow;
import financialWeb.workflow.DebtorPaymentsWorkflow;

public class DebtorPayments64651 extends DebtorPaymentsWorkflow {

 @Test(groups = {"smoke"})
  public void cancelManualPayment() throws InterruptedException, ParseException, IOException {
  
    uniqueCreditorNumber = CreditorMaintenanceWorkflow.createCreditor();
    uniqueDebtorNumber = updateDebtor(
        testdataprop.getProperty("title"),
        testdataprop.getProperty("firstname"),
        testdataprop.getProperty("lastname"),
        testdataprop.getProperty("location"),
        testdataprop.getProperty("typeofdebtor"),
        testdataprop.getProperty("accesslevel3")
        );
    
    setDebtorNumber(uniqueDebtorNumber);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    searchAndClickTab(orprop.getProperty("tabs"),testdataprop.getProperty("dbdebtordetailheadertab"));
    setCreditorAccountCode(uniqueCreditorNumber);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    searchAndClickTab(orprop.getProperty("tabs"),testdataprop.getProperty("mainheadertab"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("authorise"));
    createUnallocatedManualPayment(
        uniqueDebtorNumber,
        testdataprop.getProperty("paymenttranscode"),
        msgprop.getProperty("referenceone"),
        msgprop.getProperty("referencetwo"),
        msgprop.getProperty("updatedreferenceone"),
        msgprop.getProperty("updatedreferencetwo"),
        testdataprop.getProperty("amount"),
        testdataprop.getProperty("cashpaymentmethod"),
        testdataprop.getProperty("comment"),
        msgprop.getProperty("authorisedformatchingstatus")
        );
    
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("adjust"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("refundoverpayment"));
    selectRefundTransactionCode(testdataprop.getProperty("refundtranscode"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    setRefundComment(testdataprop.getProperty("refundcomment"));
    setRefundReason(testdataprop.getProperty("reasonforcredit"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    closeRefundOverpayment();
    validateStatus(msgprop.getProperty("selectedformatching"));
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }
  
}
