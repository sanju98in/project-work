package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.GLMaintenanceWorkflow;

public class GLMaintenance65462 extends GLMaintenanceWorkflow{
  
  @Test(groups = {"smoke"})
  public void  findClassificationCode() throws InterruptedException, ParseException, IOException, URISyntaxException {
       
    classificationCode= createClassificationMaintenanceCode();
    //find classification code 
    searchText(testdataprop.getProperty("findclassificationcode"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("findclassificationcode"));
    findCode(classificationCode);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    validateGridIsAdded(orprop.getProperty("tablerevoverygroup"),classificationCode.trim());
    
    //signOut
    clickSignOut();   
  }
}