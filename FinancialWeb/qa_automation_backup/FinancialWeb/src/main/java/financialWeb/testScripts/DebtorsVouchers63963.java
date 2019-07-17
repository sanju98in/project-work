package financialWeb.testScripts;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorsCreditNotesWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;
import util.GenUtil;

public class DebtorsVouchers63963 extends DebtorsVouchersWorkflow {


  @Test(groups = {"smoke"})
    public void matchDBCreditNoteToAnInvoiceFully() throws InterruptedException, ParseException, IOException {
  
    DebtorMaintenanceWorkflow.createDebtor();
    createDBInvoice();
    searchText(testdataprop.getProperty("searchdbvouchers"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbvouchers"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),testdataprop.getProperty("searchcdbcreditnote"));
    DebtorsCreditNotesWorkflow.setCreditLineTransCode(testdataprop.getProperty("crnotetransactioncode"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    DebtorsCreditNotesWorkflow.setDebtorNumber(uniqueMaintenanceNumber);
    DebtorsCreditNotesWorkflow.setReverseOverpaymentComment(referenceNo);
    String currentDate = GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle=driver.getWindowHandle();
    DebtorsCreditNotesWorkflow.clickGLDate();
    getHandles();
    selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    DebtorsCreditNotesWorkflow.setDtCrNoteGLDate();
    selectDate(currentDate,parentHandle,testdataprop.getProperty("todaydate"));
    DebtorsCreditNotesWorkflow.selectReasonForCredit(testdataprop.getProperty("reasonforcredit"));
    DebtorsCreditNotesWorkflow.selectTakeDetailsFromInvoice();
    DebtorsCreditNotesWorkflow.AllocateCreditToInvoice();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    Thread.sleep(5000);
    existingAllocation(msgprop.getProperty("existingallocations"));
    //searchTableColumn(orprop.getProperty("tabtable"),msgprop.getProperty("existingallocations"));
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    String strDate= formatter.format(date);
    searchTableColumn(orprop.getProperty("existingallocationtabledata"),strDate);
    searchTableColumn(orprop.getProperty("existingallocationtabledata"),referenceNo);
    searchTableColumn(orprop.getProperty("existingallocationtabledata"),msgprop.getProperty("outstandingamount"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }

  
    
}
