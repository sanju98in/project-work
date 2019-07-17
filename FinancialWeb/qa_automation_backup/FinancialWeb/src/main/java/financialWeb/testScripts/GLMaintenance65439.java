package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.GLMaintenanceWorkflow;

public class GLMaintenance65439 extends GLMaintenanceWorkflow{
  
  @Test(groups = {"smoke"})
  public void  deleteClassificationCode() throws InterruptedException, ParseException, IOException, URISyntaxException {
       
    classificationCode = createClassificationMaintenanceCode();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("delete"));
    validateDeleteMessage(msgprop.getProperty("classificationcodedeletemsg"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("delete"));
    clickFindClassificationCode();
    findClassificationMaintenanceCode(classificationCode);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    validateErrorMessage(msgprop.getProperty("findclassificationcodeerrormsg"));
    closeFindClassificationCodesPopuUp();
    //signOut
    clickSignOut();   
  }
}