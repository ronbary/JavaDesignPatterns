package org.ronbary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.ronbary.AbstractComponent.ISearchFlightAvailability;
import org.ronbary.PageComponents.MultiTrip;
import org.ronbary.PageComponents.RoundTrip;
import org.ronbary.PageObjects.TravelHomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class DemoTest extends BaseTest {

    WebDriver driver;
    TravelHomePage travelHomePage;

    @BeforeTest
    public void setup() {
        driver = initializeDriver();
        travelHomePage = new TravelHomePage(driver);
    }


    @Test(dataProvider = "getData")
    public void flightTest(HashMap<String, String> reservationDetails) {
        travelHomePage.goTo();
        System.out.println(travelHomePage.getFooterNav().getFlightAttribute());

        System.out.println(travelHomePage.getHeaderNavigationBar().getFlightAttribute());

        System.out.println(travelHomePage.getFooterNav().getLinkCount());
        System.out.println(travelHomePage.getHeaderNavigationBar().getLinkCount());

        // using Factory pattern
        // check availability sending different strategy to the booking method using Factory pattern
        travelHomePage.setBookingStrategy("multitrip");
        //travelHomePage.setBookingStrategy("roundtrip");

        travelHomePage.checkAvailability(reservationDetails);

//        HashMap<String,String> reservationDetails = new HashMap<>();
//        reservationDetails.put("origin","MAA");
//        reservationDetails.put("destination","HYD");
//        reservationDetails.put("destination2","DEL");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }


    @DataProvider
    //hashmaps,dataprovider, json, jackson,list
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> l = getJsonData(System.getProperty("user.dir") +
                "//src//test//java//org//ronbary//DataLoads//reservationDetails.json");

        return new Object[][]
                {
                        {l.get(0)}, {l.get(1)}
                };
    }

}
