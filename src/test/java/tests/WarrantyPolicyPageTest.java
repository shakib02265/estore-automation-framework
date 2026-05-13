package tests;

import base.BaseTest;
import pages.WarrantyPolicyPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WarrantyPolicyPageTest extends BaseTest {

    @Test
    public void verifyWarrantyPolicyPage() {

        WarrantyPolicyPage page =
                new WarrantyPolicyPage(driver);

        page.open();

        Assert.assertTrue(
                page.isPageLoaded());
    }
}