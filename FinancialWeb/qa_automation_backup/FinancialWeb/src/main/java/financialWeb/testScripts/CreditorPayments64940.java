package financialWeb.testScripts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.testng.annotations.Test;
import financialWeb.workflow.CreditorPaymentsWorkflow;

public class CreditorPayments64940 extends CreditorPaymentsWorkflow{
  
  @Test(groups = {"smoke"})
  public void  newPaymentRunBACS() throws InterruptedException, ParseException, IOException, URISyntaxException {
            
    creditorNewPayment(testdataprop.getProperty("templatebacsrun"),msgprop.getProperty("paymentrunstatusinprogress"),msgprop.getProperty("paymentrunstatuscomplete"));
    clickHrefLink(testdataprop.getProperty("home"));
    //signOut
    clickSignOut();   
  }
}