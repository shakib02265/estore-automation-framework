package base;

import java.lang.reflect.Method;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.time.Duration;

import java.awt.GraphicsEnvironment;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.ITestResult;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

import io.qameta.allure.Allure;

import utils.PdfUtil;
import utils.ReportUtil;

import utils.ScreenshotUtil;

import utils.CsvUtil;
import utils.VideoUtil;

public class BaseTest {

    public WebDriver driver;

    private long startTime;



    @BeforeMethod
    public void setup(

            Method method

    ) throws Exception {



        // execution start


        startTime =

                System.currentTimeMillis();



        // chromedriver


        WebDriverManager

                .chromedriver()

                .setup();



        ChromeOptions options =

                new ChromeOptions();




        // GitHub Actions safe


        options.addArguments(

                "--headless=new",

                "--no-sandbox",

                "--disable-dev-shm-usage",

                "--disable-gpu",

                "--window-size=1920,1080",

                "--remote-allow-origins=*"
        );




        driver =

                new ChromeDriver(

                        options
                );




        // slower stable loading


        driver.manage()

                .timeouts()

                .pageLoadTimeout(

                        Duration.ofSeconds(30)
                );



        driver.manage()

                .timeouts()

                .implicitlyWait(

                        Duration.ofSeconds(10)
                );



        driver.manage()

                .window()

                .maximize();




        // video only local


        if(

                !GraphicsEnvironment

                        .isHeadless()

        ){

            VideoUtil.startRecord(

                    method.getName()
            );
        }
    }




    // visual pause


    protected void waitForPage()

            throws Exception {


        Thread.sleep(

                2000
        );
    }




    @AfterMethod(alwaysRun = true)
    public void tearDown(

            ITestResult result

    ) throws Exception {




        String testName =

                result.getName();




        String status =

                result.isSuccess()

                        ?

                        "PASSED"

                        :

                        "FAILED";




        long executionTime =

                System.currentTimeMillis()

                        -

                        startTime;




        String currentUrl =

                driver.getCurrentUrl();




        // small pause


        Thread.sleep(

                1000
        );




        // screenshot


        if(

                driver != null
        ){

            ScreenshotUtil.capture(

                    driver,

                    testName
            );
        }




        // CSV


        CsvUtil.create(

                "UI",

                testName,

                currentUrl,

                status,

                executionTime
        );




        // PDF


        PdfUtil.create(

                "UI",

                testName,

                currentUrl,

                status,

                executionTime
        );




        // overall report


        ReportUtil.create(

                "UI",

                testName,

                currentUrl,

                result.isSuccess(),

                executionTime
        );




        // video only local


        if(

                !GraphicsEnvironment

                        .isHeadless()

        ){

            VideoUtil.stopRecord();
        }




        // allure


        Allure.step(

                "Executed : "

                        + testName
        );




        // screenshot


        try {


            Allure.addAttachment(

                    "Screenshot",

                    Files.newInputStream(

                            Paths.get(

                                    "screenshots/"
                                            + testName
                                            + ".png"
                            )
                    )
            );


        } catch(Exception e){}




        // video


        try {


            if(

                    !GraphicsEnvironment

                            .isHeadless()

            ){

                Allure.addAttachment(

                        "Video",

                        Files.newInputStream(

                                Paths.get(

                                        "videos/"
                                                + testName
                                                + ".avi"
                                )
                        )
                );
            }


        } catch(Exception e){}




        // pdf


        try {


            Allure.addAttachment(

                    "PDF",

                    Files.newInputStream(

                            Paths.get(

                                    "pdf/"
                                            + testName
                                            + ".pdf"
                            )
                    )
            );


        } catch(Exception e){}




        // close browser


        if(

                driver != null
        ){

            driver.quit();
        }
    }
}