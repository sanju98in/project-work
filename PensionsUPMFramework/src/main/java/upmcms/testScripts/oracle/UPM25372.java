package upmcms.testScripts.oracle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import upmcms.workflow.MyPensionWorkflow;

public class UPM25372 extends MyPensionWorkflow{
  
  @Test(groups = {"oracle"})
  public void  loginAsPensioner() throws InterruptedException, ParseException, IOException, URISyntaxException {
    
    cmsSignOnOracleDB(testdataprop.getProperty("orausername"),testdataprop.getProperty("orapassword"),testdataprop.getProperty("oraseqans"));
    
    validateLabel(msgprop.getProperty("civicapensions"));
    
    //log off
    cmsSignOut();
  }
}