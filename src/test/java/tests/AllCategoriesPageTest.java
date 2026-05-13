package tests;

import base.BaseTest;
import pages.AllCategoriesPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AllCategoriesPageTest extends BaseTest {

    @Test
    public void verifyAllCategoriesPage() {

        AllCategoriesPage page =
                new AllCategoriesPage(driver);

        page.open();

        Assert.assertTrue(
                page.isPageLoaded());
    }
}