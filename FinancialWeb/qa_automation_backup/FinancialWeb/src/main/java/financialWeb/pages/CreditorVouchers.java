package financialWeb.pages;

import java.io.FileNotFoundException;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestBase;
public class CreditorVouchers extends CommonPage {
    
    public static final Logger log= Logger.getLogger(CreditorVouchers.class.getName());
    public static WebDriver driver;
   
    static CreditorVouchers objCreditorVouchers;  
   
    @FindBy(xpath="//*[@class='WebControlPopUp']/div/table/tbody/tr/td[4]/a[2]")
    public static WebElement btnCloseAuditInfoPopup;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Combo_1$cboCombo']")
    public static WebElement drpdnTransCode;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_16']")
    public static WebElement txtInvoiceNo;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_17']")
    public static WebElement txtPOInvoiceInvoiceNo;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Curr_19$txtCurr']")
    public static WebElement txtGrossAmount;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Curr_20$txtCurr']")
    public static WebElement txtPOInvoiceGrossAmount;
    
    //@FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Curr_21$txtCurr']")
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Curr_22$txtCurr']")
    public static WebElement txtVatAmount;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Curr_21$txtCurr']")
    public static WebElement txtCrNoteVatAmount;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$WC_Fin_Curr_22$txtCurr']")
    public static WebElement txtPOInvoiceVatAmount;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_9']")
    public static WebElement txtCreditorNumber;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_10']")
    public static WebElement txtPOInvoiceCreditorNumber;
    
    @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Date_18_imgDte']")
    public static WebElement dtInvoiceDate;
    
    @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Date_19_imgDte']")
    public static WebElement dtPOInvoiceDate;
    
    @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Date_23_imgDte']")
    public static WebElement dtPOInvoiceGLDate;
    
    @FindBy(xpath="//*[@id='ctl00_Main_WC_FIN_Grid_Upd0_WC_Fin_Date_22_imgDte']")
    public static WebElement dtGLDate;
    
    @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_txtPIN_LINE_ITEM_1_10']")
    public static WebElement txtSetGLCode;
    
    @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_txtPIN_LINE_ITEM_1_11']")
    public static WebElement txtSetAnalysisCode;
    
    @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_txtPIN_LINE_ITEM_1_28']")
    public static WebElement txtSetGoodsAmount;
    
    @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_cboPIN_LINE_ITEM_1_32']")
    public static WebElement drpdnVatCode;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_2']")
    public static WebElement txtVoucherNumber;
   
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_3']")
    public static WebElement txtSUndryInvoiceVoucherNo;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_39']")
    public static WebElement txtCreditNoteStatus;

    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_40']")
    public static WebElement txtSundryInvoiceComment;

    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_41']")
    public static WebElement txtStatus;
    
    @FindBy(xpath="//*[@name='ctl00$Main$WC_FIN_Grid_Upd0$proxy_txt_42']")
    public static WebElement txtComment;
    
    @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_txtPIN_LINE_ITEM_1_7']")
    public static WebElement txtGlCode;
    
    @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_txtPIN_LINE_ITEM_1_8']")
    public static WebElement txtAnalysisCode;   

    @FindBy(xpath="//*[@name='ctl00_Main_WC_FIN_Grid_Upd0_cboPIN_LINE_ITEM_1_14']")
    public static WebElement drpdnCreditNoteVatCode;
    
    public static void setDrpdnCreditNoteVatCode(String data) throws InterruptedException {
      selectDropDown(CreditorVouchers.drpdnCreditNoteVatCode,data);
    }
    
    public static void setTxtAnalysisCode(String data) {
      setText(CreditorVouchers.txtAnalysisCode,data);
    }
    
    public static void setTxtGlCode(String data) throws InterruptedException {
      setText(CreditorVouchers.txtGlCode,data);
      CreditorVouchers.txtGlCode.sendKeys(Keys.TAB);
      Thread.sleep(3000);
    }

    public static void setTxtSUndryInvoiceComment(String data) {
      setText(CreditorVouchers.txtSundryInvoiceComment,data);
    }
         
    public static void setTxtSUndryInvoiceVoucherNo(String data) {
      setText(CreditorVouchers.txtSUndryInvoiceVoucherNo,data);
    }
    
