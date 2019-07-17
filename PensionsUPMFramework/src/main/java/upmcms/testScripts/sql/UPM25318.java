package upmcms.testScripts.sql;
import org.testng.annotations.Test;
import upmcms.workflow.MyPersonalDetailsWorkflow;

public class UPM25318 extends MyPersonalDetailsWorkflow{
  
  @Test(groups = {"sqlServer"})
  public void  cmsChangeOfEmailRightHandSide() throws Exception {
    
    cmsSignOnSqlServerDB(testdataprop.getProperty("sqlusername"),testdataprop.getProperty("sqlpassword"),testdataprop.getProperty("sqlseqans"));
    
    validateCMSPersonalDetails(orprop.getProperty("table"),testdataprop.getProperty("personaldetails"),testdataprop.getProperty("mypersonaldata"),testdataprop.getProperty("mypersonaldatalinks"));
    searchAndClickLinkFromInThisSection(testdataprop.getProperty("updatemyemailinthissec"));
    validateHeader(orprop.getProperty("updatemyemailheader"),msgprop.getProperty("updatemyemail"));
    cmsChangeEmailNegative(testdataprop.getProperty("newemailadd"),msgprop.getProperty("updatemyemailvalidationmessage"));
    String randomEmail= getRandomEmail();
    cmsChangeEmailPositive(randomEmail,msgprop.getProperty("wrongpasswordvalidationmessage"),testdataprop.getProperty("wrongpassword"),testdataprop.getProperty("orapassword"));
    myPersonalDetails(randomEmail);
    
    //log off
    cmsSignOut();
  }
}