package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class DbCon extends TestBase {
	
	static String currentDir=System.getProperty("user.dir");
	public static String TESTDATA_SHEET = TestBase.findEnvFilePath+ File.separator;

	static Workbook workbook;
	static Sheet worksheet;
	
	public String path;
	public static FileInputStream file = null;
	public FileOutputStream fileOut = null;
	private static HSSFWorkbook book = null;
	private HSSFSheet sheet = null;
	TestBase objTestBase;
	public DbCon() {
	}
	
	/**
	 * Overloaded Constructor to initialize the excel file for input/output 
	 * @param excelName : Name of excel file to set connection with
	 */
	public DbCon(String excelName) {
		TESTDATA_SHEET = TESTDATA_SHEET + excelName;
		try {
			file = new FileInputStream(TESTDATA_SHEET);
			book = new HSSFWorkbook(file);
			sheet = book.getSheetAt(0);
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** Read and returns the records.
	 * Accepts work sheet and work book name
	 * @param  sheetName Excel worksheet name
	 * @param  excelName Name of excel file Name
	 * @return Two dimension Object that has all data stored in given worksheet of given Excel file
	 */
	public static Object[][] getWorksheetData(String sheetName,String excelName) {
		file = null;
		TestBase.loadEnvDataConfigurations();
		TESTDATA_SHEET = TestBase.findEnvFilePath+ File.separator + excelName;
		try {
			file = new FileInputStream(TESTDATA_SHEET);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		worksheet = workbook.getSheet(sheetName);
		Object[][] data = new Object[worksheet.getLastRowNum()][worksheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < worksheet.getLastRowNum(); i++) {
			for (int k = 0; k < worksheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = worksheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}

	//Check Sheet Exist or not
 	/** Check if the work sheet exists
 	 * @param sheetName : Name of worksheet to check if exist 
 	 * @param excelName : Name of excel file
 	 * @return
 	 * true/false
 	 */
 	public static boolean isWorksheetExist(String sheetName , String excelName) {
 		TestBase.loadEnvDataConfigurations();
		TESTDATA_SHEET = TestBase.findEnvFilePath+ File.separator + excelName;
		try {
			file = new FileInputStream(TESTDATA_SHEET);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			file = new FileInputStream(TESTDATA_SHEET);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int index = book.getSheetIndex(sheetName);
		if (index == -1) {
			index = book.getSheetIndex(sheetName.toUpperCase());
			if (index == -1)
				return false;
			else
				return true;
		} else
			return true;
	}

 	// get row count
 	/** Count no. of rows / records
 	 * @param sheetName : Name of worksheet
 	 * @param excelName : Name of excel file
 	 * @return
 	 * count of rows / records
 	 */
 	public int getRowCount(String sheetName, String excelName) {
		
		TestBase.loadEnvDataConfigurations();
		TESTDATA_SHEET = TestBase.findEnvFilePath+ File.separator + excelName;
		try {
			file = new FileInputStream(TESTDATA_SHEET);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int index = book.getSheetIndex(sheetName);
		try {
			file = new FileInputStream(TESTDATA_SHEET);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (index == -1)
			return 0;
		else {
			int number = sheet.getPhysicalNumberOfRows();
			return number;
		}
	}
 	
 	/** Returns the list of data based on query passed as parameter.
 	 * This utilizes the database configurations as available in env.properties file.
     * @param query : Sql query to be executed in string format
     * @return 
     * List with all records as per query specified 
     */
	public static List<String> getResultList(String query) {
		Statement statement = null;
		Connection conn = null;
		ResultSet res = null;
		List<String> list = new ArrayList<String>();
		try {
			conn = DriverManager.getConnection(
					TestBase.envprop.getProperty("jdbc.driver.url"),
					TestBase.envprop.getProperty("DatabaseUsername"),
					TestBase.envprop.getProperty("DatabasePassword"));

			statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			res = statement.executeQuery(query);
			ResultSetMetaData rsmd = res.getMetaData();
			rsmd.getColumnCount();

			while (res.next()) {
				list.add(res.getString(1));
			}
			statement.close();
			res.close();
			conn.close();
		} catch (SQLException e) {
			log.error("Error while fatching result sets from database " + query + e.getMessage());
		} finally {
			try {
				if (null != conn)
					conn.close();
				if (null != statement)
					statement.close();
				if (null != res)
					res.close();
			} catch (Exception e) { 
		}
	}
	return list;
}

}
