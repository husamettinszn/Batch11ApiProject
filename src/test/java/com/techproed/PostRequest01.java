package com.techproed;

import TestData.DummyTestData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testbase.TestBaseDummy;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostRequest01 extends TestBaseDummy {
    /*
	 	 When
	 	  	I send a POST Request to the Url http://dummy.restapiexample.com/api/v1/create
	 	  	by using the following Request Body {
												    "name":"Ahmet Aksoy",
												    "salary":"1000",
												    "age":"18",
												    "profile_image": ""
												}
	 	 Then
	 	  	Status code is 200
	 	  	And response body should be like {
											    "status": "success",
											    "data": {
											        "name": "Ahmet Aksoy",
											        "salary": "1000",
											        "age": "18",
											        "profile_image": null
											    },
											    "message": "Successfully! Record has been added."
											 }
	*/
    @Test
    public void post01(){
        spec03.pathParam("createPath", "create");

        DummyTestData expectedObj = new DummyTestData();
        Map<String, String> reqBodyMap = expectedObj.setUpData3();
        System.out.println(reqBodyMap);

        Response response = given().
                contentType(ContentType.JSON).
                spec(spec03).
                auth().
                basic("admin", "password123").
                body(reqBodyMap).
                when().post("/{createPath}");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(reqBodyMap.get("name"), jsonPath.getString("data.name"));
        Assert.assertEquals(reqBodyMap.get("salary"), jsonPath.getString("data.salary"));
        Assert.assertEquals(reqBodyMap.get("age"), jsonPath.getString("data.age"));

        if (reqBodyMap.get("profile_image").equals("")){
            reqBodyMap.put("profile_image", null);
        }
        Assert.assertEquals(reqBodyMap.get("profile_image"), jsonPath.get("data.profile_image"));


    }
}
