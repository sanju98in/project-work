package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.GLMaintenanceWorkflow;

public class GLMaintenance65249 extends GLMaintenanceWorkflow{
  
  @Test(groups = {"smoke"})
  public void  createGLCostCentreAnalysis() throws InterruptedException, ParseException, IOException, URISyntaxException {
    
    verifyAndcreateControlData(testdataprop.getProperty("controldataset"),
                              testdataprop.getProperty("detailcodedimensionvalue"),
                              testdataprop.getProperty("searchorcreatecontroldata"),
                              orprop.getProperty("tablecontroldatamaintenance"));
    verifyAndCreateCostCenterDimensions(testdataprop.getProperty("searchorcreatecontroldata"),
                                        testdataprop.getProperty("detailcodedimensionvalue"),
                                        testdataprop.getProperty("costcentredimensiondesc"));
    analysisCode=createCostCentreAnalysis(testdataprop.getProperty("costcentreanalysissetcode"),
                            testdataprop.getProperty("testcostcentredimensiondesc"),
                            testdataprop.getProperty("costcentreanalysisdesc"));
  
    //signOut
    clickSignOut();   
  }
}