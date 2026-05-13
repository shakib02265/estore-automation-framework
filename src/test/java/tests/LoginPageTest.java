package tests;

import base.BaseTest;
import pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void verifyLoginPage() {

        LoginPage page =
                new LoginPage(driver);

        page.open();

        Assert.assertTrue(
                page.isPageLoaded());
    }
}