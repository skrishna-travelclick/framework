package com.automation.framework.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import com.automation.framework.bean.*;


@CucumberOptions(
        features = {"src/test/resources/SalesForceApp"},//path to the features   		
        plugin = {"pretty", "json:target/cucumber.json"},//what formatters to use
        tags = {Configurations.tag}
        )//what tags to incluse(@)/exclude(@~)

public class CukesTest extends AbstractTestNGCucumberTests{

}
