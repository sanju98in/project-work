package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.FinancialWebHomepageWorkflow;
import financialWeb.workflow.GLMaintenanceWorkflow;
import util.GenUtil;

public class GLMaintenance65141 extends GLMaintenanceWorkflow{
  
  @Test(groups = {"smoke"})
  public void  createNewDetailCodeByCopyingExistingDetailCode() throws InterruptedException, ParseException, IOException, URISyntaxException {
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    verifyAndcreateDetailCodeDimension(testdataprop.getProperty("detailcodedimensions"),testdataprop.getProperty("detailcodedimensionsdesc"),testdataprop.getProperty("detailcodedimensionvalue"),testdataprop.getProperty("detailCodeDesc"),orprop.getProperty("detailcodetable"));
    analysisCode = createAnalysisCode(testdataprop.getProperty("detailcodeanalysis"),testdataprop.getProperty("detailcodedimensionsdesc"),testdataprop.getProperty("detailcodeanalysisdesc"));
    createNewDetailCode();
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
    clickHrefLink(testdataprop.getProperty("home"));
    //signOut
    clickSignOut();   
  }
}