package mypack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.ss.usermodel.CellType;


public class ExcelUtils {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static FileInputStream excelFile;
	private static String filePath;
	
	public static String[][] contactData=new String[1][6];
	
	
	
	public static String[][] readExcelData(String fileName, String sheetName) throws Exception {//Do not change method signature
	
		// Implement code to read the contact details from the excel sheet using excel fileName and sheetName.
	    // Note:Handle code for both numeric and string values read from the excel
		
		filePath = fileName;
		File file = new File(filePath);
		excelFile = new FileInputStream(file);
		ExcelWBook = new XSSFWorkbook(excelFile);
		ExcelWSheet = ExcelWBook.getSheet(sheetName);

		XSSFRow row = ExcelWSheet.getRow(0); // Only one row as per instructions

		for (int i = 0; i < 6; i++) { // 6 columns as per requirements (NickName, Contact Name, Company, City, Country, Type)
			XSSFCell cell = row.getCell(i);
			if (cell != null) {
				if (cell.getCellType() == CellType.STRING) {
					contactData[0][i] = cell.getStringCellValue();
				} else if (cell.getCellType() == CellType.NUMERIC) {
					contactData[0][i] = String.valueOf((long) cell.getNumericCellValue());
				}
			} else {
				contactData[0][i] = ""; // Handle empty cells
			}
		}
		
		// Store the excel data in the static variable 'libraryCard' array and return it.
		// Only one row in the excel sheet so keep 'row' as 0. 
		// Store only the column value in the array

        return contactData;
        
	}

    	  	  		 	     	     	      	 	


}