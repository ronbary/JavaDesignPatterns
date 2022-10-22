package org.ronbary.PageComponents;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.ronbary.AbstractComponent.AbstractComponent;

public class FooterNav extends AbstractComponent {

    WebDriver driver;

    By flights = By.cssSelector("[title='Flights']");
    By links = By.cssSelector("a");

    public FooterNav(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    // methods to handle flights
    // scope of selenium in this class should be only in the Footer area

    public String getFlightAttribute()
    {
        return findElement(flights).getAttribute("class");
    }

    public int getLinkCount()
    {
        return findElements(links).size();
    }

}
