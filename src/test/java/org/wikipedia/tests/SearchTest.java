package org.wikipedia.tests;

import com.epam.automation.core.TestBase;
import com.epam.utilities.PropertyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.wikipedia.pages.ArticlePage;
import org.wikipedia.pages.MainPage;

public class SearchTest extends TestBase {

    @Test
    public void testScenarioSearchSoftwareEngineer(){
        PropertyUtil testdata = new PropertyUtil(".\\src\\test\\resources\\testdata\\search-oop-software-engineer.txt");

        MainPage mainPage = new MainPage(getDriver());
        mainPage.search(testdata.get("searchtext") );
        mainPage.selectAnItemFromSearchResults(0);

        ArticlePage articlePage = new ArticlePage(getDriver());
        Assert.assertTrue(getDriver().getCurrentUrl().equals(testdata.get("oop-page-url")));

        articlePage.clickOnLinkWithTitle(testdata.get("link-title"));

        Assert.assertTrue(getDriver().getCurrentUrl().equals(testdata.get("object-oriented-programming-page-url")));

        articlePage.scrollDownToPageBottom();

        articlePage.expandNavigationBoxByTitleName(testdata.get("navigation-box-title"));

        articlePage.clickOnItemInNavigationBox(testdata.get("navigation-box-title"),
                testdata.get("navigation-box-row-name"),
                testdata.get("navigation-box-item-name"));

        Assert.assertTrue(articlePage.verifyFirstHeading(testdata.get("navigation-box-item-name")));

    }

}
