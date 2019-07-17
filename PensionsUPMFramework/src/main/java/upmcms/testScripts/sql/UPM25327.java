package upmcms.testScripts.sql;
import org.testng.annotations.Test;
import upmcms.workflow.MyPensionWorkflow;

public class UPM25327 extends MyPensionWorkflow{

  //Functionality is not working clicking on Change my password link is throwing error
  @Test(groups = {"sqlServer"})
  public void  cmsChangeOfPasswordPersonalDetails() throws Exception {
    
    cmsSignOnSqlServerDB(testdataprop.getProperty("sqlsetcurrentusername"),testdataprop.getProperty("sqlsetcurrentpassword"),testdataprop.getProperty("sqlsetcurrentseqans"));
    clickTopBanner(testdataprop.getProperty("personaldetails"));
    searchAndClickMyPersonalDetailsLink(testdataprop.getProperty("updatemypassword"));
    
    //incorrect current password
    setupWrongNewPasswordForSqlServer(
        testdataprop.getProperty("currentPassword"),
        testdataprop.getProperty("newPassword"),
        testdataprop.getProperty("RetypedNewPassword"));
    
    validateSecurityMsg(msgprop.getProperty("changemypassworderror"));
    retry();
    
    //correct current password    
    setupWrongNewPasswordForSqlServer(
        testdataprop.getProperty("sqlsetcurrentpassword"),
        testdataprop.getProperty("hello"),
        testdataprop.getProperty("hello"));
    appAlert(msgprop.getProperty("changemypasserror"));
    
  //correct current password    
    setupWrongNewPasswordForSqlServer(
        testdataprop.getProperty("sqlsetcurrentpassword"),
        testdataprop.getProperty("hello")+"12345",
        testdataprop.getProperty("hello")+ "12345");
    appAlert(msgprop.getProperty("changemypasserror"));
    
  //correct current password    
    setupWrongNewPasswordForSqlServer(
        testdataprop.getProperty("sqlsetcurrentpassword"),
        testdataprop.getProperty("hello")+ "12345?",
        testdataprop.getProperty("hello")+ "12345?");
    appAlert(msgprop.getProperty("changemypasserror"));
    
    //correct current password    
    setupWrongNewPasswordForSqlServer(
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