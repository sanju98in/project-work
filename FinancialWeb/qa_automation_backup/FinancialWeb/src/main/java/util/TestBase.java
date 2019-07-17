package util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * @author CIVICA Vadodara
 *
 */
public class TestBase {

  // create object for all supporting classes
  DbCon objDBConn;
  Listener listener;
  GenUtil objGenUtil;
  static String bindUrl;

  // class variables
  protected static String KEYWORD_PASS = "Pass";
  protected static String KEYWORD_FAIL = "Fail";
  static String log4jConfPath = "log4j.properties";
  public static String tempDownloadDir;
  public static String csvDownloadPath;


  protected static WebDriver dr;
  protected static EventFiringWebDriver driver;
  static WebEventListener eventListener;
  public static WebElement lastElement = null;
  public static String lastBorder = null;

  public static final String SCRIPT_GET_ELEMENT_BORDER = null;
  public static final String SCRIPT_UNHIGHLIGHT_ELEMENT = null;


  protected static File findEnvFilePath;
  static File findResourceDirPath;
  static File findErrorMessagePath;
  static File findDriversPath;
  static long waitTimeOut;

  static FileInputStream envDirPath;
  static FileInputStream envIp;
  protected static FileInputStream testIp;
  static FileInputStream preRequisitesIp;
  static FileInputStream errorIp;
  static FileInputStream OrIp;
  static FileInputStream fileUploadIp;
  static FileWriter writer;
  static FileOutputStream output;

  protected static Properties envprop;
  protected static Properties testdataprop;
  protected static Properties prerequisitesdataprop;
  protected static Properties msgprop;
  protected static Properties orprop;
  protected static Properties fileuploadprop;

  protected static String configpath = System.getProperty("user.dir");
  protected static String locale = null;
  protected static int DEFAULT_BROWSER_TIMEOUT;
  protected static WebElement webelement;
  protected static String defaultDownloadpath;

  protected static WebDriverWait wait;
  protected static List<WebElement> webelements = null;
  public static HashMap<String, Object> chromePref = new HashMap<String, Object>();

  // handler to be used in case of switching browsers

  protected static java.util.Set<String> handles;
  protected static String parentHandle;
  protected static String childHandle;

  //private static boolean preRequisiteSetupCheck=false;
  // screenshot
  TakesScreenshot ts = (TakesScreenshot) driver;

  public static Logger log = Logger.getLogger(TestBase.class.getName());

  // Reading all the file path at first
  protected static void loadEnvDataConfigurations() {

    try {
      PropertyConfigurator.configure(log4jConfPath);
      envprop = new Properties();
      String relativePath = null;
      File filePath = new File("./");
      relativePath = filePath.getCanonicalPath();

      findResourceDirPath = new File(relativePath + File.separator + "src" + File.separator + "main"
          + File.separator + "resources");
      findDriversPath = new File(relativePath + File.separator + "src" + File.separator + "main"
          + File.separator + "resources" + File.separator + "drivers");
      findEnvFilePath = new File(relativePath + File.separator + "src" + File.separator + "main"
          + File.separator + "resources" + File.separator + "testData");
      envIp = new FileInputStream(findEnvFilePath + File.separator + "env.properties");
      envprop.load(envIp);
      locale = envprop.getProperty("locale");
      String defaulttimeout = envprop.getProperty("defaulttimeout");
      DEFAULT_BROWSER_TIMEOUT = Integer.parseInt(defaulttimeout);
      waitTimeOut = 20;
      log.info("Environment data configuration settings loaded successfully");
    } catch (IOException e) {
      log.error("Error while loading environment property file" + e.getMessage());
    }
  }

  // Reading all the properties in testdata.properties file from the test data folder
  protected static void loadTestDataConfigurations() throws IOException {
    testdataprop = new Properties();
    testIp = new FileInputStream(
        findEnvFilePath + File.separator + locale + File.separator + "testdata.properties");
    testdataprop.load(testIp);
    log.info(" Test Data configuration settings loaded successfully ");
  }
  
  // Reading all the properties in prerequisitessetup.properties file from the test data folder
 protected static void loadPreRequisiteSetupConfigurations() throws IOException {
    prerequisitesdataprop = new Properties();
    preRequisitesIp = new FileInputStream(
        findEnvFilePath + File.separator  + "prerequisiteappconfigsetup.properties");
    prerequisitesdataprop.load(preRequisitesIp);
    log.info(" Pre-Requisite  Configuration Setup File loaded successfully ");
  }

  // Reading all the properties in testdata.properties file from the test data folder
  protected static void loadORProperty() throws IOException {
    orprop = new Properties();
    OrIp = new FileInputStream(findEnvFilePath + File.separator + "OR.properties");
    orprop.load(OrIp);
    log.info(" Object property configuration settings loaded successfully ");
  }

  protected static void loadMessageDataConfigurations() throws IOException {
    msgprop = new Properties();
    errorIp = new FileInputStream(
        findEnvFilePath + File.separator + locale + File.separator + "message.properties");
    msgprop.load(errorIp);
    log.info(" Message property configuration settings loaded successfully ");
  }
  protected static void externalFileUploadConfigurations() throws IOException {     
    fileuploadprop=new Properties();        
    fileUploadIp = new FileInputStream(findEnvFilePath + File.separator + "FileUpload.exe");        
    msgprop.load(errorIp);      
    log.info(" File Upload property configuration settings loaded successfully ");      
  }
  
  /**
   * Includes all possible environment e.g. qa, staging, uat, prod which can be defined in test
   * "group" so that it will be executed. Also includes all possible testing types e.g.
   * "smoke","sanity","unit","integration","regression","functional","system" which can be defined
   * in test "group" so that it will be executed
   * @throws IOException
   * @throws InterruptedException
   */
  @BeforeMethod(alwaysRun = true)
  protected static void init() throws InterruptedException, IOException {
    
    try {
      loadEnvDataConfigurations();
      loadTestDataConfigurations();
      loadMessageDataConfigurations();
      loadORProperty();
      externalFileUploadConfigurations();
      loadPreRequisiteSetupConfigurations();
      try {
        if (!envprop.getProperty("browser").equals(null)) {
          selectBrowser(envprop.getProperty("browser"));
          maximizeWindow();
        }
        if (!envprop.getProperty("url").equals(null)) {
          navigateWithWindowsAuthentication(testdataprop.getProperty("purchasingbasicusername"),
              testdataprop.getProperty("financialwebpassword"), envprop.getProperty("url"));

          log.info(" Browser Initialization finished with url " + envprop.getProperty("url"));
        }
      } catch (Exception e) {
        log.error(" Cannot load Browser details " + e.getMessage());
        return;
      }

    } catch (IOException e) {
      log.error(" Error loading environment details " + e.getMessage());
    }
      /*File appDataSetup = new File(
          findEnvFilePath + File.separator  + "prerequisitecompleted.txt");
      preRequisiteSetupCheck = appDataSetup.exists() && appDataSetup.isFile();
      if (!preRequisiteSetupCheck) {
        //PreRequisiteWorkflow.preRequisiteTestSetup();
        appDataSetup = new File(findEnvFilePath + File.separator  + "prerequisitecompleted.txt");
        appDataSetup.createNewFile();
        log.info(" Application Set up file is created!");
      }else {
        log.info("Already exists. Skipping set up file creation process! "  );
    }
*/
  }

  // Select Browser is required for selecting the browser based on the argument passed.
  // This method can be extended by adding further if conditions
  protected static void selectBrowser(String browser) throws InterruptedException {
    if (browser.equalsIgnoreCase("chrome")) {
      ChromeOptions options = new ChromeOptions();
      System.setProperty("webdriver.chrome.driver",
          findDriversPath + File.separator + "chromedriver.exe");
      tempDownloadDir = System.getProperty("java.io.tmpdir");
      chromePref.put("download.default_directory", tempDownloadDir);
      options.setExperimentalOption("prefs", chromePref);
      options.addArguments("--disable-notifications");
      log.info("Creating the object of " + browser);
      dr = new ChromeDriver(options);

    } else if (browser.equalsIgnoreCase("FF")) {
      System.setProperty("webdriver.gecko.driver",
          findDriversPath + File.separator + "geckodriver.exe");
      log.info("Creating the object of " + browser);
      dr = new FirefoxDriver();
    } else if (browser.equalsIgnoreCase("IE")) {
      System.setProperty("webdriver.ie.driver",
          findDriversPath + File.separator + "IEDriverServer.exe");
      dr = new InternetExplorerDriver();

    } else {
      throw new IllegalStateException("Unsupported browser type");
    }

    driver = new EventFiringWebDriver(dr);
    eventListener = new WebEventListener();
    driver.register(eventListener);
    waitImplicit(DEFAULT_BROWSER_TIMEOUT);
    wait = new WebDriverWait(driver, waitTimeOut);
  }

