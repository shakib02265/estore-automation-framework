package tests;

import base.BaseTest;
import pages.LifestyleGadgetsPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LifestyleGadgetsPageTest extends BaseTest {

    @Test
    public void verifyLifestyleGadgetsPage() {

        LifestyleGadgetsPage page =
                new LifestyleGadgetsPage(driver);

        page.open();

        Assert.assertTrue(
                page.isPageLoaded());
    }
}