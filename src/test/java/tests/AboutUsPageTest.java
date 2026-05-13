package tests;

import base.BaseTest;
import pages.AboutUsPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AboutUsPageTest extends BaseTest {

    @Test
    public void verifyAboutUsPage() {

        AboutUsPage page =
                new AboutUsPage(driver);

        page.open();

        Assert.assertTrue(
                page.isPageLoaded());
    }
}