    public static void closeAuditInfo() throws InterruptedException {
      boolean found= btnCloseAuditInfoPopup.isDisplayed();
      if(found) {
        btnCloseAuditInfoPopup.click();
      }
    }
    
    public static void setTransCode(String data) throws InterruptedException {
      selectDropDown(drpdnTransCode, data);
    }

    public static void setInvoiceNo(String data) {
      setText(txtInvoiceNo, data);
    }
    
    public static void setPOInvoiceInvoiceNo(String data) {
      setText(txtPOInvoiceInvoiceNo, data);
    }

    public static void setGrossAmount(String data) {
      setText(txtGrossAmount, data);
    }
    
    public static void setPOInvoiceGrossAmount(String data) {
      setText(txtPOInvoiceGrossAmount, data);
    }

    public static void setVatAmount(String data) {
      setText(txtVatAmount, data);
    }
    
    public static void setVatAmount(String data, String novalue) {
      setText(txtCrNoteVatAmount, data);
    }
    
    public static void setPOInvoiceVatAmount(String data) {
      setText(txtPOInvoiceVatAmount, data);
    }
    
    public static void clickInvoiceDate() {
      dtInvoiceDate.click();
    }
    public static void clickdtPOInvoiceDate() {
      dtPOInvoiceDate.click();
    }
    public static void clickdtPOInvoiceGLDate() {
      dtPOInvoiceGLDate.click();
    }
    
    public static void clickGLDate() {
      dtGLDate.click();
    }

    public static void creditorNumber(String data) throws InterruptedException {
      txtCreditorNumber.sendKeys(data);
      txtCreditorNumber.sendKeys(Keys.TAB);
      Thread.sleep(3000);
    }
    public static void POInvoiceCreditorNumber(String data) throws InterruptedException {
      txtPOInvoiceCreditorNumber.sendKeys(data);
      txtPOInvoiceCreditorNumber.sendKeys(Keys.TAB);
      Thread.sleep(3000);
    }
    
    public static void glCode(String data) throws InterruptedException {
      txtSetGLCode.sendKeys(data);
      txtSetGLCode.sendKeys(Keys.TAB);
      Thread.sleep(2000);
    }
    
    public static void analysisCode(String data) throws InterruptedException {
      txtSetAnalysisCode.sendKeys(data);
      txtSetAnalysisCode.sendKeys(Keys.TAB);
    }
    
    public static void goodsAmount(String data) throws InterruptedException {
      txtSetGoodsAmount.sendKeys(data);
      txtSetGoodsAmount.sendKeys(Keys.TAB);
    }
    
    public static void setVatCode(String data) throws InterruptedException {
     selectDropDown(drpdnVatCode, data);
    }
    
    public static void setVoucherNUmber(String data) throws InterruptedException {
      setText(txtVoucherNumber, data);
     }
     
    
    public static String getVoucherNumber() throws InterruptedException {
      
      boolean found = false;
      while(!found) {
      found  = txtVoucherNumber.isDisplayed();
      if(found) {
      highlightElement(txtVoucherNumber);
      } else {
        Thread.sleep(2000);
        found=false;
        }
      }
      return txtVoucherNumber.getAttribute("value");
     }
    
    public static String getPOVoucherNumber() throws InterruptedException {
      
      boolean found = false;
      while(!found) {
      found  = txtSUndryInvoiceVoucherNo.isDisplayed();
      if(found) {
      highlightElement(txtSUndryInvoiceVoucherNo);
      } else {
        Thread.sleep(2000);
        found=false;
        }
      }
      return txtSUndryInvoiceVoucherNo.getAttribute("value");
     }
    
    public static void voucherNumber(String data) throws InterruptedException {
      txtSUndryInvoiceVoucherNo.sendKeys(data);
      txtSUndryInvoiceVoucherNo.sendKeys(Keys.TAB);
     }
        
    public static void setComment(String data) {
      setText(txtComment, data);
    }
    
    //parameterize constructor to initalize driver and page factory web element
    public CreditorVouchers(WebDriver driver) throws FileNotFoundException{
        driver=TestBase.driver;
        PageFactory.initElements(driver, this);
    }
    
    public CreditorVouchers()  throws FileNotFoundException{
    }
}
