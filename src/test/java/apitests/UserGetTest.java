package apitests;

import base.APIBaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UserGetTest
        extends APIBaseTest {

    @Test
    public void verifyUsersAPI() {



        endpoint =

                "https://jsonplaceholder.typicode.com/users";



        method =
                "GET";



        Response response =

                given()

                .when()

                .get("/users");



        statusCode =

                response.getStatusCode();



        responseBody =

                response.asPrettyString();



        Assert.assertEquals(

                statusCode,

                200
        );
    }
}