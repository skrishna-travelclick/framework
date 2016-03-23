package com.automation.framework.step_definitions;

import java.util.logging.Logger;

import com.automation.framework.bean.Configurations;
import com.automation.framework.util.ConfigurationsUtil;

//import com.travelclick.insite.NavigatorFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AuthenticationSteps {

	private static final Logger LOGGER = Logger.getLogger(AuthenticationSteps.class.getName());
    private Configurations configurations;
      
    
	@Given("^I navigate to the insite application$")
	public void given_I_navigate_to_the_insite_application(){
		configurations = ConfigurationsUtil.getInstance().getConfigurations();		
		LOGGER.info("Entering: I navigate to the insite application");		
	//	NavigatorFactory.getNavigator().given_I_navigate_to_the_insite_application(configurations.getHostURL());
	}
	
	@When("^I try to login with '(.+)' credentials$")
	public void when_I_try_to_login(String credentialsType){
		LOGGER.info("Entering: I try to login with " + credentialsType + " credentials");
	//	NavigatorFactory.getNavigator().when_I_try_to_login(credentialsType);		
	}
	
	@Then("^I should see that I logged in '(.+)'$")
	public void then_I_login(String outcome){
		LOGGER.info("Entering: I should see that I logged in " + outcome);
	//	NavigatorFactory.getNavigator().then_I_login(outcome);		
	}
	
}
