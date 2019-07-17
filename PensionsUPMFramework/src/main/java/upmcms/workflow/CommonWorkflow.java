package upmcms.workflow;
import static org.testng.Assert.assertEquals;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import upmcms.pages.CommonPage;
import upmcms.pages.HomePage;
import upmcms.pages.LoginPage;
import upmcms.pages.MyPension;
import upmcms.pages.MyPersonalDetails;

public class CommonWorkflow extends CommonPage{

  static HomePage objHomePage ;
  static LoginPage objloginPage;
  static MyPersonalDetails objMyPersonalDetails;
  static MyPersonalDetailsWorkflow objMyPersonalDetailsWorkflow;
  static MyPension objMyPension;
  
  protected static String securityQAndAns = null;
  protected static String randomString = null;
  protected static String randomValue = null;
  protected final String autoTest = "AutoTest";
  protected ArrayList<String> allNominatedBeneficiaries = new ArrayList<String>(); 
  
  public static boolean validateMessage(WebElement element, String msg) throws FileNotFoundException, InterruptedException {
    log("validateMessage Started");
    waitForPageLoad();
    boolean found=containsText(element, msg);
    log("validateMessage Finished");
    return found;
  }

  public static void verifyPageTitle(String actual,String expected){
    log("verifyPageTitle Started");
    assertEquals(actual, expected);
    log.info("Actual value " + actual + " matched with " + expected);
    log("verifyPageTitle Finished");
  }

  public static void selectDropdownOption(WebElement selectDrpDn, String expectedOption) {
    log("selectDropdownOption Started");
    Select select =new Select(selectDrpDn); 
    select.selectByValue(expectedOption);
    log("selectDropdownOption Finished");
  }

  public static void validateTextOnPage(String data) {
    driver.getPageSource().contains(data);
  }

  public static ArrayList<String> searchTableColumnAndClick(WebElement htmltable, int maxRow, WebElement findElement) throws InterruptedException {//,WebElement searchTable ) {
    log("searchTableColumnAndClick Started");
    List<WebElement> rows=htmltable.findElements(By.tagName("tr"));
    ArrayList<String> rowValue = new ArrayList<String>();

    for(int rnum=0;rnum<maxRow;rnum++)
    {
      List<WebElement> columns=rows.get(rnum).findElements(By.tagName("td"));
      for(int cnum=0;cnum<columns.size();cnum++)
      {
        rowValue.add(columns.get(cnum).getText());
      }

      IsExist(findElement);
      if(findElement.getText()!=null){
        log.info(KEYWORD_PASS + " Value of the field is " + findElement.getText());
        findElement.click();
      }
      else {
        log.info(KEYWORD_FAIL + " Value of the field is blank/null" );
      }
    }

    waitForPageLoad();
    log("searchTableColumnAndClick Finished");
    return rowValue;
  }

  public static void searchAndClickLink(List<WebElement> arrList, String data) throws FileNotFoundException, InterruptedException {
    objHomePage = new HomePage(driver);
    for(WebElement arrElement:arrList) {
      List <WebElement> anchors=arrElement.findElements(By.tagName("a"));
      for(WebElement anchor:anchors) {
        if(anchor.getText().trim().equalsIgnoreCase(data)) {
          log.info(KEYWORD_PASS + "clicking link " + anchor.getText());
          clickElement(anchor);
          break;
        }
      }
    }
    waitForPageLoad();
  }

  protected void searchAndClickLink(String data) throws FileNotFoundException, InterruptedException {
    objHomePage = new HomePage(driver);
    waitForPageLoad();
    searchAndClickLink(HomePage.myPsnsionsLinks,data);
  }

  protected void validateAuthentication() throws FileNotFoundException, InterruptedException {
    objloginPage = new LoginPage(driver);
    waitForPageLoad();
    validateMessage(LoginPage.lblIncorrectAuth, msgprop.getProperty("incorrectauth"));
  }

  
  protected void clickTopBanner(String data) throws FileNotFoundException, InterruptedException {
    objHomePage = new HomePage(driver);
    waitForPageLoad();
    searchAndClickLink(HomePage.lnkHomePageTopMenuLink,data);
    waitForPageLoad();
  }

