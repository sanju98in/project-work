package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.GLMaintenanceWorkflow;

public class GLMaintenance65254 extends GLMaintenanceWorkflow{
  
  @Test(groups = {"smoke"})
  public void  creatingNewCostCentreByCopyingExistingCostCentre() throws InterruptedException, ParseException, IOException, URISyntaxException {
    
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
    searchText(testdataprop.getProperty("searchglcostcentremaintenance"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchglcostcentremaintenance"));
    costCentreCode=createCostCentreCode();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    setClassificationCodeMaintenanceDescription(testdataprop.getProperty("comment"));
    setDimensionSet(testdataprop.getProperty("costcentreanalysissetcode"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addline"));
    clickBtnLevel();
    setGLDetailCodeMaintenanceAnalysisCode(testdataprop.getProperty("detailcodedimensionvalue"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    searchAndClickLatestRecordInTable(orprop.getProperty("finddebtorstablebody"),testdataprop.getProperty("detailcodedimensionvalue"));
    clickBtnAnalysisCode();
    setFindCostAnalysisCode(analysisCode);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    searchAndClickLatestRecordInTable(orprop.getProperty("finddebtorstablebody"),analysisCode);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("copy"));
    setNewGlCostCode();
    setNewClassificationCodeMaintenanceDescription(testdataprop.getProperty("comment"));
    setNewClassificationCodeMaintenanceComment(testdataprop.getProperty("comment"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("complete"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("close"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    //signOut
    clickSignOut();   
  }
}