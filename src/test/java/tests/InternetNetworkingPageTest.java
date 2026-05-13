package tests;

import base.BaseTest;
import pages.InternetNetworkingPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InternetNetworkingPageTest extends BaseTest {

    @Test
    public void verifyInternetNetworkingPage() {

        InternetNetworkingPage page =
                new InternetNetworkingPage(driver);

        page.open();

        Assert.assertTrue(
                page.isPageLoaded());
    }
}