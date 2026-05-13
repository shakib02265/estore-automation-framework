package pages;

import org.openqa.selenium.WebDriver;

public class SearchPage {

    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {

        driver.get("https://estore.link3.net/search");
    }

    public boolean isPageLoaded() {

        return driver.getCurrentUrl()
                .contains("search");
    }
}