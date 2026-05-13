package pages;

import org.openqa.selenium.WebDriver;

public class AllShopsPage {

    private WebDriver driver;

    public AllShopsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {

        driver.get("https://estore.link3.net/all-shops");
    }

    public boolean isPageLoaded() {

        return driver.getCurrentUrl()
                .contains("all-shops");
    }
}