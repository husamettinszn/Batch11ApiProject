package com.techproed;

import TestData.JsonPlaceHolderTestData;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import testbase.TestBaseJsonPlaceHolder;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostRequest03Tekrar extends TestBaseJsonPlaceHolder {

    @Test
    public void post03(){
        spec01.pathParam("todosPath", "todos");

        JsonPlaceHolderTestData expectedObj = new JsonPlaceHolderTestData();

        JSONObject expectedDataJson = expectedObj.setUpPostRequestByJSONObject();
        System.out.println(expectedDataJson);

        Response response = given().
                contentType(ContentType.JSON).
                spec(spec01).
                auth().
                basic("admin", "password123").
                body(expectedDataJson.toString()).
                when().
                post("/{todosPath}");
        response.prettyPrint();

        //Body   Matcher body + JsonObject
        response.
                then().
                assertThat().
                contentType(ContentType.JSON).
                statusCode(201).
                body("completed", equalTo(expectedDataJson.getBoolean("completed")),
                        "title", equalTo(expectedDataJson.getString("title")),
                        "userId", equalTo(expectedDataJson.getInt("userId")));

        //HardAssert    JsonObject +   JSonPath

        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(expectedDataJson.getBoolean("completed"), jsonPath.getBoolean("completed") );
        Assert.assertEquals(expectedDataJson.getInt("userId"), jsonPath.getInt("userId"));
        Assert.assertEquals(expectedDataJson.getString("title"), jsonPath.getString("title"));

        //SoftAssert JSONObject + GSon De-Serialization

        Map<String, Object> actualGSON = response.as(HashMap.class);
        System.out.println(actualGSON);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualGSON.get("completed"), expectedDataJson.getBoolean("completed"));
        softAssert.assertEquals(actualGSON.get("title"), expectedDataJson.getString("title"));
        softAssert.assertEquals(actualGSON.get("userId"), expectedDataJson.getInt("userId"));


        softAssert.assertAll();



    }
}

