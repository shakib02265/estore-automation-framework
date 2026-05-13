package pages;

import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {

        driver.get(
                "https://estore.link3.net/user/registration");
    }

    public boolean isPageLoaded() {

        return driver.getCurrentUrl()
                .contains("registration");
    }
}