  protected static void searchTableColumn(String htmltable, String dataSet)
      throws InterruptedException {
    waitForPageLoad();
    
    StringTokenizer strTk = new StringTokenizer(dataSet, ",");
    while(strTk.hasMoreTokens()) {
      String myDate = strTk.nextToken();
    List<WebElement> myTable = driver.findElements(By.xpath(htmltable));
    for (WebElement locateElement : myTable) {
      if (locateElement.getText().equals(myDate.trim())) {
        highlightElement(locateElement);
        break;
      }
    }
   }
  }

  protected void searchAndClickLinkText(String dataset, List<WebElement> elementList ) {
    StringTokenizer stk= new StringTokenizer(dataset, ",");
    while(stk.hasMoreTokens()) {
      String myToken=stk.nextToken().trim();
      for(WebElement element:elementList) {
        if(element.getText().trim().equalsIgnoreCase(myToken))
        {
          log.info(KEYWORD_PASS + " Find the element " + element.getText());
          clickElement(element);
          break;
        }
      }
    }
  }

  protected static void searchAnchorTextInTableColumn(String table, String findElement)
      throws InterruptedException, FileNotFoundException {
    WebElement htmlTable = driver.findElement(By.xpath(table));
    List<WebElement> rows = htmlTable.findElements(By.tagName("tr"));
    int size = rows.size();
    for (int rnum = 0; rnum < size; rnum++) {
      List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
      for (int cnum = 0; cnum < columns.size(); cnum++) {
        List<WebElement> anchors = rows.get(rnum).findElements(By.tagName("a"));
        for(WebElement anchor:anchors) {
          if(anchor.getText().equalsIgnoreCase(findElement)) {
            highlightElement(anchor);
            break;
          }
        }
      }
    }
  }
  
  protected static void searchAndClickAnchorTextInTableColumn(String table, String findElement)
      throws InterruptedException, FileNotFoundException {
    WebElement htmlTable = driver.findElement(By.xpath(table));
    List<WebElement> rows = htmlTable.findElements(By.tagName("tr"));
    int size = rows.size();
    boolean found = false;
    while(!found) {
    for (int rnum = 0; rnum < size; rnum++) {
      List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
      for (int cnum = 0; cnum < columns.size(); cnum++) {
        List<WebElement> anchors = rows.get(rnum).findElements(By.tagName("a"));
        for(WebElement anchor:anchors) {
          if(anchor.getText().equalsIgnoreCase(findElement)) {
            clickElement(anchor);
            waitForPageLoad();
            found=true;
            break;
          }
        }if(found)break;
      }if(found)break;
    }if(found)break;
   }
    waitForPageLoad();
  }
  
  protected void cmsSignOnOracleDB(String userName,String password, String secqns) throws FileNotFoundException, InterruptedException {
    waitForPageLoad();
    //
    //MyPersonalDetailsWorkflow.cmsSignIn(testdataprop.getProperty("signin"),testdataprop.getProperty("orausername"),testdataprop.getProperty("orapassword"),testdataprop.getProperty("oraseqans"));
    MyPersonalDetailsWorkflow.cmsSignIn(testdataprop.getProperty("signin"),userName,password,secqns);
    waitForPageLoad();
  }
  
  protected void cmsSignOnSqlServerDB(String userName,String password,String secq) throws FileNotFoundException, InterruptedException {
    waitForPageLoad();
    navigate(envprop.getProperty("sqlurl"));
    Thread.sleep(2000);
    waitForPageLoad();
    MyPersonalDetailsWorkflow.cmsSignIn(testdataprop.getProperty("signin"),userName,password,secq);
    waitForPageLoad();
  }
  
  protected void appAlert(String data) throws FileNotFoundException, InterruptedException {
    waitForPageLoad();
    List<WebElement> lblAlert = driver.findElements(By.xpath(orprop.getProperty("alert")));
    for(WebElement myAlert:lblAlert) {
      if(myAlert.isDisplayed()) {
        validateMessage(myAlert, data);
      }
     }
  }
 
