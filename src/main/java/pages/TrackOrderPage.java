package pages;

import org.openqa.selenium.WebDriver;

public class TrackOrderPage {

    private WebDriver driver;

    public TrackOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {

        driver.get(
                "https://estore.link3.net/user/login?redirect=/track-order");
    }

    public boolean isPageLoaded() {

        return driver.getCurrentUrl()
                .contains("track-order");
    }
}