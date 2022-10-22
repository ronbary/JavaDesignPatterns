package org.ronbary.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.ronbary.AbstractComponent.AbstractComponent;
import org.ronbary.AbstractComponent.ISearchFlightAvailability;

import java.util.HashMap;
import java.util.function.Consumer;

public class RoundTrip extends AbstractComponent implements ISearchFlightAvailability {

    private By rdo = By.id("ctl00_mainContent_rbtnl_Trip_1");
    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By cb = By.id("ctl00_mainContent_chk_IndArm");
    private By search = By.id("ctl00_mainContent_btn_FindFlights");

    public RoundTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvailability(HashMap<String,String> reservationDetails) {

        // using the "Execute around pattern"
        // and passing the "selectOriginCity" method to be executed from inside makeStateReady
        makeStateReady(s->selectOriginCity(reservationDetails.get("origin")));

        selectDestinationCity(reservationDetails.get("destination"));
        findElement(cb).click();
        findElement(search).click();

    }

    public void selectOriginCity(String origin){

        findElement(from).click();
        findElement(By.xpath("//a[@value='" + origin + "']")).click();
    }

    public void selectDestinationCity(String destination){

        findElement(to).click();
        findElement(By.xpath("(//a[@value='" + destination + "'])[2]")).click();


    }

    public void makeStateReady(Consumer<RoundTrip> consumer){

        System.out.println("I'm inside round trip");
        findElement(rdo).click();
        findElement(from).click();

        // this is generic execution using execute around pattern
        consumer.accept(this);
        System.out.println("am done");





        //common prerequistes code
        //execute actual function-Book/calendar
        //tear down method

    }
}
