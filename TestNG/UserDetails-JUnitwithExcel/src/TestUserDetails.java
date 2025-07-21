import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class TestUserDetails {

	public static WebDriver driver;
	UserDetails user;
	public static String[] data;
	public static String successMessage;

	public static String file_path;
	public static FileInputStream work_file;
	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;

	String baseUrl = "https://webapps.tekstac.com/Users/";

	@Before
	public void setUp() throws Exception {
		driver = DriverSetup.getWebDriver();
		driver.get(baseUrl);
		user = new UserDetails(driver);
	}

	public static String[] getExcelData() throws Exception {
		return readExcelData("users");
	}

	@Test
	public void testValidUserdetails() throws Exception {
		data = getExcelData();

		user.setName(data[0]);
		user.setAddress(data[1]);
		user.setMobile(data[2]);
		user.setEmail(data[3]);

		user.submit();

		// Wait for form submission result to load
		Thread.sleep(2000);

		successMessage = user.getSuccessMessage();

		// Update this expected message as per your actual page
		String expectedMessage = "User Details Submitted Successfully";

		assertEquals(expectedMessage, successMessage.trim());
	}

	public static String[] readExcelData(String sheetName) throws Exception {
		file_path = "UserDetails.xlsx";
		work_file = new FileInputStream(file_path);
		workbook = new XSSFWorkbook(work_file);
		worksheet = workbook.getSheet(sheetName);

		XSSFRow row = worksheet.getRow(0);
		XSSFCell cell = null;

		String[] user_data = new String[4]; // 4 columns: name, address, mobile, email

		for (int i = 0; i < 4; i++) {
			if (row.getCell(i) == null) {
				user_data[i] = "";
				continue;
			}
			switch (row.getCell(i).getCellType()) {
				case STRING:
					user_data[i] = row.getCell(i).getStringCellValue();
					break;
				case NUMERIC:
					user_data[i] = String.valueOf((long) row.getCell(i).getNumericCellValue());
					break;
				case BLANK:
					user_data[i] = "";
					break;
				default:
					user_data[i] = "";
					break;
			}
			System.out.println(user_data[i]); // Optional: prints the value to console
		}

		workbook.close();
		work_file.close();

		return user_data;
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
