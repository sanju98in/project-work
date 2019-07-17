package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.FinancialWebHomepageWorkflow;
import financialWeb.workflow.GLMaintenanceWorkflow;

public class GLMaintenance65142 extends GLMaintenanceWorkflow{
  
  @Test(groups = {"smoke"})
  public void  clearDetailCode() throws InterruptedException, ParseException, IOException, URISyntaxException {
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    verifyAndcreateDetailCodeDimension(testdataprop.getProperty("detailcodedimensions"),testdataprop.getProperty("detailcodedimensionsdesc"),testdataprop.getProperty("detailcodedimensionvalue"),testdataprop.getProperty("detailCodeDesc"),orprop.getProperty("detailcodetable"));
    analysisCode = createAnalysisCode(testdataprop.getProperty("detailcodeanalysis"),testdataprop.getProperty("detailcodedimensionsdesc"),testdataprop.getProperty("detailcodeanalysisdesc"));
    createNewDetailCode();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("clear"));
     clickHrefLink(testdataprop.getProperty("home"));
    //signOut
    clickSignOut();   
  }
}