package tests;

import base.BaseTest;
import pages.TrackOrderPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TrackOrderPageTest extends BaseTest {

    @Test
    public void verifyTrackOrderPage() {

        TrackOrderPage page =
                new TrackOrderPage(driver);

        page.open();

        Assert.assertTrue(
                page.isPageLoaded());
    }
}