  // The URL will be used to open in the browser of driver(WebDriver)
  protected static void navigate(String url) throws InterruptedException {
    log.debug("Navigating to URL ");
    try {
      driver.navigate().to(url);

    } catch (Exception e) {
      log.error("Not able to navigate " + e.getMessage());
    }
    log.info(" Navigated to " + url);
    waitImplicit(DEFAULT_BROWSER_TIMEOUT);
  }

  // The URL will be used to open in the browser of driver(WebDriver)
  protected static void navigateWithWindowsAuthentication(String userName, String password,
      String url) throws InterruptedException {
    log.debug("Navigating to URL ");
    try {
      bindUrl = "http" + ":" + "//" + userName + ":" + password + "@" + url;
      //bindUrl = "http" + ":" + "//" + "Civica"+"\\" + "financial.product" + ":" + "password*66123" + "@" + url;
      //driver.navigate().to(bindUrl);
      driver.get(bindUrl);
    } catch (Exception e) {
      log.error("Not able to navigate " + e.getMessage());
    }
    log.info(" Navigated to " + bindUrl);
    waitImplicit(DEFAULT_BROWSER_TIMEOUT);
  }


  protected static void maximizeWindow() {
    driver.manage().window().maximize();
  }

  /**
   * This function Deletes all cookies
   * 
   */
  public void deleteAllCookies() {
    log.debug("Deleting all the Browser cookies ");
    try {
      driver.manage().deleteAllCookies();
      driver.navigate().refresh();
      log.info("Deleted all browser cookies ");
    } catch (Exception e) {
      log.error(KEYWORD_FAIL + " Unable delete all the cookies from Browser " + e.getMessage());
    }
  }

  protected void OpenNewUrl() throws IOException, InterruptedException {
    selectBrowser(envprop.getProperty("browser"));
    navigate(envprop.getProperty("childurl"));
    handles = driver.getWindowHandles();
    parentHandle = driver.getWindowHandle();
  }

  protected void OpenNewUrl(String newURL) throws IOException, InterruptedException {
    loadEnvDataConfigurations();
    selectBrowser(envprop.getProperty("browser"));
    navigate(newURL);
    handles = driver.getWindowHandles();
    parentHandle = driver.getWindowHandle();
  }

  //
  /**
   * Wait for the visibility of the element for a certain amount of time. Explicit Wait for an
   * element to become visible.
   * 
   * @param timeoutseconds : maximum time in seconds to wait for element to be visible
   * @param element : webelement to become visible
   * @return : void
   * @throws InterruptedException 
   * 
   */
  @SuppressWarnings("null")
  public static boolean waitForElementVisibility(long timeoutseconds, WebElement element) throws InterruptedException {
    boolean found = false;
    while(!found) {
    try {
      WebDriverWait wait = new WebDriverWait(driver, timeoutseconds);
      wait.until(ExpectedConditions.visibilityOf(element));
      highlightElement(element);
      found = true;
      break;
    } catch (Exception e) {
      log.error("Web element " + element.getText() + " not exist");
      found = false;
    }
    }
    Thread.sleep(2000);
    return found;
  }


  public static boolean waitForElementInVisibility(long timeoutseconds, WebElement element) {
    boolean found = false;
    while(!found) {
    try {
      WebDriverWait wait = new WebDriverWait(driver, timeoutseconds);
      wait.until(ExpectedConditions.invisibilityOf(element));
      highlightElement(element);
      found = true;
      break;
    
    } catch (Exception e) {
      log.error("Web element " + element.getText() + " not exist");
      found = false;
    }
    }
    return found;
  }

