package upmcms.workflow;

import java.io.FileNotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import upmcms.pages.LoginPage;
import upmcms.pages.MyPension;
import upmcms.pages.MyPersonalDetails;

/**
 * @author CIVICA
 */
public class MyPersonalDetailsWorkflow extends CommonWorkflow{

  protected String homePageTitle() throws InterruptedException{
     return driver.getTitle();
  }

  protected String loginPageTitle() throws InterruptedException, FileNotFoundException{
    //read the expected title of landing page 
    return driver.getTitle();
  }

  protected static void setLogin(String data) throws FileNotFoundException, InterruptedException {
    objloginPage = new LoginPage(driver);
    waitforPanelElement(LoginPage.txtLogin);
    setText(LoginPage.txtLogin, data);
  }

  protected static void clickButton(String data) throws FileNotFoundException, InterruptedException {
    objloginPage = new LoginPage(driver);
    waitForPageLoad();
    for(WebElement btnLabel:LoginPage.btnLabelMatch) {
      waitForPageLoad();
      if(btnLabel.getText().trim().equalsIgnoreCase(data)) {
        log.info(KEYWORD_PASS + " Found " + btnLabel.getText());
        clickElement(btnLabel);
        break;
      }
    }
    waitForPageLoad();
    //waitforPanelElement(LoginPage.txtPassword);
  }

  protected static void cmsSignIn(String linkName, String userName, String password, String seqAns) throws FileNotFoundException, InterruptedException {
    waitForPageLoad();
    Thread.sleep(3000);
    clickHrefLink(linkName);
    waitForPageLoad();
    setLogin(userName);
    setPassword(password);
    clickButton(linkName);
    waitForPageLoad();
    setPassword(seqAns);
    clickButton(linkName);
    waitForPageLoad();
    waitForPageLoad();
  }

   protected void cmsChangeEmailNegative(String data,String msg) throws FileNotFoundException, InterruptedException {
    objMyPersonalDetails = new MyPersonalDetails(driver);
    setText(MyPersonalDetails.txtNewEmailAdd, data);
    MyPersonalDetails.txtRepeatNewEmailAdd.clear();
    MyPersonalDetails.txtRepeatNewEmailAdd.sendKeys(data.toUpperCase());
    clickElement(MyPersonalDetails.btnSubmit);
    waitForPageLoad();
    validateMessage(MyPersonalDetails.lbltEmailAddErrorValidation,msg);
    waitForPageLoad();
    clickElement(MyPersonalDetails.btnRetry);
    waitForPageLoad();
  }
  
  protected void cmsChangeEmailPositive(String newRandomEmailAdd,String msg,String wrongpassword,String password) throws FileNotFoundException, InterruptedException {
    waitForPageLoad();
    objMyPersonalDetails = new MyPersonalDetails(driver);
    int size=MyPersonalDetails.txtUpdateMyEmailInputList.size();
    for(int i=0;i<size;i++) {
      MyPersonalDetails.txtUpdateMyEmailInputList.get(i).sendKeys(newRandomEmailAdd);
    }
    waitForPageLoad();
    clickElement(MyPersonalDetails.btnSubmit);
    waitForPageLoad();
    setPassword(wrongpassword);
    clickElement(MyPersonalDetails.btnSubmit);
    waitForPageLoad();
    validateMessage(MyPersonalDetails.lbltEmailAddErrorValidation,msg);
    waitForPageLoad();
    clickElement(MyPersonalDetails.btnRetry);
    waitForPageLoad();
    setPassword(password);
    clickElement(MyPersonalDetails.btnSubmit);
    waitForPageLoad();
  }
  
  protected void validateUpdatedData(String data) throws FileNotFoundException, InterruptedException{
    objMyPersonalDetails = new MyPersonalDetails(driver);
    waitForPageLoad();
    validateMessage(MyPersonalDetails.lblEmail, data);
  }
  
  protected void perfMethodOfCommunication(String data) throws FileNotFoundException, InterruptedException{
    objMyPersonalDetails = new MyPersonalDetails(driver);
    waitForPageLoad();
    Select oSelect = new Select(MyPersonalDetails.drpdnContactMethod);
     oSelect.selectByVisibleText(data);
  }
  
  protected void myPersonalDetails(String data) throws FileNotFoundException, InterruptedException {
    objMyPersonalDetails = new MyPersonalDetails(driver);
    searchTableColumn(MyPersonalDetails.tblMyPersonalDetails,data);
    waitForPageLoad();
  }
  
  protected void changeUsername(String data) throws FileNotFoundException, InterruptedException {
    objMyPension = new MyPension(driver);
    waitForPageLoad();
    for(int i=0;i<MyPension.txtSecQAns.size();i++) {
      setText(MyPension.txtSecQAns.get(i), data);
    }
    submitChanges();
    waitForPageLoad();
  }
  
  protected void setNewUsername(String data) throws FileNotFoundException, InterruptedException {
    objMyPension = new MyPension(driver);
    waitForPageLoad();
    setText(MyPension.txtNewUserName, data);
  }
  
  protected void setRetypedUsername(String data) throws FileNotFoundException, InterruptedException {
    objMyPension = new MyPension(driver);
    waitForPageLoad();
    setText(MyPension.txtRetypedUsername, data);
    
  }
  
}//end of class
