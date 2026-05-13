package pages;

import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {

        driver.get("https://estore.link3.net/");
    }

    public boolean isPageLoaded() {

        return driver.getCurrentUrl()
                .contains("estore.link3.net");
    }
}