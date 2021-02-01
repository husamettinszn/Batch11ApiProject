package com.techproed;

import io.restassured.response.Response;
import org.hamcrest.Matchers.*;
import org.junit.Test;
import testbase.TestBaseJsonPlaceHolder;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetRequest06 extends TestBaseJsonPlaceHolder {
    /* 1)When I send a GET request to REST API URL
    https://jsonplaceholder.typicode.com/todos/123
    Then HTTP Status Code should be 200
    And "Server" in Headers should be "cloudflare"
    And response content type is “application/JSON”
    And "userId" should be 7,
    And "title" should be "esse et quis iste est earum aut impedit"
    And "completed" should be false
     */
    @Test

    public void test01(){
        spec01.pathParams("name", "todos", "id", 123);


        Response response = given().
                spec(spec01).
                when().
                get("/{name}/{id}");

        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                header("Server","cloudflare");

        response.
                then().
                assertThat().
                contentType("application/json").
                body("userId", equalTo(7)).
                body("title",equalTo("esse et quis iste est earum aut impedit")).
                body("id",equalTo(123)).
                body("completed", equalTo(false));

    }
}
