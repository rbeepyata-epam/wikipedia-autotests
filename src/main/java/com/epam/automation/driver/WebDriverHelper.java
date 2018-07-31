package com.epam.automation.driver;

import com.epam.automation.core.ConfigProperties;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverHelper {
    private static final Logger logger = LoggerFactory.getLogger(WebDriverHelper.class);

    private WebDriver driver;
    long timeout = ConfigProperties.TIMEOUT;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementToBeVisible(WebElement webElement){
        Wait<WebDriver> wait;
        try {
            new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(webElement));
        } finally {
        }
    }

    public void waitForElementToBeVisible(By by){
        Wait<WebDriver> wait;
        try {
            new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(by));
        } finally {
        }
    }

    public void waitForElementToBeClickable(WebElement webElement){
        Wait<WebDriver> wait;
        try {
            new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(webElement));
        } finally {
        }
    }

    public void click(WebElement webElement) {
        logger.info("Clicking on the element " + webElement);
        waitForElementToBeClickable(webElement);
        webElement.click();
    }

    public void sendKeys(WebElement webElement, CharSequence... keysToSend) {
        waitForElementToBeClickable(webElement);
        webElement.sendKeys(keysToSend);
    }

    public void goToPageBottom(){
        Actions actions = new Actions(getDriver());
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
        actions.keyUp(Keys.CONTROL).perform();
    }

    public void clear(WebElement webElement) {
        webElement.clear();
    }

    public boolean isSelected(WebElement webElement) {
        return webElement.isSelected();
    }

    public boolean isEnabled(WebElement webElement) {
        return webElement.isEnabled();
    }

    public String getText(WebElement webElement) {
        return webElement.getText();
    }

    public boolean isDisplayed(WebElement webElement) {
        return webElement.isDisplayed();
    }

}
