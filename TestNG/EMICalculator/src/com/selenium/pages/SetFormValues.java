package com.selenium.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SetFormValues {
    
    private WebDriver driver;

//Do not change the constructor
    public SetFormValues(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "demo")
    WebElement namePrompt;

    @FindBy(id = "amount")
    WebElement amountField;

    @FindBy(id = "year")
    WebElement yearField;

    @FindBy(id = "roi")
    WebElement roiField;

    @FindBy(name = "button") // "calculate" button
    WebElement calculateButton;


    public void setName(String name) {
         // Click on the element to trigger the alert prompt
         // Switch to the alert context
         // Send the provided name to the alert input field
         // Accept the alert to confirm the name input
    	namePrompt.click();
        Alert prompt = driver.switchTo().alert();
        prompt.sendKeys(name);
        prompt.accept();
    }

    public void setAmount(String amt) {
        //locate and fill the input box of the 'Amount' with value passed as parameter
    	amountField.clear();
        amountField.sendKeys(amt);
    }

    public void setYear(String yrs) {
        //locate and fill the input box of the 'Year' with value passed as parameter
    	yearField.clear();
        yearField.sendKeys(yrs);
    }

    public void setROI(String interest) {
        //locate and fill the input box of the 'ROI' with value passed as parameter
    	roiField.clear();
        roiField.sendKeys(interest);
    }

    public void setCalculate() {
        //locate and submit the calcuate button
    	calculateButton.click();
    }

    public void setAlert() {
         //handle and accept the Alert
    	Alert alert = driver.switchTo().alert();
        alert.accept();
    } // Missing closing brace for setAlert() method
} // Missing closing brace for SetFormValues class