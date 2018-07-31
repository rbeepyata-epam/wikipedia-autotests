package org.wikipedia.pages;

import com.epam.automation.core.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ArticlePage extends PageBase {

    public ArticlePage(WebDriver driver){
        super(driver);
    }

    public static class Locators{
        static final String GENERIC_LINK_XPATH = "//a[text()='%%']";
        static final String REPLACE_TOKEN = "%%";
        static final String GENERIC_SHOW_LINK_IN_NAVBOX_XPATH = "//th[@class='navbox-title'][descendant::a[text()='%%']]//a[text()='show']";
        static final String GENERIC_HIDE_LINK_IN_NAVBOX_XPATH = "//th[@class='navbox-title'][descendant::a[text()='%%']]//a[text()='hide']";
        static final String GENERIC_TABLE_NAVBOX_XPATH = "//table[descendant::a[text()='%%']]";
        static final String GENERIC_ROW_IN_NAVBOX_XPATH = "/tbody/tr[descendant::th[@class='navbox-group'][descendant::*[contains(text(),'%%')]]]";
        static final String ITEMS_IN_ROW_NAVBOX_XPATH = "//ul//li//a";
        static final String LABEL_FIRST_HEADING_XPATH = "//*[@id='firstHeading']";
    }

    @FindBy(xpath = Locators.LABEL_FIRST_HEADING_XPATH)
    private WebElement labelFirstHeading;

    public void clickOnLinkWithTitle(String title){
        WebElement link = getDriver()
                .findElement(By.xpath(Locators.GENERIC_LINK_XPATH.replace(Locators.REPLACE_TOKEN, title)));
        link.click();
    }

    public void expandNavigationBoxByTitleName(String title){
        WebElement showLink = getDriver()
                .findElement(By.xpath(Locators.GENERIC_SHOW_LINK_IN_NAVBOX_XPATH.replace(Locators.REPLACE_TOKEN, title)));
        showLink.click();
        webDriverHelper.waitForElementToBeVisible(By.xpath(Locators.GENERIC_HIDE_LINK_IN_NAVBOX_XPATH.replace(Locators.REPLACE_TOKEN, title)));
    }


    public void clickOnItemInNavigationBox(String title, String rowName, String itemText){
        String table = Locators.GENERIC_TABLE_NAVBOX_XPATH.replace(Locators.REPLACE_TOKEN, title);
        String row = Locators.GENERIC_ROW_IN_NAVBOX_XPATH.replace(Locators.REPLACE_TOKEN, rowName);
        String items = table + row + Locators.ITEMS_IN_ROW_NAVBOX_XPATH;
        List<WebElement> itemsList = getDriver().findElements(By.xpath(items));

        for (WebElement item: itemsList) {
            if (item.getText().equals(itemText)){
                item.click();
                break;
            }
        }
        webDriverHelper.waitForElementToBeVisible(labelFirstHeading);
    }

    public boolean verifyFirstHeading(String firstHeading){
        return labelFirstHeading.getText().equals(firstHeading);
    }
}
