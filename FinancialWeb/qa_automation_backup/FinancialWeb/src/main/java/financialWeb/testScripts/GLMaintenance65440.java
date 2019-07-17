package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.GLMaintenanceWorkflow;
import util.GenUtil;

public class GLMaintenance65440 extends GLMaintenanceWorkflow{
  
  @Test(groups = {"smoke"})
  public void  creatingNewClassificationCodeByCopyingExistingClassificationCode() throws InterruptedException, ParseException, IOException, URISyntaxException {
       
    classificationCode = createClassificationMaintenanceCode();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("copy"));
    randomValue = GenUtil.getRandomAlphaNumericValue(testdataprop.getProperty("classificationcodelimit"));
    setNewCode(randomValue);
    randomComment = getRandomComment();
    String newDescription = randomComment;
    setNewClassificationCodeMaintenanceDescription(newDescription);
    randomComment = getRandomComment();
    setNewClassificationCodeMaintenanceComment(randomComment);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    validateInsertionMessage(msgprop.getProperty("classificationcodeinsertionmsg"));
    validateNewClassificationCodeMaintenanceDescription(newDescription);
    validateNewClassificationCodeMaintenanceComment(randomComment);
    String newCode = storeNewCode();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("close"));
    validateUpdatedClassificationCode(newCode);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    //signOut
    clickSignOut();   
  }
}