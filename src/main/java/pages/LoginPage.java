package pages;

import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {

        driver.get("https://estore.link3.net/user/login");
    }

    public boolean isPageLoaded() {

        return driver.getCurrentUrl()
                .contains("login");
    }
}