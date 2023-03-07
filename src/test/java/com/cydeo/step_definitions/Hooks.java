package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before (order = 1) //--> import from io.cucumber.java, NOT from Junit
    public void setupScenario () {
        System.out.println("====Setting up browser using cucumber @Before ====");
    }

    @Before (value = "@login", order = 2)
    public void setupScenarioForLogins () {
        System.out.println("====Setting up browser using cucumber @Before ====");
    }

    @Before (value = "@db", order = 0)
    public void setupForDatabaseScenarios () {
        System.out.println("====Setting up browser using cucumber @Before ====");
    }

    @After
    public void teardownScenario (Scenario scenario) {

        byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());

        Driver.closeDriver();
    }

    @BeforeStep
    public void setupStep () {
        System.out.println("-----------> Applying setup using @BeforeStep");
    }

    @AfterStep
    public void afterStep () {
        System.out.println("-----------> Applying teardown using @AfterStep");
    }


}
