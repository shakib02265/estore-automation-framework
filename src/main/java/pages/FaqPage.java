package pages;

import org.openqa.selenium.WebDriver;

public class FaqPage {

    private WebDriver driver;

    public FaqPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {

        driver.get(
                "https://estore.link3.net/page/faq");
    }

    public boolean isPageLoaded() {

        return driver.getCurrentUrl()
                .contains("faq");
    }
}