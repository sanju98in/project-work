package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.FinancialWebHomepageWorkflow;
import financialWeb.workflow.GLEnquiriesWorkflow;
import financialWeb.workflow.GLMaintenanceWorkflow;

public class GLEnquiries65543 extends GLEnquiriesWorkflow{
  
  @Test(groups = {"smoke"})
  public void  findCostCenterOnGLCodeLevelEnquiryPage() throws InterruptedException, ParseException, IOException, URISyntaxException {
    
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    
    GLMaintenanceWorkflow.verifyAndcreateControlData(testdataprop.getProperty("controldataset"),
        testdataprop.getProperty("detailcodedimensionvalue"),
        testdataprop.getProperty("searchorcreatecontroldata"),
        orprop.getProperty("tablecontroldatamaintenance"));
    
    GLMaintenanceWorkflow.verifyAndCreateCostCenterDimensions(testdataprop.getProperty("searchorcreatecontroldata"),
        testdataprop.getProperty("detailcodedimensionvalue"),
        testdataprop.getProperty("costcentredimensiondesc"));
    
    analysisCode=GLMaintenanceWorkflow.createCostCentreAnalysis(testdataprop.getProperty("costcentreanalysissetcode"),
      testdataprop.getProperty("testcostcentredimensiondesc"),
      testdataprop.getProperty("costcentreanalysisdesc"));

    costCentreCode =GLMaintenanceWorkflow.createGLCostCenter();
    
    searchText(testdataprop.getProperty("searchglcodelevelenquiry"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("glcodelevel"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    findCostCenter(costCentreCode);
    
    //signOut
    clickSignOut();
      
  }
}