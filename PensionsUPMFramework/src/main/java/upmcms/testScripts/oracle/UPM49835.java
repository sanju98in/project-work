package upmcms.testScripts.oracle;
import org.testng.annotations.Test;
import upmcms.workflow.MyPensionWorkflow;

public class UPM49835 extends MyPensionWorkflow{
  
  @Test(groups = {"oracle"})
  public void  cmsUpdateNominationsAddingTenRightHandSide() throws Exception {
    
    cmsSignOnSqlServerDB(testdataprop.getProperty("sqlusername"),testdataprop.getProperty("sqlpassword"),testdataprop.getProperty("sqlseqans"));
    
    clickTopBanner(testdataprop.getProperty("membershipdetails"));
    searchAndClickLinkFromInThisSection(testdataprop.getProperty("updatemynomination"));
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