  /**
   * Wait for the element to be click able for a certain amount of time. Explicit Wait for an
   * element to become click able.
   * 
   * @param timeoutseconds : maximum time in seconds to wait for element to be visible
   * @param element : webelement to become visible
   * @return : void
   */
  @SuppressWarnings("null")
  public static boolean waitForElementClickable(long timeoutseconds, WebElement element) {
    if (element != null) {
      try {
        WebDriverWait wait = new WebDriverWait(driver, timeoutseconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return true;
      } catch (Exception e) {
        return false;
      }
    } else
      log.error("Web element not exist ");
    return false;
  }

  /**
   * Will wait for given time(in seconds) before throwing exception for any element Implicite wait
   * for a certain amount of time before throwing an exception.
   * 
   * @param timeoutInSeconds : Maximum time to wait for in seconds
   * @throws InterruptedException if InterruptedException
   */
  public static void waitImplicit(int timeoutInSeconds) throws InterruptedException {
    driver.manage().timeouts().implicitlyWait(timeoutInSeconds, TimeUnit.SECONDS);
  }

  /**
   * Switch to any pop-up window and Click on Accept/OK button.
   * 
   * @param driver : Current webdriver
   * @return Message text available on popup window. return alert message
   */
  public static void switchandAcceptPopupMessageBox(WebDriver driver) {
    
    try {
      Alert alert = driver.switchTo().alert();
      alert.accept();
    } catch (Exception e) {
      // Sometimes the text exist, but not the accept button, this means the popup wasn't displayed
      // and therefore really never existed.
    }
  }

  /**
   * Switch to any pop-up window and Click on Dismiss/Cancel button
   * 
   * @param driver : Current webdriver
   * @return Message text available on popup window.
   */
  public static String switchandCancelPopupMessageBox(WebDriver driver) {
    String message = null;
    try {
      Alert alert = driver.switchTo().alert();

      message = alert.getText();
      alert.dismiss();
    } catch (Exception e) {
      // Sometimes the text exist, but not the accept button. this means the popup wasn't displayed
      // and therefore really never existed.
      message = null;
    }
    return message;
  }


  // Logging method so that the same log is added in logger as well as syso
  /**
   * Log action in logger and console window
   * 
   * @param data : data to log(String)
   */
  public static void log(String data) {
    log.info(data);
    Reporter.log(data);
  }

  // Method retrieves all the windows open for a driver in a iterator
  /**
   * Retrieves handles for all the windows open for active driver in a iterator
   * 
   * @return Iterator : list of iterator
   */
  public static Iterator<String> getAllWindows() {
    Set<String> windows = driver.getWindowHandles();
    Iterator<String> itr = windows.iterator();
    return itr;
  }

  /**
   * Switch to other open window Sets driver to new window
   */
  public static String getHandles() {
    log.info(driver.getWindowHandle());
    // get new window handles
    for (String handle1 : driver.getWindowHandles()) {
      driver.switchTo().window(handle1);
      childHandle = handle1;
      log.info(handle1);

    }
    return childHandle;
  }



  /**
   * Close the current child window if focus is on child window
   * 
   * @throws InterruptedException if InterruptedException
   */
  public static void closeChildWindow(String childWindow) throws InterruptedException {
    driver.switchTo().window(childWindow).close();
  }

  /**
   * Switch back to parent window
   * 
   * @param parentHandle
   * @throws InterruptedException if InterruptedException
   */
  public static void switchToParentWindow(String parentHandle) throws InterruptedException {
    driver.switchTo().window(parentHandle);
    log.info(parentHandle);
  }

  /**
   * Close parent window
   * 
   * @throws InterruptedException if InterruptedException
   */
  public void closeParentWindow() throws InterruptedException {

    driver.switchTo().window(parentHandle);
    Thread.sleep(1000);
    driver.close();
  }

  /**
   * Switch to frame
   * 
   * @param panel : panel/frame to which you want to switch
   */
  public static void switchToFrame(String panel) {
    driver.switchTo().frame(panel);
  }

  /**
   * Close all the open browser instance
   */
  @AfterMethod(alwaysRun = true)
  public void quitBrowser() {
    try {
      driver.quit();
    } catch (Exception e) {
      log(" Browser  cannot be Closed ");
    }
  }

  /**
   * Close the current browser instance
   */
  public void closeBrowser() {
    try {
      driver.close();
    } catch (Exception e) {
      log("Browser  cannot be Closed ");
    }
  }

  // Common page methods
  /**
   * Accepts locator passed from OR property file in String format and returns inner text of the
   * element
   * 
   * @param locator : String locator details
   * @return String
   * 
   */
  public static String getElementText(String locator) {
    log.debug(" Get element text ");
    WebElement element;
    String text = null;
    try {
      element = findElement(locator);
      if (element != null) {
        text = element.getText();
        highlightElement(element);
        log.info(KEYWORD_PASS + " Element " + element + " text found " + text);
        return text;
      } else {
        log.info(" Cannot find the element: " + element);
      }
    } catch (Exception e) {
      log.warn(KEYWORD_FAIL + " Element not found " + e.getMessage());
    }
    return text;
  }

  /**
   * Accepts locator passed from OR property file in String format. Checks for the element. Click
   * element
   * 
   * @param locator : String locator details
   * 
   */
  public static void clickLink(String locator) {
    log.debug("Clicking on link ");

    try {
      webelement = findElement(locator);
      log.info(KEYWORD_PASS + " Clicked element " + webelement);
      driver.findElement(By.xpath(orprop.getProperty(locator))).click();
    } catch (Exception e) {
      log.error(KEYWORD_FAIL + " Not able to click on link " + e.getMessage());
    }
  }

  /**
   * Accepts locator passed from OR property file in String format. Checks the element by CSS
   * locator type and if found then clicks the link A generic method to handle click action of any
   * web element found by CSS locator type
   * 
   * @param locator : String locator details
   */
  public static void clickElementByCss(String locator) {
    log.debug("Clicking on element by CSS ");
    try {
      webelement = findElement(locator);
      log.info(KEYWORD_PASS + " Element found " + webelement);
      driver.findElement(By.cssSelector(orprop.getProperty(locator))).click();

    } catch (Exception e) {
      log.info(KEYWORD_FAIL + " Not able to click on link " + e.getMessage());
    }
  }

  /**
   * Accepts locator passed from OR property file in String format. Checks for the element and if
   * found then clicks on the element. A generic method to handle click action of any web element
   * 
   * @param locator : String locator details
   * 
   */
  public static void clickElement(String locator) {
    log.debug("Clicking on the element ");
    try {
      webelement = findElement(locator);
      log.info(KEYWORD_PASS + " Element found " + webelement);
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("arguments[0].click();", locator);
    } catch (Exception e) {
      log.info(KEYWORD_FAIL + " Not able to click on element " + e.getMessage());
    }
  }

  /**
   * Accepts locator passed from OR property file in String format. Checks the element by linkText
   * locator type and if found then clicks the link
   * 
   * @param locator : String locator details
   * 
   */
  public static void clickLinkBylinkText(String locator) {
    log.debug("Clicking on link by LinkText ");
    try {
      webelement = findElement(locator);
      log.info(KEYWORD_PASS + " Element found " + webelement);
      driver.findElement(By.linkText(orprop.getProperty(locator))).click();
    } catch (Exception e) {
      log.info(KEYWORD_FAIL + " -- Not able to click " + locator + e.getMessage());
    }
  }

  /**
   * Accepts WebElement, Waits for the page to be loaded and hover mouse over the element
   * 
   * @param element : Webelement on which action is to be performed
   * @throws InterruptedException if InterruptedException
   */

  public static void mouseHover(WebElement element) throws InterruptedException {
    log.debug("Mouse Hovering to the element ");
    long startTime = new Date().getTime();
    Object ready = ((JavascriptExecutor) driver).executeScript("return document.readyState",
        new Object[] {"0"});
    while ((ready == null) || ("loading".equalsIgnoreCase(ready.toString()))) {
      long elapsedTime = new Date().getTime() - startTime;
      if (elapsedTime > 5000) {
        log.error(KEYWORD_FAIL + "Failed to wait for document.readyState ");
        break;
      }
      Thread.sleep(200);
    }
    try {
      Actions builder = new Actions(driver);
      builder.moveToElement(element).build().perform();
      highlightElement(element);
      log.info(KEYWORD_PASS + " Hovered mouse over element ");
      waitImplicit(3);
    } catch (Exception e) {
      log.info(KEYWORD_FAIL + " Unable to mouse hover " + e.getMessage());
    }
  }

  /**
   * Accepts WebElement, Waits for the page to be loaded and hover mouse over the element
   * 
   * @param element : Webelement on which action is to be performed
   * @throws InterruptedException if InterruptedException
   */

  public static void mouseHoverAndClickElement(WebElement element) throws InterruptedException {
    log.debug("Mouse Hovering to the element ");
    long startTime = new Date().getTime();
    Object ready = ((JavascriptExecutor) driver).executeScript("return document.readyState",
        new Object[] {"0"});
    while ((ready == null) || ("loading".equalsIgnoreCase(ready.toString()))) {
      long elapsedTime = new Date().getTime() - startTime;
      if (elapsedTime > 5000) {
        log.error(KEYWORD_FAIL + "Failed to wait for document.readyState ");
        break;
      }
      Thread.sleep(200);
    }
    try {
      Actions builder = new Actions(driver);
      builder.moveToElement(element).build().perform();
      highlightElement(element);
      element.click();
      log.info(KEYWORD_PASS + " Clicked element ");
      waitImplicit(3);
    } catch (Exception e) {
      log.info(KEYWORD_FAIL + " Unable to click element " + e.getMessage());
    }
  }



  /**
   * Accepts locator passed from OR property file in String format. Selects the dropdown value by
   * index position
   * 
   * @param locator : String locator details
   * @param Index : index at which element to be selected
   * @return true : if element is selected at given index false : if element is not available at
   *         given index to select
   */
  public static boolean selectDropDrownByIndex(String locator, int Index) {
    try {

      if (locator != null) {
        WebElement DropdownElement = findElement(locator);
        Select SelectIndex = new Select(DropdownElement);
        SelectIndex.selectByIndex(Index);
        log.info(KEYWORD_PASS + " Selected DropDrown " + DropdownElement + " value By Index "
            + SelectIndex);
      }
      return false;
    } catch (Exception e) {
      log.info(" Error occured while selecting the option in the select box *" + locator + " ***"
          + e.getMessage());
      return false;
    }
  }

  /**
   * Verify if the list option has been selected. Accepts locator (list object/drop down) passed
   * from OR property file in String format. Search for the list against all the similar elements on
   * the page by tag name "option". Checks and returns, If the element matched has attribute
   * selected.
   * 
   * @param locator : String locator details
   * @param data : Data to look for in list selector
   * @return true/false
   */
  public static boolean VerifyListSelection(String locator, String data) {
    log.debug("Verifying all the list elements");
    try {
      String expectedVal = data;
      WebElement droplist = driver.findElement(By.xpath(orprop.getProperty(locator)));
      List<WebElement> droplist_cotents = droplist.findElements(By.tagName("option"));
      String actualVal = null;
      for (int i = 0; i < droplist_cotents.size(); i++) {
        String selected_status = droplist_cotents.get(i).getAttribute("selected");
        if (selected_status != null)
          actualVal = droplist_cotents.get(i).getText();
      }
      if (!actualVal.equals(expectedVal)) {
        log.info(KEYWORD_FAIL + "Value not in list - " + expectedVal);
        return false;
      }
    } catch (Exception e) {
      log.error(KEYWORD_FAIL + "Could not find list. " + e.getMessage());
      return false;
    }
    log.info(KEYWORD_PASS + "Value is in the list  ");
    return true;
  }

  /**
   * Accepts locator passed from OR property file in String format. Checks the Check box is already
   * "Checked", If not then click the check box
   * 
   * @param locator : String locator details
   */

  public static void checkCheckBox(String locator) {
    log.debug("Checking checkbox");
    try {
      // true or null
      String checked =
          driver.findElement(By.xpath(orprop.getProperty(locator))).getAttribute("checked");
      if (checked == null)// checkbox is unchecked
        webelement = findElement(locator);
      log.info(KEYWORD_PASS + "Checking checkbox " + webelement);
      driver.findElement(By.xpath(orprop.getProperty(locator))).click();
    } catch (Exception e) {
      log.error(KEYWORD_FAIL + " Could not find checkbox " + e.getMessage());
    }
  }

  /**
   * Accepts locator passed from OR property file in String format. Checks the Check box is
   * "Checked". If checked, then will un-check
   * 
   * @param locator : String locator details
   * 
   */

  public static void unCheckCheckBox(String locator) {
    log.debug("Unchecking checkBox");
    try {
      String checked =
          driver.findElement(By.xpath(orprop.getProperty(locator))).getAttribute("checked");
      if (checked != null)
        webelement = findElement(locator);
      log.info(KEYWORD_PASS + "Un Checking checkbox " + webelement);
      driver.findElement(By.xpath(orprop.getProperty(locator))).click();
    } catch (Exception e) {
      log.error(KEYWORD_FAIL + " Could not find checkbox " + e.getMessage());
    }
  }

  /**
   * Accepts locator passed from OR property file in String format. Checks the Checkbox is "Checked"
   * or not
   * 
   * @param locator : String locator details
   * @return Returns true if checked false if unchecked
   * 
   */

  public static boolean verifySelected(String locator) {
    log.debug("Verifying checkbox selected");
    try {
      String checked =
          driver.findElement(By.xpath(orprop.getProperty(locator))).getAttribute("checked");
      if (checked != null) {
        webelement = findElement(locator);
        log.info(KEYWORD_PASS + " Checkbox is selected ");
        return true;
      } else {
        log.info(KEYWORD_FAIL + " Checkbox is not selected ");
        return false;
      }
    } catch (Exception e) {
      log.error(KEYWORD_FAIL + " Cannot not find the checkbox" + e.getMessage());
      return false;
    }
  }

  /**
   * Accepts locator passed from OR property file in String format. Checks the Checkbox is "Checked"
   * or not
   * 
   * @param locator : String locator details
   * @return Returns true if checked false if unchecked
   * 
   */

  public static void verifySelected(WebElement element) {
    log.debug("Verifying checkbox selected");
    String checked = element.getAttribute("checked");
    if (checked.equalsIgnoreCase("true"))
      log.info(KEYWORD_PASS + " Option is selected ");
    else
      log.info(KEYWORD_FAIL + " Option is not selected ");
  }


  /**
   * Accepts locator passed from OR property file in String format. Accepts value in function
   * parameter which needs to be clicked. Search for all the check boxes on the page, and if matches
   * then click on the check box
   * 
   * @param Locator : String locator for set of checkboxes
   * @param Value : string value for which checkbox to be checked
   * 
   */
  public static void CheckCheckBox(String Locator, String Value) {
    try {
      List<WebElement> oCheckBox = findElements(Locator);
      int iSize = oCheckBox.size();
      for (int i = 0; i < iSize; i++) {
        // Store the checkbox name to the string variable, using 'Value' attribute
        String sValue = oCheckBox.get(i).getAttribute("value");
        if (sValue.equalsIgnoreCase(Value)) {
          log.info(" Found the checkbox ");
          oCheckBox.get(i).click();
          break;
        }
      }
    } catch (Exception e) {
      log.error(KEYWORD_FAIL + " Cannot find the checkbox " + e.getMessage());
    }
  }

  /**
   * Accepts locator passed from OR property file in String format. Sets the user input in the text
   * box
   * 
   * @param locator : String locator details
   * @param text : text to be set
   */
  public static void setText(String locator, String text) {
    log.debug("Writing in text box");

    try {
      webelement = findElement(locator);
      driver.findElement(By.xpath(orprop.getProperty(locator))).sendKeys(text);
      log.info(KEYWORD_PASS + " Text written in the text box ");

    } catch (Exception e) {
      log.error(KEYWORD_FAIL + " Unable to write in the text box " + e.getMessage());
    }
  }

  /**
   * Accepts locator passed from OR property file in String format. Sets the user input in the text
   * box for locator type CSSSelector
   * 
   * @param locator: String locator details
   * @param text : text to be set
   * 
   */
  public static void setTextCSS(String locator, String text) {
    log.debug(" Writing in text box ");

    try {
      webelement = findElement(locator);
      driver.findElement(By.cssSelector(orprop.getProperty(locator))).sendKeys(text);
      log.info(KEYWORD_PASS + " Text written in the text box ");
    } catch (Exception e) {
      log.error(KEYWORD_FAIL + " Unable to write " + e.getMessage());
    }
  }

  /**
   * Accepts locator passed from OR property file in String format. Check, compare text and return
   * true/false based on user input. Also, logs the matched input.
   * 
   * @param locator : String locator details
   * @param text : text to be verified
   * @return : Returns true if value matches else returns false
   * 
   */
  public static boolean verifyText(String locator, String text) {
    log.debug("Verifying the text in input box");
    try {
      String actual =
          driver.findElement(By.xpath(orprop.getProperty(locator))).getAttribute("value");
      String expected = text;

      if (actual.equals(expected)) {
        log.info(KEYWORD_PASS + " Text " + expected + " matches in the input box with " + actual);
        return true;
      } else {
        log.info(KEYWORD_FAIL + " Text " + expected + " does not matches in the input box with "
            + actual);
        return false;
      }
    } catch (Exception e) {
      log.error(KEYWORD_FAIL + " Unable to find input box " + e.getMessage());
      return false;
    }
  }

  /**
   * Accepts locator passed from OR property file in String format. Check, compare text and return
   * true/false based on user input. Also, logs the matched input.
   * 
   * @param locator : String locator details
   * @param text : text to be verified
   * @return : Returns true if value matches else returns false
   * 
   */
  public static boolean verifyTextAttribute(WebElement element,String text){
    log.debug("Verifying the value attribute in input box");
    try{
        String actual = element.getAttribute("value").trim();
        String expected=text.trim();

        if(actual.equals(expected)){
          highlightElement(element);
            log.info(KEYWORD_PASS+" Text " + expected + " matches in the input box with " + actual);
            return true;
        }else{
            log.info(KEYWORD_FAIL+" Text " + expected + " does not matches in the input box with " + actual);
            return false;
        }
    }catch(Exception e){
        log.error(KEYWORD_FAIL+ " Unable to find input box "+e.getMessage());
        return false;
    }
}

  /**
   * Accepts locator passed from OR property file in String format. Check and return true/false, if
   * the element exists on the page
   * 
   * @param locator : String locator details
   * @return : Returns true if element exists else returns false
   */
  public static boolean isExist(String locator) {
    log.debug("Checking existance of element");
    try {
      driver.findElement(By.xpath(orprop.getProperty(locator)));
      webelement = findElement(locator);
      log.info(KEYWORD_PASS + " Element exists ");
      return true;
    } catch (Exception e) {
      log.error(KEYWORD_FAIL + " Object doest not exist " + e.getMessage());
      return false;
    }
  }

  /**
   * Accepts locator passed from OR property file in String format. find the element and clicks on
   * it.
   * 
   * @param locator : String locator details
   * 
   */
  public static void click(String locator) {
    log.debug("Clicking on any element");
    try {
      webelement = findElement(locator);
      driver.findElement(By.xpath(orprop.getProperty(locator))).click();
      log.info(KEYWORD_PASS + " Clicked element ");
    } catch (Exception e) {
      log.error(KEYWORD_FAIL + " Not able to click " + e.getMessage());
    }

  }

  // For PageFactory
  /**
   * Accepts WebElement and highlights the element on window.
   * 
   * @param element : webelement to highlight
   * 
   */
  //Creating a custom function to highlight the screen element
  public static void highlightElement(WebElement element) throws InterruptedException{

    scrollToView(element);
    for (int i = 0; i <1;i++) {
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
      Thread.sleep(500);
      js.executeScript("arguments[0].setAttribute('style', arguments[1]);",element, "");
    }
    //JavascriptExecutor js = (JavascriptExecutor) driver;
    //js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
  }
  // Creating a custom function to highlight the screen element
//  public static void highlightElement(WebElement element) {
//
//    JavascriptExecutor js = (JavascriptExecutor) driver;
//    js.executeScript(
//        "arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
//        element);
//    // remember the new element
//    // lastElement = element;
//    // lastBorder = (String)(js.executeScript(SCRIPT_GET_ELEMENT_BORDER, element));
//    // unhighlightLast();
//  }

  public static void unhighlightLast() {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    if (lastElement != null) {
      try {
        // if there already is a highlighted element, unhighlight it
        js.executeScript(SCRIPT_UNHIGHLIGHT_ELEMENT, lastElement, lastBorder);
      } catch (StaleElementReferenceException ignored) {
        // the page got reloaded, the element isn't there
      } finally {
        // element either restored or wasn't valid, nullify in both cases
        lastElement = null;
      }
    }
  }

  /**
   * Accepts web element. If element found, highlight the element on window and click using click
   * event. Uses click method to click the element
   * 
   * @param element : webelement to click
   * 
   */
  public static void clickObject(WebElement element) {
    log.debug("Clicking on web element ");
    try {
      highlightElement(element);
      log.info(KEYWORD_PASS + " Clicked element ");
      element.click();
    } catch (Exception e) {
      log.error(KEYWORD_FAIL + " Not able to click on link " + e.getMessage());
    }
  }

  /**
   * Accepts web element. If element found, highlight and clicks the element using javascript. Uses
   * JavascriptExecutor to click the element
   * 
   * @param element : webelement to click
   * @throws InterruptedException if InterruptedException
   * 
   */
  public static void clickElement(WebElement element) throws InterruptedException {
    log.debug("Clicking on Button");
    waitImplicit(10);
    try {
      reAuthenticationPopup();
      waitforPanelLoad();
      scrollToView(element);
      highlightElement(element);
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("arguments[0].click();", element);
      log.info(KEYWORD_PASS + " clicked on the button ");
    } catch (Exception e) {
      log.error(KEYWORD_FAIL + " Not able to click on Button " + e.getMessage());
    }
  }

  /**
   * Accepts web element and list item to be selected. Checks, if the list item is sent in the
   * parameter then clicks the item from the list. If list item is not sent then select any random
   * value from the list.
   * 
   * @param element : webelement of list
   * @param data : data to be selected from list(string)
   * 
   * 
   */
  public static void selectList(WebElement element, String data) {
    log.debug("Selecting from list ");
    try {
      if (!(data == null)) {
        element.sendKeys(data);
        highlightElement(element);
        log.info(KEYWORD_PASS + " Selected value from the list " + data);
      } else {
        // logic to find a random value in list
        WebElement droplist = element;
        List<WebElement> droplist_cotents = droplist.findElements(By.tagName("option"));
        Random num = new Random();
        int index = num.nextInt(droplist_cotents.size());
        String selectedVal = droplist_cotents.get(index).getText();
        element.sendKeys(selectedVal);
        highlightElement(element);
        log.info(KEYWORD_PASS + " Selected random value from the list. ");

      }
    } catch (Exception e) {
      log.error(KEYWORD_FAIL + " Could not select list item. " + e.getMessage());
    }
  }

  /**
   * Accepts web element and data to be selected from the list. Verify and return element if data
   * present in the list
   * 
   * @param element : webelement of list
   * @param data : data to be searched in list
   * @return returns true if data is found in list else returns false
   * 
   */
  public static boolean verifyListSelection(WebElement element, String data) {
    log.debug("Verifying all the list elements");
    try {
      String expectedVal = data;
      WebElement droplist = element;
      List<WebElement> droplist_cotents = droplist.findElements(By.tagName("option"));
      String actualVal = null;
      for (int i = 0; i < droplist_cotents.size(); i++) {
        String selected_status = droplist_cotents.get(i).getAttribute("selected");
        if (selected_status != null)
          actualVal = droplist_cotents.get(i).getText();
        highlightElement(droplist_cotents.get(i));
      }
      if (!actualVal.equals(expectedVal)) {
        log.info(KEYWORD_FAIL + "Value not in list - " + expectedVal);
        return false;
      } else {
        highlightElement(element);
        log.info(KEYWORD_PASS + " Value found in list - " + expectedVal);
        return true;
      }
    } catch (Exception e) {
      log.error(KEYWORD_FAIL + " Could not find list. " + e.getMessage());
      return false;
    }
  }

  /**
   * Accepts web element. Checks if the check box is already selected. If not then check(click) the
   * check box
   * 
   * @param element : webelement of checkbox to check
   * 
   */
  public static void checkCheckBox(WebElement element) {
    log.debug("Checking checkbox");
    try {
      // true or null
      String checked = element.getAttribute("checked");
      if (checked == null) {// checkbox is unchecked
        highlightElement(element);
        element.click();
        log.info(KEYWORD_PASS + " clicked checkbox ");
      }
    } catch (Exception e) {
      log.error(KEYWORD_FAIL + " Could not find checkbox " + e.getMessage());
    }
  }

  /**
   * Accepts web element. Checks if the check box is already selected. If yes then un-check(click)
   * the check box
   * 
   * @param element : webelement of checkbox
   * 
   */

  public static void unCheckCheckBox(WebElement element) {
    log.debug("Unchecking checkBox");
    try {
      String checked = element.getAttribute("checked");
      if (checked != null) {// check box is checked
        element.click();
        highlightElement(element);
        log.info(KEYWORD_PASS + " unchecked checkbox ");
      }
    } catch (Exception e) {
      log.error(KEYWORD_FAIL + " Could not find checkbox ");
    }
  }

  /**
   * Accepts web element. Verify the check box is selected
   * 
   * @param element : webelement of checkbox to see if is selected
   * @return Returns true if element is selected else returns false.
   */

  public static boolean IsCheckBoxSelected(WebElement element) {
    log.debug("Verifying checkbox selected");
    try {
      String checked = element.getAttribute("checked");
      highlightElement(element);
      if (checked != null) {
        log.info(KEYWORD_PASS + " checkbox is selected ");
        return true;
      } else {
        log.info(KEYWORD_FAIL + " checkbox is not selected ");
        return false;
      }
    } catch (Exception e) {
      log.error(KEYWORD_FAIL + " Could not find checkbox ");
      return false;
    }
  }

  /**
   * Accepts web element and text to be searched Verify and compare the element text. Return matches
   * (true or false )
   * 
   * @param element : webelement to verify text
   * @param data : text to be verified
   * @return returns true if text matches else returns false
   * 
   */
  public static boolean verifyText(WebElement element, String data) {
    log.debug("Verifying the text");
    try {
      String actual = element.getText();
      highlightElement(element);
      String expected = data;
      if (actual.trim().equals(expected)) {
        log.info(KEYWORD_PASS + " Verified the text " + " Actual text is " + actual + " and "
            + " Expected text is " + expected);
        return true;
      } else {
        log.info(KEYWORD_FAIL + " Cannot verify the text " + "Actual text is " + actual + " and "
            + " Expected text is " + expected);
        return false;
      }
    } catch (Exception e) {
      log.error(KEYWORD_FAIL + " Object not found " + e.getMessage());
      return false;
    }
  }

  /**
   * Accepts web element and data to be set in the input/text box. Highlight the text box if found
   * and sets the data in the input box.
   * 
   * @param element : webelement to set text
   * @param data : text to be set in textbox
   */
  public static void setText(WebElement element, String data) {
    log.debug("Writing in text box");
    
    try {
      reAuthenticationPopup();
        waitforPanelLoad();
       scrollToView(element);
      highlightElement(element);
      element.clear();
      element.sendKeys(data.trim());
      element.sendKeys(Keys.TAB);
      log.info(KEYWORD_PASS + " Data is written in the text box " + data);
    } catch (Exception e) {
      log.error(KEYWORD_FAIL + " Unable to write in the text box " + e.getMessage());
    }
  }

  /**
   * Accepts web element. Check the visibility of the element on screen and return true/false
   * 
   * @param element : webelement to see if element exists
   * @return : Returns true if element found else returns false
   * 
   */
  public static boolean IsExist(WebElement element) {
    log.debug("Checking existance of element");
    try {
      if (!element.isDisplayed()) {
        highlightElement(element);
        log.info(KEYWORD_FAIL + " Object does not exist ");
        return false;
      } else {
        log.info(KEYWORD_PASS + " Object exist ");
        highlightElement(element);
        return true;
      }
    } catch (Exception e) {
      log.error(KEYWORD_FAIL + " Object doest not exist ");
      return false;
    }
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
    

  /**
   * Accepts web element. Highlight the element on the screen. click the element.
   * 
   * @param element : webelement to click on
   * 
   */
  public static void click(WebElement element) {
    log.debug("Clicking on any element");
    try {
      highlightElement(element);
      element.click();
      log.info(KEYWORD_PASS + " Element clicked ");
    } catch (Exception e) {
      log.error(KEYWORD_FAIL + " Not able to click " + e.getMessage());
    }
  }

  /**
   * Accepts locator from OR property file in String format. Search for the element on the screen
   * based on the type of locator by id/name/xpath/linkText/class. Returns matching web element(s).
   * 
   * @param locator : locator for element
   * @return list of web element(s) matching given locator
   */
  public static List<WebElement> findElements(String locator) {

    if (locator != null) {
      String[] arrLocator = locator.split("==");
      String locatorTag = arrLocator[0].trim();
      String objectLocator = arrLocator[1].trim();

      if (locatorTag.equalsIgnoreCase("id")) {
        webelements = driver.findElements(By.id(objectLocator));
      } else if (locatorTag.equalsIgnoreCase("name")) {
        webelements = driver.findElements(By.name(objectLocator));
      } else if (locatorTag.equalsIgnoreCase("xpath")) {
        webelements = driver.findElements(By.xpath(objectLocator));
      } else if (locatorTag.equalsIgnoreCase("linkText")) {
        webelements = driver.findElements(By.linkText(objectLocator));
      } else if (locatorTag.equalsIgnoreCase("class")) {
        webelements = driver.findElements(By.className(objectLocator));
      } else {
        log.error(KEYWORD_FAIL + " Please Check the Locator Syntax Given :" + locator);
        return null;
      }
    }
    return webelements;
  }

  /**
   * Accepts locator from OR property file in String format. search for the element in all the
   * matching web elements on the screen. Returns true/false
   * 
   * @param locator : string for element locator
   * @return : Returns true if element is present else returns false
   */
  public static boolean isElementPresent(String locator) {
    List<WebElement> arrElements = null;
    arrElements = findElements(locator);
    if (arrElements.size() > 0 && arrElements != null) {
      log.info(KEYWORD_PASS + " Element found ");
      return true;
    } else
      log.info(KEYWORD_FAIL + " Element not found ");
    return false;
  }

  /**
   * Accepts web element. double clicks on the element.
   * 
   * @param element : element to double click on
   * 
   */
  public static void doubleClick(WebElement element) {
    try {
      if ((driver != null) && (element != null)) {
        highlightElement(element);
        (new Actions(driver)).doubleClick(element).build().perform();
        log.info(KEYWORD_PASS + " Double clicked element ");
      }
    } catch (Exception e) {
      log.error(KEYWORD_FAIL + " Unable to click " + e.getMessage());
    }

  }

  /**
   * Accepts driver and web element. highlight the element on the screen using javascript.
   * 
   * @param driver : currently active webdriver
   * @param element : element to be highlighted
   * 
   */
  public static void highlightElement(WebDriver driver, WebElement element) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
        "border: 2px solid DeepPink;");
  }

