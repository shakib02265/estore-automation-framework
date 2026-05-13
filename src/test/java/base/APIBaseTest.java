package base;

import org.testng.ITestResult;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.qameta.allure.Allure;

import io.restassured.RestAssured;

import utils.CsvUtil;
import utils.PdfUtil;
import utils.ReportUtil;

public class APIBaseTest {

    protected long startTime;

    protected String endpoint;

    protected String method;

    protected String requestBody = "";

    protected String responseBody = "";

    protected int statusCode;



    @BeforeClass
    public void setupAPI() {



        RestAssured.baseURI =

                "https://jsonplaceholder.typicode.com";
    }




    @BeforeMethod
    public void startTimer() {



        startTime =

                System.currentTimeMillis();
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




        // CSV


        CsvUtil.create(

                "API",

                testName,

                endpoint,

                status,

                executionTime
        );




        // PDF


        PdfUtil.create(

                "API",

                testName,

                endpoint,

                status,

                executionTime
        );




        // overall html report


        ReportUtil.create(

                "API",

                testName,

                endpoint,

                result.isSuccess(),

                executionTime
        );




        // allure


        Allure.addAttachment(

                "API Endpoint",

                endpoint
        );



        Allure.addAttachment(

                "Method",

                method
        );



        Allure.addAttachment(

                "Status Code",

                String.valueOf(
                        statusCode
                )
        );



        Allure.addAttachment(

                "Execution Time",

                executionTime
                        + " ms"
        );



        if(!requestBody.isEmpty()){

            Allure.addAttachment(

                    "Request Body",

                    requestBody
            );
        }



        if(!responseBody.isEmpty()){

            Allure.addAttachment(

                    "Response Body",

                    responseBody
            );
        }
    }
}