  protected void submitChanges() throws FileNotFoundException, InterruptedException {
    objHomePage = new HomePage(driver);
    waitForPageLoad();
    waitforPanelElement(HomePage.btnSumit);
    clickElement(HomePage.btnSumit);
    waitForPageLoad();
  }
  
  protected void goBack() throws FileNotFoundException, InterruptedException {
    objHomePage = new HomePage(driver);
    waitForPageLoad();
    clickElement(HomePage.btnBack);
    waitForPageLoad();
  }
  
  protected void goNext() throws FileNotFoundException, InterruptedException {
    objHomePage = new HomePage(driver);
    waitForPageLoad();
    clickElement(HomePage.btnNext);
    waitForPageLoad();
  }
  
  protected void completeChanges() throws FileNotFoundException, InterruptedException {
    objHomePage = new HomePage(driver);
    waitForPageLoad();
    clickElement(HomePage.btnComplete);
    waitForPageLoad();
  }
  
  protected void confirmChanges() throws FileNotFoundException, InterruptedException {
    objHomePage = new HomePage(driver);
    waitForPageLoad();
    clickElement(HomePage.btnConfirm);
    waitForPageLoad();
  }
  
  protected void search() throws FileNotFoundException, InterruptedException {
    objHomePage = new HomePage(driver);
    clickElement(HomePage.btnSearch);
    waitForPageLoad();
  }
  
  protected static void searchTableColumn(List<WebElement> tableList,String findElement)
      throws InterruptedException, FileNotFoundException {
    objMyPersonalDetails = new MyPersonalDetails(driver);
    List<WebElement> myTable =tableList;
    int size=tableList.size();
    boolean found=false;
    while(size>0  && !found) {
    for (WebElement htmlTable : myTable) {
      List<WebElement> rows = htmlTable.findElements(By.tagName("tr"));
      int rsize = rows.size();
      for (int rnum = 0; rnum < rsize; rnum++) {
        List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
        for (int cnum = 0; cnum < columns.size(); cnum++) {
          log.info(columns.get(cnum).getText());
            if(columns.get(cnum).getText().trim().equalsIgnoreCase(findElement)) {
              highlightElement(columns.get(cnum));
              found= true;
              break;
            }
          }
        }
      } 
    }
    }
  
  public void validateCMSPersonalDetails(String table,String bannerName,String personaDetails,String personalDetailsLinks) throws FileNotFoundException, InterruptedException {
    objMyPersonalDetails = new MyPersonalDetails(driver);
    clickTopBanner(bannerName);
    StringTokenizer stk= new StringTokenizer(personaDetails, ",");
    int size=table.length();
    while(size>0 && stk.hasMoreTokens()) {
      searchTableColumn(table, stk.nextToken());
    }
    stk= new StringTokenizer(personalDetailsLinks, ",");
    while(stk.hasMoreTokens()) {
      String myToken=stk.nextToken().trim();
      for(WebElement element:MyPersonalDetails.lstPersonalLinks) {
        if(element.getText().trim().equalsIgnoreCase(myToken))
        {
          log.info(KEYWORD_PASS + " Find the element " + element.getText());
          highlightElement(element);
          break;
        }
      }
    }
    waitForPageLoad();
  }
 
  protected void searchAndClickLinkFromInThisSection(String dataset) throws Exception {
    waitForPageLoad();
    objMyPersonalDetails = new MyPersonalDetails(driver);
    searchAndClickLinkText(dataset,MyPersonalDetails.lblInThisSection);
    waitForPageLoad();
  }
  
    protected static void setPassword(String data) throws FileNotFoundException, InterruptedException {
    objloginPage = new LoginPage(driver);
    waitForPageLoad();
    waitforPanelElement(LoginPage.txtPassword);
    setText(LoginPage.txtPassword, data);
  }
    
