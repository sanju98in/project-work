package upmcms.testScripts.oracle;
import upmcms.workflow.MyPensionWorkflow;

public class UPM25327 extends MyPensionWorkflow{
  
 // @Test(groups = {"oracle"})
  public void  cmsChangeOfPasswordPersonalDetails() throws Exception {
    
    cmsSignOnOracleDB(testdataprop.getProperty("orausername"),testdataprop.getProperty("orapassword"),testdataprop.getProperty("oraseqans"));
    clickTopBanner(testdataprop.getProperty("personaldetails"));
    searchAndClickMyPersonalDetailsLink(testdataprop.getProperty("updatemypassword"));
    
    //incorrect current password
    setupNewPasswordForOracle(
        testdataprop.getProperty("currentPassword"),
        testdataprop.getProperty("newPassword"),
        testdataprop.getProperty("RetypedNewPassword"));
    validateSecurityMsg(msgprop.getProperty("changemypassworderror"));
    retry();
    
    //correct current password    
    setupNewPasswordForOracle(
        testdataprop.getProperty("orapassword"),
        testdataprop.getProperty("hello"),
        testdataprop.getProperty("hello"));
    appAlert(msgprop.getProperty("changemypasserror"));
    
  //correct current password    
    setupNewPasswordForOracle(
        testdataprop.getProperty("orapassword"),
        testdataprop.getProperty("hello")+"12345",
        testdataprop.getProperty("hello")+ "12345");
    appAlert(msgprop.getProperty("changemypasserror"));
    
  //correct current password    
    setupNewPasswordForOracle(
        testdataprop.getProperty("orapassword"),
        testdataprop.getProperty("hello")+ "12345?",
        testdataprop.getProperty("hello")+ "12345?");
    appAlert(msgprop.getProperty("changemypasserror"));
    
    //correct current password    
    setupNewPasswordForOracle(
        testdataprop.getProperty("orapassword"),
        testdataprop.getProperty("orapassword"),
        testdataprop.getProperty("orapassword"));
    validateScreenMessage(msgprop.getProperty("samepasswordvalidationmsg"));
    retry();
    
    randomString=getRandomAlphaNumericValue(testdataprop.getProperty("randompasswordlimit"));
    setupNewPasswordForOracle(testdataprop.getProperty("orapassword"),randomString);
    waitForPageLoad();
    Ok();
    
    // login again with updated security details
    cmsSignOnOracleDB(testdataprop.getProperty("orausername"),testdataprop.getProperty("orapassword"),testdataprop.getProperty("oraseqans"));
    
  //log off
    cmsSignOut();
  }

  
}