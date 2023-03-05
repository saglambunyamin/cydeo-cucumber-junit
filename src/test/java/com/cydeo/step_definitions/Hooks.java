package com.cydeo.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

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
    public void teardownScenario () {
        System.out.println("=== Closing browser using cucumber @After ===");
        System.out.println("=== Scenario ended. Take Screenshot if test failed ===");
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
