package financialWeb.pages;

import java.io.FileNotFoundException;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import util.TestBase;

public class DebtorPayments extends CommonPage {

  public static final Logger log= Logger.getLogger(DebtorPayments.class.getName());
    public static WebDriver driver;
    
    //Page Factory - OR:
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_5']")
    public static WebElement txtReferenceOne;

    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_16']")
    public static WebElement txtReferenceTwo;
      
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_4$cboCombo']")
    private static WebElement drpdnTransCode;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_txt_7']")
    public static WebElement txtCancelComment;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WCFinancialsTest1$proxy_txt_7']")
    private static WebElement txtDBFindPaymentReferenceOne;
    
    @FindBy(xpath="//*[@id='ctl00_Main_WCFinancialsTest1_WC_Fin_Date_10_imgDte']")
    private static WebElement imgTransDate;
        
    @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_proxy_lbl_5']")
    public static WebElement lblForReferenceOne;

    @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_proxy_lbl_16']")
    public static WebElement lblForReferenceTwo;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_9']")
    public static WebElement txtDebtorNo;

    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Curr_19$txtCurr']")
    public static WebElement txtAmount;
    
    @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Date_20_imgDte']")
    public static WebElement dtDate;
    
    @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Date_22_imgDte']")
    public static WebElement dtGLDate;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_35$cboCombo']")
    public static WebElement drpdnStatus;

    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_txt_9']")
    public static WebElement txtAllocatedDebtorNo;

    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Date_20$txtDate']")
    public static WebElement txtDate;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_txt_30']")
    public static WebElement txtAllocatedReferenceNo;

    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_34']")
    public static WebElement txtCommentBox;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$proxy_txt_34']")
    public static WebElement txtAllocatedCommentBox;
        
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Combo_4$cboCombo']")
    private static WebElement drpdnAllocatedTransCode;

    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Combo_6$cboCombo']")
    public static WebElement drpdnCancelReason;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_27$cboCombo']")
    public static WebElement drpdnPaymentMethod;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$btn_Table_Results']")
    public static WebElement btnCancelSave;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Combo_9$cboCombo']")
    public static WebElement drpdnRefundTransCode;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$btnPNT_CLOSE_1']")
    public static WebElement btnClose;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_find_5']")
    public static WebElement btnSearchReferenceOne;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Combo_27$cboCombo']")
    public static WebElement drpdnAllocatedPaymentMethod;

    @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_proxy_lbl_5']")
    public static WebElement lblForAllocatedReferenceOne;

    @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_proxy_lbl_16']")
    public static WebElement lblForAllocatedReferenceTwo;
    
    
    @FindBy(xpath="//*[@id='brd_ctl00_Main_WCFinancialsFind0']")
    public static WebElement tabDBNotesForPayment;
    
    @FindBy(xpath="//*[@id='ctl00_Main_WCFinancialsFind0_ResultsTable']/tbody/tr[2]/td[2]/a/img")
    public static WebElement imgAttach;
/*
     Debtor Maintenance new global elements
      */
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd1$proxy_txt_4']")
    public static WebElement txtTitle;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd1$proxy_txt_5']")
    public static WebElement txtFirstName;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd1$proxy_txt_6']")
    public static WebElement txtLastName;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd1$WC_Fin_Combo_8$cboCombo']")
    public static WebElement drpdnLocation;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd1$WC_Fin_Combo_9$cboCombo']")
    public static WebElement drpdnTypeOfDebtor;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_OBJ_Upd1$WC_Fin_Combo_10$cboCombo']")
    public static WebElement drpdnAccessLevel;
    
    @FindBy(xpath="//*[@name = 'ctl00$Main$WC_FIN_OBJ_Upd1$proxy_txt_6']")
    public static WebElement txtAddressLine1;
    
    @FindBy(xpath="//*[@name = 'ctl00$Main$WC_FIN_OBJ_Upd1$proxy_txt_7']")
    public static WebElement txtAddressLine2;
    
    @FindBy(xpath="//*[@name = 'ctl00$Main$WC_FIN_OBJ_Upd1$proxy_txt_8']")
    public static WebElement txtAddressLine3;
    
    @FindBy(xpath="//*[@name = 'ctl00$Main$WC_FIN_OBJ_Upd1$proxy_txt_9']")
    public static WebElement txtAddressLine4;
    
    @FindBy(xpath="//*[@name = 'ctl00$Main$WC_FIN_OBJ_Upd1$proxy_txt_10']")
    public static WebElement txtCountry;
    
