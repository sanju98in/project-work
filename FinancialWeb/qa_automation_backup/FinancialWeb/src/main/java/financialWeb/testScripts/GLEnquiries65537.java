package financialWeb.testScripts;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.FinancialWebHomepageWorkflow;
import financialWeb.workflow.GLEnquiriesWorkflow;
import financialWeb.workflow.GLMaintenanceWorkflow;

public class GLEnquiries65537 extends GLEnquiriesWorkflow {

  @Test(groups = {"smoke"})
  public void createHighLevelEnquiries()
      throws InterruptedException, ParseException, IOException, URISyntaxException {
    FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();

    GLMaintenanceWorkflow.verifyAndcreateDetailCodeDimension(
        testdataprop.getProperty("detailcodedimensions"),
        testdataprop.getProperty("detailcodedimensionsdesc"),
        testdataprop.getProperty("detailcodedimensionvalue"),
        testdataprop.getProperty("detailCodeDesc"), orprop.getProperty("detailcodetable"));

    analysisCode =
        GLMaintenanceWorkflow.createAnalysisCode(testdataprop.getProperty("detailcodeanalysis"),
            testdataprop.getProperty("detailcodedimensionsdesc"),
            testdataprop.getProperty("detailcodeanalysisdesc"));

    detailCode = GLMaintenanceWorkflow.createNewDetailCode();

    searchText(testdataprop.getProperty("searchglhighlevelenquiry"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchglhighlevel"));
    Thread.sleep(3000);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    setDimensionOne(testdataprop.getProperty("glenquiriesdimensionone"));
    setDCLevel(testdataprop.getProperty("detailcodedimensionvalue"));
    setDetailCode(analysisCode, orprop.getProperty("gldetailcodesearchtable"));
    selectCreateCopyOfEnquiryCheckbox();
    newEnquiryName = getRandomAlphaNumericValue(testdataprop.getProperty("copyofenquirynamelimit"));
    selectCreateCopyOfEnquiryName(newEnquiryName);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("save"));

    // newEnquiry no value is stored on class level so that can be used on different places.
    getCreateCopyOfEnquiryName(newEnquiryName);

    // signOut
    clickSignOut();
  }
}
