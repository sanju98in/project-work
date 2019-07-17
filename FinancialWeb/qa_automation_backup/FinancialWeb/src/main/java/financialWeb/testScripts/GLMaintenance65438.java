package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.GLMaintenanceWorkflow;

public class GLMaintenance65438 extends GLMaintenanceWorkflow{
  
  @Test(groups = {"smoke"})
  public void  createClassificationCode() throws InterruptedException, ParseException, IOException, URISyntaxException {
       
    createClassificationMaintenanceCode();
    //signOut
    clickSignOut();   
  }
}