  /**
   * Accepts locator from OR property file in String format. Find for the element based on locator
   * type (id, name, xpath, linktext, css and class). returns web element.
   * 
   * @param locator : string locator for element to search for
   * @return WebElement
   */
  public static WebElement findElement(String locator) {
    if (locator != null) {
      String[] arrLocator = locator.split("==");
      String locatorTag = arrLocator[0].trim();
      String objectLocator = arrLocator[1].trim();
      try {
        if (locatorTag.equalsIgnoreCase("id")) {
          webelement = driver.findElement(By.id(objectLocator));
          highlightElement(webelement);
        } else if (locatorTag.equalsIgnoreCase("name")) {
          webelement = driver.findElement(By.name(objectLocator));
          highlightElement(webelement);
        } else if (locatorTag.equalsIgnoreCase("xpath")) {
          webelement = driver.findElement(By.xpath(objectLocator));
          highlightElement(webelement);
        } else if (locatorTag.equalsIgnoreCase("linkText")) {
          webelement = driver.findElement(By.linkText(objectLocator));
          highlightElement(webelement);
        } else if (locatorTag.equalsIgnoreCase("class")) {
          webelement = driver.findElement(By.className(objectLocator));
          highlightElement(webelement);
        } else if (locatorTag.equalsIgnoreCase("css")) {
          webelement = driver.findElement(By.cssSelector(objectLocator));
          highlightElement(webelement);
        } else {
          String error = "Please Check the Given Locator Syntax : " + locator;
          error = error.replaceAll("'", "\"");
          return null;
        }
      } catch (Exception exception) {
        String error = "Please Check the Given Locator Syntax : " + locator;
        error = error.replaceAll("'", "\"");
        log.error(KEYWORD_FAIL + exception + exception.getMessage());
        return null;
      }
    }
    return webelement;
  }

