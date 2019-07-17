package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.FinancialWebHomepageWorkflow;
import financialWeb.workflow.GLEnquiriesWorkflow;
import financialWeb.workflow.GLMaintenanceWorkflow;

public class GLEnquiries65538 extends GLEnquiriesWorkflow{
  
    @Test(groups = {"smoke"})
   public void  amendExistingHighLevelEnquiries() throws InterruptedException, ParseException, IOException, URISyntaxException {
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    GLMaintenanceWorkflow.verifyAndcreateDetailCodeDimension(testdataprop.getProperty("detailcodedimensions"),testdataprop.getProperty("detailcodedimensionsdesc"),testdataprop.getProperty("detailcodedimensionvalue"),testdataprop.getProperty("detailCodeDesc"),orprop.getProperty("detailcodetable"));
    analysisCode = GLMaintenanceWorkflow.createAnalysisCode(testdataprop.getProperty("detailcodeanalysis"),testdataprop.getProperty("detailcodedimensionsdesc"),testdataprop.getProperty("detailcodeanalysisdesc"));
    detailCode = GLMaintenanceWorkflow.createNewDetailCode();
    newEnquiryName = createHighLevelEnquiry();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("clear"));
    findHighLevelEnquiryName(newEnquiryName);
    getCreateCopyOfEnquiryName(newEnquiryName);
    setHighLevelDesctiption(testdataprop.getProperty("amendhighlevelenquiriesdesc"));
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    validateHighLevelDesctiption(testdataprop.getProperty("amendhighlevelenquiriesdesc"));
  
    //signOut
    clickSignOut();
      
  }
}