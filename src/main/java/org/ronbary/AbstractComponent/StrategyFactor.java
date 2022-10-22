package org.ronbary.AbstractComponent;


/*
implement factory pattern over strategy
to create : MultiTrip or RoundTrip
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.ronbary.PageComponents.MultiTrip;
import org.ronbary.PageComponents.RoundTrip;

public class StrategyFactor {

    WebDriver driver;
    By sectionElement = By.id("flightSearchContainer");

    public StrategyFactor(WebDriver driver) {
        this.driver = driver;
    }

    // the factory method according to the strategy
    public ISearchFlightAvailability createStrategy(String strategyType){

        if (strategyType.equalsIgnoreCase("multitrip"))
        {
            return new MultiTrip(driver,sectionElement);
        }
        if (strategyType.equalsIgnoreCase("roundtrip"))
        {
            return new RoundTrip(driver,sectionElement);
        }

        return null;

    }




}
