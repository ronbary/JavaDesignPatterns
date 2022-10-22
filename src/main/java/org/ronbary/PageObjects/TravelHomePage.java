package org.ronbary.PageObjects;

/*
example for design patterns using the site URL :

https://rahulshettyacademy.com/dropdownsPractise/

 */


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.ronbary.AbstractComponent.ISearchFlightAvailability;
import org.ronbary.AbstractComponent.StrategyFactor;
import org.ronbary.PageComponents.FooterNav;
import org.ronbary.PageComponents.NavigationBar;

import java.util.HashMap;

/*
example how to differentiate between the header and footer sections
and use find element from the sectionElement and not using (driver.findElement)

this will do the trick and give us the exact section element header or footer

 */


public class TravelHomePage
{
    By footerNavSectionElement = By.id("traveller-home");
    By headerNavSectionElement = By.id("buttons");
    WebDriver driver;
    ISearchFlightAvailability searchFlightAvail = null;

    public TravelHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo()
    {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public NavigationBar getHeaderNavigationBar(){

        return new NavigationBar(driver,headerNavSectionElement);
    }

    public FooterNav getFooterNav(){

        return new FooterNav(driver,footerNavSectionElement);
    }

    public void setBookingStrategy(String strategyType){

        StrategyFactor strategyFactor = new StrategyFactor(driver);
        searchFlightAvail = strategyFactor.createStrategy(strategyType);
        this.searchFlightAvail = searchFlightAvail;
    }


    public void checkAvailability(HashMap<String,String> reservationDetails){

        if (searchFlightAvail != null) {
            searchFlightAvail.checkAvailability(reservationDetails);
        }
        else{
            System.out.println("you should provide valid booking strategy !");
        }
    }

    public String getTitle()
    {
        System.out.println("Hello this is new version from Core Framework !!!");
        return driver.getTitle();
    }

}
