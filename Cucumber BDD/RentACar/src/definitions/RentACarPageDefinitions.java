package definitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import setup.DriverSetup;
import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.CarRentalForm;
import tests.CarType;

public class RentACarPageDefinitions {

    public static WebDriver driver;
    public static String successMessage;
    public static String baseUrl = "https://webapps.tekstac.com/RentaCar/";

    @DataTableType
    public CarRentalForm mapToRentalForm(List<String> entry) {
        return new CarRentalForm(
                entry.get(0), // name
                entry.get(1), // contact number
                entry.get(2), // address
                entry.get(3), // travel date
                entry.get(4), // duration
                entry.get(5), // license number
                entry.get(6) // payment mode
        );
    }

    @ParameterType(".*")
    public CarType carType(String type) {
        return new CarType(type);
    }

    @Given("open the Rent A Car form page")
    public void open_Rent_A_Car_Page() {
        driver = DriverSetup.getDriver();
        driver.get(baseUrl);
    }

    @When("enter rental details")
    public void enter_rental_details(CarRentalForm form) {
        driver.findElement(By.id("name")).sendKeys(form.name);
        driver.findElement(By.id("number")).sendKeys(form.contactNumber);
        driver.findElement(By.id("address")).sendKeys(form.address);

        // Use JS to set travel date
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('traveldate').value='" + form.travelDate + "'");

        driver.findElement(By.id("duration")).sendKeys(form.duration);
        driver.findElement(By.id("license")).sendKeys(form.licenseNumber);

        if (form.paymentMode.equalsIgnoreCase("Net Banking")) {
            driver.findElement(By.id("netbanking")).click();
        } else if (form.paymentMode.equalsIgnoreCase("Cash on Delivery")) {
            driver.findElement(By.id("cod")).click();
        }
    }

    @When("select car type {carType}")
    public void select_car_type(CarType type) {
        Select dropdown = new Select(driver.findElement(By.id("cartype")));
        dropdown.selectByVisibleText(type.carType);
    }

    @Then("submit the form")
    public void submit_the_form() {
        driver.findElement(By.id("submit")).click();
    }

    @Then("get the result")
    public void get_the_result() {
        successMessage = driver.findElement(By.id("result")).getText();
        System.out.println(successMessage);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
