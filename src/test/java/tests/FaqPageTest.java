package tests;

import base.BaseTest;
import pages.FaqPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FaqPageTest extends BaseTest {

    @Test
    public void verifyFaqPage() {

        FaqPage page =
                new FaqPage(driver);

        page.open();

        Assert.assertTrue(
                page.isPageLoaded());
    }
}