package pages;

import org.openqa.selenium.WebDriver;

public class InternetNetworkingPage {

    private WebDriver driver;

    public InternetNetworkingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {

        driver.get(
                "https://estore.link3.net/category/internet-networking");
    }

    public boolean isPageLoaded() {

        return driver.getCurrentUrl()
                .contains("internet-networking");
    }
}