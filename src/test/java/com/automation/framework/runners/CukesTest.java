package com.automation.framework.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/features/"},//path to the features
        glue = {"com.automation.framework.step_definitions"},
        plugin = {"pretty", "json:target/cucumber.json"},//what formatters to use
        tags = {"@login"}
        )//what tags to incluse(@)/exclude(@~)

public class CukesTest extends AbstractTestNGCucumberTests{

}
