package com.phptravels.pages;

import com.phptravels.elements.DatePicker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PhpTravelsHomePage extends BasePage {

    @FindBy(xpath = "//*[@data-name='flights']")
    private WebElement flightSection;

    @FindBy(xpath = "//*[@for='flightSearchRadio-2']")
    private WebElement oneWayRadio;

    @FindBy(xpath = "//*[@for='flightSearchRadio-1']")
    private WebElement roundTripRadio;

    @FindBy(id = "s2id_location_from")
    private WebElement fromClickableField;

    @FindBy(xpath = "//*[@id=\"select2-drop\"]/div/input")
    private WebElement fromDropdown;

    @FindBy(id = "s2id_location_to")
    private WebElement toClickableField;

    @FindBy(xpath = "//*[@id=\"select2-drop\"]/div/input")
    private WebElement toDropdown;

    @FindBy(id = "FlightsDateStart")
    private WebElement departDate;

    @FindBy(id = "FlightsDateEnd")
    private WebElement returnDate;

    @FindBy(xpath = "//*[@id='flights']//*[@type='submit']")
    private WebElement searchButton;

    private DatePicker departDatePicker;

    public PhpTravelsHomePage(WebDriver driver){
        super(driver);
        departDatePicker = new DatePicker(driver);
    }

    public void fillReturnFlightInfo(String fromCity, String destinationCity)
    {
        flightSection.click();
        roundTripRadio.click();
        fromClickableField.click();
        fromDropdown.sendKeys(fromCity);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"select2-drop\"]/ul/li[1]"), fromCity));
        driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul/li[1]")).click();

        toClickableField.click();
        toDropdown.sendKeys(destinationCity);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"select2-drop\"]/ul/li[1]"), destinationCity));
        driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul/li[1]")).click();

        departDatePicker.pickDate(2022, 5, 30);
    }
}
