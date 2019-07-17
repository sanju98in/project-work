package upmcms.testScripts.oracle;
import org.testng.annotations.Test;
import upmcms.workflow.MyPensionWorkflow;

public class UPM49834 extends MyPensionWorkflow{
  
  @Test(groups = {"oracle"})
  public void  cmsUpdateNominationsAddingTwoPlusNegativeTestsRightHandSide() throws Exception {
    
    cmsSignOnOracleDB(testdataprop.getProperty("orausername"),testdataprop.getProperty("orapassword"),testdataprop.getProperty("oraseqans"));
    
    clickTopBanner(testdataprop.getProperty("membershipdetails"));
    searchAndClickLinkFromInThisSection(testdataprop.getProperty("updatemynomination"));
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