  /**
   * Performs keyboard action keys Shift+Tab
   * 
   * @throws AWTException if AWTException
   */
  public static void PressShiftTab() throws AWTException {
    Robot robot = new Robot();
    robot.delay(3000);
    robot.keyPress(KeyEvent.VK_SHIFT);
    robot.keyPress(KeyEvent.VK_TAB);
    robot.keyRelease(KeyEvent.VK_TAB);
    robot.keyRelease(KeyEvent.VK_SHIFT);
  }

  /**
   * Performs keyboard action key TAB
   * 
   * @throws AWTException if WETException
   * 
   */
  public static void PressTab() throws AWTException {
    Robot robot = new Robot();
    robot.delay(3000);

    robot.keyPress(KeyEvent.VK_TAB);
    robot.keyRelease(KeyEvent.VK_TAB);
  }

  /**
   * Accepts attribute name and locator from OR property file in String format. Search for the web
   * element. Check the attribute Name. Return attribute Value if found
   * 
   * @param locator : string locator for element
   * @param attributeName : attribute to look for
   * @return : string value of attribute for searched element
   */
  public static String getAttribute(String locator, String attributeName) {
    String attributeValue = null;
    try {

      WebElement element = findElement(locator);
      if (element != null) {
        attributeValue = element.getAttribute(attributeName);
        log.info(KEYWORD_PASS + " Element attribute is present ");
        return attributeValue;
      } else {
        log.info(KEYWORD_FAIL + " Element attribute is present ");
      }
      element = null;
    } catch (Exception e) {
      log.error(KEYWORD_FAIL + " Cannot find the element " + e.getMessage());
    }
    return attributeValue;
  }

