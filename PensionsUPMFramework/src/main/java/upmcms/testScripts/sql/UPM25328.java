package upmcms.testScripts.sql;
import org.testng.annotations.Test;
import upmcms.workflow.MyPensionWorkflow;

public class UPM25328 extends MyPensionWorkflow{
  
  @Test(groups = {"sqlServer"})
  public void  cmsChangeOfPasswordChangeMyAccount() throws Exception {
    
    cmsSignOnSqlServerDB(testdataprop.getProperty("sqlsetcurrentusername"),testdataprop.getProperty("sqlsetcurrentpassword"),testdataprop.getProperty("sqlsetcurrentseqans"));
    clickTopBanner(testdataprop.getProperty("changemyaccount"));
    searchAndClickLinkFromInThisSection(testdataprop.getProperty("changemypassword"));
    
    //incorrect current password
    setupNewPasswordForSqlServer(
        testdataprop.getProperty("currentPassword"),
        testdataprop.getProperty("newPassword"),
        testdataprop.getProperty("RetypedNewPassword"));
    
    validateSecurityMsg(msgprop.getProperty("changemypassworderror"));
    retry();
    
    //correct current password    
    setupNewPasswordForSqlServer(
        testdataprop.getProperty("sqlsetcurrentpassword"),
        testdataprop.getProperty("hello"),
        testdataprop.getProperty("hello"));
    appAlert(msgprop.getProperty("changemypasserror"));
    
  //correct current password    
    setupNewPasswordForSqlServer(
        testdataprop.getProperty("sqlsetcurrentpassword"),
        testdataprop.getProperty("hello")+"12345",
        testdataprop.getProperty("hello")+ "12345");
    appAlert(msgprop.getProperty("changemypasserror"));
    
  //correct current password    
    setupNewPasswordForSqlServer(
        testdataprop.getProperty("sqlsetcurrentpassword"),
        testdataprop.getProperty("hello")+ "12345?",
        testdataprop.getProperty("hello")+ "12345?");
    appAlert(msgprop.getProperty("changemypasserror"));
    
    
    //correct current password    
    setupNewPasswordForSqlServer(
        testdataprop.getProperty("sqlsetcurrentpassword"),
        testdataprop.getProperty("sqlsetcurrentpassword"),
        testdataprop.getProperty("sqlsetcurrentpassword"));
    validateScreenMessage(msgprop.getProperty("samepasswordvalidationmsg"));
    retry();
    
   randomString=getRandomAlphaNumericValue(testdataprop.getProperty("randompasswordlimit"));
    setupNewPasswordForSqlServer(testdataprop.getProperty("sqlsetcurrentpassword"),randomString);
    waitForPageLoad();
    Ok();
    
    // login again with updated security details
    cmsSignOnSqlServerDB(testdataprop.getProperty("sqlsetcurrentusername"),testdataprop.getProperty("sqlsetcurrentpassword"),testdataprop.getProperty("sqlsetcurrentseqans"));
    
  //log off
    cmsSignOut();
  }

  
}