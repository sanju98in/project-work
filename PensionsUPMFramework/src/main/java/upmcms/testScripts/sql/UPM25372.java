package upmcms.testScripts.sql;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import upmcms.workflow.MyPensionWorkflow;

public class UPM25372 extends MyPensionWorkflow{
  
  @Test(groups = {"sqlServer"})
  public void  loginAsPensioner() throws InterruptedException, ParseException, IOException, URISyntaxException {
    
    cmsSignOnSqlServerDB(testdataprop.getProperty("sqlusername"),testdataprop.getProperty("sqlpassword"),testdataprop.getProperty("sqlseqans"));
    
    validateLabel(msgprop.getProperty("civicapensions"));
    
    //log off
    cmsSignOut();
  }
}