  /**
   * Accepts web element(drop down) and value to be selected. Check the drop down exists. Highlight
   * the drop down. Select the drop down value. Press Keyboard key TAB
   * 
   * @param object : webelement to selectdropdown from
   * @param value : value to select from in dropdown
   * 
   */
  public static void selectDropDownValue(WebElement object, String value) {
    try {
      WebElement element = object;

      if (element != null) {
        Select selectBox = new Select(element);

        highlightElement(element);
        element.click();
        selectBox.selectByValue(value);
        //element.sendKeys(Keys.TAB);
        element.click();

        log.info(KEYWORD_PASS + " Dropdown value selected ");
      }
    } catch (Exception e) {
      log.error(KEYWORD_FAIL + " Cannot select the dropdown " + e.getMessage());
    }
  }

  // newly added method
  public static void selectDropDown(WebElement element, String fieldValue)
      throws InterruptedException {
    Select dropDown = new Select(element);
    int index = 0;
    for (WebElement option : dropDown.getOptions()) {
      
      if (option.getText().trim().equalsIgnoreCase(fieldValue.trim())) {
        log.info(option.getText().trim());
        break;
      }
      index++;
    }
    dropDown.selectByIndex(index);
    highlightElement(element);
    Thread.sleep(1000);
  }

  /**
   * Accepts web element list. Accepts data on which the element be searched. Matches the data with
   * web elements. Highlights the matched element on screen. Returns web element.
   * 
   * @param elements : WebElement list to search text in
   * @param data : text to search for
   * @return : webelement whose text is set as data searched for
   * 
   */
  public static WebElement findElementByText(List<WebElement> elements, String data) {
    WebElement result = null;
    try {
      for (WebElement element : elements) {
        element.getText().trim();
        if (data.equalsIgnoreCase(element.getText().trim())) {
          result = element;
          highlightElement(result);
          log.info(KEYWORD_PASS + " Text find on the page ");
          break;
        } else {
          log.info(KEYWORD_FAIL + " Cannot find the given text on the page ");
        }
      }
    } catch (Exception e) {
      log.error(KEYWORD_FAIL + " Cannot find the element " + e.getMessage());
    }
    return result;
  }

