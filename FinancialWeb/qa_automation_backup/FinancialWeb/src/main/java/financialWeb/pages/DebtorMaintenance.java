package financialWeb.pages;

import java.io.FileNotFoundException;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestBase;
public class DebtorMaintenance extends CommonPage {
    public static final Logger log= Logger.getLogger(DebtorMaintenance.class.getName());
    public static WebDriver driver;
    //Page Factory - OR:
    
    @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_OBJ_Upd0_pnlTabButton']/input")
    public static List <WebElement> lblDbDebtorMaintenanceTabs;

    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd1$proxy_txt_1']")
    public static WebElement txtDebtorNumber;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_2']")
    public static WebElement txtTitleForDbInsertDebtor;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_3']")
    public static WebElement txtFirstNameForDbInsertDebtor;
   
    @FindBy(xpath="//*[@type='text' and @name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_4']")
    public static WebElement txtTitle;
    
    @FindBy(xpath="//*[@type='text' and @name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_5']")
    public static WebElement txtFirstName;
    
    @FindBy(xpath="//*[@name = 'ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_6']")
    public static WebElement txtAddressLine1;
    
    @FindBy(xpath="//*[@name = 'ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_7']")
    public static WebElement txtAddressLine2;
    
    @FindBy(xpath="//*[@name = 'ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_8']")
    public static WebElement txtAddressLine3;
    
    @FindBy(xpath="//*[@name = 'ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_9']")
    public static WebElement txtAddressLine4;
    
    @FindBy(xpath="//*[@name = 'ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_10']")
    public static WebElement txtCountry;
    
    @FindBy(xpath="//*[@name = 'ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_12']")
    public static WebElement txtAlternateNumber;
    
    @FindBy(xpath="//*[@name = 'ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_13']")
    public static WebElement txtEmailForInsertContact;

    @FindBy(xpath="//*[@name = 'ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_14']")
    public static WebElement txtPostCode;  
    
    @FindBy(xpath="//*[@name = 'ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_20']")
    public static WebElement txtAddressCode;  
    
    @FindBy(xpath="//*[@value ='Insert Address' and @type='submit']")
    public static WebElement btnInsertAddress;  
    
    @FindBy(xpath="//*[@name = 'ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_22']")
    public static WebElement txtNameAtAddress; 
    
    @FindBy(xpath="//*[@name = 'ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_23']")
    public static WebElement txtAddressLine1ForDbInsertDebtor; 
    
    @FindBy(xpath="//*[@name = 'ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_24']")
    public static WebElement txtAddressLine2ForDbInsertDebtor; 
    
    @FindBy(xpath="//*[@name = 'ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_25']")
    public static WebElement txtAddressLine3ForDbInsertDebtor; 
    
    @FindBy(xpath="//*[@name = 'ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_26']")
    public static WebElement txtAddressLine4ForDbInsertDebtor; 
    
    @FindBy(xpath="//*[@name = 'ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_27']")
    public static WebElement txtCountryForDbInsertDebtor; 
    
    @FindBy(xpath="//*[@name = 'ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_28']")
    public static WebElement txtWebsiteForInsertAddress; 
    
    @FindBy(xpath="//*[@name = 'ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_29']")
    public static WebElement txtComment; 
    
    @FindBy(xpath="//*[@name = 'ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_31']")
    public static WebElement txtPostCodeForDbInsertDebtor; 
    
    @FindBy(xpath="//*[@name = 'ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_33']")
    public static WebElement txtTelephone; 
    
    @FindBy(xpath="//*[@name = 'ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_35']")
    public static WebElement txtEmail; 
    
    @FindBy(xpath="//*[@name = 'ctl00$Main$WC_FIN_OBJ_Upd0$proxy_txt_36']")
    public static WebElement txtWebsite; 
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$WC_Fin_Combo_6$cboCombo']")
    public static WebElement drpdnLocationForDebtorForDbInsertDebtor;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$WC_Fin_Combo_7$cboCombo']")
    public static WebElement dropdnTypeofDebtorForDbInsertDebtor;
    
