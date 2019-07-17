package util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import au.com.bytecode.opencsv.CSVReader;

public class GenUtil extends TestBase{

  /**Create a folder with Time Stamp in the working directory when file path is not specified.
   * 
   * 
   */
  public static int rowCount ;
  public static void CreateFolderWithTimeStamp()

  {
    Date today = Calendar.getInstance().getTime();

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");

    String folderName = formatter.format(today);
    folderName = System.getProperty("user.dir") + File.separator+folderName;
    log.info("Directory created successfully\n " + folderName );
    File directory = new File(folderName);
    directory.mkdir();
  }

  /**Create a folder with Time Stamp on the path specified by user.
   * @param folderpath : Path where the folder needs to be created
   * 
   * 
   */
  public static void CreateFolderWithTimeStamp(final String folderpath) {

    final File dir = new File(folderpath);
    if (!dir.exists() ) {
      log.error("Cannot create directory on the given file path: " +  folderpath);
    }else {
      Date today = Calendar.getInstance().getTime();
      // (2) create our date "formatter" (the date format we want)
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
      // (3) create a new String using the date format we want
      String folderName = formatter.format(today);
      folderName = dir +"\\" +folderName;
      File Createdir = new File(folderName);
      Createdir.mkdir();
      log.info("New folder created on path " +  folderpath);
    }
  }

  /**Delete all temporary files from java.io.tmpdir
   * @throws UnknownHostException if has UnknownHostException
   */
  public static void deleteTempFile() throws UnknownHostException {
    String property = "java.io.tmpdir";
    String temp = System.getProperty(property);
    File directory = new File(temp);
    try {
      delete(directory);
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(0);
    }
  }

  /** Delete the file specified from path as shared by user
   * @param file : File name along with entire path (e.g. C:\directorypath\filename.ext)
   * @throws IOException if IOException
   */
  public static void delete(File file) throws IOException {
    if (file.isDirectory()) { // directory is empty, then delete it
      if (file.list().length == 0) {
        file.delete();
      } else {
        // list all the directory contents
        String files[] = file.list();
        for (String temp : files) {
          // construct the file structure
          File fileDelete = new File(file, temp);
          // recursive delete
          delete(fileDelete);
        }
        // check the directory again, if empty then delete it
        if (file.list().length == 0) {
          file.delete();
          log.info("Directory is deleted : "
              + file.getAbsolutePath());
        }
      }
    } else {
      // if file, then delete it
      file.delete();
    }
  }


