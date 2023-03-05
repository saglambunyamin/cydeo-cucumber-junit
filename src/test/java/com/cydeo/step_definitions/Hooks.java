package com.cydeo.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before //--> import from io.cucumber.java, NOT from Junit
    public void setupScenario () {
        System.out.println("====Setting up browser using cucumber @Before ====");
    }

    @After
    public void teardownScenario () {
        System.out.println("=== Closing browser using cucumber @After ===");
        System.out.println("=== Scenario ended. Take Screenshot if test failed ===");
    }

}
