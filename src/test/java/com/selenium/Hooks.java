package com.selenium;

import com.selenium.driver.DriverFactory;
import cucumber.api.java.Before;

public class Hooks
{
    private DriverFactory driverManager= new DriverFactory();
    @Before
    public void setUp(){
        driverManager.openBrowser();
        driverManager.maxBrowser();
        driverManager.navigateTo("https://www.argos.co.uk/");
        driverManager.applyImpcitWait();
    }

    // @After
    public void tearDown(){
        driverManager.closeBrowser();
    }
}
