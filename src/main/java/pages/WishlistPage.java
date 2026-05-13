package pages;

import org.openqa.selenium.WebDriver;

public class WishlistPage {

    private WebDriver driver;

    public WishlistPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {

        driver.get(
                "https://estore.link3.net/user/login?redirect=/user/wishlist");
    }

    public boolean isPageLoaded() {

        return driver.getCurrentUrl()
                .contains("wishlist");
    }
}