import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import org.junit.Assert;

public class KeywordEngine extends BaseClass {
	static final String filePath = "Keywords.xlsx"; // Assuming Keywords.xlsx is in the project root
	public static String confirmMessage;
	
    public void executeTest(String filePath) throws IOException {
        
    //  It reads test steps from an Excel file and executes them sequentially.

    //  It retrieves the action type, locator type, locator value, and test data from each row.
    
    //  It performs the corresponding actions such as opening a browser, navigating to a URL, interacting with elements (click, sendKeys, selectDropdown).
    
    //  Then, Retrieve the text of a web element, store it in a static variable confirmMessage, and verify that it matches the expected value.
    
    //  Switch case is used to handle different actions dynamically based on the provided input.
    
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0); // Get the first sheet

        // Iterate over rows
        for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Start from 1 to skip header row
            Row row = sheet.getRow(i);
            if (row == null) {
                continue; // Skip empty rows
            }

            String action = row.getCell(0).getStringCellValue();
            String locatorType = "";
            String locatorValue = "";
            String testData = "";

            // Safely get cell values, handling potential nulls or different cell types
            if (row.getCell(1) != null) {
                locatorType = row.getCell(1).getStringCellValue();
            }
            if (row.getCell(2) != null) {
                locatorValue = row.getCell(2).getStringCellValue();
            }
            if (row.getCell(3) != null) {
                testData = row.getCell(3).getStringCellValue();
            }

            switch (action.toLowerCase()) {
                case "openbrowser":
                    openBrowser();
                    break;
                case "navigateto":
                    navigateTo(testData);
                    break;
                case "click":
                    click(locatorType, locatorValue);
                    break;
                case "selectdropdown":
                    selectDropdown(locatorType, locatorValue, testData);
                    break;
                case "sendkeys":
                    sendKeys(locatorType, locatorValue, testData);
                    break;
                case "verifyconfirmmessage":
                    confirmMessage = verifyConfirmMessage(locatorType, locatorValue);
                    Assert.assertEquals(testData, confirmMessage);
                    break;
                case "closebrowser": // Assuming a close browser action might be needed
                    if (driver != null) {
                        driver.quit();
                    }
                    break;
                default:
                    System.out.println("Unknown action: " + action);
                    break;
            }
        }
        workbook.close();
        fis.close();
    }
    
    
    public static void main(String[] args) throws IOException {
        KeywordEngine engine = new KeywordEngine();
        engine.executeTest(filePath);
    }
}
