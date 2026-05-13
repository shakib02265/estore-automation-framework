package pages;

import org.openqa.selenium.WebDriver;

public class ProfileLoginPage {

    private WebDriver driver;

    public ProfileLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {

        driver.get(
                "https://estore.link3.net/user/login?redirect=/user/profile");
    }

    public boolean isPageLoaded() {

        return driver.getCurrentUrl()
                .contains("profile");
    }
}