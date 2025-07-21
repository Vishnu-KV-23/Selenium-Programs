import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class LibraryCard {      // DO NOT CHANGE THE CLASS NAME
	
	// Use the below declared variables 
	public static String filePath = null;   //Location of Test data excel file
    public static FileInputStream excelFile;    //FileInputStream
    public static FileOutputStream excelFileOut;    //FileOutputStream
    public static XSSFWorkbook ExcelWBook; //Excel WorkBook
    public static XSSFSheet ExcelWSheet;   //Excel Sheet
    
    public static String[] libraryCard=new String[8];

       
    public static String[] readExcelData(String fileName, String sheetName) throws Exception { // DO NOT CHANGE THE METHOD SIGNATURE
		
	 	// get the excel file path
    	filePath = System.getProperty("user.dir") + File.separator + fileName;

	 	// Implement code to read the Library Card details from the excel sheet using excel fileName and sheetName.
	 	// Note: Handle code for both numeric and string values read from the excel
		
		// Store the excel data in the static variable 'libraryCard' array and return it.
		// Only one row in the excel sheet so keep 'row' as 0. 
		// Store only the column value in the array
		//return null;

    	excelFile = new FileInputStream(filePath);
    	ExcelWBook = new XSSFWorkbook(excelFile);
    	ExcelWSheet = ExcelWBook.getSheet(sheetName);
    	XSSFRow row = ExcelWSheet.getRow(0);
    	for (int i = 0; i < 8; i++) {
            XSSFCell cell = row.getCell(i);

            // Handle both numeric and string values
            if (cell != null) {
                if (cell.getCellType() == CellType.NUMERIC) {
                    // Remove decimal for whole numbers like age or phone
                    libraryCard[i] = String.valueOf((long) cell.getNumericCellValue());
                } else if (cell.getCellType() == CellType.STRING) {
                    libraryCard[i] = cell.getStringCellValue();
                } else {
                    libraryCard[i] = ""; // Handle blank or other types
                }
            } else {
                libraryCard[i] = ""; // If cell is null
            }
        }
    	ExcelWBook.close();
        excelFile.close();

        return libraryCard;
    }


    public static void main(String[] args) throws Exception {   // DO NOT CHANGE THE METHOD SIGNATURE
	    LibraryCard customer = new LibraryCard();
	    
	    String[] data = readExcelData("Card.xlsx","user_details");
	    System.out.println("Excel Data ");
	    for(int i=0; i< data.length; i++){
	        System.out.println(data[i]);
	    }
	        
    }
}
