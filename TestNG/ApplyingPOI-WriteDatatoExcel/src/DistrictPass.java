import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class DistrictPass {     //DO NOT change the class name

    public static void writeExcelData() throws Exception  {         //DO NOT change the method signature
	    
	    //Implement code to write the values 'John', 'john@gmail.com', '2317654121' to in the excel sheet
	    //As shown in the image

        String fileName = "EPass.xlsx";
        String sheetName = "TestCase";
        String filePath = System.getProperty("user.dir") + File.separator + fileName;

        XSSFWorkbook workbook = null;
        XSSFSheet sheet;
        File file = new File(filePath);

        // Check if the file exists. If it does, open it; otherwise, create a new workbook.
        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
            fis.close();
        } else {
            workbook = new XSSFWorkbook();
        }

        // Get the sheet. If it exists, get it; otherwise, create a new one.
        sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            sheet = workbook.createSheet(sheetName);
        }

        // Create the first row (row 0)
        XSSFRow row = sheet.createRow(0);

        // Write the data to cells
        XSSFCell cell0 = row.createCell(0);
        cell0.setCellValue("John");

        XSSFCell cell1 = row.createCell(1);
        cell1.setCellValue("john@gmail.com");

        XSSFCell cell2 = row.createCell(2);
        cell2.setCellValue("2317654121");

        // Write the workbook to the file
        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);
        fos.close();
        workbook.close();
    }
    
    public static void main(String[] args) throws Exception { 
        
	    DistrictPass epass = new DistrictPass();
	    
	    //Add required code
        writeExcelData(); // Call the method to write data
        System.out.println("Data successfully written to EPass.xlsx");
	}
}