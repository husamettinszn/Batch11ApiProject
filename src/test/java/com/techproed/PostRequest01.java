package com.techproed;

import TestData.DummyTestData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import testbase.TestBaseDummy;

import java.util.HashMap;
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

        Map<String, String> expectedMessageMap= expectedObj.setUpMessageData();
        System.out.println(expectedMessageMap);
        Assert.assertEquals(expectedMessageMap.get("message"), jsonPath.getString("message"));

        //2.Yol GSon --> DE-Serialization

        Map<String ,Object> actualDataMap = response.as(HashMap.class);
        System.out.println(actualDataMap);

        Assert.assertEquals(reqBodyMap.get("name"), ((Map)actualDataMap.get("data")).get("name"));
        Assert.assertEquals(reqBodyMap.get("salary"), ((Map)actualDataMap.get("data")).get("salary"));
        Assert.assertEquals(reqBodyMap.get("age"), ((Map)actualDataMap.get("data")).get("age"));

        // if (reqBodyMap.get("profile_image").equals("")){
        //    reqBodyMap.put("profile_image", null);
        // }

        Assert.assertEquals(reqBodyMap.get("profile_image"), ((Map) actualDataMap.get("data")).get("profile_image"));
        Assert.assertEquals(expectedMessageMap.get("message"), actualDataMap.get("message"));
        Assert.assertEquals(expectedMessageMap.get("status"), actualDataMap.get("status"));

        //3. Yol JSon Object

        SoftAssert softAssert = new SoftAssert();

        JSONObject expectedDataJsonObject = expectedObj.setUpPostReqBodyByUsingJSONObject();
        System.out.println(expectedDataJsonObject);

        softAssert.assertEquals(jsonPath.getString("data.name"), expectedDataJsonObject.getString("name"));
        softAssert.assertEquals(jsonPath.getString("data.salary"), expectedDataJsonObject.getString("salary"));
        softAssert.assertEquals(jsonPath.getString("data.age"), expectedDataJsonObject.getString("age"));

        JSONObject msgJSONObject = expectedObj.setUpMessageDataByUsingJSONObject();

        JSONObject msjJSONObject = expectedObj.setUpMessageDataByUsingJSONObject();
        System.out.println(msjJSONObject);
        softAssert.assertEquals(jsonPath.getString("message"),msjJSONObject.getString("message"));
        softAssert.assertEquals(jsonPath.getString("status"),msjJSONObject.getString("status"));
        softAssert.assertAll();
    }
}
