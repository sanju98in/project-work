package upmcms.testScripts.oracle;
import org.testng.annotations.Test;
import upmcms.workflow.MyPersonalDetailsWorkflow;

public class UPM25335 extends MyPersonalDetailsWorkflow{
  
  @Test(groups = {"oracle"})
  public void  cmsUpdatePMOCMainBody() throws Exception {
    
    cmsSignOnOracleDB(testdataprop.getProperty("orausername"),testdataprop.getProperty("orapassword"),testdataprop.getProperty("oraseqans"));
    
    validateCMSPersonalDetails(orprop.getProperty("table"),testdataprop.getProperty("personaldetails"),testdataprop.getProperty("mypersonaldata"),testdataprop.getProperty("mypersonaldatalinks"));
    searchAndClickMyPersonalDetailsLink(testdataprop.getProperty("methodofcommn"));
    perfMethodOfCommunication(testdataprop.getProperty("prefmethodnothing"));
    submitChanges();
    appAlert(msgprop.getProperty("mendatoryfielderror"));
    perfMethodOfCommunication(testdataprop.getProperty("prefmethodbyletter"));
    submitChanges();
    myPersonalDetails(testdataprop.getProperty("prefmethodbyletter"));
    
    //log off
    cmsSignOut();
  }
}