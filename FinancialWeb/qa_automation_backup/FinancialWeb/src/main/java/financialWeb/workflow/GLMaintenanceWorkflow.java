package financialWeb.workflow;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import financialWeb.pages.DebtorVouchersSalesInvoices;
import financialWeb.pages.GLMaintenance;
import util.GenUtil;

public class GLMaintenanceWorkflow extends CommonWorkflow {

  public static void verifyAndcreateDetailCodeDimension(String data, String desc, String detailCode,
      String detailCodeDesc, String table) throws FileNotFoundException, InterruptedException {
    boolean found = false;
    waitforPanelLoad();
    objGLMaintenance = new GLMaintenance(driver);
    searchText(testdataprop.getProperty("searchgldetailcodedimensions"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchgldetailcodedimensions"));
    waitForElementDisappear();
    while (!found) {
      found = validateDetailCode(detailCode, detailCodeDesc, table);
      if (found) {
        break;
      } else {
        clicklnkDetailCodeDimensions(testdataprop.getProperty("detailcodedimensions"));
        setLevel(testdataprop.getProperty("detailcodedimensionvalue"));
        setDescription(desc);
        callEvent(orprop.getProperty("button"), testdataprop.getProperty("insert"));
        callEvent(orprop.getProperty("button"), testdataprop.getProperty("save"));
        level = getLevel();
        callEvent(orprop.getProperty("button"), testdataprop.getProperty("close"));
        waitforPanelLoad();
        callEvent(orprop.getProperty("button"), testdataprop.getProperty("refresh"));
      }
    }
  }

  private static boolean validateDetailCode(String detailCode, String detailCodeDesc, String table)
      throws InterruptedException {
    boolean found = false;
    List<WebElement> tableList = driver.findElements(By.xpath(table));
    for (WebElement tableData : tableList) {
      List<WebElement> divs = tableData.findElements(By.tagName("div"));
      for (WebElement div : divs) {
        if (div.isDisplayed() && div.getText().trim().equalsIgnoreCase(detailCode.trim())) {
          found = true;
          highlightElement(div);
        } else {
          found = false;
          break;
        }
      }
      if (found) {
        List<WebElement> anchors = tableData.findElements(By.tagName("a"));
        for (WebElement a : anchors) {
          if (a.getText().trim().equalsIgnoreCase(detailCodeDesc.trim())) {
            highlightElement(a);
            found = true;
            break;
          }
        }
        if (found)
          break;
      }
    }
    return found;
  }

  private static String getLevel() throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    waitforPanelElement(GLMaintenance.txtLevel);
    highlightElement(GLMaintenance.txtLevel);
    return GLMaintenance.txtLevel.getAttribute("value").trim();
  }

  private static String getCode() throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    // waitforPanelElement(GLMaintenance.txtCode);
    String code = getRandomWebElementValue(msgprop.getProperty("lblcode"));
    // setRandomWebElementValue(msgprop.getProperty("lblcode"), randomNumber);
    // highlightElement(GLMaintenance.txtCode);
    return code;
  }


  private static void setDescription(String desc)
      throws FileNotFoundException, InterruptedException {
    setRandomWebElementValue(msgprop.getProperty("lbldescription"), desc);
    // objGLMaintenance = new GLMaintenance(driver);
    // setText(GLMaintenance.txtDesc, desc);
  }

