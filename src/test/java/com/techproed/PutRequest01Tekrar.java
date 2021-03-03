package com.techproed;

import TestData.JsonPlaceHolderTestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testbase.TestBaseJsonPlaceHolder;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PutRequest01Tekrar extends TestBaseJsonPlaceHolder {
    @Test
    public void put01(){
        spec01.pathParams("todosPath", "todos",
                "id", 198);
        JsonPlaceHolderTestData expectedObj = new JsonPlaceHolderTestData();

        JSONObject expectedDataJSon = expectedObj.setUpPutRequestByJSONObject();

        Response response = given().
                contentType(ContentType.JSON).
                spec(spec01).
                body(expectedDataJSon.toString()).
                when().
                put("/{todosPath}/{id}");
        response.prettyPrint();

        //Body
        response.
                then().
                assertThat().
                contentType(ContentType.JSON).
                statusCode(200).
                body("completed", equalTo(expectedDataJSon.getBoolean("completed")),
                        "title", equalTo(expectedDataJSon.getString("title")),
                        "userId", equalTo(expectedDataJSon.getInt("userId")));

        Map<String, Object> actualDataGSON = response.as(HashMap.class);
        System.out.println(actualDataGSON);

        Assert.assertEquals(expectedDataJSon.getBoolean("completed"), actualDataGSON.get("completed"));
        Assert.assertEquals(expectedDataJSon.getString("title"), actualDataGSON.get("title"));
        Assert.assertEquals(expectedDataJSon.getInt("userId"), actualDataGSON.get("userId"));

    }
}