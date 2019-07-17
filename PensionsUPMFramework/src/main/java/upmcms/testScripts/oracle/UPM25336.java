package upmcms.testScripts.oracle;
import org.testng.annotations.Test;
import upmcms.workflow.MyPersonalDetailsWorkflow;

public class UPM25336 extends MyPersonalDetailsWorkflow{
  
  @Test(groups = {"oracle"})
  public void  cmsUpdatePMOCRightHandSide() throws Exception {
    
    cmsSignOnOracleDB(testdataprop.getProperty("orausername"),testdataprop.getProperty("orapassword"),testdataprop.getProperty("oraseqans"));
    
    validateCMSPersonalDetails(orprop.getProperty("table"),testdataprop.getProperty("personaldetails"),testdataprop.getProperty("mypersonaldata"),testdataprop.getProperty("mypersonaldatalinks"));
    searchAndClickLinkFromInThisSection(testdataprop.getProperty("methodofcommn"));
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