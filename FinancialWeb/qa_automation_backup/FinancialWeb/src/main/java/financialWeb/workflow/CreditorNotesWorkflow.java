package financialWeb.workflow;
import java.io.FileNotFoundException;
import financialWeb.pages.CreditorNotes;

public class CreditorNotesWorkflow extends CommonWorkflow{

  static CreditorNotes objCreditorNotes;
   
  public static void setMsgForCreditor(String data) throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objCreditorNotes = new  CreditorNotes(driver);
    CreditorNotes.setTxtMsg(data);
  }
  
  public static void setUpdatedMsg(String data) throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objCreditorNotes = new  CreditorNotes(driver);
    waitforPanelElement(CreditorNotes.txtUpdatedMsg);
    CreditorNotes.setTxtUpdatedMsg(data);
  }
  //end of class
}