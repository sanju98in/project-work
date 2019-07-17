package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.FinancialWebHomepageWorkflow;
import financialWeb.workflow.GLMaintenanceWorkflow;
import util.GenUtil;

public class GLMaintenance65087 extends GLMaintenanceWorkflow{
  
  @Test(groups = {"smoke"})
  public void  createDetailCode() throws InterruptedException, ParseException, IOException, URISyntaxException {
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    verifyAndcreateDetailCodeDimension(testdataprop.getProperty("detailcodedimensions"),testdataprop.getProperty("detailcodedimensionsdesc"),testdataprop.getProperty("detailcodedimensionvalue"),testdataprop.getProperty("detailCodeDesc"),orprop.getProperty("detailcodetable"));
    String analysisCode = createAnalysisCode(testdataprop.getProperty("detailcodeanalysis"),testdataprop.getProperty("detailcodedimensionsdesc"),testdataprop.getProperty("detailcodeanalysisdesc"));
    searchText(testdataprop.getProperty("searchgldetailcodemaintenance"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchgldetailcodemaintenance"));
    waitforPanelLoad();
    randomValue=GenUtil.getRandomAlphaNumericValue(testdataprop.getProperty("classificationcodelimit"));
    setClassificationCode(msgprop.getProperty("lbldetailcode"),randomValue);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    randomComment = getRandomComment();
    setClassificationCodeMaintenanceDescription(randomComment);
    setAccountType(testdataprop.getProperty("assettype"));
    setUnits(testdataprop.getProperty("units"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("addline"));
    clickFindAnalysisLevel();
    findClassificationMaintenanceCode(testdataprop.getProperty("detailcodedimensionvalue"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    clickLevel(testdataprop.getProperty("detailcodedimensionvalue"));
    clickGLDetailCodeMaintenanceAnalysisCode();
    setGLDetailCodeMaintenanceAnalysisCode(analysisCode);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    clickAnalysisCode(orprop.getProperty("finddebtorstablebody"),analysisCode);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    //field of detail code and classification code are same
    detailCode = storeClassificationCode(msgprop.getProperty("lbldetailcode"));
    clickHrefLink(testdataprop.getProperty("home"));
    //signOut
    clickSignOut();   
  }
}