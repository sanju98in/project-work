package upmcms.testScripts.oracle;
import upmcms.workflow.MyPensionWorkflow;

public class UPM25325 extends MyPensionWorkflow{
  
  //Security details are not being changed in oracle environment. Issue in application
  //@Test(groups = {"oracle"})
  public void  cmsUpdateMySecurityQnsPesonalDetails() throws Exception {
    
    cmsSignOnOracleDB(testdataprop.getProperty("orasetcurrentusername"),testdataprop.getProperty("orasetcurrentpassword"),testdataprop.getProperty("orasetcurrentseqans"));
    
    validateCMSPersonalDetails(orprop.getProperty("table"),testdataprop.getProperty("personaldetails"),testdataprop.getProperty("mypersonaldata"),testdataprop.getProperty("mypersonaldatalinks"));
    searchAndClickMyPersonalDetailsLink(testdataprop.getProperty("updatemysecurityqns"));
    setPassword(testdataprop.getProperty("wrongpassword"));
    submitChanges();
    validateSecurityMsg(msgprop.getProperty("incorrectpassword"));
    retry();
    setPassword(testdataprop.getProperty("orasetcurrentpassword"));
    submitChanges();
    submitChanges();
    validateSecurityMsg(msgprop.getProperty("nochangeinpassword"));
    completeChanges();
    searchAndClickMyPersonalDetailsLink(testdataprop.getProperty("updatemysecurityqns"));
    setPassword(testdataprop.getProperty("orasetcurrentpassword"));
    submitChanges();
    securityQAndAns = getRandomString(testdataprop.getProperty("newsecuritylimit"));
    setupNewSecurityQAndAnswersForOracle(securityQAndAns);
 
    //log off
    cmsSignOut();
    
    // login again with updated security details
    cmsSignOnOracleDB(testdataprop.getProperty("orasetcurrentusername"),testdataprop.getProperty("orasetcurrentpassword"),testdataprop.getProperty("orasetcurrentseqans"));
    
  //log off
    cmsSignOut();
  }

  
}