package com.techproed;

import io.restassured.response.Response;
import org.junit.Test;
import testbase.TestBaseJsonPlaceHolder;

import static io.restassured.RestAssured.given;

public class GetRequest06Tekrar extends TestBaseJsonPlaceHolder {
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
    public void get01(){
        spec01.pathParams("name", "todos",
                "id" , 123);

        Response response = given().
                spec(spec01).
                when().
                get("/{name}/{id}");
    }
}
