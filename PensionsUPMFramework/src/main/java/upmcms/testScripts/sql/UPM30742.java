package upmcms.testScripts.sql;
import org.testng.annotations.Test;
import upmcms.workflow.MyPensionWorkflow;
import util.GenUtil;

public class UPM30742 extends MyPensionWorkflow{
  
  //need valid credentials as the given user doesn't have matching data as per test case
  @Test(groups = {"sqlServer"})
  public void  amendingBankOrBuildingSocietyUpdateMyBakDetailsRightHandLink() throws Exception {
    
    cmsSignOnSqlServerDB(testdataprop.getProperty("sqlpensionusername"),testdataprop.getProperty("sqlpensionpassword"),testdataprop.getProperty("sqlpensionseqans"));
    
    clickTopBanner(testdataprop.getProperty("membershipdetails"));
    searchAndClickMyMembershipDetailsLink(testdataprop.getProperty("updatemybankdetails"));
    isNewBankAcBasedInUK(testdataprop.getProperty("bankacinukno"));
    selectEffectiveDateOfChange();
    String newDate=GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("effectivedays"));
    selectCalendarDate(newDate);
    submitChanges();
    validateScreenMessage(msgprop.getProperty("overseasbankupdatemsg"));
    completeChanges();
    searchTableColumn(orprop.getProperty("updatemyemailheader"), msgprop.getProperty("mymembershipdetails"));
    
    searchAndClickLinkFromInThisSection(testdataprop.getProperty("updatemybankdetails"));
    isNewBankAcBasedInUK(testdataprop.getProperty("bankacinukyes"));
    selectEffectiveDateOfChange();
    newDate=GenUtil.additionalDayOfDateFromCurrentDate(testdataprop.getProperty("effectivedays"));
    selectCalendarDate(newDate);
    submitChanges();
    setBankSortCode(testdataprop.getProperty("banksortcode"));
    search();
    validateSearchResults(orprop.getProperty("searchresult"));
    goBack();
    clearSortCode();
    setBankName(testdataprop.getProperty("bankname"));
    setBankBranch(testdataprop.getProperty("bankbranch"));
    search();
    selectBankDetailRadioOption(orprop.getProperty("searchresultsecondradio"));
    goNext();
    randomString = getRandomString(testdataprop.getProperty("randomstringlimit")) + autoTest;
    setAccountName(randomString);
    randomValue = getRandomNumber(testdataprop.getProperty("accountnumberlimit"));
    setAccountNumber(randomValue);
    setPaymentRef(testdataprop.getProperty("onlinepaymentref"));
    goNext();
    confirmChanges();
    validateScreenMessage(msgprop.getProperty("invalidacname"));
    retry();
    //validateScreenMessage(msgprop.getProperty("overseasbankupdatemsg"));
    searchTableColumn(orprop.getProperty("updatemyemailheader"), testdataprop.getProperty("updatemybankdetails"));
    setBankSortCode(testdataprop.getProperty("banksortcode"));
    search();
    validateSearchResults(orprop.getProperty("searchresult"));
    selectBankDetailRadioOption(orprop.getProperty("searchresultradio"));
    goNext();
    setAccountName(testdataprop.getProperty("accountname"));
    randomValue = getRandomNumber(testdataprop.getProperty("accountnumberlimit"));
    setAccountNumber(randomValue);
    setPaymentRef(testdataprop.getProperty("onlinepaymentref"));
    goNext();
    confirmChanges();
    
    
//    
//    
//    
//    validateUpdateNominationLabel(msgprop.getProperty("nominationpctmsg"));
//    selectNominee(testdataprop.getProperty("prefmethodnothing"));
//    appAlert(msgprop.getProperty("mendatoryfielderror"));
//    randomString = getRandomString(testdataprop.getProperty("randomstringlimit"));
//    updateNomination(randomString,
//        testdataprop.getProperty("reltomembers"),
//        testdataprop.getProperty("dayofbirth"),
//        testdataprop.getProperty("monthofbirth"),
//        testdataprop.getProperty("yearofbirth"),
//        testdataprop.getProperty("nominationtype"),
//        testdataprop.getProperty("pctgbenefit"),
//        testdataprop.getProperty("addnomineeno")
//        );
//    SetNewNominee(testdataprop.getProperty("addnomineeyes"));
//    setPercentageOfBenefits(testdataprop.getProperty("pctgbenefitzero"));
//    appAlert(msgprop.getProperty("pctgofbenifitserror"));
//    setPercentageOfBenefits(testdataprop.getProperty("pctgbenefitoverlimit"));
//    appAlert(msgprop.getProperty("pctgofbenifitserror"));
//    setPercentageOfBenefits(testdataprop.getProperty("pctgbenefitunderlimit"));
//    SetNewNominee(testdataprop.getProperty("addnomineeno"));
//    submitChanges();
//    goBack();
//    setPercentageOfBenefits(testdataprop.getProperty("pctgbenefit"));
//    submitChanges();
//    validateUpdateNominationMessage(msgprop.getProperty("nominationmsg"));
//    
    //log off
    cmsSignOut();
  }
}