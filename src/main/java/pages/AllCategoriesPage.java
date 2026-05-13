package pages;

import org.openqa.selenium.WebDriver;

public class AllCategoriesPage {

    private WebDriver driver;

    public AllCategoriesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {

        driver.get(
                "https://estore.link3.net/all-categories");
    }

    public boolean isPageLoaded() {

        return driver.getCurrentUrl()
                .contains("all-categories");
    }
}