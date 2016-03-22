package com.automation.framework.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;

//import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.FilenameUtils;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.automation.framework.bean.Configurations;
import com.automation.framework.constants.SheetIds;
import com.automation.framework.constants.ApplicationConstants;

public class ConfigurationsUtil {

	private XSSFSheet configurationSheet;
//	private static XSSFSheet functionsSheet;
	private static ConfigurationsUtil configurationsUtil = null;	
	
	private static Configurations configurations;
	//private static String runningMode = ReservationConstants.RUNNING_MODE;
	    
	 public Configurations getConfigurations() {
	    	if (configurations == null) {
	      //  	if(runningMode == null || runningMode.equals("") ){
	        		configurationsUtilForDataSource();
	                configurations = getConfigurationFileData();
	      //  }
	         }
	        return configurations;
	 }


	    /**
	     * Action Method to create the Instance for the ConfigurationDetailsUtil
	     * @return ConfigurationDetailsUtil instance
	     */
	    public static ConfigurationsUtil getInstance() {
	        if (configurationsUtil == null) {
	            return configurationsUtil = new ConfigurationsUtil();
	        } else {
	            return configurationsUtil;
	        }

	    }

	    /**
	     * To read the excel configuration file and its sheet id
	     */
	    public void configurationsUtilForDataSource(){
	        FileInputStream fileInputStream = null;
	        XSSFWorkbook workbook = null;
	        try {

	            fileInputStream = new FileInputStream(new File(ApplicationConstants.ENVFILE_PATH));	            
	            // Create Workbook instance holding reference to .xlsx file
	             workbook = new XSSFWorkbook(fileInputStream);
	            // Get first/desired sheet from the workbook
	            configurationSheet = workbook.getSheetAt(SheetIds.ENVIRONMENT_DETAILS_SHEETID.getSheetId());
//	            functionsSheet = workbook.getSheetAt(SheetIds.ENV_FUNCTIONS_SHEETID.getSheetId());
	        } catch (final Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                fileInputStream.close();
	            } catch (final IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    /**
	     * Method to read the data from .xlsx file and populate the environment data environmentList
	     * @return populated configurationDetails bean class from the excel sheet 
	     */
	    private Configurations getConfigurationFileData() {
	        final Configurations configurations = new Configurations();

	        configurations.setHostURL(configurationSheet.getRow(4).getCell(3).getStringCellValue());
	        configurations.setSeleniumHubUrl(configurationSheet.getRow(39).getCell(3).getStringCellValue());
	       // configurations.setThreadCount((int) configurationSheet.getRow(40).getCell(3).getNumericCellValue());
	        
	        return configurations;
	    }

	
}
