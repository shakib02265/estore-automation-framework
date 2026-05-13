package pages;

import org.openqa.selenium.WebDriver;

public class WarrantyPolicyPage {

    private WebDriver driver;

    public WarrantyPolicyPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {

        driver.get(
                "https://estore.link3.net/page/warranty-policy");
    }

    public boolean isPageLoaded() {

        return driver.getCurrentUrl()
                .contains("warranty-policy");
    }
}