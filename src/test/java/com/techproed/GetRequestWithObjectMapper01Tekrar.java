package com.techproed;

import TestData.JsonPlaceHolderTestData;
import Utilities.JSonUtil;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testbase.TestBaseJsonPlaceHolder;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequestWithObjectMapper01Tekrar extends TestBaseJsonPlaceHolder {
    @Test
    public void get01() {

        String expectedJson = "{\"userId\": 10,\n" +
                "\"id\": 198,\n" +
                "\"title\": \"quis eius est sint explicabo\",\n" +
                "\"completed\": true\n}";

        spec01.pathParams("todosPath", "todos",
                "id", 198);

        Map<String, Object> expectedMap = JSonUtil.convertJsonToJava(expectedJson);
        System.out.println(expectedMap);

        Response response = given().
                spec(spec01).
                when().
                get("/{todosPath}/{id}");

        response.prettyPrint();

        Map<String, Object> actualDataMap = JSonUtil.convertJsonToJava(response.asString());
        System.out.println(actualDataMap);

        Assert.assertEquals(expectedMap.get("userId"), actualDataMap.get("userId"));
        Assert.assertEquals(expectedMap.get("completed"), actualDataMap.get("completed"));
        Assert.assertEquals(expectedMap.get("title"), actualDataMap.get("title"));
        Assert.assertEquals(expectedMap.get("id"), actualDataMap.get("id"));

    }

}
