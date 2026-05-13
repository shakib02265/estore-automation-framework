package tests;

import base.BaseTest;
import pages.TravelGadgetsPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TravelGadgetsPageTest extends BaseTest {

    @Test
    public void verifyTravelGadgetsPage() {

        TravelGadgetsPage page =
                new TravelGadgetsPage(driver);

        page.open();

        Assert.assertTrue(
                page.isPageLoaded());
    }
}