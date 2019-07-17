package upmcms.testScripts.oracle;
import upmcms.workflow.MyPensionWorkflow;

public class UPM25326 extends MyPensionWorkflow{

//cannot execute as the functionality for updating security detail is broken
 // @Test(groups = {"oracle"})
  public void  cmsUpdateMySecurityQnsChangeMyAccountDetails() throws Exception {
    
    cmsSignOnOracleDB(testdataprop.getProperty("orausername"),testdataprop.getProperty("orapassword"),testdataprop.getProperty("oraseqans"));

    clickTopBanner(testdataprop.getProperty("changemyaccount"));
    searchAndClickLinkFromInThisSection(testdataprop.getProperty("changemysecurityqns"));
    setPassword(testdataprop.getProperty("wrongpassword"));
    submitChanges();
    validateSecurityMsg(msgprop.getProperty("incorrectpassword"));
    retry();
    setPassword(testdataprop.getProperty("orapassword"));
    submitChanges();
    submitChanges();
    validateSecurityMsg(msgprop.getProperty("nochangeinpassword"));
    completeChanges();
    searchAndClickMyPersonalDetailsLink(testdataprop.getProperty("updatemysecurityqns"));
    setPassword(testdataprop.getProperty("orapassword"));
    submitChanges();
    securityQAndAns = getRandomString(testdataprop.getProperty("newsecuritylimit"));
    setupNewSecurityQAndAnswersForOracle(securityQAndAns);
 
    //log off
    cmsSignOut();
    
    // login again with updated security details
    cmsSignOnOracleDB(testdataprop.getProperty("orausername"),testdataprop.getProperty("orapassword"),testdataprop.getProperty("oraseqans"));
    
  //log off
    cmsSignOut();
  }

  
}