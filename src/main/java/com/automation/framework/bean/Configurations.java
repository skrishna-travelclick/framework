package com.automation.framework.bean;

public class Configurations {
    private String hostURL; 
    private String seleniumHubUrl;
    private static String tags;
    public static final String tag  = "@login";
 //   private int threadCount;

    // private Map<String, GridNode> gridNodes;
    //    private String browserVersion;

    public String getHostURL() {
    	return hostURL;
    }
    
    public void setHostURL(final String hostURL) {
    	this.hostURL = hostURL;
    }
    
    
    public String getSeleniumHubUrl() {
        return seleniumHubUrl;
    }

    public void setSeleniumHubUrl(final String seleniumHubUrl) {
        this.seleniumHubUrl = seleniumHubUrl;
    }
    
    public static String getTags() {
    	return tags;
    }
    
    public void setTags(final String tags) {
    	this.tags = "@login";
    }
    

    
    

    
}