package com.automation.framework.runners;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

//import org.apache.commons.lang3.ClassUtils;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

//import com.travelclick.reservation.TestLauncher;
//import com.travelclick.reservation.bean.ConfigurationDetails;
//import com.travelclick.reservation.bean.GridNode;
//import com.travelclick.reservation.constants.ApplicationTypes;
//import com.travelclick.reservation.constants.ReservationConstants;
//import com.travelclick.reservation.logback.LogManager;
//import com.travelclick.reservation.util.ConfigurationDetailsUtil;
//import com.travelclick.reservation.util.EmailSenderUtil;
//import com.travelclick.reservation.util.SuiteListener;


/**
 * This Class is used for generating the testNg.xml file programatically for execution of test methods.
 */

public class DriverTest {

//    public final ConfigurationDetails configurationDetails;
 //   private String runningMode = ReservationConstants.RUNNING_MODE;
    private Map<String, String> mapForMethodAndClasses;
 
    /**
     *  Creates the instance for the configuration details.
     */
    public DriverTest() {
//        configurationDetails = ConfigurationDetailsUtil.getInstance().getConfigurationDetails();
    }

    //public DriverTest(ConfigurationDetails configurationDetails,String testType,String autType,String versionId) {
//        ConfigurationDetailsUtil.getInstance().setConfigurationDetails(configurationDetails,testType,autType,versionId);
//        this.configurationDetails = ConfigurationDetailsUtil.getInstance().getConfigurationDetails();
  //  }
    
    /**
     * Call execute method to generate the testng.xml file
     * @param args Not Used
     */
    public static void main(final String args[]) {
 //       new TestLauncher().execute();
    }
    
    public void setMapForMethodAndClasses(Map<String, String> mapForMethodAndClasses) 
    {
		this.mapForMethodAndClasses = mapForMethodAndClasses;
	}
    

    /**
     * Method to set the configuration to the testNg.xml file and trigger the testng.xml 
     */
    public void execute() {
    	 /*      final TestNG testNG = new TestNG();
        final List<XmlSuite> suites = new ArrayList<XmlSuite>();
       if (configurationDetails != null) {
            final Map<String, GridNode> map = configurationDetails.getGridNodes();
            for (final String key : map.keySet()) {
                suites.add(getSuite(map.get(key)));
            }

            testNG.setXmlSuites(suites);
            testNG.setSuiteThreadPoolSize(map.size());
            testNG.setOutputDirectory(configurationDetails.getOutputLogFileLocation() + File.separator
                    + ReservationConstants.TESTNG_REPORTS_DIR);
            testNG.addListener(new SuiteListener());
            testNG.run();
            // sendNotification(ConfigurationDetailsUtil.getEnvironmentDetails().getOutputLogFileLocation()
            // + Web3Constants.TESTNG_EMAILABLE_REPORT_PATH + Web3Constants.TESTNG_EMAILABLE_REPORT);
        }
        */
    }

    public void sendNotification(final String filePath) {
   //     EmailSenderUtil.sendMail(filePath);
    }

    /** Method to get the xml suite by providing the name of node  
     * @param node Passing the name of the node for the particular browser 
     */
  //  public XmlSuite getSuite(final GridNode node) {
    	/*
        final XmlSuite xmlSuite = new XmlSuite();
        final Map<String, String> suiteParams = new HashMap<String, String>();
        suiteParams.put("nodeName", node.toString());
        xmlSuite.setParameters(suiteParams);
        xmlSuite.setName(node.toString());
        if (ReservationConstants.APPLICATION_TYPE.equalsIgnoreCase(ApplicationTypes.WEB3.name())) {
            xmlSuite.setParallel("methods");
            xmlSuite.setDataProviderThreadCount(configurationDetails.getThreadCount());
        }
        xmlSuite.setThreadCount(configurationDetails.getThreadCount());
        List<XmlTest> xmlTests = getExecutableModules(xmlSuite);
        if (xmlTests != null) 
        {
            xmlSuite.setTests(xmlTests);
        }
        return xmlSuite;
        */
 //   }