    protected void cmsSignOut() throws InterruptedException, FileNotFoundException {
      waitForPageLoad();
      objloginPage = new LoginPage(driver);
      waitforPanelElement(LoginPage.lblLogoutDrodown);
      clickElement(LoginPage.lblLogoutDrodown);
      boolean found= IsExist(LoginPage.lblLogoutDrodownListItems);
      if(found) {
        List <WebElement> anchors=LoginPage.lblLogoutDrodownListItems.findElements(By.tagName("a"));
        for(WebElement anchor:anchors) {
          waitForPageLoad();
          if(anchor.getText().trim().equalsIgnoreCase(testdataprop.getProperty("logoff").trim())) {
            waitForPageLoad();
            log.info(KEYWORD_PASS + " Find Element " + anchor.getText());
            anchor.click();
            break;
          }
        }
      }waitForPageLoad();
    }
 
    protected void retry() throws FileNotFoundException, InterruptedException {
      objMyPersonalDetails = new MyPersonalDetails(driver);
      clickElement(MyPersonalDetails.btnRetry);
      waitForPageLoad();
    }
    
    protected void Ok() throws FileNotFoundException, InterruptedException {
      objMyPersonalDetails = new MyPersonalDetails(driver);
      Thread.sleep(3000);
      waitforPanelElement(MyPersonalDetails.btnOk);
      clickElement(MyPersonalDetails.btnOk);
      waitForPageLoad();
    }
    
    protected void searchAndClickMyPersonalDetailsLink(String dataset) throws Exception {
      waitForPageLoad();
      objMyPersonalDetails = new MyPersonalDetails(driver);
      searchAndClickLinkText(dataset,MyPersonalDetails.lstPersonalLinks);
      waitForPageLoad();
    }
    

    protected static void dateTimePicker(String date,
        List<WebElement> calDays,WebElement calDrpDnMonth, WebElement calDrpDnYear)
        throws InterruptedException, FileNotFoundException {
      waitForPageLoad();
      boolean found = false;

      String date_ent1[] = date.split("/");
      String day = date_ent1[0];
      String year = date_ent1[2];
      if (day.equals("01") || day.equals("02") || day.equals("03") || day.equals("04")
          || day.equals("05") || day.equals("06") || day.equals("07") || day.equals("08")
          || day.equals("09")) {

        day = (day.substring(1));
      }
      String month = date_ent1[1];
      if (month.equals("01") || month.equals("02") || month.equals("03") || month.equals("04")
          || month.equals("05") || month.equals("06") || month.equals("07") || month.equals("08")
          || month.equals("09")) {

        month = (month.substring(1));
      }
      found = true;
      if (found) {
        selectDropDown(calDrpDnMonth, month);
        selectDropDown(calDrpDnYear, year);
        for (WebElement dt : calDays) {
          if (dt.getText().trim().equalsIgnoreCase(day.trim())) {
            highlightElement(dt);
            clickElement(dt);
            break;
          }
        }
      }
      waitForPageLoad();
    } 

    protected void selectCalendarDate(String date) throws FileNotFoundException, InterruptedException {
      List<WebElement> days=driver.findElements(By.xpath(orprop.getProperty("day")));
      WebElement month = driver.findElement(By.xpath(orprop.getProperty("month")));
      WebElement year = driver.findElement(By.xpath(orprop.getProperty("year")));
      dateTimePicker(date,days,month,year);
    }
    
    protected void validateHelpQuestions(String qns,String helpText,String close) throws InterruptedException {
      waitForPageLoad();
      int i,j=0;
      List<WebElement> questioncircle= driver.findElements(By.xpath(qns));
      waitForPageLoad();
      StringTokenizer strTk = new StringTokenizer(msgprop.getProperty("updatemybankdetailshelpquestion"), ",");
      
      while(strTk.hasMoreTokens()) {
        boolean found = false;
        while(!found) {
        String helpContents = strTk.nextToken();
        for(i=j;i<questioncircle.size();i++) {
          j++;
          waitForPageLoad();
          questioncircle.get(i).click();
          waitForPageLoad();
          List<WebElement> helpTexts= driver.findElements(By.xpath(helpText));
          for(int k=0;k<helpTexts.size();k++) {
            log.info(helpTexts.get(k).getText().trim());
            if(helpTexts.get(k).isDisplayed() && helpTexts.get(k).getText().trim().equalsIgnoreCase(helpContents.trim())) {
              highlightElement(helpTexts.get(k));
              List<WebElement> btnClose= driver.findElements(By.xpath(close));
              log.info("size " + btnClose.size());
              for(WebElement elementClose:btnClose) {
                  found = IsExist(elementClose);
                  if(found) {
                    waitForPageLoad();
                    highlightElement(elementClose);
                    elementClose.click();
                    found =true;
                    break;
                  }
              }
            }if (found) break;
          }if (found) break;
        }if (found) break;
      } 
    }
    }
    
