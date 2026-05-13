package pages;

import org.openqa.selenium.WebDriver;

public class MobileAccessoriesPage {

    private WebDriver driver;

    public MobileAccessoriesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {

        driver.get(
                "https://estore.link3.net/category/mobile-accessories");
    }

    public boolean isPageLoaded() {

        return driver.getCurrentUrl()
                .contains("mobile-accessories");
    }
}