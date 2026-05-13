package apitests;

import base.APIBaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UserPostTest
        extends APIBaseTest {

    @Test
    public void createUser() {



        endpoint =

                "https://jsonplaceholder.typicode.com/posts";



        method =
                "POST";



        requestBody =

                "{"

                + "\"name\":\"Link3\","

                + "\"job\":\"QA\""

                + "}";



        Response response =

                given()

                .header(

                        "Content-Type",

                        "application/json"
                )

                .body(
                        requestBody
                )

                .when()

                .post("/posts");



        statusCode =

                response.getStatusCode();



        responseBody =

                response.asPrettyString();



        Assert.assertEquals(

                statusCode,

                201
        );
    }
}