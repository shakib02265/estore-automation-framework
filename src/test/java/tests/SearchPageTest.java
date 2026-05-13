package tests;

import base.BaseTest;
import pages.SearchPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchPageTest extends BaseTest {

    @Test
    public void verifySearchPage() {

        SearchPage page =
                new SearchPage(driver);

        page.open();

        Assert.assertTrue(
                page.isPageLoaded());
    }
}