    @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_OBJ_Upd0_WC_Fin_Combo_8_cboCombo']")
    public static WebElement drpdnLocationForDebtor;
           
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$WC_Fin_Combo_9$cboCombo']")
    public static WebElement dropdnTypeofDebtor;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$WC_Fin_Combo_10$cboCombo']")
    public static WebElement dropdnAccessLevel;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$WC_Fin_Combo_21$cboCombo']")
    public static WebElement dropdnVatCode;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$WC_Fin_Combo_23$cboCombo']")
    public static WebElement dropdnTelephoneNumber;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$WC_Fin_Combo_25$cboCombo']")
    public static WebElement dropdnalternateTelephoneNumber;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_chk_3']")
    public static WebElement suspendRecoveryCheckbox;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_chk_4']")
    public static WebElement emailCreditNoteCheckbox;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_chk_5']")
    public static WebElement emailStatementsCheckbox;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_chk_6']")
    public static WebElement emailInstalmentsCheckbox;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_chk_7']")
    public static WebElement emailInvoiceMasterCheckbox;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_chk_8']")
    public static WebElement emailReminderLettersCheckbox;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_chk_9']")
    public static WebElement emailDDAgreementsCheckbox;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_chk_10']")
    public static WebElement emailDDmandatesCheckbox;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_chk_11']")
    public static WebElement faxInvoiceCheckbox;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_chk_12']")
    public static WebElement faxCreditNoteCheckbox;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_chk_13']")
    public static WebElement faxStatementsCheckbox;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_chk_14']")
    public static WebElement faxInstallmentsCheckbox;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_chk_15']")
    public static WebElement faxInvoiceMasterCheckbox;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_chk_16']")
    public static WebElement faxReminderLettersCheckbox;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_chk_17']")
    public static WebElement faxDDAgreementsCheckbox;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd0$proxy_chk_18']")
    public static WebElement faxDDmandatesCheckbox;
    
    @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_OBJ_Upd0_ErrorLabel']")
    public static WebElement lblErrorMsg;
    
    @FindBy(xpath="//*[@id='ctl00_Main_WCFinancialsTest1_inputtableheader']")
    public static WebElement lblInputHeaders;
    
    @FindBy(xpath="//*[@id='ctl00_Main_WCFinancialsTest1_ResultsTable']/tbody/tr/td[2]")
    public static List <WebElement> lblActionColumn;
    
    @FindBy(xpath="//*[@id='ctl00_Main_WCFinancialsTest1_ResultsTable']/tbody/tr/td[3]")
    public static List <WebElement> lblTypeColumn;
    
    @FindBy(xpath="//*[@id='ctl00_Main_WCFinancialsFind0_ResultsTable']")
    public static WebElement tblDBEditAddress;
    
    
    
    //parameterize constructor to initalize driver and page factory web element
    public DebtorMaintenance(WebDriver driver) throws FileNotFoundException{
        driver=TestBase.driver;
        PageFactory.initElements(driver, this);
    }
    public DebtorMaintenance()  throws FileNotFoundException{
    }
    static WebElement getDropdnalternateTelephoneNumber() {
      return dropdnalternateTelephoneNumber;
    }
    public static void setDropdnalternateTelephoneNumber(String data) throws InterruptedException {
      selectDropDown(dropdnalternateTelephoneNumber, data);
    }
    static WebElement getTxtWebsiteForInsertAddress() {
      return txtWebsiteForInsertAddress;
    }
    public static void setTxtWebsiteForInsertAddress(String data) {
      setText(txtWebsiteForInsertAddress, data);
    }
    static WebElement getTxtComment() {
      return txtComment;
    }
    public static void setTxtComment(String data) {
      setText(txtComment, data);;
    }
    static WebElement getTxtAlternateNumber() {
      return txtAlternateNumber;
    }
    public static void setTxtAlternateNumber(String data) {
      setText(txtAlternateNumber, data);
    }
    public static WebElement getTxtEmailForInsertContact() {
      return txtEmailForInsertContact;
    }
    public static void setTxtEmailForInsertContact(String data) {
      setText(txtEmailForInsertContact,data);
    }
    
    public static String getAddressLineOne() throws InterruptedException {
      highlightElement(txtAddressLine1);
      return txtAddressLine1.getAttribute("value");
    }
    
    public static String getAddressLineTwo() throws InterruptedException {
      highlightElement(txtAddressLine2);
      return txtAddressLine2.getAttribute("value");
    }
    
    public static String getAddressLineThree() throws InterruptedException {
      highlightElement(txtAddressLine3);
      return txtAddressLine3.getAttribute("value");
    }
    
    public static String getAddressLineFour() throws InterruptedException{
      highlightElement(txtAddressLine4);
      return txtAddressLine4.getAttribute("value");
    }
    
    public static String getCountry() throws InterruptedException{
      highlightElement(txtCountry);
      return txtCountry.getAttribute("value");
    }
    
    public static String getPostCode() throws InterruptedException{
      highlightElement(txtPostCode);
      return txtPostCode.getAttribute("value");
    }
    
    public static String getTitle() throws InterruptedException{
      highlightElement(txtTitle);
      return txtTitle.getAttribute("value");
    }
    
    public static String getFirstName() throws InterruptedException{
      highlightElement(txtFirstName);
      return txtFirstName.getAttribute("value");
    }
    
    public static String getLastName() throws InterruptedException{
      highlightElement(txtAddressLine1);
      return txtAddressLine1.getAttribute("value");
    }
}
