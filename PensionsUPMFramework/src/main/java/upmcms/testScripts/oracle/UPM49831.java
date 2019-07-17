package upmcms.testScripts.oracle;
import org.testng.annotations.Test;
import upmcms.workflow.MyPensionWorkflow;

public class UPM49831 extends MyPensionWorkflow{
  
  @Test(groups = {"oracle"})
  public void  cmsUpdateNominationsAddingTenMainBody() throws Exception {
    
    cmsSignOnOracleDB(testdataprop.getProperty("orausername"),testdataprop.getProperty("orapassword"),testdataprop.getProperty("oraseqans"));
    
    clickTopBanner(testdataprop.getProperty("membershipdetails"));
    searchAndClickMyMembershipDeDetailsLink(testdataprop.getProperty("updatemynomination"));
    validateUpdateNominationLabel(msgprop.getProperty("nominationpctmsg"));
 
    //add and validate 10 Beneficiaries
    allNominatedBeneficiaries = createMultipleNomination(testdataprop.getProperty("tenpctgbenefit"),
        testdataprop.getProperty("reltomembers"),
        testdataprop.getProperty("dayofbirth"),
        testdataprop.getProperty("monthofbirth"),
        testdataprop.getProperty("yearofbirth"),
        testdataprop.getProperty("nominationtype"),
        testdataprop.getProperty("tenpctgbenefit"),
        testdataprop.getProperty("addnomineeyes")
        );
    validateNominatedBeneficiaries(orprop.getProperty("nominatedbeneficiaries"),allNominatedBeneficiaries);
    //log off
    cmsSignOut();
  }
}