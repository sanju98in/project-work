package upmcms.testScripts.oracle;
import org.testng.annotations.Test;
import upmcms.workflow.MyPersonalDetailsWorkflow;

public class UPM25324 extends MyPersonalDetailsWorkflow{
  
  @Test(groups = {"oracle"})
  public void  cmsChangeUserNameChangeMyAccount() throws Exception {
    
    cmsSignOnOracleDB(testdataprop.getProperty("orasetcurrentusername"),testdataprop.getProperty("orasetcurrentpassword"),testdataprop.getProperty("orasetcurrentseqans"));
    
    clickTopBanner(testdataprop.getProperty("changemyaccount"));
    searchAndClickLinkFromInThisSection(testdataprop.getProperty("changemyusername"));
    changeUsername(testdataprop.getProperty("orasetcurrentusername").toUpperCase());
    validateScreenMessage(msgprop.getProperty("changeusernameerror"));
    retry();
    
    changeUsername(testdataprop.getProperty("orasetcurrentusername").toLowerCase());
    appAlert(msgprop.getProperty("changeusernamealert"));

    changeUsername(testdataprop.getProperty("orasetcurrentusername")+"?");
    appAlert(msgprop.getProperty("changeusernamealert"));
    
    changeUsername(testdataprop.getProperty("orasetcurrentusername").toUpperCase()+"_ - . @");
    appAlert(msgprop.getProperty("changeusernamealert"));

    setNewUsername(testdataprop.getProperty("orasetcurrentusername").toUpperCase()+"A");
    setRetypedUsername(testdataprop.getProperty("orasetcurrentusername").toUpperCase()+"AB");
    submitChanges();
    validateScreenMessage(msgprop.getProperty("mismatchusernameerror"));
    retry();
    
    if(testdataprop.getProperty("orasetcurrentusername").equalsIgnoreCase(testdataprop.getProperty("oraseteoldusername"))) {
      updateUsernameForOracle(getRandomAlphaNumericValue(testdataprop.getProperty("randomstringlimit")).toUpperCase());
    }
      else {
        updateUsernameForOracle(getRandomAlphaNumericValue(testdataprop.getProperty("randomstringlimit")).toUpperCase());
      }

    setPassword(testdataprop.getProperty("wrongpassword"));
    submitChanges();
    validateScreenMessage(msgprop.getProperty("wrongpasswordvalidationmessage"));
    retry();
    setPassword(testdataprop.getProperty("orasetcurrentpassword"));
    submitChanges();
    
    setLogin(testdataprop.getProperty("oraseteoldusername"));
    setPassword(testdataprop.getProperty("oraseteoldusername"));
    clickButton(testdataprop.getProperty("signin"));
    validateAuthentication();
    
    setLogin(testdataprop.getProperty("orasetcurrentusername"));
    setPassword(testdataprop.getProperty("orasetcurrentpassword"));
    clickButton(testdataprop.getProperty("signin"));
    waitForPageLoad();
    setPassword(testdataprop.getProperty("orasetcurrentseqans"));
    waitForPageLoad();
    clickButton(testdataprop.getProperty("signin"));
    waitForPageLoad();
    //log off
    cmsSignOut();
  }
}