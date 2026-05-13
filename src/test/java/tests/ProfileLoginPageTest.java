package tests;

import base.BaseTest;
import pages.ProfileLoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileLoginPageTest extends BaseTest {

    @Test
    public void verifyProfileLoginPage() {

        ProfileLoginPage page =
                new ProfileLoginPage(driver);

        page.open();

        Assert.assertTrue(
                page.isPageLoaded());
    }
}