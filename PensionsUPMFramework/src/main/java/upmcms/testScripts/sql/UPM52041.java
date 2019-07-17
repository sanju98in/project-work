package upmcms.testScripts.sql;
import upmcms.workflow.MyPensionWorkflow;
import util.GenUtil;

public class UPM52041 extends MyPensionWorkflow{
  
//This test case will execute only on SQL back end as the user is not configured in oracle db.
  //@Test(groups = {"sqlServer"})
//this script is failing as unified bank details link is not working.
  public void unifiedBankValidationForMendatoryFieldsMainBodyLink() throws Exception {
    
    cmsSignOnSqlServerDB(testdataprop.getProperty("sqlpensionusername"),testdataprop.getProperty("sqlpensionpassword"),testdataprop.getProperty("sqlpensionseqans"));
    
    clickTopBanner(testdataprop.getProperty("membershipdetails"));
    searchAndClickLinkFromInThisSection(testdataprop.getProperty("updatebankdetailsunified"));
    isNewBankAcBasedInUK(testdataprop.getProperty("bankacinukyes"));
    selectEffectiveDateOfChange();
    String newDate=GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("effectivedays"));
    selectCalendarDate(newDate);
    submitChanges();
    //waitforProcessUnload();
 
    searchTableColumn(orprop.getProperty("updatemybankdetailslabels"), msgprop.getProperty("mybankdetailsunifiedlabels"));
  
    //add new code
    selectBuildingSocietyAccount(testdataprop.getProperty("addnomineeyes"));
    searchTableColumn(orprop.getProperty("updatemybankdetailslabels"), msgprop.getProperty("bldgsctyreferencelabels"));
    
    validateHelpQuestions(orprop.getProperty("listquestioncircle"),orprop.getProperty("listhelptext"),orprop.getProperty("closehelptitle"));
    
    submitChanges();
    appAlert(msgprop.getProperty("mendatoryfielderror"));
    
    randomString = getRandomString(testdataprop.getProperty("randomstringlimit")) + autoTest;
    setBankAccountName(randomString);
    appAlert(msgprop.getProperty("mendatoryfielderror"));
    
    setBankSortCode(testdataprop.getProperty("banksortcode"));
    appAlert(msgprop.getProperty("mendatoryfielderror"));
    
    randomValue = getRandomNumber(testdataprop.getProperty("accountnumberlimit"));
    setBankAccountNumber(randomValue);

    //add new code
    selectBuildingSocietyAccount(testdataprop.getProperty("addnomineeyes"));
    submitChanges();
    appAlert(msgprop.getProperty("mendatoryfielderror"));
    //log off
    cmsSignOut();
  }
}