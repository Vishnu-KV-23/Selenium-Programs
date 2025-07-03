import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExploreTable {

	public static WebDriver driver;
	public static int rowCount, colCount, specificRowCellValues, specificColumnCellValue;
	String baseUrl = "https://webapps.tekstac.com/SeleniumApp1/SmartUniversity/view_dept.html";

	public ExploreTable(WebDriver driver) {
		this.driver = driver;
	}

	public ExploreTable() {
	}

	public WebDriver createDriver() {
		driver = DriverSetup.getDriver();
		driver.get(baseUrl);
		return driver;
	}

	public WebElement sortTable() {
		WebElement sortButton = driver.findElement(By.id("sorttable"));
		sortButton.click();
		return sortButton;
	}

	public List<WebElement> fetchTableData() {
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='sortingTable']/tbody/tr"));
		rowCount = rows.size();
		for (WebElement row : rows) {
			System.out.println(row.getText());
		}
		return rows;
	}

	public List<WebElement> fetchColumnHeader() {
		List<WebElement> headers = driver.findElements(By.xpath("//table[@id='sortingTable']/thead/tr/th"));
		colCount = headers.size();
		for (WebElement header : headers) {
			System.out.println(header.getText());
		}
		return headers;
	}

	public List<WebElement> fetchSpecificRow() {
		List<WebElement> rowData = driver.findElements(By.xpath("//table[@id='sortingTable']/tbody/tr[2]/td"));
		specificRowCellValues = rowData.size();
		for (WebElement cell : rowData) {
			System.out.println(cell.getText());
		}
		return rowData;
	}

	public WebElement fetchSpecificColumn() {
		WebElement cell = driver.findElement(By.xpath("//table[@id='sortingTable']/tbody/tr[3]/td[1]"));
		System.out.println(cell.getText());
		return cell;
	}

	public static void main(String[] args) {
		ExploreTable table = new ExploreTable();
		table.createDriver();
		table.sortTable();
		table.fetchTableData();
		table.fetchColumnHeader();
		table.fetchSpecificRow();
		table.fetchSpecificColumn();
	}
}
