package utils;

import java.io.File;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static void capture(
            WebDriver driver,
            String testName)

            throws Exception {

        File source =

                ((TakesScreenshot) driver)

                        .getScreenshotAs(
                                OutputType.FILE);

        File destination =

                new File(

                        "screenshots/"
                                + testName
                                + ".png"
                );

        destination.getParentFile()
                .mkdirs();

        FileUtils.copyFile(
                source,
                destination);
    }
}