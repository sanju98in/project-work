package financialWeb.workflow;

import java.io.FileNotFoundException;
import financialWeb.pages.CreditorVouchers;

public class CreditorVouchersWorkflow extends CommonWorkflow{

  static CreditorVouchers objCreditorVouchers;

  public static void closePopup() throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objCreditorVouchers = new CreditorVouchers(driver);
    CreditorVouchers.closeAuditInfo();
    waitforPanelLoad();
  }

  public static void setCRPOInvoiceTransCode(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objCreditorVouchers = new CreditorVouchers(driver);
    waitforPanelElement(CreditorVouchers.drpdnTransCode);
    CreditorVouchers.setTransCode(data);
  }
  
  public static void setCRPOInvoiceNo(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objCreditorVouchers = new CreditorVouchers(driver);
    CreditorVouchers.setInvoiceNo(data);
  }
  
  public static void setCRPOInvoiceGrossAmount(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objCreditorVouchers = new CreditorVouchers(driver);
    CreditorVouchers.setGrossAmount(data);
  }
  
  public static void setPOInvoiceGrossAmount(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objCreditorVouchers = new CreditorVouchers(driver);
    CreditorVouchers.setPOInvoiceGrossAmount(data);
  }
  
  public static void setPOInvoiceVatAmount(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objCreditorVouchers = new CreditorVouchers(driver);
    CreditorVouchers.setPOInvoiceVatAmount(data);
  }
  
  public static void setPOInvoiceInvoiceNo(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objCreditorVouchers = new CreditorVouchers(driver);
    CreditorVouchers.setPOInvoiceInvoiceNo(data);
  }
  
  public static void setCRPOInvoiceVatAmount(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objCreditorVouchers = new CreditorVouchers(driver);
    CreditorVouchers.setVatAmount(data);
  }
  
  public static void setCRPOInvoiceVatAmount(String data,String data1) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objCreditorVouchers = new CreditorVouchers(driver);
    CreditorVouchers.setVatAmount(data,"0");
  }
  
  public static void selectInvoiceDate() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objCreditorVouchers = new CreditorVouchers(driver);
    CreditorVouchers.clickInvoiceDate();;
  }
  
  public static void selectGLDate() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objCreditorVouchers = new CreditorVouchers(driver);
    CreditorVouchers.clickGLDate();
  }
  
  public static void selectPOInvoiceDate() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objCreditorVouchers = new CreditorVouchers(driver);
    CreditorVouchers.clickdtPOInvoiceDate();
  }
  
  public static void selectPOInvoiceGLDate() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objCreditorVouchers = new CreditorVouchers(driver);
    CreditorVouchers.clickdtPOInvoiceGLDate();
  }
  
  public static void setCreditorNumber(String data) throws FileNotFoundException, InterruptedException {
    objCreditorVouchers = new CreditorVouchers(driver);
    CreditorVouchers.creditorNumber(data);
  }
  
  public static void setPOInvoiceCreditorNumber(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objCreditorVouchers = new CreditorVouchers(driver);
    CreditorVouchers.POInvoiceCreditorNumber(data);
  }
  
  public static void setCRPOInvoiceGLCode(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objCreditorVouchers = new CreditorVouchers(driver);
    CreditorVouchers.glCode(data);
  }
  
  public static void setCRPOInvoiceAnalysisCode(String data) throws FileNotFoundException, InterruptedException {
    objCreditorVouchers = new CreditorVouchers(driver);
    CreditorVouchers.analysisCode(data);
  }
  
  public static void setCRPOInvoiceGoodsAmount(String data) throws FileNotFoundException, InterruptedException {
    objCreditorVouchers = new CreditorVouchers(driver);
    CreditorVouchers.goodsAmount(data);
  }
  
  public static void setCRPOInvoiceVatCode(String data) throws FileNotFoundException, InterruptedException {
    objCreditorVouchers = new CreditorVouchers(driver);
    CreditorVouchers.setVatCode(data);
  }

  public static String storeVoucherNumber() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objCreditorVouchers = new CreditorVouchers(driver);
    waitforPanelElement(CreditorVouchers.txtVoucherNumber);
    return voucherNumber = CreditorVouchers.getVoucherNumber();
  }
  
  public static String storePOVoucherNumber() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objCreditorVouchers = new CreditorVouchers(driver);
    waitforPanelElement(CreditorVouchers.txtSUndryInvoiceVoucherNo);
    return voucherNumber = CreditorVouchers.getPOVoucherNumber();
  }
  
  public static void setVoucherNumber(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objCreditorVouchers = new CreditorVouchers(driver);
    //txtSUndryInvoiceVoucherNo
    waitforPanelElement(CreditorVouchers.txtSUndryInvoiceVoucherNo);
    //waitforPanelElement(CreditorVouchers.txtVoucherNumber);
    CreditorVouchers.voucherNumber(data);
  }
  public static void setCRVoucherNumber(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objCreditorVouchers = new CreditorVouchers(driver);
      CreditorVouchers.setVoucherNUmber(data);
  }
  public static void validatePOInvoiceStatus(String data) throws FileNotFoundException, InterruptedException {
    objCreditorVouchers = new CreditorVouchers(driver);
    waitforPanelElement(CreditorVouchers.txtStatus);
    validateMessageByTag(CreditorVouchers.txtStatus, data);
  }
  public static void validateCRPOInvoiceStatus(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objCreditorVouchers = new CreditorVouchers(driver);
     waitforPanelElement(CreditorVouchers.txtComment);
    validateMessageByTag(CreditorVouchers.txtComment, data);
  }
  
  public static void setCRPOInvoiceComment(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objCreditorVouchers = new CreditorVouchers(driver);
    CreditorVouchers.setComment(data);
    waitforPanelLoad();
  }
  
  public static void setSUndryInvoiceVoucherNo(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objCreditorVouchers = new CreditorVouchers(driver);
    CreditorVouchers.setTxtSUndryInvoiceVoucherNo(data);
  }
  
  public static void setSUndryInvoiceComment(String data) throws FileNotFoundException, InterruptedException {
    objCreditorVouchers = new CreditorVouchers(driver);
    waitforPanelElement(CreditorVouchers.txtSundryInvoiceComment);
    CreditorVouchers.setTxtSUndryInvoiceComment(data);
  }
  
  public static void setCrCreditNoteGlCode(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objCreditorVouchers = new CreditorVouchers(driver);
    CreditorVouchers.setTxtGlCode(data);
  }
  
  public static void setCrCreditNoteAnalysisCode(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objCreditorVouchers = new CreditorVouchers(driver);
    CreditorVouchers.setTxtAnalysisCode(data);
  }
  
  public static void setCrCreditNoteVatCode(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objCreditorVouchers = new CreditorVouchers(driver);
    CreditorVouchers.setDrpdnCreditNoteVatCode(data);
  }
  
  public static void validateCreditNoteStatus(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objCreditorVouchers = new CreditorVouchers(driver);
    waitforPanelElement(CreditorVouchers.txtCreditNoteStatus);
    validateMessageByTag(CreditorVouchers.txtCreditNoteStatus,data);
  }
  
  
   //end of class
}
