package upmcms.testScripts.sql;
import upmcms.workflow.MyPensionWorkflow;
import util.GenUtil;

public class UPM30748 extends MyPensionWorkflow{
  
//This test case will execute only onSQL back end as the user is not configured in oracle db.
  //@Test(groups = {"sqlServer"})
  //this script is failing as unified bank details link is not working.
  public void unifiedBankValidationDisplayAndHelpTextRightHandLink() throws Exception {
    
    cmsSignOnSqlServerDB(testdataprop.getProperty("sqlpensionusername"),testdataprop.getProperty("sqlpensionpassword"),testdataprop.getProperty("sqlpensionseqans"));
    
    clickTopBanner(testdataprop.getProperty("membershipdetails"));
    searchAndClickLinkFromInThisSection(testdataprop.getProperty("updatebankdetailsunified"));
    isNewBankAcBasedInUK(testdataprop.getProperty("bankacinukyes"));
    selectEffectiveDateOfChange();
    String newDate=GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("effectivedays"));
    selectCalendarDate(newDate);
    submitChanges();
    
    searchTableColumn(orprop.getProperty("updatemybankdetailslabels"), msgprop.getProperty("mybankdetailsunifiedlabels"));
    selectRadioOption(orprop.getProperty("searchresultradio"),testdataprop.getProperty("addnomineeyes"));
    validateHelpQuestions(orprop.getProperty("listquestioncircle"),orprop.getProperty("listhelptext"),orprop.getProperty("closehelptitle"));

    //log off
    cmsSignOut();
  }
}