  /**Creates zip and places it at working directory for the file passed by user located under given sourcefilepath   
   * @param sourceFilePath : Path were file is available to be zipped
   * @param sourceFileName : Name of file to be zipped
   */
  public static void zip(String sourceFilePath,String sourceFileName){
    try
    {
      File inFolder=new File(sourceFilePath);
      File outFolder=new File(sourceFileName);
      ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(outFolder)));
      BufferedInputStream in = null;
      byte[] data  = new byte[1000];
      String files[] = inFolder.list();
      for (int i=0; i<files.length; i++)
      {
        in = new BufferedInputStream(new FileInputStream
            (inFolder.getPath() + "/" + files[i]), 1000);
        out.putNextEntry(new ZipEntry(files[i]));
        int count;
        while((count = in.read(data,0,1000)) != -1)
        {
          out.write(data, 0, count);
        }
        out.closeEntry();
      }
      out.flush();
      out.close();

    }
    catch(Exception e){
      e.printStackTrace();
    }
  }

  /**
   * Download the file from given  file path and stores it at download folder under working directory
   * if Download folder is not avialable it will create one.
   * @param href : URL from where the file is to be download
   * @param fileName : Name by which the file will be saved
   * @throws Exception if any exception 
   */
  @SuppressWarnings("resource")
  public static void downloadFile(String href, String fileName) throws Exception{

    PropertyConfigurator.configure(System.getProperty("user.dir") + "log4j.properties");

    URL url = null;
    URLConnection con = null;
    int i;

    url = new URL(href);

    con = url.openConnection();
    File file = new File(".//downnload//" + fileName);
    BufferedInputStream bis = new BufferedInputStream(con.getInputStream());

    BufferedOutputStream bos = new BufferedOutputStream(
        new FileOutputStream(file));
    while ((i = bis.read()) != -1) {
      bos.write(i);
    }
    bos.flush();
    bis.close();

  }

  /*
   * Below method is used to get the latest file from the directory. 
   * It takes the folder path as the parameter and returns the file which is recently added to the folder.
   */

  public static File getLatestFilefromDir(){
    File dir= new File(TestBase.tempDownloadDir);
    File[] files = dir.listFiles();

    if (files == null || files.length == 0) {
      return null;
    }

    File lastModifiedFile = files[0];
    for (int i = 1; i < files.length; i++) {
      if (lastModifiedFile.lastModified() < files[i].lastModified()) {
        lastModifiedFile = files[i];
      }
      log.info(lastModifiedFile);
    }
    return lastModifiedFile;
  }

  /*
   * Below is the method to read the CSV file and get the number of entries present in the exported csv file. 
   * It takes the file name as the parameter
   */

  @SuppressWarnings("resource")
  public static int getRecordsCountInCSV(String csvFileName) {
    int lineNumberCount = 0;
    try {
      if (!csvFileName.isEmpty() || csvFileName != null) {
        String filePath = TestBase.tempDownloadDir+ System.getProperty("file.separator") + csvFileName;
        File file = new File(filePath);
        if (file.exists()) {
          log.info("Downloaded file found : " + csvFileName);
          FileReader fr = new FileReader(file);
          LineNumberReader linenumberreader = new LineNumberReader(fr);
          while (linenumberreader.readLine() != null) {
            lineNumberCount++;
          }
          // To remove the header
          lineNumberCount = lineNumberCount - 1;
          log.info("Total number of lines found in csv : "
              + (lineNumberCount));
          //linenumberreader.close();
        } else {
          log.info("File does not exists");
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return lineNumberCount;
  }

  public static boolean isFileDownloaded(String fileName) {
    boolean flag = false;
    File dir = new File(TestBase.tempDownloadDir);
    File[] dir_contents = dir.listFiles();

    for (int i = 0; i < dir_contents.length; i++) {
      if (dir_contents[i].getName().equals(fileName))
        return flag=true;
    }

    return flag;
  }


  /* Get the newest file for a specific extension */
  @SuppressWarnings("resource")
  public static String getTheLatestDownloadedFile(String ext) {
    dr.manage().deleteAllCookies();
    File theNewestFile = null;
    File dir = new File(TestBase.tempDownloadDir);
    FileFilter fileFilter = new WildcardFileFilter("*." + ext);
    File[] files = dir.listFiles(fileFilter);
    String fileName = null;

    if (files.length > 0) {
      /** The newest file comes first **/
      Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
      theNewestFile = files[0];
      fileName=theNewestFile.getName();
      int rowTotal =0;
      try {
        BufferedReader br = new BufferedReader( new FileReader(theNewestFile));
        String line;
        log.info("Reading all records in csv file ");
        while( (line = br.readLine()) != null ) {
          log.info(line);
          rowTotal +=1;
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
      rowCount = rowTotal-1;
      log.info("Total rows in the table is " + (rowTotal-1));
      
      

    }
    return fileName;
  }
  
  //read contents of files inside zip folder.
  @SuppressWarnings("resource")
  public static void readZipFolderContents(String fileName) {
    try {
      ZipFile zf = new ZipFile(fileName);
      Enumeration<? extends ZipEntry> entries = zf.entries();
      BufferedReader input = new BufferedReader(new InputStreamReader(
        System.in));
    while (entries.hasMoreElements()) {
      ZipEntry ze = (ZipEntry) entries.nextElement();
      log.info("Reading " + ze.getName());
      String inputLine = input.readLine();
      if (inputLine.equalsIgnoreCase("yes")) {
        long size = ze.getSize();
        if (size > 0) {
          log.info("Length is " + size);
          BufferedReader br = new BufferedReader(
              new InputStreamReader(zf.getInputStream(ze)));
          String line;
          while ((line = br.readLine()) != null) {
            log.info(line);
          }
          br.close();
        }
      }
    }
    }
  catch (IOException e) {
    e.printStackTrace();
  }
  }
  
  @SuppressWarnings("resource")
  public static void verifyColumnFromFile(String fileName,String comlumnExist) throws IOException {
    File file = new File(TestBase.tempDownloadDir+ System.getProperty("file.separator") + fileName); 

    CSVReader csvReader = new CSVReader(new FileReader(file));

    List<String[]> content = csvReader.readAll();
    String[] row=null;
    int i=0;
    for (Object object : content) {
      row = (String[]) object;
      if(row[i].equalsIgnoreCase(comlumnExist)) {
        {
          log.info("Column exist in the file " + row[i]);
          break;
        }
      }

    }
  }

  @SuppressWarnings("resource")
  public static void verifyExcelColumn(String fileName,String comlumnExist) throws IOException {
    CSVReader reader = new CSVReader(new FileReader(TestBase.tempDownloadDir+ File.separator + fileName));
    String [] nextLine;
  
    nextLine = reader.readNext();
    getHeaderLocation(nextLine, comlumnExist);
    
  }
  private static void getHeaderLocation(String[] headers, String columnName) {
    for (String header:headers) {
      if(header.equalsIgnoreCase(columnName)) {
        log.info("Pass: Column header " + header + " found in downloaded file");
        break;
      }
    }
 
 }
  
  /*
   * Example of reading Zip archive using ZipFile class
   */

  public static void readUsingZipFile(String fileName) throws IOException {
      final ZipFile file = new ZipFile(TestBase.tempDownloadDir+ File.separator + fileName);
      log.info("Iterating over zip file : " + fileName);

      try {
          final Enumeration<? extends ZipEntry> entries = file.entries();
          while (entries.hasMoreElements()) {
              final ZipEntry entry = entries.nextElement();
              System.out.printf("File: %s Size %d  Modified on %TD %n", entry.getName(), entry.getSize(), new Date(entry.getTime()));
              
          }
      } finally {
          file.close();
      }
  }

  public static ArrayList<String> ReadAllColumnsValuesOfTable(WebElement htmltable, int startsWith, int maxRow) throws InterruptedException {
    log("ReadColumnsValues Started");
    List<WebElement> rows=htmltable.findElements(By.tagName("tr"));
    ArrayList<String> rowValue = new ArrayList<String>();
    rows.get(startsWith).click();
    
    for(int rnum=startsWith;rnum<=maxRow;rnum++)
    {
      
      List<WebElement> columns=rows.get(rnum).findElements(By.tagName("td"));
      for(WebElement column:columns)
      {
        highlightElement(column);
        log.info(column.getText());
        rowValue.add(column.getText());
        }
    }
    waitForPageLoad();
    log("ReadColumnsValues Started");
    return rowValue;
  }
  
  /* Get the newest file for a specific extension */
  @SuppressWarnings("resource")
  public static String getLatestDownloadedFileSize(String csvFileName) {
    dr.manage().deleteAllCookies();
    File theNewestFile = null;
    File dir = new File(TestBase.tempDownloadDir);
    FileFilter fileFilter = new WildcardFileFilter(csvFileName);
    File[] files = dir.listFiles(fileFilter);
    String fileName = null;

    if (files.length > 0) {
      /** The newest file comes first **/
      Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
      theNewestFile = files[0];
      fileName=theNewestFile.getName();
      try {
        BufferedReader br = new BufferedReader( new FileReader(theNewestFile));
        String line;
        log.info("Reading all records in csv file ");
        while( (line = br.readLine()) != null ) {
            // do something with line
            log.info(line);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    }
    return fileName;
  }
  
  public static void dateParser(String dateInString) {
    String pattern = "dd/MM/yyyy";
    SimpleDateFormat formatter = new SimpleDateFormat(pattern);
    

    try {

        Date date = formatter.parse(dateInString);
        log.info(date);
        log.info(formatter.format(date));

    } catch (ParseException e) {
        e.printStackTrace();
    }
  }
  
  public static String additionalDayOfDateFromCurrentDate(String plusNoOfDays) {
    // Get current date
    String DATE_FORMAT = "dd/MMM/yyyy";
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
  //end of class
}
