package org.ronbary.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.ronbary.AbstractComponent.AbstractComponent;
import org.ronbary.AbstractComponent.ISearchFlightAvailability;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponent implements ISearchFlightAvailability {


    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By submit = By.id("ctl00_mainContent_btn_FindFlights");
    private By multiCity_rdo = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By destination_2= By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    private By modalPopup = By.id("MultiCityModelAlert");

    public MultiTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvailability(HashMap<String,String> reservationDetails ) {

        // execute around pattern
        // provide the method to invoke from this class using consumer
        // after the set of operation done
        // in the makeStateReady
        makeStateReady(s->selectOriginCity(reservationDetails.get("origin")));

        selectDestinationCity(reservationDetails.get("destination"));

        // hard coded here not good practice , will fix it later
        selectDestinationCity2(reservationDetails.get("destination2"));
    }


    public void selectOriginCity(String origin)
    {
        findElement(from).click();
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }

    public void selectDestinationCity(String destination)
    {
        findElement(to).click();
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }

    public void selectDestinationCity2(String destination2)
    {
        findElement(destination_2).click();
        findElement(By.xpath("(//a[@value='"+destination2+"'])[3]")).click();
    }

    /*
        write common pre request code before you start calling operation on the page

        can add tear down method also

        Consumer:
        the method information what to execute can be passed using the consumer

     */
    public void makeStateReady(Consumer<MultiTrip> consumer){

        System.out.println("I'm inside Multi trip");
        findElement(multiCity_rdo).click();
        findElement(modalPopup).click();

        waitForElementToDisappear(modalPopup);

        // this is generic execution using execute around pattern
        consumer.accept(this);
        System.out.println("am done");




        //common prerequistes code
        //execute actual function-Book/calendar
        //tear down method

    }

}
