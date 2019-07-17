package financialWeb.workflow;
import java.io.FileNotFoundException;
import financialWeb.pages.DebtorsNotes;

public class DebtorsNotesWorkflow extends CommonWorkflow{

  static DebtorsNotes objDebtorsNotes;
  
  public static void setTxtMsgField(String data) throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorsNotes = new  DebtorsNotes(driver);
    DebtorsNotes.setTxtMsg(data);
  }
  
  public static void setReminder() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorsNotes = new  DebtorsNotes(driver);
    DebtorsNotes.setSetReminderCheckBox();
  }
  
  public static void setSendToSelfChkBox() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorsNotes = new  DebtorsNotes(driver);
    DebtorsNotes.setSendToSelfCheckBox();
  }
  
  public static void clickDbNotesDebtorTab() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorsNotes = new  DebtorsNotes(driver);
    DebtorsNotes.setDbNotesDebtorTab();
  }
  
  public static void setUpdateMsg(String data) throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorsNotes = new  DebtorsNotes(driver);
    DebtorsNotes.setTxtUpdateMsg(data);
  }
  
  public static void getUpdateMsg() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorsNotes = new  DebtorsNotes(driver);
    DebtorsNotes.getTxtUpdateMsg();
  }
  
  public static void setUpdateReminderDate() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorsNotes = new  DebtorsNotes(driver);
    DebtorsNotes.setDtUpdateReminderDate();
  }
  
  public static void verifyGridDataOnHomePage() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objDebtorsNotes = new  DebtorsNotes(driver);
    String appendText = "DB: Debtor:"+" "+uniqueMaintenanceNumber+" "+"-"+" "+fullName+" "+"Debtor: "+ uniqueMaintenanceNumber+":"+" "+"Testing Notes for this invoice";
    log.info(appendText);
    searchTableColumn(orprop.getProperty("userMessagetable"),appendText);
  }
  //end of class
}