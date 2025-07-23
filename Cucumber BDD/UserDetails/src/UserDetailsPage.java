import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDetailsPage {

  public WebDriver driver;

  /* ========== Web-elements (located by id) ========== */
  @FindBy(id = "name")
  private WebElement nameInput;

  @FindBy(id = "address")
  private WebElement addressInput;

  @FindBy(id = "mobile")
  private WebElement mobileInput;

  @FindBy(id = "email")
  private WebElement emailInput;

  @FindBy(id = "Submit")
  private WebElement submitButton;

  @FindBy(id = "result")
  private WebElement resultElement;

  /* ========== Constructors ========== */
  public UserDetailsPage() {
  } // default (unused)

  public UserDetailsPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  /* ========== Business-methods ========== */
  public void setName(String name) {
    nameInput.clear();
    nameInput.sendKeys(name);
  }

  public void setAddress(String address) {
    addressInput.clear();
    addressInput.sendKeys(address);
  }

  public void setMobileNumber(String mobileNumber) {
    mobileInput.clear();
    mobileInput.sendKeys(mobileNumber);
  }

  public void setEmail(String email) {
    emailInput.clear();
    emailInput.sendKeys(email);
  }

  public void clickSubmitButton() {
    submitButton.click();
  }

  public String getResultText() {
    return resultElement.getText();
  }
}
