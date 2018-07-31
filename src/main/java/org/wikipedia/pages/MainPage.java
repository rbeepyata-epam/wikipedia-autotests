package org.wikipedia.pages;

import com.epam.automation.core.PageBase;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends PageBase {

    public MainPage(WebDriver driver){
        super(driver);
    }

    public static class Locators{
        static final String TEXT_BOX_SEARCH_WIKIPEDIA_XPATH = "//*[@id='searchInput']";
        static final String SEARCH_RESULTS_XPATH = "//div[@class='suggestions-results']//a";
    }

    @FindBy(xpath = Locators.TEXT_BOX_SEARCH_WIKIPEDIA_XPATH)
    private WebElement textboxSearchWikipedia;

    public void search(String searchText){
        textboxSearchWikipedia.sendKeys(searchText, Keys.ARROW_DOWN);
        webDriverHelper.waitForElementToBeVisible(By.xpath(Locators.SEARCH_RESULTS_XPATH));
    }

    public void selectAnItemFromSearchResults(int resultItemNumber){
        List<WebElement> searchResults = getDriver().findElements(By.xpath(Locators.SEARCH_RESULTS_XPATH));
        searchResults.get(resultItemNumber).click();
    }

}
