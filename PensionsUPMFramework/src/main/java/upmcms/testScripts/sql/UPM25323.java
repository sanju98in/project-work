package upmcms.testScripts.sql;
import org.testng.annotations.Test;
import upmcms.workflow.MyPersonalDetailsWorkflow;

public class UPM25323 extends MyPersonalDetailsWorkflow{
  
  @Test(groups = {"sqlServer"})
  public void  cmsUpdateUserNamePersonalDetails() throws Exception {
    
    //cmsSignOnSqlServerDB(testdataprop.getProperty("sqlusername"),testdataprop.getProperty("sqlpassword"),testdataprop.getProperty("sqlseqans"));
    cmsSignOnSqlServerDB(testdataprop.getProperty("sqlsetcurrentusername"),testdataprop.getProperty("sqlsetcurrentpassword"),testdataprop.getProperty("sqlsetcurrentseqans"));
    
    clickTopBanner(testdataprop.getProperty("personaldetails"));
    searchAndClickMyPersonalDetailsLink(testdataprop.getProperty("updatemyusername"));
    changeUsername(testdataprop.getProperty("sqlsetcurrentusername").toUpperCase());
    validateScreenMessage(msgprop.getProperty("changeusernameerror"));
    retry();
    
    changeUsername(testdataprop.getProperty("sqlsetcurrentusername").toLowerCase());
    appAlert(msgprop.getProperty("changeusernamealert"));

    changeUsername(testdataprop.getProperty("sqlsetcurrentusername").toUpperCase()+"?");
    appAlert(msgprop.getProperty("changeusernamealert"));
    
    changeUsername(testdataprop.getProperty("sqlsetcurrentusername").toUpperCase()+"_ - . @");
    appAlert(msgprop.getProperty("changeusernamealert"));

    setNewUsername(testdataprop.getProperty("sqlsetcurrentusername").toUpperCase()+"A");
    setRetypedUsername(testdataprop.getProperty("sqlsetcurrentusername").toUpperCase()+"AB");
    submitChanges();
    validateScreenMessage(msgprop.getProperty("mismatchusernameerror"));
    retry();
    
    if(testdataprop.getProperty("sqlsetcurrentusername").equalsIgnoreCase(testdataprop.getProperty("sqloldchangeusername"))) {
      updateUsernameForSqlServer(getRandomAlphaNumericValue(testdataprop.getProperty("randomstringlimit")).toUpperCase());
    }
      else {
        updateUsernameForSqlServer(getRandomAlphaNumericValue(testdataprop.getProperty("randomstringlimit")).toUpperCase());
      }
    
    setPassword(testdataprop.getProperty("wrongpassword"));
    submitChanges();
    validateScreenMessage(msgprop.getProperty("wrongpasswordvalidationmessage"));
    retry();
    setPassword(testdataprop.getProperty("sqlsetcurrentpassword"));
    submitChanges();
    
    setLogin(testdataprop.getProperty("sqloldchangeusername"));
    setPassword(testdataprop.getProperty("sqlchangeoldpassword"));
    clickButton(testdataprop.getProperty("signin"));
    validateAuthentication();
    
    setLogin(testdataprop.getProperty("sqlsetcurrentusername"));
    setPassword(testdataprop.getProperty("sqlsetcurrentpassword"));
    clickButton(testdataprop.getProperty("signin"));
    waitForPageLoad();
    setPassword(testdataprop.getProperty("sqlsetcurrentseqans"));
    waitForPageLoad();
    clickButton(testdataprop.getProperty("signin"));
    waitForPageLoad();
    //log off
    cmsSignOut();
  }
}