package upmcms.testScripts.sql;
import org.testng.annotations.Test;
import upmcms.workflow.MyPensionWorkflow;

public class UPM25325 extends MyPensionWorkflow{
  
  @Test(groups = {"sqlServer"})
  public void  cmsUpdateMySecurityQnsPesonalDetails() throws Exception {
    
    cmsSignOnSqlServerDB(testdataprop.getProperty("sqlsetcurrentusername"),testdataprop.getProperty("sqlsetcurrentpassword"),testdataprop.getProperty("sqlsetcurrentseqans"));
    
    validateCMSPersonalDetails(orprop.getProperty("table"),testdataprop.getProperty("personaldetails"),testdataprop.getProperty("mypersonaldata"),testdataprop.getProperty("mypersonaldatalinks"));
    searchAndClickMyPersonalDetailsLink(testdataprop.getProperty("updatemysecurityqns"));
    setPassword(testdataprop.getProperty("wrongpassword"));
    submitChanges();
    validateSecurityMsg(msgprop.getProperty("incorrectpassword"));
    retry();
    setPassword(testdataprop.getProperty("sqlsetcurrentpassword"));
    submitChanges();
    submitChanges();
    validateSecurityMsg(msgprop.getProperty("nochangeinpassword"));
    completeChanges();
    searchAndClickMyPersonalDetailsLink(testdataprop.getProperty("updatemysecurityqns"));
    setPassword(testdataprop.getProperty("sqlsetcurrentpassword"));
    submitChanges();
    securityQAndAns = getRandomString(testdataprop.getProperty("newsecuritylimit"));
    setupNewSecurityQAndAnswersForSqlServer(securityQAndAns);
 
    //log off
    cmsSignOut();
    
    // login again with updated security details
    cmsSignOnSqlServerDB(testdataprop.getProperty("sqlsetcurrentusername"),testdataprop.getProperty("sqlsetcurrentpassword"),testdataprop.getProperty("sqlsetcurrentseqans"));
    
  //log off
    cmsSignOut();
  }

  
}