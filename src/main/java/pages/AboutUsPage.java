package pages;

import org.openqa.selenium.WebDriver;

public class AboutUsPage {

    private WebDriver driver;

    public AboutUsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {

        driver.get(
                "https://estore.link3.net/page/about-us");
    }

    public boolean isPageLoaded() {

        return driver.getCurrentUrl()
                .contains("about-us");
    }
}