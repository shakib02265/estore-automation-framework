package tests;

import base.BaseTest;
import pages.HomePage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void verifyHomePage() {

        HomePage page =
                new HomePage(driver);

        page.open();

        Assert.assertTrue(
                page.isPageLoaded());
    }
}