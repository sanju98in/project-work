package upmcms.testScripts.sql;
import org.testng.annotations.Test;
import upmcms.workflow.MyPersonalDetailsWorkflow;

public class UPM25336 extends MyPersonalDetailsWorkflow{
  
  @Test(groups = {"sqlServer"})
  public void  cmsUpdatePMOCRightHandSide() throws Exception {
    
    cmsSignOnSqlServerDB(testdataprop.getProperty("sqlusername"),testdataprop.getProperty("sqlpassword"),testdataprop.getProperty("sqlseqans"));
    
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