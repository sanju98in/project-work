package financialWeb.testScripts;

import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;
import util.GenUtil;

public class DebtorsVouchers64637 extends DebtorsVouchersWorkflow {
 
  @Test(groups = {"smoke"})
  public void amendTheRecoveryDetailsOfaDBRecoveryGroup() throws InterruptedException, ParseException, IOException {
  
    uniqueMaintenanceNumber = DebtorMaintenanceWorkflow.createDebtor();
    String oldReferenceNo = createDBInvoice();
    referenceNo = createDBInvoice();
    createDBRecoveryGroup(oldReferenceNo);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("recoverydetails"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("change"));
    DebtorsVouchersWorkflow.selectChangeRecoveryRoute();
    DebtorsVouchersWorkflow.selectRoute(testdataprop.getProperty("route"));
    DebtorsVouchersWorkflow.selectStage(testdataprop.getProperty("stage"));
    String currentDate = GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle=driver.getWindowHandle();
    DebtorsVouchersWorkflow.selectDateStage();
    getHandles();
    selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("ok"));
    DebtorsVouchersWorkflow.validateProvRoute(msgprop.getProperty("provroute"));
    DebtorsVouchersWorkflow.validateProvStage(msgprop.getProperty("provstage"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("ok"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }
}
