package financialWeb.testScripts;

import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorsCreditNotesWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;
import util.GenUtil;

public class DebtorsVouchers63965 extends DebtorsVouchersWorkflow {


  @Test(groups = {"smoke"})
    public void matchDBCreditNoteToMultipleInvoices()
      throws InterruptedException, ParseException, IOException {

    DebtorMaintenanceWorkflow.createDebtor();

    // create multiple invoices
    createDBInvoice();
    createDBInvoice();

    searchText(testdataprop.getProperty("searchdbvouchers"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchdbvouchers"));
    clickSearchResultsLinkText(orprop.getProperty("menusearchresults"),
        testdataprop.getProperty("searchcdbcreditnote"));
    DebtorsCreditNotesWorkflow
        .setCreditLineTransCode(testdataprop.getProperty("crnotetransactioncode"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    DebtorsCreditNotesWorkflow.setCreditLineDebtorNo(uniqueMaintenanceNumber);
    String currentDate =
        GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    parentHandle = driver.getWindowHandle();
    DebtorsCreditNotesWorkflow.clickTaxPointDate();
    getHandles();
    selectDate(currentDate, parentHandle, testdataprop.getProperty("todaydate"));
    DebtorsCreditNotesWorkflow.clickGLDate();
    selectDate(currentDate, parentHandle, testdataprop.getProperty("todaydate"));
    DebtorsCreditNotesWorkflow.selectCreditReason(testdataprop.getProperty("reasonforcredit"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("addline"));
    DebtorsCreditNotesWorkflow.setDescription(testdataprop.getProperty("dbcreditlinedesc"));
    DebtorsCreditNotesWorkflow.setQty(testdataprop.getProperty("qty"));
    DebtorsCreditNotesWorkflow.setPrice(testdataprop.getProperty("crnoteprice"));
    DebtorsCreditNotesWorkflow.setVatCodex(testdataprop.getProperty("vtcode"));
    DebtorsCreditNotesWorkflow.setGLCode(testdataprop.getProperty("glcode"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("insert"));
    crNoteReference = DebtorsCreditNotesWorkflow.getRefernece();
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("allocate"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submit"));
    DebtorsCreditNotesWorkflow.findAndClickCheckbox();
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("addtoallocation"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("save"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("complete"));
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }



}
