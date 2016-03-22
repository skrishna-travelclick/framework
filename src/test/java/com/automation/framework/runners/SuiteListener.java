package com.automation.framework.runners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

//import com.automation.framework.bean.GridNode;
//import com.travelclick.reservation.logback.LogManager;

/**
 * Listener Class to initialize the logger and set the name of thread with the node name 
 */
public class SuiteListener implements ISuiteListener {

  //  @Override
    public void onStart(final ISuite iSuite) {
        final String suiteName = getSuiteName(iSuite);
  //      final GridNode gridNode = ConfigurationDetailsUtil.getInstance().getConfigurationDetails().getGridNodes()
  //              .get(suiteName);

        Thread.currentThread().setName(suiteName);
//        LogManager.initializeSuiteLogger(gridNode.getLogDirPath(), suiteName);
//        LogManager.getLogger().info("Suite Execution has started : " + suiteName);
    }

   // @Override
    public void onFinish(final ISuite iSuite) {
//        LogManager.getLogger().info("Suite Execution has finished : " + getSuiteName(iSuite));
    }

    private String getSuiteName(final ISuite iSuite) {
        return iSuite.getName().replace("Suite", "").trim();
    }
}