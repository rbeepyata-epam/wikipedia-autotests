package com.epam.automation.core;

import com.epam.utilities.PropertyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ConfigProperties {
    private static final Logger logger = LoggerFactory.getLogger(ConfigProperties.class);
	private static final PropertyUtil PROPERTIES_UTIL = new PropertyUtil(".\\src\\main\\resources\\config.properties");

	public static final String BROWSER = getBrowserName();
    public static final String URL =  PROPERTIES_UTIL.get("url");
    public static final long TIMEOUT =  Long.parseLong(PROPERTIES_UTIL.get("timeout"));

    private static String getBrowserName() {
        String browserName = System.getProperty("browser");
        if (browserName == null || browserName.isEmpty()) {
            logger.info("No browser type specified in the command line! Defaulting to the browser specified in config.properties...");
            browserName = PROPERTIES_UTIL.get("browser");
        }
        if (browserName.equalsIgnoreCase("chrome") || browserName.equalsIgnoreCase("firefox")) {
            return browserName;
        } else {
            throw new RuntimeException(browserName + " is not valid browser name!");
        }
    }
}
