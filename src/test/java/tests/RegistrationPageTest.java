package tests;

import base.BaseTest;
import pages.RegistrationPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationPageTest extends BaseTest {

    @Test
    public void verifyRegistrationPage() {

        RegistrationPage page =
                new RegistrationPage(driver);

        page.open();

        Assert.assertTrue(
                page.isPageLoaded());
    }
}