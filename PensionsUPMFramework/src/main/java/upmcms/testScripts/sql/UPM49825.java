package upmcms.testScripts.sql;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import upmcms.workflow.MyPensionWorkflow;

public class UPM49825 extends MyPensionWorkflow{
  
  @Test(groups = {"sqlServer"})
  public void  cmsUpdateNominationsAddingTwoPlusNegativeTestsMainBody() throws InterruptedException, ParseException, IOException, URISyntaxException {
    
    cmsSignOnSqlServerDB(testdataprop.getProperty("sqlusername"),testdataprop.getProperty("sqlpassword"),testdataprop.getProperty("sqlseqans"));
    
    clickTopBanner(testdataprop.getProperty("membershipdetails"));
    searchAndClickMyMembershipDeDetailsLink(testdataprop.getProperty("updatemynomination"));
    validateUpdateNominationLabel(msgprop.getProperty("nominationpctmsg"));
    selectNominee(testdataprop.getProperty("prefmethodnothing"));
    appAlert(msgprop.getProperty("mendatoryfielderror"));
    randomString = getRandomString(testdataprop.getProperty("randomstringlimit"));
    updateNomination(randomString,
        testdataprop.getProperty("reltomembers"),
        testdataprop.getProperty("dayofbirth"),
        testdataprop.getProperty("monthofbirth"),
        testdataprop.getProperty("yearofbirth"),
        testdataprop.getProperty("nominationtype"),
        testdataprop.getProperty("pctgbenefit"),
        testdataprop.getProperty("addnomineeno")
        );
    SetNewNominee(testdataprop.getProperty("addnomineeyes"));
    setPercentageOfBenefits(testdataprop.getProperty("pctgbenefitzero"));
    appAlert(msgprop.getProperty("pctgofbenifitserror"));
    setPercentageOfBenefits(testdataprop.getProperty("pctgbenefitoverlimit"));
    appAlert(msgprop.getProperty("pctgofbenifitserror"));
    setPercentageOfBenefits(testdataprop.getProperty("pctgbenefitunderlimit"));
    SetNewNominee(testdataprop.getProperty("addnomineeno"));
    submitChanges();
    goBack();
    setPercentageOfBenefits(testdataprop.getProperty("pctgbenefit"));
    submitChanges();
    validateScreenMessage(msgprop.getProperty("nominationmsg"));
    
    //log off
    cmsSignOut();
  }
}