    public static boolean waitforPanelElement(WebElement element)
        throws InterruptedException, FileNotFoundException {
      boolean found = false;
      waitForPageLoad();
      while (!found) {
        waitForPageLoad();
        found = element.isDisplayed();
        if (found) {
          highlightElement(element);
          break;
        } else {
          found = false;
          Thread.sleep(1000);
        }
      }
      return found;
    } 
    
    public static void waitforProcessUnload()
        throws InterruptedException, FileNotFoundException {
      boolean found = false;
      //waitForPageLoad();
      
      while (!found) {
        WebElement findProcess= driver.findElement(By.xpath(orprop.getProperty("busyprocess")));
        found = IsElementDisplayed(findProcess);
        if (found) {
          Thread.sleep(3000);
          found = true;
          break;
        }else {
          //found = false;
          Thread.sleep(100);
          }
        }
      Thread.sleep(2000);
      WebElement civicaForm = driver.findElement(By.xpath(orprop.getProperty("civicaform")));
      waitforPanelElement(civicaForm);
    } 
    
      public static boolean IsElementDisplayed(WebElement element) throws InterruptedException {
        log.debug("Checking existance of element");
        boolean found = false;
          if (!element.isDisplayed()) {
            found=false;
          } else {
            log.info(KEYWORD_PASS + " Object exist ");
            highlightElement(element);
            found = true;
          }
          return found;
        } 
     
      protected void setupNewSecurityQAndAnswersForOracle(String value) throws InterruptedException, IOException{
        objMyPension = new MyPension(driver);
        waitForPageLoad();
        for(int i=0;i<MyPension.txtSecQAns.size();i++) {
          setText(MyPension.txtSecQAns.get(i), value);
        }
        submitChanges();
        String preserveValue = testdataprop.getProperty("orasetcurrentseqans");
        setpropertyvalue("orasetoldseqans",preserveValue);
        setpropertyvalue("orasetcurrentseqans",value);
        waitForPageLoad();
        completeChanges();
        waitForPageLoad();
      }
      
      protected void setupNewSecurityQAndAnswersForSqlServer(String value) throws InterruptedException, IOException{
        objMyPension = new MyPension(driver);
        waitForPageLoad();
        for(int i=0;i<MyPension.txtSecQAns.size();i++) {
          setText(MyPension.txtSecQAns.get(i), value);
        }
        submitChanges();
        String preserveValue = testdataprop.getProperty("sqlsetcurrentseqans");
        setpropertyvalue("sqlchangeoldseqans",preserveValue);
        setpropertyvalue("sqlsetcurrentseqans",value);
        waitForPageLoad();
        completeChanges();
        waitForPageLoad();
      }
    /*
     *   
      protected void setupNewPasswordForOracle(String value) throws InterruptedException, IOException{
        objMyPension = new MyPension(driver);
        waitForPageLoad();
        for(int i=0;i<MyPension.txtSecQAns.size();i++) {
          setText(MyPension.txtSecQAns.get(i), value);
        }
        submitChanges();
        setpropertyvalue("orapassword",value);
        waitForPageLoad();
        completeChanges();
        waitForPageLoad();
      }
  
     * */    
      protected void setupNewPasswordForSqlServer(String currentPassword,String newPassword,String RetypedNewPassword) throws InterruptedException, IOException{
        objMyPension = new MyPension(driver);
        waitForPageLoad();
       setText(MyPension.txCurrentPwd, currentPassword);
       setText(MyPension.txtNewPwd, newPassword);
       setText(MyPension.txtRetypedNewPwd, RetypedNewPassword);
       submitChanges();
       waitForPageLoad();
      }
      