    /** Method to get executable modules to testNg.xml
     * @param xmlSuite Need to provide for the particular browser
     * @return list of the tests to be excluded for the particular suite
     */
    /*
    public List<XmlTest> getExecutableModules(final XmlSuite xmlSuite) {
        final List<XmlTest> xmlTests = new ArrayList<XmlTest>();
        try {
            final Map<String, Method> fieldsForConfigurationDetails = getExcuteableTestClasses();
            if (fieldsForConfigurationDetails != null && fieldsForConfigurationDetails.size() > 0) {
                final List<XmlTest> createXmlTests = new ArrayList<XmlTest>();
                final List<XmlTest> modifyXmlTests = new ArrayList<XmlTest>();
                final List<XmlTest> cancelXmlTests = new ArrayList<XmlTest>();
                for (final Entry<String, Method> entry : fieldsForConfigurationDetails.entrySet()) {
                    if (fieldsForConfigurationDetails.get(entry.getKey()).invoke(configurationDetails) != null) {
                        final String reservationType = entry.getKey().toString().substring(0, 1).toUpperCase()
                                + entry.getKey().toString().substring(1);
                        final XmlTest reservationXmlTest = new XmlTest(xmlSuite);
                        final StringBuilder reservationTestSb = new StringBuilder();
                        reservationTestSb.append(ReservationConstants.TEST_MODULE_START_WITH);
                        reservationTestSb.append(reservationType);
                        reservationXmlTest.setName(reservationTestSb.toString());
                        final StringBuilder reservationClassTestSb = new StringBuilder();
                        reservationClassTestSb.append(configurationDetails.getBaseTestClassesPackage());
                        reservationClassTestSb.append(reservationType);
                        reservationXmlTest.setName(reservationTestSb.toString());
                        reservationXmlTest.setPreserveOrder("true");
                        final List<XmlClass> reservationXmlClassesList = new ArrayList<XmlClass>();
                        final XmlClass xmlClass = new XmlClass(reservationClassTestSb.toString().trim());
                        if(runningMode == null || runningMode.equals("") )
                        {
                        	xmlClass.setExcludedMethods(ConfigurationDetailsUtil.getTestMethodExecutableStatus(ClassUtils
                                    .getShortClassName(xmlClass.getName())));	
                        }else if( runningMode.equals("web"))
                        {
                        	xmlClass.setExcludedMethods(getWebTestMethodExecutableStatus(ClassUtils
                                    .getShortClassName(xmlClass.getName())));	
                        }
                        reservationXmlClassesList.add(xmlClass);
                        reservationXmlTest.setXmlClasses(reservationXmlClassesList);
                        if (reservationType.contains(ReservationConstants.MODIFY_RESERVATION)) {
                            modifyXmlTests.add(reservationXmlTest);
                        } else if(reservationType.contains(ReservationConstants.CANCEL_RESERVATION)){
                            cancelXmlTests.add(reservationXmlTest);
                        }else
                        {
                            createXmlTests.add(reservationXmlTest); 
                        }
                    }
                }
                xmlTests.addAll(createXmlTests);
                xmlTests.addAll(modifyXmlTests);
                xmlTests.addAll(cancelXmlTests);
            }
        } catch (final Exception e) {
            LogManager.getLogger().info(" Error in getExecutableModules method :" + e.getMessage());
        }
        return xmlTests;
    }
*/
    /**
     * It is used to add the executable test classes method to testNg.xml file  
     * @return
     */
    /*
    public Map<String, Method> getExcuteableTestClasses() {
        final Map<String, Method> fieldsForConfigurationDetails = new HashMap<String, Method>();
        try {
            final BeanInfo testBeanInfo = Introspector.getBeanInfo(ConfigurationDetails.class);
            for (final PropertyDescriptor propertyDescriptor : testBeanInfo.getPropertyDescriptors()) {
                if (propertyDescriptor.getReadMethod().invoke(configurationDetails, (Object[]) null) != null) {
                    final String filedValue = propertyDescriptor.getReadMethod()
                            .invoke(configurationDetails, (Object[]) null).toString();
                    if ((filedValue.equalsIgnoreCase("true"))) {
                        fieldsForConfigurationDetails.put(propertyDescriptor.getName(),
                                propertyDescriptor.getReadMethod());
                    }
                }
            }
        } catch (final Exception e) {
            LogManager.getLogger().info(" Error in getExcuteableTestClasses method :" + e.getMessage());
        }
        return fieldsForConfigurationDetails;

    }
    */
    private List<String> getWebTestMethodExecutableStatus(String testClassName)
    {
    	List<String> excludedTestMethodList = new ArrayList<String>();
    	for (Entry<String, String> entry : mapForMethodAndClasses.entrySet()) 
    	{
			if (testClassName.equals(entry.getKey().replaceAll("\\s+","")))
			{
				String[] value = entry.getValue().split(",");
				for (int i = 0; i < value.length; i++) {
					excludedTestMethodList.add(value[i]);
				}
			}
		}
    	return excludedTestMethodList;
    }
    //
}