  /**
   * Accepts web elements. Perform mouse drag-n-drop action on the element.
   * 
   * @param source : source webelement to drag from
   * @param target : target webelement to drag into
   * @return WebElement: Target webelement
   * 
   */
  public static WebElement dragAnddrop(WebElement source, WebElement target) {
    try {
      (new Actions(driver)).dragAndDrop(source, target).perform();
      highlightElement(target);
      log.info(KEYWORD_PASS + " Drag and Drop action is performed ");
    } catch (Exception e) {
      log.error(KEYWORD_FAIL + " cannot perform drag and drop " + e.getMessage());
    }
    return target;
  }

  /**
   * Accepts web element and data to be searched. Checks for the element. Check element contains
   * data. Return true/false
   * 
   * @param element : webelement to check for text
   * @param data : text to search for
   * @return : Returns true if element found else returns false
   * @throws InterruptedException
   */
  public static boolean containsText(WebElement element, String data) throws InterruptedException {
    waitForPageLoad();
    boolean matches = false;
    try {
      // First check that the element is displayed, for those elements that only display if you've
      // done the right prior steps
      // and check what's in the element and compare it to the text
      if (element.isDisplayed()) {
        //log.info(element.getText().trim());
        matches = element.getText().trim().contains(data);
        if (matches) {
          highlightElement(element);
          //log.info(element.getText().trim());
          log.info(KEYWORD_PASS + " Find the text " + data + " in given string " + matches);

        } else {
          log.info(KEYWORD_FAIL + " Cannot find the text " + data + " in given string " + matches);
        }
      } else {
        log.info(" Given Element is not displayed ");
      }
    } catch (Exception e) {
      log.error(KEYWORD_FAIL + " Element does not exist " + e.getMessage());
    }
    return matches;
  }


  /**
   * Set value for given key in property file(testdata.property) in current locale. If the key does
   * not exists a new key/value will be added.
   * 
   * @param key : Key for the given property to set
   * @param value : Value you want to set for given key
   * @throws IOException if IO Exception
   */

  public static void setpropertyvalue(String key, String value) throws IOException {

    testdataprop = new Properties();
    String file_path = findEnvFilePath + File.separator + locale;
    testIp = new FileInputStream(file_path + File.separator + "testdata.properties");
    testdataprop.load(testIp);
    String KeyExist = testdataprop.getProperty(key);
    writer = new FileWriter(file_path + File.separator + "testdata.properties", true);
    if (KeyExist != null) {
      log.info("Key already exist: " + testdataprop.getProperty(key));
      testdataprop.put(key, value);
      output = new FileOutputStream(file_path + File.separator + "testdata.properties");
      testdataprop.store(output, "Runtime key value");
      log.info("Updated existing key value: " + testdataprop.getProperty(key));
    } else {
      log.info("New Key and value added : " + testdataprop.getProperty(key));
      testdataprop.setProperty(key, value);
      output = new FileOutputStream(file_path + File.separator + "testdata.properties");
      testdataprop.store(output, " Added new runtime keyvalue pair ");
      log.info("Added New Key value pair: " + testdataprop.getProperty(key));
    }
    writer.close();
  }

  /**
   * Accepts web element and data to be searched. Checks for the element. Check element text Starts
   * with data. Return true/false
   * 
   * @param element : web element to search
   * @param data : Part of text to search for
   * @return : returns true if element starts with search text else returns false
   * 
   */
  public static boolean startsWithText(WebElement element, String data) {
    boolean matches = false;
    try {
      // First check that the element is displayed, for those elements that only display if you've
      // done the right prior steps
      // and check what's in the element and compare it to the text
      if (element.isDisplayed()) {
        matches = element.getText().startsWith(data);
        if (matches) {
          log.info(
              " Find the text " + data + " at starting position in the given string " + matches);
        } else {
          log.info(" Cannot find the text " + data + " at starting position in the given string "
              + matches);
        }
      } else {
        log.info(" Given Element is not displayed ");;
      }
    } catch (Exception e) {
      log.error(KEYWORD_FAIL + " Element does not exist " + e.getMessage());
    }
    return matches;
  }

  /**
   * Accepts web element and data to be compared. Checks for the element. Check element text value
   * equals to data.
   * 
   * @param element : webelement to search text for
   * @param data : text to search for
   * @param isCaseSensitve : boolean value true if search has to be case sensitive else false
   * @return
   * 
   *         true/false
   */
  public boolean equalsText(WebElement element, String data, boolean isCaseSensitve) {
    boolean matches = false;
    try {
      if (element.isDisplayed()) {
        if (isCaseSensitve) {
          matches = element.getText().equals(data);
        } else {
          matches = element.getText().equalsIgnoreCase(data);
        }
        if (matches) {
          log.info(" Given text " + data + " eauals to " + matches);
        } else {
          log.info(" Given text " + data + " is not eauals to " + matches);
        }

      } else {
        log.info(" Given Element is not displayed");
      }
    } catch (Exception e) {
      log.error(KEYWORD_FAIL + " Element does not exist" + e.getMessage());
    }
    return matches;
  }

