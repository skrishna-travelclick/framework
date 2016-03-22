package com.automation.framework.page_objects;

import java.awt.Toolkit;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
//import org.openqa.selenium.ie.InternetExplorerDriver;

import com.automation.framework.constants.ApplicationConstants;

import com.automation.framework.constants.Browsers;
import com.automation.framework.util.ConfigurationsUtil;
import com.automation.framework.bean.Configurations;


public class BrowserFactory {
	
	private static final String BROWSER_PROP_KEY = "browser";	
	private static Configurations configurations;
				
	/**
	 * creates the browser driver specified in the system property "browser"
	 * if no property is set then a firefox browser driver is created.
	 * The allow properties are firefox, safari and chrome
	 * e.g to run with safari, pass in the option -Dbrowser=safari at runtime
	 * @return WebDriver
	 */
	public static WebDriver getBrowser() {
		Browsers browser;
		WebDriver driver = null;
		//Configurations configurations = new Configurations();
		configurations = ConfigurationsUtil.getInstance().getConfigurations();
		
		if(System.getProperty(BROWSER_PROP_KEY)==null){
			browser = Browsers.FIREFOX;
			//browser = Browsers.CHROME;
			//browser = Browsers.IE;
		}else{
			browser = Browsers.browserForName(System.getProperty(BROWSER_PROP_KEY));
		}
		switch(browser){
			case CHROME:
				try {
					driver = createChromeDriver(configurations.getSeleniumHubUrl());
				} catch (MalformedURLException e) {					
					e.printStackTrace();
				}				
				break;
			case IE:				
				try {
					driver = createIEDriver(configurations.getSeleniumHubUrl());
				} catch (MalformedURLException e) {					
					e.printStackTrace();
				}				
				break;
			case FIREFOX:
			default:
				try {					
					driver = createFirefoxDriver(configurations.getSeleniumHubUrl());
				} catch (MalformedURLException e) {					
					e.printStackTrace();
				}
				break;
		}
		addAllBrowserSetup(driver);
		return driver;
	}

	private static WebDriver createIEDriver(String HUB_URL) throws MalformedURLException {
			
		DesiredCapabilities cap = new DesiredCapabilities().internetExplorer();		
		//cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	    	       
	    return new RemoteWebDriver(new URL(HUB_URL), cap);	
	}

	private static WebDriver createChromeDriver(String HUB_URL) throws MalformedURLException 
	{		
	
		DesiredCapabilities cap = new DesiredCapabilities().chrome();		
	    return new RemoteWebDriver(new URL(HUB_URL), cap);	
			
	}
	
	private static WebDriver createFirefoxDriver(String HUB_URL) throws MalformedURLException 
	{
		//if(System.getProperty(ApplicationConstants.RUNNING_MODE)==null){
		if(ApplicationConstants.RUNNING_MODE==null){
			DesiredCapabilities cap = new DesiredCapabilities().firefox();
			//cap.setBrowserName("firefox");
			//cap.setVersion("30.0");
			//cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);		    	       
		    return new RemoteWebDriver(new URL(HUB_URL), cap);
		}else{
			return new FirefoxDriver();
		}
    }

	private static void addAllBrowserSetup(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().setPosition(new Point(0, 0));
        java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dim = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
        driver.manage().window().setSize(dim);
	}

}
