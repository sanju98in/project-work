package financialWeb.testScripts;

import java.io.FileNotFoundException;
import org.testng.annotations.Test;
import financialWeb.workflow.DBReportsWorkflow;
import financialWeb.workflow.FinancialWebHomepageWorkflow;
import financialWeb.workflow.GLMaintenanceWorkflow;
import financialWeb.workflow.GLReportsWorkflow;

public class GLReports76691 extends DBReportsWorkflow {

  @Test(groups = {"smoke"})
  public void runGLReport() throws FileNotFoundException, InterruptedException {

    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();

    // GL- Verify and Create Detail Code dimension
    GLMaintenanceWorkflow.verifyAndcreateDetailCodeDimension(
        testdataprop.getProperty("detailcodedimensions"),
        testdataprop.getProperty("detailcodedimensionsdesc"),
        testdataprop.getProperty("detailcodedimensionvalue"),
        testdataprop.getProperty("detailCodeDesc"), orprop.getProperty("detailcodetable"));
    // GL - Create Analysis Code
    analysisCode =
        GLMaintenanceWorkflow.createAnalysisCode(testdataprop.getProperty("detailcodeanalysis"),
            testdataprop.getProperty("detailcodedimensionsdesc"),
            testdataprop.getProperty("detailcodeanalysisdesc"));
    // GL - Create Detail Code
    detailCode = GLMaintenanceWorkflow.createNewDetailCode();
    // Create GL Report Style
    reportStyleName = GLReportsWorkflow.createNewGLReprtStyle();
    // Create the GL Job Number
    dbJobNumber= GLReportsWorkflow.createGLJobNumber(reportStyleName, analysisCode);
    // Verify the GL Job Number
    GLReportsWorkflow.verifyJobNumber(dbJobNumber, analysisCode);
    // Click on Home link
    clickHrefLink(testdataprop.getProperty("home"));
    // signOut
    clickSignOut();
  }
}
