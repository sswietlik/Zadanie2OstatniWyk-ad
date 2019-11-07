package com.phptravels.tests;

import com.phptravels.pages.BasePage;
import com.phptravels.pages.PhpTravelsHomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.System.setProperty;

public class FlightReservationTests {

    WebDriver driver;

    @Before
    public void setUp(){
        setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        //driver.quit();
    }

    @Test
    public void reserveOneWayFlightTest(){
        // arrange
        driver.get("https://www.phptravels.net/");
        PhpTravelsHomePage phpTravelsHomePage = new PhpTravelsHomePage(driver);
        String fromCity = "Warsaw";
        String destinationCity = "New York";

        // act
        phpTravelsHomePage.fillReturnFlightInfo(fromCity, destinationCity);

        // assert
    }
}