  public static void waitForPageLoad() throws InterruptedException {
    Thread.sleep(500);
    JavascriptExecutor js = (JavascriptExecutor) driver;


    // Initially bellow given if condition will check ready state of page.
    if (js.executeScript("return document.readyState").toString().equals("complete")) {
      return;
    }

    // This loop will rotate for 50 times to check If page Is ready after every 1 second.
    // You can replace your value with 50 If you wants to Increase or decrease wait time.
    for (int i = 0; i < 100; i++) {
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        System.out.println("Interrupted!" + e);

      }
      // To check page ready state.
      if (js.executeScript("return document.readyState").toString().equals("complete")) {
        break;
      }
    }
  }

  public static WebElement locatorParser(String locator) {

    By loc = By.id(locator);

    if (locator.contains("id"))
      loc = By.id(locator.substring(locator.indexOf("\"") + 1, locator.length() - 2));

    else if (locator.contains("name"))
      loc = By.name(locator.substring(locator.indexOf("\"") + 1, locator.length() - 2));

    if (locator.contains("xpath"))
      loc = By.xpath(locator.substring(locator.indexOf("\"") + 1, locator.length() - 2));

    return (WebElement) loc;
  }

  public static String getRandomEmail() {
    String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    StringBuilder salt = new StringBuilder();
    Random rnd = new Random();
    while (salt.length() < 10) { // length of the random string.
      int index = (int) (rnd.nextFloat() * SALTCHARS.length());
      salt.append(SALTCHARS.charAt(index));
    }
    String saltStr = salt.toString();
    return saltStr + "@automationtest.co";

  }

  public static String getRandomNumber(String convert) {
    Random random = new Random();
    int randomNumber = 0;
    int limit = Integer.parseInt(convert);
    boolean loop = true;
    while (loop) {
      randomNumber = random.nextInt();
      if (Integer.toString(randomNumber).length() == limit
          && !Integer.toString(randomNumber).startsWith("-")) {
        loop = false;
      }
    }
    return Long.toString(randomNumber);
  }

  public static void scrollToView(WebElement element) {
    {
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("arguments[0].scrollIntoView();", element);
    }

  }

  /**
   * Returns string which is actually a report path where the actual csv file will be stored. This
   * method always return a string which is actually folder path.
   * <p>
   * 
   * @return String
   * 
   */
  public static String createFloder() {
    String filepath;

    // Fetching current date
    DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
    String requiredDate = df.format(new Date()).toString();

    filepath = System.getProperty("java.io.tmpdir") + File.separator + requiredDate;
    File file = new File(filepath);
    if (!file.exists()) {
      if (file.mkdir()) {
        System.out.println("Directory is created!");
      } else {
        System.out.println("Failed to create directory!");
      }
    } else {
      System.out.println("Directory Exists");
    }
    return filepath;
  }

  public static String uploadFile(String externalFile) throws IOException, InterruptedException, URISyntaxException {
    Thread.sleep(1000);
    String fileName =
        findEnvFilePath.toString() + File.separator + externalFile;
    Runtime.getRuntime().exec(findEnvFilePath + File.separator + "FileUpload.exe"+" "+ fileName);
    Thread.sleep(2000);
    return fileName;
  }

  public static String ltrim(String str) {
    int i = 0;
    while (i < str.length() && Character.isWhitespace(str.charAt(i))) {
      System.out.println("Char At(i)  " + str.charAt(i));
      i++;
    }
    return str.substring(i);
  }

  public static void clickHrefLink(String data) throws FileNotFoundException, InterruptedException {
    List<WebElement> anchors = driver.findElements(By.tagName("a"));
    for (WebElement anchor : anchors) {
      log.info(anchor.getText());
      if (anchor.getText().equalsIgnoreCase(data)) {
        log.info("Test Pass: Link option is visible for the logged in user " + anchor.getText());
        scrollToView(anchor);
        clickElement(anchor);
        Thread.sleep(2000);
        break;
      }
    }
  }

  public static String findMatchingNumberInString(WebElement element, String text) throws InterruptedException {
    String actual = element.getText();
    log.info(element.getText());
    String expected = text.trim();

    actual = extractNumber(actual);
    System.out.println();
    log.info(actual);
    if (actual.equals(expected)) {
      highlightElement(element);
    }
    return actual;
  }

  public static String extractNumber(final String str) {
    if (str == null || str.isEmpty())
      return "";
    StringBuilder sb = new StringBuilder();
    boolean found = false;
    for (char c : str.toCharArray()) {
      if (Character.isDigit(c)) {
        sb.append(c);
        log.info(sb);
        found = true;
      } else if (found) {
        // If we already found a digit before and this char is not a digit, stop looping
        break;
      }
    }
    return sb.toString();
  }

  public static String getRandomString() {
    String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    StringBuilder salt = new StringBuilder();
    Random rnd = new Random();
      while (salt.length() < 10) { // length of the random string.
          int index = (int) (rnd.nextFloat() * SALTCHARS.length());
          salt.append(SALTCHARS.charAt(index));
     }
       String saltStr = salt.toString();
       return saltStr;
   } 

  public static String getRandomAlphaNumericValue(String limit) {
    String charlist = 
        "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      StringBuffer randStr = new StringBuffer();
      for(int i=0; i<Integer.parseInt(limit); i++){
          int number = getrndNumber(charlist);
          char ch = charlist.charAt(number);
          randStr.append(ch);
      }
      log.info(randStr.toString());
      return randStr.toString();
    } 
  private static int getrndNumber(String charlist) {
    int randomInt = 0;
    Random randomGenerator = new Random();
    randomInt = randomGenerator.nextInt(charlist.length());
    if (randomInt - 1 == -1) {
        return randomInt;
    } else {
        return randomInt - 1;
    }
}
  public static void waitforPanelLoad() throws InterruptedException, FileNotFoundException {
    waitForElementDisappear();
    boolean found = false;
    while (!found) {
     // WebElement findPanel = driver.findElement(By.xpath(orprop.getProperty("panelload")));
      WebElement uniquePanel = driver.findElement(By.xpath(orprop.getProperty("uniquepanelload")));
      //WebElement authentcatePanel = driver.findElement(By.xpath(orprop.getProperty("uniquepanelload")));
      
      //boolean isPanelEnabled = findPanel.isDisplayed();
      boolean isUniquePanelEnabled = uniquePanel.isDisplayed();
      //boolean isAuthPanelEnabled = authentcatePanel.isDisplayed();
      
     // isPanelEnabled = IsElementDisplayed(findPanel);
      isUniquePanelEnabled = IsElementDisplayed(uniquePanel);
      //isAuthPanelEnabled = IsElementDisplayed(authentcatePanel);
      if (isUniquePanelEnabled) {
        found = true;
        break;
      } else if (!isUniquePanelEnabled) {
        WebElement reAuth = driver.findElement(By.xpath(orprop.getProperty("authpanelload")));
        found = IsElementDisplayed(reAuth);
        if(found) {
          log.info("*******************Hurrey***************");
        callEvent(orprop.getProperty("button"), testdataprop.getProperty("continue"));
        break;
        }
      }
      else {
        found = false;
        Thread.sleep(500);
      }
    }
  }
  
  public static boolean waitForElementDisappear()
      throws InterruptedException, FileNotFoundException {
    boolean found = false;

    while (!found) {
      Thread.sleep(600);
      WebElement loading = driver.findElement(By.xpath(orprop.getProperty("loading")));
      boolean isPanelEnabled = loading.isDisplayed();
      if (isPanelEnabled) {
        highlightElement(loading);
        Thread.sleep(800);
      } else {
        found = true;
        Thread.sleep(800);
        break;
      }
    }
    reAuthenticationPopup();
    Thread.sleep(500);
    return found;
  }
  
  protected static void reAuthenticationPopup() throws InterruptedException, FileNotFoundException {
    boolean found = false;
    boolean foundAuthenticationPopup = false;
    boolean foundFramePopup = false;
    boolean foundSubmit = false;
    Thread.sleep(500);
    parentHandle = driver.getWindowHandle();
    while (!found) {
      WebElement foundReauthenticationPopup =
          driver.findElement(By.xpath(orprop.getProperty("reauthenticationpopup")));
      foundAuthenticationPopup = foundReauthenticationPopup.isDisplayed();
      if (!foundAuthenticationPopup) {
        // do nothing
        break;
      } else {
        WebElement foundFrame =
            driver.findElement(By.xpath(orprop.getProperty("reauthenticationpopupframe")));
        foundFramePopup = foundFrame.isDisplayed();
        if (foundFramePopup) {
          switchToFrame(orprop.getProperty("reauthenticationpopupframename"));
          WebElement findContinue =
              driver.findElement(By.xpath(orprop.getProperty("reauthenticationcontinue")));
          foundSubmit = findContinue.isDisplayed();
          if (foundSubmit) {
            findContinue.click();
            switchToParentWindow(parentHandle);
            waitforPanelLoad();
            found = true;
            break;
          }
          if (found)
            break;
        }
        if (found)
          break;
      }
      if (found)
        break;
    }
    Thread.sleep(700);
  }
  
  public static void callEvent(String table, String butName)
      throws InterruptedException, FileNotFoundException {
    waitForPageLoad();
    boolean found = false;
    Thread.sleep(500);
    waitForElementDisappear();
    // waitForPageLoad();
    List<WebElement> findButton = driver.findElements(By.xpath(table));
    for (WebElement myButton : findButton) {
      if (myButton.isDisplayed() && myButton.isEnabled()
          && myButton.getAttribute("value").trim().equalsIgnoreCase(butName.trim())) {
        found = findAndClickElementWithTextAttribute(myButton, butName);
        if (found) {
          found = waitForElementDisappear();
          if (found) {
            // waitForPageLoad();
            break;
          }
        }
      }
      if (found)
        break;
    }
    // WaitForElementDisapper();
    waitforPanelLoad();
    Thread.sleep(1000);
  }

  public static boolean findAndClickElementWithTextAttribute(WebElement element, String text)
      throws InterruptedException, FileNotFoundException {
    boolean found = false;
    String actual = element.getAttribute("value").trim();
    String expected = text.trim();

    if (actual.equalsIgnoreCase(expected)) {
      highlightElement(element);
      log.info(KEYWORD_PASS + " Find the element " + element);
      clickElement(element);
      log.info("");
      found = true;
    }
    waitForElementDisappear();
    return found;
  }
}// end of class
