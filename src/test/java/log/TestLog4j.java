package log;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



public class TestLog4j {
	
	public static void main(String[] args) throws Exception {
		PropertyConfigurator.configure("src"+File.separator+"main"+File.separator+"resources"+File.separator+"log4j.xml");
		Logger logger = Logger.getLogger(TestLog4j.class);
		logger.warn("warn123");
		logger.debug("debug123");
		logger.error("error");
    }
}
