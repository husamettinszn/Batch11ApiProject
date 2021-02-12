package com.techproed;

import TestData.JsonPlaceHolderTestData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testbase.TestBaseJsonPlaceHolder;

import java.util.Map;

import static io.restassured.RestAssured.*;

public class PatchRequest01 extends TestBaseJsonPlaceHolder {
    /*
   When
         I send PATCH Request to the Url https://jsonplaceholder.typicode.com/todos/198
         with the PUT Request body like {
                                        "title": "I love API"
                                       }
   Then
          Status code is 200
          And response body is like  {
                                    "userId": 10,
                                    "title": "I love API",
                                    "completed": true,
                                    "id": 198
                                  }
*/


}