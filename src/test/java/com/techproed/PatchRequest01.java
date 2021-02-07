package com.techproed;

import TestData.JsonPlaceHolderTestData;
import io.restassured.response.Response;
import org.junit.Test;
import testbase.TestBaseJsonPlaceHolder;

import static io.restassured.RestAssured.given;

public class PatchRequest01 extends TestBaseJsonPlaceHolder {
    /*
	   When
	 		I send PATCH Request to the Url https://jsonplaceholder.typicode.com/todos/198
	 		with the PUT Request body like {
										    "title": "Tidy your room",
										   }
	   Then
	   	   Status code is 200
	   	   And response body is like  {
									    "userId": 10,
									    "title": "Tidy your room",
									    "completed": true,
									    "id": 198
									  }
   */
    @Test
    public void patch01(){
    spec01.pathParams("todosPath", "todos",
            "id",198);

        Response response = given().when().get("/{todos}/{id}");
    }

}
