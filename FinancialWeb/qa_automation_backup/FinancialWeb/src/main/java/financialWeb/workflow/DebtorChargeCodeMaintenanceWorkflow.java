package financialWeb.workflow;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import financialWeb.pages.DebtorChargeCodeMaintenance;

/**Some common methods which can be used for any page actions.
 */
public class DebtorChargeCodeMaintenanceWorkflow extends CommonWorkflow {
  
  static DebtorChargeCodeMaintenance objDebtorChargeCodeMaintenance;
  protected static String chargecode = null;
  
  protected static String setChargeCode() throws FileNotFoundException, InterruptedException {
    objDebtorChargeCodeMaintenance = new DebtorChargeCodeMaintenance(driver);
    chargecode = getRandomString();
    waitforPanelElement(DebtorChargeCodeMaintenance.txtChargeCode);
    setText(DebtorChargeCodeMaintenance.txtChargeCode, chargecode);
    return chargecode;
  }
  
  protected static String getChargeCode() throws FileNotFoundException, InterruptedException {
   // objDebtorChargeCodeMaintenance = new DebtorChargeCodeMaintenance(driver);
    //chargecode = DebtorChargeCodeMaintenance.getChargeCode();
    chargecode = getRandomWebElementValue(msgprop.getProperty("lblchargecode"));
    return chargecode;
  }
  
  protected static void setShortDescription(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
objDebtorChargeCodeMaintenance = new DebtorChargeCodeMaintenance(driver);
    waitforPanelElement(DebtorChargeCodeMaintenance.txtShortDescription);
    setText(DebtorChargeCodeMaintenance.txtShortDescription,data);
  }
  protected static void setDescription(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDebtorChargeCodeMaintenance = new DebtorChargeCodeMaintenance(driver);
    setText(DebtorChargeCodeMaintenance.txtDescription,data);
  }
  protected static void setPopUpText(String data) throws FileNotFoundException, InterruptedException {
    objDebtorChargeCodeMaintenance = new DebtorChargeCodeMaintenance(driver);
    selectDropDown(DebtorChargeCodeMaintenance.popUpTextDropDn,data);
  }
  protected static void setUnitOfCharge(String data) throws FileNotFoundException, InterruptedException {
    objDebtorChargeCodeMaintenance = new DebtorChargeCodeMaintenance(driver);
    selectDropDown(DebtorChargeCodeMaintenance.unitOfChargeDropDn,data);
  }
  
  protected static void selectCheckboxPriceInclusiveOfVAT() throws FileNotFoundException, InterruptedException {
    objDebtorChargeCodeMaintenance = new DebtorChargeCodeMaintenance(driver);
    DebtorChargeCodeMaintenance.checkPriceInclusiveOfVAT();
  }
  
  protected static void selectCheckboxAllowOverrideDesc() throws FileNotFoundException, InterruptedException {
    objDebtorChargeCodeMaintenance = new DebtorChargeCodeMaintenance(driver);
    DebtorChargeCodeMaintenance.allowOverrideDesc();
  }
  protected static void selectCheckboxAllowOverridePrice() throws FileNotFoundException, InterruptedException {
    objDebtorChargeCodeMaintenance = new DebtorChargeCodeMaintenance(driver);
    DebtorChargeCodeMaintenance.allowOverridePrice();
  }
  protected static void selectCheckboxAllowOverrideVatCode() throws FileNotFoundException, InterruptedException {
    objDebtorChargeCodeMaintenance = new DebtorChargeCodeMaintenance(driver);
    DebtorChargeCodeMaintenance.allowOverrideVatCode();
  }
  protected static void selectCheckboxAllowOverrideLedgerCode() throws FileNotFoundException, InterruptedException {
    objDebtorChargeCodeMaintenance = new DebtorChargeCodeMaintenance(driver);
    DebtorChargeCodeMaintenance.allowOverrideLedgerCode();
  }
  
  protected static void selectCheckboxAllowOverrideUnitOfCharge() throws FileNotFoundException, InterruptedException {
    objDebtorChargeCodeMaintenance = new DebtorChargeCodeMaintenance(driver);
    DebtorChargeCodeMaintenance.allowOverrideUnitOfCharge();
  }
  
