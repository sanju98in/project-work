package upmcms.testScripts.sql;
import org.testng.annotations.Test;
import upmcms.workflow.MyPensionWorkflow;

public class UPM25373 extends MyPensionWorkflow{
  
  //Need oracle details for this test case. Test is running only on SqlServer 
  @Test(groups = {"sqlServer"})
  public void  cmsViewPayrollDocuments() throws Exception {
    
    cmsSignOnSqlServerDB(testdataprop.getProperty("sqlpensionusername"),testdataprop.getProperty("sqlpensionpassword"),testdataprop.getProperty("sqlpensionseqans"));
    clickTopBanner(testdataprop.getProperty("viewmydocuments"));
    searchAndClickLinkFromInThisSection(testdataprop.getProperty("mypayslipsandpsixty"));
  
    searchAndClickAnchorTextInTableColumn(orprop.getProperty("tablemypayslip"), testdataprop.getProperty("viewpayslip"));
    downloadPDF(testdataprop.getProperty("downloadpdf"));
    waitForPageLoad();

    driver.navigate().back();
    waitForPageLoad();
    validateHeader(orprop.getProperty("updatemyemailheader"),msgprop.getProperty("payslippageheader"));
    
    //log off
    cmsSignOut();
  }
}