
package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.GLMaintenanceWorkflow;

public class GLMaintenance66104 extends GLMaintenanceWorkflow{
  
  @Test(groups = {"smoke"})
  public void  createLedgerCode() throws InterruptedException, ParseException, IOException, URISyntaxException {
    
    verifyAndcreateControlData(testdataprop.getProperty("controldataset"),
        testdataprop.getProperty("detailcodedimensionvalue"),
        testdataprop.getProperty("searchorcreatecontroldata"),
        orprop.getProperty("tablecontroldatamaintenance"));
    
    verifyAndCreateCostCenterDimensions(testdataprop.getProperty("searchorcreatecontroldata"),
        testdataprop.getProperty("detailcodedimensionvalue"),
        testdataprop.getProperty("costcentredimensiondesc")
        );    
    analysisCode=createCostCentreAnalysis(testdataprop.getProperty("costcentreanalysissetcode"),
        testdataprop.getProperty("testcostcentredimensiondesc"),
        testdataprop.getProperty("costcentreanalysisdesc"));
   
    costCentreCode = createGLCostCenter();   
    verifyAndcreateDetailCodeDimension(testdataprop.getProperty("detailcodedimensions"),
        testdataprop.getProperty("detailcodedimensionsdesc"),
        testdataprop.getProperty("detailcodedimensionvalue"),
        testdataprop.getProperty("detailCodeDesc"),
        orprop.getProperty("detailcodetable"));    
    createAnalysisCode(testdataprop.getProperty("detailcodeanalysis"),
        testdataprop.getProperty("detailcodedimensionsdesc"),
        testdataprop.getProperty("detailcodeanalysisdesc"));    
    detailCode =createGLDetailCode();  
    classificationCode = createClassificationMaintenanceCode();   
    searchText(testdataprop.getProperty("searchglledgercodemaintenance"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchglledgercodemaintenance"));
    String ledgerCode = costCentreCode +"/"+ detailCode + "/" +classificationCode;
    setLedgerCode(ledgerCode);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    //signOut
    clickSignOut();   
  }  
}