package tests;

import base.BaseTest;
import pages.PurchaseHistoryPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseHistoryPageTest extends BaseTest {

    @Test
    public void verifyPurchaseHistoryPage() {

        PurchaseHistoryPage page =
                new PurchaseHistoryPage(driver);

        page.open();

        Assert.assertTrue(
                page.isPageLoaded());
    }
}