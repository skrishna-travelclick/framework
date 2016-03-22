package com.automation.framework.util;

import java.io.File;
import java.net.URISyntaxException;

public class FileUtil {

	  public static File getFile(String filename) throws URISyntaxException {
	        File file = new File(filename);
	        if (!file.exists()){
	        	file = new File(FileUtil.class.getClassLoader().getResource(filename).toURI());
	        }
	        return (file != null && file.exists() ? file : null);
	    }
	  
}
