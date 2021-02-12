package com.techproed;



import TestData.JsonPlaceHolderTestData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testbase.TestBaseJsonPlaceHolder;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class PostRequest03 extends TestBaseJsonPlaceHolder {
    /*
     When
          I send POST Request to the Url https://jsonplaceholder.typicode.com/todos
          with the request body {
                                "userId": 55,
                                "title": "Tidy your room",
                                "completed": false
                               }
    Then
        Status code is 200
        And response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                   }
 */


}