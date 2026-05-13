package tests;

import base.BaseTest;
import pages.AllShopsPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AllShopsPageTest extends BaseTest {

    @Test
    public void verifyAllShopsPage() {

        AllShopsPage page =
                new AllShopsPage(driver);

        page.open();

        Assert.assertTrue(
                page.isPageLoaded());
    }
}