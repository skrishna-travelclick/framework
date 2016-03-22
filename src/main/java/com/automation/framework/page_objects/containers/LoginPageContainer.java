package com.automation.framework.page_objects.containers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.automation.framework.page_objects.BrowserDriver;

public class LoginPageContainer {
	private String validationContainerCSS = "div.dijitValidationContainer";

	@FindBy(how = How.CLASS_NAME, using = "clsPageTitle")
    public WebElement loginPageDiv;
	
	
	@FindBy(how = How.ID, using = "username")
    public WebElement usernameInput;
	
	public WebElement getUsernameValidationDiv(){
		WebElement parent = BrowserDriver.getParent(BrowserDriver.getParent(usernameInput));		
		return parent.findElement(By.cssSelector(validationContainerCSS));
	}

//	@FindBy(how = How.CSS, using = "#LoginPage input[name=password]")
//    public WebElement passwordInput;

	@FindBy(how = How.ID, using = "password")
    public WebElement passwordInput;
	
	public WebElement getPasswordValidationDiv(){
		WebElement parent = BrowserDriver.getParent(BrowserDriver.getParent(passwordInput));
		return parent.findElement(By.cssSelector(validationContainerCSS));
	}
	
	//this doesn't work due to the way dojo constructs buttons...need to find a better solution
//	@FindBy(how = How.CSS, using = "#LoginPage input[name=SubmitLogin]")
//    public WebElement submitButton;
//	@FindBy(how = How.CSS, using = "#LoginPage span[role='button']")
//    public WebElement submitButton;

	@FindBy(how = How.NAME, using = "btnSubmit")
    public WebElement submitButton;

}