    @FindBy(xpath="//*[@name = 'ctl00$Main$WC_FIN_OBJ_Upd1$proxy_txt_14']")
    public static WebElement txtPostCode;  
    
    @FindBy(xpath="//*[@name = 'ctl00$Main$WC_FIN_OBJ_Upd1$proxy_txt_1']")
    public static WebElement txtDebtorNumber;  
    
    @FindBy(xpath="//*[@name = 'ctl00$Main$WC_FIN_OBJ_Upd1$proxy_txt_19']")
    public static WebElement txtCreditorActCode;  
    
    @FindBy(xpath="//*[@name = 'ctl00$Main$WC_FIN_Grid_Upd1$proxy_txt_17']")
    public static WebElement txtRefundOverpaymentComment;  
    
    @FindBy(xpath="//*[@name = 'ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Combo_18$cboCombo']")
    public static WebElement drpdnRefundReason; 
    
    @FindBy(xpath="//*[@name = 'ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Combo_35$cboCombo']")
    public static WebElement drpdndbManualPaymentStatus; 
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Curr_19$txtCurr']")
    public static WebElement txtAllocatedAmount;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Curr_21$txtCurr']")
    public static WebElement txtAllocated;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd1$WC_Fin_Curr_23$txtCurr']")
    public static WebElement txtOutstanding;
        
    @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_WC_Fin_Date_20_imgDte']")
    public static WebElement dtAllocatedDate;
    
    @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd1_WC_Fin_Date_22_imgDte']")
    public static WebElement dtAllocatedGLDate;
    
    @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd2_WC_Fin_AjaxLK_5_imgAjx']")
    public static WebElement drpdnAllocateTo;
    
    @FindBy(xpath=" //*[@id='ctl00_Main_WC_FIN_Grid_List0_ResultsTable']/tbody/tr[2]/td[1]")
    public static WebElement chkdbAllocationCheckBox;
    
    @FindBy(xpath=" //*[@name='ctl00$Main$WC_FIN_Grid_Upd2$btn_Table_Results']")
    public static WebElement btnSave;
    
    @FindBy(xpath="//*[@type='button' and @value=' New Allocation ']")
    public static WebElement btnNewAllocation;
  
    @FindBy(xpath="//*[@type='button' and @value='Add to Allocations']")
    public static WebElement btnAddToAllocation;
    
    public static void setBtnSave() {
      DebtorPayments.btnSave.click();
    }
    
    public static String getDrpdndbManualPaymentStatus() {
      Select oSelect = new Select(drpdndbManualPaymentStatus);
      return oSelect.getFirstSelectedOption().getText();     
    }

    public static void setChkdbAllocationCheckBox() {
      checkCheckBox(DebtorPayments.chkdbAllocationCheckBox);
    }

    public static void setDrpdnAllocateTo() throws InterruptedException {
      DebtorPayments.drpdnAllocateTo.click();
    }

    public static String getTxtAllocated() {
      return txtAllocated.getAttribute("value");
    }
    
    public static void setTransactionCode(String data) throws InterruptedException {
      selectDropDown(drpdnTransCode, data);
    }
    
    public static String getTxtDate() {
      return txtDate.getAttribute("value");
    }

    public static String getTxtOutstanding() {
      return txtOutstanding.getAttribute("value");
    }
    
    public static void setReferenceOne(String data) throws InterruptedException {
      setText(txtReferenceOne, data);
    }
    
    public static void setReferenceTwo(String data) throws InterruptedException {
      setText(txtReferenceTwo, data);
    }
    
    public static String getReferenceOne() throws InterruptedException {
      highlightElement(txtReferenceOne);
      return txtReferenceOne.getAttribute("value");
    }
    
    public static String getReferenceTwo()throws InterruptedException {
      highlightElement(txtReferenceTwo);
      return txtReferenceTwo.getAttribute("value");
    }
    
    public static String getLabelForReferenceOne() throws InterruptedException {
      return lblForReferenceOne.getText();
    }
    
    public static String getLblForAllocatedReferenceOne() {
      return lblForAllocatedReferenceOne.getText();
    }
    
    public static String getLblForAllocatedReferenceTwo() {
      return lblForAllocatedReferenceTwo.getText();
    }

    public static String getLabelForReferenceTwo()throws InterruptedException {
      return lblForReferenceOne.getText();
    }
    
    public static void setDebtorNumber(String data) throws InterruptedException {
      txtDebtorNo.sendKeys(data);
      txtDebtorNo.sendKeys(Keys.TAB);
      Thread.sleep(3000);
    }
    
