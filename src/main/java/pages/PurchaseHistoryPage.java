package pages;

import org.openqa.selenium.WebDriver;

public class PurchaseHistoryPage {

    private WebDriver driver;

    public PurchaseHistoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {

        driver.get(
                "https://estore.link3.net/user/login?redirect=/user/purchase-history");
    }

    public boolean isPageLoaded() {

        return driver.getCurrentUrl()
                .contains("purchase-history");
    }
}