package tests;

import base.BaseTest;
import pages.MobileAccessoriesPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileAccessoriesPageTest extends BaseTest {

    @Test
    public void verifyMobileAccessoriesPage() {

        MobileAccessoriesPage page =
                new MobileAccessoriesPage(driver);

        page.open();

        Assert.assertTrue(
                page.isPageLoaded());
    }
}