package com.epam.automation.core;

import com.epam.automation.driver.DriverFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base class for all Junit test classes.
 * Instantiates driver, lifecycle methods for test and configuration
 */
public abstract class TestBase {
    private static final Logger logger = LoggerFactory.getLogger(TestBase.class);
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @Before
    public void setupTest() {
        logger.info("Launching " + ConfigProperties.BROWSER + " browser ...");
        driver.set(DriverFactory.getDriver(ConfigProperties.BROWSER));
        getDriver().manage().window().maximize();
        logger.info("Opening " + ConfigProperties.URL + " ...");
        getDriver().get(ConfigProperties.URL);
    }

    @After
    public void tearDown() {
        logger.info("Closing browser ...");
        getDriver().quit();
    }

    @AfterClass
    public static void terminate () {
        driver.remove();
    }

    public WebDriver getDriver() {
        return driver.get();
    }

}