  protected static void setDefaultQuantity(String data) throws FileNotFoundException {
    objDebtorChargeCodeMaintenance = new DebtorChargeCodeMaintenance(driver);
    setText(DebtorChargeCodeMaintenance.txtDefaultQuantity,data);
  }
  protected static void setVatCode(String data) throws FileNotFoundException, InterruptedException {
    objDebtorChargeCodeMaintenance = new DebtorChargeCodeMaintenance(driver);
    selectDropDown(DebtorChargeCodeMaintenance.vatCodeDropDn,data);
  }
  protected static void setStartDate() throws FileNotFoundException {
    objDebtorChargeCodeMaintenance = new DebtorChargeCodeMaintenance(driver);
    String currentdate =additionalDayOfDateFromCurrentDateWithDateFormat(testdataprop.getProperty("currentdate"));
    setText(DebtorChargeCodeMaintenance.txtStartDate,currentdate);
  } 
  public static String getStartDate() throws FileNotFoundException {
    objDebtorChargeCodeMaintenance = new DebtorChargeCodeMaintenance(driver);
    return DebtorChargeCodeMaintenance.txtStartDate.getAttribute("value");
  }
  protected static void setPrice(String data) throws FileNotFoundException {
    objDebtorChargeCodeMaintenance = new DebtorChargeCodeMaintenance(driver);
    setText(DebtorChargeCodeMaintenance.txtPrice,data);
  }
  protected static void setGLCode(String data) throws FileNotFoundException, InterruptedException {
    objDebtorChargeCodeMaintenance = new DebtorChargeCodeMaintenance(driver);
    waitforPanelElement(DebtorChargeCodeMaintenance.txtGLCode);
    setText(DebtorChargeCodeMaintenance.txtGLCode,data);
   // DebtorChargeCodeMaintenance.txtGLCode.sendKeys(Keys.TAB);
    Thread.sleep(2000);
  }
  protected static void uncheckSuspendCharge() throws FileNotFoundException {
    objDebtorChargeCodeMaintenance = new DebtorChargeCodeMaintenance(driver);
    unCheckCheckBox(DebtorChargeCodeMaintenance.uncheckSuspendChargeCheckBox);
  }
  protected static void clickAnalysisCode() throws FileNotFoundException {
    objDebtorChargeCodeMaintenance = new DebtorChargeCodeMaintenance(driver);
    click(DebtorChargeCodeMaintenance.txtAnalysisCode);
  }
  protected static void clickArchitecturalService() throws FileNotFoundException, InterruptedException {
    objDebtorChargeCodeMaintenance = new DebtorChargeCodeMaintenance(driver);
    waitforPanelElement(DebtorChargeCodeMaintenance.architecturalCheckBox);
    click(DebtorChargeCodeMaintenance.architecturalCheckBox);
  }
  protected static void clickHousing() throws FileNotFoundException {
    objDebtorChargeCodeMaintenance = new DebtorChargeCodeMaintenance(driver);
    click(DebtorChargeCodeMaintenance.housingCheckBox);
  }
  protected static void clickChiefexecutive() throws FileNotFoundException, InterruptedException {
    objDebtorChargeCodeMaintenance = new DebtorChargeCodeMaintenance(driver);
    click(DebtorChargeCodeMaintenance.chiefExecCheckBox);
  }
  public static void setDBfindChargeCode(String data) throws FileNotFoundException, InterruptedException {
    objDebtorChargeCodeMaintenance = new DebtorChargeCodeMaintenance(driver);
    waitforPanelElement(DebtorChargeCodeMaintenance.txtDBfindChargeCode);
    setText(DebtorChargeCodeMaintenance.txtDBfindChargeCode,data);
  }
  protected static void setsecondStartDate() throws FileNotFoundException {
    objDebtorChargeCodeMaintenance = new DebtorChargeCodeMaintenance(driver);
    String dateafterthreemonths = additionalDayOfDateFromCurrentDateWithDateFormat(testdataprop.getProperty("threemonthsadditionaldate"));
    setText(DebtorChargeCodeMaintenance.txtsecondStartDate,dateafterthreemonths);
  }
  protected static String additionalDayOfDateFromCurrentDateWithDateFormat(String plusNoOfDays) {
      // Get current date
      String DATE_FORMAT = "dd/MM/yyyy";
      DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
      DateTimeFormatter dateFormat8 = DateTimeFormatter.ofPattern(DATE_FORMAT);
      Date currentDate = new Date();
      // convert date to localdatetime
      LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
      dateFormat8.format(localDateTime).toString();
      // plus one
      localDateTime = localDateTime.plusDays(Integer.parseInt(plusNoOfDays));
      // convert LocalDateTime to date
      Date currentDatePlusOneDay = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
      String dateToString =dateFormat.format(currentDatePlusOneDay).toString();
      return dateToString;
    
  }
  protected static void setSecondPrice(String data) throws FileNotFoundException {
    objDebtorChargeCodeMaintenance = new DebtorChargeCodeMaintenance(driver);
    setText(DebtorChargeCodeMaintenance.txtSecondPrice,data);
  }
  public static void btnClear() throws FileNotFoundException, InterruptedException {
    objDebtorChargeCodeMaintenance = new DebtorChargeCodeMaintenance(driver);
    waitforPanelElement(DebtorChargeCodeMaintenance.btnclear);
    clickElement(DebtorChargeCodeMaintenance.btnclear);
    waitforPanelLoad();
  }
  
  protected static void updateAndcloseDBChargeCodeSecurityWindow() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objDebtorChargeCodeMaintenance = new DebtorChargeCodeMaintenance(driver);
    boolean found = false;
    waitforPanelElement(DebtorChargeCodeMaintenance.btnUpdate);
    while(!found) {
      found = DebtorChargeCodeMaintenance.btnUpdate.isDisplayed();
      if(found) {
        DebtorChargeCodeMaintenance.updateDBChargeCodeSecurity();
        waitforPanelLoad();
        break;
      }
    }
    waitforPanelLoad();
    found = false;
    while(!found) {
      //found = DebtorChargeCodeMaintenance.btnClose.isDisplayed();
      found = waitforPanelElement(DebtorChargeCodeMaintenance.btnClose);
      if(found) {
        DebtorChargeCodeMaintenance.closeDBChargeCodeSecurity();
        waitforPanelLoad();
        break;
      }
    } waitforPanelLoad();
  }

  public static void validateChargeCodeTextPopup() throws FileNotFoundException, InterruptedException {
    objDebtorChargeCodeMaintenance = new DebtorChargeCodeMaintenance(driver); 
    Thread.sleep(3000);
    boolean found = false;
    while(!found) {
      found = DebtorChargeCodeMaintenance.msgboxQuestionOK.isDisplayed();
      if(found) {
        DebtorChargeCodeMaintenance.msgboxQuestionOK.click();
        Thread.sleep(1500);
        waitforPanelLoad();
        break;
      }
    }
    waitforPanelLoad();
  }
}//end of class