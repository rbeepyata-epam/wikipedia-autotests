package com.epam.automation.core;

import com.epam.automation.driver.WebDriverHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base class for all page object classes.
 * Initialises driver for pages and holds generic page related code
 */
public abstract class PageBase {
	private static final Logger logger = LoggerFactory.getLogger(PageBase.class);
	
	protected WebDriver driver;
	protected WebDriverHelper webDriverHelper = new WebDriverHelper();

	public PageBase(WebDriver driver){
	    this.driver = driver;
	    this.webDriverHelper.setDriver(driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void scrollDownToPageBottom(){
		Actions actions = new Actions(getDriver());
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
		actions.keyUp(Keys.CONTROL).perform();
	}

}
