package financialWeb.testScripts;

import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.DebtorMaintenanceWorkflow;
import financialWeb.workflow.DebtorsCreditNotesWorkflow;
import financialWeb.workflow.DebtorsVouchersWorkflow;
import util.GenUtil;

public class DebtorsVouchers64399 extends DebtorsVouchersWorkflow {


  @Test(groups = {"smoke"})
  public void cancelDBCreditNote() throws InterruptedException, ParseException, IOException {

    DebtorMaintenanceWorkflow.createDebtor();
    DebtorsCreditNotesWorkflow.createDBCreditNote();
    DebtorsCreditNotesWorkflow.clickAdjust();
    DebtorsCreditNotesWorkflow.clickCancelCreditNotes();
    DebtorsCreditNotesWorkflow.setCancelReason(testdataprop.getProperty("cancelreason"));
    String currentDate =
        GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("currentdate"));
    DebtorsCreditNotesWorkflow.clickCancellationDate();
    DebtorsCreditNotesWorkflow.selectCancellationDate(currentDate, parentHandle,
        testdataprop.getProperty("todaydate"));
    DebtorsCreditNotesWorkflow.clickCancellationGLDate();
    DebtorsCreditNotesWorkflow.selectCancellationGLDate(currentDate, parentHandle,
        testdataprop.getProperty("todaydate"));
    DebtorsCreditNotesWorkflow.selectCancellationComment(testdataprop.getProperty("comment"));
    DebtorsCreditNotesWorkflow.saveCancellation();
    DebtorsCreditNotesWorkflow
        .validateCancellationFieldsAreDisabled(msgprop.getProperty("disabled"));
    DebtorsCreditNotesWorkflow.validateCancelledCreditNoteStatus(msgprop.getProperty("cancelled"));
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }



}
