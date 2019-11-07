package com.phptravels.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DatePicker {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id='FlightsDateStart']")
    private WebElement pickerFieldToClick;

    @FindBy(id = "datepickers-container")
    private WebElement pickerContainer;

    @FindBy(xpath = "//*[@id=\"datepickers-container\"]/div[7]/nav/div[1]")
    private WebElement left;

    @FindBy(xpath = "//*[@id=\"datepickers-container\"]/div[7]/nav/div[3]")
    private WebElement right;

    @FindBy(xpath = "//*[@id=\"datepickers-container\"]/div[7]/nav/div[2]")
    private WebElement title;


    public DatePicker(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void pickDate(int year, int month, int day){
        pickerFieldToClick.click();
        title.click();
        selectYear(year);
        selectMonth(month);
        selectDay(day, month);
    }

    private void selectYear(int year){
        WebElement yearElement = driver.findElement(By.xpath("//*[@id=\"datepickers-container\"]/div[7]/nav/div[2]"));
        int tempYear = Integer.parseInt(yearElement.getText());
        while (tempYear < year){
            right.click();
            ++tempYear;
        }
    }

    private void selectMonth(int month) {
        WebElement monthElement = driver.findElement(By.xpath(String.format(
                "//*[@id=\"datepickers-container\"]//*[@class='datepicker--cell datepicker--cell-month' and @data-month='%d']", month)
        ));
        monthElement.click();
    }

    private void selectDay(int day, int month){
        WebElement dayElement = driver.findElement(By.xpath(String.format(
                "//*[@id='datepickers-container']//*[@data-month='%d' and @data-date='%d']", month, day
                )
        ));
        dayElement.click();
    }
}
