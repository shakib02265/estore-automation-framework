package pages;

import org.openqa.selenium.WebDriver;

public class LifestyleGadgetsPage {

    private WebDriver driver;

    public LifestyleGadgetsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {

        driver.get(
                "https://estore.link3.net/category/lifestyle-gadgets");
    }

    public boolean isPageLoaded() {

        return driver.getCurrentUrl()
                .contains("lifestyle-gadgets");
    }
}