  private static void setLevel(String randomNumber)
      throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    waitforPanelElement(GLMaintenance.txtLevel);
    setText(GLMaintenance.txtLevel, randomNumber);
  }

  public static void clicklnkDetailCodeDimensions(String data)
      throws InterruptedException, FileNotFoundException {
    objGLMaintenance = new GLMaintenance(driver);
    waitforPanelLoad();
    if (GLMaintenance.lnkDetailCodeDimensions.getText().trim().equalsIgnoreCase(data)) {
      log.info(KEYWORD_PASS + " Find Element " + GLMaintenance.lnkDetailCodeDimensions.getText());
      GLMaintenance.lnkDetailCodeDimensions.click();
      waitforPanelLoad();
    }

  }

  public static void clickCostCentrebtn(String labelName)
      throws InterruptedException, FileNotFoundException {
    WebElement costCenterTxtbox =
        getRandomWebElement(labelName, orprop.getProperty("costcenrebtn"));
    clickElement(costCenterTxtbox);
  }

  public static String createAnalysisCode(String data, String level, String desc)
      throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    searchText(testdataprop.getProperty("searchgldetailcodeanalysis"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchgldetailcodeanalysis"));
    waitforPanelLoad();
    clicklnkDetailCodeAnalysis(data);
    waitforPanelLoad();
    selectAnalysisLevel(level);
    setDescription(desc);
    randomNumber = GenUtil.getRandomNumber(testdataprop.getProperty("chargecode"));
    setCode(randomNumber);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("save"));
    randomNumber = getCode();
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("close"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("refresh"));
    return randomNumber;
  }

  private static void setCode(String randomNumber)
      throws FileNotFoundException, InterruptedException {
    // objGLMaintenance = new GLMaintenance(driver);
    setRandomWebElementValue(msgprop.getProperty("lblcode"), randomNumber);
  }

  private static void selectAnalysisLevel(String data)
      throws FileNotFoundException, InterruptedException {
    // objGLMaintenance = new GLMaintenance(driver);
    waitforPanelLoad();
    selectRandomWebElementDrpDwn(msgprop.getProperty("lbllevel"), data);
    // waitforPanelElement(GLMaintenance.drpdnAnalysisLevel);
    // selectDropDown(GLMaintenance.drpdnAnalysisLevel, data);
  }

  public static void clicklnkDetailCodeAnalysis(String data)
      throws InterruptedException, FileNotFoundException {
    waitforPanelLoad();
    objGLMaintenance = new GLMaintenance(driver);
    if (GLMaintenance.lnkDetailCodeAnalysis.getText().trim().equalsIgnoreCase(data)) {
      log.info(KEYWORD_PASS + " Find Element " + GLMaintenance.lnkDetailCodeAnalysis.getText());
      GLMaintenance.lnkDetailCodeAnalysis.click();
      waitforPanelLoad();
    }
  }

  public static String createClassificationMaintenanceCode()
      throws FileNotFoundException, InterruptedException {
    /*
     * objGLMaintenance = new GLMaintenance(driver);
     * FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
     */
    objGLMaintenance = new GLMaintenance(driver);
    objFinWebHomePageWorkflow = new FinancialWebHomepageWorkflow();
   // FinancialWebHomepageWorkflow.verifyFinancialsWebMainMenu();
    searchText(testdataprop.getProperty("searchglclassificationcodemaint"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchglclassificationcodemaint"));
    classificationCode = GenUtil.getRandomAlphaNumericValue(testdataprop.getProperty("classificationcodelimit"));
    setClassificationCode(msgprop.getProperty("lblclassificationcode"), classificationCode);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    randomValue = getRandomComment();
    setClassificationCodeMaintenanceDescription(randomValue);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("save"));
    classificationCode = storeClassificationCode(msgprop.getProperty("lblclassificationcode"));
    return classificationCode;
  }

  protected static String storeClassificationCode(String labelCode)
      throws FileNotFoundException, InterruptedException {
    // waitforPanelLoad();
    // getRandomWebElementValue(msgprop.getProperty("lbldetailcode"));
    //// objGLMaintenance = new GLMaintenance(driver);
    // waitforPanelElement(GLMaintenance.txtClasificationCode);
    // highlightElement(GLMaintenance.txtClasificationCode);
    // waitforPanelLoad();
    return getRandomWebElementValue(labelCode);
  }

  protected static void setClassificationCodeMaintenanceDescription(String randomValue)
      throws FileNotFoundException, InterruptedException {
    setRandomWebElementValue(msgprop.getProperty("lbldescription"), randomValue);
    // objGLMaintenance = new GLMaintenance(driver);
    // waitforPanelElement(GLMaintenance.txtClassificationCodeMaintDesc);
    // setText(GLMaintenance.txtClassificationCodeMaintDesc, );
  }

  protected void setNewClassificationCodeMaintenanceDescription(String randomValue)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objGLMaintenance = new GLMaintenance(driver);
    setText(GLMaintenance.txtClassificationCodeMaintNewDesc, randomValue);
  }


  protected void validateNewClassificationCodeMaintenanceDescription(String msg)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objGLMaintenance = new GLMaintenance(driver);
    waitforPanelElement(GLMaintenance.txtClassificationCodeMaintNewDesc);
    validateMessageByTag(GLMaintenance.txtClassificationCodeMaintNewDesc, msg);
  }


  protected void setNewClassificationCodeMaintenanceComment(String randomValue)
      throws FileNotFoundException {
    objGLMaintenance = new GLMaintenance(driver);
    setText(GLMaintenance.txtClassificationCodeMaintNewComment, randomValue);
  }

  protected void validateNewClassificationCodeMaintenanceComment(String msg)
      throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    waitforPanelElement(GLMaintenance.txtClassificationCodeMaintNewComment);
    validateMessageByTag(GLMaintenance.txtClassificationCodeMaintNewComment, msg);
  }



  protected static void setClassificationCode(String randomLabel, String randomNumber)
      throws FileNotFoundException, InterruptedException {
    // objGLMaintenance = new GLMaintenance(driver);
    // setRandomWebElementValue(msgprop.getProperty("lbldetailcode"), randomNumber);
    setRandomWebElementValue(randomLabel, randomNumber);
    // waitforPanelElement(GLMaintenance.txtClasificationCode);
    // waitforPanelElement(GLMaintenance.txtClasificationCode);
    // setText(GLMaintenance.txtClasificationCode, );
  }

  protected void validateDeleteMessage(String msg)
      throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    validateMessage(GLMaintenance.lblDeleteMessage, msg);
  }


  protected void validateInsertionMessage(String msg)
      throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    waitforPanelElement(GLMaintenance.lblInsertionMessage);
    validateMessage(GLMaintenance.lblInsertionMessage, msg);
  }

  protected void validateErrorMessage(String msg)
      throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    waitForElementVisibility(20000, GLMaintenance.imgClose);
    validateMessage(GLMaintenance.lblErrorMessage, msg);
  }

  protected void clickFindClassificationCode() throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    click(GLMaintenance.txtFindClasificationCode);
    waitforPanelLoad();
  }

  protected static void findClassificationMaintenanceCode(String data)
      throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    waitforPanelLoad();
    waitforPanelElement(GLMaintenance.txtSetFindClasificationCode);
    setText(GLMaintenance.txtSetFindClasificationCode, data);
    waitforPanelLoad();
  }

  protected void closeFindClassificationCodesPopuUp()
      throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    waitForElementVisibility(20000, GLMaintenance.imgClose);
    clickElement(GLMaintenance.imgClosePopup);
    waitforPanelLoad();
  }

  protected void setNewCode(String data) throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    waitforPanelElement(GLMaintenance.txtSetNewClasificationCode);
    setText(GLMaintenance.txtSetNewClasificationCode, data);
    waitforPanelLoad();
  }

  protected String storeNewCode() throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    waitForElementVisibility(5000, GLMaintenance.txtSetNewClasificationCode);
    highlightElement(GLMaintenance.txtSetNewClasificationCode);
    return GLMaintenance.txtSetNewClasificationCode.getAttribute("value");
  }

  protected void validateUpdatedClassificationCode(String msg)
      throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    waitforPanelElement(GLMaintenance.txtClasificationCode);
    validateMessageByTag(GLMaintenance.txtClasificationCode, msg);
  }

  protected static void setAccountType(String data)
      throws InterruptedException, FileNotFoundException {
    // objGLMaintenance = new GLMaintenance(driver);
    selectRandomWebElementDrpDwn(msgprop.getProperty("lblaccounttype"), data);
    // selectDropDown(GLMaintenance.drpdnAssetType, );
  }

  protected static void setUnits(String data) throws InterruptedException, FileNotFoundException {
    objGLMaintenance = new GLMaintenance(driver);
    selectRandomWebElementDrpDwn(msgprop.getProperty("lblunits"), data);
    // selectDropDown(GLMaintenance.drpdnUnits, data);
  }

  protected static void clickFindAnalysisLevel()
      throws FileNotFoundException, InterruptedException {
    // objGLMaintenance = new GLMaintenance(driver);
    clickElement(GLMaintenance.btnFindAnalysisLevel);
    waitforPanelLoad();
  }

  protected static void clickLevel(String data) throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    waitforPanelLoad();
    findAndClickLinkText(GLMaintenance.tblFindDetailLevels, data);
  }

  protected static void clickGLDetailCodeMaintenanceAnalysisCode()
      throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    clickElement(GLMaintenance.txtFindAnalysisCode);
  }

  protected static void setGLDetailCodeMaintenanceAnalysisCode(String data)
      throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    waitForPageLoad();
    waitforPanelElement(GLMaintenance.txtAnalysisCode);
    setText(GLMaintenance.txtAnalysisCode, data);
  }

  protected void clickClassificationNote(String data, String code)
      throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    waitforPanelLoad();
    searchAndClickAnchorTextInTableColumn(data, code);
    waitforPanelLoad();
  }

  protected static void clickAnalysisCode(String data, String code)
      throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    waitforPanelLoad();
    searchAndClickAnchorTextInTableColumn(data, code);
    waitforPanelLoad();
  }

  public static String createNewDetailCode() throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    searchText(testdataprop.getProperty("searchgldetailcodemaintenance"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchgldetailcodemaintenance"));
    waitforPanelLoad();
    randomValue =
        GenUtil.getRandomAlphaNumericValue(testdataprop.getProperty("classificationcodelimit"));
    setClassificationCode(msgprop.getProperty("lbldetailcode"), randomValue);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    //setRandomWebElementValue(msgprop.getProperty(""), "");
   randomComment = getRandomComment();
    setClassificationCodeMaintenanceDescription(randomComment);
    setAccountType(testdataprop.getProperty("assettype"));
    setUnits(testdataprop.getProperty("units"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("addline"));
    clickFindAnalysisLevel();
    findClassificationMaintenanceCode(testdataprop.getProperty("detailcodedimensionvalue"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submit"));
    clickLevel(testdataprop.getProperty("detailcodedimensionvalue"));
    clickGLDetailCodeMaintenanceAnalysisCode();
    setGLDetailCodeMaintenanceAnalysisCode(analysisCode);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submit"));
    clickAnalysisCode(orprop.getProperty("finddebtorstablebody"), analysisCode);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("save"));
    return detailCode = storeClassificationCode(msgprop.getProperty("lbldetailcode"));
  }

  public static void verifyAndcreateControlData(String dataSet, String code, String desc,
      String table) throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    objFinWebHomePageWorkflow = new FinancialWebHomepageWorkflow();
    boolean found = false;
    waitforPanelLoad();
    searchText(testdataprop.getProperty("searchglcontroldata"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchglcontroldata"));
    waitforPanelElement(GLMaintenance.drpdnControlDataType);
    selectDropDown(GLMaintenance.drpdnControlDataType,
        testdataprop.getProperty("controldatatypedimension"));
    waitforPanelLoad();
    validateTableExist(GLMaintenance.tblGLControlData);
    found = validateTableData(GLMaintenance.tblGLControlData, code, desc, table);
    if (!found) {
      log.info("Creating new GL Control Data.");
      callEvent(orprop.getProperty("button"), testdataprop.getProperty("insert"));
      waitforPanelElement(GLMaintenance.txtControlDataMaintCode);
      setText(GLMaintenance.txtControlDataMaintCode, code);
      setText(GLMaintenance.txtControlDataMaintDimensionSets, desc);
      clickElement(GLMaintenance.btnInsert);
      waitforPanelLoad();
      waitForElementDisappear();
    } else {
      log.info(KEYWORD_PASS + " GL Control Data already exists.");
    }
    waitforPanelLoad();
  }

  protected void setGLNoteMessageForDetailsCode(String data)
      throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    waitforPanelElement(GLMaintenance.txtMsg);
    setText(GLMaintenance.txtMsg, data);
  }

  protected void setLedgerCode(String data) throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    waitforPanelElement(GLMaintenance.txtLedgerCode);
    setText(GLMaintenance.txtLedgerCode, data);
    waitforPanelLoad();
  }

  protected void setGLFindLedgerCode(String data)
      throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    waitforPanelElement(GLMaintenance.txtGlFindLedgerCode);
    setText(GLMaintenance.txtGlFindLedgerCode, data);
  }

  protected void searchForDetailCodeTab(String table, String data)
      throws FileNotFoundException, InterruptedException {
    searchTableColumn(table, data);
    searchAndClickLatestRecordInTable(table, data);
  }

  public static void validateGridIsAdded(String table, String data)
      throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    searchTableColumn(table, data);
  }

  public static void verifyAndCreateCostCenterDimensions(String analysisSet, String code,
      String desc) throws InterruptedException, IOException {
    boolean found = false;
    objGLMaintenance = new GLMaintenance(driver);
    searchText(testdataprop.getProperty("searchglcostcenterdimension"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchglcostcenterdimension"));
    setAnalysisSet(analysisSet);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submit"));
    List<WebElement> tblCostCentreDimension =
        driver.findElements(By.xpath(orprop.getProperty("tblcostcntrdmnsn")));
    int tblSize = tblCostCentreDimension.size();
    while (tblSize > 0) {
      for (WebElement table : tblCostCentreDimension) {
        found = validateTableExist(table);
        if (found) {
          found = validateDescriptionAndLevelData(table, code, desc);
          if (found)
            break;
        }
      }
      if (found)
        break;
    }
    if (!found) {
      waitforPanelLoad();
      log.info("Creating new GL Control Data.");
      clickElement(GLMaintenance.lnkDetailCodeAnalysis);
      waitforPanelLoad();
      setText(GLMaintenance.txtControlDataMaintCode, code);
      randomValue = getRandomAlphaNumericValue(testdataprop.getProperty("chargecode"));
      String testcostcentredimensiondesc = desc + randomValue;
      setText(GLMaintenance.txtControlDataMaintDimensionSets, testcostcentredimensiondesc);
      setpropertyvalue("testcostcentredimensiondesc", testcostcentredimensiondesc);
      clickElement(GLMaintenance.btnInsert);
      waitforPanelLoad();
      callEvent(orprop.getProperty("button"), testdataprop.getProperty("close"));
      waitForElementDisappear();
      callEvent(orprop.getProperty("button"), testdataprop.getProperty("refresh"));
      waitforPanelLoad();
    } else {
      log.info(KEYWORD_PASS + " GL Control Data already exists.");
    }
    waitforPanelLoad();
  }

  public static boolean validateDescriptionAndLevelData(WebElement element, String code,
      String desc) throws InterruptedException, IOException {
    boolean found = false;
    waitforPanelLoad();
    objGLMaintenance = new GLMaintenance(driver);
    List<WebElement> rows = element.findElements(By.tagName("tr"));
    int size = rows.size();
    for (int rnum = 0; rnum < size; rnum++) {
      List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
      for (int i = 0; i < columns.size(); i++) {
        log.info(columns.get(i).getText());
        if (columns.get(i).getText().contains(code)) {
          highlightElement(columns.get(i));
          List<WebElement> anchors = rows.get(rnum).findElements(By.tagName("a"));
          for (WebElement anchor : anchors) {
            log.info(anchor.getText().trim());
            log.info(desc.trim());
            if (anchor.getText().trim().contains(desc.trim())) {
              clickElement(anchor);
              break;
            }
          }
          waitforPanelLoad();
          waitforPanelElement(GLMaintenance.txtControlDataMaintCode);
          GLMaintenance.txtControlDataMaintCode.clear();
          randomValue = getRandomAlphaNumericValue(testdataprop.getProperty("chargecode"));
          String testcostcentredimensiondesc = desc.trim() + randomValue.trim();
          setText(GLMaintenance.txtControlDataMaintCode, testcostcentredimensiondesc);
          setpropertyvalue("testcostcentredimensiondesc", testcostcentredimensiondesc);
          callEvent(orprop.getProperty("button"), testdataprop.getProperty("save"));
          Thread.sleep(2000);
          callEvent(orprop.getProperty("button"), testdataprop.getProperty("close"));
          callEvent(orprop.getProperty("button"), testdataprop.getProperty("refresh"));
          found = true;
          break;
        }
      }
      if (found)
        break;
    }
    return found;
  }

  private static void setAnalysisSet(String analysisSet)
      throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    selectDropDown(GLMaintenance.drpdnAnalysisSet, analysisSet);
  }

  public static String createCostCentreAnalysis(String analysisSet, String level, String desc)
      throws FileNotFoundException, InterruptedException {

    waitforPanelLoad();
    objGLMaintenance = new GLMaintenance(driver);
    searchText(testdataprop.getProperty("searchglcostcentreanalysis"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchglcostcentreanalysis"));
    costCentreAnalysisSet(analysisSet);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submit"));
    clickElement(GLMaintenance.lnkControlCentrAnalysis);
    waitforPanelLoad();
    setAnalysisLevel(level);
    setCostCentreAnalysisDescription(desc);
    analysisCode = getRandomAlphaNumericValue(testdataprop.getProperty("endindexlimit"));
    setRandomWebElementValue(msgprop.getProperty("lblcode"), analysisCode);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("save"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("close"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("refresh"));
    waitforPanelLoad();
    return analysisCode;
  }

  protected static void costCentreAnalysisSet(String analysisSet)
      throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objGLMaintenance = new GLMaintenance(driver);

    waitforPanelElement(GLMaintenance.drpdnCostCentreAnalysisSet);
    selectDropDown(GLMaintenance.drpdnCostCentreAnalysisSet, analysisSet);
  }

  protected static void setAnalysisLevel(String level)
      throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    waitforPanelElement(GLMaintenance.drpdnLevel);
    selectDropDown(GLMaintenance.drpdnLevel, level);
    waitforPanelLoad();
  }

  protected static void setCostCentreAnalysisDescription(String desc)
      throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    setText(GLMaintenance.txtControlDataMaintDimensionSets, desc);
  }

  protected static String createCostCentreCode()
      throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    costCentreCode = getRandomAlphaNumericValue(testdataprop.getProperty("updatedprice"));
    setText(GLMaintenance.txtClasificationCode, costCentreCode);
    return costCentreCode;
  }

  protected static void setDimensionSet(String dimensionSet)
      throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    selectDropDown(GLMaintenance.drpdnDimensionSet, dimensionSet);
  }

  protected static void clickBtnLevel() throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    clickElement(GLMaintenance.btnLevel);
    waitforPanelLoad();
  }

  protected static void clickBtnAnalysisCode() throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    clickElement(GLMaintenance.btnAnalysisCode);
    waitforPanelLoad();
  }

  protected static void clickBtnAnalysisCod() throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    // clickElement(GLMaintenance.btnAnalysisCode);
     clickElement(GLMaintenance.btnAnalysisCod);
     waitforPanelLoad();
  }
  protected static void setFindCostAnalysisCode(String code)
      throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    waitforPanelElement(GLMaintenance.txtFindCostAnalysisCode);
    setText(GLMaintenance.txtFindCostAnalysisCode, code);
  }

  protected void setNewGlCostCode() throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    String data = getRandomAlphaNumericValue(testdataprop.getProperty("updatedprice"));
    setText(GLMaintenance.txtSetNewClasificationCode, data);
    waitforPanelLoad();
  }

  protected void setGlNoteMsg(String msg) throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    waitforPanelElement(GLMaintenance.txtGlNoteMsg);
    setText(GLMaintenance.txtGlNoteMsg, msg);
  }

  public void clickBrowseAndUploadFile()
      throws InterruptedException, IOException, URISyntaxException {
    waitforPanelLoad();
    objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    String uploadFrame = orprop.getProperty("uploadfileframe");
    switchToFrame(uploadFrame);
    boolean found = false;
    found = DebtorVouchersSalesInvoices.btnBrowser.isDisplayed();
    if (found) {
      highlightElement(DebtorVouchersSalesInvoices.btnBrowser);
      click(DebtorVouchersSalesInvoices.btnBrowser);
    }
    uploadFile(envprop.getProperty("uploadexcelexternalfile"));
    clickUpload();
  }

  public void clickUpload() throws InterruptedException, FileNotFoundException {
    objDebtorVouchersSalesInvoices = new DebtorVouchersSalesInvoices(driver);
    DebtorVouchersSalesInvoices.btnUpload.click();;
  }

  public static String createGLCostCenter() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    searchText(testdataprop.getProperty("searchglcostcentremaintenance"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchglcostcentremaintenance"));
    costCentreCode = createCostCentreCode();
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    setClassificationCodeMaintenanceDescription(testdataprop.getProperty("comment"));
    setDimensionSet(testdataprop.getProperty("costcentreanalysissetcode"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("addline"));
    clickBtnLevel();
    setGLDetailCodeMaintenanceAnalysisCode(testdataprop.getProperty("detailcodedimensionvalue"));//detailcodedimensionvalue
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submit"));
    searchAndClickLatestRecordInTable(orprop.getProperty("finddebtorstablebody"),
        testdataprop.getProperty("detailcodedimensionvalue"));
    clickBtnAnalysisCod();
    setFindCostAnalysisCode(analysisCode);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submit"));
    searchAndClickLatestRecordInTable(orprop.getProperty("finddebtorstablebody"), analysisCode);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("save"));
    waitforPanelLoad();
    return costCentreCode;
  }

  protected String createGLDetailCode() throws FileNotFoundException, InterruptedException {
    searchText(testdataprop.getProperty("searchgldetailcodemaintenance"));
    searchedTextAndValidateSearchMenuResult(orprop.getProperty("menusearchedtext"),
        testdataprop.getProperty("searchgldetailcodemaintenance"));
    waitforPanelLoad();
    randomValue =
        GenUtil.getRandomAlphaNumericValue(testdataprop.getProperty("classificationcodelimit"));
    setClassificationCode(msgprop.getProperty("lbldetailcode"), randomValue);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("load"));
    randomComment = getRandomComment();
    setClassificationCodeMaintenanceDescription(randomComment);
    setAccountType(testdataprop.getProperty("assettype"));
    setUnits(testdataprop.getProperty("units"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("insert"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("addline"));
    clickFindAnalysisLevel();
    findClassificationMaintenanceCode(testdataprop.getProperty("detailcodedimensionvalue"));
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submit"));
    clickLevel(testdataprop.getProperty("detailcodedimensionvalue"));
    clickGLDetailCodeMaintenanceAnalysisCode();
    setGLDetailCodeMaintenanceAnalysisCode(randomNumber);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("submit"));
    clickAnalysisCode(orprop.getProperty("finddebtorstablebody"), randomNumber);
    callEvent(orprop.getProperty("button"), testdataprop.getProperty("save"));
    // field of detail code and classification code are same
    detailCode = storeClassificationCode(msgprop.getProperty("lbldetailcode"));
    return detailCode;
  }

  public static void findCode(String data) throws FileNotFoundException, InterruptedException {
    objGLMaintenance = new GLMaintenance(driver);
    setText(GLMaintenance.txtGLFindCode, data);
    waitforPanelLoad();
  }

  /*
   * public void setDrpdnTransaction(String data) throws InterruptedException, FileNotFoundException
   * { objGLMaintenance = new GLMaintenance(driver); selectDropDown(GLMaintenance.drpdnTransaction,
   * data); }
   * 
   * public void setDrpdnReversalJournalTransaction(String data) throws InterruptedException,
   * FileNotFoundException { objGLMaintenance = new GLMaintenance(driver);
   * selectDropDown(GLMaintenance.drpdnRevarsalJournalTransaction, data); }
   * 
   * public void validateStandardJournalDepartment(String data) throws FileNotFoundException,
   * InterruptedException { objGLMaintenance = new GLMaintenance(driver);
   * waitforPanelElement(GLMaintenance.drpdnStandardJournalDepartment); String actuals =
   * GLMaintenance.getDrpdnStandardJournalDepartment(); if (actuals.equalsIgnoreCase(data)) {
   * log.info("Pass: Department field value is " + actuals);
   * highlightElement(GLMaintenance.drpdnStandardJournalDepartment); } else
   * log.info("Fail: Department field value is " + actuals); }
   * 
   * public void validateStandardJournalSection(String data) throws FileNotFoundException,
   * InterruptedException { objGLMaintenance = new GLMaintenance(driver);
   * waitforPanelElement(GLMaintenance.drpdnStandardJournalSection); String actuals =
   * GLMaintenance.getDrpdnStandardJournalSection(); if (actuals.equalsIgnoreCase(data)) {
   * log.info("Pass: Section field value is " + actuals);
   * highlightElement(GLMaintenance.drpdnStandardJournalSection); } else
   * log.info("Fail: Section field value is " + actuals); }
   * 
   * protected void clickFindLedgerCode() throws FileNotFoundException, InterruptedException {
   * objGLMaintenance = new GLMaintenance(driver); clickElement(GLMaintenance.btnFindLedgerCode);
   * waitforPanelLoad(); }
   * 
   * protected void clickStandardJournalDate() throws FileNotFoundException, InterruptedException {
   * objGLMaintenance = new GLMaintenance(driver);
   * clickElement(GLMaintenance.dtStandardJournalDate); Thread.sleep(2000); }
   * 
   * protected void setStandardJournalLedgerCode(String data) throws FileNotFoundException,
   * InterruptedException { objGLMaintenance = new GLMaintenance(driver); waitforPanelLoad();
   * waitforPanelElement(GLMaintenance.txtFindLedgerCodeDebit);
   * setText(GLMaintenance.txtFindLedgerCodeDebit, data); waitforPanelLoad(); }
   * 
   * protected void setStandardJournalLedgerCodeCredit(String data) throws FileNotFoundException,
   * InterruptedException { objGLMaintenance = new GLMaintenance(driver); waitforPanelLoad();
   * waitforPanelElement(GLMaintenance.txtFindLedgerCodeCredit);
   * setText(GLMaintenance.txtFindLedgerCodeCredit, data); waitforPanelLoad(); }
   * 
   * protected void setStandardJournalDebit(String data) throws FileNotFoundException,
   * InterruptedException { objGLMaintenance = new GLMaintenance(driver); waitforPanelLoad();
   * waitforPanelElement(GLMaintenance.txtFindDebit); setText(GLMaintenance.txtFindDebit, data);
   * waitforPanelLoad(); }
   * 
   * protected void setStandardJournalCredit(String data) throws FileNotFoundException,
   * InterruptedException { objGLMaintenance = new GLMaintenance(driver); waitforPanelLoad();
   * waitforPanelElement(GLMaintenance.txtFindCredit); setText(GLMaintenance.txtFindCredit, data);
   * waitforPanelLoad(); }
   * 
   * public String validateStandardJournalNumber() throws FileNotFoundException,
   * InterruptedException { objGLMaintenance = new GLMaintenance(driver);
   * waitforPanelElement(GLMaintenance.txtJournalNumber); String JournalNumber =
   * GLMaintenance.getStandardJournalNumber(); return JournalNumber; }
   * 
   * protected void validateStandardJournalStatus(String data) throws FileNotFoundException,
   * InterruptedException { objGLMaintenance = new GLMaintenance(driver); WaitForElementDisapper();
   * waitforPanelElement(GLMaintenance.txtStandardJournalStatus);
   * validateMessageByTag(GLMaintenance.txtStandardJournalStatus, data); } public void
   * setDrpdnFindTransaction(String data) throws InterruptedException, FileNotFoundException {
   * objGLMaintenance = new GLMaintenance(driver);
   * selectDropDown(GLMaintenance.drpdnFindTransaction, data); }
   * 
   * public void setDrpdnFindJournalType(String data) throws InterruptedException,
   * FileNotFoundException { objGLMaintenance = new GLMaintenance(driver);
   * selectDropDown(GLMaintenance.drpdnFindJournalType, data); }
   * 
   * protected void setJournalNumberforReversal(String data) throws FileNotFoundException,
   * InterruptedException { objGLMaintenance = new GLMaintenance(driver); waitforPanelLoad();
   * waitforPanelElement(GLMaintenance.txtFindJournalHeaderforReversalNumber);
   * setText(GLMaintenance.txtFindJournalHeaderforReversalNumber, data); waitforPanelLoad(); }
   * 
   * public void validateJournalNoToReverse(String data) throws FileNotFoundException,
   * InterruptedException { objGLMaintenance = new GLMaintenance(driver);
   * waitforPanelElement(GLMaintenance.txtJournalNotoReverse); String actuals =
   * GLMaintenance.getJournalNotoReversal(); if (actuals.equalsIgnoreCase(data)) {
   * log.info("Pass: Section field value is " + actuals);
   * highlightElement(GLMaintenance.txtJournalNotoReverse); } else
   * log.info("Fail: Section field value is " + actuals); }
   * 
   * protected void validateReversalJournalStatus(String data) throws FileNotFoundException,
   * InterruptedException { objGLMaintenance = new GLMaintenance(driver); WaitForElementDisapper();
   * waitforPanelElement(GLMaintenance.txtReversalJournalStatus); reversalJournalStatus =
   * GLMaintenance.getReversalJournalStatus(); if (reversalJournalStatus.equalsIgnoreCase(data)) {
   * highlightElement(GLMaintenance.txtReversalJournalStatus);
   * log.info("Pass: Creditor status field value is " + reversalJournalStatus); } else
   * log.info("Fail: Creditor status field value is " + reversalJournalStatus); }
   */
}// end of class
