import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.CellType; // Added import for CellType
import java.io.IOException;

public class ExcelUtils {    //Do not change the class name
	
	//Use this declaration to store values parsed from excel
    public static String[] passengerData=new String[8];
    
    public static String[] readExcelData(String fileName) throws IOException {   //Do not change the method signature
    
        //Implement code to read data from excel file. Store the values in 'passengerData' array. Return the array. */
        File excelFile = new File(fileName);
        FileInputStream fis = new FileInputStream(excelFile);
        
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        // As per the prompt, the sheet name is 'details' and the method signature cannot be changed to accept it.
        XSSFSheet sheet = workbook.getSheet("details"); 
        
        // Assuming data is in the first row (row 0)
        XSSFRow row = sheet.getRow(0);
        
        if (row != null) {
            for (int i = 0; i < passengerData.length; i++) {
                XSSFCell cell = row.getCell(i);
                if (cell != null) {
                    // Set cell type to string to avoid issues with different data types
                    cell.setCellType(CellType.STRING); // Changed to CellType.STRING
                    passengerData[i] = cell.getStringCellValue();
                } else {
                    passengerData[i] = ""; // Handle empty cells if any
                }
            }
        }
        
        workbook.close();
        fis.close();
        
        return passengerData;
    }

}