      protected void setupWrongNewPasswordForSqlServer(String currentPassword,String newPassword,String RetypedNewPassword) throws InterruptedException, IOException{
        objMyPension = new MyPension(driver);
        waitForPageLoad();
       setText(MyPension.txCurrentPwd, currentPassword);
       setText(MyPension.txtNewPwd, newPassword);
       setText(MyPension.txtRetypedNewPwd, RetypedNewPassword);
       submitChanges();
       waitForPageLoad();
      }
      
      protected void setupNewPasswordForOracle(String currentPassword,String newPassword,String RetypedNewPassword) throws InterruptedException, IOException{
        objMyPension = new MyPension(driver);
        waitForPageLoad();
       setText(MyPension.txCurrentPwd, currentPassword);
       setText(MyPension.txtNewPwd, newPassword);
       setText(MyPension.txtRetypedNewPwd, RetypedNewPassword);
       submitChanges();
       waitForPageLoad();
      }

      protected void setupNewPasswordForSqlServer(String currentPassword,String newPassword) throws InterruptedException, IOException{
        objMyPension = new MyPension(driver);
        waitForPageLoad();
       setText(MyPension.txCurrentPwd, currentPassword);
       setText(MyPension.txtNewPwd, newPassword);
       setText(MyPension.txtRetypedNewPwd, newPassword);
       submitChanges();
       waitForPageLoad();
       String preserveNewPassword = testdataprop.getProperty("sqlsetcurrentpassword");
       setpropertyvalue("sqlchangeoldpassword",preserveNewPassword);
       setpropertyvalue("sqlsetcurrentpassword",newPassword);
      }

      protected void setupNewPasswordForOracle(String currentPassword,String newPassword) throws InterruptedException, IOException{
        objMyPension = new MyPension(driver);
        waitForPageLoad();
       setText(MyPension.txCurrentPwd, currentPassword);
       setText(MyPension.txtNewPwd, newPassword);
       setText(MyPension.txtRetypedNewPwd, newPassword);
       submitChanges();
       waitForPageLoad();
       String preserveNewPassword = testdataprop.getProperty("orasetcurrentpassword");
       setpropertyvalue("oraseteoldpassword",preserveNewPassword);
       setpropertyvalue("orasetcurrentpassword",newPassword);
       //setpropertyvalue("sqlsetcurrentpassword",newPassword);
       waitForPageLoad();
      }
      
      protected void updateUsernameForOracle(String value) throws InterruptedException, IOException{
        objMyPension = new MyPension(driver);
        waitForPageLoad();
        for(int i=0;i<MyPension.txtSecQAns.size();i++) {
          setText(MyPension.txtSecQAns.get(i), value);
        }
        submitChanges();
        String preserve = testdataprop.getProperty("orasetcurrentusername");
        setpropertyvalue("oraseteoldusername",preserve);
        setpropertyvalue("orasetcurrentusername",value);
      }
      
      protected void updateUsernameForSqlServer(String value) throws InterruptedException, IOException{
        objMyPension = new MyPension(driver);
        waitForPageLoad();
        for(int i=0;i<MyPension.txtSecQAns.size();i++) {
          setText(MyPension.txtSecQAns.get(i), value);
        }
        submitChanges();
        String preserve = testdataprop.getProperty("sqlsetcurrentusername");
        setpropertyvalue("sqloldchangeusername",preserve);
        setpropertyvalue("sqlsetcurrentusername",value);
        }

      protected void validateScreenMessage(String data) throws FileNotFoundException, InterruptedException {
        objMyPension = new MyPension(driver);
        waitForPageLoad();
        waitforPanelElement(MyPension.lblUpdateMyNominationMsg);
        validateMessage(MyPension.lblUpdateMyNominationMsg, data);
        waitForPageLoad();
      }
      
      protected void validateHeader(String table,String data) throws InterruptedException, FileNotFoundException {
        objMyPersonalDetails = new MyPersonalDetails(driver);
        WebElement element=driver.findElement(By.xpath(table));
        validateMessage(element, data);
        waitForPageLoad();
      }
  //end of class
}
