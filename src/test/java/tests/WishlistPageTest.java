package tests;

import base.BaseTest;
import pages.WishlistPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WishlistPageTest extends BaseTest {

    @Test
    public void verifyWishlistPage() {

        WishlistPage page =
                new WishlistPage(driver);

        page.open();

        Assert.assertTrue(
                page.isPageLoaded());
    }
}