    public static void setTxtAllocatedDebtorNo(String data) throws InterruptedException {
      setText(DebtorPayments.txtAllocatedDebtorNo,data);
      txtAllocatedDebtorNo.sendKeys(Keys.TAB);
      Thread.sleep(3000);
    }
    
    public static void setAmount(String data) throws InterruptedException {
      setText(txtAmount, data);
    }
    
    public static String getAmount() throws InterruptedException {
      return txtAmount.getAttribute("value");
    }
    
    public static void setTxtAllocatedAmount(String data) {
      setText(DebtorPayments.txtAllocatedAmount,data);
    }
    
    public static void clickDate() throws InterruptedException {
      clickElement(dtDate);
    }
    
    public static void clickGLDate() throws InterruptedException {
      clickElement(dtGLDate);
    }
    
    public static void clickAllocatedDate() throws InterruptedException {
      clickElement(dtAllocatedDate);
    }
    
    public static void clickAllocatedGLDate() throws InterruptedException {
      clickElement(dtAllocatedGLDate);
    }
    
     
    public static void setAllocatedPaymentMethod(String data) throws InterruptedException {
      selectDropDown(DebtorPayments.drpdnAllocatedPaymentMethod,data);
    }

    public static void setPaymentMethod(String data) throws InterruptedException {
      selectDropDown(drpdnPaymentMethod, data);
    }
    
    public static void setTitle(String data) throws InterruptedException {
      setText(txtTitle, data);
    }
    public static void setFirstName(String data) throws InterruptedException {
      setText(txtFirstName, data);
    }
    
    public static void setLastName(String data) throws InterruptedException {
      setText(txtLastName, data);
    }
    public static void setLocation(String data) throws InterruptedException {
      selectDropDown(drpdnLocation, data);
    }
    public static void setTypeOfDebtors(String data) throws InterruptedException {
      selectDropDown(drpdnTypeOfDebtor, data);
    }
    
    public static void setAccessLevel(String data) throws InterruptedException {
      selectDropDown(drpdnAccessLevel, data);
    }
    
    public static String getDebtorNumber() {
      return txtDebtorNumber.getAttribute("value");
    }
    
    public static void setDebtorNo(String data) {
      setText(txtDebtorNumber,data);
    }
    
    
    public static String getTitle() throws InterruptedException {
      return txtTitle.getAttribute("value");
    }
    public static String getFirstName() throws InterruptedException {
      return txtFirstName.getAttribute("value");
    }
    
    public static String getLastName() throws InterruptedException {
      return txtLastName.getAttribute("value");
    }
    public static void setCreditorNo(String data) {
      setText(txtCreditorActCode, data);
    }

    public static void setRefundTransCode(String data) throws InterruptedException {
      selectDropDown(drpdnRefundTransCode, data);
    }
    public static void setRefundOverpaymentComment(String data) {
     setText(txtRefundOverpaymentComment, data);
    }
    public static void setRefundOverpaymentReason(String data) throws InterruptedException {
      selectDropDown(drpdnRefundReason, data);
    }
    
    public static void clickReferenceOne() throws InterruptedException {
      clickElement(btnSearchReferenceOne);
    }

    public static void setReferenceOneForDBFind(String data) {
      setText(txtDBFindPaymentReferenceOne, data);
     }

    public static void clickTransDate() throws InterruptedException {
      clickElement(imgTransDate);
    }
    public static void clickDBNotesForPayment() throws InterruptedException {
      clickElement(tabDBNotesForPayment);
      
    }
    
    public static void setDrpdnAllocatedTransCode(String data) throws InterruptedException {
      selectDropDown(DebtorPayments.drpdnAllocatedTransCode,data);
    }
    
    public static void setComment(String data) throws InterruptedException {
      setText(txtCommentBox, data);
    }
    
    public static void setAllocatedComment(String data) throws InterruptedException {
      setText(txtAllocatedCommentBox, data);
    }
    
    public static String getStatus() {
      Select oSelect = new Select(drpdnStatus);
      return oSelect.getFirstSelectedOption().getText();
    }
    public static void setCancelReason(String data) throws InterruptedException {
      selectDropDown(drpdnCancelReason, data);
    }
    
    public static void setCancelComment(String data) throws InterruptedException {
      setText(txtCancelComment, data);
    }
    
   public static void setTxtAllocatedReferenceNo(String data) {
     setText(DebtorPayments.txtAllocatedReferenceNo,data);
   }
   

   //parameterize constructor to initalize driver and page factory web element
    public DebtorPayments(WebDriver driver) throws FileNotFoundException{
        driver=TestBase.driver;
        PageFactory.initElements(driver, this);
    }
    public DebtorPayments()  throws FileNotFoundException{
    }
   
}
