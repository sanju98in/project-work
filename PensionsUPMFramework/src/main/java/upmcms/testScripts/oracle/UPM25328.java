package upmcms.testScripts.oracle;
import upmcms.workflow.MyPensionWorkflow;

public class UPM25328 extends MyPensionWorkflow{
  
 // @Test(groups = {"oracle"})
  public void  cmsChangeOfPasswordChangeMyAccount() throws Exception {
    
    //cmsSignOnOracleDB(testdataprop.getProperty("orausername"),testdataprop.getProperty("orapassword"),testdataprop.getProperty("oraseqans"));
    cmsSignOnOracleDB(testdataprop.getProperty("orasetcurrentusername"),testdataprop.getProperty("orasetcurrentpassword"),testdataprop.getProperty("orasetcurrentseqans"));
    clickTopBanner(testdataprop.getProperty("changemyaccount"));
    searchAndClickLinkFromInThisSection(testdataprop.getProperty("changemypassword"));
    
    //incorrect current password
    setupNewPasswordForOracle(
        testdataprop.getProperty("currentPassword"),
        testdataprop.getProperty("newPassword"),
        testdataprop.getProperty("RetypedNewPassword"));
    validateSecurityMsg(msgprop.getProperty("changemypassworderror"));
    retry();
    
    //correct current password    
    setupNewPasswordForOracle(
        testdataprop.getProperty("orasetcurrentpassword"),
        testdataprop.getProperty("hello"),
        testdataprop.getProperty("hello"));
    appAlert(msgprop.getProperty("changemypasserror"));
    
  //correct current password    
    setupNewPasswordForOracle(
        testdataprop.getProperty("orasetcurrentpassword"),
        testdataprop.getProperty("hello")+"12345",
        testdataprop.getProperty("hello")+ "12345");
    appAlert(msgprop.getProperty("changemypasserror"));
    
  //correct current password    
    setupNewPasswordForOracle(
        testdataprop.getProperty("orasetcurrentpassword"),
        testdataprop.getProperty("hello")+ "12345?",
        testdataprop.getProperty("hello")+ "12345?");
    appAlert(msgprop.getProperty("changemypasserror"));
    
    //correct current password    
    setupNewPasswordForOracle(
        testdataprop.getProperty("orasetcurrentpassword"),
        testdataprop.getProperty("orasetcurrentpassword"),
        testdataprop.getProperty("orasetcurrentpassword"));
    validateScreenMessage(msgprop.getProperty("samepasswordvalidationmsg"));
    retry();
    
    randomString=getRandomAlphaNumericValue(testdataprop.getProperty("randompasswordlimit"));
    setupNewPasswordForOracle(testdataprop.getProperty("orasetcurrentpassword"),randomString);
    Ok();
    
    // login again with updated security details
    cmsSignOnOracleDB(testdataprop.getProperty("orasetcurrentusername"),testdataprop.getProperty("orasetcurrentpassword"),testdataprop.getProperty("orasetcurrentseqans"));
    
  //log off
    cmsSignOut();
  }

  
}