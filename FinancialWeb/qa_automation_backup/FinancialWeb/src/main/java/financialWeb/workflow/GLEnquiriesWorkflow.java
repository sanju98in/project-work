package financialWeb.workflow;

import java.io.FileNotFoundException;
import financialWeb.pages.GLEnquiries;

public class GLEnquiriesWorkflow extends CommonWorkflow{

  static GLEnquiries objEnquiries;
  
  protected void setDimensionOne(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad(); 
    objEnquiries = new GLEnquiries(driver);
    waitforPanelElement(GLEnquiries.drpdnDimensionOne);
    selectDropDown(GLEnquiries.drpdnDimensionOne, data);
    
  }
  
  protected void setDCLevel(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad(); 
    objEnquiries = new GLEnquiries(driver);
    selectDropDownValue(GLEnquiries.drpdnDCLevel, data);
  }
  
  protected void setDetailCode(String data,String myTable) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad(); 
    objEnquiries = new GLEnquiries(driver);
    GLEnquiries.btnFindDetailCode.click();
    waitforPanelElement(GLEnquiries.txtAnalysisCode);
    setText(GLEnquiries.txtAnalysisCode, data);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    searchAndClickAnchorTextInTableColumn(myTable, data);
    waitforPanelLoad();
    validateMessageByTag(GLEnquiries.txtDetailCode, data);
  }
  
  protected void selectCreateCopyOfEnquiryCheckbox() throws FileNotFoundException, InterruptedException {
    /*
     * waitforPanelLoad(); objEnquiries = new GLEnquiries(driver);
     * checkCheckBox(GLEnquiries.chkCreateCopyOfEnquiry);
     */
    setRandomWebElementChkbx(msgprop.getProperty("lblcreatecopyofenquiry"));
  }
  
  protected void selectCreateCopyOfEnquiryName(String data) throws FileNotFoundException, InterruptedException {
    
    /*
     * waitforPanelLoad(); objEnquiries = new GLEnquiries(driver);
     * waitforPanelElement(GLEnquiries.txtCreateCopyOfEnquiryName);
     * setText(GLEnquiries.txtCreateCopyOfEnquiryName,data);
     */
      setRandomWebElementValue(msgprop.getProperty("lblnewname"), data);
  
  }
    
  protected void getCreateCopyOfEnquiryName(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad(); 
    objEnquiries = new GLEnquiries(driver);
    validateMessageByTag(GLEnquiries.txtEnquiryName, data);
  }
  
  protected String createHighLevelEnquiry() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    searchText(testdataprop.getProperty("searchglhighlevelenquiry"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("searchglhighlevel"));
    Thread.sleep(3000);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    setDimensionOne(testdataprop.getProperty("glenquiriesdimensionone"));
    setDCLevel(testdataprop.getProperty("detailcodedimensionvalue"));
    setDetailCode(analysisCode,orprop.getProperty("gldetailcodesearchtable"));
//    findCostCenter(costCentreCode);
    newEnquiryName = getRandomAlphaNumericValue(testdataprop.getProperty("copyofenquirynamelimit"));
    setRandomWebElementChkbx(msgprop.getProperty("lblcreatecopyofenquiry"));
    setRandomWebElementValue(msgprop.getProperty("lblnewname"), newEnquiryName);
    
    
    //selectCreateCopyOfEnquiryCheckbox();
    //newEnquiryName = getRandomAlphaNumericValue(testdataprop.getProperty("copyofenquirynamelimit"));
    //selectCreateCopyOfEnquiryName(newEnquiryName);
    
    
    
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    //newEnquiry no value is stored on class level so that can be used on different places.
    getCreateCopyOfEnquiryName(newEnquiryName);
    return newEnquiryName;
  }
  
  protected void findHighLevelEnquiryName(String newEnquiryName) throws InterruptedException, FileNotFoundException {
    waitforPanelLoad(); 
    objEnquiries = new GLEnquiries(driver);
    GLEnquiries.txtFindEnquiryName.click();
    Thread.sleep(6000);
    waitforPanelLoad();
    setText(GLEnquiries.txtEnquiryFindName, newEnquiryName);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    findAndClickLinkText(GLEnquiries.tblFindHighLevelEnquiryData, newEnquiryName);
    Thread.sleep(4000);
    waitforPanelLoad();
  }
  
  protected void setHighLevelDesctiption(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad(); 
    objEnquiries = new GLEnquiries(driver);
    waitforPanelElement(GLEnquiries.txtEnquiryDesc);
    setText(GLEnquiries.txtEnquiryDesc, data);
  }
  
  protected void validateHighLevelDesctiption(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad(); 
    objEnquiries = new GLEnquiries(driver);
    waitforPanelElement(GLEnquiries.txtEnquiryDesc);
    validateMessageByTag(GLEnquiries.txtEnquiryDesc, data);
    waitforPanelLoad();
  }
  
  protected void findCostCenter(String costCentreCode) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objEnquiries = new GLEnquiries(driver);
    GLEnquiries.btnFindCostCentre.click();
    waitforPanelLoad();
    setText(GLEnquiries.txtCostCode, costCentreCode);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("submit"));
    findAndClickLinkText(GLEnquiries.tblFindHighLevelEnquiryData, costCentreCode);
    waitforPanelLoad();
  }

  protected void createCopyOfEnquiryName(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad(); 
    objEnquiries = new GLEnquiries(driver);
    checkCheckBox(GLEnquiries.chkCopyOfEnquiry);
    setText(GLEnquiries.txtCopyOfEnquiryName, data);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    waitforPanelLoad();
  }
  
  protected String createCodeLevelEnquiry() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    searchText(testdataprop.getProperty("searchglcodelevelenquiry"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),testdataprop.getProperty("glcodelevel"));
    waitforPanelLoad();
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("load"));
    findCostCenter(costCentreCode);
    String enquiryName = getRandomAlphaNumericValue(testdataprop.getProperty("classificationcodelimit"));
    setRandomWebElementChkbx(msgprop.getProperty("lblcreatecopyofenquiry"));
    setRandomWebElementValue(msgprop.getProperty("lblnewname"), enquiryName);
    callEvent(orprop.getProperty("button"),testdataprop.getProperty("save"));
    //createCopyOfEnquiryName(enquiryName);
    waitforPanelLoad();
    return enquiryName;
  }
}//end of class
