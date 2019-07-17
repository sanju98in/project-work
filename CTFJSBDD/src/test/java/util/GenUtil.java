package util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.log4j.PropertyConfigurator;

public class GenUtil extends TestBase{
	//public static final Logger log = Logger.getLogger(GenUtil.class.getName());
	
	/**Create a folder with Time Stamp in the working directory when file path is not specified.
	 */
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
		
	/**Create database connection executes given query and returns the list with result.
	 * @param query : Query to be executed
	 * @return List : and SQL record for executed query
	 * 
	 */

}
