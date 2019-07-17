package upmcms.testScripts.sql;
import upmcms.workflow.MyPensionWorkflow;
import util.GenUtil;

public class UPM52042 extends MyPensionWorkflow{
  
 
  //Validation on step 5 needs to be checked
  //@Test(groups = {"sqlServer"})
//this script is failing as unified bank details link is not working.
  public void unifiedBankValidationForAccountNameMainBodyLink() throws Exception {
    
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

    selectBuildingSocietyAccount(testdataprop.getProperty("addnomineeyes"));
    submitChanges();
    appAlert(msgprop.getProperty("mendatoryfielderror"));
    
    selectBuildingSocietyAccount(testdataprop.getProperty("addnomineeno"));
    
    setBankSortCode(testdataprop.getProperty("banksortcode"));
    //appAlert(msgprop.getProperty("mendatoryfielderror"));
    
    randomString = getRandomString(testdataprop.getProperty("pctgbenefit")) + autoTest;
    setBankAccountName(randomString);
    appAlert(msgprop.getProperty("accountnamelimiterror"));
    
    randomString = getRandomString(testdataprop.getProperty("pctgbenefitunderlimit")) +" " +autoTest;
    setBankAccountName(randomString);
    
    submitChanges();
    
    retry();
    //log off
    cmsSignOut();
  }
}