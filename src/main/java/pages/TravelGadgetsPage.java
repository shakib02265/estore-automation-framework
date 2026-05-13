package pages;

import org.openqa.selenium.WebDriver;

public class TravelGadgetsPage {

    private WebDriver driver;

    public TravelGadgetsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {

        driver.get(
                "https://estore.link3.net/category/travel-gadgets?brandIds=1&brandIds=2&brandIds=3&brandIds=4");
    }

    public boolean isPageLoaded() {

        return driver.getCurrentUrl()
                .contains("travel-gadgets");
    }
}